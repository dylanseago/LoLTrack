package com.seago.loltrack.fonts;

import android.widget.TextView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class RobotoLightTextView extends TextView {

	public RobotoLightTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public RobotoLightTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public RobotoLightTextView(Context context) {
		super(context);
		init();
	}

	private void init() {
		if (!isInEditMode()) {
			Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Light.ttf");
			setTypeface(tf);
		}
	}

}
