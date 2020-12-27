package com.example.netease.fragmnet;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mvplibrary.base.BaseFragment;
import com.example.netease.R;
import com.example.netease.adapter.GridAdapter;
import com.example.netease.adapter.GriddAdapter;
import com.example.netease.adapter.GridtAdapter;
import com.example.netease.adapter.LanGeAdapter;
import com.example.netease.adapter.LanGetowAdapter;
import com.example.netease.adapter.LayLinAdapter;
import com.example.netease.adapter.MyAdapter;
import com.example.netease.adapter.MyTowAdapter;
import com.example.netease.adapter.RecyAdapter;
import com.example.netease.bean.HomeBean;
import com.example.netease.contract.HomeContract;
import com.example.netease.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.IHomeView {
    @BindView(R.id.home_Recycler)
    RecyclerView homeRecycler;
    private ArrayList<HomeBean.DataDTO.BannerDTO> banner;
    private ArrayList<HomeBean.DataDTO.ChannelDTO> channelDTOS;
    private MyAdapter myAdapter;
    private LanGetowAdapter lanGetowAdapter;
    private MyTowAdapter myTowAdapter;
    private MyTowAdapter myTowAdaptere;
    private MyTowAdapter myTowAdapterer;
    private MyTowAdapter myTowAdapterere;
    private DelegateAdapter adapter;
    private LanGeAdapter lanGeAdapter;
    private VirtualLayoutManager layoutManager;
    private ArrayList<HomeBean.DataDTO.BrandListDTO> brandlist;
    private GridAdapter gridAdapter;
    private ArrayList<HomeBean.DataDTO.NewGoodsListDTO> newGoodsListDTOS;
    private GriddAdapter griddAdapter;
    private ArrayList<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsListDTOS;
    private LayLinAdapter layLinAdapter;
    private ArrayList<HomeBean.DataDTO.TopicListDTO> topicListDTOS;
    private RecyAdapter recyAdapter;
    private ArrayList<HomeBean.DataDTO.CategoryListDTO> categoryListDTOS;
    private ArrayList<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> dtoArrayList;


    @Override
    protected void initData() {
        presenter.getHome();
    }

    @Override
    protected void initView() {
        banner = new ArrayList<>();
        channelDTOS = new ArrayList<>();
        brandlist = new ArrayList<>();
        newGoodsListDTOS = new ArrayList<>();
        hotGoodsListDTOS = new ArrayList<>();
        topicListDTOS = new ArrayList<>();
        categoryListDTOS = new ArrayList<>();
        dtoArrayList = new ArrayList<>();

        layoutManager = new VirtualLayoutManager(getContext());
        //设置回收复用线程池大小
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        homeRecycler.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0,15);
        //通栏
        //通栏
        myAdapter = initTongLan();
        lanGeAdapter = initLanGe();
        lanGetowAdapter = initChannel();
        myTowAdapter = initGoodList("品牌制造供应商");
        gridAdapter = initBrandlist();
        myTowAdaptere = initGoodList("周一周四，新品发送");
        griddAdapter = initBrandlistt();
        myTowAdapterer = initGoodList("人气推荐");
        layLinAdapter = initLL();
        myTowAdapterere = initGoodList("专题精选");
        recyAdapter = initTop();
    }

    private RecyAdapter initTop() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(1-5);// 设置设置布局内每行布局的宽与高的比
        RecyAdapter recyAdapter = new RecyAdapter(getContext(),singleLayoutHelper, topicListDTOS);
        return recyAdapter;
    }

    @SuppressLint("WrongConstant")
    private LayLinAdapter initLL() {
        layoutManager.setOrientation(VirtualLayoutManager.VERTICAL);
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();

        linearLayoutHelper.setItemCount(hotGoodsListDTOS.size());// 设置布局里Item个数
        linearLayoutHelper.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper.setMargin(0,0,0,10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        linearLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(2); // 设置每行Item的距离
        LayLinAdapter layLinAdapter = new LayLinAdapter(linearLayoutHelper, hotGoodsListDTOS);
        return layLinAdapter;
    }

    private GriddAdapter initBrandlistt() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);

        //公共属性
        gridLayoutHelper.setItemCount(brandlist.size());// 设置布局里Item个数
        gridLayoutHelper.setPadding(5, 5, 5, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比

        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(2);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(2);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        GriddAdapter griddAdapter = new GriddAdapter(gridLayoutHelper, newGoodsListDTOS);
        return griddAdapter;
    }

    private GridAdapter initBrandlist() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);

        //公共行数
        gridLayoutHelper.setItemCount(brandlist.size());
        gridLayoutHelper.setPadding(5,5,5,0); //设置layouthelper的子元素对layouthelper边缘的距离
        gridLayoutHelper.setBgColor(Color.WHITE);//设置背景颜色
        gridLayoutHelper.setAspectRatio(3); //设置布局内每行布局的宽高比

        //gridlayouthelper特有属性
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(2);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(2);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        GridAdapter gridAdapter = new GridAdapter(gridLayoutHelper, brandlist);
        return gridAdapter;
    }

    private LanGeAdapter initLanGe() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 公共属性
        columnLayoutHelper.setItemCount(1);// 设置布局里Item个数
        columnLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        LanGeAdapter geAdapter = new LanGeAdapter(columnLayoutHelper, banner);
        return geAdapter;
    }

    private MyTowAdapter initGoodList(String string) {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setPadding(0, 50, 0, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        MyTowAdapter myTowAdapter = new MyTowAdapter(singleLayoutHelper,string);
        return myTowAdapter;
    }

    private LanGetowAdapter initChannel() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 公共属性
        columnLayoutHelper.setItemCount(channelDTOS.size());// 设置布局里Item个数
        columnLayoutHelper.setPadding(20, 50, 20, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        LanGetowAdapter getowAdapter = new LanGetowAdapter(columnLayoutHelper, channelDTOS);
        return getowAdapter;
    }

    private MyAdapter initTongLan() {
        /**
         TODO 设置通栏布局
         */
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        // 公共属性
        singleLayoutHelper.setItemCount(3);// 设置布局里Item个数
        singleLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        MyAdapter myAdapter = new MyAdapter(singleLayoutHelper);
        return myAdapter;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public HomePresenter getPresenter() {
        return new HomePresenter();
    }

    private void initAddAdapter(){

        homeRecycler.setLayoutManager(layoutManager);
        homeRecycler.setAdapter(adapter);
    }

    @Override
    public <T> void getHomeV(T t) {
        HomeBean homeBannerBean = (HomeBean) t;
        if (homeBannerBean!=null){
            List<HomeBean.DataDTO.BannerDTO> banner = homeBannerBean.getData().getBanner();
            this.banner.clear();
            this.banner.addAll(banner);
            lanGeAdapter.notifyDataSetChanged();
            List<HomeBean.DataDTO.ChannelDTO> channel = homeBannerBean.getData().getChannel();
            channelDTOS.clear();
            channelDTOS.addAll(channel);
            lanGetowAdapter.notifyDataSetChanged();
            List<HomeBean.DataDTO.BrandListDTO> brandList = homeBannerBean.getData().getBrandList();
            brandlist.clear();
            brandlist.addAll(brandList);
            gridAdapter.notifyDataSetChanged();
            List<HomeBean.DataDTO.NewGoodsListDTO> newGoodsList = homeBannerBean.getData().getNewGoodsList();
            newGoodsListDTOS.clear();
            newGoodsListDTOS.addAll(newGoodsList);
            griddAdapter.notifyDataSetChanged();
            List<HomeBean.DataDTO.HotGoodsListDTO> hotGoodsList = homeBannerBean.getData().getHotGoodsList();
            hotGoodsListDTOS.clear();
            hotGoodsListDTOS.addAll(hotGoodsList);
            layLinAdapter.notifyDataSetChanged();
            List<HomeBean.DataDTO.TopicListDTO> topicList = homeBannerBean.getData().getTopicList();
            topicListDTOS.clear();
            topicListDTOS.addAll(topicList);
            recyAdapter.notifyDataSetChanged();

            adapter = new DelegateAdapter(layoutManager, false);
            adapter.addAdapter(myAdapter);
            adapter.addAdapter(lanGeAdapter);
            adapter.addAdapter(lanGetowAdapter);
            adapter.addAdapter(myTowAdapter);
            adapter.addAdapter(gridAdapter);
            adapter.addAdapter(myTowAdaptere);
            adapter.addAdapter(griddAdapter);
            adapter.addAdapter(myTowAdapterer);
            adapter.addAdapter(layLinAdapter);
            adapter.addAdapter(myTowAdapterere);
            adapter.addAdapter(recyAdapter);
            List<HomeBean.DataDTO.CategoryListDTO> categoryList = homeBannerBean.getData().getCategoryList();
            categoryListDTOS.clear();
            categoryListDTOS.addAll(categoryList);
            dtoArrayList.clear();
            for (int i = 0; i < categoryListDTOS.size(); i++) {
                MyTowAdapter myTowAdapter1 = initGoodList(categoryListDTOS.get(i).getName());
                adapter.addAdapter(myTowAdapter1);
                List<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList = categoryListDTOS.get(i).getGoodsList();
                GridtAdapter gridtAdapter = initGrid((ArrayList<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO>) goodsList, i);
                adapter.addAdapter(gridtAdapter);
            }
        }
        initAddAdapter();
    }

    private GridtAdapter initGrid(ArrayList<HomeBean.DataDTO.CategoryListDTO.GoodsListDTO> goodsList, int i) {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数

        // 公共属性
        gridLayoutHelper.setItemCount(brandlist.size());// 设置布局里Item个数
        gridLayoutHelper.setPadding(5, 5, 5, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(2);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(2);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        GridtAdapter griddAdapter = new GridtAdapter(gridLayoutHelper, goodsList,i);
        return griddAdapter;
    }

    @Override
    public void tips(String string) {
        Log.e("TAG",string);
    }
}