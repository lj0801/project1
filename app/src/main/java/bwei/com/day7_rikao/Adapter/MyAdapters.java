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

public class MyAdapters extends RecyclerView.Adapter<MyAdapters.ViewHolder> {
    Context  context;
    private List<GetBeans.ResultBean.MlssBean> list;
    private LayoutInflater layoutInflater;
    private  View view;
    private    OnsetItmesRecyclerListenter  onsetItmesRecyclerListenter;
    public  void   setRecyclerItemClickListener(OnsetItmesRecyclerListenter onsetItmesRecyclerListenter) {
        this.onsetItmesRecyclerListenter = onsetItmesRecyclerListenter;
    }
    public MyAdapters(Context context, List<GetBeans.ResultBean.MlssBean> list) {
        this.layoutInflater=LayoutInflater.from(context);
        this.context = context;
        this.list = list;
     }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view=layoutInflater.inflate(R.layout.grid_view,viewGroup,false);
        ViewHolder  viewHolder =new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.textView_title.setText(list.get(0).getCommodityList().get(i).getCommodityName());
        viewHolder.textView_price.setText("￥:"+list.get(0).getCommodityList().get(i).getPrice()+".00");
        Glide.with(context)
                .load(list.get(0).getCommodityList().get(i).getMasterPic())
                .into(viewHolder.imageView);
        viewHolder.textView_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                      onsetItmesRecyclerListenter.OnItemListenters(i,list);

            }
        });
    }
    //自定义接口
    public   interface   OnsetItmesRecyclerListenter{
        //写入一个方法
        void  OnItemListenters(int position,List<GetBeans.ResultBean.MlssBean> list);

    }

    @Override
    public int getItemCount() {
        return list.get(0).getCommodityList().size();
    }



    //创建容器
    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView_title,textView_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img_text_grid);
            textView_title=itemView.findViewById(R.id.text_name_grid);
            textView_price=itemView.findViewById(R.id.text_price_grid);
        }
    }

}
