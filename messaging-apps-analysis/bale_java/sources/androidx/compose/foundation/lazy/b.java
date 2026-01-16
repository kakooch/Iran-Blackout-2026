package androidx.compose.foundation.lazy;

import androidx.compose.ui.e;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class b extends e.c implements InterfaceC21655tu3 {
    private float o;
    private InterfaceC9664aL6 p;
    private InterfaceC9664aL6 q;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.e = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.h(aVar, this.e, 0, 0, 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public b(float f, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
        this.o = f;
        this.p = interfaceC9664aL6;
        this.q = interfaceC9664aL62;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        InterfaceC9664aL6 interfaceC9664aL6 = this.p;
        int iRound = (interfaceC9664aL6 == null || ((Number) interfaceC9664aL6.getValue()).intValue() == Integer.MAX_VALUE) ? Integer.MAX_VALUE : Math.round(((Number) interfaceC9664aL6.getValue()).floatValue() * this.o);
        InterfaceC9664aL6 interfaceC9664aL62 = this.q;
        int iRound2 = (interfaceC9664aL62 == null || ((Number) interfaceC9664aL62.getValue()).intValue() == Integer.MAX_VALUE) ? Integer.MAX_VALUE : Math.round(((Number) interfaceC9664aL62.getValue()).floatValue() * this.o);
        int iN = iRound != Integer.MAX_VALUE ? iRound : C17833ne1.n(j);
        int iM = iRound2 != Integer.MAX_VALUE ? iRound2 : C17833ne1.m(j);
        if (iRound == Integer.MAX_VALUE) {
            iRound = C17833ne1.l(j);
        }
        if (iRound2 == Integer.MAX_VALUE) {
            iRound2 = C17833ne1.k(j);
        }
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(AbstractC19606qe1.a(iN, iRound, iM, iRound2));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0), 4, null);
    }

    public final void v2(float f) {
        this.o = f;
    }

    public final void w2(InterfaceC9664aL6 interfaceC9664aL6) {
        this.q = interfaceC9664aL6;
    }

    public final void x2(InterfaceC9664aL6 interfaceC9664aL6) {
        this.p = interfaceC9664aL6;
    }
}
