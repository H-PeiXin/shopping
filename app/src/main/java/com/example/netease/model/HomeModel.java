package com.example.netease.model;

import com.example.mvplibrary.utils.INetCallBack;
import com.example.mvplibrary.utils.RetrofitUtils;
import com.example.netease.contract.HomeContract;

public class HomeModel implements HomeContract.IHomeModel {
    @Override
    public <T> void getHomeData(String url, INetCallBack<T> callBack) {
        RetrofitUtils.getInstance().get(url,callBack);
    }
}
