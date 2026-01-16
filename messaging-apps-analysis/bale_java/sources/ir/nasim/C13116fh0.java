package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;

/* renamed from: ir.nasim.fh0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13116fh0 extends e.c implements InterfaceC21655tu3 {
    private UA2 o;

    /* renamed from: ir.nasim.fh0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;
        final /* synthetic */ C13116fh0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC21430te5 abstractC21430te5, C13116fh0 c13116fh0) {
            super(1);
            this.e = abstractC21430te5;
            this.f = c13116fh0;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.v(aVar, this.e, 0, 0, 0.0f, this.f.v2(), 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public C13116fh0(UA2 ua2) {
        this.o = ua2;
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0, this), 4, null);
    }

    public String toString() {
        return "BlockGraphicsLayerModifier(block=" + this.o + ')';
    }

    public final UA2 v2() {
        return this.o;
    }

    public final void w2() {
        XA4 xa4K2 = KG1.j(this, AbstractC9572aB4.a(2)).K2();
        if (xa4K2 != null) {
            xa4K2.D3(this.o, true);
        }
    }

    public final void x2(UA2 ua2) {
        this.o = ua2;
    }
}
