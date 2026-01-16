package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class vv implements vb {
    public final vx a;
    final /* synthetic */ vx b;
    private final va c;
    private final int d;
    private boolean e;

    public vv(vx vxVar, vx vxVar2, va vaVar, int i) {
        this.b = vxVar;
        this.a = vxVar2;
        this.c = vaVar;
        this.d = i;
    }

    private final void f() {
        if (this.e) {
            return;
        }
        this.b.h.r(this.b.c[this.d], this.b.d[this.d], 0, null, this.b.t);
        this.e = true;
    }

    public final void a() {
        ary.q(this.b.e[this.d]);
        this.b.e[this.d] = false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final boolean b() {
        return !this.b.q() && this.c.y(this.b.b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final void c() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final int d(cz czVar, iw iwVar, boolean z) {
        if (this.b.q()) {
            return -3;
        }
        if (this.b.v != null && this.b.v.d(this.d + 1) <= this.c.r()) {
            return -3;
        }
        f();
        return this.c.z(czVar, iwVar, z, this.b.b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final int e(long j) {
        if (this.b.q()) {
            return 0;
        }
        int iC = this.c.C(j, this.b.b);
        if (this.b.v != null) {
            iC = Math.min(iC, this.b.v.d(this.d + 1) - this.c.r());
        }
        this.c.D(iC);
        if (iC > 0) {
            f();
        }
        return iC;
    }
}
