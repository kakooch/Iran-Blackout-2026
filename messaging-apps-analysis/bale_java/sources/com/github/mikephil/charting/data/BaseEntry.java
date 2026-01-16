package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public abstract class BaseEntry {
    private float a;
    private Object b;
    private Drawable c;

    public BaseEntry() {
        this.a = 0.0f;
        this.b = null;
        this.c = null;
    }

    public Object getData() {
        return this.b;
    }

    public Drawable getIcon() {
        return this.c;
    }

    public float getY() {
        return this.a;
    }

    public void setData(Object obj) {
        this.b = obj;
    }

    public void setIcon(Drawable drawable) {
        this.c = drawable;
    }

    public void setY(float f) {
        this.a = f;
    }

    public BaseEntry(float f) {
        this.b = null;
        this.c = null;
        this.a = f;
    }

    public BaseEntry(float f, Object obj) {
        this(f);
        this.b = obj;
    }

    public BaseEntry(float f, Drawable drawable) {
        this(f);
        this.c = drawable;
    }

    public BaseEntry(float f, Drawable drawable, Object obj) {
        this(f);
        this.c = drawable;
        this.b = obj;
    }
}
