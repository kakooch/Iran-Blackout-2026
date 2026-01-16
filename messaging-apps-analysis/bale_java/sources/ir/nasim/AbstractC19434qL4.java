package ir.nasim;

/* renamed from: ir.nasim.qL4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19434qL4 {
    private static final int c(C24216yE6 c24216yE6) {
        int iA0 = c24216yE6.a0();
        int iB0 = c24216yE6.b0();
        while (iB0 >= 0 && !c24216yE6.q0(iB0)) {
            iB0 = c24216yE6.D0(iB0);
        }
        int iJ0 = iB0 + 1;
        int iB02 = 0;
        while (iJ0 < iA0) {
            if (c24216yE6.l0(iA0, iJ0)) {
                if (c24216yE6.q0(iJ0)) {
                    iB02 = 0;
                }
                iJ0++;
            } else {
                iB02 += c24216yE6.q0(iJ0) ? 1 : c24216yE6.B0(iJ0);
                iJ0 += c24216yE6.j0(iJ0);
            }
        }
        return iB02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(C24216yE6 c24216yE6, C6669Om c6669Om, InterfaceC15247jG interfaceC15247jG) {
        int iE = c24216yE6.E(c6669Om);
        if (!(c24216yE6.a0() < iE)) {
            AbstractC5138Ib1.s("Check failed");
        }
        e(c24216yE6, interfaceC15247jG, iE);
        int iC = c(c24216yE6);
        while (c24216yE6.a0() < iE) {
            if (c24216yE6.k0(iE)) {
                if (c24216yE6.p0()) {
                    interfaceC15247jG.g(c24216yE6.z0(c24216yE6.a0()));
                    iC = 0;
                }
                c24216yE6.e1();
            } else {
                iC += c24216yE6.T0();
            }
        }
        if (!(c24216yE6.a0() == iE)) {
            AbstractC5138Ib1.s("Check failed");
        }
        return iC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(C24216yE6 c24216yE6, InterfaceC15247jG interfaceC15247jG, int i) {
        while (!c24216yE6.m0(i)) {
            c24216yE6.U0();
            if (c24216yE6.q0(c24216yE6.b0())) {
                interfaceC15247jG.k();
            }
            c24216yE6.T();
        }
    }
}
