package ir.resaneh1.iptv.helper.datePicker;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

/* loaded from: classes3.dex */
public class CustomNumberPicker extends NumberPicker {
    Typeface type;

    public CustomNumberPicker(Context context, AttributeSet attributeSet) {
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
        this.type = Typeface.createFromAsset(getContext().getAssets(), "fonts/iranyekanwebregular.ttf");
        updateView(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        this.type = Typeface.createFromAsset(getContext().getAssets(), "fonts/iranyekanwebregular.ttf");
        updateView(view);
    }

    private void updateView(View view) {
        if (view instanceof EditText) {
            ((EditText) view).setTypeface(this.type);
        }
    }
}
