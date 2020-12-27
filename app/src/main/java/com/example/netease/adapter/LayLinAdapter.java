package com.example.netease.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.netease.R;
import com.example.netease.bean.HomeBean;

import java.util.ArrayList;

public class LayLinAdapter extends DelegateAdapter.Adapter<LayLinAdapter.LayViewHolder> {
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsList;

    public LayLinAdapter(LinearLayoutHelper linearLayoutHelper, ArrayList<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsList) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.hotGoodsList = hotGoodsList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public LayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_laylin, null, false);
        return new LayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LayViewHolder holder, int position) {
//        LayViewHolder lay = (LayViewHolder) holder;
//        Log.e("TAG55", "onBindViewHolder: "+holder );
//        Log.e("TAG66", "onBindViewHolder: "+layyLinViewHolder );
        HomeBean.DataDTO.HotGoodsListDTO hotGoodsListDTO = hotGoodsList.get(position);
        holder.title.setText(hotGoodsListDTO.getName());
        holder.name.setText(hotGoodsListDTO.getGoods_brief());
        holder.jin.setText("¥"+hotGoodsListDTO.getRetail_price());

        Glide.with(holder.image).load(hotGoodsListDTO.getList_pic_url()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return hotGoodsList.size();
    }

    public class LayViewHolder extends RecyclerView.ViewHolder {
        private final TextView jin;
        private final TextView name;
        private final TextView title;
        private final ImageView image;
        public LayViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.lay_image);
            title = itemView.findViewById(R.id.lay_title);
            name = itemView.findViewById(R.id.lay_name);
            jin = itemView.findViewById(R.id.lay_jin);
        }
    }
//
//    @Override
//    public LayoutHelper onCreateLayoutHelper() {
//        return linearLayoutHelper;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_laylin, null, false);
//        return new LayViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        LayViewHolder lay = (LayViewHolder) holder;
////        Log.e("TAG55", "onBindViewHolder: "+holder );
////        Log.e("TAG66", "onBindViewHolder: "+layyLinViewHolder );
//        HomeBannerBean.DataDTO.HotGoodsListDTO hotGoodsListDTO = hotGoodsList.get(position);
//        lay.title.setText(hotGoodsListDTO.getName());
//        lay.name.setText(hotGoodsListDTO.getGoods_brief());
//        lay.jin.setText("¥"+hotGoodsListDTO.getRetail_price());
//
//        Glide.with(lay.image).load(hotGoodsListDTO.getList_pic_url()).into(lay.image);
//    }
//
//    @Override
//    public int getItemCount() {
//        return hotGoodsList.size();
//    }
//
//    private class LayViewHolder extends RecyclerView.ViewHolder {
//
//        private final TextView jin;
//        private final TextView name;
//        private final TextView title;
//        private final ImageView image;
//
//        public LayViewHolder(View view) {
//            super(view);
//            image = view.findViewById(R.id.lay_image);
//            title = view.findViewById(R.id.lay_title);
//            name = view.findViewById(R.id.lay_name);
//            jin = view.findViewById(R.id.lay_jin);
//        }
//    }
}
