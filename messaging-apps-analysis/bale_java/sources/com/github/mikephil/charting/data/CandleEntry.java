package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public class CandleEntry extends Entry {
    private float e;
    private float f;
    private float g;
    private float h;

    public CandleEntry(float f, float f2, float f3, float f4, float f5) {
        super(f, (f2 + f3) / 2.0f);
        this.e = f2;
        this.f = f3;
        this.h = f4;
        this.g = f5;
    }

    public float getBodyRange() {
        return Math.abs(this.h - this.g);
    }

    public float getClose() {
        return this.g;
    }

    public float getHigh() {
        return this.e;
    }

    public float getLow() {
        return this.f;
    }

    public float getOpen() {
        return this.h;
    }

    public float getShadowRange() {
        return Math.abs(this.e - this.f);
    }

    @Override // com.github.mikephil.charting.data.BaseEntry
    public float getY() {
        return super.getY();
    }

    public void setClose(float f) {
        this.g = f;
    }

    public void setHigh(float f) {
        this.e = f;
    }

    public void setLow(float f) {
        this.f = f;
    }

    public void setOpen(float f) {
        this.h = f;
    }

    @Override // com.github.mikephil.charting.data.Entry
    public CandleEntry copy() {
        return new CandleEntry(getX(), this.e, this.f, this.h, this.g, getData());
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Object obj) {
        super(f, (f2 + f3) / 2.0f, obj);
        this.e = f2;
        this.f = f3;
        this.h = f4;
        this.g = f5;
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Drawable drawable) {
        super(f, (f2 + f3) / 2.0f, drawable);
        this.e = f2;
        this.f = f3;
        this.h = f4;
        this.g = f5;
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Drawable drawable, Object obj) {
        super(f, (f2 + f3) / 2.0f, drawable, obj);
        this.e = f2;
        this.f = f3;
        this.h = f4;
        this.g = f5;
    }
}
