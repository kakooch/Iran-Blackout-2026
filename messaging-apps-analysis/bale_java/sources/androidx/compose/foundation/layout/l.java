package androidx.compose.foundation.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.C22045ua3;
import ir.nasim.InterfaceC10436bc3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.InterfaceC9236Zb3;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
abstract class l extends e.c implements InterfaceC21655tu3 {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.e = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.n(aVar, this.e, C22045ua3.b.b(), 0.0f, 2, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return interfaceC9236Zb3.z(i);
    }

    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return interfaceC9236Zb3.Z(i);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        long jV2 = v2(interfaceC12377eW3, zv3, j);
        if (w2()) {
            jV2 = AbstractC19606qe1.e(j, jV2);
        }
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(jV2);
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0), 4, null);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return interfaceC9236Zb3.i0(i);
    }

    public abstract long v2(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j);

    public abstract boolean w2();

    @Override // ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return interfaceC9236Zb3.k0(i);
    }
}
