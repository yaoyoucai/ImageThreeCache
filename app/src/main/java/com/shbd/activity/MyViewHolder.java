package com.shbd.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by yh on 2016/6/24.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;

    public MyViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageview);
    }
}
