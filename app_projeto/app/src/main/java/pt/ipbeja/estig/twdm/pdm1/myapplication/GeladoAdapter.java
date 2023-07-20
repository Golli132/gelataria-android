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

public class GeladoAdapter extends RecyclerView.Adapter<GeladoAdapter.GeladoViewHolder> {
    private List<Gelado> geladoItems;
    private GeladoAdapterEventListener geladoEventListener;

    public GeladoAdapter(GeladoAdapterEventListener geladoEventListener){
        this.geladoItems = new ArrayList<>();
        this.geladoEventListener = geladoEventListener;
    }

    @NonNull
    public GeladoViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int ViewType){
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_items, parent, false);
        return new GeladoViewHolder(rootView);
    }

    public void onBindViewHolder(@NonNull GeladoViewHolder holder, int position){
        final Gelado gelItems = this.geladoItems.get(position);
        holder.textViewIceName.setText(gelItems.getGelName());
        holder.textViewIcePrice.setText(String.valueOf(gelItems.getGelPrice()) + " €");
        Glide.with(holder.rootView.getContext()).load(gelItems.getGelImg()).into(holder.imageViewIceItem);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(geladoEventListener != null) geladoEventListener.onGeladoClicked(gelItems.getGelId());
            }
        });
    }

    public int getItemCount(){
        return this.geladoItems.size();
    }

    public void refreshList(List<Gelado> newGeladoList){
        this.geladoItems = newGeladoList;
    }

    public class GeladoViewHolder extends RecyclerView.ViewHolder{
        private View rootView;
        private TextView textViewIceName;
        private TextView textViewIcePrice;
        private ImageView imageViewIceItem;

        public GeladoViewHolder(@NonNull View rootView){
            super(rootView);
            this.rootView = rootView;
            this.textViewIceName = rootView.findViewById(R.id.textViewItemName);
            this.textViewIcePrice = rootView.findViewById(R.id.textViewItemPrice);
            this.imageViewIceItem = rootView.findViewById(R.id.imageViewItem);
        }
    }

    public interface GeladoAdapterEventListener{
        void onGeladoClicked(long gelId);
    }
}