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

public class MyAdapters3 extends RecyclerView.Adapter<MyAdapters3.ViewHolder> {
    Context  context;
    private List<GetBeans.ResultBean.PzshBean> pzlist;
    private LayoutInflater layoutInflater;
    private  View view;
    private    OnsetItmesRecyclerListenter  onsetItmesRecyclerListenter;
    public  void    setOnClickListenter(OnsetItmesRecyclerListenter  onsetItmesRecyclerListenter){
            this.onsetItmesRecyclerListenter=onsetItmesRecyclerListenter;
    }




    //自定义接口
    public   interface   OnsetItmesRecyclerListenter{
        //写入一个方法
        void  OnItemListenters(int position,List<GetBeans.ResultBean.PzshBean> list);

    }
    public MyAdapters3(Context context, List<GetBeans.ResultBean.PzshBean> pzlist) {
        this.layoutInflater=LayoutInflater.from(context);
        this.context = context;
        this.pzlist = pzlist;
     }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view=layoutInflater.inflate(R.layout.recycler_view3,viewGroup,false);
        ViewHolder  viewHolder =new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.textView_title.setText(pzlist.get(0).getCommodityList().get(i).getCommodityName());
        viewHolder.textView_price.setText("￥:"+pzlist.get(0).getCommodityList().get(i).getPrice()+".00");
        Glide.with(context).load(pzlist.get(0).getCommodityList().get(i).getMasterPic())
                .into(viewHolder.imageView);
        viewHolder.textView_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onsetItmesRecyclerListenter.OnItemListenters(i,pzlist);
            }
        });
    }
    @Override
    public int getItemCount() {
        return pzlist.get(0).getCommodityList().size();
    }

    //创建容器
    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView_title,textView_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_recycler3);
            textView_title=itemView.findViewById(R.id.text_title_recycler3);
            textView_price=itemView.findViewById(R.id.text_price_recycler3);
        }
    }

}
