package bwei.com.day7_rikao.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bwei.com.day7_rikao.Bean.QuanShopBean;
import bwei.com.day7_rikao.R;

public class Quan_Adapters    extends  RecyclerView.Adapter<Quan_Adapters.Quanviewholder>    {
    Context context;
    private List<QuanShopBean.ResultBean> quanlist;

    public Quan_Adapters(Context context, List<QuanShopBean.ResultBean> quanlist) {
        this.context = context;
        this.quanlist = quanlist;
    }

    @NonNull
    @Override
    public Quanviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  view=View.inflate(context, R.layout.quan_recycler_layout,null);
        return  new Quanviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Quanviewholder quanviewholder, int i) {
        quanviewholder.textView1.setText(quanlist.get(i).getNickName());
        quanviewholder.textView2.setText(quanlist.get(i).getContent());
        Glide.with(context).load(quanlist.get(i).getHeadPic()).into(quanviewholder.imageView1);
        Glide.with(context).load(quanlist.get(i).getImage()).into(quanviewholder.imageView2);
    }

    @Override
    public int getItemCount() {
        return quanlist.size();
    }
       class  Quanviewholder extends RecyclerView.ViewHolder{
            ImageView   imageView1,imageView2;
            TextView   textView1,textView2;
           public Quanviewholder(@NonNull View itemView) {
               super(itemView);
               imageView1=itemView.findViewById(R.id.quan_img_view);
               imageView2=itemView.findViewById(R.id.quan_img_zhan);
               textView1=itemView.findViewById(R.id.quan_text_name);
               textView2=itemView.findViewById(R.id.quan_text_content);
           }
       }
}
