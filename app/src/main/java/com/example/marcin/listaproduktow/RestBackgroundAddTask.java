package com.example.marcin.listaproduktow;
import com.example.marcin.listaproduktow.data.Shop;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;

/**
 * Created by Marcin on 01.02.2016.
 */
@EBean
public class RestBackgroundAddTask {

    @RootContext
    AddNewItem activity;

    @RestService
    ShopListRestClient restClient;

    @UiThread
    void publishSuccess(){activity.showSuccess(); }
    @UiThread
    void publishError(Exception e){activity.showError(e);}

    @Background
    public void addShopItem(Shop shop){
        try
        {
            restClient.setHeader("X-DreamFactory-Api-Key", "5fbd4c24e49371d5871619d34a2aa0860b9df5109158e513a598e6b3888ac550");
            restClient.addShopItem(shop);
            publishSuccess();
        }
        catch(Exception e)
        {
            publishError(e);
        }

    }


}
