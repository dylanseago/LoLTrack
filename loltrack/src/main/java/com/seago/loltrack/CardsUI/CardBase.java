/**
 * Created by Dylan Seago on 27/01/14.
 *
 * Custom Card View element
 */
package com.seago.loltrack.CardsUI;

import android.view.View;
import com.seago.loltrack.CardsUI.CardListView.CardClickListener;

import com.afollestad.silk.caching.SilkComparable;

public abstract class CardBase implements SilkComparable<CardBase> {

    private int contentLayout;
    private CardClickListener cardClickListener = null;

    public CardBase(int contentLayout) {
        this.contentLayout = contentLayout;
    }

    public CardBase(int contentLayout, CardClickListener cardClickListener) {
        this(contentLayout);
        this.cardClickListener = cardClickListener;
    }

    /**
     * Handles setting up views after layout inflation
     */
    public abstract View getCardContent(View view) ;

    /**
     * @return The layout of the cards content
     */
    public int getLayout() {
        return contentLayout;
    }

    public CardClickListener getCardClickListener() {
        return this.cardClickListener;
    }

    /**
     * Sets the cardClickListener for this card.
     */
    public CardBase setCardClickListener(CardClickListener cardClickListener) {
        this.cardClickListener = cardClickListener;
        return this;
    }

    public boolean isClickable() {
        return cardClickListener != null;
    }

    @Override
    public Object getSilkId() {
        return getLayout();
    }

    @Override
    public boolean equalTo(CardBase other) {
        return this.getSilkId() == other.getSilkId();
    }
}
