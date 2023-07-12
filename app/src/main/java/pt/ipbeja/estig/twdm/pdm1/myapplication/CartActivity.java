/*package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartActivity extends AppCompatActivity implements CartAdapter.CartAdapterEventListener{
    private CartAdapter cartAdapter;
    ImageView imageViewGoHome;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView recyclerViewCart = findViewById(R.id.recyclerViewCartItem);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        this.cartAdapter = new CartAdapter(this);
        recyclerViewCart.setAdapter(this.cartAdapter);
        recyclerViewCart.setLayoutManager(layoutManager);

        List<CartItem> newCartItemList = AppDatabase.getInstance(this).getCartDao().getAll();
        this.cartAdapter.refreshList(newCartItemList);

        imageViewGoHome = (ImageView) findViewById(R.id.imageViewGoBack6);
        imageViewGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, MainPage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        List<CartItem> newCartItemList = AppDatabase.getInstance(this).getCartDao().getAll();
        this.cartAdapter.refreshList(newCartItemList);
    }
}*/
