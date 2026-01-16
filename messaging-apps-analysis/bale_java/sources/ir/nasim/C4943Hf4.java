package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;

/* renamed from: ir.nasim.Hf4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4943Hf4 extends e.c implements InterfaceC9814ac1, InterfaceC21655tu3 {

    /* renamed from: ir.nasim.Hf4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;
        final /* synthetic */ AbstractC21430te5 f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, AbstractC21430te5 abstractC21430te5, int i2) {
            super(1);
            this.e = i;
            this.f = abstractC21430te5;
            this.g = i2;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.h(aVar, this.f, AbstractC20723sV3.d((this.e - this.f.P0()) / 2.0f), AbstractC20723sV3.d((this.g - this.f.A0()) / 2.0f), 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        float f = 0;
        float fQ = C17784nZ1.q(AbstractC23053wG5.d(((C17784nZ1) AbstractC10434bc1.a(this, AbstractC3248Ab3.a())).v(), C17784nZ1.q(f)));
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
        boolean z = b2() && (Float.isNaN(fQ) ^ true) && C17784nZ1.p(fQ, C17784nZ1.q(f)) > 0;
        int iB0 = true ^ Float.isNaN(fQ) ? interfaceC12377eW3.B0(fQ) : 0;
        int iMax = z ? Math.max(abstractC21430te5L0.P0(), iB0) : abstractC21430te5L0.P0();
        int iMax2 = z ? Math.max(abstractC21430te5L0.A0(), iB0) : abstractC21430te5L0.A0();
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, iMax, iMax2, null, new a(iMax, abstractC21430te5L0, iMax2), 4, null);
    }
}
