package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import androidx.compose.ui.platform.AndroidComposeView;

/* renamed from: ir.nasim.gO5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13534gO5 implements InterfaceC23124wO4 {
    public static final b n = new b(null);
    public static final int o = 8;
    private static final InterfaceC14603iB2 p = a.e;
    private final AndroidComposeView a;
    private InterfaceC14603iB2 b;
    private SA2 c;
    private boolean d;
    private boolean f;
    private boolean g;
    private InterfaceC12969fU4 h;
    private final InterfaceC23085wK1 l;
    private int m;
    private final C11654dN4 e = new C11654dN4();
    private final C7448Rt3 i = new C7448Rt3(p);
    private final C21853uF0 j = new C21853uF0();
    private long k = androidx.compose.ui.graphics.f.b.a();

    /* renamed from: ir.nasim.gO5$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        public final void a(InterfaceC23085wK1 interfaceC23085wK1, Matrix matrix) {
            interfaceC23085wK1.z(matrix);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC23085wK1) obj, (Matrix) obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.gO5$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.gO5$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC14603iB2 interfaceC14603iB2) {
            super(1);
            this.e = interfaceC14603iB2;
        }

        public final void a(UE0 ue0) {
            this.e.invoke(ue0, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((UE0) obj);
            return C19938rB7.a;
        }
    }

    public C13534gO5(AndroidComposeView androidComposeView, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2) {
        this.a = androidComposeView;
        this.b = interfaceC14603iB2;
        this.c = sa2;
        InterfaceC23085wK1 c12307eO5 = Build.VERSION.SDK_INT >= 29 ? new C12307eO5(androidComposeView) : new RN5(androidComposeView);
        c12307eO5.y(true);
        c12307eO5.s(false);
        this.l = c12307eO5;
    }

    private final void l(UE0 ue0) {
        if (this.l.x() || this.l.o()) {
            this.e.a(ue0);
        }
    }

    private final void m(boolean z) {
        if (z != this.d) {
            this.d = z;
            this.a.H0(this, z);
        }
    }

    private final void n() {
        if (Build.VERSION.SDK_INT >= 26) {
            Cb8.a.a(this.a);
        } else {
            this.a.invalidate();
        }
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void a(float[] fArr) {
        AV3.l(fArr, this.i.b(this.l));
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void b(InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2) {
        this.i.h();
        m(false);
        this.f = false;
        this.g = false;
        this.k = androidx.compose.ui.graphics.f.b.a();
        this.b = interfaceC14603iB2;
        this.c = sa2;
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void c(UE0 ue0, C21226tK2 c21226tK2) {
        Canvas canvasD = AbstractC7624Sn.d(ue0);
        if (canvasD.isHardwareAccelerated()) {
            k();
            boolean z = this.l.J() > 0.0f;
            this.g = z;
            if (z) {
                ue0.k();
            }
            this.l.r(canvasD);
            if (this.g) {
                ue0.p();
                return;
            }
            return;
        }
        float fB = this.l.b();
        float fW = this.l.w();
        float fP = this.l.p();
        float fB2 = this.l.B();
        if (this.l.a() < 1.0f) {
            InterfaceC12969fU4 interfaceC12969fU4A = this.h;
            if (interfaceC12969fU4A == null) {
                interfaceC12969fU4A = AbstractC15587jq.a();
                this.h = interfaceC12969fU4A;
            }
            interfaceC12969fU4A.c(this.l.a());
            canvasD.saveLayer(fB, fW, fP, fB2, interfaceC12969fU4A.p());
        } else {
            ue0.n();
        }
        ue0.c(fB, fW);
        ue0.r(this.i.b(this.l));
        l(ue0);
        InterfaceC14603iB2 interfaceC14603iB2 = this.b;
        if (interfaceC14603iB2 != null) {
            interfaceC14603iB2.invoke(ue0, null);
        }
        ue0.i();
        m(false);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public long d(long j, boolean z) {
        return z ? this.i.g(this.l, j) : this.i.e(this.l, j);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void destroy() {
        if (this.l.h()) {
            this.l.d();
        }
        this.b = null;
        this.c = null;
        this.f = true;
        m(false);
        this.a.S0();
        this.a.Q0(this);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void e(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        this.l.C(androidx.compose.ui.graphics.f.f(this.k) * i);
        this.l.D(androidx.compose.ui.graphics.f.g(this.k) * i2);
        InterfaceC23085wK1 interfaceC23085wK1 = this.l;
        if (interfaceC23085wK1.t(interfaceC23085wK1.b(), this.l.w(), this.l.b() + i, this.l.w() + i2)) {
            this.l.E(this.e.b());
            invalidate();
            this.i.c();
        }
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void f(C6908Pm4 c6908Pm4, boolean z) {
        if (z) {
            this.i.f(this.l, c6908Pm4);
        } else {
            this.i.d(this.l, c6908Pm4);
        }
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public boolean g(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & j));
        if (this.l.o()) {
            return 0.0f <= fIntBitsToFloat && fIntBitsToFloat < ((float) this.l.getWidth()) && 0.0f <= fIntBitsToFloat2 && fIntBitsToFloat2 < ((float) this.l.getHeight());
        }
        if (this.l.x()) {
            return this.e.f(j);
        }
        return true;
    }

    @Override // ir.nasim.InterfaceC23124wO4
    /* renamed from: getUnderlyingMatrix-sQKQjiQ */
    public float[] mo2getUnderlyingMatrixsQKQjiQ() {
        return this.i.b(this.l);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void h(androidx.compose.ui.graphics.d dVar) {
        SA2 sa2;
        int iZ = dVar.z() | this.m;
        int i = iZ & 4096;
        if (i != 0) {
            this.k = dVar.z0();
        }
        boolean z = false;
        boolean z2 = this.l.x() && !this.e.e();
        if ((iZ & 1) != 0) {
            this.l.g(dVar.A());
        }
        if ((iZ & 2) != 0) {
            this.l.m(dVar.K());
        }
        if ((iZ & 4) != 0) {
            this.l.c(dVar.b());
        }
        if ((iZ & 8) != 0) {
            this.l.n(dVar.H());
        }
        if ((iZ & 16) != 0) {
            this.l.e(dVar.G());
        }
        if ((iZ & 32) != 0) {
            this.l.u(dVar.F());
        }
        if ((iZ & 64) != 0) {
            this.l.G(DX0.k(dVar.h()));
        }
        if ((iZ & 128) != 0) {
            this.l.I(DX0.k(dVar.M()));
        }
        if ((iZ & 1024) != 0) {
            this.l.l(dVar.s());
        }
        if ((iZ & 256) != 0) {
            this.l.j(dVar.I());
        }
        if ((iZ & 512) != 0) {
            this.l.k(dVar.r());
        }
        if ((iZ & 2048) != 0) {
            this.l.i(dVar.w());
        }
        if (i != 0) {
            this.l.C(androidx.compose.ui.graphics.f.f(this.k) * this.l.getWidth());
            this.l.D(androidx.compose.ui.graphics.f.g(this.k) * this.l.getHeight());
        }
        boolean z3 = dVar.o() && dVar.J() != MK5.a();
        if ((iZ & 24576) != 0) {
            this.l.H(z3);
            this.l.s(dVar.o() && dVar.J() == MK5.a());
        }
        if ((131072 & iZ) != 0) {
            InterfaceC23085wK1 interfaceC23085wK1 = this.l;
            dVar.E();
            interfaceC23085wK1.f(null);
        }
        if ((32768 & iZ) != 0) {
            this.l.q(dVar.p());
        }
        boolean zH = this.e.h(dVar.C(), dVar.b(), z3, dVar.F(), dVar.d());
        if (this.e.c()) {
            this.l.E(this.e.b());
        }
        if (z3 && !this.e.e()) {
            z = true;
        }
        if (z2 != z || (z && zH)) {
            invalidate();
        } else {
            n();
        }
        if (!this.g && this.l.J() > 0.0f && (sa2 = this.c) != null) {
            sa2.invoke();
        }
        if ((iZ & 7963) != 0) {
            this.i.c();
        }
        this.m = dVar.z();
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void i(float[] fArr) {
        float[] fArrA = this.i.a(this.l);
        if (fArrA != null) {
            AV3.l(fArr, fArrA);
        }
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void invalidate() {
        if (this.d || this.f) {
            return;
        }
        this.a.invalidate();
        m(true);
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void j(long j) {
        int iB = this.l.b();
        int iW = this.l.w();
        int iK = C22045ua3.k(j);
        int iL = C22045ua3.l(j);
        if (iB == iK && iW == iL) {
            return;
        }
        if (iB != iK) {
            this.l.A(iK - iB);
        }
        if (iW != iL) {
            this.l.v(iL - iW);
        }
        n();
        this.i.c();
    }

    @Override // ir.nasim.InterfaceC23124wO4
    public void k() {
        if (this.d || !this.l.h()) {
            V05 v05D = (!this.l.x() || this.e.e()) ? null : this.e.d();
            InterfaceC14603iB2 interfaceC14603iB2 = this.b;
            if (interfaceC14603iB2 != null) {
                this.l.F(this.j, v05D, new c(interfaceC14603iB2));
            }
            m(false);
        }
    }
}
