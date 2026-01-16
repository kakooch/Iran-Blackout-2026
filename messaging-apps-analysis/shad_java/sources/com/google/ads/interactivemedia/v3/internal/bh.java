package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class bh implements ed, ee {
    private final int a;
    private ef c;
    private int d;
    private int e;
    private vb f;
    private cy[] g;
    private long h;
    private boolean j;
    private boolean k;
    private final cz b = new cz();
    private long i = Long.MIN_VALUE;

    public bh(int i) {
        this.a = i;
    }

    protected final cz A() {
        this.b.a();
        return this.b;
    }

    protected final cy[] B() {
        return (cy[]) ary.t(this.g);
    }

    protected final ef C() {
        ef efVar = this.c;
        ary.t(efVar);
        return efVar;
    }

    protected final bn D(Exception exc, cy cyVar) {
        return E(exc, cyVar, false);
    }

    protected final bn E(Exception exc, cy cyVar, boolean z) {
        int i;
        if (cyVar == null || this.k) {
            i = 4;
        } else {
            this.k = true;
            try {
                int iR = asn.r(O(cyVar));
                this.k = false;
                i = iR;
            } catch (bn unused) {
                this.k = false;
            } catch (Throwable th) {
                this.k = false;
                throw th;
            }
        }
        return bn.b(exc, K(), this.d, cyVar, i, z);
    }

    protected final int F(cz czVar, iw iwVar, boolean z) {
        vb vbVar = this.f;
        ary.t(vbVar);
        int iD = vbVar.d(czVar, iwVar, z);
        if (iD == -4) {
            if (iwVar.c()) {
                this.i = Long.MIN_VALUE;
                return this.j ? -4 : -3;
            }
            long j = iwVar.d + this.h;
            iwVar.d = j;
            this.i = Math.max(this.i, j);
            return iD;
        }
        if (iD != -5) {
            return iD;
        }
        cy cyVar = czVar.a;
        ary.t(cyVar);
        if (cyVar.p == Long.MAX_VALUE) {
            return -5;
        }
        cx cxVarA = cyVar.a();
        cxVarA.ai(cyVar.p + this.h);
        czVar.a = cxVarA.a();
        return -5;
    }

    protected final int G(long j) {
        vb vbVar = this.f;
        ary.t(vbVar);
        return vbVar.e(j - this.h);
    }

    protected final boolean H() {
        if (j()) {
            return this.j;
        }
        vb vbVar = this.f;
        ary.t(vbVar);
        return vbVar.b();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public void I(float f) throws bn {
        throw null;
    }

    protected void J(long j, long j2) throws bn {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed, com.google.ads.interactivemedia.v3.internal.ee
    public final int a() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final void aX() throws bn {
        ary.q(this.e == 1);
        this.e = 2;
        w();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final void aY(cy[] cyVarArr, vb vbVar, long j, long j2) throws bn {
        ary.q(!this.j);
        this.f = vbVar;
        this.i = j2;
        this.g = cyVarArr;
        this.h = j2;
        J(j, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final vb aZ() {
        return this.f;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final ee b() {
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final void c(int i) {
        this.d = i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public adw d() {
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final int e() {
        return this.e;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final void f(ef efVar, cy[] cyVarArr, vb vbVar, long j, boolean z, boolean z2, long j2, long j3) throws bn {
        ary.q(this.e == 0);
        this.c = efVar;
        this.e = 1;
        u(z, z2);
        aY(cyVarArr, vbVar, j2, j3);
        v(j, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final boolean j() {
        return this.i == Long.MIN_VALUE;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final long k() {
        return this.i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final void l() {
        this.j = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final boolean m() {
        return this.j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final void n() throws IOException {
        vb vbVar = this.f;
        ary.t(vbVar);
        vbVar.c();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final void o(long j) throws bn {
        this.j = false;
        this.i = j;
        v(j, false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final void p() {
        ary.q(this.e == 2);
        this.e = 1;
        x();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final void q() {
        ary.q(this.e == 1);
        this.b.a();
        this.e = 0;
        this.f = null;
        this.g = null;
        this.j = false;
        y();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ed
    public final void r() {
        ary.q(this.e == 0);
        this.b.a();
        z();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ee
    public int s() throws bn {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dz
    public void t(int i, Object obj) throws bn {
    }

    protected void u(boolean z, boolean z2) throws bn {
    }

    protected void v(long j, boolean z) throws bn {
        throw null;
    }

    protected void w() throws bn {
    }

    protected void x() {
    }

    protected void y() {
        throw null;
    }

    protected void z() {
    }
}
