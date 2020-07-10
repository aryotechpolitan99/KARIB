package com.aryotech.sahabatkarib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aryotech.sahabatkarib.Fragment.BoosterFragment;
import com.aryotech.sahabatkarib.Fragment.EventFragment;
import com.aryotech.sahabatkarib.Fragment.ShopingFragment;
import com.aryotech.sahabatkarib.Model.Event;
import com.aryotech.sahabatkarib.Model.ViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    LinearLayoutManager eLinearLayoutManager;
    RecyclerView eRecyclerView;
    FirebaseDatabase eFirebaseDatabase;
    DatabaseReference eDatabaseReference;
    FirebaseRecyclerAdapter<Event, ViewHolder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Event> option;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eLinearLayoutManager = new LinearLayoutManager(this);
        eLinearLayoutManager.setReverseLayout(true);
        eLinearLayoutManager.setStackFromEnd(true);

        eRecyclerView = findViewById(R.id.recyclerView);
        eFirebaseDatabase = FirebaseDatabase.getInstance();
        eDatabaseReference = eFirebaseDatabase.getReference("Data");

        showData();

        //Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new EventFragment()).commit();
    }

    private void showData() {

        option = new FirebaseRecyclerOptions.Builder<Event>().setQuery(eDatabaseReference, Event.class).build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Event, ViewHolder>(option){
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int i, @NonNull Event event) {

                holder.setDetails(getApplicationContext(), event.getImage(), event.getTittle());

            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
                ViewHolder viewHolder = new ViewHolder(itemView);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                        Toast.makeText(MainActivity.this, "Long Click", Toast.LENGTH_SHORT).show();

                    }

                });
                return viewHolder;
            }
        };

        eRecyclerView.setLayoutManager(eLinearLayoutManager);
        firebaseRecyclerAdapter.startListening();
        eRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }


    protected void onStart() {
        super.onStart();

        if (firebaseRecyclerAdapter != null) {
            firebaseRecyclerAdapter.startListening();
        }
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
