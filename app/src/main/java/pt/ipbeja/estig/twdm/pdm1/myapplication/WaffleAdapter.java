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

public class WaffleAdapter extends RecyclerView.Adapter<WaffleAdapter.WaffleViewHolder> {
    private List<Waffle> waffleItems;
    private WaffleAdapterEventListener waffleEventListener;

    public WaffleAdapter(WaffleAdapterEventListener waffleEventListener){
        this.waffleItems = new ArrayList<>();
        this.waffleEventListener = waffleEventListener;
    }

    @NonNull
    public WaffleViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int ViewType){
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.waffle_items, parent, false);
        return new WaffleViewHolder(rootView);
    }


    public void onBindViewHolder(@NonNull WaffleViewHolder holder, int position){
        final Waffle waffleItems = this.waffleItems.get(position);
        holder.textViewWaffleName.setText(waffleItems.getWaffleName());
        holder.textViewWafflePrice.setText(waffleItems.getWafflePrice());
        Glide.with(holder.rootView.getContext()).load(waffleItems.getWaffleImg()).into(holder.imageViewWaffleItem);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waffleEventListener != null) waffleEventListener.onWaffleClicked(waffleItems.getWaffleId());
            }
        });
    }

    public int getItemCount(){
        return this.waffleItems.size();
    }

    public void refreshList(List<Waffle> newWaffleList){
        this.waffleItems = newWaffleList;
    }

    public class WaffleViewHolder extends RecyclerView.ViewHolder{
        private View rootView;
        private TextView textViewWaffleName;
        private TextView textViewWafflePrice;
        private ImageView imageViewWaffleItem;

        public WaffleViewHolder(@NonNull View rootView){
            super(rootView);
            this.rootView = rootView;
            this.textViewWaffleName = rootView.findViewById(R.id.textViewWaffleName);
            this.textViewWafflePrice = rootView.findViewById(R.id.textViewWafflePrice);
            this.imageViewWaffleItem = rootView.findViewById(R.id.imageViewWaffleItem);
        }
    }

    public interface WaffleAdapterEventListener{
        void onWaffleClicked(long waffleId);
    }
}
