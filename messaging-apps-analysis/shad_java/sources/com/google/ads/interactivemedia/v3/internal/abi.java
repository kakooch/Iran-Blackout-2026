package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class abi extends FrameLayout {
    private final abh a;
    private float b;
    private final int c;

    public abi(Context context) {
        super(context, null);
        this.c = 0;
        this.a = new abh(this);
    }

    public final void a(float f) {
        if (this.b != f) {
            this.b = f;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = measuredWidth;
        float f2 = measuredHeight;
        float f3 = f / f2;
        float f4 = (this.b / f3) - 1.0f;
        if (Math.abs(f4) <= 0.01f) {
            this.a.a(this.b, f3, false);
            return;
        }
        if (f4 > 0.0f) {
            measuredHeight = (int) (f / this.b);
        } else {
            measuredWidth = (int) (f2 * this.b);
        }
        this.a.a(this.b, f3, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }
}
