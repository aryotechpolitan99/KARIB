package com.aryotech.sahabatkarib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.aryotech.sahabatkarib.Fragment.Booster;
import com.aryotech.sahabatkarib.Fragment.Event;
import com.aryotech.sahabatkarib.Fragment.Shoping;
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
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new Event()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.event:
                            fragment = new Event();
                            break;

                        case R.id.booster:
                            fragment = new Booster();
                            break;

                        case R.id.shop:
                            fragment = new Shoping();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
                    return false;
                }
            };


//        //Set Event Selected
//        bottomNavigationView.setSelectedItemId(R.id.event);
//
//        //Perform ItemSelectedListener
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//                switch (menuItem.getItemId()) {
//                    case R.id.event:
//                        startActivity(new Intent(getApplicationContext()
//                                , EventActivity.class));
//                        overridePendingTransition(0, 0);
//                        finish();
//                        return true;
//                    case R.id.booster:
//                        startActivity(new Intent(getApplicationContext()
//                                , BoosterActivity.class));
//                        finish();
//                        return true;
//                    case R.id.shop:
//                        startActivity(new Intent(getApplicationContext()
//                                , ShoopingActivity.class));
//                        overridePendingTransition(0, 0);
//                        finish();
//                        return true;
//                }
//                return false;
//            }
//        });

}
