package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class yt extends ss implements aac {
    public static final /* synthetic */ int a = 0;
    private final yp b;
    private final dg c;
    private final df d;
    private final jh e;
    private final int f;
    private final aad g;
    private adh h;
    private final yg i;
    private final acj j;
    private final aqd k;

    static {
        cv.b("goog.exo.hls");
    }

    /* synthetic */ yt(dg dgVar, yg ygVar, yp ypVar, aqd aqdVar, jh jhVar, acj acjVar, aad aadVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        df dfVar = dgVar.b;
        ary.t(dfVar);
        this.d = dfVar;
        this.c = dgVar;
        this.i = ygVar;
        this.b = ypVar;
        this.k = aqdVar;
        this.e = jhVar;
        this.j = acjVar;
        this.g = aadVar;
        this.f = i;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final dg U() {
        return this.c;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void V(tv tvVar) {
        ((yr) tvVar).k();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final tv W(tw twVar, acc accVar, long j) {
        ug ugVarF = f(twVar);
        return new yr(this.b, this.g, this.i, this.h, this.e, h(twVar), this.j, ugVarF, accVar, this.k, this.f, null, null, null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ss
    protected final void a(adh adhVar) {
        this.h = adhVar;
        this.e.b();
        this.g.a(this.d.a, f(null), this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ss
    protected final void d() {
        this.g.b();
        this.e.c();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void u() throws IOException {
        this.g.i();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aac
    public final void y(zt ztVar) {
        vf vfVar;
        long j;
        long jA = ztVar.k ? bi.a(ztVar.c) : -9223372036854775807L;
        int i = ztVar.a;
        long j2 = (i == 2 || i == 1) ? jA : -9223372036854775807L;
        long j3 = ztVar.b;
        ary.t(this.g.e());
        yy yyVar = new yy();
        if (this.g.l()) {
            long jG = ztVar.c - this.g.g();
            long j4 = ztVar.j ? jG + ztVar.n : -9223372036854775807L;
            List<zs> list = ztVar.m;
            if (j3 != -9223372036854775807L) {
                j = j3;
            } else if (list.isEmpty()) {
                j = 0;
            } else {
                int iMax = Math.max(0, list.size() - 3);
                long j5 = ztVar.n;
                long j6 = ztVar.h;
                long j7 = j5 - (j6 + j6);
                while (iMax > 0 && list.get(iMax).e > j7) {
                    iMax--;
                }
                j = list.get(iMax).e;
            }
            vfVar = new vf(j2, jA, j4, ztVar.n, jG, j, true, !ztVar.j, true, yyVar, this.c);
        } else {
            long j8 = j3 == -9223372036854775807L ? 0L : j3;
            long j9 = ztVar.n;
            vfVar = new vf(j2, jA, j9, j9, 0L, j8, true, false, false, yyVar, this.c);
        }
        e(vfVar);
    }
}
