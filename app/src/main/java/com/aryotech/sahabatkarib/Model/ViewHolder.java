package com.aryotech.sahabatkarib.Model;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aryotech.sahabatkarib.R;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View eview;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        eview = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                eclickListener.onItemClick(view, getAdapterPosition());

            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                eclickListener.onItemLongClick(view,getAdapterPosition());
                return true;
            }
        });
    }

    public void setDetails(Context ctx, String image, String tittle){

        TextView eTittle = eview.findViewById(R.id.tittle_tv_eventlist);
        ImageView eImage = eview.findViewById(R.id.imageview_evenlist);

        eTittle.setText(tittle);

        Picasso.get().load(image).into(eImage);

    }

    private ViewHolder.ClickListener eclickListener;

    public  interface ClickListener{

        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public void setOnClickListener(ViewHolder.ClickListener clickListener){

        eclickListener = clickListener;
    }
}
