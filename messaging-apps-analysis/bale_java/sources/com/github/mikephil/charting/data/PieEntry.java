package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.util.Log;

/* loaded from: classes2.dex */
public class PieEntry extends Entry {
    private String e;

    public PieEntry(float f) {
        super(0.0f, f);
    }

    public String getLabel() {
        return this.e;
    }

    public float getValue() {
        return getY();
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float getX() {
        Log.i("DEPRECATED", "Pie entries do not have x values");
        return super.getX();
    }

    public void setLabel(String str) {
        this.e = str;
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void setX(float f) {
        super.setX(f);
        Log.i("DEPRECATED", "Pie entries do not have x values");
    }

    public PieEntry(float f, Object obj) {
        super(0.0f, f, obj);
    }

    @Override // com.github.mikephil.charting.data.Entry
    public PieEntry copy() {
        return new PieEntry(getY(), this.e, getData());
    }

    public PieEntry(float f, Drawable drawable) {
        super(0.0f, f, drawable);
    }

    public PieEntry(float f, Drawable drawable, Object obj) {
        super(0.0f, f, drawable, obj);
    }

    public PieEntry(float f, String str) {
        super(0.0f, f);
        this.e = str;
    }

    public PieEntry(float f, String str, Object obj) {
        super(0.0f, f, obj);
        this.e = str;
    }

    public PieEntry(float f, String str, Drawable drawable) {
        super(0.0f, f, drawable);
        this.e = str;
    }

    public PieEntry(float f, String str, Drawable drawable, Object obj) {
        super(0.0f, f, drawable, obj);
        this.e = str;
    }
}
