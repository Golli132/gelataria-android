package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView homePageImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homePageImg = (ImageView) findViewById(R.id.homeImg);
        homePageImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Log.i("Click", "New Client!");
                Intent intent = new Intent(MainActivity.this, MainPage.class);
                startActivity(intent);
                finish();
            }
        });
    }
}