package com.seago.loltrack.fonts;

import android.widget.TextView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

class RobotoBoldTextView extends TextView {

	public RobotoBoldTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public RobotoBoldTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public RobotoBoldTextView(Context context) {
		super(context);
		init();
	}

	private void init() {
		if (!isInEditMode()) {
			Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Bold.ttf");
			setTypeface(tf);
		}
	}

}
