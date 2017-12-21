package com.example.zhouliukaoshi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.zhouliukaoshi.commodity.Bean;
import com.example.zhouliukaoshi.commodity.Bean2;
import com.example.zhouliukaoshi.evenbus.Message;
import com.example.zhouliukaoshi.present.PresentToos2;
import com.example.zhouliukaoshi.view.ViewPort;
import com.example.zhouliukaoshi.view.ViewPort2;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by Administrator on 2017/12/9/009.
 */
public class MainActivity2 extends AppCompatActivity implements ViewPort2{
    private TextView tv;
    private PresentToos2 presentToos2;
    private SimpleDraweeView sdv;
    private int goods_id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();



    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getBean(Message message){
        //presentToos2.getBean2(message.goods_id);
        goods_id=message.goods_id;
    }
    private void init() {
        EventBus.getDefault().register(MainActivity2.this);
        tv= (TextView) findViewById(R.id.tv);
        sdv= (SimpleDraweeView) findViewById(R.id.sdv);
        getData(goods_id);
    }


    @Override
    public void showData2(Bean2 bean2, int goods_id) {
      sdv.setImageURI(bean2.image_url);
      tv.setText(bean2.goods_name);
        Log.i(bean2.toString(),"777777"+goods_id);

    }

    public void getData(int a) {
        presentToos2=new PresentToos2(this);
        presentToos2.getBean2(a);
    }
}
