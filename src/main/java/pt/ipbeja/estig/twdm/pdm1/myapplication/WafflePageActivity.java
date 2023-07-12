package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WafflePageActivity extends AppCompatActivity  implements WaffleAdapter.WaffleAdapterEventListener{
    private WaffleAdapter waffleAdapter;
    ImageView imageViewGoHome;
    ImageView imageViewCart;

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

        imageViewGoHome = (ImageView) findViewById(R.id.imageViewGoBack2);
        imageViewGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WafflePageActivity.this, MainPage.class);
                startActivity(intent);
            }
        });

        /*imageViewCart = (ImageView) findViewById(R.id.imageViewCart2);
        imageViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(WafflePageActivity.this, CartActivity.class);
                startActivity(int2);
            }
        });*/
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