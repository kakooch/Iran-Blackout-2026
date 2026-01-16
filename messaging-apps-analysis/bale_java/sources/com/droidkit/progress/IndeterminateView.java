package com.droidkit.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes2.dex */
public class IndeterminateView extends View {
    private int a;
    private int b;
    private int c;
    private int d;
    private RectF e;
    private Paint f;
    private Paint g;

    public IndeterminateView(Context context) {
        super(context);
        this.c = -12219667;
        this.d = -4665872;
        this.e = new RectF();
        this.f = new Paint();
        this.g = new Paint();
        a();
    }

    private void a() {
        int i = (int) (getResources().getDisplayMetrics().density * 4.0f);
        this.a = i;
        this.b = i / 2;
        this.f.setColor(this.c);
        this.g.setColor(this.d);
    }

    private float b(double d) {
        return ((float) (Math.sin(d * 6.283185307179586d) + 1.0d)) / 2.0f;
    }

    public int getBackgroundColor() {
        return this.d;
    }

    public int getColor() {
        return this.c;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int height = (getHeight() - this.a) / 2;
        int width = getWidth();
        float f = height;
        float f2 = width;
        canvas.drawRect(0.0f, f, f2, this.a + height, this.g);
        long j = width * 3;
        int iCurrentTimeMillis = ((int) (((System.currentTimeMillis() % 1600) * j) / 1600.0f)) - width;
        int iCurrentTimeMillis2 = ((int) ((((System.currentTimeMillis() + 533) % 1600) * j) / 1600.0f)) - width;
        float f3 = f2 * 0.5f;
        int iB = ((int) (b((System.currentTimeMillis() % 1100) / 1100.0f) * f3)) + (this.a * 2);
        int iB2 = ((int) (b(((System.currentTimeMillis() + 366) % 1100) / 1100.0f) * f3)) + (this.a * 2);
        int iB3 = (int) (f3 * b(((System.currentTimeMillis() + 733) % 1100) / 1100.0f));
        int i = this.a;
        this.e.set(iCurrentTimeMillis, f, iCurrentTimeMillis + iB, i + height);
        RectF rectF = this.e;
        int i2 = this.b;
        canvas.drawRoundRect(rectF, i2, i2, this.f);
        this.e.set(iCurrentTimeMillis2, f, iCurrentTimeMillis2 + iB2, this.a + height);
        RectF rectF2 = this.e;
        int i3 = this.b;
        canvas.drawRoundRect(rectF2, i3, i3, this.f);
        this.e.set(((int) ((j * ((System.currentTimeMillis() + 1066) % 1600)) / 1600.0f)) - width, f, r1 + iB3 + (i * 2), height + this.a);
        RectF rectF3 = this.e;
        int i4 = this.b;
        canvas.drawRoundRect(rectF3, i4, i4, this.f);
        postInvalidateOnAnimation();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.getSize(i) : (int) (getResources().getDisplayMetrics().density * 100.0f);
        int mode2 = View.MeasureSpec.getMode(i2);
        setMeasuredDimension(size, mode2 != Integer.MIN_VALUE ? mode2 != 1073741824 ? this.a : View.MeasureSpec.getSize(i2) : Math.min(this.a, View.MeasureSpec.getSize(i2)));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.d = i;
        this.g.setColor(i);
    }

    public void setColor(int i) {
        this.c = i;
        this.f.setColor(i);
    }

    public IndeterminateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -12219667;
        this.d = -4665872;
        this.e = new RectF();
        this.f = new Paint();
        this.g = new Paint();
        a();
    }

    public IndeterminateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = -12219667;
        this.d = -4665872;
        this.e = new RectF();
        this.f = new Paint();
        this.g = new Paint();
        a();
    }
}
