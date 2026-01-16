package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class cj extends bg {
    final abg b;
    private final abf c;
    private final Handler d;
    private final cr e;
    private final cu f;
    private final Handler g;
    private final adt<dw> h;
    private final eq i;
    private final List<ci> j;
    private final boolean k;
    private final gj l;
    private final Looper m;
    private final abq n;
    private int o;
    private boolean p;
    private int q;
    private int r;
    private du s;
    private int t;
    private long u;
    private ve v;

    public cj(ed[] edVarArr, abf abfVar, bk bkVar, abq abqVar, gj gjVar, boolean z, eg egVar, bj bjVar, long j, boolean z2, adk adkVar, Looper looper) {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = aeu.e;
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 30 + String.valueOf(str).length());
        sb.append("Init ");
        sb.append(hexString);
        sb.append(" [");
        sb.append("ExoPlayerLib/2.12.1");
        sb.append("] [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        int length = edVarArr.length;
        ary.q(true);
        ary.t(abfVar);
        this.c = abfVar;
        this.n = abqVar;
        this.l = gjVar;
        this.k = z;
        this.m = looper;
        this.h = new adt<>();
        this.j = new ArrayList();
        this.v = new ve();
        abg abgVar = new abg(new ef[2], new aba[2], null);
        this.b = abgVar;
        this.i = new eq();
        this.t = -1;
        this.d = new Handler(looper);
        cr crVar = new cr(this) { // from class: com.google.ads.interactivemedia.v3.internal.bp
            private final cj a;

            {
                this.a = this;
            }

            @Override // com.google.ads.interactivemedia.v3.internal.cr
            public final void a(cq cqVar) {
                this.a.w(cqVar);
            }
        };
        this.e = crVar;
        this.s = du.a(abgVar);
        if (gjVar != null) {
            gjVar.I(this);
            e(gjVar);
            abqVar.c(new Handler(looper), gjVar);
        }
        cu cuVar = new cu(edVarArr, abfVar, abgVar, bkVar, abqVar, gjVar, egVar, bjVar, j, false, looper, adkVar, crVar);
        this.f = cuVar;
        this.g = new Handler(cuVar.i());
    }

    private final int C() {
        if (this.s.a.u()) {
            return this.t;
        }
        du duVar = this.s;
        return duVar.a.g(duVar.b.a, this.i).c;
    }

    private final void D(final du duVar, boolean z, final int i, final int i2, final int i3, boolean z2) {
        Pair pair;
        du duVar2 = this.s;
        this.s = duVar;
        int i4 = 1;
        boolean z3 = !duVar2.a.equals(duVar.a);
        es esVar = duVar2.a;
        es esVar2 = duVar.a;
        if (esVar2.u() && esVar.u()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (esVar2.u() != esVar.u()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else {
            Object obj = esVar.v(esVar.g(duVar2.b.a, this.i).c, this.a).b;
            Object obj2 = esVar2.v(esVar2.g(duVar.b.a, this.i).c, this.a).b;
            int i5 = this.a.l;
            if (obj.equals(obj2)) {
                pair = (z && i == 0 && esVar2.i(duVar.b.a) == i5) ? new Pair(Boolean.TRUE, 0) : new Pair(Boolean.FALSE, -1);
            } else {
                if (!z || i != 0) {
                    if (z && i == 1) {
                        i4 = 2;
                    } else {
                        if (!z3) {
                            throw new IllegalStateException();
                        }
                        i4 = 3;
                    }
                }
                pair = new Pair(Boolean.TRUE, Integer.valueOf(i4));
            }
        }
        boolean zBooleanValue = ((Boolean) pair.first).booleanValue();
        final int iIntValue = ((Integer) pair.second).intValue();
        if (!duVar2.a.equals(duVar.a)) {
            this.h.c(new adr(duVar, i2) { // from class: com.google.ads.interactivemedia.v3.internal.cc
                private final du a;
                private final int b;

                {
                    this.a = duVar;
                    this.b = i2;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj3) {
                    du duVar3 = this.a;
                    ((dw) obj3).g(duVar3.a, this.b);
                }
            });
        }
        if (z) {
            this.h.c(new adr(i) { // from class: com.google.ads.interactivemedia.v3.internal.cd
                private final int a;

                {
                    this.a = i;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj3) {
                    ((dw) obj3).r(this.a);
                }
            });
        }
        if (zBooleanValue) {
            final dg dgVar = !duVar.a.u() ? duVar.a.v(duVar.a.g(duVar.b.a, this.i).c, this.a).c : null;
            this.h.c(new adr(dgVar, iIntValue) { // from class: com.google.ads.interactivemedia.v3.internal.ce
                private final dg a;
                private final int b;

                {
                    this.a = dgVar;
                    this.b = iIntValue;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj3) {
                    ((dw) obj3).h(this.a, this.b);
                }
            });
        }
        bn bnVar = duVar2.e;
        bn bnVar2 = duVar.e;
        if (bnVar != bnVar2 && bnVar2 != null) {
            this.h.c(new adr(duVar) { // from class: com.google.ads.interactivemedia.v3.internal.cf
                private final du a;

                {
                    this.a = duVar;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj3) {
                    ((dw) obj3).q(this.a.e);
                }
            });
        }
        abg abgVar = duVar2.h;
        abg abgVar2 = duVar.h;
        if (abgVar != abgVar2) {
            Object obj3 = abgVar2.d;
            this.h.c(new adr(duVar) { // from class: com.google.ads.interactivemedia.v3.internal.cg
                private final du a;

                {
                    this.a = duVar;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj4) {
                    du duVar3 = this.a;
                    ((dw) obj4).i(duVar3.g, duVar3.h.c);
                }
            });
        }
        if (!duVar2.i.equals(duVar.i)) {
            this.h.c(new adr(duVar) { // from class: com.google.ads.interactivemedia.v3.internal.ch
                private final du a;

                {
                    this.a = duVar;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj4) {
                    ((dw) obj4).j(this.a.i);
                }
            });
        }
        if (duVar2.f != duVar.f) {
            this.h.c(new adr(duVar) { // from class: com.google.ads.interactivemedia.v3.internal.bq
                private final du a;

                {
                    this.a = duVar;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj4) {
                    ((dw) obj4).k(this.a.f);
                }
            });
        }
        if (duVar2.d != duVar.d || duVar2.k != duVar.k) {
            this.h.c(new adr(duVar) { // from class: com.google.ads.interactivemedia.v3.internal.br
                private final du a;

                {
                    this.a = duVar;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj4) {
                    du duVar3 = this.a;
                    ((dw) obj4).l(duVar3.k, duVar3.d);
                }
            });
        }
        if (duVar2.d != duVar.d) {
            this.h.c(new adr(duVar) { // from class: com.google.ads.interactivemedia.v3.internal.bs
                private final du a;

                {
                    this.a = duVar;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj4) {
                    ((dw) obj4).m(this.a.d);
                }
            });
        }
        if (duVar2.k != duVar.k) {
            this.h.c(new adr(duVar, i3) { // from class: com.google.ads.interactivemedia.v3.internal.bt
                private final du a;
                private final int b;

                {
                    this.a = duVar;
                    this.b = i3;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj4) {
                    du duVar3 = this.a;
                    ((dw) obj4).n(duVar3.k, this.b);
                }
            });
        }
        if (duVar2.l != duVar.l) {
            this.h.c(new adr(duVar) { // from class: com.google.ads.interactivemedia.v3.internal.bu
                private final du a;

                {
                    this.a = duVar;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj4) {
                    ((dw) obj4).o(this.a.l);
                }
            });
        }
        if (G(duVar2) != G(duVar)) {
            this.h.c(new adr(duVar) { // from class: com.google.ads.interactivemedia.v3.internal.bv
                private final du a;

                {
                    this.a = duVar;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj4) {
                    ((dw) obj4).p(cj.G(this.a));
                }
            });
        }
        if (!duVar2.m.equals(duVar.m)) {
            this.h.c(new adr(duVar) { // from class: com.google.ads.interactivemedia.v3.internal.bw
                private final du a;

                {
                    this.a = duVar;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj4) {
                    ((dw) obj4).s(this.a.m);
                }
            });
        }
        if (z2) {
            this.h.c(bx.a);
        }
        if (duVar2.n != duVar.n) {
            this.h.c(new adr(duVar) { // from class: com.google.ads.interactivemedia.v3.internal.by
                private final du a;

                {
                    this.a = duVar;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj4) {
                    boolean z4 = this.a.n;
                    ((dw) obj4).u();
                }
            });
        }
        if (duVar2.o != duVar.o) {
            this.h.c(new adr(duVar) { // from class: com.google.ads.interactivemedia.v3.internal.bz
                private final du a;

                {
                    this.a = duVar;
                }

                @Override // com.google.ads.interactivemedia.v3.internal.adr
                public final void a(Object obj4) {
                    boolean z4 = this.a.o;
                    ((dw) obj4).v();
                }
            });
        }
        this.h.d();
    }

    private final du E(du duVar, es esVar, Pair<Object, Long> pair) {
        ary.o(esVar.u() || pair != null);
        es esVar2 = duVar.a;
        du duVarD = duVar.d(esVar);
        if (esVar.u()) {
            tw twVarB = du.b();
            du duVarG = duVarD.c(twVarB, bi.b(this.u), bi.b(this.u), 0L, vj.a, this.b, arn.i()).g(twVarB);
            duVarG.p = duVarG.r;
            return duVarG;
        }
        Object obj = duVarD.b.a;
        int i = aeu.a;
        boolean z = !obj.equals(pair.first);
        tw twVar = z ? new tw(pair.first) : duVarD.b;
        long jLongValue = ((Long) pair.second).longValue();
        long jB = bi.b(t());
        if (!esVar2.u()) {
            jB -= esVar2.g(obj, this.i).b();
        }
        if (z || jLongValue < jB) {
            ary.q(!twVar.b());
            du duVarG2 = duVarD.c(twVar, jLongValue, jLongValue, 0L, z ? vj.a : duVarD.g, z ? this.b : duVarD.h, z ? arn.i() : duVarD.i).g(twVar);
            duVarG2.p = jLongValue;
            return duVarG2;
        }
        if (jLongValue != jB) {
            ary.q(!twVar.b());
            long jMax = Math.max(0L, duVarD.q - (jLongValue - jB));
            long j = duVarD.p;
            if (duVarD.j.equals(duVarD.b)) {
                j = jLongValue + jMax;
            }
            du duVarC = duVarD.c(twVar, jLongValue, jLongValue, jMax, duVarD.g, duVarD.h, duVarD.i);
            duVarC.p = j;
            return duVarC;
        }
        int i2 = esVar.i(duVarD.j.a);
        if (i2 != -1 && esVar.z(i2, this.i).c == esVar.g(twVar.a, this.i).c) {
            return duVarD;
        }
        esVar.g(twVar.a, this.i);
        long j2 = twVar.b() ? this.i.j(twVar.b, twVar.c) : this.i.d;
        du duVarG3 = duVarD.c(twVar, duVarD.r, duVarD.r, j2 - duVarD.r, duVarD.g, duVarD.h, duVarD.i).g(twVar);
        duVarG3.p = j2;
        return duVarG3;
    }

    private final Pair<Object, Long> F(es esVar, int i, long j) {
        if (esVar.u()) {
            this.t = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.u = j;
            return null;
        }
        if (i >= esVar.s()) {
            i = esVar.e(false);
            j = esVar.v(i, this.a).a();
        }
        return esVar.x(this.a, this.i, i, bi.b(j));
    }

    private static boolean G(du duVar) {
        return duVar.d == 3 && duVar.k && duVar.l == 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final void A() {
        B(null);
    }

    public final void B(bn bnVar) {
        du duVar = this.s;
        du duVarG = duVar.g(duVar.b);
        duVarG.p = duVarG.r;
        duVarG.q = 0L;
        du duVarE = duVarG.e(1);
        if (bnVar != null) {
            duVarE = duVarE.f(bnVar);
        }
        this.o++;
        this.f.f();
        D(duVarE, false, 4, 0, 1, false);
    }

    public final void b() {
        this.f.b();
    }

    public final boolean c() {
        return this.s.o;
    }

    public final Looper d() {
        return this.m;
    }

    public final void e(dw dwVar) {
        this.h.a(dwVar);
    }

    public final int f() {
        return this.s.d;
    }

    public final void g() {
        du duVar = this.s;
        if (duVar.d != 1) {
            return;
        }
        du duVarF = duVar.f(null);
        du duVarE = duVarF.e(true != duVarF.a.u() ? 2 : 4);
        this.o++;
        this.f.c();
        D(duVarE, false, 4, 1, 1, false);
    }

    public final void h(boolean z, int i, int i2) {
        du duVar = this.s;
        if (duVar.k == z && duVar.l == i) {
            return;
        }
        this.o++;
        du duVarH = duVar.h(z, i);
        this.f.d(z, i);
        D(duVarH, false, 4, 0, i2, false);
    }

    public final boolean i() {
        return this.s.k;
    }

    public final void j() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = aeu.e;
        String strA = cv.a();
        int length = String.valueOf(hexString).length();
        StringBuilder sb = new StringBuilder(length + 36 + String.valueOf(str).length() + String.valueOf(strA).length());
        sb.append("Release ");
        sb.append(hexString);
        sb.append(" [");
        sb.append("ExoPlayerLib/2.12.1");
        sb.append("] [");
        sb.append(str);
        sb.append("] [");
        sb.append(strA);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        if (!this.f.h()) {
            this.h.e(cb.a);
        }
        this.h.f();
        this.d.removeCallbacksAndMessages(null);
        gj gjVar = this.l;
        if (gjVar != null) {
            this.n.d(gjVar);
        }
        du duVarE = this.s.e(1);
        this.s = duVarE;
        du duVarG = duVarE.g(duVarE.b);
        this.s = duVarG;
        duVarG.p = duVarG.r;
        this.s.q = 0L;
    }

    public final ea k(dz dzVar) {
        return new ea(this.f, dzVar, this.s.a, m(), this.g);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final int l() {
        if (this.s.a.u()) {
            return 0;
        }
        du duVar = this.s;
        return duVar.a.i(duVar.b.a);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final int m() {
        int iC = C();
        if (iC == -1) {
            return 0;
        }
        return iC;
    }

    public final long n() {
        if (q()) {
            du duVar = this.s;
            tw twVar = duVar.b;
            duVar.a.g(twVar.a, this.i);
            return bi.a(this.i.j(twVar.b, twVar.c));
        }
        es esVarU = u();
        if (esVarU.u()) {
            return -9223372036854775807L;
        }
        return bi.a(esVarU.v(m(), this.a).o);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final long o() {
        if (this.s.a.u()) {
            return this.u;
        }
        if (this.s.b.b()) {
            return bi.a(this.s.r);
        }
        du duVar = this.s;
        tw twVar = duVar.b;
        long jA = bi.a(duVar.r);
        this.s.a.g(twVar.a, this.i);
        return jA + this.i.a();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final long p() {
        return bi.a(this.s.q);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final boolean q() {
        return this.s.b.b();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final int r() {
        if (q()) {
            return this.s.b.b;
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final int s() {
        if (q()) {
            return this.s.b.c;
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final long t() {
        if (!q()) {
            return o();
        }
        du duVar = this.s;
        duVar.a.g(duVar.b.a, this.i);
        du duVar2 = this.s;
        return duVar2.c == -9223372036854775807L ? duVar2.a.v(m(), this.a).a() : this.i.a() + bi.a(this.s.c);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final es u() {
        return this.s.a;
    }

    final /* synthetic */ void w(final cq cqVar) {
        this.d.post(new Runnable(this, cqVar) { // from class: com.google.ads.interactivemedia.v3.internal.ca
            private final cj a;
            private final cq b;

            {
                this.a = this;
                this.b = cqVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.x(this.b);
            }
        });
    }

    final /* synthetic */ void x(cq cqVar) {
        int i = this.o - cqVar.b;
        this.o = i;
        if (cqVar.c) {
            this.p = true;
            this.q = cqVar.d;
        }
        if (cqVar.e) {
            this.r = cqVar.f;
        }
        if (i == 0) {
            es esVar = cqVar.a.a;
            if (!this.s.a.u() && esVar.u()) {
                this.t = -1;
                this.u = 0L;
            }
            if (!esVar.u()) {
                List<es> listR = ((eb) esVar).r();
                ary.q(listR.size() == this.j.size());
                for (int i2 = 0; i2 < listR.size(); i2++) {
                    this.j.get(i2).b = listR.get(i2);
                }
            }
            boolean z = this.p;
            this.p = false;
            D(cqVar.a, z, this.q, 1, this.r, false);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.dx
    public final void y(int i) {
        es esVar = this.s.a;
        if (i < 0 || (!esVar.u() && i >= esVar.s())) {
            throw new da();
        }
        this.o++;
        if (q()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.e.a(new cq(this.s));
        } else {
            du duVarE = E(this.s.e(f() != 1 ? 2 : 1), esVar, F(esVar, i, 0L));
            this.f.e(esVar, i, bi.b(0L));
            D(duVarE, true, 1, 0, 1, true);
        }
    }

    public final void z(List<ty> list) {
        int size = list.size();
        for (int i = 0; i < list.size(); i++) {
            ty tyVar = list.get(i);
            ary.t(tyVar);
            if ((tyVar instanceof vn) && size > 1) {
                throw new IllegalArgumentException();
            }
        }
        C();
        o();
        this.o++;
        if (!this.j.isEmpty()) {
            int size2 = this.j.size();
            for (int i2 = size2 - 1; i2 >= 0; i2--) {
                this.j.remove(i2);
            }
            this.v = this.v.g(0, size2);
            this.j.isEmpty();
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            dq dqVar = new dq(list.get(i3), this.k);
            arrayList.add(dqVar);
            this.j.add(i3, new ci(dqVar.b, dqVar.a.C()));
        }
        this.v = this.v.f(0, arrayList.size());
        eb ebVar = new eb(this.j, this.v);
        if (!ebVar.u() && ebVar.s() <= 0) {
            throw new da();
        }
        du duVarE = E(this.s, ebVar, F(ebVar, 0, -9223372036854775807L));
        int i4 = duVarE.d;
        if (i4 != 1) {
            i4 = (ebVar.u() || ebVar.s() <= 0) ? 4 : 2;
        }
        du duVarE2 = duVarE.e(i4);
        this.f.q(arrayList, 0, bi.b(-9223372036854775807L), this.v);
        D(duVarE2, false, 4, 0, 1, false);
    }
}
