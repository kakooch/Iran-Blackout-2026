package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class uv extends ss implements uo {
    private final dg a;
    private final df b;
    private final abw c;
    private final kc d;
    private final jh e;
    private final int f;
    private boolean g;
    private long h;
    private boolean i;
    private boolean j;
    private adh k;
    private final acj l;

    uv(dg dgVar, abw abwVar, kc kcVar, jh jhVar, acj acjVar, int i) {
        df dfVar = dgVar.b;
        ary.t(dfVar);
        this.b = dfVar;
        this.a = dgVar;
        this.c = abwVar;
        this.d = kcVar;
        this.e = jhVar;
        this.l = acjVar;
        this.f = 1048576;
        this.g = true;
        this.h = -9223372036854775807L;
    }

    private final void y() {
        long j = this.h;
        vf vfVar = new vf(-9223372036854775807L, -9223372036854775807L, j, j, 0L, 0L, this.i, false, this.j, null, this.a);
        e(this.g ? new ut(vfVar) : vfVar);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final dg U() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void V(tv tvVar) {
        ((us) tvVar).k();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final tv W(tw twVar, acc accVar, long j) {
        acg acgVarA = ((ach) this.c).a();
        adh adhVar = this.k;
        if (adhVar != null) {
            acgVarA.b(adhVar);
        }
        return new us(this.b.a, acgVarA, this.d, this.e, h(twVar), this.l, f(twVar), this, accVar, 1048576);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ss
    protected final void a(adh adhVar) {
        this.k = adhVar;
        this.e.b();
        y();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uo
    public final void b(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.h;
        }
        if (!this.g && this.h == j && this.i == z && this.j == z2) {
            return;
        }
        this.h = j;
        this.i = z;
        this.j = z2;
        this.g = false;
        y();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ss
    protected final void d() {
        this.e.c();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void u() {
    }
}
