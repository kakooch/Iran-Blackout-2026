package com.google.ads.interactivemedia.v3.internal;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class pm implements jy {
    public static final /* synthetic */ int a = 0;
    private final int b;
    private final int c;
    private final List<aes> d;
    private final aee e;
    private final SparseIntArray f;
    private final pp g;
    private final SparseArray<pr> h;
    private final SparseBooleanArray i;
    private final SparseBooleanArray j;
    private final pi k;
    private ph l;
    private ka m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private pr r;
    private int s;
    private int t;

    static {
        int i = pj.b;
    }

    public pm() {
        this(1, 112800);
    }

    static /* synthetic */ void r(pm pmVar) {
        pmVar.n++;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void d(ka kaVar) {
        this.m = kaVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void e(long j, long j2) {
        ph phVar;
        ary.q(this.b != 2);
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            aes aesVar = this.d.get(i);
            if (aesVar.d() == -9223372036854775807L || (aesVar.d() != 0 && aesVar.b() != j2)) {
                aesVar.e();
                aesVar.a(j2);
            }
        }
        if (j2 != 0 && (phVar = this.l) != null) {
            phVar.b(j2);
        }
        this.e.a(0);
        this.f.clear();
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            this.h.valueAt(i2).b();
        }
        this.s = 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final void f() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        r2 = r2 + 1;
     */
    @Override // com.google.ads.interactivemedia.v3.internal.jy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(com.google.ads.interactivemedia.v3.internal.jv r7) throws java.io.IOException {
        /*
            r6 = this;
            com.google.ads.interactivemedia.v3.internal.aee r0 = r6.e
            byte[] r0 = r0.i()
            r1 = 0
            r2 = 940(0x3ac, float:1.317E-42)
            r7.g(r0, r1, r2)
            r2 = 0
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r2 >= r3) goto L29
            r3 = 0
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r2
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r2 = r2 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.d(r2)
            r7 = 1
            return r7
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.pm.g(com.google.ads.interactivemedia.v3.internal.jv):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    @Override // com.google.ads.interactivemedia.v3.internal.jy
    public final int h(jv jvVar, kl klVar) throws IOException {
        int i;
        ?? r15;
        boolean z;
        long jM = jvVar.m();
        if (!this.o) {
            i = 2;
            r15 = 0;
        } else {
            if (jM != -1 && this.b != 2 && !this.k.a()) {
                return this.k.d(jvVar, klVar, this.t);
            }
            if (this.p) {
                i = 2;
                z = false;
            } else {
                this.p = true;
                if (this.k.b() != -9223372036854775807L) {
                    z = false;
                    i = 2;
                    ph phVar = new ph(this.k.c(), this.k.b(), jM, this.t, this.c);
                    this.l = phVar;
                    this.m.am(phVar.a());
                } else {
                    i = 2;
                    z = false;
                    this.m.am(new kn(this.k.b()));
                }
            }
            if (this.q) {
                this.q = z;
                e(0L, 0L);
                if (jvVar.l() != 0) {
                    klVar.a = 0L;
                    return 1;
                }
            }
            ph phVar2 = this.l;
            r15 = z;
            if (phVar2 != null) {
                r15 = z;
                if (phVar2.c()) {
                    return this.l.d(jvVar, klVar);
                }
            }
        }
        byte[] bArrI = this.e.i();
        if (9400 - this.e.g() < 188) {
            int iD = this.e.d();
            if (iD > 0) {
                System.arraycopy(bArrI, this.e.g(), bArrI, r15, iD);
            }
            this.e.c(bArrI, iD);
        }
        while (this.e.d() < 188) {
            int iE = this.e.e();
            int iA = jvVar.a(bArrI, iE, 9400 - iE);
            if (iA == -1) {
                return -1;
            }
            this.e.f(iE + iA);
        }
        int iG = this.e.g();
        int iE2 = this.e.e();
        int iF = mz.f(this.e.i(), iG, iE2);
        this.e.h(iF);
        int i2 = iF + 188;
        if (i2 > iE2) {
            int i3 = this.s + (iF - iG);
            this.s = i3;
            if (this.b == i && i3 > 376) {
                throw new dt("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            this.s = r15;
        }
        int iE3 = this.e.e();
        if (i2 > iE3) {
            return r15;
        }
        int iV = this.e.v();
        if ((8388608 & iV) != 0) {
            this.e.h(i2);
            return r15;
        }
        int i4 = (4194304 & iV) != 0 ? 1 : 0;
        int i5 = (iV >> 8) & 8191;
        int i6 = iV & 32;
        pr prVar = (iV & 16) != 0 ? this.h.get(i5) : null;
        if (prVar == null) {
            this.e.h(i2);
            return r15;
        }
        if (this.b != i) {
            int i7 = iV & 15;
            int i8 = this.f.get(i5, i7 - 1);
            this.f.put(i5, i7);
            if (i8 == i7) {
                this.e.h(i2);
                return r15;
            }
            if (i7 != ((i8 + 1) & 15)) {
                prVar.b();
            }
        }
        if (i6 != 0) {
            int iN = this.e.n();
            i4 |= (this.e.n() & 64) != 0 ? 2 : 0;
            this.e.k(iN - 1);
        }
        boolean z2 = this.o;
        if (this.b == i || z2 || !this.j.get(i5, r15)) {
            this.e.f(i2);
            prVar.c(this.e, i4);
            this.e.f(iE3);
        }
        if (this.b != i && !z2 && this.o && jM != -1) {
            this.q = true;
        }
        this.e.h(i2);
        return r15;
    }

    public pm(int i, int i2) {
        this(1, new aes(0L), new oe(null), 112800);
    }

    public pm(int i, aes aesVar, pp ppVar, int i2) {
        this.g = ppVar;
        this.c = 112800;
        this.b = i;
        this.d = Collections.singletonList(aesVar);
        this.e = new aee(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.i = sparseBooleanArray;
        this.j = new SparseBooleanArray();
        SparseArray<pr> sparseArray = new SparseArray<>();
        this.h = sparseArray;
        this.f = new SparseIntArray();
        this.k = new pi(112800);
        this.t = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray<pr> sparseArrayA = ppVar.a();
        int size = sparseArrayA.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.h.put(sparseArrayA.keyAt(i3), sparseArrayA.valueAt(i3));
        }
        this.h.put(0, new pe(new pk(this)));
        this.r = null;
    }
}
