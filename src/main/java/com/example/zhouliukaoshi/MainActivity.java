package com.example.zhouliukaoshi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.zhouliukaoshi.adapter.MyAdapter;
import com.example.zhouliukaoshi.commodity.Bean;
import com.example.zhouliukaoshi.commodity.Bean2;
import com.example.zhouliukaoshi.evenbus.Message;
import com.example.zhouliukaoshi.present.PresentToos;
import com.example.zhouliukaoshi.view.ViewPort;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPort{
    private PresentToos presentToos;
    private RecyclerView rlv;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        rlv= (RecyclerView) findViewById(R.id.rlv);
        getBean();
    }

    @Override
    public void showView(final List<Bean.GoodsListBean> beanList) {
         rlv.setLayoutManager(new GridLayoutManager(this,2));
        adapter=new MyAdapter(beanList,this);
         rlv.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClick() {
            @Override
            public void onItemClick(View view, int a) {
                EventBus.getDefault().postSticky(new Message(beanList.get(a).goods_id));
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                //Toast.makeText(MainActivity.this,beanList.get(a).goods_id+"",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }



    public void getBean() {
        presentToos=new PresentToos(this);
        presentToos.getBean();
    }
}
