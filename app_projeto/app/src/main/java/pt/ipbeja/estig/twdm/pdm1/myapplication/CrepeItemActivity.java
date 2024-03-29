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

public class CrepeItemActivity extends AppCompatActivity {
    private static final String KEY_CREPE_ID = "crepeId";

    public static void startActivity(Context context,long crepeId){
        Intent intent = new Intent(context, CrepeItemActivity.class);
        intent.putExtra(CrepeItemActivity.KEY_CREPE_ID, crepeId);
        context.startActivity(intent);
    }

    private Crepe crepe;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            long crepeId = bundle.getLong(KEY_CREPE_ID, -1);

            AppDatabase db = AppDatabase.getInstance(this);
            CrepeDao crepeDao = db.getCrepeDao();

            this.crepe = crepeDao.getById(crepeId);
            ImageView imageViewItemImg = findViewById(R.id.imageViewItemImg);
            TextView textViewItemPrice = findViewById(R.id.textViewPrice);
            TextView textViewItemName = findViewById(R.id.textViewName);

            Glide.with(this).load(crepe.getCrepeImg()).into(imageViewItemImg);
            textViewItemName.setText(crepe.getCrepeName());
            textViewItemPrice.setText(String.valueOf(crepe.getCrepePrice()));

            ImageView imageViewGoBack = (ImageView) findViewById(R.id.imageViewGoBack5);
            imageViewGoBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent int1 = new Intent(CrepeItemActivity.this, CrepePageActivity.class);
                    startActivity(int1);
                }
            });

            Button buttonAddCart = findViewById(R.id.buttonAddCart);
            buttonAddCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String itemName = crepe.getCrepeName();
                    double price = crepe.getCrepePrice();
                    int amount = 1;

                    AppDatabase db = AppDatabase.getInstance(CrepeItemActivity.this);
                    CartDao cartDao = db.getCartDao();

                    Log.i("Click", "Added to cart");
                    CartItem cartItem = new CartItem(0, itemName, price, amount);
                    cartDao.insert(cartItem);

                    Intent intent = new Intent(CrepeItemActivity.this, CrepePageActivity.class);
                    startActivity(intent);
                }
            });


        } else {
            finish();
        }
    }
}
