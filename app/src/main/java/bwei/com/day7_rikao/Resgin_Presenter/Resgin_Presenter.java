package bwei.com.day7_rikao.Resgin_Presenter;

import bwei.com.day7_rikao.Api.MyApi;
import bwei.com.day7_rikao.Resgin_Activity;
import bwei.com.day7_rikao.Resgin_Model.Resgin_Model;

public class Resgin_Presenter implements Resgin_Presenter_Interface,Resgin_Model.Resgin_newInterface {
     Resgin_Activity  resgin_activity;
    private final Resgin_Model resgin_model;

    public Resgin_Presenter(Resgin_Activity resgin_activity) {
        this.resgin_activity = resgin_activity;
        resgin_model = new Resgin_Model(this);

    }

    @Override
    public void getModel_Resgn(String phone, String pwd) {
        resgin_model.getResginData(MyApi.SHOP_resign,phone,pwd);

    }
    @Override
    public void onStatus_Resgin(String data) {
        resgin_activity.getResgin(data);

    }

    @Override
    public void onFailed_Resgin() {

    }


}
