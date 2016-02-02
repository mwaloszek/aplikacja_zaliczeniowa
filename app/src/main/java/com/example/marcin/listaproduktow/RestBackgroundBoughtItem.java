package com.example.marcin.listaproduktow;

import com.example.marcin.listaproduktow.data.ShopList;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

/**
 * Created by Marcin on 02.02.2016.
 */
@EBean
public class RestBackgroundBoughtItem {

    @RootContext
    BoughtItem activity;

    @RestService
    ShopListRestClient restClient;

    @Background
    void getShopListCompleted() {
        try {
            restClient.setHeader("X-DreamFactory-Api-Key", "5fbd4c24e49371d5871619d34a2aa0860b9df5109158e513a598e6b3888ac550");
            ShopList shop = restClient.getShopListCompleted();
            publishResult(shop);

        } catch (Exception e) {
            publishError(e);
        }
    }

    @UiThread
    void publishResult(ShopList shop) {
        activity.updateTaskList(shop);
    }

    @UiThread
    void publishError(Exception e) {
        activity.showError(e);
    }
}


