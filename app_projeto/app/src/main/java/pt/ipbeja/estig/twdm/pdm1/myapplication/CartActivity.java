package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartActivity extends AppCompatActivity implements CartAdapter.OnCartItemInteractionListener {

    private CartAdapter cartAdapter;
    ImageView imageViewGoHome;
    Button buttonGoToPayment;
    TextView textViewTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView recyclerViewCart = findViewById(R.id.recyclerViewCartItem);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        AppDatabase db = AppDatabase.getInstance(CartActivity.this);
        CartDao cartDao = db.getCartDao();

        List<CartItem> cartItem = cartDao.getAll();

        this.cartAdapter = new CartAdapter(cartItem, this);

        recyclerViewCart.setAdapter(this.cartAdapter);
        recyclerViewCart.setLayoutManager(layoutManager);

        imageViewGoHome = findViewById(R.id.imageViewGoBack6);
        imageViewGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, MainPage.class);
                startActivity(intent);
            }
        });

        buttonGoToPayment = findViewById(R.id.buttonGoToPayment);
        buttonGoToPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, PagamentoActivity.class);
                startActivity(intent);
            }
        });

        textViewTotalPrice = findViewById(R.id.textViewShowTotal);
        updateTotalPrice();
    }

    @Override
    public void onAddAmountClicked(CartItem cartItem) {
        updateTotalPrice();
    }

    @Override
    public void onTakeAmountClicked(CartItem cartItem) {
        updateTotalPrice();
    }

    @Override
    public void onDeleteClicked(CartItem cartItem) {
        updateTotalPrice();
    }

    public void updateTotalPrice() {
        AppDatabase db = AppDatabase.getInstance(CartActivity.this);
        CartDao cartDao = db.getCartDao();

        double totalPrice = cartDao.getTotalPrice();
        textViewTotalPrice.setText(String.valueOf(totalPrice) + " €");
    }
}
