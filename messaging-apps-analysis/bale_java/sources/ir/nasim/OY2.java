package ir.nasim;

import ir.nasim.AbstractC21430te5;

/* loaded from: classes.dex */
final class OY2 implements InterfaceC20377ru3 {
    private final C18510om7 b;
    private final int c;
    private final C18600ov7 d;
    private final SA2 e;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC12377eW3 e;
        final /* synthetic */ OY2 f;
        final /* synthetic */ AbstractC21430te5 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC12377eW3 interfaceC12377eW3, OY2 oy2, AbstractC21430te5 abstractC21430te5, int i) {
            super(1);
            this.e = interfaceC12377eW3;
            this.f = oy2;
            this.g = abstractC21430te5;
            this.h = i;
        }

        public final void a(AbstractC21430te5.a aVar) {
            InterfaceC12377eW3 interfaceC12377eW3 = this.e;
            int iF = this.f.f();
            C18600ov7 c18600ov7M = this.f.m();
            C14367hn7 c14367hn7 = (C14367hn7) this.f.l().invoke();
            this.f.k().k(EnumC24286yM4.b, AbstractC17328mm7.c(interfaceC12377eW3, iF, c18600ov7M, c14367hn7 != null ? c14367hn7.f() : null, this.e.getLayoutDirection() == EnumC12613eu3.b, this.g.P0()), this.h, this.g.P0());
            AbstractC21430te5.a.l(aVar, this.g, Math.round(-this.f.k().d()), 0, 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public OY2(C18510om7 c18510om7, int i, C18600ov7 c18600ov7, SA2 sa2) {
        this.b = c18510om7;
        this.c = i;
        this.d = c18600ov7;
        this.e = sa2;
    }

    @Override // ir.nasim.InterfaceC20377ru3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(zv3.k0(C17833ne1.k(j)) < C17833ne1.l(j) ? j : C17833ne1.d(j, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        int iMin = Math.min(abstractC21430te5L0.P0(), C17833ne1.l(j));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, iMin, abstractC21430te5L0.A0(), null, new a(interfaceC12377eW3, this, abstractC21430te5L0, iMin), 4, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OY2)) {
            return false;
        }
        OY2 oy2 = (OY2) obj;
        return AbstractC13042fc3.d(this.b, oy2.b) && this.c == oy2.c && AbstractC13042fc3.d(this.d, oy2.d) && AbstractC13042fc3.d(this.e, oy2.e);
    }

    public final int f() {
        return this.c;
    }

    public int hashCode() {
        return (((((this.b.hashCode() * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final C18510om7 k() {
        return this.b;
    }

    public final SA2 l() {
        return this.e;
    }

    public final C18600ov7 m() {
        return this.d;
    }

    public String toString() {
        return "HorizontalScrollLayoutModifier(scrollerPosition=" + this.b + ", cursorOffset=" + this.c + ", transformedText=" + this.d + ", textLayoutResultProvider=" + this.e + ')';
    }
}
