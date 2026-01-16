package com.google.maps.android.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes3.dex */
public class SquareTextView extends TextView {
    private int a;
    private int b;

    public SquareTextView(Context context) {
        super(context);
        this.a = 0;
        this.b = 0;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.translate(this.b / 2, this.a / 2);
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int iMax = Math.max(measuredWidth, measuredHeight);
        if (measuredWidth > measuredHeight) {
            this.a = measuredWidth - measuredHeight;
            this.b = 0;
        } else {
            this.a = 0;
            this.b = measuredHeight - measuredWidth;
        }
        setMeasuredDimension(iMax, iMax);
    }

    public SquareTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 0;
    }

    public SquareTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
    }
}
