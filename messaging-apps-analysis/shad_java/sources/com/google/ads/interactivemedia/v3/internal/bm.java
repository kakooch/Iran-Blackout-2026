package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class bm implements adw {
    private final aeo a;
    private final bl b;
    private ed c;
    private adw d;
    private boolean e = true;
    private boolean f;

    public bm(bl blVar, adk adkVar) {
        this.b = blVar;
        this.a = new aeo(adkVar);
    }

    public final void a() {
        this.f = true;
        this.a.a();
    }

    public final void b() {
        this.f = false;
        this.a.b();
    }

    public final void c(long j) {
        this.a.c(j);
    }

    public final void d(ed edVar) throws bn {
        adw adwVar;
        adw adwVarD = edVar.d();
        if (adwVarD == null || adwVarD == (adwVar = this.d)) {
            return;
        }
        if (adwVar != null) {
            throw bn.c(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.d = adwVarD;
        this.c = edVar;
        adwVarD.h(this.a.i());
    }

    public final void e(ed edVar) {
        if (edVar == this.c) {
            this.d = null;
            this.c = null;
            this.e = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long f(boolean r6) {
        /*
            r5 = this;
            com.google.ads.interactivemedia.v3.internal.ed r0 = r5.c
            if (r0 == 0) goto L66
            boolean r0 = r0.N()
            if (r0 != 0) goto L66
            com.google.ads.interactivemedia.v3.internal.ed r0 = r5.c
            boolean r0 = r0.M()
            if (r0 != 0) goto L1d
            if (r6 != 0) goto L66
            com.google.ads.interactivemedia.v3.internal.ed r6 = r5.c
            boolean r6 = r6.j()
            if (r6 == 0) goto L1d
            goto L66
        L1d:
            com.google.ads.interactivemedia.v3.internal.adw r6 = r5.d
            com.google.ads.interactivemedia.v3.internal.ary.t(r6)
            long r0 = r6.g()
            boolean r2 = r5.e
            if (r2 == 0) goto L46
            com.google.ads.interactivemedia.v3.internal.aeo r2 = r5.a
            long r2 = r2.g()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L3a
            com.google.ads.interactivemedia.v3.internal.aeo r6 = r5.a
            r6.b()
            goto L72
        L3a:
            r2 = 0
            r5.e = r2
            boolean r2 = r5.f
            if (r2 == 0) goto L46
            com.google.ads.interactivemedia.v3.internal.aeo r2 = r5.a
            r2.a()
        L46:
            com.google.ads.interactivemedia.v3.internal.aeo r2 = r5.a
            r2.c(r0)
            com.google.ads.interactivemedia.v3.internal.dv r6 = r6.i()
            com.google.ads.interactivemedia.v3.internal.aeo r0 = r5.a
            com.google.ads.interactivemedia.v3.internal.dv r0 = r0.i()
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L72
            com.google.ads.interactivemedia.v3.internal.aeo r0 = r5.a
            r0.h(r6)
            com.google.ads.interactivemedia.v3.internal.bl r0 = r5.b
            r0.a(r6)
            goto L72
        L66:
            r6 = 1
            r5.e = r6
            boolean r6 = r5.f
            if (r6 == 0) goto L72
            com.google.ads.interactivemedia.v3.internal.aeo r6 = r5.a
            r6.a()
        L72:
            long r0 = r5.g()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.bm.f(boolean):long");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adw
    public final long g() {
        if (this.e) {
            return this.a.g();
        }
        adw adwVar = this.d;
        ary.t(adwVar);
        return adwVar.g();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adw
    public final void h(dv dvVar) {
        adw adwVar = this.d;
        if (adwVar != null) {
            adwVar.h(dvVar);
            dvVar = this.d.i();
        }
        this.a.h(dvVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adw
    public final dv i() {
        adw adwVar = this.d;
        return adwVar != null ? adwVar.i() : this.a.i();
    }
}
