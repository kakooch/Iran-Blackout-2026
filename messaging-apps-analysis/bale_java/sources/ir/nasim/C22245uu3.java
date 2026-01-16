package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.uu3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22245uu3 extends XA4 {
    public static final a Q0 = new a(null);
    private static final InterfaceC12969fU4 R0;
    private InterfaceC21655tu3 M0;
    private C17833ne1 N0;
    private DJ3 O0;
    private C17611nG P0;

    /* renamed from: ir.nasim.uu3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.uu3$b */
    private final class b extends DJ3 {
        public b() {
            super(C22245uu3.this);
        }

        @Override // ir.nasim.DJ3, ir.nasim.InterfaceC9236Zb3
        public int Z(int i) {
            InterfaceC21655tu3 interfaceC21655tu3J3 = C22245uu3.this.J3();
            DJ3 dj3E2 = C22245uu3.this.K3().E2();
            AbstractC13042fc3.f(dj3E2);
            return interfaceC21655tu3J3.J(this, dj3E2, i);
        }

        @Override // ir.nasim.BJ3
        public int e1(AbstractC13165fm abstractC13165fm) {
            int iB = AbstractC22841vu3.b(this, abstractC13165fm);
            c2().u(abstractC13165fm, iB);
            return iB;
        }

        @Override // ir.nasim.DJ3, ir.nasim.InterfaceC9236Zb3
        public int i0(int i) {
            InterfaceC21655tu3 interfaceC21655tu3J3 = C22245uu3.this.J3();
            DJ3 dj3E2 = C22245uu3.this.K3().E2();
            AbstractC13042fc3.f(dj3E2);
            return interfaceC21655tu3J3.p(this, dj3E2, i);
        }

        @Override // ir.nasim.DJ3, ir.nasim.InterfaceC9236Zb3
        public int k0(int i) {
            InterfaceC21655tu3 interfaceC21655tu3J3 = C22245uu3.this.J3();
            DJ3 dj3E2 = C22245uu3.this.K3().E2();
            AbstractC13042fc3.f(dj3E2);
            return interfaceC21655tu3J3.z(this, dj3E2, i);
        }

        @Override // ir.nasim.ZV3
        public AbstractC21430te5 l0(long j) {
            C22245uu3 c22245uu3 = C22245uu3.this;
            b1(j);
            c22245uu3.N3(C17833ne1.a(j));
            InterfaceC21655tu3 interfaceC21655tu3J3 = c22245uu3.J3();
            DJ3 dj3E2 = c22245uu3.K3().E2();
            AbstractC13042fc3.f(dj3E2);
            l2(interfaceC21655tu3J3.b(this, dj3E2, j));
            return this;
        }

        @Override // ir.nasim.DJ3, ir.nasim.InterfaceC9236Zb3
        public int z(int i) {
            InterfaceC21655tu3 interfaceC21655tu3J3 = C22245uu3.this.J3();
            DJ3 dj3E2 = C22245uu3.this.K3().E2();
            AbstractC13042fc3.f(dj3E2);
            return interfaceC21655tu3J3.F(this, dj3E2, i);
        }
    }

    static {
        InterfaceC12969fU4 interfaceC12969fU4A = AbstractC15587jq.a();
        interfaceC12969fU4A.k(C24381yX0.b.b());
        interfaceC12969fU4A.w(1.0f);
        interfaceC12969fU4A.v(VV4.a.b());
        R0 = interfaceC12969fU4A;
    }

    public C22245uu3(C3419Au3 c3419Au3, InterfaceC21655tu3 interfaceC21655tu3) {
        super(c3419Au3);
        this.M0 = interfaceC21655tu3;
        C17611nG c17611nG = null;
        this.O0 = c3419Au3.k0() != null ? new b() : null;
        if ((interfaceC21655tu3.h().W1() & AbstractC9572aB4.a(512)) != 0) {
            AbstractC13042fc3.g(interfaceC21655tu3, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
            AbstractC18350oW3.a(interfaceC21655tu3);
            c17611nG = new C17611nG(this, null);
        }
        this.P0 = c17611nG;
    }

    private final void L3() {
        if (S1()) {
            return;
        }
        g3();
        C17611nG c17611nG = this.P0;
        if (c17611nG == null) {
            q1().j();
            K3().q3(false);
            return;
        }
        c17611nG.b();
        D1();
        DJ3 dj3E2 = E2();
        AbstractC13042fc3.f(dj3E2);
        dj3E2.f2();
        throw null;
    }

    @Override // ir.nasim.XA4
    public DJ3 E2() {
        return this.O0;
    }

    @Override // ir.nasim.XA4
    public e.c J2() {
        return this.M0.h();
    }

    public final InterfaceC21655tu3 J3() {
        return this.M0;
    }

    public final XA4 K3() {
        XA4 xa4K2 = K2();
        AbstractC13042fc3.f(xa4K2);
        return xa4K2;
    }

    public final void M3(InterfaceC21655tu3 interfaceC21655tu3) {
        if (!AbstractC13042fc3.d(interfaceC21655tu3, this.M0)) {
            e.c cVarH = interfaceC21655tu3.h();
            if ((cVarH.W1() & AbstractC9572aB4.a(512)) != 0) {
                AbstractC13042fc3.g(interfaceC21655tu3, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
                AbstractC18350oW3.a(interfaceC21655tu3);
                C17611nG c17611nG = this.P0;
                if (c17611nG != null) {
                    AbstractC18350oW3.a(interfaceC21655tu3);
                    c17611nG.p(null);
                } else {
                    AbstractC18350oW3.a(interfaceC21655tu3);
                    c17611nG = new C17611nG(this, null);
                }
                this.P0 = c17611nG;
            } else {
                this.P0 = null;
            }
        }
        this.M0 = interfaceC21655tu3;
    }

    public final void N3(C17833ne1 c17833ne1) {
        this.N0 = c17833ne1;
    }

    protected void O3(DJ3 dj3) {
        this.O0 = dj3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.XA4, ir.nasim.AbstractC21430te5
    public void U0(long j, float f, UA2 ua2) {
        super.U0(j, f, ua2);
        L3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.XA4, ir.nasim.AbstractC21430te5
    public void W0(long j, float f, C21226tK2 c21226tK2) {
        super.W0(j, f, c21226tK2);
        L3();
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int Z(int i) {
        C17611nG c17611nG = this.P0;
        if (c17611nG == null) {
            return this.M0.J(this, K3(), i);
        }
        c17611nG.b();
        K3();
        throw null;
    }

    @Override // ir.nasim.BJ3
    public int e1(AbstractC13165fm abstractC13165fm) {
        DJ3 dj3E2 = E2();
        return dj3E2 != null ? dj3E2.b2(abstractC13165fm) : AbstractC22841vu3.b(this, abstractC13165fm);
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int i0(int i) {
        C17611nG c17611nG = this.P0;
        if (c17611nG == null) {
            return this.M0.p(this, K3(), i);
        }
        c17611nG.b();
        K3();
        throw null;
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int k0(int i) {
        C17611nG c17611nG = this.P0;
        if (c17611nG == null) {
            return this.M0.z(this, K3(), i);
        }
        c17611nG.b();
        K3();
        throw null;
    }

    @Override // ir.nasim.XA4
    public void k3(UE0 ue0, C21226tK2 c21226tK2) {
        K3().q2(ue0, c21226tK2);
        if (AbstractC4360Eu3.b(G1()).getShowLayoutBounds()) {
            r2(ue0, R0);
        }
    }

    @Override // ir.nasim.ZV3
    public AbstractC21430te5 l0(long j) {
        if (A2()) {
            C17833ne1 c17833ne1 = this.N0;
            if (c17833ne1 == null) {
                throw new IllegalArgumentException("Lookahead constraints cannot be null in approach pass.".toString());
            }
            j = c17833ne1.r();
        }
        b1(j);
        C17611nG c17611nG = this.P0;
        if (c17611nG == null) {
            r3(J3().b(this, K3(), j));
            f3();
            return this;
        }
        c17611nG.b();
        c17611nG.o();
        throw null;
    }

    @Override // ir.nasim.XA4
    public void t2() {
        if (E2() == null) {
            O3(new b());
        }
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int z(int i) {
        C17611nG c17611nG = this.P0;
        if (c17611nG == null) {
            return this.M0.F(this, K3(), i);
        }
        c17611nG.b();
        K3();
        throw null;
    }
}
