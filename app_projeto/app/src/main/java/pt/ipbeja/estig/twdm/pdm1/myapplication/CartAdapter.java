package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<CartItem> cartItems;
    private OnCartItemInteractionListener listener;

    public CartAdapter(List<CartItem> cartItems, OnCartItemInteractionListener listener) {
        this.cartItems = cartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items, parent, false);
        return new CartViewHolder(rootView, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        AppDatabase db = AppDatabase.getInstance(holder.context);
        CartDao cartDao = db.getCartDao();

        final CartItem cartItem = this.cartItems.get(position);
        holder.textViewItemName.setText(cartItem.getItemName());
        holder.textViewItemPrice.setText(String.valueOf(cartItem.getPrice() * cartItem.getAmount()) + " €");
        holder.textViewItemAmount.setText(Integer.toString(cartItem.getAmount()));

        holder.buttonAddAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = cartItem.getAmount();
                amount++;
                cartDao.updateAmount(amount, cartItem.getItemId());

                cartItem.setAmount(amount); // Update the CartItem's amount
                holder.textViewItemAmount.setText(Integer.toString(amount)); // Update the TextView

                if (listener != null) {
                    listener.onAddAmountClicked(cartItem);
                }
            }
        });

        holder.buttonTakeAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = cartItem.getAmount();
                if (amount > 0) {
                    amount--;
                    cartDao.updateAmount(amount, cartItem.getItemId());

                    cartItem.setAmount(amount);
                    holder.textViewItemAmount.setText(Integer.toString(amount));

                    if (amount == 0) {
                        cartDao.delete(cartItem); // Remove the item from the cart
                        if (listener != null) {
                            listener.onDeleteClicked(cartItem);
                        }
                    } else {
                        if (listener != null) {
                            listener.onTakeAmountClicked(cartItem);
                        }
                    }
                }
                refreshList(holder.context);
            }
        });

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartDao.delete(cartItem);

                if (listener != null) {
                    listener.onDeleteClicked(cartItem);
                }
                refreshList(holder.context);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.cartItems.size();
    }

    public void refreshList(Context context) {
        AppDatabase db = AppDatabase.getInstance(context);
        CartDao cartDao = db.getCartDao();

        this.cartItems = cartDao.getAll();
        notifyDataSetChanged();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        private View rootView;
        private TextView textViewItemName;
        private TextView textViewItemPrice;
        private TextView textViewTotalPrice;
        private Button buttonAddAmount;
        private Button buttonTakeAmount;
        private Button buttonDelete;
        private TextView textViewItemAmount;
        private Context context;

        public CartViewHolder(@NonNull View rootView, Context context) {
            super(rootView);
            this.rootView = rootView;
            textViewItemName = itemView.findViewById(R.id.textViewCartName);
            textViewItemPrice = itemView.findViewById(R.id.textViewCartPrice);
            textViewTotalPrice = itemView.findViewById(R.id.textViewShowTotal);
            buttonAddAmount = itemView.findViewById(R.id.buttonAddAmount);
            buttonTakeAmount = itemView.findViewById(R.id.buttonTakeAmount);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
            textViewItemAmount = itemView.findViewById(R.id.textViewItemAmount);
            this.context = context;
        }
    }

    public interface OnCartItemInteractionListener {
        void onAddAmountClicked(CartItem cartItem);
        void onTakeAmountClicked(CartItem cartItem);
        void onDeleteClicked(CartItem cartItem);
    }
}

