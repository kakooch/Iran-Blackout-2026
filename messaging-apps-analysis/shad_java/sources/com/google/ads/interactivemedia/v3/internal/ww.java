package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseArray;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ww extends ss {
    private int A;
    private long B;
    private int C;
    private final wz D;
    private final acj E;
    private final aqd F;
    private final abw a;
    private final jh b;
    private final long c;
    private final ug d;
    private final adc<? extends xj> e;
    private final wr f;
    private final Object g;
    private final SparseArray<wj> h;
    private final Runnable i;
    private final Runnable j;
    private final xf k;
    private final adb l;
    private abx m;
    private ada n;
    private adh o;
    private IOException p;
    private Handler q;
    private dg r;
    private df s;
    private Uri t;
    private final Uri u;
    private xj v;
    private boolean w;
    private long x;
    private long y;
    private long z;

    static {
        cv.b("goog.exo.dash");
    }

    /* synthetic */ ww(dg dgVar, abw abwVar, adc adcVar, wz wzVar, aqd aqdVar, jh jhVar, acj acjVar, long j, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.r = dgVar;
        df dfVar = dgVar.b;
        ary.t(dfVar);
        this.s = dfVar;
        Uri uri = dfVar.a;
        this.t = uri;
        this.u = uri;
        this.v = null;
        this.a = abwVar;
        this.e = adcVar;
        this.D = wzVar;
        this.b = jhVar;
        this.E = acjVar;
        this.c = j;
        this.F = aqdVar;
        this.d = f(null);
        this.g = new Object();
        this.h = new SparseArray<>();
        this.k = new wo(this);
        this.B = -9223372036854775807L;
        this.z = -9223372036854775807L;
        this.f = new wr(this);
        this.l = new ws(this);
        this.i = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.wk
            private final ww a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.K();
            }
        };
        this.j = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.wl
            private final ww a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.F();
            }
        };
    }

    private final void L(yd ydVar, adc<Long> adcVar) {
        S(new add(this.m, Uri.parse(ydVar.b), 5, adcVar), new wu(this), 1);
    }

    private final void M() {
        aen.c(this.n, new wm(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(long j) {
        this.z = j;
        P(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(IOException iOException) {
        adu.b("DashMediaSource", "Failed to resolve time offset.", iOException);
        P(true);
    }

    private final void P(boolean z) {
        long j;
        boolean z2;
        long j2;
        xo xoVar;
        for (int i = 0; i < this.h.size(); i++) {
            int iKeyAt = this.h.keyAt(i);
            if (iKeyAt >= this.C) {
                this.h.valueAt(i).p(this.v, iKeyAt - this.C);
            }
        }
        int iB = this.v.b() - 1;
        xo xoVarC = this.v.c(iB);
        long jE = this.v.e(iB);
        long jB = bi.b(aeu.ai(this.z));
        wt wtVarA = wt.a(this.v.c(0), this.v.e(0), jB);
        wt wtVarA2 = wt.a(xoVarC, jE, jB);
        long jMax = wtVarA.b;
        long jMin = wtVarA2.c;
        if (!this.v.d || wtVarA2.a) {
            j = jMax;
            z2 = false;
        } else {
            jMin = Math.min(jMin - bi.b(xoVarC.b), jMin);
            long j3 = this.v.f;
            if (j3 != -9223372036854775807L) {
                long jB2 = jMin - bi.b(j3);
                while (jB2 < 0 && iB > 0) {
                    iB--;
                    jB2 += this.v.e(iB);
                }
                jMax = iB == 0 ? Math.max(jMax, jB2) : this.v.e(0);
            }
            z2 = true;
            j = jMax;
        }
        long j4 = jMin - j;
        long jE2 = j4;
        for (int i2 = 0; i2 < this.v.b() - 1; i2++) {
            jE2 += this.v.e(i2);
        }
        xj xjVar = this.v;
        long j5 = xjVar.a;
        long jA = j5 != -9223372036854775807L ? j5 + xjVar.c(0).b + bi.a(j) : -9223372036854775807L;
        if (this.v.d) {
            long jB3 = (j + jB) - bi.b(jA);
            long jB4 = bi.b(this.r.c.b);
            long j6 = jB3 - jMin;
            if (jB4 < j6) {
                jB4 = j6;
            }
            long j7 = jB3 - j;
            if (jB4 > j7) {
                jB4 = j7 - Math.min(5000000L, j4 / 2);
            }
            long jA2 = bi.a(jB4);
            dg dgVarA = this.r;
            if (dgVarA.c.b != jA2) {
                db dbVarA = dgVarA.a();
                dbVarA.d(jA2);
                dgVarA = dbVarA.a();
                this.r = dgVarA;
                this.s = dgVarA.b;
            }
            long jB5 = jB - bi.b(jA + dgVarA.c.b);
            long jMin2 = Math.min(5000000L, jE2 / 2);
            j2 = jB5 < jMin2 ? jMin2 : jB5;
        } else {
            j2 = 0;
        }
        xj xjVar2 = this.v;
        e(new wn(xjVar2.a, jA, this.z, this.C, j, jE2, j2, xjVar2, this.r));
        this.q.removeCallbacks(this.j);
        if (z2) {
            Handler handler = this.q;
            Runnable runnable = this.j;
            xj xjVar3 = this.v;
            long jAi = aeu.ai(this.z);
            int iB2 = xjVar3.b() - 1;
            xo xoVarC2 = xjVar3.c(iB2);
            long jB6 = bi.b(xoVarC2.b);
            long jE3 = xjVar3.e(iB2);
            long jB7 = bi.b(jAi);
            long jB8 = bi.b(xjVar3.a);
            long jB9 = bi.b(5000L);
            int i3 = 0;
            while (i3 < xoVarC2.c.size()) {
                List<xt> list = xoVarC2.c.get(i3).c;
                if (list.isEmpty()) {
                    xoVar = xoVarC2;
                } else {
                    xoVar = xoVarC2;
                    wx wxVarL = list.get(0).l();
                    if (wxVarL != null) {
                        long jI = ((jB8 + jB6) + wxVarL.i(jE3, jB7)) - jB7;
                        if (jI < jB9 - 100000 || (jI > jB9 && jI < jB9 + 100000)) {
                            jB9 = jI;
                        }
                    }
                }
                i3++;
                xoVarC2 = xoVar;
            }
            handler.postDelayed(runnable, ast.a(jB9, RoundingMode.CEILING));
        }
        if (this.w) {
            K();
            return;
        }
        if (z) {
            xj xjVar4 = this.v;
            if (xjVar4.d) {
                long j8 = xjVar4.e;
                if (j8 != -9223372036854775807L) {
                    if (j8 == 0) {
                        j8 = 5000;
                    }
                    Q(Math.max(0L, (this.x + j8) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    private final void Q(long j) {
        this.q.postDelayed(this.i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public final void K() {
        Uri uri;
        this.q.removeCallbacks(this.i);
        if (this.n.c()) {
            return;
        }
        if (this.n.f()) {
            this.w = true;
            return;
        }
        synchronized (this.g) {
            uri = this.t;
        }
        this.w = false;
        S(new add(this.m, uri, 4, this.e), this.f, this.E.a(4));
    }

    private final <T> void S(add<T> addVar, act<add<T>> actVar, int i) {
        this.n.e(addVar, actVar, i);
        this.d.d(new to(addVar.b), addVar.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6 A[PHI: r13
      0x00c6: PHI (r13v6 long) = (r13v0 long), (r13v2 long), (r13v3 long) binds: [B:29:0x00c4, B:37:0x00d7, B:34:0x00d0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void A(com.google.ads.interactivemedia.v3.internal.add<com.google.ads.interactivemedia.v3.internal.xj> r18, long r19, long r21) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ww.A(com.google.ads.interactivemedia.v3.internal.add, long, long):void");
    }

    final acu B(add<xj> addVar, long j, long j2, IOException iOException, int i) {
        long j3 = addVar.a;
        addVar.e();
        addVar.f();
        addVar.d();
        to toVar = new to();
        new tt(addVar.c);
        long jC = acj.c(new acr(iOException, i));
        acu acuVarB = jC == -9223372036854775807L ? ada.b : ada.b(false, jC);
        this.d.m(toVar, addVar.c, iOException, !acuVarB.a());
        return acuVarB;
    }

    final void C(add<Long> addVar, long j, long j2) {
        long j3 = addVar.a;
        addVar.e();
        addVar.f();
        addVar.d();
        this.d.g(new to(), addVar.c);
        N(addVar.a().longValue() - j);
    }

    final acu D(add<Long> addVar, long j, long j2, IOException iOException) {
        ug ugVar = this.d;
        long j3 = addVar.a;
        addVar.e();
        addVar.f();
        addVar.d();
        ugVar.m(new to(), addVar.c, iOException, true);
        O(iOException);
        return ada.a;
    }

    final void E(add<?> addVar, long j, long j2) {
        long j3 = addVar.a;
        addVar.e();
        addVar.f();
        addVar.d();
        this.d.j(new to(), addVar.c);
    }

    final /* synthetic */ void F() {
        P(false);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final dg U() {
        return this.r;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void V(tv tvVar) {
        wj wjVar = (wj) tvVar;
        wjVar.q();
        this.h.remove(wjVar.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final tv W(tw twVar, acc accVar, long j) {
        int iIntValue = ((Integer) twVar.a).intValue() - this.C;
        ug ugVarG = g(twVar, this.v.c(iIntValue).b);
        wj wjVar = new wj(iIntValue + this.C, this.v, iIntValue, this.D, this.o, this.b, h(twVar), this.E, ugVarG, this.z, this.l, accVar, this.F, this.k, null, null, null);
        this.h.put(wjVar.a, wjVar);
        return wjVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ss
    protected final void a(adh adhVar) {
        this.o = adhVar;
        this.b.b();
        this.m = this.a.a();
        this.n = new ada("Loader:DashMediaSource");
        this.q = aeu.k();
        K();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ss
    protected final void d() {
        this.w = false;
        this.m = null;
        ada adaVar = this.n;
        if (adaVar != null) {
            adaVar.h();
            this.n = null;
        }
        this.x = 0L;
        this.y = 0L;
        this.v = null;
        this.t = this.u;
        this.p = null;
        Handler handler = this.q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.q = null;
        }
        this.z = -9223372036854775807L;
        this.A = 0;
        this.B = -9223372036854775807L;
        this.C = 0;
        this.h.clear();
        this.b.c();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ty
    public final void u() throws IOException {
        this.l.a();
    }

    final void y() {
        this.q.removeCallbacks(this.j);
        K();
    }

    final void z(long j) {
        long j2 = this.B;
        if (j2 == -9223372036854775807L || j2 < j) {
            this.B = j;
        }
    }
}
