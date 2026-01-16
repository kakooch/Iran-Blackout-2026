package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class xc implements wg {
    protected final xa[] a;
    private final adb b;
    private final int[] c;
    private final int d;
    private final abx e;
    private final long f;
    private final int g = 1;
    private final xg h;
    private aba i;
    private xj j;
    private int k;
    private IOException l;
    private boolean m;

    public xc(adb adbVar, xj xjVar, int i, int[] iArr, aba abaVar, int i2, abx abxVar, long j, int i3, boolean z, List<cy> list, xg xgVar) {
        this.b = adbVar;
        this.j = xjVar;
        this.c = iArr;
        this.i = abaVar;
        this.d = i2;
        this.e = abxVar;
        this.k = i;
        this.f = j;
        this.h = xgVar;
        long jE = xjVar.e(i);
        ArrayList<xt> arrayListK = k();
        this.a = new xa[abaVar.l()];
        for (int i4 = 0; i4 < this.a.length; i4++) {
            this.a[i4] = new xa(jE, i2, arrayListK.get(abaVar.n(i4)), z, list, xgVar);
        }
    }

    private final ArrayList<xt> k() {
        List<xi> list = this.j.c(this.k).c;
        ArrayList<xt> arrayList = new ArrayList<>();
        for (int i : this.c) {
            arrayList.addAll(list.get(i).c);
        }
        return arrayList;
    }

    private final long l(long j) {
        xj xjVar = this.j;
        return j - bi.b(xjVar.a + xjVar.c(this.k).b);
    }

    private static final long m(xa xaVar, wc wcVar, long j, long j2, long j3) {
        return wcVar != null ? wcVar.i() : aeu.I(xaVar.h(j), j2, j3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vy
    public final long a(long j, eg egVar) {
        for (xa xaVar : this.a) {
            if (xaVar.b != null) {
                long jH = xaVar.h(j);
                long jF = xaVar.f(jH);
                return egVar.a(j, jF, (jF >= j || jH >= ((long) (xaVar.e() + (-1)))) ? jF : xaVar.f(jH + 1));
            }
        }
        return j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vy
    public final void b() throws IOException {
        IOException iOException = this.l;
        if (iOException != null) {
            throw iOException;
        }
        this.b.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vy
    public final int c(long j, List<? extends wc> list) {
        return (this.l != null || this.i.l() < 2) ? list.size() : this.i.i(j, list);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vy
    public final boolean d(long j, vt vtVar, List<? extends wc> list) {
        if (this.l != null) {
            return false;
        }
        return this.i.u();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vy
    public final void e(long j, long j2, List<? extends wc> list, vu vuVar) {
        cy cyVar;
        xt xtVar;
        int i;
        vt vzVar;
        vu vuVar2;
        xq xqVarC;
        long j3;
        int i2;
        we[] weVarArr;
        int i3;
        if (this.l != null) {
            return;
        }
        long j4 = j2 - j;
        long jB = bi.b(this.j.a) + bi.b(this.j.c(this.k).b) + j2;
        xg xgVar = this.h;
        if (xgVar == null || !xgVar.a.b(jB)) {
            long jB2 = bi.b(aeu.ai(this.f));
            long jL = l(jB2);
            wc wcVar = list.isEmpty() ? null : list.get(list.size() - 1);
            int iL = this.i.l();
            we[] weVarArr2 = new we[iL];
            int i4 = 0;
            while (i4 < iL) {
                xa xaVar = this.a[i4];
                if (xaVar.b == null) {
                    weVarArr2[i4] = we.a;
                    i2 = i4;
                    weVarArr = weVarArr2;
                    i3 = iL;
                    j3 = jL;
                } else {
                    long jD = xaVar.d(jB2);
                    j3 = jL;
                    long j5 = xaVar.j(jB2);
                    i2 = i4;
                    weVarArr = weVarArr2;
                    i3 = iL;
                    long jM = m(xaVar, wcVar, j2, jD, j5);
                    if (jM < jD) {
                        weVarArr[i2] = we.a;
                    } else {
                        weVarArr[i2] = new xb(jM, j5);
                    }
                }
                i4 = i2 + 1;
                jL = j3;
                weVarArr2 = weVarArr;
                iL = i3;
            }
            long j6 = jL;
            this.i.d(j4, !this.j.d ? -9223372036854775807L : Math.max(0L, Math.min(l(jB2), this.a[0].g(this.a[0].j(jB2))) - j), list);
            xa xaVar2 = this.a[this.i.a()];
            vs vsVar = xaVar2.c;
            if (vsVar != null) {
                xt xtVar2 = xaVar2.a;
                xq xqVarN = vsVar.e() == null ? xtVar2.n() : null;
                xq xqVarK = xaVar2.b == null ? xtVar2.k() : null;
                if (xqVarN != null || xqVarK != null) {
                    abx abxVar = this.e;
                    cy cyVarQ = this.i.q();
                    int iB = this.i.b();
                    Object objC = this.i.c();
                    xt xtVar3 = xaVar2.a;
                    if (xqVarN == null || (xqVarK = xqVarN.c(xqVarK, xtVar3.c)) != null) {
                        xqVarN = xqVarK;
                    }
                    vuVar.a = new wb(abxVar, aqd.s(xtVar3, xqVarN, 0), cyVarQ, iB, objC, xaVar2.c);
                    return;
                }
            }
            long j7 = xaVar2.d;
            boolean z = j7 != -9223372036854775807L;
            if (xaVar2.e() == 0) {
                vuVar.b = z;
                return;
            }
            long jD2 = xaVar2.d(jB2);
            long j8 = xaVar2.j(jB2);
            boolean z2 = z;
            long jM2 = m(xaVar2, wcVar, j2, jD2, j8);
            if (jM2 < jD2) {
                this.l = new st();
                return;
            }
            if (jM2 > j8 || (this.m && jM2 >= j8)) {
                vuVar.b = z2;
                return;
            }
            if (z2 && xaVar2.f(jM2) >= j7) {
                vuVar.b = true;
                return;
            }
            int iMin = (int) Math.min(1L, (j8 - jM2) + 1);
            if (j7 != -9223372036854775807L) {
                while (iMin > 1 && xaVar2.f((iMin + jM2) - 1) >= j7) {
                    iMin--;
                }
            }
            long j9 = true != list.isEmpty() ? -9223372036854775807L : j2;
            abx abxVar2 = this.e;
            int i5 = this.d;
            cy cyVarQ2 = this.i.q();
            int iB2 = this.i.b();
            Object objC2 = this.i.c();
            xt xtVar4 = xaVar2.a;
            long jF = xaVar2.f(jM2);
            xq xqVarI = xaVar2.i(jM2);
            String str = xtVar4.c;
            if (xaVar2.c == null) {
                vzVar = new wf(abxVar2, aqd.s(xtVar4, xqVarI, true != xaVar2.k(jM2, j6) ? 8 : 0), cyVarQ2, iB2, objC2, jF, xaVar2.g(jM2), jM2, i5, cyVarQ2);
                vuVar2 = vuVar;
            } else {
                xq xqVar = xqVarI;
                int i6 = 1;
                int i7 = 1;
                while (true) {
                    cyVar = cyVarQ2;
                    if (i7 >= iMin || (xqVarC = xqVar.c(xaVar2.i(i7 + jM2), str)) == null) {
                        break;
                    }
                    i6++;
                    i7++;
                    cyVarQ2 = cyVar;
                    xqVar = xqVarC;
                }
                long j10 = (i6 + jM2) - 1;
                long jG = xaVar2.g(j10);
                long j11 = xaVar2.d;
                long j12 = (j11 == -9223372036854775807L || j11 > jG) ? -9223372036854775807L : j11;
                if (true != xaVar2.k(j10, j6)) {
                    xtVar = xtVar4;
                    i = 8;
                } else {
                    xtVar = xtVar4;
                    i = 0;
                }
                vzVar = new vz(abxVar2, aqd.s(xtVar, xqVar, i), cyVar, iB2, objC2, jF, jG, j9, j12, jM2, i6, -xtVar.d, xaVar2.c);
                vuVar2 = vuVar;
            }
            vuVar2.a = vzVar;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vy
    public final void f(vt vtVar) {
        jt jtVarD;
        if (vtVar instanceof wb) {
            int iO = this.i.o(((wb) vtVar).f);
            xa xaVar = this.a[iO];
            if (xaVar.b == null && (jtVarD = xaVar.c.d()) != null) {
                this.a[iO] = xaVar.b(new wy(jtVarD, xaVar.a.d));
            }
        }
        xg xgVar = this.h;
        if (xgVar != null) {
            xgVar.a.d(vtVar);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vy
    public final boolean g(vt vtVar, boolean z, Exception exc, long j) {
        xa xaVar;
        int iE;
        if (!z) {
            return false;
        }
        xg xgVar = this.h;
        if (xgVar != null && xgVar.a.c(vtVar)) {
            return true;
        }
        if (!this.j.d && (vtVar instanceof wc) && (exc instanceof aco) && ((aco) exc).a == 404 && (iE = (xaVar = this.a[this.i.o(vtVar.f)]).e()) != -1 && iE != 0) {
            if (((wc) vtVar).i() > (xaVar.c() + iE) - 1) {
                this.m = true;
                return true;
            }
        }
        if (j != -9223372036854775807L) {
            aba abaVar = this.i;
            if (abaVar.s(abaVar.o(vtVar.f), j)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vy
    public final void h() {
        for (xa xaVar : this.a) {
            vs vsVar = xaVar.c;
            if (vsVar != null) {
                vsVar.f();
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wg
    public final void i(xj xjVar, int i) {
        try {
            this.j = xjVar;
            this.k = i;
            long jE = xjVar.e(i);
            ArrayList<xt> arrayListK = k();
            for (int i2 = 0; i2 < this.a.length; i2++) {
                xt xtVar = arrayListK.get(this.i.n(i2));
                xa[] xaVarArr = this.a;
                xaVarArr[i2] = xaVarArr[i2].a(jE, xtVar);
            }
        } catch (st e) {
            this.l = e;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.wg
    public final void j(aba abaVar) {
        this.i = abaVar;
    }
}
