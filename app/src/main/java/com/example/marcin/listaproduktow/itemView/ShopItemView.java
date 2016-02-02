package com.example.marcin.listaproduktow.itemView;

/**
 * Created by Marcin on 01.02.2016.
 */
import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.marcin.listaproduktow.R;
import com.example.marcin.listaproduktow.data.Shop;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.list_item)
public class ShopItemView extends RelativeLayout {


    @ViewById
    ImageView acronym;

    @ViewById
    TextView name;

    @ViewById
    TextView status;

    public ShopItemView(Context context) {
        super(context);
    }

    public void bind(Shop shop) {
        name.setText(shop.name);
        status.setText(shop.status);

    }

}
