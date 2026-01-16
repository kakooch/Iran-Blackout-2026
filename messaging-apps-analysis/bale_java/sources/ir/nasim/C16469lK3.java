package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;

/* renamed from: ir.nasim.lK3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16469lK3 extends e.c implements InterfaceC21655tu3 {
    private int o;
    private int p;

    /* renamed from: ir.nasim.lK3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.e = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC13042fc3.i(aVar, "$this$layout");
            AbstractC21430te5.a.l(aVar, this.e, 0, 0, 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public C16469lK3(int i, int i2) {
        this.o = i;
        this.p = i2;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC13042fc3.i(interfaceC12377eW3, "$this$measure");
        AbstractC13042fc3.i(zv3, "measurable");
        long jD = AbstractC19606qe1.d(j, AbstractC4663Ga3.a(this.o, this.p));
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0((C17833ne1.k(j) != Integer.MAX_VALUE || C17833ne1.l(j) == Integer.MAX_VALUE) ? (C17833ne1.l(j) != Integer.MAX_VALUE || C17833ne1.k(j) == Integer.MAX_VALUE) ? AbstractC19606qe1.a(C4414Fa3.g(jD), C4414Fa3.g(jD), C4414Fa3.f(jD), C4414Fa3.f(jD)) : AbstractC19606qe1.a((C4414Fa3.f(jD) * this.o) / this.p, (C4414Fa3.f(jD) * this.o) / this.p, C4414Fa3.f(jD), C4414Fa3.f(jD)) : AbstractC19606qe1.a(C4414Fa3.g(jD), C4414Fa3.g(jD), (C4414Fa3.g(jD) * this.p) / this.o, (C4414Fa3.g(jD) * this.p) / this.o));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0), 4, null);
    }

    public final void v2(int i) {
        this.p = i;
    }

    public final void w2(int i) {
        this.o = i;
    }
}
