package com.notoweb.kulinerkhassemarang;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int KulinerId;
    int KulinerSmgId = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            finishApp();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void finishApp() {
        finish();
        moveTaskToBack(true);
    }

    public void displayKulinerInfo(View view) {

        TextView detailsTextView = (TextView) findViewById(R.id.kuliner_details);

        ImageView kulinerImageView = (ImageView) findViewById(R.id.kuliner_image);

        detailsTextView.setText(getKulinerSmg());

        switch (KulinerId) {
            case 0: kulinerImageView.setImageResource(R.drawable.lumpia);
                break;
            case 1: kulinerImageView.setImageResource(R.drawable.roti_ganjel_rel);
                break;
            case 2: kulinerImageView.setImageResource(R.drawable.wedang_tahu);
                break;
            case 3: kulinerImageView.setImageResource(R.drawable.bandeng_presto);
                break;
            case 4: kulinerImageView.setImageResource(R.drawable.tahu_petis);
                break;
            case 5: kulinerImageView.setImageResource(R.drawable.mie_kopyok);
                break;
            case 6: kulinerImageView.setImageResource(R.drawable.kue_moci);
                break;
            case 7: kulinerImageView.setImageResource(R.drawable.tahu_gimbal);
                break;
            case 8: kulinerImageView.setImageResource(R.drawable.wingo_babat);
                break;
            case 9: kulinerImageView.setImageResource(R.drawable.babat_gongso);
                break;
            case 10: kulinerImageView.setImageResource(R.drawable.tahu_pong);
                break;
            case 11: kulinerImageView.setImageResource(R.drawable.sego_gandul);
                break;
        }
    }

    public String getKulinerSmg() {

        Resources res = getResources();
        String[] kulinerDetails = res.getStringArray(R.array.kuliner_details_array);

        int arrayLength = kulinerDetails.length;

        KulinerId = randInt(kulinerDetails.length);

        checkId(arrayLength);

        KulinerSmgId = KulinerId;

        return kulinerDetails[KulinerId];
    }

    public static int randInt(int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt(max);
        return randomNum;
    }

    public void checkId(int arrayLength) {
        if (KulinerSmgId != KulinerId) {
            return;
        } else {
            while (KulinerSmgId == KulinerId) {
                KulinerId = randInt(arrayLength);
            }
            return;
        }
    }
}