package androidx.compose.ui;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes2.dex */
public final class f extends e.c implements InterfaceC21655tu3 {
    private float o;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;
        final /* synthetic */ f f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC21430te5 abstractC21430te5, f fVar) {
            super(1);
            this.e = abstractC21430te5;
            this.f = fVar;
        }

        public final void a(AbstractC21430te5.a aVar) {
            aVar.g(this.e, 0, 0, this.f.v2());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public f(float f) {
        this.o = f;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0, this), 4, null);
    }

    public String toString() {
        return "ZIndexModifier(zIndex=" + this.o + ')';
    }

    public final float v2() {
        return this.o;
    }

    public final void w2(float f) {
        this.o = f;
    }
}
