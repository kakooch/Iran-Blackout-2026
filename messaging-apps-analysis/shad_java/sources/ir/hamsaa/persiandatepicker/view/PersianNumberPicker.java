package ir.hamsaa.persiandatepicker.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;

/* loaded from: classes3.dex */
public class PersianNumberPicker extends NumberPicker {
    public PersianNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        updateView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        updateView(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        updateView(view);
    }

    public void setTypeFace(Typeface typeface) {
        super.invalidate();
    }

    private void updateView(View view) {
        Typeface typeface;
        if (!(view instanceof TextView) || (typeface = PersianDatePickerDialog.typeFace) == null) {
            return;
        }
        ((TextView) view).setTypeface(typeface);
    }
}
