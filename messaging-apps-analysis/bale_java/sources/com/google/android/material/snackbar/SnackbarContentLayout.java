package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.InterfaceC22153ul1;
import ir.nasim.WB5;
import ir.nasim.WU3;

/* loaded from: classes3.dex */
public class SnackbarContentLayout extends LinearLayout implements InterfaceC22153ul1 {
    private TextView a;
    private Button b;
    private int c;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    private static void d(View view, int i, int i2) {
        if (AbstractC12990fW7.V(view)) {
            AbstractC12990fW7.F0(view, AbstractC12990fW7.F(view), i, AbstractC12990fW7.E(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    private boolean e(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.a.getPaddingTop() == i2 && this.a.getPaddingBottom() == i3) {
            return z;
        }
        d(this.a, i2, i3);
        return true;
    }

    @Override // ir.nasim.InterfaceC22153ul1
    public void a(int i, int i2) {
        this.a.setAlpha(0.0f);
        long j = i2;
        long j2 = i;
        this.a.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(0.0f);
            this.b.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    @Override // ir.nasim.InterfaceC22153ul1
    public void b(int i, int i2) {
        this.a.setAlpha(1.0f);
        long j = i2;
        long j2 = i;
        this.a.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.b.getVisibility() == 0) {
            this.b.setAlpha(1.0f);
            this.b.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    void c(float f) {
        if (f != 1.0f) {
            this.b.setTextColor(WU3.h(WU3.d(this, AbstractC12181eA5.colorSurface), this.b.getCurrentTextColor(), f));
        }
    }

    public Button getActionView() {
        return this.b;
    }

    public TextView getMessageView() {
        return this.a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(WB5.snackbar_text);
        this.b = (Button) findViewById(WB5.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) throws Resources.NotFoundException {
        super.onMeasure(i, i2);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(AbstractC12799fB5.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(AbstractC12799fB5.design_snackbar_padding_vertical);
        boolean z = this.a.getLayout().getLineCount() > 1;
        if (!z || this.c <= 0 || this.b.getMeasuredWidth() <= this.c) {
            if (!z) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!e(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!e(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setMaxInlineActionWidth(int i) {
        this.c = i;
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
