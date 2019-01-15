package bwei.com.day7_rikao.Resgin_Model;

import java.io.IOException;

import bwei.com.day7_rikao.Utils.OKHttps;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Resgin_Model  implements Resgin_ModelInterface {

    Resgin_newInterface  resgin_newInterface;

    public Resgin_Model(Resgin_newInterface resgin_newInterface) {
        this.resgin_newInterface = resgin_newInterface;
    }

    @Override
    public void getResginData(String urls, String phone, String pwd) {
        OKHttps.OkHttpPost(urls, phone, pwd, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                resgin_newInterface.onFailed_Resgin();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                resgin_newInterface.onStatus_Resgin(response.body().string());
            }
        });
    }
    //自定义个接口
    public  interface   Resgin_newInterface{
        void onStatus_Resgin( String  data);
        void   onFailed_Resgin();
    }
}
