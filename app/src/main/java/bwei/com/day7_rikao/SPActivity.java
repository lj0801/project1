package bwei.com.day7_rikao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.recker.flybanner.FlyBanner;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import bwei.com.day7_rikao.Bean.ShangBean;
import bwei.com.day7_rikao.PresenterSP.SPPresenters;
import bwei.com.day7_rikao.ViewSP.SPViewInterface;

public class SPActivity extends AppCompatActivity implements SPViewInterface {

    @BindView(R.id.text_sp_name)
    TextView textSpName;
    @BindView(R.id.text_sp_title)
    TextView textSpTitle;
    @BindView(R.id.xbanner)
    XBanner xbanner;
    @BindView(R.id.fly_banner)
    FlyBanner flyBanner;
    private SPPresenters spPresenters;
    private Unbinder bind;
    private ShangBean.ResultBean result;
    private ShangBean shangBean;

    private List<String> imglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        bind = ButterKnife.bind(this);
        Intent intent = getIntent();
        String id = intent.getStringExtra("commodityId");
        int ID = Integer.parseInt(id);
        spPresenters = new SPPresenters(this);
        spPresenters.GetSPModel(ID);


    }

    @Override
    public void getSP(String data) {
        Gson gson = new Gson();
        shangBean = gson.fromJson(data, ShangBean.class);
        result = shangBean.getResult();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String name = result.getCommodityName();
                String categoryName = result.getCategoryName();
                textSpTitle.setText(name);
                textSpName.setText(categoryName);
                String[] split = result.getPicture().split(",");
                imglist = new ArrayList<>();
                for (int i = 0; i < split.length; i++) {
                    imglist.add(split[i]);
                }
               // flyBanner.setImagesUrl(imglist);
                // 为XBanner绑定数据
                xbanner.setData(imglist, null);
                // XBanner适配数据
                xbanner.setmAdapter(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, View view, int position) {
                        Glide.with(SPActivity.this).load(imglist.get(position)).into((ImageView) view);
                    }
                });
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
