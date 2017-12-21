package com.example.zhouliukaoshi.model;

import android.util.Log;

import com.example.zhouliukaoshi.api.MyAPI;
import com.example.zhouliukaoshi.api.MyService;
import com.example.zhouliukaoshi.commodity.Bean2;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/10/010.
 */

public class ModelToos2 implements ModelPort2 {
   // private Bean2 bean2;
    private OnFinish2 onFinish2;
    public ModelToos2(OnFinish2 onFinish2) {
        this.onFinish2 = onFinish2;
    }
    @Override
    public void getData2(final int goods_id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyAPI.MESSAGE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MyService service = retrofit.create(MyService.class);
        Observable<Bean2> beanObservable = service.getBean2(goods_id);

        beanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean2>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                       // System.out.println( e.toString()+"________________");
                    }

                    @Override
                    public void onNext(Bean2 bean2) {
                       // Log.i(bean2.toString()+"--------","22222222");
                        onFinish2.onGetFinish2(bean2,goods_id);
                    }
                });

//        System.out.println("____________________________"+goods_id);
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(MyAPI.MESSAGE)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        MyService service = retrofit.create(MyService.class);
//        Observable<Bean2> beanObservable = service.getBean2(goods_id);
//        beanObservable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Bean2>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.i("sssssssssssss失败",e.toString());
//                    }
//
//                    @Override
//                    public void onNext(Bean2 bean2) {
//                        Log.i("sssssssssssss成功",bean2.toString());
//                        onFinish2.onGetFinish2(bean2,goods_id);
//                    }
//                });

    }
    public interface nOnFinish2{
        void onGetFinish2(Bean2 bean2,int good_id);
    }
}
