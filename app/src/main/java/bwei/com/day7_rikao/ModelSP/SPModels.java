package bwei.com.day7_rikao.ModelSP;

import java.io.IOException;

import bwei.com.day7_rikao.Utils.OKHttps;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SPModels  implements SPModelInterface {
    SPModelInterface   spModelInterface;

    public SPModels(SPModelInterface spModelInterface) {
        this.spModelInterface = spModelInterface;
    }

    @Override
    public void getSPdata(String url) {

        OKHttps.getInstance().OkHttpget(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                spModelInterface.getfuil();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                spModelInterface.getsuccessful(response.body().string());
            }
        });

    }
    public   interface    SPModelInterface{
            void    getsuccessful(String  data);
            void    getfuil();
    }
}
