/**
 * Created by Dylan Seago on 27/01/14.
 *
 * Custom Card View element
 */
package com.seago.loltrack;

import android.app.Activity;
import android.view.View;

import com.afollestad.cardsui.CardAdapter;
import com.afollestad.cardsui.CardBase;

class LCardAdapter extends CardAdapter {

    public LCardAdapter(Activity context) {
        super(context);
    }

    @Override
    public View onViewCreated(int index, View recycled, CardBase item) {
        recycled = ((LCard) item).getCardContent(recycled);
        return super.onViewCreated(index, recycled, item);
    }

    public void add(LCard toAdd){
        registerLayout(toAdd.getLayout());
        registerLayout(toAdd.getContentLayout());
        super.add(toAdd);
    }
}