/**
 * Created by Dylan Seago on 27/01/14.
 *
 * Custom Card View element
 */
package com.seago.loltrack;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.cardsui.Card;
import com.afollestad.cardsui.CardBase;
import com.afollestad.silk.adapters.SilkAdapter;

class LCardAdapter extends SilkAdapter<LCard> {

    private final int EMPTY_CARD = R.layout.card_empty;
    private final SparseIntArray mViewTypes;
    private boolean mCardsClickable = true;

    public LCardAdapter(Activity context) {
        super(context);
        mViewTypes = new SparseIntArray();
        registerLayout(EMPTY_CARD);
    }

    @Override
    public View onViewCreated(int index, View recycled, LCard item) {
        recycled = item.getCardContent(recycled);
        invalidatePadding(index, recycled);
        return recycled;
    }

    public final int getLayout(int index) {
        return getLayout(index, -1);
    }

    @Override
    public final int getLayout(int index, int type) {
        return getItem(index).getLayout();
    }

    @SuppressWarnings("deprecation")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            // Inflate empty card
            view = LayoutInflater.from(getContext()).inflate(EMPTY_CARD, null);
            // Inflate content of card
            View child = LayoutInflater.from(getContext()).inflate(getLayout(i), null);
            ((ViewGroup) view).addView(child, 0);
        }
        return onViewCreated(i, view, getItem(i));
    }

    public void add(LCard toAdd){
        registerLayout(toAdd.getLayout());
        super.add(toAdd);
    }

    public static void setupTouchDelegate(Context context, final View menu) {
        final int offset = context.getResources().getDimensionPixelSize(com.afollestad.cardsui.R.dimen.card_action_touchdelegate);
        assert menu.getParent() != null;
        ((View) menu.getParent()).post(new Runnable() {
            public void run() {
                Rect delegateArea = new Rect();
                menu.getHitRect(delegateArea);
                delegateArea.top -= offset;
                delegateArea.bottom += offset;
                delegateArea.left -= offset;
                delegateArea.right += offset;
                TouchDelegate expandedArea = new TouchDelegate(delegateArea, menu);
                ((View) menu.getParent()).setTouchDelegate(expandedArea);
            }
        });
    }

    @Override
    public final boolean isEnabled(int position) {
        LCard item = getItem(position);
        return mCardsClickable && item.isClickable();
    }

    /**
     * Sets whether or not cards in the adapter are clickable, setting it to false will turn card's list selectors off
     * and the list's OnItemClickListener will not be called. This <b>will</b> override individual isClickable values
     * set to {@link Card}s.
     */
    public final LCardAdapter setCardsClickable(boolean clickable) {
        mCardsClickable = clickable;
        return this;
    }

    private void invalidatePadding(int index, View view) {
        int top = index == 0 ? com.afollestad.cardsui.R.dimen.card_outer_padding_firstlast : com.afollestad.cardsui.R.dimen.card_outer_padding_top;
        int bottom = index == (getCount() - 1) ? com.afollestad.cardsui.R.dimen.card_outer_padding_firstlast : com.afollestad.cardsui.R.dimen.card_outer_padding_bottom;
        view.setPadding(view.getPaddingLeft(),
                getContext().getResources().getDimensionPixelSize(top),
                view.getPaddingRight(),
                getContext().getResources().getDimensionPixelSize(bottom));
    }

    @Override
    public Object getItemId(LCard item) {
        return item.getSilkId();
    }

    /**
     * Registers a custom layout in the adapter, that isn't one of the default layouts, and that was passed in the adapter's constructor.
     * <p/>
     * This must be used if you override getLayout() and specify custom layouts for certain list items.
     */
    public final LCardAdapter registerLayout(int layoutRes) {
        if(mViewTypes.get(layoutRes, -1) == -1) {
            mViewTypes.put(layoutRes, mViewTypes.size());
        }
        return this;
    }

    @Override
    public final int getItemViewType(int position) {
        CardBase item = getItem(position);
        if (mViewTypes.get(item.getLayout(), -1) != -1)
            return mViewTypes.get(item.getLayout());
        String name = getContext().getResources().getResourceName(item.getLayout());
        throw new RuntimeException("The layout " + name + " is not registered.");
    }
}