/**
 * Created by Dylan Seago on 27/01/14.
 *
 * Custom Card View element
 */
package com.seago.loltrack;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.afollestad.cardsui.Card;
import com.afollestad.cardsui.CardBase;
import com.afollestad.cardsui.CardHeader;

public abstract class LCard implements CardBase<LCard> {

    private boolean isClickable;
    private int mLayout;

    public LCard(int layout) {
        mLayout = layout;
    }

    public abstract View getCardContent(View v) ;

    @Override
    public int getLayout() {
        return mLayout;
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

    /**
     * Sets whether or not the card is clickable, setting it to false will turn the card's list selector off
     * and the list's OnItemClickListener will not be called.
     * <p/>
     * This <b>does not</b> override the isClickable value set to a {@link LCardAdapter}, however.
     */
    public LCard setClickable(boolean clickable) {
        isClickable = clickable;
        return this;
    }

    @Override
    public boolean isClickable() {
        // The card will not respond to being tapped
        return isClickable;
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
        return mLayout;
    }

    @Override
    public boolean equalTo(LCard other) {
        return mLayout == other.mLayout;
    }
}
