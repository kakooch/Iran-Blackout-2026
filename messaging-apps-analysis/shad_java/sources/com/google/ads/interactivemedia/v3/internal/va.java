package com.google.ads.interactivemedia.v3.internal;

import android.os.Looper;
import com.facebook.stetho.websocket.CloseCodes;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class va implements kr {
    private cy A;
    private cy B;
    private cy C;
    private int D;
    private boolean E;
    private boolean F;
    private long G;
    private boolean H;
    private ji I;
    private final ux a;
    private final Looper c;
    private final jh d;
    private final je e;
    private uz f;
    private cy g;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean w;
    private boolean z;
    private final uy b = new uy();
    private int h = CloseCodes.NORMAL_CLOSURE;
    private int[] i = new int[CloseCodes.NORMAL_CLOSURE];
    private long[] j = new long[CloseCodes.NORMAL_CLOSURE];
    private long[] m = new long[CloseCodes.NORMAL_CLOSURE];
    private int[] l = new int[CloseCodes.NORMAL_CLOSURE];
    private int[] k = new int[CloseCodes.NORMAL_CLOSURE];
    private kq[] n = new kq[CloseCodes.NORMAL_CLOSURE];
    private cy[] o = new cy[CloseCodes.NORMAL_CLOSURE];
    private long t = Long.MIN_VALUE;
    private long u = Long.MIN_VALUE;
    private long v = Long.MIN_VALUE;
    private boolean y = true;
    private boolean x = true;

    public va(acc accVar, Looper looper, jh jhVar, je jeVar) {
        this.c = looper;
        this.d = jhVar;
        this.e = jeVar;
        this.a = new ux(accVar);
    }

    private final synchronized void M() {
        this.s = 0;
        this.a.c();
    }

    private final synchronized int N(cz czVar, iw iwVar, boolean z, boolean z2, uy uyVar) {
        iwVar.c = false;
        if (!V()) {
            if (!z2 && !this.w) {
                cy cyVar = this.B;
                if (cyVar == null || (!z && cyVar == this.g)) {
                    return -3;
                }
                ary.t(cyVar);
                W(cyVar, czVar);
                return -5;
            }
            iwVar.f(4);
            return -4;
        }
        int iAb = ab(this.s);
        if (!z && this.o[iAb] == this.g) {
            if (!X(iAb)) {
                iwVar.c = true;
                return -3;
            }
            iwVar.f(this.l[iAb]);
            long j = this.m[iAb];
            iwVar.d = j;
            if (j < this.t) {
                iwVar.g(Integer.MIN_VALUE);
            }
            if (iwVar.j()) {
                return -4;
            }
            uyVar.a = this.k[iAb];
            uyVar.b = this.j[iAb];
            uyVar.c = this.n[iAb];
            this.s++;
            return -4;
        }
        W(this.o[iAb], czVar);
        return -5;
    }

    private final synchronized boolean O(cy cyVar) {
        this.y = false;
        if (aeu.c(cyVar, this.B)) {
            return false;
        }
        if (aeu.c(cyVar, this.C)) {
            this.B = this.C;
        } else {
            this.B = cyVar;
        }
        cy cyVar2 = this.B;
        this.E = adz.d(cyVar2.l, cyVar2.i);
        this.F = false;
        return true;
    }

    private final synchronized long P(long j, boolean z, boolean z2) {
        int i;
        int i2 = this.p;
        if (i2 != 0) {
            long[] jArr = this.m;
            int i3 = this.r;
            if (j >= jArr[i3]) {
                if (z2 && (i = this.s) != i2) {
                    i2 = i + 1;
                }
                int iY = Y(i3, i2, j, false);
                if (iY == -1) {
                    return -1L;
                }
                return Z(iY);
            }
        }
        return -1L;
    }

    private final synchronized long Q() {
        int i = this.p;
        if (i == 0) {
            return -1L;
        }
        return Z(i);
    }

    private final void R() {
        if (this.I != null) {
            this.I = null;
            this.g = null;
        }
    }

    private final synchronized void S(long j, int i, long j2, int i2, kq kqVar) {
        int i3 = this.p;
        if (i3 > 0) {
            int iAb = ab(i3 - 1);
            ary.o(this.j[iAb] + ((long) this.k[iAb]) <= j2);
        }
        this.w = (536870912 & i) != 0;
        this.v = Math.max(this.v, j);
        int iAb2 = ab(this.p);
        this.m[iAb2] = j;
        long[] jArr = this.j;
        jArr[iAb2] = j2;
        this.k[iAb2] = i2;
        this.l[iAb2] = i;
        this.n[iAb2] = kqVar;
        cy[] cyVarArr = this.o;
        cy cyVar = this.B;
        cyVarArr[iAb2] = cyVar;
        this.i[iAb2] = this.D;
        this.C = cyVar;
        int i4 = this.p + 1;
        this.p = i4;
        int i5 = this.h;
        if (i4 == i5) {
            int i6 = i5 + CloseCodes.NORMAL_CLOSURE;
            int[] iArr = new int[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            kq[] kqVarArr = new kq[i6];
            cy[] cyVarArr2 = new cy[i6];
            int i7 = this.r;
            int i8 = i5 - i7;
            System.arraycopy(jArr, i7, jArr2, 0, i8);
            System.arraycopy(this.m, this.r, jArr3, 0, i8);
            System.arraycopy(this.l, this.r, iArr2, 0, i8);
            System.arraycopy(this.k, this.r, iArr3, 0, i8);
            System.arraycopy(this.n, this.r, kqVarArr, 0, i8);
            System.arraycopy(this.o, this.r, cyVarArr2, 0, i8);
            System.arraycopy(this.i, this.r, iArr, 0, i8);
            int i9 = this.r;
            System.arraycopy(this.j, 0, jArr2, i8, i9);
            System.arraycopy(this.m, 0, jArr3, i8, i9);
            System.arraycopy(this.l, 0, iArr2, i8, i9);
            System.arraycopy(this.k, 0, iArr3, i8, i9);
            System.arraycopy(this.n, 0, kqVarArr, i8, i9);
            System.arraycopy(this.o, 0, cyVarArr2, i8, i9);
            System.arraycopy(this.i, 0, iArr, i8, i9);
            this.j = jArr2;
            this.m = jArr3;
            this.l = iArr2;
            this.k = iArr3;
            this.n = kqVarArr;
            this.o = cyVarArr2;
            this.i = iArr;
            this.r = 0;
            this.h = i6;
        }
    }

    private final synchronized boolean T(long j) {
        if (this.p == 0) {
            return j > this.u;
        }
        if (v() >= j) {
            return false;
        }
        int i = this.p;
        int iAb = ab(i - 1);
        while (i > this.s && this.m[iAb] >= j) {
            i--;
            iAb--;
            if (iAb == -1) {
                iAb = this.h - 1;
            }
        }
        U(this.q + i);
        return true;
    }

    private final long U(int i) {
        int iM = m() - i;
        ary.o(iM >= 0 && iM <= this.p - this.s);
        int i2 = this.p - iM;
        this.p = i2;
        this.v = Math.max(this.u, aa(i2));
        this.w = iM == 0 && this.w;
        int i3 = this.p;
        if (i3 == 0) {
            return 0L;
        }
        return this.j[ab(i3 - 1)] + this.k[r8];
    }

    private final boolean V() {
        return this.s != this.p;
    }

    private final void W(cy cyVar, cz czVar) {
        cy cyVar2 = this.g;
        jc jcVar = cyVar2 == null ? null : cyVar2.o;
        this.g = cyVar;
        jc jcVar2 = cyVar.o;
        czVar.a = cyVar.c(this.d.a(cyVar));
        czVar.b = this.I;
        if (cyVar2 == null || !aeu.c(jcVar, jcVar2)) {
            ji jiVarD = this.d.d(cyVar);
            this.I = jiVarD;
            czVar.b = jiVarD;
        }
    }

    private final boolean X(int i) {
        if (this.I != null) {
            return (this.l[i] & 1073741824) != 0 ? false : false;
        }
        return true;
    }

    private final int Y(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2 && this.m[i] <= j; i4++) {
            if (!z || (this.l[i] & 1) != 0) {
                i3 = i4;
            }
            i++;
            if (i == this.h) {
                i = 0;
            }
        }
        return i3;
    }

    private final long Z(int i) {
        this.u = Math.max(this.u, aa(i));
        int i2 = this.p - i;
        this.p = i2;
        this.q += i;
        int i3 = this.r + i;
        this.r = i3;
        int i4 = this.h;
        if (i3 >= i4) {
            i3 -= i4;
            this.r = i3;
        }
        int i5 = this.s - i;
        this.s = i5;
        if (i5 < 0) {
            this.s = 0;
        }
        if (i2 != 0) {
            return this.j[i3];
        }
        if (i3 != 0) {
            i4 = i3;
        }
        return this.j[i4 - 1] + this.k[r2];
    }

    private final long aa(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iAb = ab(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.m[iAb]);
            if ((this.l[iAb] & 1) != 0) {
                break;
            }
            iAb--;
            if (iAb == -1) {
                iAb = this.h - 1;
            }
        }
        return jMax;
    }

    private final int ab(int i) {
        int i2 = this.r + i;
        int i3 = this.h;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final synchronized boolean A(int i) {
        boolean z;
        M();
        int i2 = this.q;
        if (i < i2 || i > this.p + i2) {
            z = false;
        } else {
            this.t = Long.MIN_VALUE;
            this.s = i - i2;
            z = true;
        }
        return z;
    }

    public final synchronized boolean B(long j, boolean z) {
        M();
        int iAb = ab(this.s);
        if (!V() || j < this.m[iAb] || (j > this.v && !z)) {
            return false;
        }
        int iY = Y(iAb, this.p - this.s, j, true);
        if (iY == -1) {
            return false;
        }
        this.t = j;
        this.s += iY;
        return true;
    }

    public final synchronized int C(long j, boolean z) {
        int iAb = ab(this.s);
        if (V() && j >= this.m[iAb]) {
            if (j > this.v && z) {
                return this.p - this.s;
            }
            int iY = Y(iAb, this.p - this.s, j, true);
            if (iY == -1) {
                return 0;
            }
            return iY;
        }
        return 0;
    }

    public final synchronized void D(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.s + i <= this.p) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ary.o(z);
        this.s += i;
    }

    public final void E(long j, boolean z, boolean z2) {
        this.a.e(P(j, false, z2));
    }

    public final void F() {
        this.a.e(L());
    }

    public final void G() {
        this.a.e(Q());
    }

    public final void H(long j) {
        if (this.G != j) {
            this.G = j;
            J();
        }
    }

    public final void I(uz uzVar) {
        this.f = uzVar;
    }

    protected final void J() {
        this.z = true;
    }

    protected cy K(cy cyVar) {
        if (this.G == 0 || cyVar.p == Long.MAX_VALUE) {
            return cyVar;
        }
        cx cxVarA = cyVar.a();
        cxVarA.ai(cyVar.p + this.G);
        return cxVarA.a();
    }

    public final synchronized long L() {
        int i = this.s;
        if (i == 0) {
            return -1L;
        }
        return Z(i);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void a(cy cyVar) {
        cy cyVarK = K(cyVar);
        this.z = false;
        this.A = cyVar;
        boolean zO = O(cyVarK);
        uz uzVar = this.f;
        if (uzVar == null || !zO) {
            return;
        }
        uzVar.K();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    @Override // com.google.ads.interactivemedia.v3.internal.kr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(long r12, int r14, int r15, int r16, com.google.ads.interactivemedia.v3.internal.kq r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.z
            if (r0 == 0) goto Ld
            com.google.ads.interactivemedia.v3.internal.cy r0 = r8.A
            com.google.ads.interactivemedia.v3.internal.ary.s(r0)
            r11.a(r0)
        Ld:
            r0 = r14 & 1
            boolean r1 = r8.x
            r2 = 0
            if (r1 == 0) goto L19
            if (r0 != 0) goto L17
            return
        L17:
            r8.x = r2
        L19:
            long r3 = r8.G
            long r3 = r3 + r12
            boolean r1 = r8.E
            if (r1 == 0) goto L56
            long r5 = r8.t
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L27
            return
        L27:
            if (r0 != 0) goto L56
            boolean r1 = r8.F
            if (r1 != 0) goto L52
            com.google.ads.interactivemedia.v3.internal.cy r1 = r8.B
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r5 = r1.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r5 = r5 + 50
            r6.<init>(r5)
            java.lang.String r5 = "Overriding unexpected non-sync sample for format: "
            r6.append(r5)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            java.lang.String r5 = "SampleQueue"
            android.util.Log.w(r5, r1)
            r1 = 1
            r8.F = r1
        L52:
            r1 = r14 | 1
            r5 = r1
            goto L57
        L56:
            r5 = r14
        L57:
            boolean r1 = r8.H
            if (r1 == 0) goto L68
            if (r0 == 0) goto L67
            boolean r0 = r11.T(r3)
            if (r0 != 0) goto L64
            goto L67
        L64:
            r8.H = r2
            goto L68
        L67:
            return
        L68:
            com.google.ads.interactivemedia.v3.internal.ux r0 = r8.a
            long r0 = r0.f()
            r6 = r15
            long r9 = (long) r6
            long r0 = r0 - r9
            r2 = r16
            long r9 = (long) r2
            long r9 = r0 - r9
            r0 = r11
            r1 = r3
            r3 = r5
            r4 = r9
            r7 = r17
            r0.S(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.va.b(long, int, int, int, com.google.ads.interactivemedia.v3.internal.kq):void");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final int c(abu abuVar, int i, boolean z) throws IOException {
        return atv.q(this, abuVar, i, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void d(aee aeeVar, int i) {
        atv.r(this, aeeVar, i);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final int e(abu abuVar, int i, boolean z) throws IOException {
        return this.a.g(abuVar, i, z);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.kr
    public final void f(aee aeeVar, int i) {
        this.a.h(aeeVar, i);
    }

    public final void g() {
        i(true);
        R();
    }

    public final void h() {
        i(false);
    }

    public final void i(boolean z) {
        this.a.a();
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.x = true;
        this.t = Long.MIN_VALUE;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = false;
        this.C = null;
        if (z) {
            this.A = null;
            this.B = null;
            this.y = true;
        }
    }

    public final void j(long j) {
        this.t = j;
    }

    public final void k(int i) {
        this.D = i;
    }

    public final void l() {
        this.H = true;
    }

    public final int m() {
        return this.q + this.p;
    }

    public final void n(int i) {
        this.a.b(U(i));
    }

    public final void o() {
        G();
        R();
    }

    public final void p() throws IOException {
        ji jiVar = this.I;
        if (jiVar == null) {
            return;
        }
        jd jdVarA = jiVar.a();
        ary.t(jdVarA);
        throw jdVarA;
    }

    public final int q() {
        return this.q;
    }

    public final int r() {
        return this.q + this.s;
    }

    public final synchronized int s() {
        return V() ? this.i[ab(this.s)] : this.D;
    }

    public final synchronized cy t() {
        if (this.y) {
            return null;
        }
        return this.B;
    }

    public final synchronized long u() {
        return this.v;
    }

    public final synchronized long v() {
        return Math.max(this.u, aa(this.s));
    }

    public final synchronized boolean w() {
        return this.w;
    }

    public final synchronized long x() {
        if (this.p == 0) {
            return Long.MIN_VALUE;
        }
        return this.m[this.r];
    }

    public final synchronized boolean y(boolean z) {
        boolean z2 = true;
        if (V()) {
            int iAb = ab(this.s);
            if (this.o[iAb] != this.g) {
                return true;
            }
            return X(iAb);
        }
        if (!z && !this.w) {
            cy cyVar = this.B;
            if (cyVar == null) {
                z2 = false;
            } else if (cyVar == this.g) {
                return false;
            }
        }
        return z2;
    }

    public final int z(cz czVar, iw iwVar, boolean z, boolean z2) {
        int iN = N(czVar, iwVar, z, z2, this.b);
        if (iN != -4) {
            return iN;
        }
        if (iwVar.c() || iwVar.j()) {
            return -4;
        }
        this.a.d(iwVar, this.b);
        return -4;
    }
}
