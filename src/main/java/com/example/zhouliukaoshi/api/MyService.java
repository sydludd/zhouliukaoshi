package com.example.zhouliukaoshi.api;

import com.example.zhouliukaoshi.commodity.Bean;
import com.example.zhouliukaoshi.commodity.Bean2;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/12/9/009.
 */

public interface MyService {
   @GET("v5/newlist")
    Observable<Bean> getBean(@Query("page") String a, @Query("{size}") String b, @Query("ver") String c, @Query("pdduid") String d);
    @GET("v5/goods/{goods_id}?pdduid=3470667255")
    Observable<Bean2> getBean2(@Path("goods_id") int goods_id);
}
