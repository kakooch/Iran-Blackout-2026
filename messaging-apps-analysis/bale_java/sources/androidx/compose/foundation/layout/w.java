package androidx.compose.foundation.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C22045ua3;
import ir.nasim.C4414Fa3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.PT1;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class w extends e.c implements InterfaceC21655tu3 {
    private PT1 o;
    private boolean p;
    private InterfaceC14603iB2 q;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int f;
        final /* synthetic */ AbstractC21430te5 g;
        final /* synthetic */ int h;
        final /* synthetic */ InterfaceC12377eW3 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, AbstractC21430te5 abstractC21430te5, int i2, InterfaceC12377eW3 interfaceC12377eW3) {
            super(1);
            this.f = i;
            this.g = abstractC21430te5;
            this.h = i2;
            this.i = interfaceC12377eW3;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.j(aVar, this.g, ((C22045ua3) w.this.v2().invoke(C4414Fa3.b(C4414Fa3.c(((this.h - this.g.A0()) & 4294967295L) | ((this.f - this.g.P0()) << 32))), this.i.getLayoutDirection())).r(), 0.0f, 2, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public w(PT1 pt1, boolean z, InterfaceC14603iB2 interfaceC14603iB2) {
        this.o = pt1;
        this.p = z;
        this.q = interfaceC14603iB2;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        PT1 pt1 = this.o;
        PT1 pt12 = PT1.a;
        int iN = pt1 != pt12 ? 0 : C17833ne1.n(j);
        PT1 pt13 = this.o;
        PT1 pt14 = PT1.b;
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(AbstractC19606qe1.a(iN, (this.o == pt12 || !this.p) ? C17833ne1.l(j) : Integer.MAX_VALUE, pt13 == pt14 ? C17833ne1.m(j) : 0, (this.o == pt14 || !this.p) ? C17833ne1.k(j) : Integer.MAX_VALUE));
        int iM = AbstractC23053wG5.m(abstractC21430te5L0.P0(), C17833ne1.n(j), C17833ne1.l(j));
        int iM2 = AbstractC23053wG5.m(abstractC21430te5L0.A0(), C17833ne1.m(j), C17833ne1.k(j));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, iM, iM2, null, new a(iM, abstractC21430te5L0, iM2, interfaceC12377eW3), 4, null);
    }

    public final InterfaceC14603iB2 v2() {
        return this.q;
    }

    public final void w2(InterfaceC14603iB2 interfaceC14603iB2) {
        this.q = interfaceC14603iB2;
    }

    public final void x2(PT1 pt1) {
        this.o = pt1;
    }

    public final void y2(boolean z) {
        this.p = z;
    }
}
