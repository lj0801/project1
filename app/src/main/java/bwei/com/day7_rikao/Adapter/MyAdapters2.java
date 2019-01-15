package bwei.com.day7_rikao.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bwei.com.day7_rikao.Bean.GetBeans;
import bwei.com.day7_rikao.R;

public class MyAdapters2 extends RecyclerView.Adapter<MyAdapters2.ViewHolder> {
    Context  context;
    private   List<GetBeans.ResultBean.RxxpBean> relist;
    private LayoutInflater layoutInflater;
    private  View view;
    private  OnsetItmesRecyclerListenter onsetItmesRecyclerListenter;
    public  void   setRecyclerItemClickListener(OnsetItmesRecyclerListenter onsetItmesRecyclerListenter) {
        this.onsetItmesRecyclerListenter = onsetItmesRecyclerListenter;
    }
    public MyAdapters2(Context context, List<GetBeans.ResultBean.RxxpBean> relist) {
        this.layoutInflater=LayoutInflater.from(context);
        this.context = context;
        this.relist = relist;
     }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view=layoutInflater.inflate(R.layout.recycler_view2,viewGroup,false);
        ViewHolder  viewHolder =new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.textView_title.setText(relist.get(0).getCommodityList().get(i).getCommodityName());
        viewHolder.textView_price.setText("￥:"+relist.get(0).getCommodityList().get(i).getPrice()+".00");
        Glide.with(context).load(relist.get(0).getCommodityList().get(i).getMasterPic())
                .into(viewHolder.imageView);
        viewHolder.textView_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onsetItmesRecyclerListenter.OnItemListenters(i,relist);
            }
        });
    }
    @Override
    public int getItemCount() {
        return relist.get(0).getCommodityList().size();
    }
    //自定义接口
    public   interface   OnsetItmesRecyclerListenter{
        //写入一个方法
        void  OnItemListenters(int position,List<GetBeans.ResultBean.RxxpBean> relist);

    }
    //创建容器
    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView_title,textView_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_recycler2);
            textView_title=itemView.findViewById(R.id.text_title_recycler2);
            textView_price=itemView.findViewById(R.id.text_price_recycler2);
        }
    }

}
