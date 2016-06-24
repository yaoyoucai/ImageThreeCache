package com.shbd.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shbd.bean.GroupIconBean;
import com.shbd.utils.ImageUtils;

import java.util.List;

/**
 * Created by yh on 2016/6/24.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private LayoutInflater mInflater;
    private Context mContext;

    private List<GroupIconBean.DataBean.NewsBean> mNews;

    public MyAdapter(Context context, List<GroupIconBean.DataBean.NewsBean> news) {
        this.mContext = context;
        this.mNews = news;

        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        int layoutPosition = holder.getLayoutPosition();

        //展示图片
        ImageUtils.displayImage(holder.imageView, mNews.get(layoutPosition).getListimage());

    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }
}
