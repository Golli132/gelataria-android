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

public class GeladoItemActivity extends AppCompatActivity {
    private static final String KEY_GELADO_ID = "gelId";

    public static void startActivity(Context context, long gelId) {
        Intent intent = new Intent(context, GeladoItemActivity.class);
        intent.putExtra(GeladoItemActivity.KEY_GELADO_ID, gelId);
        context.startActivity(intent);
    }

    private Gelado gelado;
    ImageView imageViewGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            long gelId = bundle.getLong(KEY_GELADO_ID, -1);

            AppDatabase db = AppDatabase.getInstance(this);
            GeladoDao gelDao = db.getGeladoDao();
            this.gelado = gelDao.getById(gelId);

            ImageView imageViewGelImg = findViewById(R.id.imageViewItemImg);
            TextView textViewItemPrice = findViewById(R.id.textViewPrice);
            TextView textViewItemName = findViewById(R.id.textViewName);

            Glide.with(this).load(gelado.getGelImg()).into(imageViewGelImg);
            textViewItemName.setText(gelado.getGelName());
            textViewItemPrice.setText(String.valueOf(gelado.getGelPrice()) + " €");

            Button buttonAddCart = findViewById(R.id.buttonAddCart);
            buttonAddCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String itemName = gelado.getGelName();
                    double price = gelado.getGelPrice();
                    int amount = 1;

                    AppDatabase db = AppDatabase.getInstance(GeladoItemActivity.this);
                    CartDao cartDao = db.getCartDao();

                    Log.i("Click", "Added to cart");
                    CartItem cartItem = new CartItem(0, itemName, price, amount);
                    cartDao.insert(cartItem);

                    Intent intent = new Intent(GeladoItemActivity.this, GeladoPageActivity.class);
                    startActivity(intent);
                }
            });

            imageViewGoBack = (ImageView) findViewById(R.id.imageViewGoBack5);
            imageViewGoBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(GeladoItemActivity.this, GeladoPageActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            finish();
        }
    }
}
