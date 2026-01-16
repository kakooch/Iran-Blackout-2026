package androidx.compose.foundation.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC19606qe1;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10436bc3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.InterfaceC9236Zb3;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class v extends e.c implements InterfaceC21655tu3 {
    private float o;
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

    public /* synthetic */ v(float f, float f2, ED1 ed1) {
        this(f, f2);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        int iZ = interfaceC9236Zb3.z(i);
        int iB0 = Float.isNaN(this.p) ^ true ? interfaceC10436bc3.B0(this.p) : 0;
        return iZ < iB0 ? iB0 : iZ;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        int iZ = interfaceC9236Zb3.Z(i);
        int iB0 = Float.isNaN(this.p) ^ true ? interfaceC10436bc3.B0(this.p) : 0;
        return iZ < iB0 ? iB0 : iZ;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        int iN;
        int iM;
        if ((!Float.isNaN(this.o)) && C17833ne1.n(j) == 0) {
            int iB0 = interfaceC12377eW3.B0(this.o);
            iN = C17833ne1.l(j);
            if (iB0 < 0) {
                iB0 = 0;
            }
            if (iB0 <= iN) {
                iN = iB0;
            }
        } else {
            iN = C17833ne1.n(j);
        }
        int iL = C17833ne1.l(j);
        if ((!Float.isNaN(this.p)) && C17833ne1.m(j) == 0) {
            int iB02 = interfaceC12377eW3.B0(this.p);
            iM = C17833ne1.k(j);
            int i = iB02 >= 0 ? iB02 : 0;
            if (i <= iM) {
                iM = i;
            }
        } else {
            iM = C17833ne1.m(j);
        }
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(AbstractC19606qe1.a(iN, iL, iM, C17833ne1.k(j)));
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0), 4, null);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        int iI0 = interfaceC9236Zb3.i0(i);
        int iB0 = Float.isNaN(this.o) ^ true ? interfaceC10436bc3.B0(this.o) : 0;
        return iI0 < iB0 ? iB0 : iI0;
    }

    public final void v2(float f) {
        this.p = f;
    }

    public final void w2(float f) {
        this.o = f;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        int iK0 = interfaceC9236Zb3.k0(i);
        int iB0 = Float.isNaN(this.o) ^ true ? interfaceC10436bc3.B0(this.o) : 0;
        return iK0 < iB0 ? iB0 : iK0;
    }

    private v(float f, float f2) {
        this.o = f;
        this.p = f2;
    }
}
