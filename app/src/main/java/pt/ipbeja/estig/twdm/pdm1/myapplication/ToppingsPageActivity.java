package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class ToppingsPageActivity extends AppCompatActivity implements ToppingsAdapter.ToppingsAdapterEventListener{
        private ToppingsAdapter toppingsAdapter;
        ImageView imageViewGoHome;
        ImageView imageViewCart;

        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_toppings);

            RecyclerView recyclerViewToppings = findViewById(R.id.recyclerViewToppings);

            LinearLayoutManager layoutManager = new LinearLayoutManager(this);

            this.toppingsAdapter = new ToppingsAdapter(this);
            recyclerViewToppings.setAdapter(this.toppingsAdapter);
            recyclerViewToppings.setLayoutManager(layoutManager);

            List<Toppings> newToppingsList = AppDatabase.getInstance(this).getToppingsDao().getAll();
            this.toppingsAdapter.refreshList(newToppingsList);

            imageViewGoHome = (ImageView) findViewById(R.id.imageViewGoBack4);
            imageViewGoHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ToppingsPageActivity.this, MainPage.class);
                    startActivity(intent);
                }
            });

            Button buttonSkip = findViewById(R.id.buttonSkip);
            buttonSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ToppingsPageActivity.this, MainPage.class);
                    startActivity(intent);
                }
            });

            /*imageViewCart = (ImageView) findViewById(R.id.imageViewCart4);
            imageViewCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent int2 = new Intent(ToppingsPageActivity.this, CartActivity.class);
                    startActivity(int2);
                }
            });*/
        }

        @Override
        protected void onStart(){
            super.onStart();
            List<Toppings> newToppingsList = AppDatabase.getInstance(this).getToppingsDao().getAll();
            this.toppingsAdapter.refreshList(newToppingsList);
        }

        @Override
        public void onToppingsClicked(long topId){
                ToppingsItemActivity.startActivity(this, topId);
            }
    }

