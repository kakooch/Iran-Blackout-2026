package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;

/* renamed from: ir.nasim.Vd6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8248Vd6 extends e.c implements InterfaceC21655tu3, InterfaceC7163Qn6 {
    private C9023Yd6 o;
    private boolean p;
    private boolean q;

    /* renamed from: ir.nasim.Vd6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(C8248Vd6.this.w2().o());
        }
    }

    /* renamed from: ir.nasim.Vd6$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(C8248Vd6.this.w2().n());
        }
    }

    /* renamed from: ir.nasim.Vd6$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int f;
        final /* synthetic */ AbstractC21430te5 g;

        /* renamed from: ir.nasim.Vd6$c$a */
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
                AbstractC21430te5.a.p(aVar, this.e, this.f, this.g, 0.0f, null, 12, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.f = i;
            this.g = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            int iO = C8248Vd6.this.w2().o();
            int i = this.f;
            if (iO < 0) {
                iO = 0;
            }
            if (iO <= i) {
                i = iO;
            }
            int i2 = C8248Vd6.this.v2() ? i - this.f : -i;
            aVar.A(new a(this.g, C8248Vd6.this.x2() ? 0 : i2, C8248Vd6.this.x2() ? i2 : 0));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public C8248Vd6(C9023Yd6 c9023Yd6, boolean z, boolean z2) {
        this.o = c9023Yd6;
        this.p = z;
        this.q = z2;
    }

    public final void A2(boolean z) {
        this.q = z;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (!this.q) {
            i = Integer.MAX_VALUE;
        }
        return interfaceC9236Zb3.z(i);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (!this.q) {
            i = Integer.MAX_VALUE;
        }
        return interfaceC9236Zb3.Z(i);
    }

    @Override // ir.nasim.InterfaceC7163Qn6
    public void U0(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC9939ao6.E0(interfaceC11943do6, true);
        C5629Kd6 c5629Kd6 = new C5629Kd6(new a(), new b(), this.p);
        if (this.q) {
            AbstractC9939ao6.G0(interfaceC11943do6, c5629Kd6);
        } else {
            AbstractC9939ao6.i0(interfaceC11943do6, c5629Kd6);
        }
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21313tS0.a(j, this.q ? EnumC24286yM4.a : EnumC24286yM4.b);
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(C17833ne1.d(j, 0, this.q ? C17833ne1.l(j) : Integer.MAX_VALUE, 0, this.q ? Integer.MAX_VALUE : C17833ne1.k(j), 5, null));
        int i = AbstractC23053wG5.i(abstractC21430te5L0.P0(), C17833ne1.l(j));
        int i2 = AbstractC23053wG5.i(abstractC21430te5L0.A0(), C17833ne1.k(j));
        int iA0 = abstractC21430te5L0.A0() - i2;
        int iP0 = abstractC21430te5L0.P0() - i;
        if (!this.q) {
            iA0 = iP0;
        }
        this.o.p(iA0);
        this.o.r(this.q ? i2 : i);
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, i, i2, null, new c(iA0, abstractC21430te5L0), 4, null);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (this.q) {
            i = Integer.MAX_VALUE;
        }
        return interfaceC9236Zb3.i0(i);
    }

    public final boolean v2() {
        return this.p;
    }

    public final C9023Yd6 w2() {
        return this.o;
    }

    public final boolean x2() {
        return this.q;
    }

    public final void y2(boolean z) {
        this.p = z;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        if (this.q) {
            i = Integer.MAX_VALUE;
        }
        return interfaceC9236Zb3.k0(i);
    }

    public final void z2(C9023Yd6 c9023Yd6) {
        this.o = c9023Yd6;
    }
}
