package androidx.compose.foundation.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC23431wu3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17784nZ1;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class o extends e.c implements InterfaceC21655tu3 {
    private float o;
    private float p;
    private boolean q;
    private final boolean r;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 f;
        final /* synthetic */ InterfaceC12377eW3 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC21430te5 abstractC21430te5, InterfaceC12377eW3 interfaceC12377eW3) {
            super(1);
            this.f = abstractC21430te5;
            this.g = interfaceC12377eW3;
        }

        public final void a(AbstractC21430te5.a aVar) {
            if (o.this.v2()) {
                AbstractC21430te5.a.l(aVar, this.f, this.g.B0(o.this.w2()), this.g.B0(o.this.x2()), 0.0f, 4, null);
            } else {
                AbstractC21430te5.a.h(aVar, this.f, this.g.B0(o.this.w2()), this.g.B0(o.this.x2()), 0.0f, 4, null);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public /* synthetic */ o(float f, float f2, boolean z, ED1 ed1) {
        this(f, f2, z);
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return this.r;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0, interfaceC12377eW3), 4, null);
    }

    public final boolean v2() {
        return this.q;
    }

    public final float w2() {
        return this.o;
    }

    public final float x2() {
        return this.p;
    }

    public final void y2(float f, float f2, boolean z) {
        if (!C17784nZ1.s(this.o, f) || !C17784nZ1.s(this.p, f2) || this.q != z) {
            AbstractC23431wu3.c(this);
        }
        this.o = f;
        this.p = f2;
        this.q = z;
    }

    private o(float f, float f2, boolean z) {
        this.o = f;
        this.p = f2;
        this.q = z;
    }
}
