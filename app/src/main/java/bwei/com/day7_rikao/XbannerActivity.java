package bwei.com.day7_rikao;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class XbannerActivity extends AppCompatActivity {

    private WebView web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xbanner);
        //初始化控件
        web_view = findViewById(R.id.web_view);
        Intent  intent=getIntent();
        String urls = intent.getStringExtra("urls");
        //设置web_view
        web_view.loadUrl(urls);
    }

}
