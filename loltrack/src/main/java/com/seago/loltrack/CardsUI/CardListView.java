package com.seago.loltrack.CardsUI;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.seago.loltrack.R;

/**
 * A {@link ListView} that automates many card related things, such as disabling the background list selector,
 * removing the list divider, and calling an ActionListener when tapped by the user.
 *
 * @author Aidan Follestad (afollestad), Dylan Seago
 */
public class CardListView extends ListView implements AdapterView.OnItemClickListener {

    public CardListView(Context context) {
        super(context);
        init(null);
    }

    public CardListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CardListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        setDivider(null);
        setDividerHeight(0);
        setSelector(android.R.color.transparent);
        super.setOnItemClickListener(this);

        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, new int[]{android.R.attr.background});
            if (a.length() > 0) {
                int color = a.getColor(0, 0);
                if (color == 0) setDefaultBackground();
                else {
                    setBackgroundColor(color);
                    setCacheColorHint(color);
                }
            } else setDefaultBackground();
        } else setDefaultBackground();
    }

    private void setDefaultBackground() {
        int gray = getResources().getColor(R.color.card_gray);
        setBackgroundColor(gray);
        setCacheColorHint(gray);
    }

    /**
     * @deprecated Use {@link #setAdapter(CardAdapter)} instead.
     */
    @Override
    public void setAdapter(ListAdapter adapter) {
        if (adapter instanceof CardAdapter) {
            setAdapter((CardAdapter) adapter);
            return;
        }
        throw new RuntimeException("The CardListView only accepts LCardAdapters.");
    }

    /**
     * Sets the list's adapter, enforces the use of only a CardAdapter, not any other type of adapter
     */
    public void setAdapter(CardAdapter adapter) {
        super.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Log.v("CardListView", "onItemClick");
        CardBase item = (CardBase) getAdapter().getItem(position);
        if (item.getCardClickListener() != null)
            item.getCardClickListener().onClick(position, item, view);
    }

    public interface CardClickListener {
        public void onClick(int index, CardBase card, View view);
    }
}

