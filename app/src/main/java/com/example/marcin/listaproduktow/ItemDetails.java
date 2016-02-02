package com.example.marcin.listaproduktow;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marcin.listaproduktow.data.Shop;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Marcin on 01.02.2016.
 */
@EActivity(R.layout.activity_item_details)
public class ItemDetails extends AppCompatActivity {

    @Extra
    Shop shop;

    @ViewById
    TextView name;

    @ViewById
    TextView status;

    @Bean
    @NonConfigurationInstance
    RestBackgroundItemDetails restBackgroundItemDetails;

    @AfterViews
    void init()
    {
        restBackgroundItemDetails.getSingleItem();
    }

    void assignItem(Shop shop)
    {
        name.setText(shop.name);
        status.setText(shop.status);
    }
    public void showError(Exception e){

        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();

    }
    @Click
    public void update()
    {
        Shop shop = new Shop();
        shop.status = "completed";
        shop.name = name.getText().toString();
        restBackgroundItemDetails.updateStatus(shop);
        Toast.makeText(this, shop.name + " kupiono!", Toast.LENGTH_LONG).show();
        MainActivity_.intent(this).start();
    }

    @Click
    public void delete()
    {
        Shop shop = new Shop();
        shop.status = "deleted";
        shop.name = name.getText().toString();
        restBackgroundItemDetails.updateStatus(shop);
        Toast.makeText(this, shop.name + " usunięto!", Toast.LENGTH_LONG).show();
        MainActivity_.intent(this).start();
    }
}