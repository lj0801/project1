package bwei.com.day7_rikao.ModelsQuan;

import java.io.IOException;

import bwei.com.day7_rikao.Utils.OKHttps;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ModelQuans   implements ModelQuanInterface {
    ModelQuanNewInterface  modelQuanNewInterface;

    public ModelQuans(ModelQuanNewInterface modelQuanNewInterface) {
        this.modelQuanNewInterface = modelQuanNewInterface;
    }


    @Override
    public void getquanshop(String urls) {

        OKHttps.getInstance().OkHttpget(urls, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                modelQuanNewInterface.getFails();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                modelQuanNewInterface.getSuccessful(response.body().string());
            }
        });
    }


    public   interface    ModelQuanNewInterface{
          void   getSuccessful(String  data);
          void   getFails();
    }
}
