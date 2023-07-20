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
import androidx.room.Dao;

import com.bumptech.glide.Glide;

public class WaffleItemActivity extends AppCompatActivity {

    ImageView imageViewGoBack;
    private static final String KEY_WAFFLE_ID = "waffleId";

    public static void startActivity(Context context, long waffleId){
        Intent intent = new Intent(context, WaffleItemActivity.class);
        intent.putExtra(WaffleItemActivity.KEY_WAFFLE_ID, waffleId);
        context.startActivity(intent);
    }

    private Waffle waffle;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            long waffleId = bundle.getLong(KEY_WAFFLE_ID, -1);

            AppDatabase db = AppDatabase.getInstance(this);
            WaffleDao waffleDao = db.getWaffleDao();
            this.waffle = waffleDao.getById(waffleId);
            ImageView imageViewWaffleImg = findViewById(R.id.imageViewItemImg);
            TextView textViewItemPrice = findViewById(R.id.textViewPrice);
            TextView textViewItemName = findViewById(R.id.textViewName);

            Glide.with(this).load(waffle.getWaffleImg()).into(imageViewWaffleImg);
            textViewItemName.setText(waffle.getWaffleName());
            textViewItemPrice.setText(String.valueOf(waffle.getWafflePrice()) + " €");

            Button buttonAddCart = findViewById(R.id.buttonAddCart);
            buttonAddCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String itemName = waffle.getWaffleName();
                    double price = waffle.getWafflePrice();
                    int amount = 1;

                    AppDatabase db = AppDatabase.getInstance(WaffleItemActivity.this);
                    CartDao cartDao = db.getCartDao();

                    Log.i("Click", "Added to cart");
                    CartItem cartItem = new CartItem(0, itemName, price, amount);
                    cartDao.insert(cartItem);

                    Intent intent = new Intent(WaffleItemActivity.this, WafflePageActivity.class);
                    startActivity(intent);
                }
            });

            imageViewGoBack = (ImageView) findViewById(R.id.imageViewGoBack5);
            imageViewGoBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(WaffleItemActivity.this, WafflePageActivity.class);
                    startActivity(intent);
                }
            });

        } else {
            finish();
        }
    }

}
