package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class us implements tv, ka, act, acx, uz {
    private static final Map<String, String> b;
    private static final cy c;
    private long A;
    private boolean B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private long G;
    private long H;
    private long I;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private final acj N;
    private final acc O;
    private final Uri d;
    private final abx e;
    private final jh f;
    private final ug g;
    private final je h;
    private final uo i;
    private final String j = null;
    private final long k = 1048576;
    private final ada l = new ada("Loader:ProgressiveMediaPeriod");
    private final uj m;
    private final adm n;
    private final Runnable o;
    private final Runnable p;
    private final Handler q;
    private tu r;
    private rk s;
    private va[] t;
    private uq[] u;
    private boolean v;
    private boolean w;
    private boolean x;
    private ur y;
    private ko z;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        b = Collections.unmodifiableMap(map);
        cx cxVar = new cx();
        cxVar.S("icy");
        cxVar.ae("application/x-icy");
        c = cxVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.google.ads.interactivemedia.v3.internal.uj] */
    public us(Uri uri, abx abxVar, kc kcVar, jh jhVar, je jeVar, acj acjVar, ug ugVar, uo uoVar, acc accVar, int i) {
        this.d = uri;
        this.e = abxVar;
        this.f = jhVar;
        this.h = jeVar;
        this.N = acjVar;
        this.g = ugVar;
        this.i = uoVar;
        this.O = accVar;
        su suVar = null;
        su suVar2 = new su(kcVar);
        if (aeu.a >= 30) {
            try {
                suVar = (uj) Class.forName("com.google.ads.interactivemedia.v3.exoplayer2.source.MediaParserExtractorAdapter").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception unused) {
            }
        }
        this.m = suVar != null ? suVar : suVar2;
        this.n = new adm();
        this.o = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.uk
            private final us a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.I();
            }
        };
        this.p = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.ul
            private final us a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.z();
            }
        };
        this.q = aeu.k();
        this.u = new uq[0];
        this.t = new va[0];
        this.I = -9223372036854775807L;
        this.G = -1L;
        this.A = -9223372036854775807L;
        this.C = 1;
    }

    static /* synthetic */ String H(us usVar) {
        String str = usVar.j;
        return null;
    }

    private final void L(int i) {
        V();
        ur urVar = this.y;
        boolean[] zArr = urVar.d;
        if (zArr[i]) {
            return;
        }
        cy cyVarA = urVar.a.a(i).a(0);
        this.g.r(adz.j(cyVarA.l), cyVarA, 0, null, this.H);
        zArr[i] = true;
    }

    private final void M(int i) {
        V();
        boolean[] zArr = this.y.b;
        if (this.J && zArr[i]) {
            if (this.t[i].y(false)) {
                return;
            }
            this.I = 0L;
            this.J = false;
            this.E = true;
            this.H = 0L;
            this.K = 0;
            for (va vaVar : this.t) {
                vaVar.h();
            }
            tu tuVar = this.r;
            ary.t(tuVar);
            tuVar.m(this);
        }
    }

    private final boolean N() {
        return this.E || U();
    }

    private final kr O(uq uqVar) {
        int length = this.t.length;
        for (int i = 0; i < length; i++) {
            if (uqVar.equals(this.u[i])) {
                return this.t[i];
            }
        }
        va vaVar = new va(this.O, this.q.getLooper(), this.f, this.h);
        vaVar.I(this);
        int i2 = length + 1;
        uq[] uqVarArr = (uq[]) Arrays.copyOf(this.u, i2);
        uqVarArr[length] = uqVar;
        this.u = (uq[]) aeu.g(uqVarArr);
        va[] vaVarArr = (va[]) Arrays.copyOf(this.t, i2);
        vaVarArr[length] = vaVar;
        this.t = (va[]) aeu.g(vaVarArr);
        return vaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public final void I() {
        if (this.M || this.w || !this.v || this.z == null) {
            return;
        }
        for (va vaVar : this.t) {
            if (vaVar.t() == null) {
                return;
            }
        }
        this.n.d();
        int length = this.t.length;
        vh[] vhVarArr = new vh[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            cy cyVarT = this.t[i].t();
            ary.t(cyVarT);
            String str = cyVarT.l;
            boolean zA = adz.a(str);
            boolean z = zA || adz.b(str);
            zArr[i] = z;
            this.x = z | this.x;
            rk rkVar = this.s;
            if (rkVar != null) {
                if (zA || this.u[i].b) {
                    qz qzVar = cyVarT.j;
                    qz qzVar2 = qzVar == null ? new qz(rkVar) : qzVar.d(rkVar);
                    cx cxVarA = cyVarT.a();
                    cxVarA.X(qzVar2);
                    cyVarT = cxVarA.a();
                }
                if (zA && cyVarT.f == -1 && cyVarT.g == -1 && rkVar.a != -1) {
                    cx cxVarA2 = cyVarT.a();
                    cxVarA2.G(rkVar.a);
                    cyVarT = cxVarA2.a();
                }
            }
            vhVarArr[i] = new vh(cyVarT.c(this.f.a(cyVarT)));
        }
        this.y = new ur(new vj(vhVarArr), zArr);
        this.w = true;
        tu tuVar = this.r;
        ary.t(tuVar);
        tuVar.k(this);
    }

    private final void Q(un unVar) {
        if (this.G == -1) {
            this.G = unVar.m;
        }
    }

    private final void R() {
        un unVar = new un(this, this.d, this.e, this.m, this, this.n);
        if (this.w) {
            ary.q(U());
            long j = this.A;
            if (j != -9223372036854775807L && this.I > j) {
                this.L = true;
                this.I = -9223372036854775807L;
                return;
            }
            ko koVar = this.z;
            ary.t(koVar);
            un.i(unVar, koVar.b(this.I).a.c, this.I);
            for (va vaVar : this.t) {
                vaVar.j(this.I);
            }
            this.I = -9223372036854775807L;
        }
        this.K = S();
        this.l.e(unVar, this, this.N.a(this.C));
        acb acbVar = unVar.l;
        ug ugVar = this.g;
        long unused = unVar.b;
        ugVar.e(new to(acbVar), 1, -1, null, 0, null, unVar.k, this.A);
    }

    private final int S() {
        int iM = 0;
        for (va vaVar : this.t) {
            iM += vaVar.m();
        }
        return iM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long T() {
        long jMax = Long.MIN_VALUE;
        for (va vaVar : this.t) {
            jMax = Math.max(jMax, vaVar.u());
        }
        return jMax;
    }

    private final boolean U() {
        return this.I != -9223372036854775807L;
    }

    private final void V() {
        ary.q(this.w);
        ary.t(this.y);
        ary.t(this.z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uz
    public final void K() {
        this.q.post(this.o);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void a(tu tuVar, long j) {
        this.r = tuVar;
        this.n.a();
        R();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ka
    public final kr ak(int i, int i2) {
        return O(new uq(i, false));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ka
    public final void al() {
        this.v = true;
        this.q.post(this.o);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ka
    public final void am(final ko koVar) {
        this.q.post(new Runnable(this, koVar) { // from class: com.google.ads.interactivemedia.v3.internal.um
            private final us a;
            private final ko b;

            {
                this.a = this;
                this.b = koVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.y(this.b);
            }
        });
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void b() throws IOException {
        r();
        if (this.L && !this.w) {
            throw new dt("Loading finished before preparation is complete.");
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final vj c() {
        V();
        return this.y.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long d(aba[] abaVarArr, boolean[] zArr, vb[] vbVarArr, boolean[] zArr2, long j) {
        aba abaVar;
        V();
        ur urVar = this.y;
        vj vjVar = urVar.a;
        boolean[] zArr3 = urVar.c;
        int i = this.F;
        int i2 = 0;
        for (int i3 = 0; i3 < abaVarArr.length; i3++) {
            vb vbVar = vbVarArr[i3];
            if (vbVar != null && (abaVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((up) vbVar).b;
                ary.q(zArr3[i4]);
                this.F--;
                zArr3[i4] = false;
                vbVarArr[i3] = null;
            }
        }
        boolean z = !this.D ? j == 0 : i != 0;
        for (int i5 = 0; i5 < abaVarArr.length; i5++) {
            if (vbVarArr[i5] == null && (abaVar = abaVarArr[i5]) != null) {
                ary.q(abaVar.l() == 1);
                ary.q(abaVar.n(0) == 0);
                int iB = vjVar.b(abaVar.k());
                ary.q(!zArr3[iB]);
                this.F++;
                zArr3[iB] = true;
                vbVarArr[i5] = new up(this, iB);
                zArr2[i5] = true;
                if (!z) {
                    va vaVar = this.t[iB];
                    z = (vaVar.B(j, true) || vaVar.r() == 0) ? false : true;
                }
            }
        }
        if (this.F == 0) {
            this.J = false;
            this.E = false;
            if (this.l.f()) {
                va[] vaVarArr = this.t;
                int length = vaVarArr.length;
                while (i2 < length) {
                    vaVarArr[i2].G();
                    i2++;
                }
                this.l.g();
            } else {
                va[] vaVarArr2 = this.t;
                int length2 = vaVarArr2.length;
                while (i2 < length2) {
                    vaVarArr2[i2].h();
                    i2++;
                }
            }
        } else if (z) {
            j = i(j);
            while (i2 < vbVarArr.length) {
                if (vbVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.D = true;
        return j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final void e(long j, boolean z) {
        V();
        if (U()) {
            return;
        }
        boolean[] zArr = this.y.c;
        int length = this.t.length;
        for (int i = 0; i < length; i++) {
            this.t[i].E(j, false, zArr[i]);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final void f(long j) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long g() {
        if (!this.E) {
            return -9223372036854775807L;
        }
        if (!this.L && S() <= this.K) {
            return -9223372036854775807L;
        }
        this.E = false;
        return this.H;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final long h() {
        long jT;
        V();
        boolean[] zArr = this.y.b;
        if (this.L) {
            return Long.MIN_VALUE;
        }
        if (U()) {
            return this.I;
        }
        if (this.x) {
            int length = this.t.length;
            jT = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i] && !this.t[i].w()) {
                    jT = Math.min(jT, this.t[i].u());
                }
            }
        } else {
            jT = Long.MAX_VALUE;
        }
        if (jT == Long.MAX_VALUE) {
            jT = T();
        }
        return jT == Long.MIN_VALUE ? this.H : jT;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long i(long j) {
        V();
        boolean[] zArr = this.y.b;
        if (true != this.z.a()) {
            j = 0;
        }
        this.E = false;
        this.H = j;
        if (U()) {
            this.I = j;
            return j;
        }
        if (this.C != 7) {
            int length = this.t.length;
            for (int i = 0; i < length; i++) {
                if (this.t[i].B(j, false) || (!zArr[i] && this.x)) {
                }
            }
            return j;
        }
        this.J = false;
        this.I = j;
        this.L = false;
        if (this.l.f()) {
            this.l.g();
        } else {
            this.l.d();
            for (va vaVar : this.t) {
                vaVar.h();
            }
        }
        return j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv
    public final long j(long j, eg egVar) {
        V();
        if (!this.z.a()) {
            return 0L;
        }
        km kmVarB = this.z.b(j);
        return egVar.a(j, kmVarB.a.b, kmVarB.b.b);
    }

    public final void k() {
        if (this.w) {
            for (va vaVar : this.t) {
                vaVar.o();
            }
        }
        this.l.i(this);
        this.q.removeCallbacksAndMessages(null);
        this.r = null;
        this.M = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final long l() {
        if (this.F == 0) {
            return Long.MIN_VALUE;
        }
        return h();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acx
    public final void m() {
        for (va vaVar : this.t) {
            vaVar.g();
        }
        this.m.b();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final boolean n(long j) {
        if (this.L || this.l.c() || this.J) {
            return false;
        }
        if (this.w && this.F == 0) {
            return false;
        }
        boolean zA = this.n.a();
        if (this.l.f()) {
            return zA;
        }
        R();
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.tv, com.google.ads.interactivemedia.v3.internal.vd
    public final boolean o() {
        return this.l.f() && this.n.c();
    }

    final boolean p(int i) {
        return !N() && this.t[i].y(this.L);
    }

    final void q(int i) throws IOException {
        this.t[i].p();
        r();
    }

    final void r() throws IOException {
        this.l.j(this.N.a(this.C));
    }

    final int s(int i, cz czVar, iw iwVar, boolean z) {
        if (N()) {
            return -3;
        }
        L(i);
        int iZ = this.t[i].z(czVar, iwVar, z, this.L);
        if (iZ != -3) {
            return iZ;
        }
        M(i);
        return -3;
    }

    final int t(int i, long j) {
        if (N()) {
            return 0;
        }
        L(i);
        va vaVar = this.t[i];
        int iC = vaVar.C(j, this.L);
        vaVar.D(iC);
        if (iC != 0) {
            return iC;
        }
        M(i);
        return 0;
    }

    final kr u() {
        return O(new uq(0, true));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ acu v(acw acwVar, long j, long j2, IOException iOException, int i) {
        acu acuVarB;
        ko koVar;
        un unVar = (un) acwVar;
        Q(unVar);
        adg unused = unVar.d;
        long unused2 = unVar.b;
        acb unused3 = unVar.l;
        to toVar = new to();
        new tt(1, -1, null, 0, null, bi.a(unVar.k), bi.a(this.A));
        long jC = acj.c(new acr(iOException, i));
        if (jC == -9223372036854775807L) {
            acuVarB = ada.b;
        } else {
            int iS = S();
            boolean z = iS > this.K;
            if (this.G != -1 || ((koVar = this.z) != null && koVar.c() != -9223372036854775807L)) {
                this.K = iS;
            } else if (!this.w || N()) {
                this.E = this.w;
                this.H = 0L;
                this.K = 0;
                for (va vaVar : this.t) {
                    vaVar.h();
                }
                un.i(unVar, 0L, 0L);
            } else {
                this.J = true;
                acuVarB = ada.a;
            }
            acuVarB = ada.b(z, jC);
        }
        acu acuVar = acuVarB;
        boolean z2 = !acuVar.a();
        this.g.n(toVar, 1, -1, null, 0, null, unVar.k, this.A, iOException, z2);
        if (z2) {
            long unused4 = unVar.b;
        }
        return acuVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ void w(acw acwVar, long j, long j2, boolean z) {
        un unVar = (un) acwVar;
        adg unused = unVar.d;
        long unused2 = unVar.b;
        acb unused3 = unVar.l;
        to toVar = new to();
        long unused4 = unVar.b;
        this.g.k(toVar, 1, -1, null, 0, null, unVar.k, this.A);
        if (z) {
            return;
        }
        Q(unVar);
        for (va vaVar : this.t) {
            vaVar.h();
        }
        if (this.F > 0) {
            tu tuVar = this.r;
            ary.t(tuVar);
            tuVar.m(this);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ void x(acw acwVar, long j, long j2) {
        ko koVar;
        un unVar = (un) acwVar;
        if (this.A == -9223372036854775807L && (koVar = this.z) != null) {
            boolean zA = koVar.a();
            long jT = T();
            long j3 = jT == Long.MIN_VALUE ? 0L : jT + 10000;
            this.A = j3;
            this.i.b(j3, zA, this.B);
        }
        adg unused = unVar.d;
        long unused2 = unVar.b;
        acb unused3 = unVar.l;
        to toVar = new to();
        long unused4 = unVar.b;
        this.g.h(toVar, 1, -1, null, 0, null, unVar.k, this.A);
        Q(unVar);
        this.L = true;
        tu tuVar = this.r;
        ary.t(tuVar);
        tuVar.m(this);
    }

    final /* synthetic */ void y(ko koVar) {
        this.z = this.s == null ? koVar : new kn(-9223372036854775807L);
        this.A = koVar.c();
        boolean z = false;
        if (this.G == -1 && koVar.c() == -9223372036854775807L) {
            z = true;
        }
        this.B = z;
        this.C = true == z ? 7 : 1;
        this.i.b(this.A, koVar.a(), this.B);
        if (this.w) {
            return;
        }
        I();
    }

    final /* synthetic */ void z() {
        if (this.M) {
            return;
        }
        tu tuVar = this.r;
        ary.t(tuVar);
        tuVar.m(this);
    }
}
