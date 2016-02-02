package com.example.marcin.listaproduktow.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.marcin.listaproduktow.data.Shop;
import com.example.marcin.listaproduktow.data.ShopList;
import com.example.marcin.listaproduktow.itemView.ShopItemView;
import com.example.marcin.listaproduktow.itemView.ShopItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 01.02.2016.
 */
@EBean
public class ShopListAdapter extends BaseAdapter {

    @RootContext
    Context context;

    List<Shop> shops = new ArrayList<Shop>();

    @Override
    public int getCount() {
        return shops.size();
    }

    @Override
    public Shop getItem(int i) {
        return shops.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ShopItemView personItemView;
        if (convertView == null) {
            personItemView = ShopItemView_.build(context);
        } else {
            personItemView = (ShopItemView) convertView;
        }

        personItemView.bind(getItem(position));
        return personItemView;

    }

    public void update(ShopList shopList) {
        shops.clear();
        shops.addAll(shopList.records);
        notifyDataSetChanged();
    }


}





