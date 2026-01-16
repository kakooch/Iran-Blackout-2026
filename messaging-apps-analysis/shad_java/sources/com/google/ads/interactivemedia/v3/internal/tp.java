package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class tp implements tv, tu {
    public final ty a;
    public final tw b;
    private tv c;
    private tu d;
    private final long e;
    private long f = -9223372036854775807L;
    private final acc g;

    public tp(ty tyVar, tw twVar, acc accVar, long j) {
        this.b = twVar;
        this.g = accVar;
        this.a = tyVar;
        this.e = j;
    }

    private final long u(long j) {
        long j2 = this.f;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void a(tu tuVar, long j) {
        this.d = tuVar;
        tv tvVar = this.c;
        if (tvVar != null) {
            tvVar.a(this, u(this.e));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void b() throws IOException {
        try {
            tv tvVar = this.c;
            if (tvVar != null) {
                tvVar.b();
            } else {
                this.a.u();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final vj c() {
        tv tvVar = this.c;
        int i = aeu.a;
        return tvVar.c();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long d(aba[] abaVarArr, boolean[] zArr, vb[] vbVarArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.f;
        if (j3 == -9223372036854775807L || j != this.e) {
            j2 = j;
        } else {
            this.f = -9223372036854775807L;
            j2 = j3;
        }
        tv tvVar = this.c;
        int i = aeu.a;
        return tvVar.d(abaVarArr, zArr, vbVarArr, zArr2, j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void e(long j, boolean z) {
        tv tvVar = this.c;
        int i = aeu.a;
        tvVar.e(j, false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final void f(long j) {
        tv tvVar = this.c;
        int i = aeu.a;
        tvVar.f(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long g() {
        tv tvVar = this.c;
        int i = aeu.a;
        return tvVar.g();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final long h() {
        tv tvVar = this.c;
        int i = aeu.a;
        return tvVar.h();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long i(long j) {
        tv tvVar = this.c;
        int i = aeu.a;
        return tvVar.i(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long j(long j, eg egVar) {
        tv tvVar = this.c;
        int i = aeu.a;
        return tvVar.j(j, egVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tu
    public final void k(tv tvVar) {
        tu tuVar = this.d;
        int i = aeu.a;
        tuVar.k(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final long l() {
        tv tvVar = this.c;
        int i = aeu.a;
        return tvVar.l();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vc
    public final /* bridge */ /* synthetic */ void m(vd vdVar) {
        tu tuVar = this.d;
        int i = aeu.a;
        tuVar.m(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final boolean n(long j) {
        tv tvVar = this.c;
        return tvVar != null && tvVar.n(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final boolean o() {
        tv tvVar = this.c;
        return tvVar != null && tvVar.o();
    }

    public final long p() {
        return this.e;
    }

    public final void q(long j) {
        this.f = j;
    }

    public final long r() {
        return this.f;
    }

    public final void s(tw twVar) {
        long jU = u(this.e);
        tv tvVarW = this.a.W(twVar, this.g, jU);
        this.c = tvVarW;
        if (this.d != null) {
            tvVarW.a(this, jU);
        }
    }

    public final void t() {
        tv tvVar = this.c;
        if (tvVar != null) {
            this.a.V(tvVar);
        }
    }
}
