package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class mf {
    public final int a;
    public int b;
    public int c;
    public long d;
    private final boolean e;
    private final aee f;
    private final aee g;
    private int h;
    private int i;

    public mf(aee aeeVar, aee aeeVar2, boolean z) {
        this.g = aeeVar;
        this.f = aeeVar2;
        this.e = z;
        aeeVar2.h(12);
        this.a = aeeVar2.B();
        aeeVar.h(12);
        this.i = aeeVar.B();
        ary.r(aeeVar.v() == 1, "first_chunk must be 1");
        this.b = -1;
    }

    public final boolean a() {
        int i = this.b + 1;
        this.b = i;
        if (i == this.a) {
            return false;
        }
        this.d = this.e ? this.f.D() : this.f.t();
        if (this.b == this.h) {
            this.c = this.g.B();
            this.g.k(4);
            int i2 = this.i - 1;
            this.i = i2;
            this.h = i2 > 0 ? (-1) + this.g.B() : -1;
        }
        return true;
    }
}
