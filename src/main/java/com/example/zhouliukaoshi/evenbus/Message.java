package com.example.zhouliukaoshi.evenbus;

/**
 * Created by Administrator on 2017/12/9/009.
 */

public class Message {
    public int goods_id;

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public Message(int goods_id) {

        this.goods_id = goods_id;
    }
}
