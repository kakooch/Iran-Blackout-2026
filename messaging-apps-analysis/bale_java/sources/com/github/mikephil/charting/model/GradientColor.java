package com.github.mikephil.charting.model;

/* loaded from: classes2.dex */
public class GradientColor {
    private int a;
    private int b;

    public GradientColor(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public int getEndColor() {
        return this.b;
    }

    public int getStartColor() {
        return this.a;
    }

    public void setEndColor(int i) {
        this.b = i;
    }

    public void setStartColor(int i) {
        this.a = i;
    }
}
