package androidx.compose.foundation.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC23431wu3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.C22045ua3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class p extends e.c implements InterfaceC21655tu3 {
    private UA2 o;
    private boolean p;
    private final boolean q;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC12377eW3 f;
        final /* synthetic */ AbstractC21430te5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC12377eW3 interfaceC12377eW3, AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.f = interfaceC12377eW3;
            this.g = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            long jR = ((C22045ua3) p.this.v2().invoke(this.f)).r();
            if (p.this.w2()) {
                AbstractC21430te5.a.p(aVar, this.g, C22045ua3.k(jR), C22045ua3.l(jR), 0.0f, null, 12, null);
            } else {
                AbstractC21430te5.a.v(aVar, this.g, C22045ua3.k(jR), C22045ua3.l(jR), 0.0f, null, 12, null);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public p(UA2 ua2, boolean z) {
        this.o = ua2;
        this.p = z;
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return this.q;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(interfaceC12377eW3, abstractC21430te5L0), 4, null);
    }

    public final UA2 v2() {
        return this.o;
    }

    public final boolean w2() {
        return this.p;
    }

    public final void x2(UA2 ua2, boolean z) {
        if (this.o != ua2 || this.p != z) {
            AbstractC23431wu3.c(this);
        }
        this.o = ua2;
        this.p = z;
    }
}
