package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainPage extends AppCompatActivity {
    ImageView imageViewGelado;
    ImageView imageViewCrepe;
    ImageView imageViewWaffle;
    ImageView imageViewCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        imageViewGelado = (ImageView) findViewById(R.id.sendToGelado);
        imageViewGelado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Click", "Gelado");
                Intent intent = new Intent(MainPage.this, GeladoPageActivity.class);
                startActivity(intent);
            }
        });

        imageViewCrepe = (ImageView) findViewById(R.id.sendToCrepe);
        imageViewCrepe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Click", "Crepe");
                Intent int2 = new Intent(MainPage.this, CrepePageActivity.class);
                startActivity(int2);
            }
        });

        imageViewWaffle = (ImageView) findViewById(R.id.sendToWaffle);
        imageViewWaffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Click", "Waffle");
                Intent int3 = new Intent(MainPage.this, WafflePageActivity.class);
                startActivity(int3);
            }
        });

        /*imageViewCart = (ImageView) findViewById(R.id.imageViewCart5);
        imageViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(MainPage.this, CartActivity.class);
                startActivity(int2);
            }
        });*/
    }
}