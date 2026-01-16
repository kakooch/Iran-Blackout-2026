package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.util.Pair;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class dl {
    private final eq a = new eq();
    private final er b = new er();
    private final gj c;
    private final Handler d;
    private long e;
    private int f;
    private boolean g;
    private di h;
    private di i;
    private di j;
    private int k;
    private Object l;
    private long m;

    public dl(gj gjVar, Handler handler) {
        this.c = gjVar;
        this.d = handler;
    }

    private final boolean A(es esVar, tw twVar, boolean z) {
        int i = esVar.i(twVar.a);
        return !esVar.v(esVar.z(i, this.a).c, this.b).i && esVar.w(i, this.a, this.b, this.f, this.g) == -1 && z;
    }

    private static final boolean B(tw twVar) {
        return !twVar.b() && twVar.e == -1;
    }

    private final void s() {
        if (this.c != null) {
            final ark arkVarR = arn.r();
            for (di diVarO = this.h; diVarO != null; diVarO = diVarO.o()) {
                arkVarR.d(diVarO.f.a);
            }
            di diVar = this.i;
            final tw twVar = diVar == null ? null : diVar.f.a;
            this.d.post(new Runnable(this, arkVarR, twVar) { // from class: com.google.ads.interactivemedia.v3.internal.dk
                private final dl a;
                private final ark b;
                private final tw c;

                {
                    this.a = this;
                    this.b = arkVarR;
                    this.c = twVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.q(this.b, this.c);
                }
            });
        }
    }

    private static tw t(es esVar, Object obj, long j, long j2, eq eqVar) {
        esVar.g(obj, eqVar);
        int iF = eqVar.f(j);
        return iF == -1 ? new tw(obj, j2, eqVar.g(j)) : new tw(obj, iF, eqVar.d(iF), j2);
    }

    private final boolean u(es esVar) {
        di diVarO = this.h;
        if (diVarO == null) {
            return true;
        }
        int i = esVar.i(diVarO.b);
        while (true) {
            i = esVar.w(i, this.a, this.b, this.f, this.g);
            while (diVarO.o() != null && !diVarO.f.f) {
                diVarO = diVarO.o();
            }
            di diVarO2 = diVarO.o();
            if (i == -1 || diVarO2 == null || esVar.i(diVarO2.b) != i) {
                break;
            }
            diVarO = diVarO2;
        }
        boolean zL = l(diVarO);
        diVarO.f = o(esVar, diVarO.f);
        return !zL;
    }

    private final dj v(es esVar, di diVar, long j) {
        long j2;
        dj djVar = diVar.f;
        long jC = (diVar.c() + djVar.e) - j;
        if (djVar.f) {
            long j3 = 0;
            int iW = esVar.w(esVar.i(djVar.a.a), this.a, this.b, this.f, this.g);
            if (iW == -1) {
                return null;
            }
            int i = esVar.h(iW, this.a, true).c;
            Object obj = this.a.b;
            long j4 = djVar.a.d;
            if (esVar.v(i, this.b).l == iW) {
                Pair<Object, Long> pairY = esVar.y(this.b, this.a, i, -9223372036854775807L, Math.max(0L, jC));
                if (pairY == null) {
                    return null;
                }
                obj = pairY.first;
                long jLongValue = ((Long) pairY.second).longValue();
                di diVarO = diVar.o();
                if (diVarO == null || !diVarO.b.equals(obj)) {
                    j4 = this.e;
                    this.e = 1 + j4;
                } else {
                    j4 = diVarO.f.a.d;
                }
                j2 = jLongValue;
                j3 = -9223372036854775807L;
            } else {
                j2 = 0;
            }
            return w(esVar, t(esVar, obj, j2, j4, this.a), j3, j2);
        }
        tw twVar = djVar.a;
        esVar.g(twVar.a, this.a);
        if (!twVar.b()) {
            int iF = this.a.f(djVar.d);
            if (iF == -1) {
                Object obj2 = twVar.a;
                long j5 = djVar.e;
                return y(esVar, obj2, j5, j5, twVar.d);
            }
            int iD = this.a.d(iF);
            if (this.a.i(iF, iD)) {
                return x(esVar, twVar.a, iF, iD, djVar.e, twVar.d);
            }
            return null;
        }
        int i2 = twVar.b;
        if (this.a.h(i2) == -1) {
            return null;
        }
        int iE = this.a.e(i2, twVar.c);
        if (iE < 0) {
            if (this.a.i(i2, iE)) {
                return x(esVar, twVar.a, i2, iE, djVar.c, twVar.d);
            }
            return null;
        }
        long jLongValue2 = djVar.c;
        if (jLongValue2 == -9223372036854775807L) {
            er erVar = this.b;
            eq eqVar = this.a;
            Pair<Object, Long> pairY2 = esVar.y(erVar, eqVar, eqVar.c, -9223372036854775807L, Math.max(0L, jC));
            if (pairY2 == null) {
                return null;
            }
            jLongValue2 = ((Long) pairY2.second).longValue();
        }
        return y(esVar, twVar.a, jLongValue2, djVar.c, twVar.d);
    }

    private final dj w(es esVar, tw twVar, long j, long j2) {
        esVar.g(twVar.a, this.a);
        if (!twVar.b()) {
            return y(esVar, twVar.a, j2, j, twVar.d);
        }
        if (this.a.i(twVar.b, twVar.c)) {
            return x(esVar, twVar.a, twVar.b, twVar.c, j, twVar.d);
        }
        return null;
    }

    private final dj x(es esVar, Object obj, int i, int i2, long j, long j2) {
        tw twVar = new tw(obj, i, i2, j2);
        long j3 = esVar.g(twVar.a, this.a).j(twVar.b, twVar.c);
        if (i2 == this.a.d(i)) {
            this.a.k();
        }
        long jMax = 0;
        if (j3 != -9223372036854775807L && j3 <= 0) {
            jMax = Math.max(0L, (-1) + j3);
        }
        return new dj(twVar, jMax, j, -9223372036854775807L, j3, false, false, false);
    }

    private final dj y(es esVar, Object obj, long j, long j2, long j3) {
        long jMax = j;
        esVar.g(obj, this.a);
        int iG = this.a.g(jMax);
        tw twVar = new tw(obj, j3, iG);
        boolean zB = B(twVar);
        boolean z = z(esVar, twVar);
        boolean zA = A(esVar, twVar, zB);
        long jC = iG != -1 ? this.a.c(iG) : -9223372036854775807L;
        long j4 = (jC == -9223372036854775807L || jC == Long.MIN_VALUE) ? this.a.d : jC;
        if (j4 != -9223372036854775807L && jMax >= j4) {
            jMax = Math.max(0L, (-1) + j4);
        }
        return new dj(twVar, jMax, j2, jC, j4, zB, z, zA);
    }

    private final boolean z(es esVar, tw twVar) {
        if (B(twVar)) {
            return esVar.v(esVar.g(twVar.a, this.a).c, this.b).m == esVar.i(twVar.a);
        }
        return false;
    }

    public final boolean a(es esVar, int i) {
        this.f = i;
        return u(esVar);
    }

    public final boolean b(es esVar, boolean z) {
        this.g = z;
        return u(esVar);
    }

    public final boolean c(tv tvVar) {
        di diVar = this.j;
        return diVar != null && diVar.a == tvVar;
    }

    public final void d(long j) {
        di diVar = this.j;
        if (diVar != null) {
            diVar.i(j);
        }
    }

    public final boolean e() {
        di diVar = this.j;
        if (diVar != null) {
            return !diVar.f.h && diVar.e() && this.j.f.e != -9223372036854775807L && this.k < 100;
        }
        return true;
    }

    public final dj f(long j, du duVar) {
        di diVar = this.j;
        return diVar == null ? w(duVar.a, duVar.b, duVar.c, duVar.r) : v(duVar.a, diVar, j);
    }

    public final di g() {
        return this.j;
    }

    public final di h() {
        return this.h;
    }

    public final di i() {
        return this.i;
    }

    public final di j() {
        di diVar = this.i;
        boolean z = false;
        if (diVar != null && diVar.o() != null) {
            z = true;
        }
        ary.q(z);
        this.i = this.i.o();
        s();
        return this.i;
    }

    public final di k() {
        di diVar = this.h;
        if (diVar == null) {
            return null;
        }
        if (diVar == this.i) {
            this.i = diVar.o();
        }
        this.h.m();
        int i = this.k - 1;
        this.k = i;
        if (i == 0) {
            this.j = null;
            di diVar2 = this.h;
            this.l = diVar2.b;
            this.m = diVar2.f.a.d;
        }
        this.h = this.h.o();
        s();
        return this.h;
    }

    public final boolean l(di diVar) {
        boolean z = false;
        ary.q(diVar != null);
        if (diVar.equals(this.j)) {
            return false;
        }
        this.j = diVar;
        while (diVar.o() != null) {
            diVar = diVar.o();
            if (diVar == this.i) {
                this.i = this.h;
                z = true;
            }
            diVar.m();
            this.k--;
        }
        this.j.n(null);
        s();
        return z;
    }

    public final void m() {
        if (this.k == 0) {
            return;
        }
        di diVarO = this.h;
        ary.s(diVarO);
        this.l = diVarO.b;
        this.m = diVarO.f.a.d;
        while (diVarO != null) {
            diVarO.m();
            diVarO = diVarO.o();
        }
        this.h = null;
        this.j = null;
        this.i = null;
        this.k = 0;
        s();
    }

    public final boolean n(es esVar, long j, long j2) {
        dj djVarO;
        es esVar2 = esVar;
        di diVarO = this.h;
        di diVar = null;
        while (diVarO != null) {
            dj djVar = diVarO.f;
            if (diVar == null) {
                djVarO = o(esVar2, djVar);
            } else {
                dj djVarV = v(esVar2, diVar, j);
                if (djVarV == null) {
                    return !l(diVar);
                }
                if (djVar.b != djVarV.b || !djVar.a.equals(djVarV.a)) {
                    return !l(diVar);
                }
                djVarO = djVarV;
            }
            long j3 = djVar.c;
            diVarO.f = j3 == djVarO.c ? djVarO : new dj(djVarO.a, djVarO.b, j3, djVarO.d, djVarO.e, djVarO.f, djVarO.g, djVarO.h);
            long j4 = djVar.e;
            long j5 = djVarO.e;
            if (j4 != -9223372036854775807L && j4 != j5) {
                return (l(diVarO) || (diVarO == this.i && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((j5 > (-9223372036854775807L) ? 1 : (j5 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : diVarO.a(j5)) ? 1 : (j2 == ((j5 > (-9223372036854775807L) ? 1 : (j5 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : diVarO.a(j5)) ? 0 : -1)) >= 0))) ? false : true;
            }
            diVar = diVarO;
            diVarO = diVarO.o();
            esVar2 = esVar;
        }
        return true;
    }

    public final dj o(es esVar, dj djVar) {
        long j;
        tw twVar = djVar.a;
        boolean zB = B(twVar);
        boolean z = z(esVar, twVar);
        boolean zA = A(esVar, twVar, zB);
        esVar.g(djVar.a.a, this.a);
        if (twVar.b()) {
            j = this.a.j(twVar.b, twVar.c);
        } else {
            j = djVar.d;
            if (j == -9223372036854775807L || j == Long.MIN_VALUE) {
                j = this.a.d;
            }
        }
        return new dj(twVar, djVar.b, djVar.c, djVar.d, j, zB, z, zA);
    }

    public final tw p(es esVar, Object obj, long j) {
        long j2;
        int i;
        int i2 = esVar.g(obj, this.a).c;
        Object obj2 = this.l;
        if (obj2 == null || (i = esVar.i(obj2)) == -1 || esVar.z(i, this.a).c != i2) {
            di diVarO = this.h;
            while (true) {
                if (diVarO == null) {
                    di diVarO2 = this.h;
                    while (true) {
                        if (diVarO2 != null) {
                            int i3 = esVar.i(diVarO2.b);
                            if (i3 != -1 && esVar.z(i3, this.a).c == i2) {
                                j2 = diVarO2.f.a.d;
                                break;
                            }
                            diVarO2 = diVarO2.o();
                        } else {
                            j2 = this.e;
                            this.e = 1 + j2;
                            if (this.h == null) {
                                this.l = obj;
                                this.m = j2;
                            }
                        }
                    }
                } else {
                    if (diVarO.b.equals(obj)) {
                        j2 = diVarO.f.a.d;
                        break;
                    }
                    diVarO = diVarO.o();
                }
            }
        } else {
            j2 = this.m;
        }
        return t(esVar, obj, j, j2, this.a);
    }

    final /* synthetic */ void q(ark arkVar, tw twVar) {
        this.c.J(arkVar.c(), twVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.ads.interactivemedia.v3.internal.di r(com.google.ads.interactivemedia.v3.internal.ee[] r12, com.google.ads.interactivemedia.v3.internal.abf r13, com.google.ads.interactivemedia.v3.internal.acc r14, com.google.ads.interactivemedia.v3.internal.ds r15, com.google.ads.interactivemedia.v3.internal.dj r16, com.google.ads.interactivemedia.v3.internal.abg r17) {
        /*
            r11 = this;
            r0 = r11
            r8 = r16
            com.google.ads.interactivemedia.v3.internal.di r1 = r0.j
            r2 = 0
            if (r1 != 0) goto L20
            com.google.ads.interactivemedia.v3.internal.tw r1 = r8.a
            boolean r1 = r1.b()
            if (r1 == 0) goto L1e
            long r4 = r8.c
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L1e
            r3 = r4
            goto L2f
        L1e:
            r3 = r2
            goto L2f
        L20:
            long r1 = r1.c()
            com.google.ads.interactivemedia.v3.internal.di r3 = r0.j
            com.google.ads.interactivemedia.v3.internal.dj r3 = r3.f
            long r3 = r3.e
            long r1 = r1 + r3
            long r3 = r8.b
            long r1 = r1 - r3
            r3 = r1
        L2f:
            com.google.ads.interactivemedia.v3.internal.di r10 = new com.google.ads.interactivemedia.v3.internal.di
            r1 = r10
            r2 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r1.<init>(r2, r3, r5, r6, r7, r8, r9)
            com.google.ads.interactivemedia.v3.internal.di r1 = r0.j
            if (r1 == 0) goto L45
            r1.n(r10)
            goto L49
        L45:
            r0.h = r10
            r0.i = r10
        L49:
            r1 = 0
            r0.l = r1
            r0.j = r10
            int r1 = r0.k
            int r1 = r1 + 1
            r0.k = r1
            r11.s()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.dl.r(com.google.ads.interactivemedia.v3.internal.ee[], com.google.ads.interactivemedia.v3.internal.abf, com.google.ads.interactivemedia.v3.internal.acc, com.google.ads.interactivemedia.v3.internal.ds, com.google.ads.interactivemedia.v3.internal.dj, com.google.ads.interactivemedia.v3.internal.abg):com.google.ads.interactivemedia.v3.internal.di");
    }
}
