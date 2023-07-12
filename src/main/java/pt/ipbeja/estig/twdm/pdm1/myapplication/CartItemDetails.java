/*package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class CartItemDetails extends AppCompatActivity {

    private static final String KEY_CART_ID = "cartId";

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_item_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            long cartId = bundle.getLong(KEY_CART_ID, -1);

            AppDatabase db = AppDatabase.getInstance(this);
            CartDao cartDao = db.getCartDao();

            this.cartId = cartDao.getById(cartId);
            TextView textViewItemPrice = findViewById(R.id.textViewPrice);
            TextView textViewItemName = findViewById(R.id.textViewName);

            textViewItemName.setText(cartitem.getCartName());
            textViewItemPrice.setText(crepe.getCrepePrice());
        } else {
            finish();
        }
}*/
