package com.example.zhouliukaoshi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhouliukaoshi.R;
import com.example.zhouliukaoshi.commodity.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/9/009.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Bean.GoodsListBean> list;
    private Context context;
    private OnItemClick onItemClick;
    public MyAdapter(List<Bean.GoodsListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.item_xinpin,null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
         holder.sdv.setImageURI(list.get(position).thumb_url);
         holder.name.setText(list.get(position).short_name);
        holder.price.setText("￥:"+list.get(position).group.price);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private OnItemClick itemClick;
        SimpleDraweeView sdv;
        TextView name,price;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemClick=onItemClick;
            itemView.setOnClickListener(this);
            sdv=itemView.findViewById(R.id.sdv);
            name=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
        }

        @Override
        public void onClick(View view) {
            if(onItemClick!=null){
                onItemClick.onItemClick(view,getPosition());
            }
        }
    }
    public interface OnItemClick{
        void onItemClick(View view,int a);
    }
  public void setOnItemClickListener(OnItemClick onItemClick){
      this.onItemClick=onItemClick;
  }
}
