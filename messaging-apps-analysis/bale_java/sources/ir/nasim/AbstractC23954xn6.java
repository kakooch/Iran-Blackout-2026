package ir.nasim;

import ir.nasim.C19701qn6;

/* renamed from: ir.nasim.xn6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC23954xn6 {

    /* renamed from: ir.nasim.xn6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C8329Vm6 e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ InterfaceC4066Dn6 h;
        final /* synthetic */ InterfaceC9173Yu3 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C8329Vm6 c8329Vm6, int i, int i2, InterfaceC4066Dn6 interfaceC4066Dn6, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = c8329Vm6;
            this.f = i;
            this.g = i2;
            this.h = interfaceC4066Dn6;
            this.i = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19701qn6.a invoke() {
            return AbstractC23954xn6.k(this.e, AbstractC23954xn6.m(this.i), this.f, this.g, this.h.a(), this.h.e() == EnumC5309Iu1.a);
        }
    }

    /* renamed from: ir.nasim.xn6$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C8329Vm6 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C8329Vm6 c8329Vm6, int i) {
            super(0);
            this.e = c8329Vm6;
            this.f = i;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(this.e.k().q(this.f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19701qn6 e(InterfaceC4066Dn6 interfaceC4066Dn6, InterfaceC25102zk0 interfaceC25102zk0) {
        boolean z = interfaceC4066Dn6.e() == EnumC5309Iu1.a;
        return new C19701qn6(f(interfaceC4066Dn6.k(), z, true, interfaceC4066Dn6.l(), interfaceC25102zk0), f(interfaceC4066Dn6.j(), z, false, interfaceC4066Dn6.d(), interfaceC25102zk0), z);
    }

    private static final C19701qn6.a f(C8329Vm6 c8329Vm6, boolean z, boolean z2, int i, InterfaceC25102zk0 interfaceC25102zk0) {
        int iG = z2 ? c8329Vm6.g() : c8329Vm6.e();
        if (i != c8329Vm6.i()) {
            return c8329Vm6.a(iG);
        }
        long jA = interfaceC25102zk0.a(c8329Vm6, iG);
        return c8329Vm6.a(z ^ z2 ? C4301En7.n(jA) : C4301En7.i(jA));
    }

    private static final C19701qn6.a g(C19701qn6.a aVar, C8329Vm6 c8329Vm6, int i) {
        return C19701qn6.a.b(aVar, c8329Vm6.k().c(i), i, 0L, 4, null);
    }

    public static final C19701qn6 h(C19701qn6 c19701qn6, InterfaceC4066Dn6 interfaceC4066Dn6) {
        if (AbstractC4300En6.d(c19701qn6, interfaceC4066Dn6)) {
            return (interfaceC4066Dn6.f() > 1 || interfaceC4066Dn6.i() == null || interfaceC4066Dn6.b().c().length() == 0) ? c19701qn6 : i(c19701qn6, interfaceC4066Dn6);
        }
        return c19701qn6;
    }

    private static final C19701qn6 i(C19701qn6 c19701qn6, InterfaceC4066Dn6 interfaceC4066Dn6) {
        C8329Vm6 c8329Vm6B = interfaceC4066Dn6.b();
        String strC = c8329Vm6B.c();
        int iG = c8329Vm6B.g();
        int length = strC.length();
        if (iG == 0) {
            int iA = JY6.a(strC, 0);
            return interfaceC4066Dn6.a() ? C19701qn6.b(c19701qn6, g(c19701qn6.e(), c8329Vm6B, iA), null, true, 2, null) : C19701qn6.b(c19701qn6, null, g(c19701qn6.c(), c8329Vm6B, iA), false, 1, null);
        }
        if (iG == length) {
            int iB = JY6.b(strC, length);
            return interfaceC4066Dn6.a() ? C19701qn6.b(c19701qn6, g(c19701qn6.e(), c8329Vm6B, iB), null, false, 2, null) : C19701qn6.b(c19701qn6, null, g(c19701qn6.c(), c8329Vm6B, iB), true, 1, null);
        }
        C19701qn6 c19701qn6I = interfaceC4066Dn6.i();
        boolean z = c19701qn6I != null && c19701qn6I.d();
        int iB2 = interfaceC4066Dn6.a() ^ z ? JY6.b(strC, iG) : JY6.a(strC, iG);
        return interfaceC4066Dn6.a() ? C19701qn6.b(c19701qn6, g(c19701qn6.e(), c8329Vm6B, iB2), null, z, 2, null) : C19701qn6.b(c19701qn6, null, g(c19701qn6.c(), c8329Vm6B, iB2), z, 1, null);
    }

    private static final boolean j(C8329Vm6 c8329Vm6, int i, boolean z) {
        if (c8329Vm6.f() == -1) {
            return true;
        }
        if (i == c8329Vm6.f()) {
            return false;
        }
        if (z ^ (c8329Vm6.d() == EnumC5309Iu1.a)) {
            if (i < c8329Vm6.f()) {
                return true;
            }
        } else if (i > c8329Vm6.f()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19701qn6.a k(C8329Vm6 c8329Vm6, int i, int i2, int i3, boolean z, boolean z2) {
        long jC = c8329Vm6.k().C(i2);
        int iN = c8329Vm6.k().q(C4301En7.n(jC)) == i ? C4301En7.n(jC) : i >= c8329Vm6.k().n() ? c8329Vm6.k().u(c8329Vm6.k().n() - 1) : c8329Vm6.k().u(i);
        int i4 = c8329Vm6.k().q(C4301En7.i(jC)) == i ? C4301En7.i(jC) : i >= c8329Vm6.k().n() ? C13774gn7.p(c8329Vm6.k(), c8329Vm6.k().n() - 1, false, 2, null) : C13774gn7.p(c8329Vm6.k(), i, false, 2, null);
        if (iN == i3) {
            return c8329Vm6.a(i4);
        }
        if (i4 == i3) {
            return c8329Vm6.a(iN);
        }
        if (!(z ^ z2) ? i2 >= iN : i2 > i4) {
            iN = i4;
        }
        return c8329Vm6.a(iN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19701qn6.a l(InterfaceC4066Dn6 interfaceC4066Dn6, C8329Vm6 c8329Vm6, C19701qn6.a aVar) {
        int iG = interfaceC4066Dn6.a() ? c8329Vm6.g() : c8329Vm6.e();
        if ((interfaceC4066Dn6.a() ? interfaceC4066Dn6.l() : interfaceC4066Dn6.d()) != c8329Vm6.i()) {
            return c8329Vm6.a(iG);
        }
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(enumC4870Gx3, new b(c8329Vm6, iG));
        InterfaceC9173Yu3 interfaceC9173Yu3B2 = AbstractC13269fw3.b(enumC4870Gx3, new a(c8329Vm6, iG, interfaceC4066Dn6.a() ? c8329Vm6.e() : c8329Vm6.g(), interfaceC4066Dn6, interfaceC9173Yu3B));
        if (c8329Vm6.h() != aVar.d()) {
            return n(interfaceC9173Yu3B2);
        }
        int iF = c8329Vm6.f();
        if (iG == iF) {
            return aVar;
        }
        if (m(interfaceC9173Yu3B) != c8329Vm6.k().q(iF)) {
            return n(interfaceC9173Yu3B2);
        }
        int iC = aVar.c();
        long jC = c8329Vm6.k().C(iC);
        return !j(c8329Vm6, iG, interfaceC4066Dn6.a()) ? c8329Vm6.a(iG) : (iC == C4301En7.n(jC) || iC == C4301En7.i(jC)) ? n(interfaceC9173Yu3B2) : c8329Vm6.a(iG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(InterfaceC9173Yu3 interfaceC9173Yu3) {
        return ((Number) interfaceC9173Yu3.getValue()).intValue();
    }

    private static final C19701qn6.a n(InterfaceC9173Yu3 interfaceC9173Yu3) {
        return (C19701qn6.a) interfaceC9173Yu3.getValue();
    }
}
