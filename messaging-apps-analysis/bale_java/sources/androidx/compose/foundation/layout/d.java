package androidx.compose.foundation.layout;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C4414Fa3;
import ir.nasim.InterfaceC10436bc3;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.InterfaceC9236Zb3;
import ir.nasim.UA2;
import ir.nasim.ZV3;

/* loaded from: classes.dex */
final class d extends e.c implements InterfaceC21655tu3 {
    private float o;
    private boolean p;

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

    public d(float f, boolean z) {
        this.o = f;
        this.p = z;
    }

    private final long A2(long j, boolean z) {
        int iM = C17833ne1.m(j);
        int iRound = Math.round(iM * this.o);
        return (iRound <= 0 || (z && !c.c(j, iRound, iM))) ? C4414Fa3.b.a() : C4414Fa3.c((iRound << 32) | (iM & 4294967295L));
    }

    private final long B2(long j, boolean z) {
        int iN = C17833ne1.n(j);
        int iRound = Math.round(iN / this.o);
        return (iRound <= 0 || (z && !c.c(j, iN, iRound))) ? C4414Fa3.b.a() : C4414Fa3.c((iN << 32) | (iRound & 4294967295L));
    }

    private final long v2(long j) {
        if (this.p) {
            long jY2 = y2(j, true);
            C4414Fa3.a aVar = C4414Fa3.b;
            if (!C4414Fa3.e(jY2, aVar.a())) {
                return jY2;
            }
            long jZ2 = z2(j, true);
            if (!C4414Fa3.e(jZ2, aVar.a())) {
                return jZ2;
            }
            long jA2 = A2(j, true);
            if (!C4414Fa3.e(jA2, aVar.a())) {
                return jA2;
            }
            long jB2 = B2(j, true);
            if (!C4414Fa3.e(jB2, aVar.a())) {
                return jB2;
            }
            long jY22 = y2(j, false);
            if (!C4414Fa3.e(jY22, aVar.a())) {
                return jY22;
            }
            long jZ22 = z2(j, false);
            if (!C4414Fa3.e(jZ22, aVar.a())) {
                return jZ22;
            }
            long jA22 = A2(j, false);
            if (!C4414Fa3.e(jA22, aVar.a())) {
                return jA22;
            }
            long jB22 = B2(j, false);
            if (!C4414Fa3.e(jB22, aVar.a())) {
                return jB22;
            }
        } else {
            long jZ23 = z2(j, true);
            C4414Fa3.a aVar2 = C4414Fa3.b;
            if (!C4414Fa3.e(jZ23, aVar2.a())) {
                return jZ23;
            }
            long jY23 = y2(j, true);
            if (!C4414Fa3.e(jY23, aVar2.a())) {
                return jY23;
            }
            long jB23 = B2(j, true);
            if (!C4414Fa3.e(jB23, aVar2.a())) {
                return jB23;
            }
            long jA23 = A2(j, true);
            if (!C4414Fa3.e(jA23, aVar2.a())) {
                return jA23;
            }
            long jZ24 = z2(j, false);
            if (!C4414Fa3.e(jZ24, aVar2.a())) {
                return jZ24;
            }
            long jY24 = y2(j, false);
            if (!C4414Fa3.e(jY24, aVar2.a())) {
                return jY24;
            }
            long jB24 = B2(j, false);
            if (!C4414Fa3.e(jB24, aVar2.a())) {
                return jB24;
            }
            long jA24 = A2(j, false);
            if (!C4414Fa3.e(jA24, aVar2.a())) {
                return jA24;
            }
        }
        return C4414Fa3.b.a();
    }

    private final long y2(long j, boolean z) {
        int iRound;
        int iK = C17833ne1.k(j);
        return (iK == Integer.MAX_VALUE || (iRound = Math.round(((float) iK) * this.o)) <= 0 || (z && !c.c(j, iRound, iK))) ? C4414Fa3.b.a() : C4414Fa3.c((iRound << 32) | (iK & 4294967295L));
    }

    private final long z2(long j, boolean z) {
        int iRound;
        int iL = C17833ne1.l(j);
        return (iL == Integer.MAX_VALUE || (iRound = Math.round(((float) iL) / this.o)) <= 0 || (z && !c.c(j, iL, iRound))) ? C4414Fa3.b.a() : C4414Fa3.c((iL << 32) | (iRound & 4294967295L));
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i / this.o) : interfaceC9236Zb3.z(i);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i / this.o) : interfaceC9236Zb3.Z(i);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        long jV2 = v2(j);
        if (!C4414Fa3.e(jV2, C4414Fa3.b.a())) {
            j = C17833ne1.b.c((int) (jV2 >> 32), (int) (jV2 & 4294967295L));
        }
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0), 4, null);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.o) : interfaceC9236Zb3.i0(i);
    }

    public final void w2(float f) {
        this.o = f;
    }

    public final void x2(boolean z) {
        this.p = z;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.o) : interfaceC9236Zb3.k0(i);
    }
}
