package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ToppingsItemActivity extends AppCompatActivity {
    ImageView imageViewGoBack;
    private static final String KEY_TOPPING_ID = "topId";

    public static void startActivity(Context context, long topId){
        Intent intent = new Intent(context, ToppingsItemActivity.class);
        intent.putExtra(ToppingsItemActivity.KEY_TOPPING_ID, topId);
        context.startActivity(intent);
    }

    private Toppings toppings;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            long topId = bundle.getLong(KEY_TOPPING_ID, -1);

            AppDatabase db = AppDatabase.getInstance(this);
            ToppingsDao toppingsDao = db.getToppingsDao();
            this.toppings = toppingsDao.getById(topId);
            ImageView imageViewTopImg = findViewById(R.id.imageViewItemImg);
            TextView textViewTopPrice = findViewById(R.id.textViewPrice);
            TextView textViewTopName = findViewById(R.id.textViewName);

            Glide.with(this).load(toppings.getTopImg()).into(imageViewTopImg);
            textViewTopName.setText(toppings.getTopName());
            textViewTopPrice.setText(String.valueOf(toppings.getTopPrice()) + " €");

            imageViewGoBack = (ImageView) findViewById(R.id.imageViewGoBack5);
            imageViewGoBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ToppingsItemActivity.this, ToppingsPageActivity.class);
                    startActivity(intent);
                }
            });

            Button buttonAddCart = findViewById(R.id.buttonAddCart);
            buttonAddCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String topItemName = toppings.getTopName();
                    double topPrice = toppings.getTopPrice();
                    int amount = 1;

                    AppDatabase db = AppDatabase.getInstance(ToppingsItemActivity.this);
                    CartDao cartDao = db.getCartDao();

                    Log.i("Click", "Added to cart");
                    CartItem cartItem = new CartItem(0, topItemName, topPrice, amount);
                    cartDao.insert(cartItem);

                    Intent intent = new Intent(ToppingsItemActivity.this, ToppingsPageActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            finish();
        }
    }
}