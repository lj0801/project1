package bwei.com.day7_rikao.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import bwei.com.day7_rikao.Adapter.Quan_Adapters;
import bwei.com.day7_rikao.Bean.QuanShopBean;
import bwei.com.day7_rikao.PresentersQuan.PresenterQuan;
import bwei.com.day7_rikao.R;
import bwei.com.day7_rikao.ViewQuan.ViewQuanInterface;
import bwei.com.day7_rikao.View_Action.TopBars;

public class BenFragments extends Fragment implements ViewQuanInterface {
   int  page=1;
   int  count=5;
    Unbinder unbinder;
    @BindView(R.id.quan_xrecycler)
    XRecyclerView quanXrecycler;
    private TopBars top_bar_ben;
    private List<QuanShopBean.ResultBean> quanlist;
    private Quan_Adapters quan_adapters;
    private PresenterQuan presenterQuan;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ben_fragments, container, false);
        top_bar_ben = view.findViewById(R.id.top_bar_ben);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        quanXrecycler.setLayoutManager(gridLayoutManager);
        presenterQuan = new PresenterQuan(BenFragments.this);
        presenterQuan.getQuanModel(page,count);
        quanXrecycler.setLoadingMoreEnabled(true);
        quanXrecycler.setPullRefreshEnabled(true);
        quanXrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        count++;
                        presenterQuan.getQuanModel(page,count);
                        quan_adapters.notifyDataSetChanged();
                        quanXrecycler.refreshComplete();
                    }
                },2000);
            }
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page=1;
                        presenterQuan.getQuanModel(page,count);
                        quan_adapters.notifyDataSetChanged();
                        quanXrecycler.loadMoreComplete();
                    }
                },2000);
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void getdata(final String data) {
        Gson gson = new Gson();
        QuanShopBean quanShopBean = gson.fromJson(data, QuanShopBean.class);
        quanlist = quanShopBean.getResult();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.i("aa", "ss" + data);
                //创建适配器
                quan_adapters = new Quan_Adapters(getActivity(), quanlist);
                quanXrecycler.setAdapter(quan_adapters);
            }
        });
    }
}
