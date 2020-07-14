package com.aryotech.sahabatkarib;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.aryotech.sahabatkarib.Fragment.BoosterFragment;
import com.aryotech.sahabatkarib.Fragment.EventFragment;
import com.aryotech.sahabatkarib.Fragment.ShopingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new EventFragment()).commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.event_nav:
                            fragment = new EventFragment();
                            break;

                        case R.id.booster_nav:
                            fragment = new BoosterFragment();
                            break;

                        case R.id.shop_nav:
                            fragment = new ShopingFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                    return false;
                }
            };


}
