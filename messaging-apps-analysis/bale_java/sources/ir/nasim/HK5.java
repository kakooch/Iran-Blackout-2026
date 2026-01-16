package ir.nasim;

import android.os.Trace;

/* loaded from: classes2.dex */
public final class HK5 {
    private final AbstractC20768sa3 a;
    private boolean e;
    private boolean f;
    private boolean g;
    private Object h;
    private final GK5 b = new GK5();
    private final C18540op7 c = new C18540op7();
    private final C3587Bm4 d = new C3587Bm4(0, 1, null);
    private long i = -1;
    private final SA2 j = new a();
    private final C6908Pm4 k = new C6908Pm4(0.0f, 0.0f, 0.0f, 0.0f);

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final void a() {
            HK5.this.h = null;
            HK5 hk5 = HK5.this;
            Trace.beginSection("OnPositionedDispatch");
            try {
                hk5.c();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } finally {
                Trace.endSection();
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public HK5(AbstractC20768sa3 abstractC20768sa3) {
        this.a = abstractC20768sa3;
    }

    private final void b(XA4 xa4, C6908Pm4 c6908Pm4) {
        while (xa4 != null) {
            InterfaceC23124wO4 interfaceC23124wO4D2 = xa4.D2();
            long jF1 = xa4.F1();
            float fK = C22045ua3.k(jF1);
            float fL = C22045ua3.l(jF1);
            c6908Pm4.m(ZG4.e((Float.floatToRawIntBits(fK) << 32) | (Float.floatToRawIntBits(fL) & 4294967295L)));
            xa4 = xa4.L2();
            if (interfaceC23124wO4D2 != null) {
                float[] fArrMo2getUnderlyingMatrixsQKQjiQ = interfaceC23124wO4D2.mo2getUnderlyingMatrixsQKQjiQ();
                if (!EV3.a(fArrMo2getUnderlyingMatrixsQKQjiQ)) {
                    AV3.g(fArrMo2getUnderlyingMatrixsQKQjiQ, c6908Pm4);
                }
            }
        }
    }

    private final void e(C3419Au3 c3419Au3, boolean z, int i, int i2, int i3, int i4) {
        int iD = c3419Au3.d();
        if (z || !this.b.g(iD, i, i2, i3, i4)) {
            C3419Au3 c3419Au3A0 = c3419Au3.A0();
            this.b.d(iD, i, i2, i3, i4, (192 & 32) != 0 ? -1 : c3419Au3A0 != null ? c3419Au3A0.d() : -1, (192 & 64) != 0 ? false : false, (192 & 128) != 0 ? false : false);
        }
        h();
    }

    private final void f(C3419Au3 c3419Au3, long j, boolean z) {
        XA4 xa4W0 = c3419Au3.w0();
        C10354bW3 c10354bW3M0 = c3419Au3.m0();
        int iN0 = c10354bW3M0.N0();
        int iF0 = c10354bW3M0.F0();
        C6908Pm4 c6908Pm4 = this.k;
        c6908Pm4.g(C22045ua3.k(j), C22045ua3.l(j), C22045ua3.k(j) + iN0, C22045ua3.l(j) + iF0);
        b(xa4W0, c6908Pm4);
        int iB = (int) c6908Pm4.b();
        int iD = (int) c6908Pm4.d();
        int iC = (int) c6908Pm4.c();
        int iA = (int) c6908Pm4.a();
        int iD2 = c3419Au3.d();
        if (z || !this.b.j(iD2, iB, iD, iC, iA)) {
            C3419Au3 c3419Au3A0 = c3419Au3.A0();
            this.b.d(iD2, iB, iD, iC, iA, (192 & 32) != 0 ? -1 : c3419Au3A0 != null ? c3419Au3A0.d() : -1, (192 & 64) != 0 ? false : false, (192 & 128) != 0 ? false : false);
        }
        h();
    }

    private final void g(C3419Au3 c3419Au3) {
        C12544en4 c12544en4G0 = c3419Au3.G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au32 = (C3419Au3) objArr[i];
            f(c3419Au32, c3419Au32.w0().F1(), false);
            g(c3419Au32);
        }
    }

    private final long l(C3419Au3 c3419Au3) {
        XA4 xa4W0 = c3419Au3.w0();
        long jC = ZG4.b.c();
        XA4 xa4Y = c3419Au3.Y();
        while (xa4Y != null && xa4Y != xa4W0) {
            InterfaceC23124wO4 interfaceC23124wO4D2 = xa4Y.D2();
            jC = AbstractC22635va3.c(jC, xa4Y.F1());
            xa4Y = xa4Y.L2();
            if (interfaceC23124wO4D2 != null) {
                float[] fArrMo2getUnderlyingMatrixsQKQjiQ = interfaceC23124wO4D2.mo2getUnderlyingMatrixsQKQjiQ();
                int iC = IK5.c(fArrMo2getUnderlyingMatrixsQKQjiQ);
                if (iC == 3) {
                    continue;
                } else {
                    if ((iC & 2) == 0) {
                        return C22045ua3.b.a();
                    }
                    jC = AV3.f(fArrMo2getUnderlyingMatrixsQKQjiQ, jC);
                }
            }
        }
        return AbstractC22635va3.d(jC);
    }

    private final long m(XA4 xa4) {
        long jC = ZG4.b.c();
        while (xa4 != null) {
            InterfaceC23124wO4 interfaceC23124wO4D2 = xa4.D2();
            jC = AbstractC22635va3.c(jC, xa4.F1());
            xa4 = xa4.L2();
            if (interfaceC23124wO4D2 != null) {
                float[] fArrMo2getUnderlyingMatrixsQKQjiQ = interfaceC23124wO4D2.mo2getUnderlyingMatrixsQKQjiQ();
                int iC = IK5.c(fArrMo2getUnderlyingMatrixsQKQjiQ);
                if (iC == 3) {
                    continue;
                } else {
                    if ((iC & 2) == 0) {
                        return C22045ua3.b.a();
                    }
                    jC = AV3.f(fArrMo2getUnderlyingMatrixsQKQjiQ, jC);
                }
            }
        }
        return AbstractC22635va3.d(jC);
    }

    public final void c() {
        int i;
        long jB = AbstractC15163j7.b();
        boolean z = this.e;
        boolean z2 = z || this.f;
        if (z) {
            this.e = false;
            C3587Bm4 c3587Bm4 = this.d;
            Object[] objArr = c3587Bm4.a;
            int i2 = c3587Bm4.b;
            for (int i3 = 0; i3 < i2; i3++) {
                ((SA2) objArr[i3]).invoke();
            }
            GK5 gk5 = this.b;
            long[] jArr = gk5.a;
            int i4 = gk5.c;
            int i5 = 0;
            while (i5 < jArr.length - 2 && i5 < i4) {
                long j = jArr[i5 + 2];
                if ((((int) (j >> 61)) & 1) != 0) {
                    i = i5;
                    this.c.c(67108863 & ((int) j), jArr[i5], jArr[i5 + 1], jB);
                } else {
                    i = i5;
                }
                i5 = i + 3;
            }
            this.b.a();
        }
        if (this.f) {
            this.f = false;
            this.c.b(jB);
        }
        if (z2) {
            this.c.a(jB);
        }
        if (this.g) {
            this.g = false;
            this.b.b();
        }
        this.c.e(jB);
    }

    public final GK5 d() {
        return this.b;
    }

    public final void h() {
        this.e = true;
    }

    public final void i(C3419Au3 c3419Au3) {
        this.e = true;
        this.b.f(c3419Au3.d());
        o(true);
    }

    public final void j(C3419Au3 c3419Au3) {
        if (C15439jb1.b) {
            long jL = l(c3419Au3);
            if (!IK5.d(jL)) {
                g(c3419Au3);
                return;
            }
            c3419Au3.U1(jL);
            c3419Au3.V1(false);
            C12544en4 c12544en4G0 = c3419Au3.G0();
            Object[] objArr = c12544en4G0.a;
            int iO = c12544en4G0.o();
            for (int i = 0; i < iO; i++) {
                C3419Au3 c3419Au32 = (C3419Au3) objArr[i];
                k(c3419Au32, c3419Au32.w0().F1(), false);
            }
            i(c3419Au3);
        }
    }

    public final void k(C3419Au3 c3419Au3, long j, boolean z) {
        long jM;
        long jL;
        if (C15439jb1.b) {
            C10354bW3 c10354bW3M0 = c3419Au3.m0();
            int iN0 = c10354bW3M0.N0();
            int iF0 = c10354bW3M0.F0();
            C3419Au3 c3419Au3A0 = c3419Au3.A0();
            long jU0 = c3419Au3.u0();
            long jD0 = c3419Au3.d0();
            int i = (int) (jD0 >> 32);
            int i2 = (int) (jD0 & 4294967295L);
            boolean z2 = false;
            if (c3419Au3A0 != null) {
                boolean zY0 = c3419Au3A0.y0();
                long jU02 = c3419Au3A0.u0();
                long jX0 = c3419Au3A0.x0();
                if (IK5.d(jU02)) {
                    if (zY0) {
                        jL = l(c3419Au3A0);
                        c3419Au3A0.U1(jL);
                        c3419Au3A0.V1(false);
                    } else {
                        jL = jX0;
                    }
                    z2 = !IK5.d(jL);
                    jM = C22045ua3.o(C22045ua3.o(jU02, jL), j);
                } else {
                    jM = m(c3419Au3.w0());
                }
            } else {
                jM = j;
            }
            if (z2 || !IK5.d(jM)) {
                f(c3419Au3, j, z);
                return;
            }
            c3419Au3.R1(jM);
            c3419Au3.O1(C4414Fa3.c((iF0 & 4294967295L) | (iN0 << 32)));
            int iK = C22045ua3.k(jM);
            int iL = C22045ua3.l(jM);
            int i3 = iK + iN0;
            int i4 = iL + iF0;
            if (!z && C22045ua3.j(jM, jU0) && i == iN0 && i2 == iF0) {
                return;
            }
            e(c3419Au3, z, iK, iL, i3, i4);
        }
    }

    public final void n(C3419Au3 c3419Au3) {
        this.b.h(c3419Au3.d());
        h();
        this.g = true;
    }

    public final void o(boolean z) {
        boolean z2 = (z && this.h == null) ? false : true;
        long jD = this.c.d();
        if (jD >= 0 || !z2) {
            if (this.i == jD && z2) {
                return;
            }
            Object obj = this.h;
            if (obj != null) {
                AbstractC15163j7.e(obj);
            }
            long jB = AbstractC15163j7.b();
            long jMax = Math.max(jD, 16 + jB);
            this.i = jMax;
            this.h = AbstractC15163j7.c(jMax - jB, this.j);
        }
    }

    public final void p(long j, long j2, float[] fArr) {
        int iC = IK5.c(fArr);
        C18540op7 c18540op7 = this.c;
        if ((iC & 2) != 0) {
            fArr = null;
        }
        this.f = c18540op7.f(j, j2, fArr) || this.f;
    }
}
