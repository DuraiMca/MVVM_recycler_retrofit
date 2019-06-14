package com.murugan.durai.logindesignwednesday.ADAPTER;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.murugan.durai.logindesignwednesday.GetPosition;
import com.murugan.durai.logindesignwednesday.MODEL.ModelClass;
import com.murugan.durai.logindesignwednesday.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewholder> {
    GetPosition getPosition;
    ArrayList<ModelClass> list = new ArrayList<>();
    Context context;

    public MyAdapter(ArrayList<ModelClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void update(ArrayList<ModelClass> list) {
        this.list = list;

    }

    public void setGetPosition(GetPosition getPosition) {
        this.getPosition = getPosition;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.images, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Picasso.with(context).load(list.get(position).getImgurl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        ImageView imageView, imageView2;

        public viewholder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.images);
            imageView2 = itemView.findViewById(R.id.images2);
            imageView2.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View v) {
                    getPosition.getD(getAdapterPosition());


                    imageView2.setBackground(context.getResources().getDrawable(R.drawable.click1));

                }
            });
        }
    }
}
