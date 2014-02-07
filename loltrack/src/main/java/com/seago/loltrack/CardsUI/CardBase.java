/**
 * Created by Dylan Seago on 27/01/14.
 *
 * Custom Card View element
 */
package com.seago.loltrack.CardsUI;

import android.view.View;
import android.view.View.OnClickListener;

import com.afollestad.silk.caching.SilkComparable;

public abstract class CardBase implements SilkComparable<CardBase> {

    private int contentLayout;
    private OnClickListener onClickListener = null;

    protected CardBase(int contentLayout) {
        this.contentLayout = contentLayout;
    }

    protected CardBase(int contentLayout, OnClickListener onClickListener) {
        this(contentLayout);
        this.onClickListener = onClickListener;
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

    public OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    /**
     * Sets the onClickListener for this card.
     */
    public CardBase setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    public boolean isClickable() {
        return onClickListener != null;
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
