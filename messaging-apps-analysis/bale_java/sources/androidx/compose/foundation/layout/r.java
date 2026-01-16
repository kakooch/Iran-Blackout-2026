package androidx.compose.foundation.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class r extends e.c implements InterfaceC21655tu3 {
    private float o;
    private float p;
    private float q;
    private float r;
    private boolean s;

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
            if (r.this.v2()) {
                AbstractC21430te5.a.l(aVar, this.f, this.g.B0(r.this.w2()), this.g.B0(r.this.x2()), 0.0f, 4, null);
            } else {
                AbstractC21430te5.a.h(aVar, this.f, this.g.B0(r.this.w2()), this.g.B0(r.this.x2()), 0.0f, 4, null);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public /* synthetic */ r(float f, float f2, float f3, float f4, boolean z, ED1 ed1) {
        this(f, f2, f3, f4, z);
    }

    public final void A2(boolean z) {
        this.s = z;
    }

    public final void B2(float f) {
        this.o = f;
    }

    public final void C2(float f) {
        this.p = f;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        int iB0 = interfaceC12377eW3.B0(this.o) + interfaceC12377eW3.B0(this.q);
        int iB02 = interfaceC12377eW3.B0(this.p) + interfaceC12377eW3.B0(this.r);
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(AbstractC19606qe1.i(j, -iB0, -iB02));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, AbstractC19606qe1.g(j, abstractC21430te5L0.P0() + iB0), AbstractC19606qe1.f(j, abstractC21430te5L0.A0() + iB02), null, new a(abstractC21430te5L0, interfaceC12377eW3), 4, null);
    }

    public final boolean v2() {
        return this.s;
    }

    public final float w2() {
        return this.o;
    }

    public final float x2() {
        return this.p;
    }

    public final void y2(float f) {
        this.r = f;
    }

    public final void z2(float f) {
        this.q = f;
    }

    private r(float f, float f2, float f3, float f4, boolean z) {
        this.o = f;
        this.p = f2;
        this.q = f3;
        this.r = f4;
        this.s = z;
    }
}
