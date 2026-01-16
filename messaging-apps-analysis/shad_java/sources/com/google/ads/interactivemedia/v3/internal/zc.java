package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class zc implements act, acx, vd, ka, uz {
    private static final Set<Integer> b = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 4)));
    private int A;
    private boolean B;
    private boolean C;
    private int D;
    private cy E;
    private cy F;
    private boolean G;
    private vj H;
    private Set<vh> I;
    private int[] J;
    private int K;
    private boolean L;
    private boolean[] M;
    private boolean[] N;
    private long O;
    private long P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private long U;
    private jc V;
    private yq W;
    private final acc X;
    private final acj Y;
    private final int c;
    private final yz d;
    private final yo e;
    private final cy f;
    private final jh g;
    private final je h;
    private final ug j;
    private final int k;
    private final ArrayList<yq> m;
    private final List<yq> n;
    private final Runnable o;
    private final Runnable p;
    private final Handler q;
    private final ArrayList<yu> r;
    private final Map<String, jc> s;
    private vt t;
    private zb[] u;
    private final Set<Integer> w;
    private final SparseIntArray x;
    private kr y;
    private int z;
    private final ada i = new ada("Loader:HlsSampleStreamWrapper");
    private final yl l = new yl();
    private int[] v = new int[0];

    public zc(int i, yz yzVar, yo yoVar, Map map, acc accVar, long j, cy cyVar, jh jhVar, je jeVar, acj acjVar, ug ugVar, int i2) {
        this.c = i;
        this.d = yzVar;
        this.e = yoVar;
        this.s = map;
        this.X = accVar;
        this.f = cyVar;
        this.g = jhVar;
        this.h = jeVar;
        this.Y = acjVar;
        this.j = ugVar;
        this.k = i2;
        Set<Integer> set = b;
        this.w = new HashSet(set.size());
        this.x = new SparseIntArray(set.size());
        this.u = new zb[0];
        this.N = new boolean[0];
        this.M = new boolean[0];
        ArrayList<yq> arrayList = new ArrayList<>();
        this.m = arrayList;
        this.n = Collections.unmodifiableList(arrayList);
        this.r = new ArrayList<>();
        this.o = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.yv
            private final zc a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.F();
            }
        };
        this.p = new Runnable(this) { // from class: com.google.ads.interactivemedia.v3.internal.yw
            private final zc a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.G();
            }
        };
        this.q = aeu.k();
        this.O = j;
        this.P = j;
    }

    private final void I() {
        for (zb zbVar : this.u) {
            zbVar.i(this.Q);
        }
        this.Q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public final void F() {
        if (!this.G && this.J == null && this.B) {
            for (zb zbVar : this.u) {
                if (zbVar.t() == null) {
                    return;
                }
            }
            vj vjVar = this.H;
            if (vjVar != null) {
                int i = vjVar.b;
                int[] iArr = new int[i];
                this.J = iArr;
                Arrays.fill(iArr, -1);
                for (int i2 = 0; i2 < i; i2++) {
                    int i3 = 0;
                    while (true) {
                        zb[] zbVarArr = this.u;
                        if (i3 < zbVarArr.length) {
                            cy cyVarT = zbVarArr[i3].t();
                            ary.s(cyVarT);
                            cy cyVarA = this.H.a(i2).a(0);
                            String str = cyVarT.l;
                            String str2 = cyVarA.l;
                            int iJ = adz.j(str);
                            if (iJ == 3) {
                                if (aeu.c(str, str2) && (!("application/cea-608".equals(str) || "application/cea-708".equals(str)) || cyVarT.D == cyVarA.D)) {
                                    break;
                                } else {
                                    i3++;
                                }
                            } else if (iJ == adz.j(str2)) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    this.J[i2] = i3;
                }
                ArrayList<yu> arrayList = this.r;
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    arrayList.get(i4).a();
                }
                return;
            }
            int length = this.u.length;
            int i5 = 0;
            int i6 = 6;
            int i7 = -1;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                cy cyVarT2 = this.u[i5].t();
                ary.s(cyVarT2);
                String str3 = cyVarT2.l;
                int i8 = adz.b(str3) ? 2 : adz.a(str3) ? 1 : adz.c(str3) ? 3 : 6;
                if (Q(i8) > Q(i6)) {
                    i7 = i5;
                    i6 = i8;
                } else if (i8 == i6) {
                    i7 = -1;
                }
                i5++;
            }
            vh vhVarB = this.e.b();
            int i9 = vhVarB.a;
            this.K = -1;
            this.J = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                this.J[i10] = i10;
            }
            vh[] vhVarArr = new vh[length];
            for (int i11 = 0; i11 < length; i11++) {
                cy cyVarT3 = this.u[i11].t();
                ary.s(cyVarT3);
                if (i11 == i7) {
                    cy[] cyVarArr = new cy[i9];
                    if (i9 == 1) {
                        cyVarArr[0] = cyVarT3.b(vhVarB.a(0));
                    } else {
                        for (int i12 = 0; i12 < i9; i12++) {
                            cyVarArr[i12] = R(vhVarB.a(i12), cyVarT3, true);
                        }
                    }
                    vhVarArr[i11] = new vh(cyVarArr);
                    this.K = i11;
                } else {
                    cy cyVar = null;
                    if (i6 == 2 && adz.a(cyVarT3.l)) {
                        cyVar = this.f;
                    }
                    vhVarArr[i11] = new vh(R(cyVar, cyVarT3, false));
                }
            }
            this.H = L(vhVarArr);
            ary.q(this.I == null);
            this.I = Collections.emptySet();
            O();
            this.d.p();
        }
    }

    private final vj L(vh[] vhVarArr) {
        for (int i = 0; i < vhVarArr.length; i++) {
            vh vhVar = vhVarArr[i];
            cy[] cyVarArr = new cy[vhVar.a];
            for (int i2 = 0; i2 < vhVar.a; i2++) {
                cy cyVarA = vhVar.a(i2);
                cyVarArr[i2] = cyVarA.c(this.g.a(cyVarA));
            }
            vhVarArr[i] = new vh(cyVarArr);
        }
        return new vj(vhVarArr);
    }

    private final yq M() {
        return this.m.get(r0.size() - 1);
    }

    private final boolean N() {
        return this.P != -9223372036854775807L;
    }

    private final void O() {
        this.C = true;
    }

    private final void P() {
        ary.q(this.C);
        ary.t(this.H);
        ary.t(this.I);
    }

    private static int Q(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 3;
    }

    private static cy R(cy cyVar, cy cyVar2, boolean z) {
        if (cyVar == null) {
            return cyVar2;
        }
        String strT = aeu.T(cyVar.i, adz.j(cyVar2.l));
        String strH = adz.h(strT);
        cx cxVarA = cyVar2.a();
        cxVarA.S(cyVar.a);
        cxVarA.U(cyVar.b);
        cxVarA.V(cyVar.c);
        cxVarA.ag(cyVar.d);
        cxVarA.ac(cyVar.e);
        cxVarA.G(z ? cyVar.f : -1);
        cxVarA.Z(z ? cyVar.g : -1);
        cxVarA.I(strT);
        cxVarA.aj(cyVar.q);
        cxVarA.Q(cyVar.r);
        if (strH != null) {
            cxVarA.ae(strH);
        }
        int i = cyVar.y;
        if (i != -1) {
            cxVarA.H(i);
        }
        qz qzVarC = cyVar.j;
        if (qzVarC != null) {
            qz qzVar = cyVar2.j;
            if (qzVar != null) {
                qzVarC = qzVar.c(qzVarC);
            }
            cxVarA.X(qzVarC);
        }
        return cxVarA.a();
    }

    private static jx S(int i, int i2) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unmapped track with id ");
        sb.append(i);
        sb.append(" of type ");
        sb.append(i2);
        Log.w("HlsSampleStreamWrapper", sb.toString());
        return new jx();
    }

    public final int A(int i, cz czVar, iw iwVar, boolean z) {
        cy cyVar;
        if (N()) {
            return -3;
        }
        int i2 = 0;
        if (!this.m.isEmpty()) {
            int i3 = 0;
            loop0: while (i3 < this.m.size() - 1) {
                int i4 = this.m.get(i3).a;
                int length = this.u.length;
                for (int i5 = 0; i5 < length; i5++) {
                    if (this.M[i5] && this.u[i5].s() == i4) {
                        break loop0;
                    }
                }
                i3++;
            }
            aeu.e(this.m, 0, i3);
            yq yqVar = this.m.get(0);
            cy cyVar2 = yqVar.f;
            if (!cyVar2.equals(this.F)) {
                this.j.r(this.c, cyVar2, yqVar.g, yqVar.h, yqVar.i);
            }
            this.F = cyVar2;
        }
        int iZ = this.u[i].z(czVar, iwVar, z, this.S);
        if (iZ != -5) {
            return iZ;
        }
        cy cyVarB = czVar.a;
        ary.t(cyVarB);
        if (i == this.A) {
            int iS = this.u[i].s();
            while (i2 < this.m.size() && this.m.get(i2).a != iS) {
                i2++;
            }
            if (i2 < this.m.size()) {
                cyVar = this.m.get(i2).f;
            } else {
                cyVar = this.E;
                ary.t(cyVar);
            }
            cyVarB = cyVarB.b(cyVar);
        }
        czVar.a = cyVarB;
        return -5;
    }

    public final int B(int i, long j) {
        if (N()) {
            return 0;
        }
        zb zbVar = this.u[i];
        int iC = zbVar.C(j, this.S);
        zbVar.D(iC);
        return iC;
    }

    public final void C() {
        this.w.clear();
    }

    public final void D(long j) {
        if (this.U != j) {
            this.U = j;
            for (zb zbVar : this.u) {
                zbVar.H(j);
            }
        }
    }

    public final void E(jc jcVar) {
        if (aeu.c(this.V, jcVar)) {
            return;
        }
        this.V = jcVar;
        int i = 0;
        while (true) {
            zb[] zbVarArr = this.u;
            if (i >= zbVarArr.length) {
                return;
            }
            if (this.N[i]) {
                zbVarArr[i].N(jcVar);
            }
            i++;
        }
    }

    final /* bridge */ /* synthetic */ void G() {
        this.B = true;
        F();
    }

    public final void H(vh[] vhVarArr, int... iArr) {
        this.H = L(vhVarArr);
        this.I = new HashSet();
        for (int i : iArr) {
            this.I.add(this.H.a(i));
        }
        this.K = 0;
        Handler handler = this.q;
        yz yzVar = this.d;
        yzVar.getClass();
        handler.post(yx.a(yzVar));
        O();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.uz
    public final void K() {
        this.q.post(this.o);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.ads.interactivemedia.v3.internal.zb[]] */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.google.ads.interactivemedia.v3.internal.zb[]] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.ads.interactivemedia.v3.internal.kr] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.google.ads.interactivemedia.v3.internal.va, com.google.ads.interactivemedia.v3.internal.zb, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.google.ads.interactivemedia.v3.internal.jx] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    @Override // com.google.ads.interactivemedia.v3.internal.ka
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.ads.interactivemedia.v3.internal.kr ak(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zc.ak(int, int):com.google.ads.interactivemedia.v3.internal.kr");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ka
    public final void al() {
        this.T = true;
        this.q.post(this.p);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ka
    public final void am(ko koVar) {
    }

    public final void d() {
        if (this.C) {
            return;
        }
        n(this.O);
    }

    public final void e() throws IOException {
        z();
        if (this.S && !this.C) {
            throw new dt("Loading finished before preparation is complete.");
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final void f(long j) {
        int i;
        if (this.i.c() || N()) {
            return;
        }
        if (this.i.f()) {
            ary.t(this.t);
            if (this.e.m(j, this.t, this.n)) {
                this.i.g();
                return;
            }
            return;
        }
        int iL = this.e.l(j, this.n);
        if (iL < this.m.size()) {
            ary.q(!this.i.f());
            loop0: while (true) {
                if (iL >= this.m.size()) {
                    iL = -1;
                    break;
                }
                int i2 = iL;
                while (true) {
                    if (i2 >= this.m.size()) {
                        yq yqVar = this.m.get(iL);
                        while (i < this.u.length) {
                            i = this.u[i].r() <= yqVar.e(i) ? i + 1 : 0;
                        }
                        break loop0;
                    } else if (this.m.get(i2).n) {
                        break;
                    } else {
                        i2++;
                    }
                }
                iL++;
            }
            if (iL == -1) {
                return;
            }
            long j2 = M().j;
            yq yqVar2 = this.m.get(iL);
            ArrayList<yq> arrayList = this.m;
            aeu.e(arrayList, iL, arrayList.size());
            for (int i3 = 0; i3 < this.u.length; i3++) {
                this.u[i3].n(yqVar2.e(i3));
            }
            if (this.m.isEmpty()) {
                this.P = this.O;
            } else {
                ((yq) ary.a(this.m)).k();
            }
            this.S = false;
            this.j.p(this.z, yqVar2.i, j2);
        }
    }

    public final vj g() {
        P();
        return this.H;
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final long h() {
        /*
            r7 = this;
            boolean r0 = r7.S
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.N()
            if (r0 == 0) goto L10
            long r0 = r7.P
            return r0
        L10:
            long r0 = r7.O
            com.google.ads.interactivemedia.v3.internal.yq r2 = r7.M()
            boolean r3 = r2.j()
            if (r3 != 0) goto L35
            java.util.ArrayList<com.google.ads.interactivemedia.v3.internal.yq> r2 = r7.m
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L34
            java.util.ArrayList<com.google.ads.interactivemedia.v3.internal.yq> r2 = r7.m
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            com.google.ads.interactivemedia.v3.internal.yq r2 = (com.google.ads.interactivemedia.v3.internal.yq) r2
            goto L35
        L34:
            r2 = 0
        L35:
            if (r2 == 0) goto L3d
            long r2 = r2.j
            long r0 = java.lang.Math.max(r0, r2)
        L3d:
            boolean r2 = r7.B
            if (r2 == 0) goto L54
            com.google.ads.interactivemedia.v3.internal.zb[] r2 = r7.u
            int r3 = r2.length
            r4 = 0
        L45:
            if (r4 >= r3) goto L54
            r5 = r2[r4]
            long r5 = r5.u()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L45
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zc.h():long");
    }

    public final int i(int i) {
        P();
        ary.t(this.J);
        int i2 = this.J[i];
        if (i2 == -1) {
            return this.I.contains(this.H.a(i)) ? -3 : -2;
        }
        boolean[] zArr = this.M;
        if (zArr[i2]) {
            return -2;
        }
        zArr[i2] = true;
        return i2;
    }

    public final void j(int i) {
        P();
        ary.t(this.J);
        int i2 = this.J[i];
        ary.q(this.M[i2]);
        this.M[i2] = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(com.google.ads.interactivemedia.v3.internal.aba[] r19, boolean[] r20, com.google.ads.interactivemedia.v3.internal.vb[] r21, boolean[] r22, long r23, boolean r25) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zc.k(com.google.ads.interactivemedia.v3.internal.aba[], boolean[], com.google.ads.interactivemedia.v3.internal.vb[], boolean[], long, boolean):boolean");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final long l() {
        if (N()) {
            return this.P;
        }
        if (this.S) {
            return Long.MIN_VALUE;
        }
        return M().j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.acx
    public final void m() {
        for (zb zbVar : this.u) {
            zbVar.g();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final boolean n(long j) {
        List<yq> listEmptyList;
        long jMax;
        if (this.S || this.i.f() || this.i.c()) {
            return false;
        }
        if (N()) {
            listEmptyList = Collections.emptyList();
            jMax = this.P;
            for (zb zbVar : this.u) {
                zbVar.j(this.P);
            }
        } else {
            listEmptyList = this.n;
            yq yqVarM = M();
            jMax = yqVarM.j() ? yqVarM.j : Math.max(this.O, yqVarM.i);
        }
        List<yq> list = listEmptyList;
        this.e.g(j, jMax, list, this.C || !list.isEmpty(), this.l);
        yl ylVar = this.l;
        boolean z = ylVar.b;
        vt vtVar = ylVar.a;
        Uri uri = ylVar.c;
        ylVar.a();
        if (z) {
            this.P = -9223372036854775807L;
            this.S = true;
            return true;
        }
        if (vtVar == null) {
            if (uri != null) {
                this.d.q(uri);
            }
            return false;
        }
        if (vtVar instanceof yq) {
            yq yqVar = (yq) vtVar;
            this.W = yqVar;
            this.E = yqVar.f;
            this.P = -9223372036854775807L;
            this.m.add(yqVar);
            ark arkVarR = arn.r();
            for (zb zbVar2 : this.u) {
                arkVarR.d(Integer.valueOf(zbVar2.m()));
            }
            yqVar.d(this, arkVarR.c());
            for (zb zbVar3 : this.u) {
                zbVar3.M(yqVar);
                if (yqVar.n) {
                    zbVar3.l();
                }
            }
        }
        this.t = vtVar;
        this.i.e(vtVar, this, this.Y.a(vtVar.e));
        this.j.e(new to(vtVar.d), vtVar.e, this.c, vtVar.f, vtVar.g, vtVar.h, vtVar.i, vtVar.j);
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final boolean o() {
        return this.i.f();
    }

    public final void p(long j, boolean z) {
        if (!this.B || N()) {
            return;
        }
        int length = this.u.length;
        for (int i = 0; i < length; i++) {
            this.u[i].E(j, false, this.M[i]);
        }
    }

    public final boolean q(long j, boolean z) {
        this.O = j;
        if (N()) {
            this.P = j;
            return true;
        }
        if (this.B && !z) {
            int length = this.u.length;
            for (int i = 0; i < length; i++) {
                if (this.u[i].B(j, false) || (!this.N[i] && this.L)) {
                }
            }
            return false;
        }
        this.P = j;
        this.S = false;
        this.m.clear();
        if (this.i.f()) {
            this.i.g();
        } else {
            this.i.d();
            I();
        }
        return true;
    }

    public final void r() {
        if (this.C) {
            for (zb zbVar : this.u) {
                zbVar.o();
            }
        }
        this.i.i(this);
        this.q.removeCallbacksAndMessages(null);
        this.G = true;
        this.r.clear();
    }

    public final void s(boolean z) {
        this.e.f(z);
    }

    public final boolean t(Uri uri, long j) {
        return this.e.j(uri, j);
    }

    public final boolean u(int i) {
        return !N() && this.u[i].y(this.S);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ acu v(acw acwVar, long j, long j2, IOException iOException, int i) {
        acu acuVarB;
        vt vtVar = (vt) acwVar;
        long jF = vtVar.f();
        boolean z = vtVar instanceof yq;
        vtVar.g();
        vtVar.h();
        to toVar = new to();
        new tt(vtVar.e, this.c, vtVar.f, vtVar.g, vtVar.h, bi.a(vtVar.i), bi.a(vtVar.j));
        acr acrVar = new acr(iOException, i);
        long jB = acj.b(acrVar);
        boolean zI = jB != -9223372036854775807L ? this.e.i(vtVar, jB) : false;
        if (zI) {
            if (z && jF == 0) {
                ArrayList<yq> arrayList = this.m;
                ary.q(arrayList.remove(arrayList.size() + (-1)) == vtVar);
                if (this.m.isEmpty()) {
                    this.P = this.O;
                } else {
                    ((yq) ary.a(this.m)).k();
                }
            }
            acuVarB = ada.a;
        } else {
            long jC = acj.c(acrVar);
            acuVarB = jC != -9223372036854775807L ? ada.b(false, jC) : ada.b;
        }
        boolean z2 = !acuVarB.a();
        this.j.n(toVar, vtVar.e, this.c, vtVar.f, vtVar.g, vtVar.h, vtVar.i, vtVar.j, iOException, z2);
        if (z2) {
            this.t = null;
        }
        if (zI) {
            if (this.C) {
                this.d.m(this);
            } else {
                n(this.O);
            }
        }
        return acuVarB;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ void w(acw acwVar, long j, long j2, boolean z) {
        vt vtVar = (vt) acwVar;
        this.t = null;
        long j3 = vtVar.c;
        vtVar.g();
        vtVar.h();
        vtVar.f();
        this.j.k(new to(), vtVar.e, this.c, vtVar.f, vtVar.g, vtVar.h, vtVar.i, vtVar.j);
        if (z) {
            return;
        }
        if (N() || this.D == 0) {
            I();
        }
        if (this.D > 0) {
            this.d.m(this);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.act
    public final /* bridge */ /* synthetic */ void x(acw acwVar, long j, long j2) {
        vt vtVar = (vt) acwVar;
        this.t = null;
        this.e.h(vtVar);
        long j3 = vtVar.c;
        vtVar.g();
        vtVar.h();
        vtVar.f();
        this.j.h(new to(), vtVar.e, this.c, vtVar.f, vtVar.g, vtVar.h, vtVar.i, vtVar.j);
        if (this.C) {
            this.d.m(this);
        } else {
            n(this.O);
        }
    }

    public final void y(int i) throws IOException {
        z();
        this.u[i].p();
    }

    public final void z() throws IOException {
        this.i.a();
        this.e.a();
    }
}
