package androidx.compose.foundation.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17784nZ1;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.K73;
import ir.nasim.TS4;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class s extends e.c implements InterfaceC21655tu3 {
    private TS4 o;

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

    public s(TS4 ts4) {
        this.o = ts4;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        float fD = this.o.d(interfaceC12377eW3.getLayoutDirection());
        float fC = this.o.c();
        float fB = this.o.b(interfaceC12377eW3.getLayoutDirection());
        float fA = this.o.a();
        float f = 0;
        if (!((C17784nZ1.p(fA, C17784nZ1.q(f)) >= 0) & (C17784nZ1.p(fD, C17784nZ1.q(f)) >= 0) & (C17784nZ1.p(fC, C17784nZ1.q(f)) >= 0) & (C17784nZ1.p(fB, C17784nZ1.q(f)) >= 0))) {
            K73.a("Padding must be non-negative");
        }
        int iB0 = interfaceC12377eW3.B0(fD);
        int iB02 = interfaceC12377eW3.B0(fB) + iB0;
        int iB03 = interfaceC12377eW3.B0(fC);
        int iB04 = interfaceC12377eW3.B0(fA) + iB03;
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(AbstractC19606qe1.i(j, -iB02, -iB04));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, AbstractC19606qe1.g(j, abstractC21430te5L0.P0() + iB02), AbstractC19606qe1.f(j, abstractC21430te5L0.A0() + iB04), null, new a(abstractC21430te5L0, iB0, iB03), 4, null);
    }

    public final void v2(TS4 ts4) {
        this.o = ts4;
    }
}
