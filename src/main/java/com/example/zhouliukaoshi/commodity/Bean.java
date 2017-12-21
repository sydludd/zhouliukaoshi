package com.example.zhouliukaoshi.commodity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/9/009.
 */

public class Bean {
    public long ver;
    public int server_time;
    public List<GoodsListBean> goods_list;

    public static class GoodsListBean {
        public int normal_price;
        public int cnt;
        public String thumb_url;
        public int event_type;
        public String country;
        public String short_name;
        public GroupBean group;
        public String allowed_region;
        public int time;
        public String image_url;
        public int market_price;
        public String goods_name;
        public String hd_thumb_url;
        public int quantity;
        public boolean is_onsale;
        public int goods_id;
        public int is_app;
        public int mall_id;
        public int region_limit;

        public static class GroupBean {

            public int customer_num;
            public int price;
        }
    }
}
