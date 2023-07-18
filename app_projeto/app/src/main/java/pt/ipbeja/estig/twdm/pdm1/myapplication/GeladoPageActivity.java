package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GeladoPageActivity extends AppCompatActivity  implements GeladoAdapter.GeladoAdapterEventListener{
    private GeladoAdapter gelAdapter;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelado);

        RecyclerView recyclerViewGelado = findViewById(R.id.recyclerViewGeladoItem);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        this.gelAdapter = new GeladoAdapter(this);
        recyclerViewGelado.setAdapter(this.gelAdapter);
        recyclerViewGelado.setLayoutManager(layoutManager);

        List<Gelado> newGeladoList = AppDatabase.getInstance(this).getGeladoDao().getAll();
        this.gelAdapter.refreshList(newGeladoList);
    }

    @Override
    protected void onStart(){
        super.onStart();
        List<Gelado> newGeladoList = AppDatabase.getInstance(this).getGeladoDao().getAll();
        this.gelAdapter.refreshList(newGeladoList);
    }

    @Override
    public void onGeladoClicked(long gelID){
        GeladoItemActivity.startActivity(this, gelID);
    }
}
