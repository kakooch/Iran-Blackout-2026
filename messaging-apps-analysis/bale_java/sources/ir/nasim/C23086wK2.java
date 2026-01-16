package ir.nasim;

import android.os.Build;
import androidx.compose.ui.graphics.a;
import androidx.compose.ui.platform.AndroidComposeView;
import ir.nasim.AbstractC10274bN4;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.wK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23086wK2 implements InterfaceC23124wO4 {
    private C21226tK2 a;
    private final InterfaceC20014rK2 b;
    private final AndroidComposeView c;
    private InterfaceC14603iB2 d;
    private SA2 e;
    private long f;
    private boolean g;
    private float[] i;
    private boolean j;
    private int n;
    private AbstractC10274bN4 p;
    private boolean q;
    private boolean r;
    private boolean t;
    private final float[] h = AV3.c(null, 1, null);
    private WH1 k = YH1.b(1.0f, 0.0f, 2, null);
    private EnumC12613eu3 l = EnumC12613eu3.a;
    private final C20576sF0 m = new C20576sF0();
    private long o = androidx.compose.ui.graphics.f.b.a();
    private boolean s = true;
    private final UA2 u = new a();

    /* renamed from: ir.nasim.wK2$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            C23086wK2 c23086wK2 = C23086wK2.this;
            UE0 ue0E = interfaceC17460n02.z1().e();
            InterfaceC14603iB2 interfaceC14603iB2 = c23086wK2.d;
            if (interfaceC14603iB2 != null) {
                interfaceC14603iB2.invoke(ue0E, interfaceC17460n02.z1().i());
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    public C23086wK2(C21226tK2 c21226tK2, InterfaceC20014rK2 interfaceC20014rK2, AndroidComposeView androidComposeView, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2) {
        this.a = c21226tK2;
        this.b = interfaceC20014rK2;
        this.c = androidComposeView;
        this.d = interfaceC14603iB2;
        this.e = sa2;
        long j = Integer.MAX_VALUE;
        this.f = C4414Fa3.c((j & 4294967295L) | (j << 32));
    }

    private final float[] m() {
        float[] fArrC = this.i;
        if (fArrC == null) {
            fArrC = AV3.c(null, 1, null);
            this.i = fArrC;
        }
        if (!this.r) {
            if (Float.isNaN(fArrC[0])) {
                return null;
            }
            return fArrC;
        }
        this.r = false;
        float[] fArrN = n();
        if (this.s) {
            return fArrN;
        }
        if (AbstractC13670gd3.a(fArrN, fArrC)) {
            return fArrC;
        }
        fArrC[0] = Float.NaN;
        return null;
    }

    private final float[] n() {
        q();
        return this.h;
    }

    private final void o(boolean z) {
        if (z != this.j) {
            this.j = z;
            this.c.H0(this, z);
        }
    }

    private final void p() {
        if (Build.VERSION.SDK_INT >= 26) {
            Cb8.a.a(this.c);
        } else {
            this.c.invalidate();
        }
    }

    private final void q() {
        if (this.q) {
            C21226tK2 c21226tK2 = this.a;
            long jB = (c21226tK2.p() & 9223372034707292159L) == 9205357640488583168L ? UD6.b(AbstractC4663Ga3.d(this.f)) : c21226tK2.p();
            AV3.i(this.h, Float.intBitsToFloat((int) (jB >> 32)), Float.intBitsToFloat((int) (jB & 4294967295L)), c21226tK2.y(), c21226tK2.z(), 1.0f, c21226tK2.q(), c21226tK2.r(), c21226tK2.s(), c21226tK2.t(), c21226tK2.u(), 1.0f);
            this.q = false;
            this.s = EV3.a(this.h);
        }
    }

    private final void r() {
        SA2 sa2;
        AbstractC10274bN4 abstractC10274bN4 = this.p;
        if (abstractC10274bN4 == null) {
            return;
        }
        AbstractC22490vK2.b(this.a, abstractC10274bN4);
        if (!(abstractC10274bN4 instanceof AbstractC10274bN4.a) || Build.VERSION.SDK_INT >= 33 || (sa2 = this.e) == null) {
            return;
        }
        sa2.invoke();
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void a(float[] fArr) {
        AV3.l(fArr, n());
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void b(InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2) {
        InterfaceC20014rK2 interfaceC20014rK2 = this.b;
        if (interfaceC20014rK2 == null) {
            M73.c("currently reuse is only supported when we manage the layer lifecycle");
            throw new KotlinNothingValueException();
        }
        if (!this.a.A()) {
            M73.a("layer should have been released before reuse");
        }
        this.a = interfaceC20014rK2.a();
        this.g = false;
        this.d = interfaceC14603iB2;
        this.e = sa2;
        this.q = false;
        this.r = false;
        this.s = true;
        AV3.h(this.h);
        float[] fArr = this.i;
        if (fArr != null) {
            AV3.h(fArr);
        }
        this.o = androidx.compose.ui.graphics.f.b.a();
        this.t = false;
        long j = Integer.MAX_VALUE;
        this.f = C4414Fa3.c((j & 4294967295L) | (j << 32));
        this.p = null;
        this.n = 0;
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void c(UE0 ue0, C21226tK2 c21226tK2) {
        k();
        this.t = this.a.v() > 0.0f;
        YZ1 yz1Z1 = this.m.z1();
        yz1Z1.a(ue0);
        yz1Z1.h(c21226tK2);
        AbstractC22490vK2.a(this.m, this.a);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public long d(long j, boolean z) {
        float[] fArrN;
        if (z) {
            fArrN = m();
            if (fArrN == null) {
                return ZG4.b.a();
            }
        } else {
            fArrN = n();
        }
        return this.s ? j : AV3.f(fArrN, j);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void destroy() {
        this.d = null;
        this.e = null;
        this.g = true;
        o(false);
        InterfaceC20014rK2 interfaceC20014rK2 = this.b;
        if (interfaceC20014rK2 != null) {
            interfaceC20014rK2.b(this.a);
            this.c.Q0(this);
        }
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void e(long j) {
        if (C4414Fa3.e(j, this.f)) {
            return;
        }
        this.f = j;
        invalidate();
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void f(C6908Pm4 c6908Pm4, boolean z) {
        float[] fArrM = z ? m() : n();
        if (this.s) {
            return;
        }
        if (fArrM == null) {
            c6908Pm4.g(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            AV3.g(fArrM, c6908Pm4);
        }
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public boolean g(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        if (this.a.l()) {
            return AbstractC13281fx6.c(this.a.o(), fIntBitsToFloat, fIntBitsToFloat2, null, null, 24, null);
        }
        return true;
    }

    @Override // ir.nasim.InterfaceC23124wO4
    /* renamed from: getUnderlyingMatrix-sQKQjiQ */
    public float[] mo2getUnderlyingMatrixsQKQjiQ() {
        return n();
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void h(androidx.compose.ui.graphics.d dVar) {
        int iB;
        SA2 sa2;
        int iZ = dVar.z() | this.n;
        this.l = dVar.u();
        this.k = dVar.t();
        int i = iZ & 4096;
        if (i != 0) {
            this.o = dVar.z0();
        }
        if ((iZ & 1) != 0) {
            this.a.Y(dVar.A());
        }
        if ((iZ & 2) != 0) {
            this.a.Z(dVar.K());
        }
        if ((iZ & 4) != 0) {
            this.a.K(dVar.b());
        }
        if ((iZ & 8) != 0) {
            this.a.e0(dVar.H());
        }
        if ((iZ & 16) != 0) {
            this.a.f0(dVar.G());
        }
        if ((iZ & 32) != 0) {
            this.a.a0(dVar.F());
            if (dVar.F() > 0.0f && !this.t && (sa2 = this.e) != null) {
                sa2.invoke();
            }
        }
        if ((iZ & 64) != 0) {
            this.a.L(dVar.h());
        }
        if ((iZ & 128) != 0) {
            this.a.c0(dVar.M());
        }
        if ((iZ & 1024) != 0) {
            this.a.W(dVar.s());
        }
        if ((iZ & 256) != 0) {
            this.a.U(dVar.I());
        }
        if ((iZ & 512) != 0) {
            this.a.V(dVar.r());
        }
        if ((iZ & 2048) != 0) {
            this.a.M(dVar.w());
        }
        if (i != 0) {
            if (androidx.compose.ui.graphics.f.e(this.o, androidx.compose.ui.graphics.f.b.a())) {
                this.a.Q(ZG4.b.b());
            } else {
                C21226tK2 c21226tK2 = this.a;
                float f = androidx.compose.ui.graphics.f.f(this.o) * ((int) (this.f >> 32));
                c21226tK2.Q(ZG4.e((Float.floatToRawIntBits(androidx.compose.ui.graphics.f.g(this.o) * ((int) (this.f & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
            }
        }
        if ((iZ & 16384) != 0) {
            this.a.N(dVar.o());
        }
        if ((131072 & iZ) != 0) {
            C21226tK2 c21226tK22 = this.a;
            dVar.E();
            c21226tK22.T(null);
        }
        if ((32768 & iZ) != 0) {
            C21226tK2 c21226tK23 = this.a;
            int iP = dVar.p();
            a.C0063a c0063a = androidx.compose.ui.graphics.a.a;
            if (androidx.compose.ui.graphics.a.e(iP, c0063a.a())) {
                iB = AbstractC6567Ob1.a.a();
            } else if (androidx.compose.ui.graphics.a.e(iP, c0063a.c())) {
                iB = AbstractC6567Ob1.a.c();
            } else {
                if (!androidx.compose.ui.graphics.a.e(iP, c0063a.b())) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
                iB = AbstractC6567Ob1.a.b();
            }
            c21226tK23.O(iB);
        }
        boolean z = true;
        if ((iZ & 7963) != 0) {
            this.q = true;
            this.r = true;
        }
        if (AbstractC13042fc3.d(this.p, dVar.C())) {
            z = false;
        } else {
            this.p = dVar.C();
            r();
        }
        this.n = dVar.z();
        if (iZ != 0 || z) {
            p();
        }
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void i(float[] fArr) {
        float[] fArrM = m();
        if (fArrM != null) {
            AV3.l(fArr, fArrM);
        }
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void invalidate() {
        if (this.j || this.g) {
            return;
        }
        this.c.invalidate();
        o(true);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void j(long j) {
        this.a.d0(j);
        p();
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void k() {
        if (this.j) {
            if (!androidx.compose.ui.graphics.f.e(this.o, androidx.compose.ui.graphics.f.b.a()) && !C4414Fa3.e(this.a.w(), this.f)) {
                C21226tK2 c21226tK2 = this.a;
                float f = androidx.compose.ui.graphics.f.f(this.o) * ((int) (this.f >> 32));
                float fG = androidx.compose.ui.graphics.f.g(this.o) * ((int) (this.f & 4294967295L));
                c21226tK2.Q(ZG4.e((Float.floatToRawIntBits(fG) & 4294967295L) | (Float.floatToRawIntBits(f) << 32)));
            }
            this.a.F(this.k, this.l, this.f, this.u);
            o(false);
        }
    }
}
