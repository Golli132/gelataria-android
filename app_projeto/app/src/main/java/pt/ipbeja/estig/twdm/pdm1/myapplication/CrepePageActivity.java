package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CrepePageActivity extends AppCompatActivity  implements CrepeAdapter.CrepeAdapterEventListener{
    private CrepeAdapter crepeAdapter;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crepe);

        RecyclerView recyclerViewCrepe = findViewById(R.id.recyclerViewCrepeItem);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        this.crepeAdapter = new CrepeAdapter(this);
        recyclerViewCrepe.setAdapter(this.crepeAdapter);
        recyclerViewCrepe.setLayoutManager(layoutManager);

        List<Crepe> newCrepeList = AppDatabase.getInstance(this).getCrepeDao().getAll();
        this.crepeAdapter.refreshList(newCrepeList);
    }

    @Override
    protected void onStart(){
        super.onStart();
        List<Crepe> newCrepeList = AppDatabase.getInstance(this).getCrepeDao().getAll();
        this.crepeAdapter.refreshList(newCrepeList);
    }

    @Override
    public void onCrepeClicked(long crepeID){
        CrepeItemActivity.startActivity(this, crepeID);
    }
}
