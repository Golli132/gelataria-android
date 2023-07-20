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

public class CrepeAdapter extends RecyclerView.Adapter<CrepeAdapter.CrepeViewHolder> {
    private List<Crepe> crepeItems;
    private CrepeAdapterEventListener crepeEventListener;

    public CrepeAdapter(CrepeAdapterEventListener crepeEventListener){
        this.crepeItems = new ArrayList<>();
        this.crepeEventListener = crepeEventListener;
    }

    @NonNull
    public CrepeViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int ViewType){
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_items, parent, false);
        return new CrepeViewHolder(rootView);
    }

    public void onBindViewHolder(@NonNull CrepeViewHolder holder, int position){
        final Crepe crepeItems = this.crepeItems.get(position);
        holder.textViewCrepeName.setText(crepeItems.getCrepeName());
        holder.textViewCrepePrice.setText(String.valueOf(crepeItems.getCrepePrice()) + " €");
        Glide.with(holder.rootView.getContext()).load(crepeItems.getCrepeImg()).into(holder.imageViewCrepeItem);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(crepeEventListener != null) crepeEventListener.onCrepeClicked(crepeItems.getCrepeId());
            }
        });
    }

    public int getItemCount(){
        return this.crepeItems.size();
    }

    public void refreshList(List<Crepe> newCrepeList){
        this.crepeItems = newCrepeList;
    }

    public class CrepeViewHolder extends RecyclerView.ViewHolder{
        private View rootView;
        private TextView textViewCrepeName;
        private TextView textViewCrepePrice;
        private ImageView imageViewCrepeItem;

        public CrepeViewHolder(@NonNull View rootView){
            super(rootView);
            this.rootView = rootView;
            this.textViewCrepeName = rootView.findViewById(R.id.textViewItemName);
            this.textViewCrepePrice = rootView.findViewById(R.id.textViewItemPrice);
            this.imageViewCrepeItem = rootView.findViewById(R.id.imageViewItem);
        }
    }

    public interface CrepeAdapterEventListener{
        void onCrepeClicked(long crepeId);
    }
}