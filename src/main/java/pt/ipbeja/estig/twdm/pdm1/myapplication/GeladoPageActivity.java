package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GeladoPageActivity extends AppCompatActivity  implements GeladoAdapter.GeladoAdapterEventListener{
    private GeladoAdapter gelAdapter;
    ImageView imageViewGoHome;
    ImageView imageViewCart;

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

        imageViewGoHome = (ImageView) findViewById(R.id.imageViewGoBack);
        imageViewGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GeladoPageActivity.this, MainPage.class);
                startActivity(intent);
            }
        });

        /*imageViewCart = (ImageView) findViewById(R.id.imageViewCart);
        imageViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(GeladoPageActivity.this, CartActivity.class);
                startActivity(int2);
            }
        });*/
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
