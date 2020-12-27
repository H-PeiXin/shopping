package com.example.netease.presenter;

import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.utils.INetCallBack;
import com.example.mvplibrary.utils.URLConstant;
import com.example.netease.bean.HomeBean;
import com.example.netease.contract.HomeContract;
import com.example.netease.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeContract.IHomeView, HomeContract.IHomeModel> implements HomeContract.IHomePresenter {

    private HomeModel homeModel;

    @Override
    public HomeContract.IHomeModel getiModel() {
        return new HomeModel();
    }

    @Override
    public void getHome() {
        homeModel = new HomeModel();
        homeModel.getHomeData(URLConstant.NEWLIST, new INetCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                iView.getHomeV(homeBean);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }
}
