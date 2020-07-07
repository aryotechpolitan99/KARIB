package com.aryotech.sahabatkarib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.aryotech.sahabatkarib.Fragment.BoosterFragment;
import com.aryotech.sahabatkarib.Fragment.EventFragment;
import com.aryotech.sahabatkarib.Fragment.ShoopingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new EventFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment = null;

                    switch (menuItem.getItemId())
                    {
                        case R.id.event_fragment:
                            fragment = new EventFragment();
                            break;

                        case R.id.booster_fragment:
                            fragment = new BoosterFragment();
                            break;

                        case R.id.shooping_fragment:
                            fragment = new ShoopingFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container.fragment).commit();


                    return true;
                }
            };
}
