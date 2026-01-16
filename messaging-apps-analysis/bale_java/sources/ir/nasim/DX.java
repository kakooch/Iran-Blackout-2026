package ir.nasim;

import ir.nasim.InterfaceC22053ub1;

/* loaded from: classes4.dex */
public abstract class DX {
    public static final void d(final androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-512380364);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            final float fQ = C17784nZ1.q(48);
            final long jE = G10.a.a(interfaceC22053ub1J, 6).E();
            interfaceC22053ub1J.W(-258761961);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new UA2() { // from class: ir.nasim.AX
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return DX.e((InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(AbstractC6919Pn6.a(eVar, (UA2) objB), 0.0f, 1, null), C17784nZ1.q(16));
            interfaceC22053ub1J.W(-258759485);
            boolean zF = interfaceC22053ub1J.f(jE);
            Object objB2 = interfaceC22053ub1J.B();
            if (zF || objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.BX
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return DX.f(fQ, jE, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC22443vF0.a(eVarI, (UA2) objB2, interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.CX
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return DX.g(eVar, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$clearAndSetSemantics");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(float f, long j, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "$this$Canvas");
        float f2 = 2;
        float f3 = f / f2;
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)) / f2) - interfaceC17460n02.w1(C17784nZ1.q(f3));
        float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)) / f2) + interfaceC17460n02.w1(C17784nZ1.q(f3));
        float fW1 = interfaceC17460n02.w1(C17784nZ1.q(8));
        InterfaceC17460n02.V0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fW1) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(fW1) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat2) << 32)), interfaceC17460n02.w1(C17784nZ1.q(4)), AbstractC24405yZ6.a.b(), null, 0.0f, null, 0, 480, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        d(eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
