package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainPage extends AppCompatActivity {
    ImageView gelado;
    ImageView crepe;
    ImageView waffle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        gelado = (ImageView) findViewById(R.id.sendToGelado);
        gelado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Click", "Gelado");
                Intent intent = new Intent(MainPage.this, GeladoPageActivity.class);
                startActivity(intent);
            }
        });

        crepe = (ImageView) findViewById(R.id.sendToCrepe);
        crepe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Click", "Crepe");
                Intent int2 = new Intent(MainPage.this, Crepe.class);
                startActivity(int2);
            }
        });

        waffle = (ImageView) findViewById(R.id.sendToWaffle);
        waffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Click", "Waffle");
                Intent int3 = new Intent(MainPage.this, WafflePageActivity.class);
                startActivity(int3);
            }
        });
    }
}