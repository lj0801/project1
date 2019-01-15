package bwei.com.day7_rikao.Model;

import java.io.IOException;

import bwei.com.day7_rikao.Utils.OKHttps;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyModel  implements  ModelInterface {
    LoginCallBack loginCallBack;
    public MyModel(LoginCallBack loginCallBack) {
        this.loginCallBack = loginCallBack;
    }
    @Override
    public void getModel(final String  url,final  String name,final String pwd) {
        OKHttps.OkHttpPost(url, name, pwd, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                loginCallBack.onFailed();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                loginCallBack.onStatus(response.body().string());
            }
        });
    }

    @Override
    public void getModellist(String datas) {
        OKHttps.OkHttpget(datas, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                loginCallBack.onlist(response.body().string());
            }
        });
    }

    //自定义一个接口
    public   interface    LoginCallBack{
        void onStatus( String  data);
        void   onFailed();
        void onlist( String  ss);
    }
}
