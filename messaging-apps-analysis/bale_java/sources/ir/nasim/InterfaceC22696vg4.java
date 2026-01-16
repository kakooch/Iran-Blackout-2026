package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.vg4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC22696vg4 extends InterfaceC24472yg4, JG1 {
    default AbstractC22106ug4 o0() {
        return C23556x72.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // ir.nasim.InterfaceC24472yg4
    default Object t(AbstractC19629qg4 abstractC19629qg4) {
        VA4 va4T0;
        if (!h().b2()) {
            M73.a("ModifierLocal accessed from an unattached node");
        }
        int iA = AbstractC9572aB4.a(32);
        if (!h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = h().Y1();
        C3419Au3 c3419Au3O = KG1.o(this);
        while (c3419Au3O != null) {
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        RG1 rg1H = cVarY1;
                        ?? c12544en4 = 0;
                        while (rg1H != 0) {
                            if (rg1H instanceof InterfaceC22696vg4) {
                                InterfaceC22696vg4 interfaceC22696vg4 = (InterfaceC22696vg4) rg1H;
                                if (interfaceC22696vg4.o0().a(abstractC19629qg4)) {
                                    return interfaceC22696vg4.o0().b(abstractC19629qg4);
                                }
                            } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                                e.c cVarW2 = rg1H.w2();
                                int i = 0;
                                rg1H = rg1H;
                                c12544en4 = c12544en4;
                                while (cVarW2 != null) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i++;
                                        c12544en4 = c12544en4;
                                        if (i == 1) {
                                            rg1H = cVarW2;
                                        } else {
                                            if (c12544en4 == 0) {
                                                c12544en4 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (rg1H != 0) {
                                                c12544en4.d(rg1H);
                                                rg1H = 0;
                                            }
                                            c12544en4.d(cVarW2);
                                        }
                                    }
                                    cVarW2 = cVarW2.S1();
                                    rg1H = rg1H;
                                    c12544en4 = c12544en4;
                                }
                                if (i == 1) {
                                }
                            }
                            rg1H = KG1.h(c12544en4);
                        }
                    }
                    cVarY1 = cVarY1.Y1();
                }
            }
            c3419Au3O = c3419Au3O.A0();
            cVarY1 = (c3419Au3O == null || (va4T0 = c3419Au3O.t0()) == null) ? null : va4T0.p();
        }
        return abstractC19629qg4.a().invoke();
    }
}
