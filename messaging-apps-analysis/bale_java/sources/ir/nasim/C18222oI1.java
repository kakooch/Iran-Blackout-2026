package ir.nasim;

import ir.nasim.AbstractC21430te5;

/* renamed from: ir.nasim.oI1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C18222oI1 extends U93 implements InterfaceC20377ru3, InterfaceC20236rg4 {
    private final A98 c;
    private final InterfaceC14603iB2 d;
    private final InterfaceC9102Ym4 e;

    /* renamed from: ir.nasim.oI1$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.e = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.l(aVar, this.e, 0, 0, 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public C18222oI1(A98 a98, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2) {
        super(ua2);
        this.c = a98;
        this.d = interfaceC14603iB2;
        this.e = AbstractC13472gH6.d(a98, null, 2, null);
    }

    private final A98 f() {
        return (A98) this.e.getValue();
    }

    private final void k(A98 a98) {
        this.e.setValue(a98);
    }

    @Override // ir.nasim.InterfaceC20377ru3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        int iIntValue = ((Number) this.d.invoke(f(), interfaceC12377eW3)).intValue();
        if (iIntValue == 0) {
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, 0, 0, null, a.e, 4, null);
        }
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(C17833ne1.d(j, 0, 0, iIntValue, iIntValue, 3, null));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), iIntValue, null, new b(abstractC21430te5L0), 4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18222oI1)) {
            return false;
        }
        C18222oI1 c18222oI1 = (C18222oI1) obj;
        return AbstractC13042fc3.d(this.c, c18222oI1.c) && this.d == c18222oI1.d;
    }

    @Override // ir.nasim.InterfaceC20236rg4
    public void g(InterfaceC24472yg4 interfaceC24472yg4) {
        k(AbstractC21393ta8.f(this.c, (A98) interfaceC24472yg4.t(AbstractC22050ua8.a())));
    }

    public int hashCode() {
        return (this.c.hashCode() * 31) + this.d.hashCode();
    }

    /* renamed from: ir.nasim.oI1$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }

        public final void a(AbstractC21430te5.a aVar) {
        }
    }
}
