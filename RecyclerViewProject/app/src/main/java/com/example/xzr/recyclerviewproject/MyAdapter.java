package com.example.xzr.recyclerviewproject;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.xzr.recyclerviewproject.Fruit;

import java.util.ArrayList;

import static com.example.xzr.recyclerviewproject.R.color.colorPrimaryDark;

/**
 * Created by xzr on 2018/12/25.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private ArrayList<String> mData;

    public MyAdapter(ArrayList<String> data) {
        this.mData = data;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);


        // 实例化ViewHolder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 绑定数据
        holder.mTv.setText(mData.get(position));
        holder.mImg.setImageResource(mData.get);

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTv;
        ImageView mImg;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.item_tv);
            mImg = itemView.findViewById(R.id.item_image);
        }
    }
}
