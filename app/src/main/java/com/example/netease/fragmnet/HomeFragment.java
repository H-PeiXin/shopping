package com.example.netease.fragmnet;


import android.graphics.Color;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mvplibrary.base.BaseFragment;
import com.example.netease.R;
import com.example.netease.adapter.LanGeAdapter;
import com.example.netease.adapter.MyAdapter;
import com.example.netease.bean.HomeBean;
import com.example.netease.contract.HomeContract;
import com.example.netease.presenter.HomePresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.IHomeView {
    @BindView(R.id.rec_home)
    RecyclerView    rec_home;
    private ArrayList<HomeBean.DataDTO.BannerDTO> banner;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> channelDTOS;
    private ArrayList<HomeBean.DataDTO.BrandListDTO> brandListDTOS;
    private ArrayList<HomeBean.DataDTO.NewGoodsListDTO> newGoodsListDTOS;
    private ArrayList<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsListDTOS;
    private ArrayList<HomeBean.DataDTO.TopicListDTO> topicListDTOS;
    private ArrayList<HomeBean.DataDTO.CategoryListDTO> categoryListDTOS;
    private ArrayList<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsListDTOS;
    private VirtualLayoutManager layoutManager;
    private MyAdapter myAdapter;
    private LanGeAdapter lanGeAdapter;

    @Override
    protected void initData() {
        presenter.getHome();
    }

    @Override
    protected void initView() {
        banner = new ArrayList<>();
        channelDTOS = new ArrayList<>();
        brandListDTOS = new ArrayList<>();
        newGoodsListDTOS = new ArrayList<>();
        hotGoodsListDTOS = new ArrayList<>();
        topicListDTOS = new ArrayList<>();
        categoryListDTOS = new ArrayList<>();
        goodsListDTOS = new ArrayList<>();

        layoutManager = new VirtualLayoutManager(getContext());
        //设置回收复用线程池大小
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        rec_home.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0,15);
        //通栏
        myAdapter = initTongLan();
        lanGeAdapter = initLanGe();
    }

    private LanGeAdapter initLanGe() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        //公共属性
        columnLayoutHelper.setItemCount(1);//设置不举例Item个数
        columnLayoutHelper.setBgColor(Color.GRAY);//设置背景颜色
        columnLayoutHelper.setAspectRatio(2);//设置布局内每行布局的宽与高的比
        LanGeAdapter lanGeAdapter = new LanGeAdapter(columnLayoutHelper, banner);
        return lanGeAdapter;

    }

    private MyAdapter initTongLan() {
        /**
         * TODO 设置通栏布局
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        //公共属性
        singleLayoutHelper.setItemCount(3);//设置布局里Item个数
        singleLayoutHelper.setBgColor(Color.WHITE);//设置背景颜色
        singleLayoutHelper.setAspectRatio(6);//设置布局内每行布局的宽与高的比
        MyAdapter myAdapter = new MyAdapter(singleLayoutHelper);
        return myAdapter;
    }

    @Override
    protected int getLayoutID() {
        return 0;
    }

    @Override
    public HomePresenter getPresenter() {
        return null;
    }

    @Override
    public <T> void getHomeV(T t) {

    }

    @Override
    public void tips(String string) {

    }
}