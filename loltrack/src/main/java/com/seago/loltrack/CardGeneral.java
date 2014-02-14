package com.seago.loltrack;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.seago.loltrack.CardsUI.CardBase;

class CardGeneral extends CardBase {
    private static final String DTAG = "CardGeneral";
    private LayoutAdapter layoutAdapter;

    public CardGeneral(int layoutId) {
        super(layoutId);
        Log.v(DTAG, "New CardGeneral with layoutId == " + layoutId);
    }

    public CardGeneral(int layoutId, LayoutAdapter layoutAdapter) {
        this(layoutId);
        this.layoutAdapter = layoutAdapter;
    }

    @Override
    public View getCardContent(View view) {
        // Sets all views to specified values
        if (layoutAdapter != null) {
            for (int i = 0; i < layoutAdapter.getViewCount() - 1; i++) {
                View v = layoutAdapter.getView(view, i);

                String value;
                // If the view isnt null (visible)
                if ((value = layoutAdapter.getViewValue(i)) != null) {
                    // If its a textView
                    if (v instanceof TextView) {
                        ((TextView) v).setText(value);
                    }
                    // If its an imageView
                    else if (v instanceof ImageView) {
                        try {
                            ((ImageView) v).setImageResource(Utils.getDrawableResource(value));
                        } catch (Exception e) {
                            v.setVisibility(View.INVISIBLE);
                        }
                    }
                }
                // If the view's value is null (gone)
                else {
                    v.setVisibility(View.GONE);
                }
            }
        }
        return view;
    }
}
