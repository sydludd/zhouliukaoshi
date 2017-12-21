package com.example.zhouliukaoshi.present;

import com.example.zhouliukaoshi.commodity.Bean;
import com.example.zhouliukaoshi.commodity.Bean2;
import com.example.zhouliukaoshi.model.ModelToos;
import com.example.zhouliukaoshi.view.ViewPort;

import java.util.List;

/**
 * Created by Administrator on 2017/12/9/009.
 */

public class PresentToos implements ModelToos.OnFinish {
    private ViewPort viewPort;
    private ModelToos modelToos;
    public PresentToos(ViewPort viewPort) {
        this.viewPort = viewPort;
        modelToos=new ModelToos(this);
    }
    public void getBean(){
        modelToos.getData();
    }

    @Override
    public void onGetFinish(List<Bean.GoodsListBean> listBeen) {

        viewPort.showView(listBeen);
    }

}
