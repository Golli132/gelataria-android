package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WaffleItemsAdapter extends RecyclerView.Adapter<WaffleItemsAdapter.WaffleViewHolder> {
    private List<WaffleItems> waffleItems;

    public WaffleItemsAdapter(List<WaffleItems> waffleItems){
        this.waffleItems = waffleItems;
    }

    @NonNull
    public WaffleViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int ViewType){
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_itens, parent, false);
        return new WaffleViewHolder(rootView);
    }

    public void onBindViewHolder(@NonNull WaffleViewHolder holder, int position){
        WaffleItems items = this.waffleItems.get(position);
        holder.textView2.setText(items.getName());
        holder.textView5.setText(items.getName());
        holder.textView4.setText(items.getPrice());

    }

    public int getItemCount(){
        return this.waffleItems.size();
    }

    public class WaffleViewHolder extends RecyclerView.ViewHolder{
        private TextView textView2;
        private TextView textView4;
        private TextView textView5;
        private TextView textView7;

        public WaffleViewHolder(@NonNull View rootView){
            super(rootView);
            this.textView2 = rootView.findViewById(R.id.textView2);
            this.textView4 = rootView.findViewById(R.id.textView4);
            this.textView5 = rootView.findViewById(R.id.textView5);
            this.textView7 = rootView.findViewById(R.id.textView7);
        }
    }
}
