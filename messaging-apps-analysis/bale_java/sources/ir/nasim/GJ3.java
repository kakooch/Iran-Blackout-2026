package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C3419Au3;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class GJ3 extends AbstractC21430te5 implements ZV3, InterfaceC14957im, InterfaceC14942ik4 {
    private boolean A;
    private final C4594Fu3 f;
    private boolean g;
    private boolean k;
    private boolean l;
    private boolean m;
    private C17833ne1 n;
    private float p;
    private UA2 q;
    private C21226tK2 r;
    private boolean w;
    private boolean z;
    private int h = Integer.MAX_VALUE;
    private int i = Integer.MAX_VALUE;
    private C3419Au3.g j = C3419Au3.g.c;
    private long o = C22045ua3.b.b();
    private a s = a.c;
    private final AbstractC14349hm t = new AJ3(this);
    private final C12544en4 u = new C12544en4(new GJ3[16], 0);
    private boolean v = true;
    private boolean x = true;
    private Object y = L1().h();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static final class a {
        public static final a a = new a("IsPlacedInLookahead", 0);
        public static final a b = new a("IsPlacedInApproach", 1);
        public static final a c = new a("IsNotPlaced", 2);
        private static final /* synthetic */ a[] d;
        private static final /* synthetic */ F92 e;

        static {
            a[] aVarArrA = a();
            d = aVarArrA;
            e = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[C3419Au3.e.values().length];
            try {
                iArr[C3419Au3.e.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C3419Au3.e.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C3419Au3.e.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[C3419Au3.e.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[C3419Au3.g.values().length];
            try {
                iArr2[C3419Au3.g.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[C3419Au3.g.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ DJ3 f;

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

        static final class b extends AbstractC8614Ws3 implements UA2 {
            public static final b e = new b();

            b() {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(DJ3 dj3) {
            super(0);
            this.f = dj3;
        }

        public final void a() {
            GJ3.this.k1();
            GJ3.this.m0(a.e);
            DJ3 dj3E2 = GJ3.this.e0().E2();
            if (dj3E2 != null) {
                boolean zR1 = dj3E2.R1();
                List listR = GJ3.this.G1().R();
                int size = listR.size();
                for (int i = 0; i < size; i++) {
                    DJ3 dj3E22 = ((C3419Au3) listR.get(i)).w0().E2();
                    if (dj3E22 != null) {
                        dj3E22.W1(zR1);
                    }
                }
            }
            this.f.q1().j();
            DJ3 dj3E23 = GJ3.this.e0().E2();
            if (dj3E23 != null) {
                dj3E23.R1();
                List listR2 = GJ3.this.G1().R();
                int size2 = listR2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    DJ3 dj3E24 = ((C3419Au3) listR2.get(i2)).w0().E2();
                    if (dj3E24 != null) {
                        dj3E24.W1(false);
                    }
                }
            }
            GJ3.this.j1();
            GJ3.this.m0(b.e);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j) {
            super(0);
            this.f = j;
        }

        public final void a() {
            DJ3 dj3E2 = GJ3.this.S1().E2();
            AbstractC13042fc3.f(dj3E2);
            dj3E2.l0(this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC23714xO4 f;
        final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC23714xO4 interfaceC23714xO4, long j) {
            super(0);
            this.f = interfaceC23714xO4;
            this.g = j;
        }

        public final void a() {
            DJ3 dj3E2;
            AbstractC21430te5.a aVarD1 = null;
            if (AbstractC4843Gu3.a(GJ3.this.G1()) || GJ3.this.f.i()) {
                XA4 xa4L2 = GJ3.this.S1().L2();
                if (xa4L2 != null) {
                    aVarD1 = xa4L2.D1();
                }
            } else {
                XA4 xa4L22 = GJ3.this.S1().L2();
                if (xa4L22 != null && (dj3E2 = xa4L22.E2()) != null) {
                    aVarD1 = dj3E2.D1();
                }
            }
            if (aVarD1 == null) {
                aVarD1 = this.f.getPlacementScope();
            }
            GJ3 gj3 = GJ3.this;
            long j = this.g;
            DJ3 dj3E22 = gj3.S1().E2();
            AbstractC13042fc3.f(dj3E22);
            AbstractC21430te5.a.j(aVarD1, dj3E22, j, 0.0f, 2, null);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
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

    public GJ3(C4594Fu3 c4594Fu3) {
        this.f = c4594Fu3;
    }

    private final boolean F1() {
        return this.f.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3419Au3 G1() {
        return this.f.m();
    }

    private final boolean J1() {
        return this.f.t();
    }

    private final C3419Au3.e K1() {
        return this.f.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final XA4 S1() {
        return this.f.A();
    }

    private final void Y1() {
        a aVar = this.s;
        if (q1()) {
            this.s = a.b;
        } else {
            this.s = a.a;
        }
        if (aVar != a.a && this.f.u()) {
            C3419Au3.B1(G1(), true, false, false, 6, null);
        }
        C12544en4 c12544en4G0 = G1().G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i];
            GJ3 gj3J0 = c3419Au3.j0();
            if (gj3J0 == null) {
                throw new IllegalArgumentException("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.".toString());
            }
            if (gj3J0.i != Integer.MAX_VALUE) {
                gj3J0.Y1();
                c3419Au3.G1(c3419Au3);
            }
        }
    }

    private final void b2() {
        C12544en4 c12544en4G0 = G1().G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i];
            if (c3419Au3.i0() && c3419Au3.q0() == C3419Au3.g.a) {
                GJ3 gj3V = c3419Au3.e0().v();
                AbstractC13042fc3.f(gj3V);
                C17833ne1 c17833ne1L = c3419Au3.e0().l();
                AbstractC13042fc3.f(c17833ne1L);
                if (gj3V.h2(c17833ne1L.r())) {
                    C3419Au3.B1(G1(), false, false, false, 7, null);
                }
            }
        }
    }

    private final void c2() {
        C3419Au3.B1(G1(), false, false, false, 7, null);
        C3419Au3 c3419Au3A0 = G1().A0();
        if (c3419Au3A0 == null || G1().c0() != C3419Au3.g.c) {
            return;
        }
        C3419Au3 c3419Au3G1 = G1();
        int i = b.a[c3419Au3A0.g0().ordinal()];
        c3419Au3G1.N1(i != 2 ? i != 3 ? c3419Au3A0.c0() : C3419Au3.g.b : C3419Au3.g.a);
    }

    private final void g2(long j, float f2, UA2 ua2, C21226tK2 c21226tK2) {
        C3419Au3 c3419Au3A0 = G1().A0();
        C3419Au3.e eVarG0 = c3419Au3A0 != null ? c3419Au3A0.g0() : null;
        C3419Au3.e eVar = C3419Au3.e.d;
        if (eVarG0 == eVar) {
            this.f.Q(false);
        }
        if (!(!G1().u())) {
            M73.a("place is called on a deactivated node");
        }
        m2(eVar);
        this.l = true;
        this.A = false;
        if (!C22045ua3.j(j, this.o)) {
            if (this.f.q() || this.f.r()) {
                k2(true);
            }
            Z1();
        }
        InterfaceC23714xO4 interfaceC23714xO4B = AbstractC4360Eu3.b(G1());
        if (F1() || !o()) {
            this.f.S(false);
            t().r(false);
            C24898zO4.d(interfaceC23714xO4B.getSnapshotObserver(), G1(), false, new e(interfaceC23714xO4B, j), 2, null);
        } else {
            DJ3 dj3E2 = S1().E2();
            AbstractC13042fc3.f(dj3E2);
            dj3E2.i2(j);
            e2();
        }
        this.o = j;
        this.p = f2;
        this.q = ua2;
        this.r = c21226tK2;
        m2(C3419Au3.e.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1() {
        C12544en4 c12544en4G0 = G1().G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            GJ3 gj3V = ((C3419Au3) objArr[i]).e0().v();
            AbstractC13042fc3.f(gj3V);
            int i2 = gj3V.h;
            int i3 = gj3V.i;
            if (i2 != i3 && i3 == Integer.MAX_VALUE) {
                gj3V.X1(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1() {
        this.f.X(0);
        C12544en4 c12544en4G0 = G1().G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            GJ3 gj3V = ((C3419Au3) objArr[i]).e0().v();
            AbstractC13042fc3.f(gj3V);
            gj3V.h = gj3V.i;
            gj3V.i = Integer.MAX_VALUE;
            if (gj3V.j == C3419Au3.g.b) {
                gj3V.j = C3419Au3.g.c;
            }
        }
    }

    private final void k2(boolean z) {
        this.f.U(z);
    }

    private final void l2(boolean z) {
        this.f.V(z);
    }

    private final void m2(C3419Au3.e eVar) {
        this.f.R(eVar);
    }

    private final void n2(boolean z) {
        this.f.W(z);
    }

    private final boolean q1() {
        return this.f.i();
    }

    private final void r2(C3419Au3 c3419Au3) {
        C3419Au3.g gVar;
        C3419Au3 c3419Au3A0 = c3419Au3.A0();
        if (c3419Au3A0 == null) {
            this.j = C3419Au3.g.c;
            return;
        }
        if (!(this.j == C3419Au3.g.c || c3419Au3.O())) {
            M73.b("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
        }
        int i = b.a[c3419Au3A0.g0().ordinal()];
        if (i == 1 || i == 2) {
            gVar = C3419Au3.g.a;
        } else {
            if (i != 3 && i != 4) {
                throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + c3419Au3A0.g0());
            }
            gVar = C3419Au3.g.b;
        }
        this.j = gVar;
    }

    @Override // ir.nasim.InterfaceC14957im
    public Map C() {
        if (!this.k) {
            if (K1() == C3419Au3.e.b) {
                t().s(true);
                if (t().g()) {
                    this.f.F();
                }
            } else {
                t().r(true);
            }
        }
        DJ3 dj3E2 = e0().E2();
        if (dj3E2 != null) {
            dj3E2.W1(true);
        }
        S();
        DJ3 dj3E22 = e0().E2();
        if (dj3E22 != null) {
            dj3E22.W1(false);
        }
        return t().h();
    }

    public final boolean D1() {
        return this.w;
    }

    @Override // ir.nasim.InterfaceC14957im
    public InterfaceC14957im E() {
        C4594Fu3 c4594Fu3E0;
        C3419Au3 c3419Au3A0 = G1().A0();
        if (c3419Au3A0 == null || (c4594Fu3E0 = c3419Au3A0.e0()) == null) {
            return null;
        }
        return c4594Fu3E0.p();
    }

    @Override // ir.nasim.AbstractC21430te5
    public int F0() {
        DJ3 dj3E2 = S1().E2();
        AbstractC13042fc3.f(dj3E2);
        return dj3E2.F0();
    }

    @Override // ir.nasim.InterfaceC14195hW3
    public int J(AbstractC13165fm abstractC13165fm) {
        C3419Au3 c3419Au3A0 = G1().A0();
        if ((c3419Au3A0 != null ? c3419Au3A0.g0() : null) == C3419Au3.e.b) {
            t().u(true);
        } else {
            C3419Au3 c3419Au3A02 = G1().A0();
            if ((c3419Au3A02 != null ? c3419Au3A02.g0() : null) == C3419Au3.e.d) {
                t().t(true);
            }
        }
        this.k = true;
        DJ3 dj3E2 = S1().E2();
        AbstractC13042fc3.f(dj3E2);
        int iJ = dj3E2.J(abstractC13165fm);
        this.k = false;
        return iJ;
    }

    public final C10354bW3 L1() {
        return this.f.w();
    }

    public final C3419Au3.g M1() {
        return this.j;
    }

    @Override // ir.nasim.AbstractC21430te5
    public int N0() {
        DJ3 dj3E2 = S1().E2();
        AbstractC13042fc3.f(dj3E2);
        return dj3E2.N0();
    }

    @Override // ir.nasim.InterfaceC14942ik4
    public void O(boolean z) {
        DJ3 dj3E2;
        DJ3 dj3E22 = S1().E2();
        if (!AbstractC13042fc3.d(Boolean.valueOf(z), dj3E22 != null ? Boolean.valueOf(dj3E22.M1()) : null) && (dj3E2 = S1().E2()) != null) {
            dj3E2.V1(z);
        }
        q2(z);
    }

    public final boolean R1() {
        if (AbstractC4843Gu3.a(G1())) {
            return true;
        }
        if (this.s == a.c && !this.f.h()) {
            this.f.Q(true);
        }
        return q1();
    }

    @Override // ir.nasim.InterfaceC14957im
    public void S() {
        this.w = true;
        t().o();
        if (F1()) {
            b2();
        }
        DJ3 dj3E2 = e0().E2();
        AbstractC13042fc3.f(dj3E2);
        if (J1() || (!this.k && !dj3E2.R1() && F1())) {
            k2(false);
            C3419Au3.e eVarK1 = K1();
            m2(C3419Au3.e.d);
            InterfaceC23714xO4 interfaceC23714xO4B = AbstractC4360Eu3.b(G1());
            this.f.T(false);
            C24898zO4.f(interfaceC23714xO4B.getSnapshotObserver(), G1(), false, new c(dj3E2), 2, null);
            m2(eVarK1);
            if (this.f.r() && dj3E2.R1()) {
                requestLayout();
            }
            l2(false);
        }
        if (t().l()) {
            t().q(true);
        }
        if (t().g() && t().k()) {
            t().n();
        }
        this.w = false;
    }

    public final boolean T1() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC21430te5
    public void U0(long j, float f2, UA2 ua2) {
        g2(j, f2, ua2, null);
    }

    public final void U1(boolean z) {
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
        int i = b.b[gVarC0.ordinal()];
        if (i == 1) {
            if (c3419Au3.k0() != null) {
                C3419Au3.B1(c3419Au3, z, false, false, 6, null);
                return;
            } else {
                C3419Au3.F1(c3419Au3, z, false, false, 6, null);
                return;
            }
        }
        if (i != 2) {
            throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
        }
        if (c3419Au3.k0() != null) {
            c3419Au3.y1(z);
        } else {
            c3419Au3.C1(z);
        }
    }

    public final void V1() {
        this.x = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC21430te5
    public void W0(long j, float f2, C21226tK2 c21226tK2) {
        g2(j, f2, null, c21226tK2);
    }

    public final void W1() {
        k2(true);
        l2(true);
    }

    public final void X1(boolean z) {
        if (z && q1()) {
            return;
        }
        if (z || q1()) {
            this.s = a.c;
            C12544en4 c12544en4G0 = G1().G0();
            Object[] objArr = c12544en4G0.a;
            int iO = c12544en4G0.o();
            for (int i = 0; i < iO; i++) {
                GJ3 gj3V = ((C3419Au3) objArr[i]).e0().v();
                AbstractC13042fc3.f(gj3V);
                gj3V.X1(true);
            }
        }
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int Z(int i) {
        c2();
        DJ3 dj3E2 = S1().E2();
        AbstractC13042fc3.f(dj3E2);
        return dj3E2.Z(i);
    }

    public final void Z1() {
        if (this.f.e() > 0) {
            C12544en4 c12544en4G0 = G1().G0();
            Object[] objArr = c12544en4G0.a;
            int iO = c12544en4G0.o();
            for (int i = 0; i < iO; i++) {
                C3419Au3 c3419Au3 = (C3419Au3) objArr[i];
                C4594Fu3 c4594Fu3E0 = c3419Au3.e0();
                if ((c4594Fu3E0.r() || c4594Fu3E0.q()) && !c4594Fu3E0.s()) {
                    C3419Au3.z1(c3419Au3, false, 1, null);
                }
                GJ3 gj3V = c4594Fu3E0.v();
                if (gj3V != null) {
                    gj3V.Z1();
                }
            }
        }
    }

    public final void a2() {
        this.s = a.a;
    }

    public final void d2() {
        this.i = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
        this.s = a.c;
    }

    @Override // ir.nasim.InterfaceC14957im
    public XA4 e0() {
        return G1().Y();
    }

    public final void e2() {
        this.A = true;
        C3419Au3 c3419Au3A0 = G1().A0();
        if ((this.s != a.a && !q1()) || (this.s != a.b && q1())) {
            Y1();
            if (this.g && c3419Au3A0 != null) {
                C3419Au3.z1(c3419Au3A0, false, 1, null);
            }
        }
        if (c3419Au3A0 == null) {
            this.i = 0;
        } else if (!this.g && (c3419Au3A0.g0() == C3419Au3.e.c || c3419Au3A0.g0() == C3419Au3.e.d)) {
            if (!(this.i == Integer.MAX_VALUE)) {
                M73.b("Place was called on a node which was placed already");
            }
            this.i = c3419Au3A0.e0().y();
            C4594Fu3 c4594Fu3E0 = c3419Au3A0.e0();
            c4594Fu3E0.X(c4594Fu3E0.y() + 1);
        }
        S();
    }

    public final void f2(long j) {
        m2(C3419Au3.e.b);
        n2(false);
        C24898zO4.h(AbstractC4360Eu3.b(G1()).getSnapshotObserver(), G1(), false, new d(j), 2, null);
        W1();
        if (AbstractC4843Gu3.a(G1())) {
            L1().a2();
        } else {
            L1().b2();
        }
        m2(C3419Au3.e.e);
    }

    @Override // ir.nasim.InterfaceC14195hW3, ir.nasim.InterfaceC9236Zb3
    public Object h() {
        return this.y;
    }

    public final boolean h2(long j) {
        long jC;
        if (!(!G1().u())) {
            M73.a("measure is called on a deactivated node");
        }
        C3419Au3 c3419Au3A0 = G1().A0();
        G1().J1(G1().O() || (c3419Au3A0 != null && c3419Au3A0.O()));
        if (!G1().i0()) {
            C17833ne1 c17833ne1 = this.n;
            if (c17833ne1 == null ? false : C17833ne1.f(c17833ne1.r(), j)) {
                InterfaceC23714xO4 interfaceC23714xO4Z0 = G1().z0();
                if (interfaceC23714xO4Z0 != null) {
                    interfaceC23714xO4Z0.w(G1(), true);
                }
                G1().I1();
                return false;
            }
        }
        this.n = C17833ne1.a(j);
        b1(j);
        t().s(false);
        m0(f.e);
        if (this.m) {
            jC = H0();
        } else {
            long j2 = RecyclerView.UNDEFINED_DURATION;
            jC = C4414Fa3.c((j2 & 4294967295L) | (j2 << 32));
        }
        this.m = true;
        DJ3 dj3E2 = S1().E2();
        if (!(dj3E2 != null)) {
            M73.b("Lookahead result from lookaheadRemeasure cannot be null");
        }
        this.f.J(j);
        Y0(C4414Fa3.c((dj3E2.A0() & 4294967295L) | (dj3E2.P0() << 32)));
        return (((int) (jC >> 32)) == dj3E2.P0() && ((int) (jC & 4294967295L)) == dj3E2.A0()) ? false : true;
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int i0(int i) {
        c2();
        DJ3 dj3E2 = S1().E2();
        AbstractC13042fc3.f(dj3E2);
        return dj3E2.i0(i);
    }

    public final void i2() {
        C3419Au3 c3419Au3A0;
        try {
            this.g = true;
            if (!this.l) {
                M73.b("replace() called on item that was not placed");
            }
            this.A = false;
            boolean zO = o();
            g2(this.o, 0.0f, this.q, this.r);
            if (zO && !this.A && (c3419Au3A0 = G1().A0()) != null) {
                C3419Au3.z1(c3419Au3A0, false, 1, null);
            }
            this.g = false;
        } catch (Throwable th) {
            this.g = false;
            throw th;
        }
    }

    public final void j2(boolean z) {
        this.v = z;
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int k0(int i) {
        c2();
        DJ3 dj3E2 = S1().E2();
        AbstractC13042fc3.f(dj3E2);
        return dj3E2.k0(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // ir.nasim.ZV3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.AbstractC21430te5 l0(long r4) {
        /*
            r3 = this;
            ir.nasim.Au3 r0 = r3.G1()
            ir.nasim.Au3 r0 = r0.A0()
            r1 = 0
            if (r0 == 0) goto L10
            ir.nasim.Au3$e r0 = r0.g0()
            goto L11
        L10:
            r0 = r1
        L11:
            ir.nasim.Au3$e r2 = ir.nasim.C3419Au3.e.b
            if (r0 == r2) goto L27
            ir.nasim.Au3 r0 = r3.G1()
            ir.nasim.Au3 r0 = r0.A0()
            if (r0 == 0) goto L23
            ir.nasim.Au3$e r1 = r0.g0()
        L23:
            ir.nasim.Au3$e r0 = ir.nasim.C3419Au3.e.d
            if (r1 != r0) goto L2d
        L27:
            ir.nasim.Fu3 r0 = r3.f
            r1 = 0
            r0.P(r1)
        L2d:
            ir.nasim.Au3 r0 = r3.G1()
            r3.r2(r0)
            ir.nasim.Au3 r0 = r3.G1()
            ir.nasim.Au3$g r0 = r0.c0()
            ir.nasim.Au3$g r1 = ir.nasim.C3419Au3.g.c
            if (r0 != r1) goto L47
            ir.nasim.Au3 r0 = r3.G1()
            r0.E()
        L47:
            r3.h2(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GJ3.l0(long):ir.nasim.te5");
    }

    public final List l1() {
        G1().R();
        if (!this.v) {
            return this.u.j();
        }
        C3419Au3 c3419Au3G1 = G1();
        C12544en4 c12544en4 = this.u;
        C12544en4 c12544en4G0 = c3419Au3G1.G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i];
            if (c12544en4.o() <= i) {
                GJ3 gj3V = c3419Au3.e0().v();
                AbstractC13042fc3.f(gj3V);
                c12544en4.d(gj3V);
            } else {
                GJ3 gj3V2 = c3419Au3.e0().v();
                AbstractC13042fc3.f(gj3V2);
                c12544en4.A(i, gj3V2);
            }
        }
        c12544en4.x(c3419Au3G1.R().size(), c12544en4.o());
        this.v = false;
        return this.u.j();
    }

    @Override // ir.nasim.InterfaceC14957im
    public void m0(UA2 ua2) {
        C12544en4 c12544en4G0 = G1().G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            InterfaceC14957im interfaceC14957imP = ((C3419Au3) objArr[i]).e0().p();
            AbstractC13042fc3.f(interfaceC14957imP);
            ua2.invoke(interfaceC14957imP);
        }
    }

    @Override // ir.nasim.InterfaceC14957im
    public boolean o() {
        return this.s != a.c;
    }

    public final void o2(C3419Au3.g gVar) {
        this.j = gVar;
    }

    public final void p2(int i) {
        this.i = i;
    }

    @Override // ir.nasim.InterfaceC14957im
    public void q0() {
        C3419Au3.B1(G1(), false, false, false, 7, null);
    }

    public void q2(boolean z) {
        this.z = z;
    }

    @Override // ir.nasim.InterfaceC14957im
    public void requestLayout() {
        C3419Au3.z1(G1(), false, 1, null);
    }

    public final C17833ne1 s1() {
        return this.n;
    }

    public final boolean s2() {
        if (h() == null) {
            DJ3 dj3E2 = S1().E2();
            AbstractC13042fc3.f(dj3E2);
            if (dj3E2.h() == null) {
                return false;
            }
        }
        if (!this.x) {
            return false;
        }
        this.x = false;
        DJ3 dj3E22 = S1().E2();
        AbstractC13042fc3.f(dj3E22);
        this.y = dj3E22.h();
        return true;
    }

    @Override // ir.nasim.InterfaceC14957im
    public AbstractC14349hm t() {
        return this.t;
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int z(int i) {
        c2();
        DJ3 dj3E2 = S1().E2();
        AbstractC13042fc3.f(dj3E2);
        return dj3E2.z(i);
    }
}
