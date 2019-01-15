package bwei.com.day7_rikao.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import bwei.com.day7_rikao.Adapter.MyAdapters;
import bwei.com.day7_rikao.Adapter.MyAdapters2;
import bwei.com.day7_rikao.Adapter.MyAdapters3;
import bwei.com.day7_rikao.Bean.BannerBean;
import bwei.com.day7_rikao.Bean.GetBeans;
import bwei.com.day7_rikao.Presenter.MyPresenter;
import bwei.com.day7_rikao.R;
import bwei.com.day7_rikao.SMActivity;
import bwei.com.day7_rikao.SPActivity;
import bwei.com.day7_rikao.View.ViewInterface;
import bwei.com.day7_rikao.View_Action.TopBars;
import bwei.com.day7_rikao.XbannerActivity;

public class Nei_Fragments extends Fragment  implements ViewInterface {

    private MyPresenter myPresenter;
    private List<GetBeans.ResultBean.MlssBean> list;
    private RecyclerView recycler_view;
    private RecyclerView recycler_view2;
    private RecyclerView recycler_view3;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<String> imagelist;
    private List<BannerBean.ResultBean> list1;
    private XBanner xbanner_list;
    private TopBars top_bar_nei;
    private List<GetBeans.ResultBean.RxxpBean> relist;
    private LinearLayoutManager linearLayoutManager2;
    private List<GetBeans.ResultBean.PzshBean> pzlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nei_fragments, container, false);
        //初始化控件
        recycler_view = view.findViewById(R.id.recycler_view);
        recycler_view2 = view.findViewById(R.id.recycler_view2);
        recycler_view3 = view.findViewById(R.id.recycler_view3);

        xbanner_list = view.findViewById(R.id.xbanner_list);
        top_bar_nei = view.findViewById(R.id.top_bar_nei);
        return  view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        top_bar_nei.setOnLeftAndRightClickListener(new TopBars.OnLeftAndRightClickListener() {
            @Override
            public void OnLeftButtonClick() {
                  Intent   intent=new Intent(getActivity(),SMActivity.class);
                  startActivity(intent);
            }

            @Override
            public void OnRightButtonClick() {

            }
        });
        //创建新型布局管理者
        linearLayoutManager = new LinearLayoutManager(getActivity());
        //设置水平方向
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //创建网格布局管理者
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        //创建瀑布流管理者
        //staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 3);
        recycler_view.setLayoutManager(linearLayoutManager);
        //设置第二个linearlayout
        linearLayoutManager2 = new LinearLayoutManager(getActivity());
        //设置水平方向
        linearLayoutManager2.setOrientation(OrientationHelper.HORIZONTAL);
        //创建管理者
        recycler_view2.setLayoutManager(linearLayoutManager2);
        //实例化presenter层
        //设置管理者
        recycler_view3.setLayoutManager(gridLayoutManager);
        myPresenter = new MyPresenter(Nei_Fragments.this);
        //调用方法
        myPresenter.getModellist();
        //创建一个xbanner方法
       createxbanner();
    }
    private void createxbanner() {
        String  s="{\n" +
                "    \"result\": [\n" +
                "        {\n" +
                "            \"imageUrl\": \"http://172.17.8.100/images/small/banner/cj.png\",\n" +
                "            \"jumpUrl\": \"http://172.17.8.100/htm/lottery/index.html\",\n" +
                "            \"rank\": 5,\n" +
                "            \"title\": \"抽奖\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"imageUrl\": \"http://172.17.8.100/images/small/banner/hzp.png\",\n" +
                "            \"jumpUrl\": \"wd://commodity_list?arg=1001007005\",\n" +
                "            \"rank\": 5,\n" +
                "            \"title\": \"美妆工具\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"imageUrl\": \"http://172.17.8.100/images/small/banner/lyq.png\",\n" +
                "            \"jumpUrl\": \"wd://commodity_info?arg=83\",\n" +
                "            \"rank\": 5,\n" +
                "            \"title\": \"连衣裙\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"imageUrl\": \"http://172.17.8.100/images/small/banner/px.png\",\n" +
                "            \"jumpUrl\": \"wd://commodity_info?arg=165\",\n" +
                "            \"rank\": 5,\n" +
                "            \"title\": \"跑鞋\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"imageUrl\": \"http://172.17.8.100/images/small/banner/wy.png\",\n" +
                "            \"jumpUrl\": \"wd://commodity_list?arg=1001002004\",\n" +
                "            \"rank\": 5,\n" +
                "            \"title\": \"卫衣\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"message\": \"查询成功\",\n" +
                "    \"status\": \"0000\"\n" +
                "}";
        //实现json解析
        Gson  gson=new Gson();
        BannerBean bannerBean = gson.fromJson(s, BannerBean.class);
        list1 = bannerBean.getResult();
        imagelist = new ArrayList<>();
        for (int i = 0; i < this.list1.size() ; i++) {
            imagelist.add(this.list1.get(i).getImageUrl());
        }
        // 为XBanner绑定数据
        xbanner_list.setData(imagelist, null);
        // XBanner适配数据
        xbanner_list.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(Nei_Fragments.this).load(imagelist.get(position)).into((ImageView) view);
            }
        });
        //设置点击跳转事件
        xbanner_list.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, int position) {
                Intent intent=new Intent(getActivity(),XbannerActivity.class);
                intent.putExtra("urls",list1.get(position).getJumpUrl());
                startActivity(intent);
            }
        });
    }
    //调用list方法
    @Override
    public void getviewdata(String message) {
    }
   //调用list方法
    @Override
    public void getviewlist(String ss) {
     //创建gson解析
        Gson   gson=new Gson();
        GetBeans getBeans = gson.fromJson(ss, GetBeans.class);
        list = getBeans.getResult().getMlss();
        GetBeans getBeans1 = gson.fromJson(ss, GetBeans.class);
        relist = getBeans1.getResult().getRxxp();
        GetBeans getBeans2 = gson.fromJson(ss, GetBeans.class);
        pzlist = getBeans2.getResult().getPzsh();
        getActivity().runOnUiThread(new Runnable()
        {
            @Override
            public void run() {
                //创建适配器
                MyAdapters  myAdapters=new MyAdapters(getActivity(),list);
                //设置适配器
                recycler_view.setAdapter(myAdapters);
                myAdapters.setRecyclerItemClickListener(new MyAdapters.OnsetItmesRecyclerListenter() {
                    @Override
                    public void OnItemListenters(int position, List<GetBeans.ResultBean.MlssBean> list) {
                        String  commodityId = list.get(0).getCommodityList().get(position).getCommodityId();
                        Intent intent=new Intent(getActivity(),SPActivity.class);
                        intent.putExtra("commodityId",commodityId);
                        startActivity(intent);
                    }
                });
                //创建适配器
                MyAdapters2  myAdapters2=new MyAdapters2(getActivity(),relist);
                //设置适配器
                recycler_view2.setAdapter(myAdapters2);
                myAdapters2.setRecyclerItemClickListener(new MyAdapters2.OnsetItmesRecyclerListenter() {
                    @Override
                    public void OnItemListenters(int position, List<GetBeans.ResultBean.RxxpBean> relist) {
                        String  commodityId = relist.get(0).getCommodityList().get(position).getCommodityId();
                        Intent intent=new Intent(getActivity(),SPActivity.class);
                        intent.putExtra("commodityId",commodityId);
                        startActivity(intent);
                    }
                });
                //创建适配器
                MyAdapters3   myAdapters3=new MyAdapters3(getActivity(),pzlist);
                //设置适配器
                recycler_view3.setAdapter(myAdapters3);
                myAdapters3.setOnClickListenter(new MyAdapters3.OnsetItmesRecyclerListenter() {
                    @Override
                    public void OnItemListenters(int position, List<GetBeans.ResultBean.PzshBean> list) {
                        String  commodityId = pzlist.get(0).getCommodityList().get(position).getCommodityId();
                        Intent intent=new Intent(getActivity(),SPActivity.class);
                        intent.putExtra("commodityId",commodityId);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
