package bwei.com.day7_rikao.PresentersQuan;

import bwei.com.day7_rikao.Api.MyApi;
import bwei.com.day7_rikao.Fragments.BenFragments;
import bwei.com.day7_rikao.ModelsQuan.ModelQuans;

public class PresenterQuan  implements PresenterQuanInterface,ModelQuans.ModelQuanNewInterface {
    BenFragments  benFragments;
    private final ModelQuans modelQuans;

    public PresenterQuan(BenFragments benFragments) {
        this.benFragments = benFragments;
        modelQuans = new ModelQuans(this);
    }

    @Override
    public void getQuanModel(int page,int  count) {
        modelQuans.getquanshop(MyApi.GetQuanShop+"?page="+page+"&count="+count);

    }

    @Override
    public void getSuccessful(String data) {
        benFragments.getdata(data);
    }

    @Override
    public void getFails() {

    }


}
