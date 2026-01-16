package androidx.compose.material3.internal;

import androidx.compose.ui.e;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC4663Ga3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C4414Fa3;
import ir.nasim.C8822Xm;
import ir.nasim.EnumC24286yM4;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.JZ1;
import ir.nasim.UA2;
import ir.nasim.XV4;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class c extends e.c implements InterfaceC21655tu3 {
    private C8822Xm o;
    private InterfaceC14603iB2 p;
    private EnumC24286yM4 q;
    private boolean r;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC12377eW3 e;
        final /* synthetic */ c f;
        final /* synthetic */ AbstractC21430te5 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC12377eW3 interfaceC12377eW3, c cVar, AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.e = interfaceC12377eW3;
            this.f = cVar;
            this.g = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            float fE = this.e.s0() ? this.f.w2().o().e(this.f.w2().x()) : this.f.w2().A();
            float f = this.f.v2() == EnumC24286yM4.b ? fE : 0.0f;
            if (this.f.v2() != EnumC24286yM4.a) {
                fE = 0.0f;
            }
            AbstractC21430te5.a.h(aVar, this.g, AbstractC20723sV3.d(f), AbstractC20723sV3.d(fE), 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public c(C8822Xm c8822Xm, InterfaceC14603iB2 interfaceC14603iB2, EnumC24286yM4 enumC24286yM4) {
        this.o = c8822Xm;
        this.p = interfaceC14603iB2;
        this.q = enumC24286yM4;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
        if (!interfaceC12377eW3.s0() || !this.r) {
            XV4 xv4 = (XV4) this.p.invoke(C4414Fa3.b(AbstractC4663Ga3.a(abstractC21430te5L0.P0(), abstractC21430te5L0.A0())), C17833ne1.a(j));
            this.o.I((JZ1) xv4.e(), xv4.f());
        }
        this.r = interfaceC12377eW3.s0() || this.r;
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(interfaceC12377eW3, this, abstractC21430te5L0), 4, null);
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        this.r = false;
    }

    public final EnumC24286yM4 v2() {
        return this.q;
    }

    public final C8822Xm w2() {
        return this.o;
    }

    public final void x2(InterfaceC14603iB2 interfaceC14603iB2) {
        this.p = interfaceC14603iB2;
    }

    public final void y2(EnumC24286yM4 enumC24286yM4) {
        this.q = enumC24286yM4;
    }

    public final void z2(C8822Xm c8822Xm) {
        this.o = c8822Xm;
    }
}
