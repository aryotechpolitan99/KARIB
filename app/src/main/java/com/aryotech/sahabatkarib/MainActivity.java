package com.aryotech.sahabatkarib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.aryotech.sahabatkarib.OptionActivity.BoosterActivity;
import com.aryotech.sahabatkarib.OptionActivity.EventActivity;
import com.aryotech.sahabatkarib.OptionActivity.ShoopingActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        //Set Event Selected
        bottomNavigationView.setSelectedItemId(R.id.event);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.event:
                        startActivity(new Intent(getApplicationContext()
                                , EventActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                    case R.id.booster:
                        startActivity(new Intent(getApplicationContext()
                                , BoosterActivity.class));
                        finish();
                        return true;
                    case R.id.shop:
                        startActivity(new Intent(getApplicationContext()
                                , ShoopingActivity.class));
                        overridePendingTransition(0, 0);
                        finish();
                        return true;
                }
                return false;
            }
        });
    }
}
