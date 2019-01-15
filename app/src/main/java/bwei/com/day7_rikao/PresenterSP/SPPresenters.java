package bwei.com.day7_rikao.PresenterSP;

import bwei.com.day7_rikao.Api.MyApi;
import bwei.com.day7_rikao.ModelSP.SPModels;
import bwei.com.day7_rikao.SPActivity;

public class SPPresenters   implements SPPresenterInterface,SPModels.SPModelInterface {
    SPActivity  spActivity;
    private final SPModels spModels;

    public SPPresenters(SPActivity spActivity) {
        this.spActivity = spActivity;
        spModels = new SPModels(this);
    }
    @Override
    public void GetSPModel(int cid) {
        spModels.getSPdata(MyApi.Shopxiang+"?commodityId="+cid);
    }
    @Override
    public void getsuccessful(String data) {
        spActivity.getSP(data);
    }
    @Override
    public void getfuil() {

    }
}
