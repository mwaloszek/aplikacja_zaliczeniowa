package com.example.marcin.listaproduktow;

/**
 * Created by Marcin on 01.02.2016.
 */
import com.example.marcin.listaproduktow.data.Shop;
import com.example.marcin.listaproduktow.data.ShopList;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.Put;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Rest(rootUrl = "http://kangur.wzr.pl:8080/api/v2",
        converters = { MappingJackson2HttpMessageConverter.class })
@RequiresHeader({"X-DreamFactory-Api-Key"})
public interface ShopListRestClient extends RestClientHeaders {

    @Get("/db/_table/note?filter=status=new")
    ShopList getShopList();

    @Get("/db/_table/note?filter=status=completed")
    ShopList getShopListCompleted();

    @Get("/db/_table/note/{id}")
    Shop getSingleItem(int id);

    @Put("/db/_table/note/{id}")
    void updateItem(int id, Shop shop);

    @Post("/db/_table/note")
    void addShopItem(Shop shop);

}

