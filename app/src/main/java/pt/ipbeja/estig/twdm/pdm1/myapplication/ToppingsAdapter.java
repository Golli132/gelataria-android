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

public class ToppingsAdapter extends RecyclerView.Adapter<ToppingsAdapter.ToppingsViewHolder> {
    private List<Toppings> toppingItems;
    private ToppingsAdapter.ToppingsAdapterEventListener toppingsEventListener;

    public ToppingsAdapter(ToppingsAdapter.ToppingsAdapterEventListener toppingsEventListener){
        this.toppingItems = new ArrayList<>();
        this.toppingsEventListener = toppingsEventListener;
    }

    @NonNull
    public ToppingsAdapter.ToppingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gelado_items, parent, false);
        return new ToppingsAdapter.ToppingsViewHolder(rootView);
    }


    public void onBindViewHolder(@NonNull ToppingsAdapter.ToppingsViewHolder holder, int position){
        final Toppings toppingItems = this.toppingItems.get(position);
        holder.textViewTopName.setText(toppingItems.getTopName());
        holder.textViewTopPrice.setText(toppingItems.getTopPrice());
        Glide.with(holder.rootView.getContext()).load(toppingItems.getTopImg()).into(holder.imageViewTopItem);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toppingsEventListener != null) toppingsEventListener.onToppingsClicked(toppingItems.getTopId());
            }
        });
    }

    public int getItemCount(){
        return this.toppingItems.size();
    }

    public void refreshList(List<Toppings> newToppingsList){
        this.toppingItems = newToppingsList;
    }

    public class ToppingsViewHolder extends RecyclerView.ViewHolder{
        private View rootView;
        private TextView textViewTopName;
        private TextView textViewTopPrice;
        private ImageView imageViewTopItem;

        public ToppingsViewHolder(@NonNull View rootView){
            super(rootView);
            this.rootView = rootView;
            this.textViewTopName = rootView.findViewById(R.id.textViewItemName);
            this.textViewTopPrice = rootView.findViewById(R.id.textViewItemPrice);
            this.imageViewTopItem = rootView.findViewById(R.id.imageViewItem);
        }
    }

    public interface ToppingsAdapterEventListener{
        void onToppingsClicked(long topId);
    }
}