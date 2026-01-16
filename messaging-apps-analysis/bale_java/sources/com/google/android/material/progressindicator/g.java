package com.google.android.material.progressindicator;

import ir.nasim.AbstractC16198ks;

/* loaded from: classes3.dex */
abstract class g {
    protected h a;
    protected final float[] b;
    protected final int[] c;

    protected g(int i) {
        this.b = new float[i * 2];
        this.c = new int[i];
    }

    abstract void a();

    protected float b(int i, int i2, int i3) {
        return (i - i2) / i3;
    }

    public abstract void c();

    public abstract void d(AbstractC16198ks abstractC16198ks);

    protected void e(h hVar) {
        this.a = hVar;
    }

    abstract void f();

    abstract void g();

    public abstract void h();
}
