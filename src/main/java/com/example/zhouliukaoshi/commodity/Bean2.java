package com.example.zhouliukaoshi.commodity;

import java.util.List;

/**
 * Created by Administrator on 2017/12/9/009.
 */

public class Bean2 {

    public String goods_sn;
    public int goods_id;
    public int cat_id;
    public int mall_id;
    public String goods_name;
    public int is_app;
    public int event_type;
    public String goods_desc;
    public int market_price;
    public int is_onsale;
    public String thumb_url;
    public String hd_thumb_url;
    public String allowed_region;
    public String country;
    public String warehouse;
    public int goods_type;
    public String image_url;
    public int is_refundable;
    public int quick_refund;
    public int is_pre_sale;
    public int pre_sale_time;
    public String share_desc;
    public int rv_image;
    public int rv;
    public int gpv;
    public String skip_goods;
    public int shipment_limit_second;
    public int sales;
    public int is_mall_rec;
    public int min_on_sale_group_price;
    public int max_on_sale_group_price;
    public int min_on_sale_normal_price;
    public int max_on_sale_normal_price;
    public int min_group_price;
    public int max_group_price;
    public int max_normal_price;
    public int min_normal_price;
    public int tag;
    public int cost_template_id;
    public int show_rec;
    public int is_folt;
    public int is_installment;
    public int app_new;
    public String red_envelopes;
    public String cost_province_codes;
    public int server_time;
    public int is_home_delivery;
    public int second_hand;
    public int cat_id_1;
    public int cat_id_2;
    public int cat_id_3;
    public List<SkuBean> sku;
    public List<GalleryBean> gallery;
    public List<GroupBean> group;
    public List<ServicePromiseBean> service_promise;
    public List<?> images;

    public static class SkuBean {

        public long sku_id;
        public int goods_id;
        public String thumb_url;
        public int quantity;
        public int limit_quantity;
        public int sold_quantity;
        public int init_quantity;
        public int is_onsale;
        public String spec;
        public int normal_price;
        public int group_price;
        public int price;
        public int market_price;
        public int weight;
        public List<SpecsBean> specs;

        public static class SpecsBean {

            public String spec_key;
            public String spec_value;
        }
    }

    public static class GalleryBean {

        public long id;
        public int goods_id;
        public String url;
        public int width;
        public int height;
        public int priority;
        public int type;
    }

    public static class GroupBean {

        public int id;
        public int group_id;
        public int goods_id;
        public int price;
        public int customer_num;
        public int start_time;
        public int end_time;
        public int duration;
        public int buy_limit;
        public int order_limit;
        public int is_open;
    }

    public static class ServicePromiseBean {

        public String type;
        public String desc;
    }
}
