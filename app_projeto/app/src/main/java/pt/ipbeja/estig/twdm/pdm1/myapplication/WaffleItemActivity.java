package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Dao;

import com.bumptech.glide.Glide;

public class WaffleItemActivity extends AppCompatActivity {
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
            textViewItemPrice.setText(waffle.getWafflePrice());
        } else {
            finish();
        }
    }

}
