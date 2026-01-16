package com.droidkit.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import ir.nasim.ZU3;

/* loaded from: classes2.dex */
public class CircularView extends View {
    private static int l = -12744461;
    private Interpolator a;
    private int b;
    private int c;
    private boolean d;
    private Paint e;
    private int f;
    private int g;
    private long h;
    private float i;
    private float j;
    private float k;

    public CircularView(Context context) {
        super(context);
        this.a = new ZU3();
        this.d = true;
        this.e = new Paint();
        this.f = 100;
        this.g = 0;
        this.h = 0L;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        a();
    }

    private void a() {
        this.c = l;
        this.b = (int) (getResources().getDisplayMetrics().density * 3.0f);
        this.e.setAntiAlias(true);
        this.e.setColor(l);
        this.e.setStrokeWidth(this.b);
    }

    public int getColor() {
        return this.c;
    }

    public int getMaxValue() {
        return this.f;
    }

    public int getStrokeWidth() {
        return this.b;
    }

    public int getValue() {
        return this.g;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        int width = (getWidth() - (this.b * 4)) / 2;
        int width2 = getWidth() / 2;
        int height = getHeight() / 2;
        double dUptimeMillis = this.d ? ((SystemClock.uptimeMillis() % 1600) * 6.283185307179586d) / 1600.0d : -1.5707963267948966d;
        long jUptimeMillis = SystemClock.uptimeMillis() - this.h;
        if (jUptimeMillis < 300) {
            float interpolation = this.a.getInterpolation(jUptimeMillis / 300.0f);
            float f = this.j;
            this.i = f + ((this.k - f) * interpolation);
            z = true;
        } else {
            this.i = this.k;
            z = false;
        }
        double d = this.i * 2.0f * 3.141592653589793d;
        float f2 = width;
        float fCos = ((float) Math.cos(dUptimeMillis)) * f2;
        float fSin = ((float) Math.sin(dUptimeMillis)) * f2;
        double d2 = dUptimeMillis + d;
        float fCos2 = ((float) Math.cos(d2)) * f2;
        float fSin2 = ((float) Math.sin(d2)) * f2;
        this.e.setStyle(Paint.Style.FILL);
        float f3 = width2;
        float f4 = height;
        boolean z2 = z;
        canvas.drawCircle(fCos + f3, f4 + fSin, this.b >> 1, this.e);
        canvas.drawCircle(f3 + fCos2, f4 + fSin2, this.b >> 1, this.e);
        this.e.setStyle(Paint.Style.STROKE);
        canvas.drawArc(new RectF(width2 - width, height - width, width2 + width, height + width), (float) ((dUptimeMillis * 180.0d) / 3.141592653589793d), (float) ((180.0d * d) / 3.141592653589793d), false, this.e);
        if (z2 || this.d) {
            postInvalidateOnAnimation();
        }
    }

    public void setColor(int i) {
        this.c = i;
        this.e.setColor(i);
    }

    public void setMaxValue(int i) {
        this.f = i;
        invalidate();
    }

    public void setStrokeWidth(int i) {
        this.b = i;
        invalidate();
    }

    public void setUseRotation(boolean z) {
        this.d = z;
    }

    public void setValue(int i) {
        this.g = i;
        this.h = SystemClock.uptimeMillis();
        this.j = this.i;
        this.k = i / this.f;
        invalidate();
    }

    public CircularView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ZU3();
        this.d = true;
        this.e = new Paint();
        this.f = 100;
        this.g = 0;
        this.h = 0L;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        a();
    }

    public CircularView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ZU3();
        this.d = true;
        this.e = new Paint();
        this.f = 100;
        this.g = 0;
        this.h = 0L;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        a();
    }
}
