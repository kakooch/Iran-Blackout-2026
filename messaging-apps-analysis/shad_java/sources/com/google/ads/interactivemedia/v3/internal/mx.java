package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class mx implements jy, ko {
    public static final /* synthetic */ int a = 0;
    private final aee b;
    private final aee c;
    private final aee d;
    private final aee e;
    private final ArrayDeque<mc> f;
    private int g;
    private int h;
    private long i;
    private int j;
    private aee k;
    private int l;
    private int m;
    private int n;
    private int o;
    private ka p;
    private mw[] q;
    private long[][] r;
    private int s;
    private long t;
    private boolean u;

    static {
        int i = mv.b;
    }

    public mx() {
        this(null);
    }

    private final void i() {
        this.g = 0;
        this.j = 0;
    }

    private final void j(long j) throws dt {
        mx mxVar;
        qz qzVar;
        long j2;
        List<ne> list;
        int i;
        int i2;
        mx mxVar2 = this;
        while (!mxVar2.f.isEmpty() && mxVar2.f.peek().a == j) {
            mc mcVarPop = mxVar2.f.pop();
            if (mcVarPop.d == 1836019574) {
                ArrayList arrayList = new ArrayList();
                ki kiVar = new ki();
                md mdVarC = mcVarPop.c(1969517665);
                if (mdVarC != null) {
                    qz qzVarA = ml.a(mdVarC, mxVar2.u);
                    if (qzVarA != null) {
                        kiVar.b(qzVarA);
                    }
                    qzVar = qzVarA;
                } else {
                    qzVar = null;
                }
                mc mcVarD = mcVarPop.d(1835365473);
                qz qzVarB = mcVarD != null ? ml.b(mcVarD) : null;
                List<ne> listC = ml.c(mcVarPop, kiVar, -9223372036854775807L, null, mxVar2.u, mu.a);
                ka kaVar = mxVar2.p;
                ary.t(kaVar);
                int size = listC.size();
                long j3 = -9223372036854775807L;
                long jMax = -9223372036854775807L;
                int i3 = 0;
                int size2 = -1;
                while (true) {
                    j2 = 0;
                    if (i3 >= size) {
                        break;
                    }
                    ne neVar = listC.get(i3);
                    if (neVar.b == 0) {
                        list = listC;
                        i = size;
                    } else {
                        nb nbVar = neVar.a;
                        ArrayList arrayList2 = arrayList;
                        long j4 = nbVar.e;
                        if (j4 == j3) {
                            j4 = neVar.h;
                        }
                        jMax = Math.max(jMax, j4);
                        mw mwVar = new mw(nbVar, neVar, kaVar.ak(i3, nbVar.b));
                        int i4 = neVar.e;
                        list = listC;
                        cx cxVarA = nbVar.f.a();
                        cxVarA.W(i4 + 30);
                        i = size;
                        if (nbVar.b == 2 && j4 > 0 && (i2 = neVar.b) > 1) {
                            cxVarA.P(i2 / (j4 / 1000000.0f));
                        }
                        int i5 = nbVar.b;
                        int i6 = mt.b;
                        if (i5 == 1) {
                            if (kiVar.a()) {
                                cxVarA.M(kiVar.a);
                                cxVarA.N(kiVar.b);
                            }
                            if (qzVar != null) {
                                cxVarA.X(qzVar);
                            }
                        } else if (i5 == 2 && qzVarB != null) {
                            ArrayList arrayList3 = new ArrayList();
                            for (int i7 = 0; i7 < qzVarB.a(); i7++) {
                                qy qyVarB = qzVarB.b(i7);
                                if (qyVarB instanceof sn) {
                                    sn snVar = (sn) qyVarB;
                                    if ("com.android.capture.fps".equals(snVar.a) || "com.android.video.temporal_layers_count".equals(snVar.a)) {
                                        arrayList3.add(snVar);
                                    }
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                cxVarA.X(new qz(arrayList3));
                            }
                        }
                        mwVar.c.a(cxVarA.a());
                        if (nbVar.b == 2 && size2 == -1) {
                            size2 = arrayList2.size();
                        }
                        arrayList = arrayList2;
                        arrayList.add(mwVar);
                    }
                    i3++;
                    j3 = -9223372036854775807L;
                    mxVar2 = this;
                    listC = list;
                    size = i;
                }
                mxVar = mxVar2;
                mxVar.s = size2;
                mxVar.t = jMax;
                mw[] mwVarArr = (mw[]) arrayList.toArray(new mw[0]);
                mxVar.q = mwVarArr;
                int length = mwVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i8 = 0; i8 < mwVarArr.length; i8++) {
                    jArr[i8] = new long[mwVarArr[i8].b.b];
                    jArr2[i8] = mwVarArr[i8].b.f[0];
                }
                int i9 = 0;
                while (i9 < mwVarArr.length) {
                    long j5 = Long.MAX_VALUE;
                    int i10 = -1;
                    for (int i11 = 0; i11 < mwVarArr.length; i11++) {
                        if (!zArr[i11]) {
                            long j6 = jArr2[i11];
                            if (j6 <= j5) {
                                i10 = i11;
                                j5 = j6;
                            }
                        }
                    }
                    int i12 = iArr[i10];
                    long[] jArr3 = jArr[i10];
                    jArr3[i12] = j2;
                    ne neVar2 = mwVarArr[i10].b;
                    j2 += neVar2.d[i12];
                    int i13 = i12 + 1;
                    iArr[i10] = i13;
                    if (i13 < jArr3.length) {
                        jArr2[i10] = neVar2.f[i13];
                    } else {
                        zArr[i10] = true;
                        i9++;
                    }
                }
                mxVar.r = jArr;
                kaVar.al();
                kaVar.am(mxVar);
                mxVar.f.clear();
                mxVar.g = 2;
            } else {
                mxVar = mxVar2;
                if (!mxVar.f.isEmpty()) {
                    mxVar.f.peek().b(mcVarPop);
                }
            }
            mxVar2 = mxVar;
        }
        if (mxVar2.g != 2) {
            i();
        }
    }

    private static long k(ne neVar, long j, long j2) {
        int iL = l(neVar, j);
        return iL == -1 ? j2 : Math.min(neVar.c[iL], j2);
    }

    private static int l(ne neVar, long j) {
        int iA = neVar.a(j);
        return iA == -1 ? neVar.b(j) : iA;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final boolean a() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final km b(long j) {
        long j2;
        long jK;
        long j3;
        long j4;
        int iB;
        if (((mw[]) ary.t(this.q)).length == 0) {
            kp kpVar = kp.a;
            return new km(kpVar, kpVar);
        }
        int i = this.s;
        if (i != -1) {
            ne neVar = this.q[i].b;
            int iL = l(neVar, j);
            if (iL == -1) {
                kp kpVar2 = kp.a;
                return new km(kpVar2, kpVar2);
            }
            long j5 = neVar.f[iL];
            j2 = neVar.c[iL];
            if (j5 >= j || iL >= neVar.b - 1 || (iB = neVar.b(j)) == -1 || iB == iL) {
                j4 = -1;
                j3 = -9223372036854775807L;
            } else {
                j3 = neVar.f[iB];
                j4 = neVar.c[iB];
            }
            jK = j4;
            j = j5;
        } else {
            j2 = Long.MAX_VALUE;
            jK = -1;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            mw[] mwVarArr = this.q;
            if (i2 >= mwVarArr.length) {
                break;
            }
            if (i2 != this.s) {
                ne neVar2 = mwVarArr[i2].b;
                long jK2 = k(neVar2, j, j2);
                if (j3 != -9223372036854775807L) {
                    jK = k(neVar2, j3, jK);
                }
                j2 = jK2;
            }
            i2++;
        }
        kp kpVar3 = new kp(j, j2);
        return j3 == -9223372036854775807L ? new km(kpVar3, kpVar3) : new km(kpVar3, new kp(j3, jK));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ko
    public final long c() {
        return this.t;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.p = kaVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        this.f.clear();
        this.j = 0;
        this.l = -1;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        if (j == 0) {
            i();
            return;
        }
        mw[] mwVarArr = this.q;
        if (mwVarArr != null) {
            for (mw mwVar : mwVarArr) {
                ne neVar = mwVar.b;
                int iA = neVar.a(j2);
                if (iA == -1) {
                    iA = neVar.b(j2);
                }
                mwVar.d = iA;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final boolean g(jv jvVar) throws IOException {
        return na.b(jvVar);
    }

    public mx(byte[] bArr) {
        this.e = new aee(16);
        this.f = new ArrayDeque<>();
        this.b = new aee(aec.a);
        this.c = new aee(4);
        this.d = new aee();
        this.l = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    @Override // com.google.ads.interactivemedia.v3.internal.jy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(com.google.ads.interactivemedia.v3.internal.jv r30, com.google.ads.interactivemedia.v3.internal.kl r31) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 964
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.mx.h(com.google.ads.interactivemedia.v3.internal.jv, com.google.ads.interactivemedia.v3.internal.kl):int");
    }
}
