package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class cq {
    public du a;
    public int b;
    public boolean c;
    public int d;
    public boolean e;
    public int f;
    private boolean g;

    public cq(du duVar) {
        this.a = duVar;
    }

    public final void a(int i) {
        this.g = 1 == ((this.g ? 1 : 0) | i);
        this.b += i;
    }

    public final void b(du duVar) {
        this.g |= this.a != duVar;
        this.a = duVar;
    }

    public final void c(int i) {
        if (this.c && this.d != 4) {
            ary.o(i == 4);
            return;
        }
        this.g = true;
        this.c = true;
        this.d = i;
    }

    public final void d(int i) {
        this.g = true;
        this.e = true;
        this.f = i;
    }
}
