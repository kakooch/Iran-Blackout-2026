package androidx.compose.foundation.layout;

import ir.nasim.AbstractC13165fm;
import ir.nasim.AbstractC13756gm;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17784nZ1;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.HY2;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.Q93;
import ir.nasim.T93;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.compose.foundation.layout.a$a, reason: collision with other inner class name */
    static final class C0044a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC13165fm e;
        final /* synthetic */ float f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;
        final /* synthetic */ AbstractC21430te5 j;
        final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0044a(AbstractC13165fm abstractC13165fm, float f, int i, int i2, int i3, AbstractC21430te5 abstractC21430te5, int i4) {
            super(1);
            this.e = abstractC13165fm;
            this.f = f;
            this.g = i;
            this.h = i2;
            this.i = i3;
            this.j = abstractC21430te5;
            this.k = i4;
        }

        public final void a(AbstractC21430te5.a aVar) {
            int iP0;
            if (a.d(this.e)) {
                iP0 = 0;
            } else {
                iP0 = !C17784nZ1.s(this.f, C17784nZ1.b.c()) ? this.g : (this.h - this.i) - this.j.P0();
            }
            AbstractC21430te5.a.l(aVar, this.j, iP0, a.d(this.e) ? !C17784nZ1.s(this.f, C17784nZ1.b.c()) ? this.g : (this.k - this.i) - this.j.A0() : 0, 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC13165fm e;
        final /* synthetic */ float f;
        final /* synthetic */ float g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractC13165fm abstractC13165fm, float f, float f2) {
            super(1);
            this.e = abstractC13165fm;
            this.f = f;
            this.g = f2;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC11734dW3 c(InterfaceC12377eW3 interfaceC12377eW3, AbstractC13165fm abstractC13165fm, float f, float f2, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(d(abstractC13165fm) ? C17833ne1.d(j, 0, 0, 0, 0, 11, null) : C17833ne1.d(j, 0, 0, 0, 0, 14, null));
        int iJ = abstractC21430te5L0.J(abstractC13165fm);
        if (iJ == Integer.MIN_VALUE) {
            iJ = 0;
        }
        int iA0 = d(abstractC13165fm) ? abstractC21430te5L0.A0() : abstractC21430te5L0.P0();
        int iK = (d(abstractC13165fm) ? C17833ne1.k(j) : C17833ne1.l(j)) - iA0;
        int iM = AbstractC23053wG5.m((Float.isNaN(f) ^ true ? interfaceC12377eW3.B0(f) : 0) - iJ, 0, iK);
        int iM2 = AbstractC23053wG5.m(((Float.isNaN(f2) ^ true ? interfaceC12377eW3.B0(f2) : 0) - iA0) + iJ, 0, iK - iM);
        int iP0 = d(abstractC13165fm) ? abstractC21430te5L0.P0() : Math.max(abstractC21430te5L0.P0() + iM + iM2, C17833ne1.n(j));
        int iMax = d(abstractC13165fm) ? Math.max(abstractC21430te5L0.A0() + iM + iM2, C17833ne1.m(j)) : abstractC21430te5L0.A0();
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, iP0, iMax, null, new C0044a(abstractC13165fm, f, iM, iP0, iM2, abstractC21430te5L0, iMax), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(AbstractC13165fm abstractC13165fm) {
        return abstractC13165fm instanceof HY2;
    }

    public static final androidx.compose.ui.e e(androidx.compose.ui.e eVar, AbstractC13165fm abstractC13165fm, float f, float f2) {
        return eVar.i(new AlignmentLineOffsetDpElement(abstractC13165fm, f, f2, Q93.b() ? new b(abstractC13165fm, f, f2) : Q93.a(), null));
    }

    public static /* synthetic */ androidx.compose.ui.e f(androidx.compose.ui.e eVar, AbstractC13165fm abstractC13165fm, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = C17784nZ1.b.c();
        }
        if ((i & 4) != 0) {
            f2 = C17784nZ1.b.c();
        }
        return e(eVar, abstractC13165fm, f, f2);
    }

    public static final androidx.compose.ui.e g(androidx.compose.ui.e eVar, float f, float f2) {
        return eVar.i(Float.isNaN(f) ^ true ? f(androidx.compose.ui.e.a, AbstractC13756gm.a(), f, 0.0f, 4, null) : androidx.compose.ui.e.a).i(Float.isNaN(f2) ^ true ? f(androidx.compose.ui.e.a, AbstractC13756gm.b(), 0.0f, f2, 2, null) : androidx.compose.ui.e.a);
    }
}
