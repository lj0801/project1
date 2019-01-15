package bwei.com.day7_rikao;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.List;

import bwei.com.day7_rikao.Fragments.BenFragments;
import bwei.com.day7_rikao.Fragments.FxFragments;
import bwei.com.day7_rikao.Fragments.GwFragments;
import bwei.com.day7_rikao.Fragments.Nei_Fragments;
import bwei.com.day7_rikao.Fragments.WangFragments;

public class MainActivity extends FragmentActivity {
    private RadioGroup radio_group;
    private ViewPager view_pager;
    private List<Fragment> flist;
    private BottomTabBar bottom_bar;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom_bar = findViewById(R.id.bottom_bar);
        bottom_bar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(8)
                .setTabBarBackgroundResource(R.mipmap.db)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,R.color.black)
                .addTabItem("首页",R.mipmap.home1,Nei_Fragments.class)
                .addTabItem("发现",R.mipmap.xing2, BenFragments.class)
                .addTabItem("购物车",R.mipmap.gw,WangFragments.class)
                .addTabItem("账单",R.mipmap.rl2,GwFragments.class)
                .addTabItem("我的",R.mipmap.me2,FxFragments.class)
                .isShowDivider(false)
               .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }

        //初始化控件
      /*  createinit();
        createdata();*/
    }
   /* private void createinit() {
        radio_group = findViewById(R.id.radio_group);
        view_pager = findViewById(R.id.view_pager);
    }*/
    /*private void createdata() {
       //创建数组
        flist = new ArrayList<>();
        //添加数组
        flist.add(new Nei_Fragments());
        flist.add(new WangFragments());
        flist.add(new BenFragments());
        //创建适配器
        MyFragmentsAdapter  myFragmentsAdapter=new MyFragmentsAdapter(getSupportFragmentManager());
        view_pager.setAdapter(myFragmentsAdapter);
        //创建点击事件
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                   switch (checkedId){
                           case R.id.radio_bun1 :
                               view_pager.setCurrentItem(0,false);
                               break;
                           case R.id.radio_bun2:
                               view_pager.setCurrentItem(1,false);
                           break;
                           case R.id.radio_bun3:
                               view_pager.setCurrentItem(2,false);
                           break;

                   }
            }
        });
    }*/
  /* //创建内部类
    class  MyFragmentsAdapter extends FragmentPagerAdapter{

       public MyFragmentsAdapter(FragmentManager fm) {
           super(fm);
       }
       @Override
       public Fragment getItem(int i) {
           return flist.get(i);
       }

       @Override
       public int getCount() {
           return flist.size();
       }

   }*/
