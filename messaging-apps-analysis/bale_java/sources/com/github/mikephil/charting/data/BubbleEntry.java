package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public class BubbleEntry extends Entry {
    private float e;

    public BubbleEntry(float f, float f2, float f3) {
        super(f, f2);
        this.e = f3;
    }

    public float getSize() {
        return this.e;
    }

    public void setSize(float f) {
        this.e = f;
    }

    @Override // com.github.mikephil.charting.data.Entry
    public BubbleEntry copy() {
        return new BubbleEntry(getX(), getY(), this.e, getData());
    }

    public BubbleEntry(float f, float f2, float f3, Object obj) {
        super(f, f2, obj);
        this.e = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Drawable drawable) {
        super(f, f2, drawable);
        this.e = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Drawable drawable, Object obj) {
        super(f, f2, drawable, obj);
        this.e = f3;
    }
}
