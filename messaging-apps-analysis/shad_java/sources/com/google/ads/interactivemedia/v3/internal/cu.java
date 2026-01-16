package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class cu implements Handler.Callback, tu, dr, bl, dy {
    private boolean A;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    private ct H;
    private long I;
    private int J;
    private boolean K;
    private bn L;
    private final bk N;
    private final bj O;
    private final ed[] a;
    private final ee[] b;
    private final abf c;
    private final abg d;
    private final abq e;
    private final adp f;
    private final HandlerThread g;
    private final Looper h;
    private final er i;
    private final eq j;
    private final long k;
    private final bm m;
    private final ArrayList<cp> n;
    private final adk o;
    private final cr p;
    private final dl q;
    private final ds r;
    private final long s;
    private eg t;
    private du u;
    private cq v;
    private boolean w;
    private boolean y;
    private boolean z;
    private int B = 0;
    private boolean C = false;
    private boolean x = false;
    private boolean M = true;
    private final boolean l = false;

    public cu(ed[] edVarArr, abf abfVar, abg abgVar, bk bkVar, abq abqVar, gj gjVar, eg egVar, bj bjVar, long j, boolean z, Looper looper, adk adkVar, cr crVar) {
        this.p = crVar;
        this.a = edVarArr;
        this.c = abfVar;
        this.d = abgVar;
        this.N = bkVar;
        this.e = abqVar;
        this.t = egVar;
        this.O = bjVar;
        this.s = j;
        this.o = adkVar;
        this.k = bkVar.d();
        du duVarA = du.a(abgVar);
        this.u = duVarA;
        this.v = new cq(duVarA);
        int length = edVarArr.length;
        this.b = new ee[2];
        for (int i = 0; i < 2; i++) {
            edVarArr[i].c(i);
            this.b[i] = edVarArr[i].b();
        }
        this.m = new bm(this, adkVar);
        this.n = new ArrayList<>();
        this.i = new er();
        this.j = new eq();
        abfVar.h(abqVar);
        this.K = true;
        Handler handler = new Handler(looper);
        this.q = new dl(gjVar, handler);
        this.r = new ds(this, gjVar, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.g = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.h = looper2;
        this.f = adkVar.c(looper2, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:213:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x045e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0472  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void A() throws com.google.ads.interactivemedia.v3.internal.bn, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.cu.A():void");
    }

    private final long B(es esVar, Object obj, long j) {
        esVar.v(esVar.g(obj, this.j).c, this.i);
        er erVar = this.i;
        if (erVar.f != -9223372036854775807L && erVar.j && erVar.i) {
            return bi.b(aeu.ai(erVar.g) - this.i.f) - (j + this.j.b());
        }
        return -9223372036854775807L;
    }

    private final boolean C(es esVar, tw twVar) {
        if (!twVar.b() && !esVar.u()) {
            esVar.v(esVar.g(twVar.a, this.j).c, this.i);
            er erVar = this.i;
            if (erVar.j && erVar.i) {
                return true;
            }
        }
        return false;
    }

    private final void D(long j, long j2) {
        this.f.e();
        this.f.g(j + j2);
    }

    private final long E(tw twVar, long j, boolean z) throws bn {
        return F(twVar, j, this.q.h() != this.q.i(), z);
    }

    private final long F(tw twVar, long j, boolean z, boolean z2) throws bn {
        y();
        this.z = false;
        if (z2 || this.u.d == 3) {
            t(2);
        }
        di diVarH = this.q.h();
        di diVarO = diVarH;
        while (diVarO != null && !twVar.equals(diVarO.f.a)) {
            diVarO = diVarO.o();
        }
        if (z || diVarH != diVarO || (diVarO != null && diVarO.a(j) < 0)) {
            ed[] edVarArr = this.a;
            int length = edVarArr.length;
            for (int i = 0; i < 2; i++) {
                M(edVarArr[i]);
            }
            if (diVarO != null) {
                while (this.q.h() != diVarO) {
                    this.q.k();
                }
                this.q.l(diVarO);
                diVarO.s();
                V();
            }
        }
        if (diVarO != null) {
            this.q.l(diVarO);
            if (diVarO.d) {
                long j2 = diVarO.f.e;
                if (j2 != -9223372036854775807L && j >= j2) {
                    j = Math.max(0L, j2 - 1);
                }
                if (diVarO.e) {
                    long jI = diVarO.a.i(j);
                    diVarO.a.e(jI - this.k, false);
                    j = jI;
                }
            } else {
                diVarO.f = diVarO.f.a(j);
            }
            G(j);
            R();
        } else {
            this.q.m();
            G(j);
        }
        X(false);
        this.f.f(2);
        return j;
    }

    private final void G(long j) throws bn {
        di diVarH = this.q.h();
        if (diVarH != null) {
            j = diVarH.a(j);
        }
        this.I = j;
        this.m.c(j);
        ed[] edVarArr = this.a;
        int length = edVarArr.length;
        for (int i = 0; i < 2; i++) {
            ed edVar = edVarArr[i];
            if (ah(edVar)) {
                edVar.o(this.I);
            }
        }
        for (di diVarH2 = this.q.h(); diVarH2 != null; diVarH2 = diVarH2.o()) {
            for (aba abaVar : diVarH2.q().c.b()) {
            }
        }
    }

    private final void H(boolean z, boolean z2) {
        I(z || !this.D, false, true, false);
        this.v.a(z2 ? 1 : 0);
        this.N.b();
        t(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void I(boolean r28, boolean r29, boolean r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.cu.I(boolean, boolean, boolean, boolean):void");
    }

    private final Pair<tw, Long> J(es esVar) {
        long j = 0;
        if (esVar.u()) {
            return Pair.create(du.b(), 0L);
        }
        Pair<Object, Long> pairX = esVar.x(this.i, this.j, esVar.e(this.C), -9223372036854775807L);
        tw twVarP = this.q.p(esVar, pairX.first, 0L);
        long jLongValue = ((Long) pairX.second).longValue();
        if (twVarP.b()) {
            esVar.g(twVarP.a, this.j);
            if (twVarP.c == this.j.d(twVarP.b)) {
                this.j.k();
            }
        } else {
            j = jLongValue;
        }
        return Pair.create(twVarP, Long.valueOf(j));
    }

    private final void K(ea eaVar) throws bn {
        if (eaVar.e().getLooper() != this.h) {
            this.f.b(15, eaVar).sendToTarget();
            return;
        }
        ai(eaVar);
        int i = this.u.d;
        if (i == 3 || i == 2) {
            this.f.f(2);
        }
    }

    private final void L(es esVar, es esVar2) {
        if (esVar.u() && esVar2.u()) {
            return;
        }
        int size = this.n.size();
        while (true) {
            size--;
            if (size < 0) {
                Collections.sort(this.n);
                return;
            } else if (!ae(this.n.get(size), esVar, esVar2, this.B, this.C, this.i, this.j)) {
                this.n.get(size).a.j(false);
                this.n.remove(size);
            }
        }
    }

    private final void M(ed edVar) throws bn {
        if (ah(edVar)) {
            this.m.e(edVar);
            aj(edVar);
            edVar.q();
            this.G--;
        }
    }

    private final boolean N() {
        di diVarH = this.q.h();
        long j = diVarH.f.e;
        if (diVarH.d) {
            return j == -9223372036854775807L || this.u.r < j || !ac();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0246 A[Catch: all -> 0x02c8, TryCatch #0 {all -> 0x02c8, blocks: (B:110:0x0240, B:112:0x0246, B:115:0x024d, B:117:0x0257, B:119:0x025f, B:121:0x0269, B:122:0x0273, B:123:0x0278), top: B:159:0x01e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f6 A[PHI: r16
      0x01f6: PHI (r16v2 long) = (r16v0 long), (r16v1 long) binds: [B:91:0x01f4, B:94:0x0201] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r11v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r22v10, types: [long] */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v17 */
    /* JADX WARN: Type inference failed for: r22v18 */
    /* JADX WARN: Type inference failed for: r22v23 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.google.ads.interactivemedia.v3.internal.cu] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void O(com.google.ads.interactivemedia.v3.internal.es r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.cu.O(com.google.ads.interactivemedia.v3.internal.es):void");
    }

    private final void P(es esVar, tw twVar, es esVar2, tw twVar2, long j) {
        if (esVar.u() || !C(esVar, twVar)) {
            return;
        }
        esVar.v(esVar.g(twVar.a, this.j).c, this.i);
        this.O.a(this.i.c.c);
        if (j != -9223372036854775807L) {
            this.O.b(B(esVar, twVar.a, j));
            return;
        }
        if (aeu.c(!esVar2.u() ? esVar2.v(esVar2.g(twVar2.a, this.j).c, this.i).b : null, this.i.b)) {
            return;
        }
        this.O.b(-9223372036854775807L);
    }

    private final void Q() {
        di diVarH = this.q.h();
        boolean z = false;
        if (diVarH != null && diVarH.f.g && this.x) {
            z = true;
        }
        this.y = z;
    }

    private final void R() {
        boolean zH;
        if (S()) {
            di diVarG = this.q.g();
            long jZ = Z(diVarG.g());
            if (diVarG == this.q.h()) {
                diVarG.b(this.I);
            } else {
                diVarG.b(this.I);
                long j = diVarG.f.b;
            }
            zH = this.N.h(jZ, this.m.i().b);
        } else {
            zH = false;
        }
        this.A = zH;
        if (zH) {
            this.q.g().j(this.I);
        }
        T();
    }

    private final boolean S() {
        di diVarG = this.q.g();
        return (diVarG == null || diVarG.g() == Long.MIN_VALUE) ? false : true;
    }

    private final void T() {
        di diVarG = this.q.g();
        boolean z = this.A || (diVarG != null && diVarG.a.o());
        du duVar = this.u;
        if (z != duVar.f) {
            this.u = new du(duVar.a, duVar.b, duVar.c, duVar.d, duVar.e, z, duVar.g, duVar.h, duVar.i, duVar.j, duVar.k, duVar.l, duVar.m, duVar.p, duVar.q, duVar.r, duVar.n, duVar.o);
        }
    }

    private final du U(tw twVar, long j, long j2) {
        List<qz> listI;
        vj vjVar;
        abg abgVar;
        boolean z = true;
        if (!this.K && j == this.u.r && twVar.equals(this.u.b)) {
            z = false;
        }
        this.K = z;
        Q();
        du duVar = this.u;
        vj vjVar2 = duVar.g;
        abg abgVar2 = duVar.h;
        List<qz> list = duVar.i;
        if (this.r.a()) {
            di diVarH = this.q.h();
            vj vjVarP = diVarH == null ? vj.a : diVarH.p();
            abg abgVarQ = diVarH == null ? this.d : diVarH.q();
            abb abbVar = abgVarQ.c;
            ark arkVar = new ark();
            for (int i = 0; i < abbVar.a; i++) {
                aba abaVarA = abbVar.a(i);
                if (abaVarA != null) {
                    qz qzVar = abaVarA.m(0).j;
                    if (qzVar == null) {
                        qzVar = new qz(new qy[0]);
                    }
                    arkVar.d(qzVar);
                }
            }
            abgVar = abgVarQ;
            listI = arkVar.c();
            vjVar = vjVarP;
        } else if (twVar.equals(this.u.b)) {
            listI = list;
            vjVar = vjVar2;
            abgVar = abgVar2;
        } else {
            vjVar = vj.a;
            abgVar = this.d;
            listI = arn.i();
        }
        return this.u.c(twVar, j, j2, Y(), vjVar, abgVar, listI);
    }

    private final void V() throws bn {
        int length = this.a.length;
        W(new boolean[2]);
    }

    private final void W(boolean[] zArr) throws bn {
        di diVarI = this.q.i();
        abg abgVarQ = diVarI.q();
        int i = 0;
        while (true) {
            int length = this.a.length;
            if (i >= 2) {
                break;
            }
            if (!abgVarQ.a(i)) {
                this.a[i].r();
            }
            i++;
        }
        int i2 = 0;
        while (true) {
            int length2 = this.a.length;
            if (i2 >= 2) {
                diVarI.g = true;
                return;
            }
            if (abgVarQ.a(i2)) {
                boolean z = zArr[i2];
                ed edVar = this.a[i2];
                if (!ah(edVar)) {
                    di diVarI2 = this.q.i();
                    boolean z2 = diVarI2 == this.q.h();
                    abg abgVarQ2 = diVarI2.q();
                    ef efVar = abgVarQ2.b[i2];
                    cy[] cyVarArrAg = ag(abgVarQ2.c.a(i2));
                    boolean z3 = ac() && this.u.d == 3;
                    boolean z4 = !z && z3;
                    this.G++;
                    edVar.f(efVar, cyVarArrAg, diVarI2.c[i2], this.I, z4, z2, diVarI2.d(), diVarI2.c());
                    edVar.t(103, new cm(this));
                    this.m.d(edVar);
                    if (z3) {
                        edVar.aX();
                    }
                }
            }
            i2++;
        }
    }

    private final void X(boolean z) {
        di diVarG = this.q.g();
        tw twVar = diVarG == null ? this.u.b : diVarG.f.a;
        boolean z2 = !this.u.j.equals(twVar);
        if (z2) {
            this.u = this.u.g(twVar);
        }
        du duVar = this.u;
        duVar.p = diVarG == null ? duVar.r : diVarG.f();
        this.u.q = Y();
        if ((z2 || z) && diVarG != null && diVarG.d) {
            aa(diVarG.p(), diVarG.q());
        }
    }

    private final long Y() {
        return Z(this.u.p);
    }

    private final long Z(long j) {
        di diVarG = this.q.g();
        if (diVarG == null) {
            return 0L;
        }
        return Math.max(0L, j - diVarG.b(this.I));
    }

    private final void aa(vj vjVar, abg abgVar) {
        this.N.g(this.a, abgVar.c);
    }

    private final void ab(dv dvVar, boolean z) {
        this.f.c(16, z ? 1 : 0, 0, dvVar).sendToTarget();
    }

    private final boolean ac() {
        du duVar = this.u;
        return duVar.k && duVar.l == 0;
    }

    private static boolean ad(du duVar, eq eqVar, er erVar) {
        tw twVar = duVar.b;
        es esVar = duVar.a;
        return twVar.b() || esVar.u() || esVar.v(esVar.g(twVar.a, eqVar).c, erVar).k;
    }

    private static boolean ae(cp cpVar, es esVar, es esVar2, int i, boolean z, er erVar, eq eqVar) {
        Object obj = cpVar.d;
        if (obj == null) {
            cpVar.a.f();
            Pair<Object, Long> pairAf = af(esVar, new ct(cpVar.a.a(), cpVar.a.g(), bi.b(cpVar.a.f())), false, i, z, erVar, eqVar);
            if (pairAf == null) {
                return false;
            }
            cpVar.a(esVar.i(pairAf.first), ((Long) pairAf.second).longValue(), pairAf.first);
            cpVar.a.f();
            return true;
        }
        int i2 = esVar.i(obj);
        if (i2 == -1) {
            return false;
        }
        cpVar.a.f();
        cpVar.b = i2;
        esVar2.g(cpVar.d, eqVar);
        if (esVar2.v(eqVar.c, erVar).k) {
            Pair<Object, Long> pairX = esVar.x(erVar, eqVar, esVar.g(cpVar.d, eqVar).c, cpVar.c + eqVar.b());
            cpVar.a(esVar.i(pairX.first), ((Long) pairX.second).longValue(), pairX.first);
        }
        return true;
    }

    private static Pair<Object, Long> af(es esVar, ct ctVar, boolean z, int i, boolean z2, er erVar, eq eqVar) {
        Pair<Object, Long> pairX;
        Object objL;
        es esVar2 = ctVar.a;
        if (esVar.u()) {
            return null;
        }
        es esVar3 = true == esVar2.u() ? esVar : esVar2;
        try {
            pairX = esVar3.x(erVar, eqVar, ctVar.b, ctVar.c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (esVar.equals(esVar3)) {
            return pairX;
        }
        if (esVar.i(pairX.first) != -1) {
            esVar3.g(pairX.first, eqVar);
            return esVar3.v(eqVar.c, erVar).k ? esVar.x(erVar, eqVar, esVar.g(pairX.first, eqVar).c, ctVar.c) : pairX;
        }
        if (z && (objL = l(erVar, eqVar, i, z2, pairX.first, esVar3, esVar)) != null) {
            return esVar.x(erVar, eqVar, esVar.g(objL, eqVar).c, -9223372036854775807L);
        }
        return null;
    }

    private static cy[] ag(aba abaVar) {
        int iL = abaVar != null ? abaVar.l() : 0;
        cy[] cyVarArr = new cy[iL];
        for (int i = 0; i < iL; i++) {
            cyVarArr[i] = abaVar.m(i);
        }
        return cyVarArr;
    }

    private static boolean ah(ed edVar) {
        return edVar.e() != 0;
    }

    private static final void ai(ea eaVar) throws bn {
        eaVar.i();
        try {
            eaVar.b().t(eaVar.c(), eaVar.d());
        } finally {
            eaVar.j(true);
        }
    }

    private static final void aj(ed edVar) throws bn {
        if (edVar.e() == 2) {
            edVar.p();
        }
    }

    static Object l(er erVar, eq eqVar, int i, boolean z, Object obj, es esVar, es esVar2) {
        int i2 = esVar.i(obj);
        int iT = esVar.t();
        int i3 = 0;
        int iW = i2;
        int i4 = -1;
        while (true) {
            if (i3 >= iT || i4 != -1) {
                break;
            }
            iW = esVar.w(iW, eqVar, erVar, i, z);
            if (iW == -1) {
                i4 = -1;
                break;
            }
            i4 = esVar2.i(esVar.j(iW));
            i3++;
        }
        if (i4 == -1) {
            return null;
        }
        return esVar2.j(i4);
    }

    private final synchronized void s(aqe<Boolean> aqeVar, long j) {
        long jA = this.o.a() + j;
        boolean z = false;
        while (!aqeVar.a().booleanValue() && j > 0) {
            try {
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jA - this.o.a();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private final void t(int i) {
        du duVar = this.u;
        if (duVar.d != i) {
            this.u = duVar.e(i);
        }
    }

    private final void u() {
        this.v.b(this.u);
        if (this.v.g) {
            this.p.a(this.v);
            this.v = new cq(this.u);
        }
    }

    private final void v(boolean z, int i, boolean z2, int i2) throws bn {
        this.v.a(z2 ? 1 : 0);
        this.v.d(i2);
        this.u = this.u.h(z, i);
        this.z = false;
        if (!ac()) {
            y();
            z();
            return;
        }
        int i3 = this.u.d;
        if (i3 == 3) {
            x();
            this.f.f(2);
        } else if (i3 == 2) {
            this.f.f(2);
        }
    }

    private final void w(boolean z) throws bn {
        tw twVar = this.q.h().f.a;
        long jF = F(twVar, this.u.r, true, false);
        if (jF != this.u.r) {
            this.u = U(twVar, jF, this.u.c);
            if (z) {
                this.v.c(4);
            }
        }
    }

    private final void x() throws bn {
        this.z = false;
        this.m.a();
        ed[] edVarArr = this.a;
        int length = edVarArr.length;
        for (int i = 0; i < 2; i++) {
            ed edVar = edVarArr[i];
            if (ah(edVar)) {
                edVar.aX();
            }
        }
    }

    private final void y() throws bn {
        this.m.b();
        ed[] edVarArr = this.a;
        int length = edVarArr.length;
        for (int i = 0; i < 2; i++) {
            ed edVar = edVarArr[i];
            if (ah(edVar)) {
                aj(edVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x009f, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00ce, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void z() throws com.google.ads.interactivemedia.v3.internal.bn {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.cu.z():void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.bl
    public final void a(dv dvVar) {
        ab(dvVar, false);
    }

    public final void b() {
        this.M = false;
    }

    public final void c() {
        this.f.a(0).sendToTarget();
    }

    public final void d(boolean z, int i) {
        this.f.d(z ? 1 : 0, i).sendToTarget();
    }

    public final void e(es esVar, int i, long j) {
        this.f.b(3, new ct(esVar, i, j)).sendToTarget();
    }

    public final void f() {
        this.f.a(6).sendToTarget();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dy
    public final synchronized void g(ea eaVar) {
        if (!this.w && this.g.isAlive()) {
            this.f.b(14, eaVar).sendToTarget();
            return;
        }
        Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        eaVar.j(false);
    }

    public final synchronized boolean h() {
        if (!this.w && this.g.isAlive()) {
            this.f.f(7);
            s(new aqe(this) { // from class: com.google.ads.interactivemedia.v3.internal.ck
                private final cu a;

                {
                    this.a = this;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.aqe
                public final Object a() {
                    return this.a.o();
                }
            }, this.s);
            return this.w;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:258:0x059a A[Catch: OutOfMemoryError -> 0x05ff, RuntimeException -> 0x0601, IOException -> 0x062c, bn -> 0x065a, TryCatch #4 {OutOfMemoryError -> 0x05ff, blocks: (B:3:0x0006, B:4:0x0010, B:7:0x0015, B:9:0x001d, B:13:0x0024, B:14:0x0027, B:277:0x05fb, B:18:0x002e, B:19:0x0031, B:20:0x0032, B:24:0x0039, B:26:0x003d, B:31:0x004a, B:32:0x0051, B:33:0x0059, B:37:0x0060, B:39:0x0069, B:41:0x0077, B:42:0x007f, B:43:0x008a, B:44:0x009e, B:45:0x00b6, B:46:0x00cc, B:48:0x00db, B:49:0x00df, B:50:0x00f0, B:52:0x00ff, B:53:0x011b, B:54:0x012e, B:58:0x0139, B:60:0x0198, B:62:0x01a6, B:64:0x01aa, B:65:0x01ad, B:66:0x01b0, B:67:0x01b5, B:70:0x01bc, B:72:0x01c0, B:73:0x01c5, B:74:0x01c8, B:76:0x01de, B:77:0x01eb, B:78:0x01f5, B:80:0x0201, B:81:0x0206, B:83:0x0210, B:84:0x021c, B:86:0x0235, B:87:0x0241, B:88:0x0247, B:92:0x024e, B:94:0x0256, B:96:0x025a, B:99:0x0261, B:101:0x0269, B:102:0x026c, B:104:0x0271, B:112:0x027f, B:113:0x0280, B:117:0x0287, B:119:0x0295, B:120:0x0299, B:121:0x029f, B:123:0x02af, B:124:0x02b3, B:125:0x02b9, B:127:0x02d0, B:130:0x02d6, B:132:0x02e4, B:136:0x02f0, B:138:0x02f6, B:140:0x02fc, B:144:0x0304, B:146:0x030c, B:148:0x033d, B:150:0x0343, B:151:0x034b, B:152:0x0352, B:154:0x0357, B:156:0x0365, B:158:0x036b, B:159:0x036f, B:161:0x0373, B:162:0x0378, B:163:0x037c, B:167:0x039a, B:169:0x03a4, B:164:0x0380, B:166:0x0389, B:170:0x03b2, B:172:0x03be, B:173:0x03ca, B:175:0x03d6, B:177:0x03fe, B:178:0x041d, B:179:0x0422, B:180:0x0434, B:187:0x043f, B:188:0x0440, B:189:0x0447, B:190:0x044f, B:191:0x0464, B:193:0x0482, B:256:0x0592, B:258:0x059a, B:240:0x0564, B:237:0x0559, B:239:0x0561, B:263:0x05a7, B:265:0x05b3, B:266:0x05b9, B:194:0x04a4, B:198:0x04b7, B:200:0x04c7, B:202:0x04de, B:204:0x04e8, B:267:0x05ba, B:268:0x05be, B:272:0x05c5, B:273:0x05cc, B:276:0x05e7), top: B:313:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x060e  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.cu.handleMessage(android.os.Message):boolean");
    }

    public final Looper i() {
        return this.h;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dr
    public final void j() {
        this.f.f(22);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tu
    public final void k(tv tvVar) {
        this.f.b(8, tvVar).sendToTarget();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vc
    public final /* bridge */ /* synthetic */ void m(vd vdVar) {
        this.f.b(9, (tv) vdVar).sendToTarget();
    }

    final /* synthetic */ void n(ea eaVar) {
        try {
            ai(eaVar);
        } catch (bn e) {
            adu.b("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    final /* synthetic */ Boolean o() {
        return Boolean.valueOf(this.w);
    }

    public final void q(List<dq> list, int i, long j, ve veVar) {
        this.f.b(17, new cn(list, veVar, 0, j)).sendToTarget();
    }
}
