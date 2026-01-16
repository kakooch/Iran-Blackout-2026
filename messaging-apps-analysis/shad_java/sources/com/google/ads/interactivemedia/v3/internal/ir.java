package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class ir {
    private int a;

    public void a() {
        this.a = 0;
    }

    public final boolean b() {
        return h(Integer.MIN_VALUE);
    }

    public final boolean c() {
        return h(4);
    }

    public final boolean d() {
        return h(1);
    }

    public final boolean e() {
        return h(268435456);
    }

    public final void f(int i) {
        this.a = i;
    }

    public final void g(int i) {
        this.a = i | this.a;
    }

    protected final boolean h(int i) {
        return (this.a & i) == i;
    }
}
