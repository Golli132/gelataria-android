package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GeladoItemsAdapter {
    private List<GeladoItems> geladoItems;

    public GeladoItemsAdapter(List<GeladoItems> geladoItems){
        this.geladoItems = geladoItems;
    }

    @NonNull
    public GeladoViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int ViewType){
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gelado_itens, parent, false);
        return new GeladoViewHolder(rootView);
    }

    public void onBindViewHolder(@NonNull GeladoViewHolder holder, int position){
        GeladoItems gelItems = this.geladoItems.get(position);
        holder.textView8.setText(gelItems.getGelName());
    }

    public int getGelItemCount(){
        return this.geladoItems.size();
    }

    public class GeladoViewHolder extends RecyclerView.ViewHolder{
        private TextView textView8;
        public GeladoViewHolder(@NonNull View rootView){
            super(rootView);
            this.textView8 = rootView.findViewById(R.id.textView8);
        }
    }
}
