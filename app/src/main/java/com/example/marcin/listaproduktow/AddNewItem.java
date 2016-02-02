package com.example.marcin.listaproduktow;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marcin.listaproduktow.data.Shop;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;
import org.springframework.util.StringUtils;

/**
 * Created by Marcin on 01.02.2016.
 */
@EActivity(R.layout.activity_add_item)
public class AddNewItem extends AppCompatActivity {

    @Bean
    @NonConfigurationInstance
    RestBackgroundAddTask restBackgroundAddTask;

    @RestService
    ShopListRestClient prc;

    @ViewById
    EditText name;

    @AfterViews
    void init() {

    }


    @Click
    void addShopItemClicked(){
        if(StringUtils.hasText(name.getText().toString()) == true ){

            Shop shop = new Shop();
            shop.name = name.getText().toString();
            shop.status = "new";

            restBackgroundAddTask.addShopItem(shop);


        } else{
            Toast.makeText(this, "Uzupełnij wymagane pola!", Toast.LENGTH_LONG).show();
        }
    }

    public void showSuccess(){
        Toast.makeText(this,"Dodano nowy produkt",Toast.LENGTH_LONG).show();
        MainActivity_.intent(this).start();
    }

    public void showError(Exception e){
        Toast.makeText(this, "Coś poszło nie tak :(\n" + e.getMessage(), Toast.LENGTH_LONG).show();
        e.printStackTrace();
    }
}
