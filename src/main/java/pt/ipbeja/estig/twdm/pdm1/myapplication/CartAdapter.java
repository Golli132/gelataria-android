package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
    private List<CartItem> cartItems;
    private CartAdapterEventListener cartEventListener;

    public CartAdapter(CartAdapterEventListener CartEventListener){
        this.cartItems = new ArrayList<>();
        this.cartEventListener = cartEventListener;
    }

    @NonNull
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items, parent, false);
        return new CartAdapter.CartViewHolder(rootView);
    }


    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position){
        final CartItem cartItems = this.cartItems.get(position);
        holder.textViewCartName.setText(cartItems.getItemName());
        holder.textViewCartTop.setText(cartItems.getItemTopping());
    }

    public int getItemCount(){
        return this.cartItems.size();
    }

    public void refreshList(List<CartItem> newCartItemList){
        this.cartItems = newCartItemList;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        private View rootView;
        private TextView textViewCartName;
        private TextView textViewCartTop;

        public CartViewHolder(@NonNull View rootView){
            super(rootView);
            this.rootView = rootView;
            this.textViewCartName = rootView.findViewById(R.id.textViewItemName);
            this.textViewCartTop = rootView.findViewById(R.id.textViewItemPrice);
        }
    }

    public interface CartAdapterEventListener{
        void onCartClicked(long crepeId);
    }
}
