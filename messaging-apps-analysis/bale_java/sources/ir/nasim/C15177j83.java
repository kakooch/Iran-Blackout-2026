package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C3419Au3;

/* renamed from: ir.nasim.j83, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15177j83 extends XA4 {
    public static final a O0 = new a(null);
    private static final InterfaceC12969fU4 P0;
    private final C16707lj7 M0;
    private DJ3 N0;

    /* renamed from: ir.nasim.j83$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.j83$b */
    private final class b extends DJ3 {
        public b() {
            super(C15177j83.this);
        }

        @Override // ir.nasim.DJ3, ir.nasim.InterfaceC9236Zb3
        public int Z(int i) {
            return G1().k1(i);
        }

        @Override // ir.nasim.BJ3
        public int e1(AbstractC13165fm abstractC13165fm) {
            Integer num = (Integer) a2().C().get(abstractC13165fm);
            int iIntValue = num != null ? num.intValue() : RecyclerView.UNDEFINED_DURATION;
            c2().u(abstractC13165fm, iIntValue);
            return iIntValue;
        }

        @Override // ir.nasim.DJ3
        protected void g2() {
            GJ3 gj3J0 = G1().j0();
            AbstractC13042fc3.f(gj3J0);
            gj3J0.e2();
        }

        @Override // ir.nasim.DJ3, ir.nasim.InterfaceC9236Zb3
        public int i0(int i) {
            return G1().l1(i);
        }

        @Override // ir.nasim.DJ3, ir.nasim.InterfaceC9236Zb3
        public int k0(int i) {
            return G1().h1(i);
        }

        @Override // ir.nasim.ZV3
        public AbstractC21430te5 l0(long j) {
            b1(j);
            C12544en4 c12544en4G0 = G1().G0();
            Object[] objArr = c12544en4G0.a;
            int iO = c12544en4G0.o();
            for (int i = 0; i < iO; i++) {
                GJ3 gj3J0 = ((C3419Au3) objArr[i]).j0();
                AbstractC13042fc3.f(gj3J0);
                gj3J0.o2(C3419Au3.g.c);
            }
            l2(G1().o0().b(this, G1().P(), j));
            return this;
        }

        @Override // ir.nasim.DJ3, ir.nasim.InterfaceC9236Zb3
        public int z(int i) {
            return G1().g1(i);
        }
    }

    static {
        InterfaceC12969fU4 interfaceC12969fU4A = AbstractC15587jq.a();
        interfaceC12969fU4A.k(C24381yX0.b.g());
        interfaceC12969fU4A.w(1.0f);
        interfaceC12969fU4A.v(VV4.a.b());
        P0 = interfaceC12969fU4A;
    }

    public C15177j83(C3419Au3 c3419Au3) {
        super(c3419Au3);
        this.M0 = new C16707lj7();
        J2().u2(this);
        this.N0 = c3419Au3.k0() != null ? new b() : null;
    }

    private final void J3() {
        if (S1()) {
            return;
        }
        G1().m0().i2();
    }

    @Override // ir.nasim.XA4
    public DJ3 E2() {
        return this.N0;
    }

    @Override // ir.nasim.XA4
    /* renamed from: I3, reason: merged with bridge method [inline-methods] */
    public C16707lj7 J2() {
        return this.M0;
    }

    protected void K3(DJ3 dj3) {
        this.N0 = dj3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // ir.nasim.XA4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void T2(ir.nasim.XA4.f r18, long r19, ir.nasim.C18367oY2 r21, int r22, boolean r23) {
        /*
            r17 = this;
            r0 = r17
            r8 = r19
            ir.nasim.Au3 r1 = r17.G1()
            r10 = r18
            boolean r1 = r10.c(r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L42
            boolean r1 = r0.H3(r8)
            if (r1 == 0) goto L1e
            r11 = r22
            r12 = r23
        L1c:
            r3 = r2
            goto L46
        L1e:
            ir.nasim.dh5$a r1 = ir.nasim.AbstractC11873dh5.a
            int r1 = r1.d()
            r11 = r22
            boolean r1 = ir.nasim.AbstractC11873dh5.g(r11, r1)
            if (r1 == 0) goto L44
            long r4 = r17.F2()
            float r1 = r0.p2(r8, r4)
            int r1 = java.lang.Float.floatToRawIntBits(r1)
            r4 = 2147483647(0x7fffffff, float:NaN)
            r1 = r1 & r4
            r4 = 2139095040(0x7f800000, float:Infinity)
            if (r1 >= r4) goto L44
            r12 = r3
            goto L1c
        L42:
            r11 = r22
        L44:
            r12 = r23
        L46:
            if (r3 == 0) goto L96
            int r13 = ir.nasim.C18367oY2.i(r21)
            ir.nasim.Au3 r1 = r17.G1()
            ir.nasim.en4 r1 = r1.F0()
            java.lang.Object[] r14 = r1.a
            int r1 = r1.o()
            int r1 = r1 - r2
            r15 = r1
        L5c:
            if (r15 < 0) goto L8d
            r1 = r14[r15]
            r16 = r1
            ir.nasim.Au3 r16 = (ir.nasim.C3419Au3) r16
            boolean r1 = r16.o()
            if (r1 == 0) goto L90
            r1 = r18
            r2 = r16
            r3 = r19
            r5 = r21
            r6 = r22
            r7 = r12
            r1.d(r2, r3, r5, r6, r7)
            boolean r1 = r21.C()
            if (r1 != 0) goto L7f
            goto L90
        L7f:
            ir.nasim.XA4 r1 = r16.w0()
            boolean r1 = r1.v3()
            if (r1 == 0) goto L8d
            r21.f()
            goto L90
        L8d:
            r1 = r21
            goto L93
        L90:
            int r15 = r15 + (-1)
            goto L5c
        L93:
            ir.nasim.C18367oY2.t(r1, r13)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15177j83.T2(ir.nasim.XA4$f, long, ir.nasim.oY2, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.XA4, ir.nasim.AbstractC21430te5
    public void U0(long j, float f, UA2 ua2) {
        super.U0(j, f, ua2);
        J3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.XA4, ir.nasim.AbstractC21430te5
    public void W0(long j, float f, C21226tK2 c21226tK2) {
        super.W0(j, f, c21226tK2);
        J3();
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int Z(int i) {
        return G1().i1(i);
    }

    @Override // ir.nasim.BJ3
    public int e1(AbstractC13165fm abstractC13165fm) {
        DJ3 dj3E2 = E2();
        if (dj3E2 != null) {
            return dj3E2.e1(abstractC13165fm);
        }
        Integer num = (Integer) y2().C().get(abstractC13165fm);
        return num != null ? num.intValue() : RecyclerView.UNDEFINED_DURATION;
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int i0(int i) {
        return G1().j1(i);
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int k0(int i) {
        return G1().f1(i);
    }

    @Override // ir.nasim.XA4
    public void k3(UE0 ue0, C21226tK2 c21226tK2) {
        InterfaceC23714xO4 interfaceC23714xO4B = AbstractC4360Eu3.b(G1());
        C12544en4 c12544en4F0 = G1().F0();
        Object[] objArr = c12544en4F0.a;
        int iO = c12544en4F0.o();
        for (int i = 0; i < iO; i++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i];
            if (c3419Au3.o()) {
                c3419Au3.K(ue0, c21226tK2);
            }
        }
        if (interfaceC23714xO4B.getShowLayoutBounds()) {
            r2(ue0, P0);
        }
    }

    @Override // ir.nasim.ZV3
    public AbstractC21430te5 l0(long j) {
        if (A2()) {
            DJ3 dj3E2 = E2();
            AbstractC13042fc3.f(dj3E2);
            j = dj3E2.d2();
        }
        b1(j);
        C12544en4 c12544en4G0 = G1().G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i = 0; i < iO; i++) {
            ((C3419Au3) objArr[i]).m0().q2(C3419Au3.g.c);
        }
        r3(G1().o0().b(this, G1().Q(), j));
        f3();
        return this;
    }

    @Override // ir.nasim.XA4
    public void t2() {
        if (E2() == null) {
            K3(new b());
        }
    }

    @Override // ir.nasim.InterfaceC9236Zb3
    public int z(int i) {
        return G1().e1(i);
    }
}
