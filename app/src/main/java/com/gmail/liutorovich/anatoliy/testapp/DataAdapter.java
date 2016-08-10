package com.gmail.liutorovich.anatoliy.testapp;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ToLik on 10.08.2016.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<String> images;
    private Context context;
    public MainActivity activity;
    private boolean flag = true;

    public DataAdapter(MainActivity activity, Context context,ArrayList<String> images) {
        this.context = context;
        this.activity = activity;
        this.images = images;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {


        Picasso.with(context).load(images.get(i)).resize(320, 240).into(viewHolder.img_android, new Callback() {
            @Override
            public void onSuccess() {
                if (i == (images.size() - 1) && flag == true) {
                    flag = false;
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("Изображения загружены!")
                            .setCancelable(false)
                            .setNegativeButton("ОК, спасибо",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_android;
        public ViewHolder(View view) {
            super(view);

            img_android = (ImageView)view.findViewById(R.id.img_android);
        }
    }
}
