package bwei.com.day7_rikao.Presenter;

import bwei.com.day7_rikao.Api.MyApi;
import bwei.com.day7_rikao.Fragments.Nei_Fragments;
import bwei.com.day7_rikao.LoginActivity;
import bwei.com.day7_rikao.Model.MyModel;

public class MyPresenter  implements   PresenterInterface,MyModel.LoginCallBack {
    LoginActivity  loginActivity;
    Nei_Fragments   nei_fragments;
    private final MyModel myModel;
    public MyPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        myModel = new MyModel(this);
    }
    public MyPresenter(Nei_Fragments nei_fragments) {
        this.nei_fragments = nei_fragments;
        myModel = new MyModel(this);
    }
    @Override
    public void getModel(String name, String pwsd) {
        myModel.getModel(MyApi.SHOP_login,name,pwsd);
    }

    @Override
    public void getModellist() {
        myModel.getModellist(MyApi.SHOP_list);
    }

    @Override
    public void onStatus(String data) {
        loginActivity.getviewdata(data);
    }
    @Override
    public void onFailed() {

    }

    @Override
    public void onlist(String ss) {
        nei_fragments.getviewlist(ss);
    }
}
