package ir.nasim;

import ir.nasim.C3419Au3;
import ir.nasim.InterfaceC23714xO4;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.aW3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9760aW3 {
    private final C3419Au3 a;
    private final C17631nI1 b;
    private boolean c;
    private boolean d;
    private final PJ4 e;
    private final C12544en4 f;
    private long g;
    private final C12544en4 h;
    private C17833ne1 i;
    private final C7457Ru3 j;

    /* renamed from: ir.nasim.aW3$a */
    public static final class a {
        private final C3419Au3 a;
        private final boolean b;
        private final boolean c;

        public a(C3419Au3 c3419Au3, boolean z, boolean z2) {
            this.a = c3419Au3;
            this.b = z;
            this.c = z2;
        }

        public final C3419Au3 a() {
            return this.a;
        }

        public final boolean b() {
            return this.c;
        }

        public final boolean c() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.aW3$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

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
                iArr[C3419Au3.e.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[C3419Au3.e.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[C3419Au3.e.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    public C9760aW3(C3419Au3 c3419Au3) {
        this.a = c3419Au3;
        InterfaceC23714xO4.a aVar = InterfaceC23714xO4.q0;
        C17631nI1 c17631nI1 = new C17631nI1(aVar.a());
        this.b = c17631nI1;
        this.e = new PJ4();
        this.f = new C12544en4(new InterfaceC23714xO4.b[16], 0);
        this.g = 1L;
        C12544en4 c12544en4 = new C12544en4(new a[16], 0);
        this.h = c12544en4;
        this.j = aVar.a() ? new C7457Ru3(c3419Au3, c17631nI1, c12544en4.j()) : null;
    }

    static /* synthetic */ boolean A(C9760aW3 c9760aW3, C3419Au3 c3419Au3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return c9760aW3.z(c3419Au3, z, z2);
    }

    private final void B(C3419Au3 c3419Au3) {
        C12544en4 c12544en4G0 = c3419Au3.G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au32 = (C3419Au3) objArr[i];
            if (p(c3419Au32)) {
                if (AbstractC4843Gu3.a(c3419Au32)) {
                    C(c3419Au32, true);
                } else {
                    B(c3419Au32);
                }
            }
        }
    }

    private final void C(C3419Au3 c3419Au3, boolean z) {
        C17833ne1 c17833ne1;
        if (c3419Au3.u()) {
            return;
        }
        if (c3419Au3 == this.a) {
            c17833ne1 = this.i;
            AbstractC13042fc3.f(c17833ne1);
        } else {
            c17833ne1 = null;
        }
        if (z) {
            e(c3419Au3, c17833ne1);
        } else {
            f(c3419Au3, c17833ne1);
        }
    }

    public static /* synthetic */ boolean I(C9760aW3 c9760aW3, C3419Au3 c3419Au3, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return c9760aW3.H(c3419Au3, z);
    }

    private final void b() {
        C12544en4 c12544en4 = this.f;
        Object[] objArr = c12544en4.a;
        int iO = c12544en4.o();
        for (int i = 0; i < iO; i++) {
            ((InterfaceC23714xO4.b) objArr[i]).n();
        }
        this.f.k();
    }

    public static /* synthetic */ void d(C9760aW3 c9760aW3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        c9760aW3.c(z);
    }

    private final boolean e(C3419Au3 c3419Au3, C17833ne1 c17833ne1) {
        if (c3419Au3.k0() == null) {
            return false;
        }
        boolean zW0 = c17833ne1 != null ? c3419Au3.W0(c17833ne1) : C3419Au3.X0(c3419Au3, null, 1, null);
        C3419Au3 c3419Au3A0 = c3419Au3.A0();
        if (zW0 && c3419Au3A0 != null) {
            if (c3419Au3A0.k0() == null) {
                C3419Au3.F1(c3419Au3A0, false, false, false, 3, null);
            } else if (c3419Au3.q0() == C3419Au3.g.a) {
                C3419Au3.B1(c3419Au3A0, false, false, false, 3, null);
            } else if (c3419Au3.q0() == C3419Au3.g.b) {
                C3419Au3.z1(c3419Au3A0, false, 1, null);
            }
        }
        return zW0;
    }

    private final boolean f(C3419Au3 c3419Au3, C17833ne1 c17833ne1) {
        boolean zS1 = c17833ne1 != null ? c3419Au3.s1(c17833ne1) : C3419Au3.t1(c3419Au3, null, 1, null);
        C3419Au3 c3419Au3A0 = c3419Au3.A0();
        if (zS1 && c3419Au3A0 != null) {
            if (c3419Au3.p0() == C3419Au3.g.a) {
                C3419Au3.F1(c3419Au3A0, false, false, false, 3, null);
            } else if (c3419Au3.p0() == C3419Au3.g.b) {
                C3419Au3.D1(c3419Au3A0, false, 1, null);
            }
        }
        return zS1;
    }

    private final void g() {
        if (this.h.o() != 0) {
            C12544en4 c12544en4 = this.h;
            Object[] objArr = c12544en4.a;
            int iO = c12544en4.o();
            for (int i = 0; i < iO; i++) {
                a aVar = (a) objArr[i];
                if (aVar.a().b()) {
                    if (aVar.c()) {
                        C3419Au3.B1(aVar.a(), aVar.b(), false, false, 2, null);
                    } else {
                        C3419Au3.F1(aVar.a(), aVar.b(), false, false, 2, null);
                    }
                }
            }
            this.h.k();
        }
    }

    private final void h(C3419Au3 c3419Au3) {
        C12544en4 c12544en4G0 = c3419Au3.G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au32 = (C3419Au3) objArr[i];
            if (AbstractC13042fc3.d(c3419Au32.U0(), Boolean.TRUE) && !c3419Au32.u()) {
                if (this.b.e(c3419Au32, true)) {
                    c3419Au32.Y0();
                }
                h(c3419Au32);
            }
        }
    }

    private final void j(C3419Au3 c3419Au3, boolean z) {
        C12544en4 c12544en4G0 = c3419Au3.G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au32 = (C3419Au3) objArr[i];
            if ((!z && p(c3419Au32)) || (z && q(c3419Au32))) {
                if (AbstractC4843Gu3.a(c3419Au32) && !z) {
                    if (c3419Au32.i0() && this.b.e(c3419Au32, true)) {
                        z(c3419Au32, true, false);
                    } else {
                        i(c3419Au32, true);
                    }
                }
                y(c3419Au32, z);
                if (!w(c3419Au32, z)) {
                    j(c3419Au32, z);
                }
            }
        }
        y(c3419Au3, z);
    }

    private final boolean k(C3419Au3 c3419Au3) {
        return c3419Au3.i0() && q(c3419Au3);
    }

    private final boolean l(C3419Au3 c3419Au3) {
        return c3419Au3.n0() && r(c3419Au3);
    }

    private final boolean p(C3419Au3 c3419Au3) {
        return c3419Au3.p0() == C3419Au3.g.a || c3419Au3.e0().c().t().k();
    }

    private final boolean q(C3419Au3 c3419Au3) {
        AbstractC14349hm abstractC14349hmT;
        if (c3419Au3.q0() == C3419Au3.g.a) {
            return true;
        }
        InterfaceC14957im interfaceC14957imP = c3419Au3.e0().p();
        return (interfaceC14957imP == null || (abstractC14349hmT = interfaceC14957imP.t()) == null || !abstractC14349hmT.k()) ? false : true;
    }

    private final boolean r(C3419Au3 c3419Au3) {
        do {
            if (!p(c3419Au3)) {
                C3419Au3 c3419Au3A0 = c3419Au3.A0();
                if ((c3419Au3A0 != null ? c3419Au3A0.g0() : null) != C3419Au3.e.a) {
                    return false;
                }
            }
            c3419Au3 = c3419Au3.A0();
            if (c3419Au3 == null) {
                return false;
            }
        } while (!c3419Au3.o());
        return true;
    }

    private final boolean w(C3419Au3 c3419Au3, boolean z) {
        return z ? c3419Au3.i0() : c3419Au3.n0();
    }

    private final void y(C3419Au3 c3419Au3, boolean z) {
        if (w(c3419Au3, z)) {
            z(c3419Au3, z, false);
        }
    }

    private final boolean z(C3419Au3 c3419Au3, boolean z, boolean z2) {
        C17833ne1 c17833ne1;
        C3419Au3 c3419Au3A0;
        if (c3419Au3.u()) {
            return false;
        }
        if (c3419Au3.o() || c3419Au3.T0() || l(c3419Au3) || AbstractC13042fc3.d(c3419Au3.U0(), Boolean.TRUE) || k(c3419Au3) || c3419Au3.M()) {
            if (c3419Au3 == this.a) {
                c17833ne1 = this.i;
                AbstractC13042fc3.f(c17833ne1);
            } else {
                c17833ne1 = null;
            }
            if (z) {
                zE = c3419Au3.i0() ? e(c3419Au3, c17833ne1) : false;
                if (z2 && ((zE || c3419Au3.h0()) && AbstractC13042fc3.d(c3419Au3.U0(), Boolean.TRUE))) {
                    c3419Au3.Y0();
                }
            } else {
                boolean zF = c3419Au3.n0() ? f(c3419Au3, c17833ne1) : false;
                if (z2 && c3419Au3.f0() && (c3419Au3 == this.a || ((c3419Au3A0 = c3419Au3.A0()) != null && c3419Au3A0.o() && c3419Au3.T0()))) {
                    if (c3419Au3 == this.a) {
                        c3419Au3.q1(0, 0);
                    } else {
                        c3419Au3.w1();
                    }
                    this.e.d(c3419Au3);
                    AbstractC4360Eu3.b(c3419Au3).getRectManager().i(c3419Au3);
                    C7457Ru3 c7457Ru3 = this.j;
                    if (c7457Ru3 != null) {
                        c7457Ru3.a();
                    }
                }
                zE = zF;
            }
            g();
        }
        return zE;
    }

    public final boolean D(C3419Au3 c3419Au3, boolean z) {
        int i = b.a[c3419Au3.g0().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 && i != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            if ((c3419Au3.i0() || c3419Au3.h0()) && !z) {
                C7457Ru3 c7457Ru3 = this.j;
                if (c7457Ru3 == null) {
                    return false;
                }
                c7457Ru3.a();
                return false;
            }
            c3419Au3.b1();
            c3419Au3.a1();
            if (c3419Au3.u()) {
                return false;
            }
            C3419Au3 c3419Au3A0 = c3419Au3.A0();
            if (AbstractC13042fc3.d(c3419Au3.U0(), Boolean.TRUE) && ((c3419Au3A0 == null || !c3419Au3A0.i0()) && (c3419Au3A0 == null || !c3419Au3A0.h0()))) {
                this.b.c(c3419Au3, true);
            } else if (c3419Au3.o() && ((c3419Au3A0 == null || !c3419Au3A0.f0()) && (c3419Au3A0 == null || !c3419Au3A0.n0()))) {
                this.b.c(c3419Au3, false);
            }
            return !this.d;
        }
        C7457Ru3 c7457Ru32 = this.j;
        if (c7457Ru32 == null) {
            return false;
        }
        c7457Ru32.a();
        return false;
    }

    public final boolean E(C3419Au3 c3419Au3, boolean z) {
        C3419Au3 c3419Au3A0;
        C3419Au3 c3419Au3A02;
        if (!(c3419Au3.k0() != null)) {
            M73.b("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        int i = b.a[c3419Au3.g0().ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2 || i == 3 || i == 4) {
            this.h.d(new a(c3419Au3, true, z));
            C7457Ru3 c7457Ru3 = this.j;
            if (c7457Ru3 == null) {
                return false;
            }
            c7457Ru3.a();
            return false;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        if (c3419Au3.i0() && !z) {
            return false;
        }
        c3419Au3.c1();
        c3419Au3.d1();
        if (c3419Au3.u()) {
            return false;
        }
        if ((AbstractC13042fc3.d(c3419Au3.U0(), Boolean.TRUE) || k(c3419Au3)) && ((c3419Au3A0 = c3419Au3.A0()) == null || !c3419Au3A0.i0())) {
            this.b.c(c3419Au3, true);
        } else if ((c3419Au3.o() || l(c3419Au3)) && ((c3419Au3A02 = c3419Au3.A0()) == null || !c3419Au3A02.n0())) {
            this.b.c(c3419Au3, false);
        }
        return !this.d;
    }

    public final void F(C3419Au3 c3419Au3) {
        this.e.d(c3419Au3);
    }

    public final boolean G(C3419Au3 c3419Au3, boolean z) {
        int i = b.a[c3419Au3.g0().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            C7457Ru3 c7457Ru3 = this.j;
            if (c7457Ru3 != null) {
                c7457Ru3.a();
            }
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            C3419Au3 c3419Au3A0 = c3419Au3.A0();
            boolean z2 = c3419Au3A0 == null || c3419Au3A0.o();
            if (z || !(c3419Au3.n0() || (c3419Au3.f0() && c3419Au3.o() == z2 && c3419Au3.o() == c3419Au3.T0()))) {
                c3419Au3.a1();
                if (!c3419Au3.u() && c3419Au3.T0() && z2) {
                    if ((c3419Au3A0 == null || !c3419Au3A0.f0()) && (c3419Au3A0 == null || !c3419Au3A0.n0())) {
                        this.b.c(c3419Au3, false);
                    }
                    if (!this.d) {
                        return true;
                    }
                }
            } else {
                C7457Ru3 c7457Ru32 = this.j;
                if (c7457Ru32 != null) {
                    c7457Ru32.a();
                }
            }
        }
        return false;
    }

    public final boolean H(C3419Au3 c3419Au3, boolean z) {
        int i = b.a[c3419Au3.g0().ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3 || i == 4) {
                this.h.d(new a(c3419Au3, false, z));
                C7457Ru3 c7457Ru3 = this.j;
                if (c7457Ru3 != null) {
                    c7457Ru3.a();
                }
            } else {
                if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!c3419Au3.n0() || z) {
                    c3419Au3.d1();
                    if (!c3419Au3.u() && (c3419Au3.o() || l(c3419Au3))) {
                        C3419Au3 c3419Au3A0 = c3419Au3.A0();
                        if (c3419Au3A0 == null || !c3419Au3A0.n0()) {
                            this.b.c(c3419Au3, false);
                        }
                        if (!this.d) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void J(long j) {
        C17833ne1 c17833ne1 = this.i;
        if (c17833ne1 == null ? false : C17833ne1.f(c17833ne1.r(), j)) {
            return;
        }
        if (!(!this.c)) {
            M73.a("updateRootConstraints called while measuring");
        }
        this.i = C17833ne1.a(j);
        if (this.a.k0() != null) {
            this.a.c1();
        }
        this.a.d1();
        C17631nI1 c17631nI1 = this.b;
        C3419Au3 c3419Au3 = this.a;
        c17631nI1.c(c3419Au3, c3419Au3.k0() != null);
    }

    public final void c(boolean z) {
        if (z) {
            this.e.e(this.a);
        }
        this.e.a();
    }

    public final void i(C3419Au3 c3419Au3, boolean z) {
        if (!this.c) {
            M73.b("forceMeasureTheSubtree should be executed during the measureAndLayout pass");
        }
        if (!(!w(c3419Au3, z))) {
            M73.a("node not yet measured");
        }
        j(c3419Au3, z);
    }

    public final boolean m() {
        return this.c;
    }

    public final boolean n() {
        return this.b.h();
    }

    public final boolean o() {
        return this.e.c();
    }

    public final long s() {
        if (!this.c) {
            M73.a("measureIteration should be only used during the measure/layout pass");
        }
        return this.g;
    }

    public final boolean t(SA2 sa2) {
        boolean z;
        if (!this.a.b()) {
            M73.a("performMeasureAndLayout called with unattached root");
        }
        if (!this.a.o()) {
            M73.a("performMeasureAndLayout called with unplaced root");
        }
        if (!(!this.c)) {
            M73.a("performMeasureAndLayout called during measure layout");
        }
        boolean z2 = false;
        if (this.i != null) {
            this.c = true;
            this.d = true;
            try {
                if (this.b.h()) {
                    C17631nI1 c17631nI1 = this.b;
                    z = false;
                    while (c17631nI1.h()) {
                        boolean z3 = !c17631nI1.a.c();
                        C3419Au3 c3419Au3D = (z3 ? c17631nI1.a : c17631nI1.b).d();
                        boolean zA = A(this, c3419Au3D, z3, false, 4, null);
                        if (c3419Au3D == this.a && zA) {
                            z = true;
                        }
                    }
                    if (sa2 != null) {
                        sa2.invoke();
                    }
                } else {
                    z = false;
                }
                this.c = false;
                this.d = false;
                C7457Ru3 c7457Ru3 = this.j;
                if (c7457Ru3 != null) {
                    c7457Ru3.a();
                }
                z2 = z;
            } catch (Throwable th) {
                this.c = false;
                this.d = false;
                throw th;
            }
        }
        b();
        return z2;
    }

    public final void u(C3419Au3 c3419Au3, long j) {
        if (c3419Au3.u()) {
            return;
        }
        if (!(!AbstractC13042fc3.d(c3419Au3, this.a))) {
            M73.a("measureAndLayout called on root");
        }
        if (!this.a.b()) {
            M73.a("performMeasureAndLayout called with unattached root");
        }
        if (!this.a.o()) {
            M73.a("performMeasureAndLayout called with unplaced root");
        }
        if (!(!this.c)) {
            M73.a("performMeasureAndLayout called during measure layout");
        }
        if (this.i != null) {
            this.c = true;
            this.d = false;
            try {
                this.b.i(c3419Au3);
                if (e(c3419Au3, C17833ne1.a(j)) || c3419Au3.h0()) {
                    if (AbstractC13042fc3.d(c3419Au3.U0(), Boolean.TRUE)) {
                        c3419Au3.Y0();
                    }
                }
                h(c3419Au3);
                f(c3419Au3, C17833ne1.a(j));
                if (c3419Au3.f0() && c3419Au3.o()) {
                    c3419Au3.w1();
                    this.e.d(c3419Au3);
                }
                g();
                this.c = false;
                this.d = false;
                C7457Ru3 c7457Ru3 = this.j;
                if (c7457Ru3 != null) {
                    c7457Ru3.a();
                }
            } catch (Throwable th) {
                this.c = false;
                this.d = false;
                throw th;
            }
        }
        b();
    }

    public final void v() {
        if (this.b.h()) {
            if (!this.a.b()) {
                M73.a("performMeasureAndLayout called with unattached root");
            }
            if (!this.a.o()) {
                M73.a("performMeasureAndLayout called with unplaced root");
            }
            if (!(!this.c)) {
                M73.a("performMeasureAndLayout called during measure layout");
            }
            if (this.i != null) {
                this.c = true;
                this.d = false;
                try {
                    if (!this.b.g(true)) {
                        if (this.a.k0() != null) {
                            C(this.a, true);
                        } else {
                            B(this.a);
                        }
                    }
                    C(this.a, false);
                    this.c = false;
                    this.d = false;
                    C7457Ru3 c7457Ru3 = this.j;
                    if (c7457Ru3 != null) {
                        c7457Ru3.a();
                    }
                } catch (Throwable th) {
                    this.c = false;
                    this.d = false;
                    throw th;
                }
            }
        }
    }

    public final void x(C3419Au3 c3419Au3) {
        this.b.i(c3419Au3);
        this.e.f(c3419Au3);
    }
}
