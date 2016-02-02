package com.example.marcin.listaproduktow;

/**
 * Created by Marcin on 01.02.2016.
 */
import com.example.marcin.listaproduktow.data.ShopList;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

@EBean
public class RestBackgroundTask {

    @RootContext
    MainActivity activity;

    @RestService
    ShopListRestClient restClient;

    @Background
    void getShopList() {
        try {
            restClient.setHeader("X-DreamFactory-Api-Key", "5fbd4c24e49371d5871619d34a2aa0860b9df5109158e513a598e6b3888ac550");
            ShopList shopList = restClient.getShopList();
            publishResult(shopList);
        } catch (Exception e) {
            publishError(e);
        }
    }


    @UiThread
    void publishResult(ShopList shopList) {
        activity.updateShoplist(shopList);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }

}

