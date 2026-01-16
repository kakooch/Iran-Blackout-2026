package com.google.ads.interactivemedia.v3.internal;

import android.os.Looper;
import android.util.Log;
import com.google.ads.interactivemedia.v3.internal.vy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class vx<T extends vy> implements vb, vd, act, acx {
    public final int a;
    boolean b;
    private final int[] c;
    private final cy[] d;
    private final boolean[] e;
    private final T f;
    private final vc<vx<T>> g;
    private final ug h;
    private final ada i = new ada("Loader:ChunkSampleStream");
    private final vu j = new vu();
    private final ArrayList<vo> k;
    private final List<vo> l;
    private final va m;
    private final va[] n;
    private final vq o;
    private vt p;
    private cy q;
    private vw<T> r;
    private long s;
    private long t;
    private int u;
    private vo v;
    private final acj w;

    /* JADX WARN: Multi-variable type inference failed */
    public vx(int i, int[] iArr, cy[] cyVarArr, vy vyVar, vc vcVar, acc accVar, long j, jh jhVar, je jeVar, acj acjVar, ug ugVar) {
        this.a = i;
        this.c = iArr;
        this.d = cyVarArr;
        this.f = vyVar;
        this.g = vcVar;
        this.h = ugVar;
        this.w = acjVar;
        ArrayList<vo> arrayList = new ArrayList<>();
        this.k = arrayList;
        this.l = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.n = new va[length];
        this.e = new boolean[length];
        int i2 = length + 1;
        int[] iArr2 = new int[i2];
        va[] vaVarArr = new va[i2];
        Looper looperMyLooper = Looper.myLooper();
        ary.t(looperMyLooper);
        va vaVar = new va(accVar, looperMyLooper, jhVar, jeVar);
        this.m = vaVar;
        int i3 = 0;
        iArr2[0] = i;
        vaVarArr[0] = vaVar;
        while (i3 < length) {
            Looper looperMyLooper2 = Looper.myLooper();
            ary.t(looperMyLooper2);
            va vaVar2 = new va(accVar, looperMyLooper2, jh.a, jeVar);
            this.n[i3] = vaVar2;
            int i4 = i3 + 1;
            vaVarArr[i4] = vaVar2;
            iArr2[i4] = this.c[i3];
            i3 = i4;
        }
        this.o = new vq(iArr2, vaVarArr);
        this.s = j;
        this.t = j;
    }

    private final void A() {
        this.m.h();
        for (va vaVar : this.n) {
            vaVar.h();
        }
    }

    private final boolean B(int i) {
        vo voVar = this.k.get(i);
        if (this.m.r() > voVar.d(0)) {
            return true;
        }
        int i2 = 0;
        while (true) {
            va[] vaVarArr = this.n;
            if (i2 >= vaVarArr.length) {
                return false;
            }
            int i3 = i2 + 1;
            if (vaVarArr[i2].r() > voVar.d(i3)) {
                return true;
            }
            i2 = i3;
        }
    }

    private final void C() {
        int iD = D(this.m.r(), this.u - 1);
        while (true) {
            int i = this.u;
            if (i > iD) {
                return;
            }
            this.u = i + 1;
            vo voVar = this.k.get(i);
            cy cyVar = voVar.f;
            if (!cyVar.equals(this.q)) {
                this.h.r(this.a, cyVar, voVar.g, voVar.h, voVar.i);
            }
            this.q = cyVar;
        }
    }

    private final int D(int i, int i2) {
        do {
            i2++;
            if (i2 >= this.k.size()) {
                return this.k.size() - 1;
            }
        } while (this.k.get(i2).d(0) <= i);
        return i2 - 1;
    }

    private final vo E() {
        return this.k.get(r0.size() - 1);
    }

    private final vo F(int i) {
        vo voVar = this.k.get(i);
        ArrayList<vo> arrayList = this.k;
        aeu.e(arrayList, i, arrayList.size());
        this.u = Math.max(this.u, this.k.size());
        int i2 = 0;
        this.m.n(voVar.d(0));
        while (true) {
            va[] vaVarArr = this.n;
            if (i2 >= vaVarArr.length) {
                return voVar;
            }
            int i3 = i2 + 1;
            vaVarArr[i2].n(voVar.d(i3));
            i2 = i3;
        }
    }

    public final void a(long j, boolean z) {
        if (q()) {
            return;
        }
        int iQ = this.m.q();
        this.m.E(j, false, true);
        int iQ2 = this.m.q();
        if (iQ2 > iQ) {
            long jX = this.m.x();
            int i = 0;
            while (true) {
                va[] vaVarArr = this.n;
                if (i >= vaVarArr.length) {
                    break;
                }
                vaVarArr[i].E(jX, false, this.e[i]);
                i++;
            }
        }
        int iMin = Math.min(D(iQ2, 0), this.u);
        if (iMin > 0) {
            aeu.e(this.k, 0, iMin);
            this.u -= iMin;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final boolean b() {
        return !q() && this.m.y(this.b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final void c() throws IOException {
        this.i.a();
        this.m.p();
        if (this.i.f()) {
            return;
        }
        this.f.b();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final int d(cz czVar, iw iwVar, boolean z) {
        if (q()) {
            return -3;
        }
        vo voVar = this.v;
        if (voVar != null && voVar.d(0) <= this.m.r()) {
            return -3;
        }
        C();
        return this.m.z(czVar, iwVar, z, this.b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vb
    public final int e(long j) {
        if (q()) {
            return 0;
        }
        int iC = this.m.C(j, this.b);
        vo voVar = this.v;
        if (voVar != null) {
            iC = Math.min(iC, voVar.d(0) - this.m.r());
        }
        this.m.D(iC);
        C();
        return iC;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final void f(long j) {
        if (this.i.c() || q()) {
            return;
        }
        if (this.i.f()) {
            vt vtVar = this.p;
            ary.t(vtVar);
            boolean z = vtVar instanceof vo;
            if (!(z && B(this.k.size() - 1)) && this.f.d(j, vtVar, this.l)) {
                this.i.g();
                if (z) {
                    this.v = (vo) vtVar;
                    return;
                }
                return;
            }
            return;
        }
        int iC = this.f.c(j, this.l);
        if (iC < this.k.size()) {
            ary.q(!this.i.f());
            int size = this.k.size();
            while (true) {
                if (iC >= size) {
                    iC = -1;
                    break;
                } else if (!B(iC)) {
                    break;
                } else {
                    iC++;
                }
            }
            if (iC == -1) {
                return;
            }
            long j2 = E().j;
            vo voVarF = F(iC);
            if (this.k.isEmpty()) {
                this.s = this.t;
            }
            this.b = false;
            this.h.p(this.a, voVarF.i, j2);
        }
    }

    public final vv g(long j, int i) {
        for (int i2 = 0; i2 < this.n.length; i2++) {
            if (this.c[i2] == i) {
                ary.q(!this.e[i2]);
                this.e[i2] = true;
                this.n[i2].B(j, true);
                return new vv(this, this, this.n[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final long h() {
        if (this.b) {
            return Long.MIN_VALUE;
        }
        if (q()) {
            return this.s;
        }
        long jMax = this.t;
        vo voVarE = E();
        if (!voVarE.j()) {
            if (this.k.size() > 1) {
                voVarE = this.k.get(r2.size() - 2);
            } else {
                voVarE = null;
            }
        }
        if (voVarE != null) {
            jMax = Math.max(jMax, voVarE.j);
        }
        return Math.max(jMax, this.m.u());
    }

    public final T i() {
        return this.f;
    }

    public final long j(long j, eg egVar) {
        return this.f.a(j, egVar);
    }

    public final void k(long j) {
        vo voVar;
        this.t = j;
        if (q()) {
            this.s = j;
            return;
        }
        int i = 0;
        while (true) {
            voVar = null;
            if (i >= this.k.size()) {
                break;
            }
            vo voVar2 = this.k.get(i);
            long j2 = voVar2.i;
            if (j2 == j && voVar2.a == -9223372036854775807L) {
                voVar = voVar2;
                break;
            } else if (j2 > j) {
                break;
            } else {
                i++;
            }
        }
        if (voVar != null ? this.m.A(voVar.d(0)) : this.m.B(j, j < l())) {
            this.u = D(this.m.r(), 0);
            for (va vaVar : this.n) {
                vaVar.B(j, true);
            }
            return;
        }
        this.s = j;
        this.b = false;
        this.k.clear();
        this.u = 0;
        if (this.i.f()) {
            this.i.g();
        } else {
            this.i.d();
            A();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final long l() {
        if (q()) {
            return this.s;
        }
        if (this.b) {
            return Long.MIN_VALUE;
        }
        return E().j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acx
    public final void m() {
        this.m.g();
        for (va vaVar : this.n) {
            vaVar.g();
        }
        this.f.h();
        vw<T> vwVar = this.r;
        if (vwVar != null) {
            vwVar.k(this);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final boolean n(long j) {
        List<vo> listEmptyList;
        long j2;
        if (this.b || this.i.f() || this.i.c()) {
            return false;
        }
        boolean zQ = q();
        if (zQ) {
            listEmptyList = Collections.emptyList();
            j2 = this.s;
        } else {
            listEmptyList = this.l;
            j2 = E().j;
        }
        this.f.e(j, j2, listEmptyList, this.j);
        vu vuVar = this.j;
        boolean z = vuVar.b;
        vt vtVar = vuVar.a;
        vuVar.a = null;
        vuVar.b = false;
        if (z) {
            this.s = -9223372036854775807L;
            this.b = true;
            return true;
        }
        if (vtVar == null) {
            return false;
        }
        this.p = vtVar;
        if (vtVar instanceof vo) {
            vo voVar = (vo) vtVar;
            if (zQ) {
                long j3 = voVar.i;
                long j4 = this.s;
                if (j3 != j4) {
                    this.m.j(j4);
                    for (va vaVar : this.n) {
                        vaVar.j(this.s);
                    }
                }
                this.s = -9223372036854775807L;
            }
            voVar.a(this.o);
            this.k.add(voVar);
        } else if (vtVar instanceof wb) {
            ((wb) vtVar).a(this.o);
        }
        this.i.e(vtVar, this, this.w.a(vtVar.e));
        this.h.e(new to(vtVar.d), vtVar.e, this.a, vtVar.f, vtVar.g, vtVar.h, vtVar.i, vtVar.j);
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final boolean o() {
        return this.i.f();
    }

    public final void p(vw<T> vwVar) {
        this.r = vwVar;
        this.m.o();
        for (va vaVar : this.n) {
            vaVar.o();
        }
        this.i.i(this);
    }

    final boolean q() {
        return this.s != -9223372036854775807L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ acu v(acw acwVar, long j, long j2, IOException iOException, int i) {
        acu acuVarB;
        vt vtVar = (vt) acwVar;
        long jF = vtVar.f();
        boolean z = vtVar instanceof vo;
        int size = this.k.size() - 1;
        boolean z2 = (jF != 0 && z && B(size)) ? false : true;
        vtVar.g();
        vtVar.h();
        to toVar = new to();
        new tt(vtVar.e, this.a, vtVar.f, vtVar.g, vtVar.h, bi.a(vtVar.i), bi.a(vtVar.j));
        acr acrVar = new acr(iOException, i);
        if (!this.f.g(vtVar, z2, iOException, z2 ? acj.b(acrVar) : -9223372036854775807L)) {
            acuVarB = null;
        } else if (z2) {
            acuVarB = ada.a;
            if (z) {
                ary.q(F(size) == vtVar);
                if (this.k.isEmpty()) {
                    this.s = this.t;
                }
            }
        } else {
            Log.w("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            acuVarB = null;
        }
        if (acuVarB == null) {
            long jC = acj.c(acrVar);
            acuVarB = jC != -9223372036854775807L ? ada.b(false, jC) : ada.b;
        }
        boolean z3 = !acuVarB.a();
        this.h.n(toVar, vtVar.e, this.a, vtVar.f, vtVar.g, vtVar.h, vtVar.i, vtVar.j, iOException, z3);
        if (z3) {
            this.p = null;
            this.g.m(this);
        }
        return acuVarB;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ void w(acw acwVar, long j, long j2, boolean z) {
        vt vtVar = (vt) acwVar;
        this.p = null;
        this.v = null;
        long j3 = vtVar.c;
        vtVar.g();
        vtVar.h();
        vtVar.f();
        this.h.k(new to(), vtVar.e, this.a, vtVar.f, vtVar.g, vtVar.h, vtVar.i, vtVar.j);
        if (z) {
            return;
        }
        if (q()) {
            A();
        } else if (vtVar instanceof vo) {
            F(this.k.size() - 1);
            if (this.k.isEmpty()) {
                this.s = this.t;
            }
        }
        this.g.m(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ void x(acw acwVar, long j, long j2) {
        vt vtVar = (vt) acwVar;
        this.p = null;
        this.f.f(vtVar);
        long j3 = vtVar.c;
        vtVar.g();
        vtVar.h();
        vtVar.f();
        this.h.h(new to(), vtVar.e, this.a, vtVar.f, vtVar.g, vtVar.h, vtVar.i, vtVar.j);
        this.g.m(this);
    }
}
