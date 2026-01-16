package ir.nasim;

/* loaded from: classes2.dex */
public abstract class AZ1 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(C24994zZ1 c24994zZ1, long j) {
        if (!c24994zZ1.h().b2()) {
            return false;
        }
        InterfaceC11379cu3 interfaceC11379cu3S = KG1.o(c24994zZ1).s();
        if (!interfaceC11379cu3S.b()) {
            return false;
        }
        long jE = AbstractC12000du3.e(interfaceC11379cu3S);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jE >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jE & 4294967295L));
        float fC2 = ((int) (c24994zZ1.C2() >> 32)) + fIntBitsToFloat;
        float fC22 = ((int) (c24994zZ1.C2() & 4294967295L)) + fIntBitsToFloat2;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j >> 32));
        if (fIntBitsToFloat > fIntBitsToFloat3 || fIntBitsToFloat3 > fC2) {
            return false;
        }
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j & 4294967295L));
        return fIntBitsToFloat2 <= fIntBitsToFloat4 && fIntBitsToFloat4 <= fC22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(BZ1 bz1, C23810xZ1 c23810xZ1) {
        bz1.e0(c23810xZ1);
        bz1.a0(c23810xZ1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(InterfaceC8645Wv7 interfaceC8645Wv7, UA2 ua2) {
        if (ua2.invoke(interfaceC8645Wv7) != EnumC8411Vv7.a) {
            return;
        }
        AbstractC8931Xv7.f(interfaceC8645Wv7, ua2);
    }
}
