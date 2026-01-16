package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class oo {
    private final kr a;
    private final boolean b;
    private final boolean c;
    private final aef f;
    private byte[] g;
    private int h;
    private int i;
    private long j;
    private boolean k;
    private long l;
    private boolean o;
    private long p;
    private long q;
    private boolean r;
    private final SparseArray<aeb> d = new SparseArray<>();
    private final SparseArray<aea> e = new SparseArray<>();
    private on m = new on(null);
    private on n = new on(null);

    public oo(kr krVar, boolean z, boolean z2) {
        this.a = krVar;
        this.b = z;
        this.c = z2;
        byte[] bArr = new byte[128];
        this.g = bArr;
        this.f = new aef(bArr, 0, 0);
        d();
    }

    public final boolean a() {
        return this.c;
    }

    public final void b(aeb aebVar) {
        this.d.append(aebVar.d, aebVar);
    }

    public final void c(aea aeaVar) {
        this.e.append(aeaVar.a, aeaVar);
    }

    public final void d() {
        this.k = false;
        this.o = false;
        this.n.a();
    }

    public final void e(long j, int i, long j2) {
        this.i = i;
        this.l = j2;
        this.j = j;
        if (!this.b || i != 1) {
            if (!this.c) {
                return;
            }
            if (i != 5 && i != 1 && i != 2) {
                return;
            }
        }
        on onVar = this.m;
        this.m = this.n;
        this.n = onVar;
        onVar.a();
        this.h = 0;
        this.k = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(byte[] r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.oo.f(byte[], int, int):void");
    }

    public final boolean g(long j, int i, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.i == 9 || (this.c && on.e(this.n, this.m))) {
            if (z && this.o) {
                long j2 = this.j;
                this.a.b(this.q, this.r ? 1 : 0, (int) (j2 - this.p), i + ((int) (j - j2)), null);
            }
            this.p = this.j;
            this.q = this.l;
            this.r = false;
            this.o = true;
        }
        boolean zD = this.b ? this.n.d() : z2;
        boolean z4 = this.r;
        int i2 = this.i;
        if (i2 == 5 || (zD && i2 == 1)) {
            z3 = true;
        }
        boolean z5 = z4 | z3;
        this.r = z5;
        return z5;
    }
}
