package bwei.com.day7_rikao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import bwei.com.day7_rikao.Bean.PostBean;
import bwei.com.day7_rikao.Presenter.MyPresenter;
import bwei.com.day7_rikao.View.ViewInterface;

public class LoginActivity extends AppCompatActivity    implements ViewInterface {
    private Button bun_login;
    private Button bun_resgin;
    private EditText edit_name;
    private EditText edit_pwd;
    private CheckBox check_rummber;
    private CheckBox check_action;
    private MyPresenter myPresenter;
    private String name;
    private String pwd;
    private   int  main;
    private String status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createinits();
        creaetedatas();
    }
    private void createinits() {
        //初始化控件
        bun_login = findViewById(R.id.bun_login);
        bun_resgin = findViewById(R.id.bun_resgin);
        edit_name = findViewById(R.id.edit_name);
        edit_pwd = findViewById(R.id.edit_pwd);
        check_rummber = findViewById(R.id.check_rummber);
        check_action = findViewById(R.id.check_action);
    }
    private void creaetedatas() {
        //创建实例化
        myPresenter = new MyPresenter(this);
        //创建点击事件
        bun_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //拿取输入的值
                name = edit_name.getText().toString();
                pwd = edit_pwd.getText().toString();
             //   Toast.makeText(LoginActivity.this,""+name+pwd,Toast.LENGTH_SHORT).show();
                //判断
                if(!name.isEmpty()&&!pwd.isEmpty()){
                    //调用构造方法
                    myPresenter.getModel(name,pwd);
                }
                else{
                    Toast.makeText(LoginActivity.this,"您输入的信息有误",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //创建点击跳转事件
        bun_resgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent  intent=new Intent(LoginActivity.this,Resgin_Activity.class);
              startActivity(intent);
            }
        });
    }
    @Override
    public void getviewdata(String message) {
            //进行酒叟gson解析
        Gson  gson=new Gson() ;
        PostBean postBean = gson.fromJson(message, PostBean.class);
        status = postBean.getStatus();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(status.equals("0000")){
                    //跳转页面
                    Intent  intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"您输入的信息不正确",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void getviewlist(String ss) {
    }
}
