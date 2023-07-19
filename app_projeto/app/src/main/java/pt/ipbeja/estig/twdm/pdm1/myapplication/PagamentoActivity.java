package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PagamentoActivity extends AppCompatActivity {
    ImageView imageViewMB;
    ImageView imageViewDinheiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metodo_pagamento);

        imageViewMB = (ImageView) findViewById(R.id.imageViewMBWay);
        imageViewMB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Click", "Gelado");
                Intent intent = new Intent(PagamentoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        imageViewDinheiro = (ImageView) findViewById(R.id.imageViewDinheiro);
        imageViewDinheiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Click", "Crepe");
                Intent int2 = new Intent(PagamentoActivity.this, MainActivity.class);
                startActivity(int2);
            }
        });
    }
}
