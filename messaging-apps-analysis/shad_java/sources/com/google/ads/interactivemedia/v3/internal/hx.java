package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class hx {
    private final gx[] a;
    private final in b;
    private final ip c;

    public hx(gx... gxVarArr) {
        in inVar = new in();
        ip ipVar = new ip();
        gx[] gxVarArr2 = {inVar, ipVar};
        this.a = gxVarArr2;
        System.arraycopy(gxVarArr, 0, gxVarArr2, 0, 0);
        this.b = inVar;
        this.c = ipVar;
    }

    public final gx[] a() {
        return this.a;
    }

    public final dv b(dv dvVar) {
        ip ipVar = this.c;
        float f = dvVar.b;
        ipVar.k(f);
        ip ipVar2 = this.c;
        float f2 = dvVar.c;
        ipVar2.j(f2);
        return new dv(f, f2);
    }

    public final long c(long j) {
        return this.c.i(j);
    }

    public final long d() {
        return this.b.p();
    }

    public final void e(boolean z) {
        this.b.o(z);
    }
}
