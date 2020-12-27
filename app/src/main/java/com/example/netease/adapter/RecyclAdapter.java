package com.example.netease.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.netease.R;
import com.example.netease.bean.HomeBean;

import java.util.ArrayList;

public class RecyclAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataDTO.TopicListDTO> topicListDTOS;

    public RecyclAdapter(Context context, ArrayList<HomeBean.DataDTO.TopicListDTO> topicListDTOS) {
        this.context = context;
        this.topicListDTOS = topicListDTOS;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_itemm, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataDTO.TopicListDTO topicListDTO = topicListDTOS.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.title.setText(topicListDTO.getTitle());
        holder1.name.setText(topicListDTO.getSubtitle());
        holder1.jin.setText("¥"+topicListDTO.getPrice_info()+"元起");
        Glide.with(holder1.image).load(topicListDTO.getItem_pic_url()).into(holder1.image);
    }

    @Override
    public int getItemCount() {
        return topicListDTOS.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final ImageView image;
        private final TextView jin;
        private final TextView name;
        public ViewHolder(View view) {
            super(view);
            title = itemView.findViewById(R.id.itemm_title);
            image = itemView.findViewById(R.id.itemm_image);
            jin = itemView.findViewById(R.id.itemm_jin);
            name = itemView.findViewById(R.id.itemm_name);
        }
    }
}
