package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CrepePageActivity extends AppCompatActivity  implements CrepeAdapter.CrepeAdapterEventListener{
    private CrepeAdapter crepeAdapter;
    ImageView imageViewGoHome;
    ImageView imageViewCart;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crepe);

        RecyclerView recyclerViewCrepe = findViewById(R.id.recyclerViewCartItem);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        this.crepeAdapter = new CrepeAdapter(this);
        recyclerViewCrepe.setAdapter(this.crepeAdapter);
        recyclerViewCrepe.setLayoutManager(layoutManager);

        List<Crepe> newCrepeList = AppDatabase.getInstance(this).getCrepeDao().getAll();
        this.crepeAdapter.refreshList(newCrepeList);

        imageViewGoHome = (ImageView) findViewById(R.id.imageViewGoBack3);
        imageViewGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrepePageActivity.this, MainPage.class);
                startActivity(intent);
            }
        });

        /*imageViewCart = (ImageView) findViewById(R.id.imageViewCart3);
        imageViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(CrepePageActivity.this, CartActivity.class);
                startActivity(int2);
            }
        });*/
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
