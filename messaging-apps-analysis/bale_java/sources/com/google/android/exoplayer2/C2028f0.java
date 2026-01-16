package com.google.android.exoplayer2;

import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC7218Qt7;
import ir.nasim.C7452Rt7;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC23757xT2;
import ir.nasim.InterfaceC24899zO5;
import ir.nasim.InterfaceC3582Bm;

/* renamed from: com.google.android.exoplayer2.f0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C2028f0 {
    private final J0.b a = new J0.b();
    private final J0.d b = new J0.d();
    private final InterfaceC3582Bm c;
    private final InterfaceC23757xT2 d;
    private long e;
    private int f;
    private boolean g;
    private C2022c0 h;
    private C2022c0 i;
    private C2022c0 j;
    private int k;
    private Object l;
    private long m;

    public C2028f0(InterfaceC3582Bm interfaceC3582Bm, InterfaceC23757xT2 interfaceC23757xT2) {
        this.c = interfaceC3582Bm;
        this.d = interfaceC23757xT2;
    }

    private static MediaSource.MediaPeriodId A(J0 j0, Object obj, long j, long j2, J0.d dVar, J0.b bVar) {
        j0.m(obj, bVar);
        j0.s(bVar.c, dVar);
        int iG = j0.g(obj);
        Object objE = obj;
        while (bVar.d == 0 && bVar.g() > 0 && bVar.u(bVar.s()) && bVar.i(0L) == -1) {
            int i = iG + 1;
            if (iG >= dVar.p) {
                break;
            }
            j0.l(i, bVar, true);
            objE = AbstractC20011rK.e(bVar.b);
            iG = i;
        }
        j0.m(objE, bVar);
        int i2 = bVar.i(j);
        return i2 == -1 ? new MediaSource.MediaPeriodId(objE, j2, bVar.h(j)) : new MediaSource.MediaPeriodId(objE, i2, bVar.o(i2), j2);
    }

    private long C(J0 j0, Object obj) {
        int iG;
        int i = j0.m(obj, this.a).c;
        Object obj2 = this.l;
        if (obj2 != null && (iG = j0.g(obj2)) != -1 && j0.k(iG, this.a).c == i) {
            return this.m;
        }
        for (C2022c0 c2022c0J = this.h; c2022c0J != null; c2022c0J = c2022c0J.j()) {
            if (c2022c0J.b.equals(obj)) {
                return c2022c0J.f.a.d;
            }
        }
        for (C2022c0 c2022c0J2 = this.h; c2022c0J2 != null; c2022c0J2 = c2022c0J2.j()) {
            int iG2 = j0.g(c2022c0J2.b);
            if (iG2 != -1 && j0.k(iG2, this.a).c == i) {
                return c2022c0J2.f.a.d;
            }
        }
        long j = this.e;
        this.e = 1 + j;
        if (this.h == null) {
            this.l = obj;
            this.m = j;
        }
        return j;
    }

    private boolean E(J0 j0) {
        C2022c0 c2022c0J = this.h;
        if (c2022c0J == null) {
            return true;
        }
        int iG = j0.g(c2022c0J.b);
        while (true) {
            iG = j0.i(iG, this.a, this.b, this.f, this.g);
            while (c2022c0J.j() != null && !c2022c0J.f.g) {
                c2022c0J = c2022c0J.j();
            }
            C2022c0 c2022c0J2 = c2022c0J.j();
            if (iG == -1 || c2022c0J2 == null || j0.g(c2022c0J2.b) != iG) {
                break;
            }
            c2022c0J = c2022c0J2;
        }
        boolean z = z(c2022c0J);
        c2022c0J.f = r(j0, c2022c0J.f);
        return !z;
    }

    private boolean d(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    private boolean e(C2024d0 c2024d0, C2024d0 c2024d02) {
        return c2024d0.b == c2024d02.b && c2024d0.a.equals(c2024d02.a);
    }

    private C2024d0 h(x0 x0Var) {
        return k(x0Var.a, x0Var.b, x0Var.c, x0Var.r);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2.C2024d0 i(com.google.android.exoplayer2.J0 r20, com.google.android.exoplayer2.C2022c0 r21, long r22) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.C2028f0.i(com.google.android.exoplayer2.J0, com.google.android.exoplayer2.c0, long):com.google.android.exoplayer2.d0");
    }

    private C2024d0 k(J0 j0, MediaSource.MediaPeriodId mediaPeriodId, long j, long j2) {
        j0.m(mediaPeriodId.a, this.a);
        return mediaPeriodId.c() ? l(j0, mediaPeriodId.a, mediaPeriodId.b, mediaPeriodId.c, j, mediaPeriodId.d) : m(j0, mediaPeriodId.a, j2, j, mediaPeriodId.d);
    }

    private C2024d0 l(J0 j0, Object obj, int i, int i2, long j, long j2) {
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i, i2, j2);
        long jF = j0.m(mediaPeriodId.a, this.a).f(mediaPeriodId.b, mediaPeriodId.c);
        long jK = i2 == this.a.o(i) ? this.a.k() : 0L;
        return new C2024d0(mediaPeriodId, (jF == -9223372036854775807L || jK < jF) ? jK : Math.max(0L, jF - 1), j, -9223372036854775807L, jF, this.a.u(mediaPeriodId.b), false, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2.C2024d0 m(com.google.android.exoplayer2.J0 r25, java.lang.Object r26, long r27, long r29, long r31) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            com.google.android.exoplayer2.J0$b r5 = r0.a
            r1.m(r2, r5)
            com.google.android.exoplayer2.J0$b r5 = r0.a
            int r5 = r5.h(r3)
            r6 = 1
            r7 = 0
            r8 = -1
            if (r5 != r8) goto L2e
            com.google.android.exoplayer2.J0$b r9 = r0.a
            int r9 = r9.g()
            if (r9 <= 0) goto L4d
            com.google.android.exoplayer2.J0$b r9 = r0.a
            int r10 = r9.s()
            boolean r9 = r9.u(r10)
            if (r9 == 0) goto L4d
            r9 = r6
            goto L4e
        L2e:
            com.google.android.exoplayer2.J0$b r9 = r0.a
            boolean r9 = r9.u(r5)
            if (r9 == 0) goto L4d
            com.google.android.exoplayer2.J0$b r9 = r0.a
            long r9 = r9.j(r5)
            com.google.android.exoplayer2.J0$b r11 = r0.a
            long r12 = r11.d
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L4d
            boolean r9 = r11.t(r5)
            if (r9 == 0) goto L4d
            r9 = r6
            r5 = r8
            goto L4e
        L4d:
            r9 = r7
        L4e:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r11 = new com.google.android.exoplayer2.source.MediaSource$MediaPeriodId
            r12 = r31
            r11.<init>(r2, r12, r5)
            boolean r2 = r0.s(r11)
            boolean r22 = r0.u(r1, r11)
            boolean r23 = r0.t(r1, r11, r2)
            if (r5 == r8) goto L6e
            com.google.android.exoplayer2.J0$b r1 = r0.a
            boolean r1 = r1.u(r5)
            if (r1 == 0) goto L6e
            r20 = r6
            goto L70
        L6e:
            r20 = r7
        L70:
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == r8) goto L80
            com.google.android.exoplayer2.J0$b r1 = r0.a
            long r14 = r1.j(r5)
        L7d:
            r16 = r14
            goto L89
        L80:
            if (r9 == 0) goto L87
            com.google.android.exoplayer2.J0$b r1 = r0.a
            long r14 = r1.d
            goto L7d
        L87:
            r16 = r12
        L89:
            int r1 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r1 == 0) goto L97
            r14 = -9223372036854775808
            int r1 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r1 != 0) goto L94
            goto L97
        L94:
            r18 = r16
            goto L9d
        L97:
            com.google.android.exoplayer2.J0$b r1 = r0.a
            long r14 = r1.d
            r18 = r14
        L9d:
            int r1 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r1 == 0) goto Lb4
            int r1 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r1 < 0) goto Lb4
            if (r23 != 0) goto Lab
            if (r9 != 0) goto Laa
            goto Lab
        Laa:
            r6 = r7
        Lab:
            long r3 = (long) r6
            long r3 = r18 - r3
            r5 = 0
            long r3 = java.lang.Math.max(r5, r3)
        Lb4:
            r12 = r3
            com.google.android.exoplayer2.d0 r1 = new com.google.android.exoplayer2.d0
            r10 = r1
            r14 = r29
            r21 = r2
            r10.<init>(r11, r12, r14, r16, r18, r20, r21, r22, r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.C2028f0.m(com.google.android.exoplayer2.J0, java.lang.Object, long, long, long):com.google.android.exoplayer2.d0");
    }

    private long n(J0 j0, Object obj, int i) {
        j0.m(obj, this.a);
        long j = this.a.j(i);
        return j == Long.MIN_VALUE ? this.a.d : j + this.a.m(i);
    }

    private boolean s(MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.c() && mediaPeriodId.e == -1;
    }

    private boolean t(J0 j0, MediaSource.MediaPeriodId mediaPeriodId, boolean z) {
        int iG = j0.g(mediaPeriodId.a);
        return !j0.s(j0.k(iG, this.a).c, this.b).i && j0.w(iG, this.a, this.b, this.f, this.g) && z;
    }

    private boolean u(J0 j0, MediaSource.MediaPeriodId mediaPeriodId) {
        if (s(mediaPeriodId)) {
            return j0.s(j0.m(mediaPeriodId.a, this.a).c, this.b).p == j0.g(mediaPeriodId.a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(AbstractC12710f43.a aVar, MediaSource.MediaPeriodId mediaPeriodId) {
        this.c.V3(aVar.h(), mediaPeriodId);
    }

    private void x() {
        final AbstractC12710f43.a aVarL = AbstractC12710f43.L();
        for (C2022c0 c2022c0J = this.h; c2022c0J != null; c2022c0J = c2022c0J.j()) {
            aVarL.a(c2022c0J.f.a);
        }
        C2022c0 c2022c0 = this.i;
        final MediaSource.MediaPeriodId mediaPeriodId = c2022c0 == null ? null : c2022c0.f.a;
        this.d.h(new Runnable() { // from class: com.google.android.exoplayer2.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w(aVarL, mediaPeriodId);
            }
        });
    }

    public MediaSource.MediaPeriodId B(J0 j0, Object obj, long j) {
        long jC = C(j0, obj);
        j0.m(obj, this.a);
        j0.s(this.a.c, this.b);
        boolean z = false;
        for (int iG = j0.g(obj); iG >= this.b.o; iG--) {
            j0.l(iG, this.a, true);
            boolean z2 = this.a.g() > 0;
            z |= z2;
            J0.b bVar = this.a;
            if (bVar.i(bVar.d) != -1) {
                obj = AbstractC20011rK.e(this.a.b);
            }
            if (z && (!z2 || this.a.d != 0)) {
                break;
            }
        }
        return A(j0, obj, j, jC, this.b, this.a);
    }

    public boolean D() {
        C2022c0 c2022c0 = this.j;
        return c2022c0 == null || (!c2022c0.f.i && c2022c0.q() && this.j.f.e != -9223372036854775807L && this.k < 100);
    }

    public boolean F(J0 j0, long j, long j2) {
        C2024d0 c2024d0R;
        C2022c0 c2022c0J = this.h;
        C2022c0 c2022c0 = null;
        while (c2022c0J != null) {
            C2024d0 c2024d0 = c2022c0J.f;
            if (c2022c0 == null) {
                c2024d0R = r(j0, c2024d0);
            } else {
                C2024d0 c2024d0I = i(j0, c2022c0, j);
                if (c2024d0I == null) {
                    return !z(c2022c0);
                }
                if (!e(c2024d0, c2024d0I)) {
                    return !z(c2022c0);
                }
                c2024d0R = c2024d0I;
            }
            c2022c0J.f = c2024d0R.a(c2024d0.c);
            if (!d(c2024d0.e, c2024d0R.e)) {
                c2022c0J.A();
                long j3 = c2024d0R.e;
                return (z(c2022c0J) || (c2022c0J == this.i && !c2022c0J.f.f && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((j3 > (-9223372036854775807L) ? 1 : (j3 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : c2022c0J.z(j3)) ? 1 : (j2 == ((j3 > (-9223372036854775807L) ? 1 : (j3 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : c2022c0J.z(j3)) ? 0 : -1)) >= 0))) ? false : true;
            }
            c2022c0 = c2022c0J;
            c2022c0J = c2022c0J.j();
        }
        return true;
    }

    public boolean G(J0 j0, int i) {
        this.f = i;
        return E(j0);
    }

    public boolean H(J0 j0, boolean z) {
        this.g = z;
        return E(j0);
    }

    public C2022c0 b() {
        C2022c0 c2022c0 = this.h;
        if (c2022c0 == null) {
            return null;
        }
        if (c2022c0 == this.i) {
            this.i = c2022c0.j();
        }
        this.h.t();
        int i = this.k - 1;
        this.k = i;
        if (i == 0) {
            this.j = null;
            C2022c0 c2022c02 = this.h;
            this.l = c2022c02.b;
            this.m = c2022c02.f.a.d;
        }
        this.h = this.h.j();
        x();
        return this.h;
    }

    public C2022c0 c() {
        C2022c0 c2022c0 = this.i;
        AbstractC20011rK.g((c2022c0 == null || c2022c0.j() == null) ? false : true);
        this.i = this.i.j();
        x();
        return this.i;
    }

    public void f() {
        if (this.k == 0) {
            return;
        }
        C2022c0 c2022c0J = (C2022c0) AbstractC20011rK.i(this.h);
        this.l = c2022c0J.b;
        this.m = c2022c0J.f.a.d;
        while (c2022c0J != null) {
            c2022c0J.t();
            c2022c0J = c2022c0J.j();
        }
        this.h = null;
        this.j = null;
        this.i = null;
        this.k = 0;
        x();
    }

    public C2022c0 g(InterfaceC24899zO5[] interfaceC24899zO5Arr, AbstractC7218Qt7 abstractC7218Qt7, InterfaceC19684qm interfaceC19684qm, u0 u0Var, C2024d0 c2024d0, C7452Rt7 c7452Rt7) {
        C2022c0 c2022c0 = this.j;
        C2022c0 c2022c02 = new C2022c0(interfaceC24899zO5Arr, c2022c0 == null ? 1000000000000L : (c2022c0.l() + this.j.f.e) - c2024d0.b, abstractC7218Qt7, interfaceC19684qm, u0Var, c2024d0, c7452Rt7);
        C2022c0 c2022c03 = this.j;
        if (c2022c03 != null) {
            c2022c03.w(c2022c02);
        } else {
            this.h = c2022c02;
            this.i = c2022c02;
        }
        this.l = null;
        this.j = c2022c02;
        this.k++;
        x();
        return c2022c02;
    }

    public C2022c0 j() {
        return this.j;
    }

    public C2024d0 o(long j, x0 x0Var) {
        C2022c0 c2022c0 = this.j;
        return c2022c0 == null ? h(x0Var) : i(x0Var.a, c2022c0, j);
    }

    public C2022c0 p() {
        return this.h;
    }

    public C2022c0 q() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.C2024d0 r(com.google.android.exoplayer2.J0 r19, com.google.android.exoplayer2.C2024d0 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r2.a
            boolean r12 = r0.s(r3)
            boolean r13 = r0.u(r1, r3)
            boolean r14 = r0.t(r1, r3, r12)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r4 = r2.a
            java.lang.Object r4 = r4.a
            com.google.android.exoplayer2.J0$b r5 = r0.a
            r1.m(r4, r5)
            boolean r1 = r3.c()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = -1
            if (r1 != 0) goto L35
            int r1 = r3.e
            if (r1 != r6) goto L2e
            goto L35
        L2e:
            com.google.android.exoplayer2.J0$b r7 = r0.a
            long r7 = r7.j(r1)
            goto L36
        L35:
            r7 = r4
        L36:
            boolean r1 = r3.c()
            if (r1 == 0) goto L48
            com.google.android.exoplayer2.J0$b r1 = r0.a
            int r4 = r3.b
            int r5 = r3.c
            long r4 = r1.f(r4, r5)
        L46:
            r9 = r4
            goto L5c
        L48:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 == 0) goto L55
            r4 = -9223372036854775808
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 != 0) goto L53
            goto L55
        L53:
            r9 = r7
            goto L5c
        L55:
            com.google.android.exoplayer2.J0$b r1 = r0.a
            long r4 = r1.n()
            goto L46
        L5c:
            boolean r1 = r3.c()
            if (r1 == 0) goto L6c
            com.google.android.exoplayer2.J0$b r1 = r0.a
            int r4 = r3.b
            boolean r1 = r1.u(r4)
        L6a:
            r11 = r1
            goto L7c
        L6c:
            int r1 = r3.e
            if (r1 == r6) goto L7a
            com.google.android.exoplayer2.J0$b r4 = r0.a
            boolean r1 = r4.u(r1)
            if (r1 == 0) goto L7a
            r1 = 1
            goto L6a
        L7a:
            r1 = 0
            goto L6a
        L7c:
            com.google.android.exoplayer2.d0 r15 = new com.google.android.exoplayer2.d0
            long r4 = r2.b
            long r1 = r2.c
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.C2028f0.r(com.google.android.exoplayer2.J0, com.google.android.exoplayer2.d0):com.google.android.exoplayer2.d0");
    }

    public boolean v(MediaPeriod mediaPeriod) {
        C2022c0 c2022c0 = this.j;
        return c2022c0 != null && c2022c0.a == mediaPeriod;
    }

    public void y(long j) {
        C2022c0 c2022c0 = this.j;
        if (c2022c0 != null) {
            c2022c0.s(j);
        }
    }

    public boolean z(C2022c0 c2022c0) {
        boolean z = false;
        AbstractC20011rK.g(c2022c0 != null);
        if (c2022c0.equals(this.j)) {
            return false;
        }
        this.j = c2022c0;
        while (c2022c0.j() != null) {
            c2022c0 = c2022c0.j();
            if (c2022c0 == this.i) {
                this.i = this.h;
                z = true;
            }
            c2022c0.t();
            this.k--;
        }
        this.j.w(null);
        x();
        return z;
    }
}
