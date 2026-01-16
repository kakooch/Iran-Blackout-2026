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
final class u extends e.c implements InterfaceC21655tu3 {
    private float o;
    private float p;
    private float q;
    private float r;
    private boolean s;

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

    public /* synthetic */ u(float f, float f2, float f3, float f4, boolean z, ED1 ed1) {
        this(f, f2, f3, f4, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long v2(ir.nasim.WH1 r7) {
        /*
            r6 = this;
            float r0 = r6.q
            boolean r0 = java.lang.Float.isNaN(r0)
            r0 = r0 ^ 1
            r1 = 2147483647(0x7fffffff, float:NaN)
            r2 = 0
            if (r0 == 0) goto L18
            float r0 = r6.q
            int r0 = r7.B0(r0)
            if (r0 >= 0) goto L19
            r0 = r2
            goto L19
        L18:
            r0 = r1
        L19:
            float r3 = r6.r
            boolean r3 = java.lang.Float.isNaN(r3)
            r3 = r3 ^ 1
            if (r3 == 0) goto L2d
            float r3 = r6.r
            int r3 = r7.B0(r3)
            if (r3 >= 0) goto L2e
            r3 = r2
            goto L2e
        L2d:
            r3 = r1
        L2e:
            float r4 = r6.o
            boolean r4 = java.lang.Float.isNaN(r4)
            r4 = r4 ^ 1
            if (r4 == 0) goto L47
            float r4 = r6.o
            int r4 = r7.B0(r4)
            if (r4 >= 0) goto L41
            r4 = r2
        L41:
            if (r4 <= r0) goto L44
            r4 = r0
        L44:
            if (r4 == r1) goto L47
            goto L48
        L47:
            r4 = r2
        L48:
            float r5 = r6.p
            boolean r5 = java.lang.Float.isNaN(r5)
            r5 = r5 ^ 1
            if (r5 == 0) goto L61
            float r5 = r6.p
            int r7 = r7.B0(r5)
            if (r7 >= 0) goto L5b
            r7 = r2
        L5b:
            if (r7 <= r3) goto L5e
            r7 = r3
        L5e:
            if (r7 == r1) goto L61
            r2 = r7
        L61:
            long r0 = ir.nasim.AbstractC19606qe1.a(r4, r0, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.u.v2(ir.nasim.WH1):long");
    }

    public final void A2(float f) {
        this.o = f;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int F(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        long jV2 = v2(interfaceC10436bc3);
        if (C17833ne1.i(jV2)) {
            return C17833ne1.k(jV2);
        }
        if (!this.s) {
            i = AbstractC19606qe1.g(jV2, i);
        }
        return AbstractC19606qe1.f(jV2, interfaceC9236Zb3.z(i));
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int J(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        long jV2 = v2(interfaceC10436bc3);
        if (C17833ne1.i(jV2)) {
            return C17833ne1.k(jV2);
        }
        if (!this.s) {
            i = AbstractC19606qe1.g(jV2, i);
        }
        return AbstractC19606qe1.f(jV2, interfaceC9236Zb3.Z(i));
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        int iN;
        int iL;
        int iM;
        int iK;
        long jA;
        long jV2 = v2(interfaceC12377eW3);
        if (this.s) {
            jA = AbstractC19606qe1.e(j, jV2);
        } else {
            if (!Float.isNaN(this.o)) {
                iN = C17833ne1.n(jV2);
            } else {
                iN = C17833ne1.n(j);
                int iL2 = C17833ne1.l(jV2);
                if (iN > iL2) {
                    iN = iL2;
                }
            }
            if (!Float.isNaN(this.q)) {
                iL = C17833ne1.l(jV2);
            } else {
                iL = C17833ne1.l(j);
                int iN2 = C17833ne1.n(jV2);
                if (iL < iN2) {
                    iL = iN2;
                }
            }
            if (!Float.isNaN(this.p)) {
                iM = C17833ne1.m(jV2);
            } else {
                iM = C17833ne1.m(j);
                int iK2 = C17833ne1.k(jV2);
                if (iM > iK2) {
                    iM = iK2;
                }
            }
            if (!Float.isNaN(this.r)) {
                iK = C17833ne1.k(jV2);
            } else {
                iK = C17833ne1.k(j);
                int iM2 = C17833ne1.m(jV2);
                if (iK < iM2) {
                    iK = iM2;
                }
            }
            jA = AbstractC19606qe1.a(iN, iL, iM, iK);
        }
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(jA);
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new a(abstractC21430te5L0), 4, null);
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int p(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        long jV2 = v2(interfaceC10436bc3);
        if (C17833ne1.j(jV2)) {
            return C17833ne1.l(jV2);
        }
        if (!this.s) {
            i = AbstractC19606qe1.f(jV2, i);
        }
        return AbstractC19606qe1.g(jV2, interfaceC9236Zb3.i0(i));
    }

    public final void w2(boolean z) {
        this.s = z;
    }

    public final void x2(float f) {
        this.r = f;
    }

    public final void y2(float f) {
        this.q = f;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public int z(InterfaceC10436bc3 interfaceC10436bc3, InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        long jV2 = v2(interfaceC10436bc3);
        if (C17833ne1.j(jV2)) {
            return C17833ne1.l(jV2);
        }
        if (!this.s) {
            i = AbstractC19606qe1.f(jV2, i);
        }
        return AbstractC19606qe1.g(jV2, interfaceC9236Zb3.k0(i));
    }

    public final void z2(float f) {
        this.p = f;
    }

    private u(float f, float f2, float f3, float f4, boolean z) {
        this.o = f;
        this.p = f2;
        this.q = f3;
        this.r = f4;
        this.s = z;
    }
}
