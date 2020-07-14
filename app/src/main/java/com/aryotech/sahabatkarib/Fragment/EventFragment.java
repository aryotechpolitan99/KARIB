package com.aryotech.sahabatkarib.Fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aryotech.sahabatkarib.Model.Event;
import com.aryotech.sahabatkarib.Model.ViewHolder;
import com.aryotech.sahabatkarib.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    private View EventsView;
    LinearLayoutManager eLinearLayoutManager;
    RecyclerView eRecyclerView;
    FirebaseDatabase eFirebaseDatabase;
    DatabaseReference eDatabaseReference;
    FirebaseRecyclerAdapter<Event, ViewHolder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Event> option;


    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        EventsView = inflater.inflate(R.layout.fragment_event, container, false);

        eLinearLayoutManager = new LinearLayoutManager(getContext());
        eLinearLayoutManager.setReverseLayout(true);
        eLinearLayoutManager.setStackFromEnd(true);

        eRecyclerView = EventsView.findViewById(R.id.recyclerView);

        eFirebaseDatabase = FirebaseDatabase.getInstance();
        eDatabaseReference = eFirebaseDatabase.getReference("Data");

        showData();

        return EventsView;
    }

    private void showData(){
        option = new FirebaseRecyclerOptions.Builder<Event>().setQuery(eDatabaseReference, Event.class).build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Event, ViewHolder>(option) {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
                ViewHolder viewHolder = new ViewHolder(itemView);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {


                    }

                    @Override
                    public void onItemLongClick(View view, int position) {



                    }
                });
                return viewHolder;
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int i, @NonNull Event event) {

                holder.setDetails(getContext(),event.getImage(), event.getTittle());

            }
        };

        eRecyclerView.setLayoutManager(eLinearLayoutManager);
        firebaseRecyclerAdapter.startListening();
        eRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    public void onStart(){

        super.onStart();

        if (firebaseRecyclerAdapter != null){
            firebaseRecyclerAdapter.startListening();
        }
    }

}
