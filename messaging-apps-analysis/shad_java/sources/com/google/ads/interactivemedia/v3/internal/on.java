package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class on {
    private boolean a;
    private boolean b;
    private aeb c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;

    private on() {
    }

    /* synthetic */ on(byte[] bArr) {
    }

    static /* synthetic */ boolean e(on onVar, on onVar2) {
        int i;
        int i2;
        int i3;
        boolean z;
        if (!onVar.a) {
            return false;
        }
        if (!onVar2.a) {
            return true;
        }
        aeb aebVar = onVar.c;
        ary.s(aebVar);
        aeb aebVar2 = onVar2.c;
        ary.s(aebVar2);
        return (onVar.f == onVar2.f && onVar.g == onVar2.g && onVar.h == onVar2.h && (!onVar.i || !onVar2.i || onVar.j == onVar2.j) && (((i = onVar.d) == (i2 = onVar2.d) || (i != 0 && i2 != 0)) && ((i3 = aebVar.k) != 0 ? !(i3 == 1 && aebVar2.k == 1 && (onVar.o != onVar2.o || onVar.p != onVar2.p)) : aebVar2.k != 0 || (onVar.m == onVar2.m && onVar.n == onVar2.n)) && (z = onVar.k) == onVar2.k && (!z || onVar.l == onVar2.l))) ? false : true;
    }

    public final void a() {
        this.b = false;
        this.a = false;
    }

    public final void b(int i) {
        this.e = i;
        this.b = true;
    }

    public final void c(aeb aebVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
        this.c = aebVar;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.k = z4;
        this.l = i5;
        this.m = i6;
        this.n = i7;
        this.o = i8;
        this.p = i9;
        this.a = true;
        this.b = true;
    }

    public final boolean d() {
        int i;
        return this.b && ((i = this.e) == 7 || i == 2);
    }
}
