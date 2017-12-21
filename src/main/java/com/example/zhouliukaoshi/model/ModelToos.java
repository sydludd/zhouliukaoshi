package com.example.zhouliukaoshi.model;


import android.util.Log;

import com.example.zhouliukaoshi.MainActivity2;
import com.example.zhouliukaoshi.api.MyAPI;
import com.example.zhouliukaoshi.api.MyService;
import com.example.zhouliukaoshi.commodity.Bean;
import com.example.zhouliukaoshi.commodity.Bean2;
import com.example.zhouliukaoshi.evenbus.Message;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/9/009.
 */

public class ModelToos implements ModelPort {
    private OnFinish onFinish;
    private List<Bean.GoodsListBean> list;

    public ModelToos(OnFinish onFinish) {
        this.onFinish = onFinish;
    }
    @Override
    public void getData() {
        list = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyAPI.NEW_SHPING)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MyService service = retrofit.create(MyService.class);
        Observable<Bean> beanObservable = service.getBean("1", "20", "1512745500001", "3470667255");
        beanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                       // Log.i(bean.toString()+"-----","2222222");
                        list = bean.goods_list;
                        onFinish.onGetFinish(list);
                    }
                });

    }



    public interface OnlFinish{
        void onGetFinish(List<Bean.GoodsListBean> listBeen);
        //void onGetFinish2(Bean2 bean2,String good_id);
    }

}
