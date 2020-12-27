package com.example.netease.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.netease.R;

public class MyTowAdapter extends DelegateAdapter.Adapter<MyTowAdapter.TexttViewHolder> {

    private SingleLayoutHelper singleLayoutHelper;
    private String title;

    public MyTowAdapter(SingleLayoutHelper singleLayoutHelper, String title) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.title = title;
    }
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public TexttViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_text, null, false);
        return new TexttViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TexttViewHolder holder, int position) {
        TexttViewHolder textViewHolder = (TexttViewHolder) holder;
        textViewHolder.text.setText(title);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class TexttViewHolder extends RecyclerView.ViewHolder {
        private final TextView text;
        public TexttViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text_name);
        }
    }

//
//    @Override
//    public LayoutHelper onCreateLayoutHelper() {
//        return singleLayoutHelper;
//    }
//
//    @NonNull
//    @Override
//    public TexttViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull TexttViewHolder holder, int position) {

//    }
//
//    @Override
//    public int getItemCount() {
//        return 1;
//    }
//
//    private class TexttViewHolder extends RecyclerView.ViewHolder {
//
//        private final TextView text;
//
//        public TexttViewHolder(View view) {
//            super(view);
//            text = view.findViewById(R.id.text_name);
//        }
//    }
}
