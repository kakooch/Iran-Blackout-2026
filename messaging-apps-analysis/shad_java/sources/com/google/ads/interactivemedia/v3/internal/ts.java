package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ts extends ta<Void> {
    private final ty a;
    private final boolean b;
    private final er c;
    private final eq d;
    private tq e;
    private tp f;
    private boolean g;
    private boolean h;
    private boolean i;

    public ts(ty tyVar, boolean z) {
        this.a = tyVar;
        boolean z2 = false;
        if (z && tyVar.s()) {
            z2 = true;
        }
        this.b = z2;
        this.c = new er();
        this.d = new eq();
        es esVarR = tyVar.r();
        if (esVarR == null) {
            this.e = tq.a(tyVar.U());
        } else {
            this.e = tq.b(esVarR, null, null);
            this.i = true;
        }
    }

    private final Object E(Object obj) {
        return (this.e.e == null || !obj.equals(tq.c)) ? obj : this.e.e;
    }

    private final void F(long j) {
        tp tpVar = this.f;
        int i = this.e.i(tpVar.b.a);
        if (i == -1) {
            return;
        }
        long j2 = this.e.z(i, this.d).d;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        tpVar.q(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ta
    protected final /* bridge */ /* synthetic */ tw A(Void r2, tw twVar) {
        Object obj = twVar.a;
        if (this.e.e != null && this.e.e.equals(obj)) {
            obj = tq.c;
        }
        return twVar.a(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    @Override // com.google.ads.interactivemedia.v3.internal.ta
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final /* bridge */ /* synthetic */ void B(java.lang.Void r12, com.google.ads.interactivemedia.v3.internal.es r13) {
        /*
            r11 = this;
            java.lang.Void r12 = (java.lang.Void) r12
            boolean r12 = r11.h
            r0 = 0
            if (r12 == 0) goto L1c
            com.google.ads.interactivemedia.v3.internal.tq r12 = r11.e
            com.google.ads.interactivemedia.v3.internal.tq r12 = r12.k(r13)
            r11.e = r12
            com.google.ads.interactivemedia.v3.internal.tp r12 = r11.f
            if (r12 == 0) goto L8d
            long r12 = r12.r()
            r11.F(r12)
            goto L8d
        L1c:
            boolean r12 = r13.u()
            if (r12 == 0) goto L38
            boolean r12 = r11.i
            if (r12 == 0) goto L2d
            com.google.ads.interactivemedia.v3.internal.tq r12 = r11.e
            com.google.ads.interactivemedia.v3.internal.tq r12 = r12.k(r13)
            goto L35
        L2d:
            java.lang.Object r12 = com.google.ads.interactivemedia.v3.internal.er.a
            java.lang.Object r1 = com.google.ads.interactivemedia.v3.internal.tq.c
            com.google.ads.interactivemedia.v3.internal.tq r12 = com.google.ads.interactivemedia.v3.internal.tq.b(r13, r12, r1)
        L35:
            r11.e = r12
            goto L8d
        L38:
            r12 = 0
            com.google.ads.interactivemedia.v3.internal.er r1 = r11.c
            r13.v(r12, r1)
            com.google.ads.interactivemedia.v3.internal.er r12 = r11.c
            long r1 = r12.n
            com.google.ads.interactivemedia.v3.internal.tp r12 = r11.f
            if (r12 == 0) goto L52
            long r3 = r12.p()
            r5 = 0
            int r12 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r12 == 0) goto L52
            r9 = r3
            goto L53
        L52:
            r9 = r1
        L53:
            com.google.ads.interactivemedia.v3.internal.er r6 = r11.c
            java.lang.Object r12 = r6.b
            com.google.ads.interactivemedia.v3.internal.eq r7 = r11.d
            r8 = 0
            r5 = r13
            android.util.Pair r1 = r5.x(r6, r7, r8, r9)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            boolean r1 = r11.i
            if (r1 == 0) goto L74
            com.google.ads.interactivemedia.v3.internal.tq r12 = r11.e
            com.google.ads.interactivemedia.v3.internal.tq r12 = r12.k(r13)
            goto L78
        L74:
            com.google.ads.interactivemedia.v3.internal.tq r12 = com.google.ads.interactivemedia.v3.internal.tq.b(r13, r12, r2)
        L78:
            r11.e = r12
            com.google.ads.interactivemedia.v3.internal.tp r12 = r11.f
            if (r12 == 0) goto L8d
            r11.F(r3)
            com.google.ads.interactivemedia.v3.internal.tw r12 = r12.b
            java.lang.Object r13 = r12.a
            java.lang.Object r13 = r11.E(r13)
            com.google.ads.interactivemedia.v3.internal.tw r0 = r12.a(r13)
        L8d:
            r12 = 1
            r11.i = r12
            r11.h = r12
            com.google.ads.interactivemedia.v3.internal.tq r12 = r11.e
            r11.e(r12)
            if (r0 == 0) goto La1
            com.google.ads.interactivemedia.v3.internal.tp r12 = r11.f
            com.google.ads.interactivemedia.v3.internal.ary.t(r12)
            r12.s(r0)
        La1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ts.B(java.lang.Object, com.google.ads.interactivemedia.v3.internal.es):void");
    }

    public final es C() {
        return this.e;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final tp W(tw twVar, acc accVar, long j) {
        tp tpVar = new tp(this.a, twVar, accVar, j);
        if (this.h) {
            tpVar.s(twVar.a(E(twVar.a)));
        } else {
            this.f = tpVar;
            if (!this.g) {
                this.g = true;
                v(null, this.a);
            }
        }
        return tpVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final dg U() {
        return this.a.U();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void V(tv tvVar) {
        ((tp) tvVar).t();
        if (tvVar == this.f) {
            this.f = null;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ta, com.google.ads.interactivemedia.v3.internal.ss
    public final void a(adh adhVar) {
        super.a(adhVar);
        if (this.b) {
            return;
        }
        this.g = true;
        v(null, this.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ta, com.google.ads.interactivemedia.v3.internal.ss
    public final void d() {
        this.h = false;
        this.g = false;
        super.d();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ta, com.google.ads.interactivemedia.v3.internal.ty
    public final void u() {
    }
}
