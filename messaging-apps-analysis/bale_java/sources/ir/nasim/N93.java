package ir.nasim;

import ir.nasim.AbstractC21430te5;

/* loaded from: classes.dex */
public final class N93 implements InterfaceC20377ru3, InterfaceC20236rg4, InterfaceC23882xg4 {
    private final A98 b;
    private final InterfaceC9102Ym4 c;
    private final InterfaceC9102Ym4 d;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC21430te5 abstractC21430te5, int i, int i2) {
            super(1);
            this.e = abstractC21430te5;
            this.f = i;
            this.g = i2;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.h(aVar, this.e, this.f, this.g, 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public N93(A98 a98) {
        this.b = a98;
        this.c = AbstractC13472gH6.d(a98, null, 2, null);
        this.d = AbstractC13472gH6.d(a98, null, 2, null);
    }

    private final A98 f() {
        return (A98) this.d.getValue();
    }

    private final A98 k() {
        return (A98) this.c.getValue();
    }

    private final void m(A98 a98) {
        this.d.setValue(a98);
    }

    private final void n(A98 a98) {
        this.c.setValue(a98);
    }

    @Override // ir.nasim.InterfaceC20377ru3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        int iB = k().b(interfaceC12377eW3, interfaceC12377eW3.getLayoutDirection());
        int iA = k().a(interfaceC12377eW3);
        int iD = k().d(interfaceC12377eW3, interfaceC12377eW3.getLayoutDirection()) + iB;
        int iC = k().c(interfaceC12377eW3) + iA;
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(AbstractC19606qe1.i(j, -iD, -iC));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, AbstractC19606qe1.g(j, abstractC21430te5L0.P0() + iD), AbstractC19606qe1.f(j, abstractC21430te5L0.A0() + iC), null, new a(abstractC21430te5L0, iB, iA), 4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof N93) {
            return AbstractC13042fc3.d(((N93) obj).b, this.b);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC20236rg4
    public void g(InterfaceC24472yg4 interfaceC24472yg4) {
        A98 a98 = (A98) interfaceC24472yg4.t(AbstractC22050ua8.a());
        n(AbstractC21393ta8.f(this.b, a98));
        m(AbstractC21393ta8.h(a98, this.b));
    }

    @Override // ir.nasim.InterfaceC23882xg4
    public C6774Ox5 getKey() {
        return AbstractC22050ua8.a();
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // ir.nasim.InterfaceC23882xg4
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public A98 getValue() {
        return f();
    }
}
