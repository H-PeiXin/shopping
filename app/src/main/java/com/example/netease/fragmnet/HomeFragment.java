package com.example.netease.fragmnet;


import com.example.mvplibrary.base.BaseFragment;
import com.example.netease.contract.HomeContract;
import com.example.netease.presenter.HomePresenter;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.IHomeView {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

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