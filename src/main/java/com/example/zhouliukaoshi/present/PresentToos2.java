package com.example.zhouliukaoshi.present;

import com.example.zhouliukaoshi.commodity.Bean2;
import com.example.zhouliukaoshi.model.ModelToos2;
import com.example.zhouliukaoshi.view.ViewPort2;

/**
 * Created by Administrator on 2017/12/9/009.
 */

public class PresentToos2 implements ModelToos2.OnFinish2 {
    private ViewPort2 viewPort2;
    private ModelToos2 modelToos2;
   // private String goods_id;
    public PresentToos2(ViewPort2 viewPort2) {
        this.viewPort2 = viewPort2;
        //this.goods_id=goods_id;
        modelToos2=new ModelToos2(this);
    }
    public void getBean2(int goods_id){

        modelToos2.getData2(goods_id);
    }
    @Override
    public void onGetFinish2(Bean2 bean2, int good_id) {

        viewPort2.showData2(bean2,good_id);
    }
}
