package androidx.compose.foundation.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.PT1;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class i extends e.c implements InterfaceC21655tu3 {
    private PT1 o;
    private float p;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC21430te5 abstractC21430te5) {
            super(1);
            this.e = abstractC21430te5;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.l(aVar, this.e, 0, 0, 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public i(PT1 pt1, float f) {
        this.o = pt1;
        this.p = f;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        int iN;
        int iL;
        int iK;
        int iK2;
        if (!C17833ne1.h(j) || this.o == PT1.a) {
            iN = C17833ne1.n(j);
            iL = C17833ne1.l(j);
        } else {
            int iRound = Math.round(C17833ne1.l(j) * this.p);
            int iN2 = C17833ne1.n(j);
            iN = C17833ne1.l(j);
            if (iRound < iN2) {
                iRound = iN2;
            }
            if (iRound <= iN) {
                iN = iRound;
            }
            iL = iN;
        }
        if (!C17833ne1.g(j) || this.o == PT1.b) {
            int iM = C17833ne1.m(j);
            iK = C17833ne1.k(j);
            iK2 = iM;
        } else {
            int iRound2 = Math.round(C17833ne1.k(j) * this.p);
            int iM2 = C17833ne1.m(j);
            iK2 = C17833ne1.k(j);
            if (iRound2 < iM2) {
                iRound2 = iM2;
            }
            if (iRound2 <= iK2) {
                iK2 = iRound2;
            }
            iK = iK2;
        }
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(AbstractC19606qe1.a(iN, iL, iK2, iK));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0), 4, null);
    }

    public final void v2(PT1 pt1) {
        this.o = pt1;
    }

    public final void w2(float f) {
        this.p = f;
    }
}
