package com.example.marcin.listaproduktow;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.marcin.listaproduktow.adapter.ShopListAdapter;
import com.example.marcin.listaproduktow.data.Shop;
import com.example.marcin.listaproduktow.data.ShopList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Marcin on 02.02.2016.
 */
@EActivity(R.layout.lista_item_completed)
@OptionsMenu(R.menu.lista)
public class BoughtItem extends AppCompatActivity {

    @ViewById
    ListView list;

    @Bean
    ShopListAdapter adapter;

    @Bean
    @NonConfigurationInstance
    RestBackgroundBoughtItem restBackgroundTask;

    ProgressDialog ringProgressDialog;


    @AfterViews
    void init() {
        list.setAdapter(adapter);
        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setMessage("Trwa ładowanie. Poczekaj!");
        ringProgressDialog.setIndeterminate(true);
        restBackgroundTask.getShopListCompleted();
        ringProgressDialog.dismiss();
    }


    @Click
    void refreshClicked() {
        ringProgressDialog.show();
        restBackgroundTask.getShopListCompleted();
    }

    @ItemClick
    void listItemClicked(Shop shop) {
        BoughtItemDetails_.intent(this).shop(shop).start();
    }

    public void updateTaskList(ShopList shopList) {
        ringProgressDialog.dismiss();
        adapter.update(shopList);
    }

    public void showError(Exception e) {
        ringProgressDialog.dismiss();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
}
