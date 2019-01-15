package bwei.com.day7_rikao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import bwei.com.day7_rikao.Bean.ResginBean;
import bwei.com.day7_rikao.Resgin_Presenter.Resgin_Presenter;
import bwei.com.day7_rikao.Resgin_View.Resgin_View_Interface;

public class Resgin_Activity extends AppCompatActivity implements Resgin_View_Interface {

    private EditText edit_phong;
    private EditText edit_login;
    private EditText edit_yan;
    private Button bun_resgin_login;
    private String status;
    private Resgin_Presenter presenter;
    private String phone;
    private String pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgin_);
        //创建初始化控件
        createResginInit();
        presenter = new Resgin_Presenter(this);
        //创建点击事件
        bun_resgin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = edit_phong.getText().toString();
                pwd = edit_login.getText().toString();
                if(!phone.isEmpty()&&!pwd.isEmpty()){
                    presenter.getModel_Resgn(phone,pwd);
                }else{
                    Toast.makeText(Resgin_Activity.this,"您输入的信息不正确",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void createResginInit() {
        edit_phong = findViewById(R.id.edit_resgin_phone);
        edit_login = findViewById(R.id.edit_resgin_login);
        edit_yan = findViewById(R.id.edit_resgin_yan);
        bun_resgin_login = findViewById(R.id.resgin_login);
    }

    @Override
    public void getResgin(String datas) {
        Gson  gson=new Gson();
        ResginBean resginBean = gson.fromJson(datas, ResginBean.class);
        status = resginBean.getStatus();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                     if(status.equals("1001")){
                         Toast.makeText(Resgin_Activity.this,"该手机已注册",Toast.LENGTH_SHORT).show();
                     }else{
                         Intent  intent=new Intent(Resgin_Activity.this,MainActivity.class);
                         startActivity(intent);
                     }
            }
        });
    }
}
