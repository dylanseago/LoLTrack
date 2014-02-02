package com.seago.loltrack;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CardGeneral extends LCard {
	private static final String			DTAG	= "CardGeneral";
	private ArrayList<ResourceValueMap>	viewValueMap;

	public CardGeneral(int layoutId, ArrayList<ResourceValueMap> viewValueMap) {
        super(layoutId);
		Log.v(DTAG, "New CardGeneral with layoutId == " + layoutId);
		this.viewValueMap = viewValueMap;
	}

	@Override
    public View getCardContent(View view) {
		// Sets all views to specified values
        for (ResourceValueMap aViewValueMap : viewValueMap) {
            View v;
            // If the view is embedded in another layout, find that view
            if (aViewValueMap.getLayoutId() != null) {
                v = view.findViewById(aViewValueMap.getLayoutId());
            } else {
                v = view;
            }

            // If the view isnt null (visible)
            if (aViewValueMap.getValue() != null) {
                // Temp object used for comparing its type
                View temp = v.findViewById(aViewValueMap.getResourceId());
                // If its a textView
                if (temp instanceof TextView) {
                    ((TextView) temp).setText(aViewValueMap.getValue());
                }
                // If its an imageView
                else if (temp instanceof ImageView) {
                    try {
                        ((ImageView) temp).setImageResource(Utils.getDrawableResource(aViewValueMap.getValue()));
                    } catch (Exception e) {
                        temp.setVisibility(View.INVISIBLE);
                    }
                }
            }
            // If the view is null (gone)
            else {
                v.findViewById(aViewValueMap.getResourceId()).setVisibility(View.GONE);
            }
        }
		return view;
	}
}
