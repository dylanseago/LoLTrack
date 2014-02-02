/**
 * Created by Dylan Seago on 27/01/14.
 *
 * Custom Card View element
 */
package com.seago.loltrack;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;

import com.afollestad.cardsui.Card;
import com.afollestad.cardsui.CardBase;
import com.afollestad.cardsui.CardHeader;

public abstract class LCard implements CardBase<LCard> {

    private int contentLayout;
    private OnClickListener onClickListener = null;

    protected LCard(int contentLayout) {
        this.contentLayout = contentLayout;
    }

    protected LCard(int contentLayout, OnClickListener onClickListener) {
        this(contentLayout);
        this.onClickListener = onClickListener;
    }

    /**
     * Inflates the cards content layout
     */
    public abstract View getCardContent(View view) ;

    /**
     * @return The layout of the cards content
     */
    public int getLayout() {
        return contentLayout;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getContent() {
        return null;
    }

    @Override
    public boolean isHeader() {
        return false;
    }

    public OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    /**
     * Sets the onClickListener for this card.
     */
    public LCard setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    @Override
    public boolean isClickable() {
        return onClickListener != null;
    }

    @Override
    public int getPopupMenu() {
        // -1 indicates that the popup menu is disabled for this card
        return -1;
    }

    @Override
    public CardHeader.ActionListener getActionCallback() {
        return null;
    }

    @Override
    public String getActionTitle() {
        return null;
    }

    @Override
    public Card.CardMenuListener<LCard> getPopupListener() {
        return null;
    }

    @Override
    public Drawable getThumbnail() {
        return null;
    }

    @Override
    public Object getTag() {
        return null;
    }

    @Override
    public Object getSilkId() {
        return getLayout();
    }

    @Override
    public boolean equalTo(LCard other) {
        return this.getSilkId() == other.getSilkId();
    }
}
