package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class yr implements tv, yz, zz {
    private final yp a;
    private final aad b;
    private final adh c;
    private final jh d;
    private final je e;
    private final ug f;
    private final int i;
    private tu j;
    private int k;
    private vj l;
    private final yg p;
    private final acj q;
    private final acc r;
    private final aqd s;
    private vd o = aqd.t(new vd[0]);
    private final IdentityHashMap<vb, Integer> g = new IdentityHashMap<>();
    private final zi h = new zi();
    private zc[] m = new zc[0];
    private zc[] n = new zc[0];

    public yr(yp ypVar, aad aadVar, yg ygVar, adh adhVar, jh jhVar, je jeVar, acj acjVar, ug ugVar, acc accVar, aqd aqdVar, int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.a = ypVar;
        this.b = aadVar;
        this.p = ygVar;
        this.c = adhVar;
        this.d = jhVar;
        this.e = jeVar;
        this.q = acjVar;
        this.f = ugVar;
        this.r = accVar;
        this.s = aqdVar;
        this.i = i;
    }

    private final zc t(int i, Uri[] uriArr, cy[] cyVarArr, cy cyVar, List<cy> list, Map<String, jc> map, long j) {
        return new zc(i, this, new yo(this.a, this.b, uriArr, cyVarArr, this.p, this.c, this.h, list), map, this.r, j, cyVar, this.d, this.e, this.q, this.f, this.i);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    @Override // com.google.ads.interactivemedia.v3.internal.tv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.ads.interactivemedia.v3.internal.tu r21, long r22) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.yr.a(com.google.ads.interactivemedia.v3.internal.tu, long):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void b() throws IOException {
        for (zc zcVar : this.m) {
            zcVar.e();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final vj c() {
        vj vjVar = this.l;
        ary.t(vjVar);
        return vjVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00dd  */
    @Override // com.google.ads.interactivemedia.v3.internal.tv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long d(com.google.ads.interactivemedia.v3.internal.aba[] r22, boolean[] r23, com.google.ads.interactivemedia.v3.internal.vb[] r24, boolean[] r25, long r26) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.yr.d(com.google.ads.interactivemedia.v3.internal.aba[], boolean[], com.google.ads.interactivemedia.v3.internal.vb[], boolean[], long):long");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void e(long j, boolean z) {
        for (zc zcVar : this.n) {
            zcVar.p(j, false);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final void f(long j) {
        this.o.f(j);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long g() {
        return -9223372036854775807L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final long h() {
        return this.o.h();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long i(long j) {
        zc[] zcVarArr = this.n;
        if (zcVarArr.length > 0) {
            boolean zQ = zcVarArr[0].q(j, false);
            int i = 1;
            while (true) {
                zc[] zcVarArr2 = this.n;
                if (i >= zcVarArr2.length) {
                    break;
                }
                zcVarArr2[i].q(j, zQ);
                i++;
            }
            if (zQ) {
                this.h.b();
            }
        }
        return j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long j(long j, eg egVar) {
        return j;
    }

    public final void k() {
        this.b.d(this);
        for (zc zcVar : this.m) {
            zcVar.r();
        }
        this.j = null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final long l() {
        return this.o.l();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vc
    public final /* bridge */ /* synthetic */ void m(vd vdVar) {
        this.j.m(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final boolean n(long j) {
        if (this.l != null) {
            return this.o.n(j);
        }
        for (zc zcVar : this.m) {
            zcVar.d();
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final boolean o() {
        return this.o.o();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.yz
    public final void p() {
        int i = this.k - 1;
        this.k = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (zc zcVar : this.m) {
            i2 += zcVar.g().b;
        }
        vh[] vhVarArr = new vh[i2];
        int i3 = 0;
        for (zc zcVar2 : this.m) {
            int i4 = zcVar2.g().b;
            int i5 = 0;
            while (i5 < i4) {
                vhVarArr[i3] = zcVar2.g().a(i5);
                i5++;
                i3++;
            }
        }
        this.l = new vj(vhVarArr);
        this.j.k(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.yz
    public final void q(Uri uri) {
        this.b.k(uri);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zz
    public final void r() {
        this.j.m(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zz
    public final boolean s(Uri uri, long j) {
        boolean zT = true;
        for (zc zcVar : this.m) {
            zT &= zcVar.t(uri, j);
        }
        this.j.m(this);
        return true == zT;
    }
}
