package ir.nasim;

import ir.nasim.AbstractC21430te5;
import ir.nasim.C22045ua3;
import ir.nasim.C3419Au3;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.bW3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10354bW3 extends AbstractC21430te5 implements ZV3, InterfaceC14957im, InterfaceC14942ik4 {
    private boolean A;
    private long A0;
    private boolean B;
    private float B0;
    private final SA2 C0;
    private long D;
    private boolean D0;
    private boolean E0;
    private final SA2 G;
    private final SA2 H;
    private float J;
    private boolean Y;
    private UA2 Z;
    private final C4594Fu3 f;
    private boolean g;
    private boolean j;
    private boolean k;
    private boolean m;
    private long n;
    private UA2 o;
    private C21226tK2 p;
    private float q;
    private boolean r;
    private Object s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private final AbstractC14349hm y;
    private final C12544en4 z;
    private C21226tK2 z0;
    private int h = Integer.MAX_VALUE;
    private int i = Integer.MAX_VALUE;
    private C3419Au3.g l = C3419Au3.g.c;

    /* renamed from: ir.nasim.bW3$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[C3419Au3.e.values().length];
            try {
                iArr[C3419Au3.e.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C3419Au3.e.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[C3419Au3.g.values().length];
            try {
                iArr2[C3419Au3.g.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[C3419Au3.g.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            b = iArr2;
        }
    }

    /* renamed from: ir.nasim.bW3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {

        /* renamed from: ir.nasim.bW3$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            public final void a(InterfaceC14957im interfaceC14957im) {
                interfaceC14957im.t().t(false);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC14957im) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.bW3$b$b, reason: collision with other inner class name */
        static final class C0909b extends AbstractC8614Ws3 implements UA2 {
            public static final C0909b e = new C0909b();

            C0909b() {
                super(1);
            }

            public final void a(InterfaceC14957im interfaceC14957im) {
                interfaceC14957im.t().q(interfaceC14957im.t().l());
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC14957im) obj);
                return C19938rB7.a;
            }
        }

        b() {
            super(0);
        }

        public final void a() {
            C10354bW3.this.q1();
            C10354bW3.this.m0(a.e);
            C10354bW3.this.e0().q1().j();
            C10354bW3.this.l1();
            C10354bW3.this.m0(C0909b.e);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bW3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        public final void a() {
            C10354bW3.this.T1().l0(C10354bW3.this.D);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bW3$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        public final void a() {
            AbstractC21430te5.a placementScope;
            XA4 xa4L2 = C10354bW3.this.T1().L2();
            if (xa4L2 == null || (placementScope = xa4L2.D1()) == null) {
                placementScope = AbstractC4360Eu3.b(C10354bW3.this.G1()).getPlacementScope();
            }
            AbstractC21430te5.a aVar = placementScope;
            C10354bW3 c10354bW3 = C10354bW3.this;
            UA2 ua2 = c10354bW3.Z;
            C21226tK2 c21226tK2 = c10354bW3.z0;
            if (c21226tK2 != null) {
                aVar.x(c10354bW3.T1(), c10354bW3.A0, c21226tK2, c10354bW3.B0);
            } else if (ua2 == null) {
                aVar.i(c10354bW3.T1(), c10354bW3.A0, c10354bW3.B0);
            } else {
                aVar.w(c10354bW3.T1(), c10354bW3.A0, c10354bW3.B0, ua2);
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bW3$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        public final void a(InterfaceC14957im interfaceC14957im) {
            interfaceC14957im.t().u(false);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC14957im) obj);
            return C19938rB7.a;
        }
    }

    public C10354bW3(C4594Fu3 c4594Fu3) {
        this.f = c4594Fu3;
        C22045ua3.a aVar = C22045ua3.b;
        this.n = aVar.b();
        this.r = true;
        this.y = new C3658Bu3(this);
        this.z = new C12544en4(new C10354bW3[16], 0);
        this.A = true;
        this.D = AbstractC19606qe1.b(0, 0, 0, 0, 15, null);
        this.G = new c();
        this.H = new b();
        this.A0 = aVar.b();
        this.C0 = new d();
    }

    private final GJ3 M1() {
        return this.f.v();
    }

    private final void c2() {
        boolean zO = o();
        r2(true);
        C3419Au3 c3419Au3G1 = G1();
        if (!zO) {
            c3419Au3G1.Y().g3();
            if (c3419Au3G1.n0()) {
                C3419Au3.F1(c3419Au3G1, true, false, false, 6, null);
            } else if (c3419Au3G1.i0()) {
                C3419Au3.B1(c3419Au3G1, true, false, false, 6, null);
            }
        }
        XA4 xa4K2 = c3419Au3G1.Y().K2();
        for (XA4 xa4W0 = c3419Au3G1.w0(); !AbstractC13042fc3.d(xa4W0, xa4K2) && xa4W0 != null; xa4W0 = xa4W0.K2()) {
            if (xa4W0.B2()) {
                xa4W0.U2();
            }
        }
        C12544en4 c12544en4G0 = c3419Au3G1.G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i];
            if (c3419Au3.B0() != Integer.MAX_VALUE) {
                c3419Au3.m0().c2();
                c3419Au3G1.G1(c3419Au3);
            }
        }
    }

    private final void d2() {
        if (o()) {
            r2(false);
            C3419Au3 c3419Au3G1 = G1();
            XA4 xa4K2 = c3419Au3G1.Y().K2();
            for (XA4 xa4W0 = c3419Au3G1.w0(); !AbstractC13042fc3.d(xa4W0, xa4K2) && xa4W0 != null; xa4W0 = xa4W0.K2()) {
                xa4W0.i3();
                xa4W0.p3();
            }
            C12544en4 c12544en4G0 = G1().G0();
            Object[] objArr = c12544en4G0.a;
            int iO = c12544en4G0.o();
            for (int i = 0; i < iO; i++) {
                ((C3419Au3) objArr[i]).m0().d2();
            }
        }
    }

    private final void f2() {
        C12544en4 c12544en4G0 = G1().G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i];
            if (c3419Au3.n0() && c3419Au3.p0() == C3419Au3.g.a && C3419Au3.t1(c3419Au3, null, 1, null)) {
                C3419Au3.F1(G1(), false, false, false, 7, null);
            }
        }
    }

    private final void g2() {
        C3419Au3.F1(G1(), false, false, false, 7, null);
        C3419Au3 c3419Au3A0 = G1().A0();
        if (c3419Au3A0 == null || G1().c0() != C3419Au3.g.c) {
            return;
        }
        C3419Au3 c3419Au3G1 = G1();
        int i = a.a[c3419Au3A0.g0().ordinal()];
        c3419Au3G1.N1(i != 1 ? i != 2 ? c3419Au3A0.c0() : C3419Au3.g.b : C3419Au3.g.a);
    }

    private final void k2(long j, float f, UA2 ua2, C21226tK2 c21226tK2) {
        if (!(!G1().u())) {
            M73.a("place is called on a deactivated node");
        }
        p2(C3419Au3.e.c);
        boolean z = !this.k;
        this.n = j;
        this.q = f;
        this.o = ua2;
        this.p = c21226tK2;
        this.k = true;
        this.Y = false;
        InterfaceC23714xO4 interfaceC23714xO4B = AbstractC4360Eu3.b(G1());
        interfaceC23714xO4B.getRectManager().k(G1(), j, z);
        if (this.w || !o()) {
            t().r(false);
            this.f.N(false);
            this.Z = ua2;
            this.A0 = j;
            this.B0 = f;
            this.z0 = c21226tK2;
            interfaceC23714xO4B.getSnapshotObserver().c(G1(), false, this.C0);
        } else {
            T1().m3(j, f, ua2, c21226tK2);
            i2();
        }
        p2(C3419Au3.e.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        C3419Au3 c3419Au3G1 = G1();
        C12544en4 c12544en4G0 = c3419Au3G1.G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i];
            if (c3419Au3.m0().h != c3419Au3.B0()) {
                c3419Au3G1.p1();
                c3419Au3G1.M0();
                if (c3419Au3.B0() == Integer.MAX_VALUE) {
                    if (c3419Au3.e0().i()) {
                        GJ3 gj3J0 = c3419Au3.j0();
                        AbstractC13042fc3.f(gj3J0);
                        gj3J0.X1(false);
                    }
                    c3419Au3.m0().d2();
                }
            }
        }
    }

    private final void l2(long j, float f, UA2 ua2, C21226tK2 c21226tK2) {
        AbstractC21430te5.a placementScope;
        this.u = true;
        boolean z = false;
        if (!C22045ua3.j(j, this.n) || this.D0) {
            if (this.f.f() || this.f.g() || this.D0) {
                this.w = true;
                this.D0 = false;
            }
            e2();
        }
        GJ3 gj3M1 = M1();
        if (gj3M1 != null && gj3M1.R1()) {
            XA4 xa4L2 = T1().L2();
            if (xa4L2 == null || (placementScope = xa4L2.D1()) == null) {
                placementScope = AbstractC4360Eu3.b(G1()).getPlacementScope();
            }
            AbstractC21430te5.a aVar = placementScope;
            GJ3 gj3M12 = M1();
            AbstractC13042fc3.f(gj3M12);
            C3419Au3 c3419Au3A0 = G1().A0();
            if (c3419Au3A0 != null) {
                c3419Au3A0.e0().X(0);
            }
            gj3M12.p2(Integer.MAX_VALUE);
            AbstractC21430te5.a.h(aVar, gj3M12, C22045ua3.k(j), C22045ua3.l(j), 0.0f, 4, null);
        }
        GJ3 gj3M13 = M1();
        if (gj3M13 != null && !gj3M13.T1()) {
            z = true;
        }
        if (!(true ^ z)) {
            M73.b("Error: Placement happened before lookahead.");
        }
        k2(j, f, ua2, c21226tK2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1() {
        this.f.Y(0);
        C12544en4 c12544en4G0 = G1().G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C10354bW3 c10354bW3M0 = ((C3419Au3) objArr[i]).m0();
            c10354bW3M0.h = c10354bW3M0.i;
            c10354bW3M0.i = Integer.MAX_VALUE;
            c10354bW3M0.u = false;
            if (c10354bW3M0.l == C3419Au3.g.b) {
                c10354bW3M0.l = C3419Au3.g.c;
            }
        }
    }

    private final void t2(C3419Au3 c3419Au3) {
        C3419Au3.g gVar;
        C3419Au3 c3419Au3A0 = c3419Au3.A0();
        if (c3419Au3A0 == null) {
            this.l = C3419Au3.g.c;
            return;
        }
        if (!(this.l == C3419Au3.g.c || c3419Au3.O())) {
            M73.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
        }
        int i = a.a[c3419Au3A0.g0().ordinal()];
        if (i == 1) {
            gVar = C3419Au3.g.a;
        } else {
            if (i != 2) {
                throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + c3419Au3A0.g0());
            }
            gVar = C3419Au3.g.b;
        }
        this.l = gVar;
    }

    @Override // ir.nasim.InterfaceC14957im
    public Map C() {
        if (!this.m) {
            if (L1() == C3419Au3.e.a) {
                t().s(true);
                if (t().g()) {
                    a2();
                }
            } else {
                t().r(true);
            }
        }
        e0().W1(true);
        S();
        e0().W1(false);
        return t().h();
    }

    public final C17833ne1 D1() {
        if (this.j) {
            return C17833ne1.a(O0());
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC14957im
    public InterfaceC14957im E() {
        C4594Fu3 c4594Fu3E0;
        C3419Au3 c3419Au3A0 = G1().A0();
        if (c3419Au3A0 == null || (c4594Fu3E0 = c3419Au3A0.e0()) == null) {
            return null;
        }
        return c4594Fu3E0.c();
    }

    @Override // ir.nasim.AbstractC21430te5
    public int F0() {
        return T1().F0();
    }

    public final long F1() {
        return this.n;
    }

    public final C3419Au3 G1() {
        return this.f.m();
    }

    @Override // ir.nasim.InterfaceC14195hW3
    public int J(AbstractC13165fm abstractC13165fm) {
        C3419Au3 c3419Au3A0 = G1().A0();
        if ((c3419Au3A0 != null ? c3419Au3A0.g0() : null) == C3419Au3.e.a) {
            t().u(true);
        } else {
            C3419Au3 c3419Au3A02 = G1().A0();
            if ((c3419Au3A02 != null ? c3419Au3A02.g0() : null) == C3419Au3.e.c) {
                t().t(true);
            }
        }
        this.m = true;
        int iJ = T1().J(abstractC13165fm);
        this.m = false;
        return iJ;
    }

    public final boolean J1() {
        return this.B;
    }

    public final boolean K1() {
        return this.w;
    }

    public final C3419Au3.e L1() {
        return this.f.o();
    }

    @Override // ir.nasim.AbstractC21430te5
    public int N0() {
        return T1().N0();
    }

    @Override // ir.nasim.InterfaceC14942ik4
    public void O(boolean z) {
        if (z != T1().M1()) {
            T1().V1(z);
            this.D0 = true;
        }
        s2(z);
    }

    public final boolean R1() {
        return this.v;
    }

    @Override // ir.nasim.InterfaceC14957im
    public void S() {
        this.B = true;
        t().o();
        if (this.w) {
            f2();
        }
        if (this.x || (!this.m && !e0().R1() && this.w)) {
            this.w = false;
            C3419Au3.e eVarL1 = L1();
            p2(C3419Au3.e.c);
            this.f.O(false);
            C3419Au3 c3419Au3G1 = G1();
            AbstractC4360Eu3.b(c3419Au3G1).getSnapshotObserver().e(c3419Au3G1, false, this.H);
            p2(eVarL1);
            if (e0().R1() && this.f.g()) {
                requestLayout();
            }
            this.x = false;
        }
        if (t().l()) {
            t().q(true);
        }
        if (t().g() && t().k()) {
            t().n();
        }
        this.B = false;
    }

    public final C3419Au3.g S1() {
        return this.l;
    }

    public final XA4 T1() {
        return this.f.A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC21430te5
    public void U0(long j, float f, UA2 ua2) {
        l2(j, f, ua2, null);
    }

    public final int U1() {
        return this.i;
    }

    public final float V1() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC21430te5
    public void W0(long j, float f, C21226tK2 c21226tK2) {
        l2(j, f, null, c21226tK2);
    }

    public final void W1(boolean z) {
        C3419Au3 c3419Au3;
        C3419Au3 c3419Au3A0 = G1().A0();
        C3419Au3.g gVarC0 = G1().c0();
        if (c3419Au3A0 == null || gVarC0 == C3419Au3.g.c) {
            return;
        }
        do {
            c3419Au3 = c3419Au3A0;
            if (c3419Au3.c0() != gVarC0) {
                break;
            } else {
                c3419Au3A0 = c3419Au3.A0();
            }
        } while (c3419Au3A0 != null);
        int i = a.b[gVarC0.ordinal()];
        if (i == 1) {
            C3419Au3.F1(c3419Au3, z, false, false, 6, null);
        } else {
            if (i != 2) {
                throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
            }
            c3419Au3.C1(z);
        }
    }

    public final void X1() {
        this.r = true;
    }

    public final boolean Y1() {
        return this.u;
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int Z(int i) {
        if (!AbstractC4843Gu3.a(G1())) {
            g2();
            return T1().Z(i);
        }
        GJ3 gj3M1 = M1();
        AbstractC13042fc3.f(gj3M1);
        return gj3M1.Z(i);
    }

    public final void Z1() {
        this.f.P(true);
    }

    public final void a2() {
        this.w = true;
        this.x = true;
    }

    public final void b2() {
        this.v = true;
    }

    @Override // ir.nasim.InterfaceC14957im
    public XA4 e0() {
        return G1().Y();
    }

    public final void e2() {
        if (this.f.d() > 0) {
            C12544en4 c12544en4G0 = G1().G0();
            Object[] objArr = c12544en4G0.a;
            int iO = c12544en4G0.o();
            for (int i = 0; i < iO; i++) {
                C3419Au3 c3419Au3 = (C3419Au3) objArr[i];
                C4594Fu3 c4594Fu3E0 = c3419Au3.e0();
                if ((c4594Fu3E0.g() || c4594Fu3E0.f()) && !c4594Fu3E0.n()) {
                    C3419Au3.D1(c3419Au3, false, 1, null);
                }
                c4594Fu3E0.w().e2();
            }
        }
    }

    @Override // ir.nasim.InterfaceC14195hW3, ir.nasim.InterfaceC9236Zb3
    public Object h() {
        return this.s;
    }

    public final void h2() {
        this.i = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
        r2(false);
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int i0(int i) {
        if (!AbstractC4843Gu3.a(G1())) {
            g2();
            return T1().i0(i);
        }
        GJ3 gj3M1 = M1();
        AbstractC13042fc3.f(gj3M1);
        return gj3M1.i0(i);
    }

    public final void i2() {
        this.Y = true;
        C3419Au3 c3419Au3A0 = G1().A0();
        float fM2 = e0().M2();
        C3419Au3 c3419Au3G1 = G1();
        XA4 xa4Y = c3419Au3G1.Y();
        for (XA4 xa4W0 = c3419Au3G1.w0(); xa4W0 != xa4Y; xa4W0 = xa4W0.K2()) {
            AbstractC13042fc3.g(xa4W0, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            fM2 += ((C22245uu3) xa4W0).M2();
        }
        if (fM2 != this.J) {
            this.J = fM2;
            if (c3419Au3A0 != null) {
                c3419Au3A0.p1();
            }
            if (c3419Au3A0 != null) {
                c3419Au3A0.M0();
            }
        }
        if (o()) {
            G1().Y().g3();
        } else {
            if (c3419Au3A0 != null) {
                c3419Au3A0.M0();
            }
            c2();
            if (this.g && c3419Au3A0 != null) {
                C3419Au3.D1(c3419Au3A0, false, 1, null);
            }
        }
        if (c3419Au3A0 == null) {
            this.i = 0;
        } else if (!this.g && c3419Au3A0.g0() == C3419Au3.e.c) {
            if (!(this.i == Integer.MAX_VALUE)) {
                M73.b("Place was called on a node which was placed already");
            }
            this.i = c3419Au3A0.e0().z();
            C4594Fu3 c4594Fu3E0 = c3419Au3A0.e0();
            c4594Fu3E0.Y(c4594Fu3E0.z() + 1);
        }
        S();
    }

    public final void j2(long j) {
        C3419Au3.e eVarL1 = L1();
        C3419Au3.e eVar = C3419Au3.e.e;
        if (!(eVarL1 == eVar)) {
            M73.b("layout state is not idle before measure starts");
        }
        this.D = j;
        C3419Au3.e eVar2 = C3419Au3.e.a;
        p2(eVar2);
        this.v = false;
        AbstractC4360Eu3.b(G1()).getSnapshotObserver().g(G1(), false, this.G);
        if (L1() == eVar2) {
            a2();
            p2(eVar);
        }
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int k0(int i) {
        if (!AbstractC4843Gu3.a(G1())) {
            g2();
            return T1().k0(i);
        }
        GJ3 gj3M1 = M1();
        AbstractC13042fc3.f(gj3M1);
        return gj3M1.k0(i);
    }

    @Override // ir.nasim.ZV3
    public AbstractC21430te5 l0(long j) {
        C3419Au3.g gVarC0 = G1().c0();
        C3419Au3.g gVar = C3419Au3.g.c;
        if (gVarC0 == gVar) {
            G1().E();
        }
        if (AbstractC4843Gu3.a(G1())) {
            GJ3 gj3M1 = M1();
            AbstractC13042fc3.f(gj3M1);
            gj3M1.o2(gVar);
            gj3M1.l0(j);
        }
        t2(G1());
        m2(j);
        return this;
    }

    @Override // ir.nasim.InterfaceC14957im
    public void m0(UA2 ua2) {
        C12544en4 c12544en4G0 = G1().G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            ua2.invoke(((C3419Au3) objArr[i]).e0().c());
        }
    }

    public final boolean m2(long j) {
        boolean z = true;
        if (!(!G1().u())) {
            M73.a("measure is called on a deactivated node");
        }
        InterfaceC23714xO4 interfaceC23714xO4B = AbstractC4360Eu3.b(G1());
        C3419Au3 c3419Au3A0 = G1().A0();
        G1().J1(G1().O() || (c3419Au3A0 != null && c3419Au3A0.O()));
        if (!G1().n0() && C17833ne1.f(O0(), j)) {
            InterfaceC23714xO4.f(interfaceC23714xO4B, G1(), false, 2, null);
            G1().I1();
            return false;
        }
        t().s(false);
        m0(e.e);
        this.j = true;
        long jA = T1().a();
        b1(j);
        j2(j);
        if (C4414Fa3.e(T1().a(), jA) && T1().P0() == P0() && T1().A0() == A0()) {
            z = false;
        }
        Y0(C4414Fa3.c((T1().A0() & 4294967295L) | (T1().P0() << 32)));
        return z;
    }

    public final void n2() {
        C3419Au3 c3419Au3A0;
        try {
            this.g = true;
            if (!this.k) {
                M73.b("replace called on unplaced item");
            }
            boolean zO = o();
            k2(this.n, this.q, this.o, this.p);
            if (zO && !this.Y && (c3419Au3A0 = G1().A0()) != null) {
                C3419Au3.D1(c3419Au3A0, false, 1, null);
            }
            this.g = false;
        } catch (Throwable th) {
            this.g = false;
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC14957im
    public boolean o() {
        return this.t;
    }

    public final void o2(boolean z) {
        this.A = z;
    }

    public final void p2(C3419Au3.e eVar) {
        this.f.R(eVar);
    }

    @Override // ir.nasim.InterfaceC14957im
    public void q0() {
        C3419Au3.F1(G1(), false, false, false, 7, null);
    }

    public final void q2(C3419Au3.g gVar) {
        this.l = gVar;
    }

    public void r2(boolean z) {
        this.t = z;
    }

    @Override // ir.nasim.InterfaceC14957im
    public void requestLayout() {
        C3419Au3.D1(G1(), false, 1, null);
    }

    public final List s1() {
        G1().Z1();
        if (!this.A) {
            return this.z.j();
        }
        C3419Au3 c3419Au3G1 = G1();
        C12544en4 c12544en4 = this.z;
        C12544en4 c12544en4G0 = c3419Au3G1.G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i];
            if (c12544en4.o() <= i) {
                c12544en4.d(c3419Au3.e0().w());
            } else {
                c12544en4.A(i, c3419Au3.e0().w());
            }
        }
        c12544en4.x(c3419Au3G1.R().size(), c12544en4.o());
        this.A = false;
        return this.z.j();
    }

    public void s2(boolean z) {
        this.E0 = z;
    }

    @Override // ir.nasim.InterfaceC14957im
    public AbstractC14349hm t() {
        return this.y;
    }

    public final boolean u2() {
        if ((h() == null && T1().h() == null) || !this.r) {
            return false;
        }
        this.r = false;
        this.s = T1().h();
        return true;
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int z(int i) {
        if (!AbstractC4843Gu3.a(G1())) {
            g2();
            return T1().z(i);
        }
        GJ3 gj3M1 = M1();
        AbstractC13042fc3.f(gj3M1);
        return gj3M1.z(i);
    }
}
