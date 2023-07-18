package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WafflePageActivity extends AppCompatActivity  implements WaffleAdapter.WaffleAdapterEventListener{
    private WaffleAdapter waffleAdapter;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waffle);

        RecyclerView recyclerViewGelado = findViewById(R.id.recyclerViewWaffleItem);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        this.waffleAdapter = new WaffleAdapter(this);
        recyclerViewGelado.setAdapter(this.waffleAdapter);
        recyclerViewGelado.setLayoutManager(layoutManager);

        List<Waffle> newWaffleList = AppDatabase.getInstance(this).getWaffleDao().getAll();
        this.waffleAdapter.refreshList(newWaffleList);
    }

    @Override
    protected void onStart(){
        super.onStart();
        List<Waffle> newWaffleList = AppDatabase.getInstance(this).getWaffleDao().getAll();
        this.waffleAdapter.refreshList(newWaffleList);
    }

    @Override
    public void onWaffleClicked(long gelID){
        WaffleItemActivity.startActivity(this, gelID);
    }
}