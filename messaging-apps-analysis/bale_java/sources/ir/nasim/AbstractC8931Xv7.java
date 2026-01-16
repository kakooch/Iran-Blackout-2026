package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.Xv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC8931Xv7 {
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
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static final InterfaceC8645Wv7 a(JG1 jg1, Object obj) {
        VA4 va4T0;
        int iA = AbstractC9572aB4.a(262144);
        if (!jg1.h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = jg1.h().Y1();
        C3419Au3 c3419Au3O = KG1.o(jg1);
        while (c3419Au3O != null) {
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        RG1 rg1H = cVarY1;
                        ?? c12544en4 = 0;
                        while (rg1H != 0) {
                            if (rg1H instanceof InterfaceC8645Wv7) {
                                InterfaceC8645Wv7 interfaceC8645Wv7 = (InterfaceC8645Wv7) rg1H;
                                if (AbstractC13042fc3.d(obj, interfaceC8645Wv7.P())) {
                                    return interfaceC8645Wv7;
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
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v9 */
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
    public static final InterfaceC8645Wv7 b(InterfaceC8645Wv7 interfaceC8645Wv7) {
        VA4 va4T0;
        int iA = AbstractC9572aB4.a(262144);
        if (!interfaceC8645Wv7.h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = interfaceC8645Wv7.h().Y1();
        C3419Au3 c3419Au3O = KG1.o(interfaceC8645Wv7);
        while (c3419Au3O != null) {
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        RG1 rg1H = cVarY1;
                        ?? c12544en4 = 0;
                        while (rg1H != 0) {
                            if (rg1H instanceof InterfaceC8645Wv7) {
                                InterfaceC8645Wv7 interfaceC8645Wv72 = (InterfaceC8645Wv7) rg1H;
                                if (AbstractC13042fc3.d(interfaceC8645Wv7.P(), interfaceC8645Wv72.P()) && AbstractC15754k7.a(interfaceC8645Wv7, interfaceC8645Wv72)) {
                                    return interfaceC8645Wv72;
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
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [ir.nasim.UA2] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static final void c(JG1 jg1, Object obj, UA2 ua2) {
        VA4 va4T0;
        int iA = AbstractC9572aB4.a(262144);
        if (!jg1.h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = jg1.h().Y1();
        C3419Au3 c3419Au3O = KG1.o(jg1);
        while (c3419Au3O != null) {
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        RG1 rg1H = cVarY1;
                        ?? c12544en4 = 0;
                        while (rg1H != 0) {
                            if (rg1H instanceof InterfaceC8645Wv7) {
                                InterfaceC8645Wv7 interfaceC8645Wv7 = (InterfaceC8645Wv7) rg1H;
                                if (!(AbstractC13042fc3.d(obj, interfaceC8645Wv7.P()) ? ((Boolean) ua2.invoke(interfaceC8645Wv7)).booleanValue() : true)) {
                                    return;
                                }
                            } else {
                                if (((rg1H.W1() & iA) != 0) && (rg1H instanceof RG1)) {
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [ir.nasim.UA2] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [androidx.compose.ui.e$c] */
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
    public static final void d(InterfaceC8645Wv7 interfaceC8645Wv7, UA2 ua2) {
        VA4 va4T0;
        int iA = AbstractC9572aB4.a(262144);
        if (!interfaceC8645Wv7.h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = interfaceC8645Wv7.h().Y1();
        C3419Au3 c3419Au3O = KG1.o(interfaceC8645Wv7);
        while (c3419Au3O != null) {
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        RG1 rg1H = cVarY1;
                        ?? c12544en4 = 0;
                        while (rg1H != 0) {
                            boolean zBooleanValue = true;
                            if (rg1H instanceof InterfaceC8645Wv7) {
                                InterfaceC8645Wv7 interfaceC8645Wv72 = (InterfaceC8645Wv7) rg1H;
                                if (AbstractC13042fc3.d(interfaceC8645Wv7.P(), interfaceC8645Wv72.P()) && AbstractC15754k7.a(interfaceC8645Wv7, interfaceC8645Wv72)) {
                                    zBooleanValue = ((Boolean) ua2.invoke(interfaceC8645Wv72)).booleanValue();
                                }
                                if (!zBooleanValue) {
                                    return;
                                }
                            } else {
                                if (((rg1H.W1() & iA) != 0) && (rg1H instanceof RG1)) {
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [ir.nasim.UA2] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static final void e(JG1 jg1, Object obj, UA2 ua2) {
        int iA = AbstractC9572aB4.a(262144);
        if (!jg1.h().b2()) {
            M73.b("visitSubtreeIf called on an unattached node");
        }
        C12544en4 c12544en4 = new C12544en4(new e.c[16], 0);
        e.c cVarS1 = jg1.h().S1();
        if (cVarS1 == null) {
            KG1.c(c12544en4, jg1.h(), false);
        } else {
            c12544en4.d(cVarS1);
        }
        while (c12544en4.o() != 0) {
            e.c cVar = (e.c) c12544en4.w(c12544en4.o() - 1);
            if ((cVar.R1() & iA) != 0) {
                for (e.c cVarS12 = cVar; cVarS12 != null; cVarS12 = cVarS12.S1()) {
                    if ((cVarS12.W1() & iA) != 0) {
                        RG1 rg1H = cVarS12;
                        ?? c12544en42 = 0;
                        while (rg1H != 0) {
                            if (rg1H instanceof InterfaceC8645Wv7) {
                                InterfaceC8645Wv7 interfaceC8645Wv7 = (InterfaceC8645Wv7) rg1H;
                                EnumC8411Vv7 enumC8411Vv7 = AbstractC13042fc3.d(obj, interfaceC8645Wv7.P()) ? (EnumC8411Vv7) ua2.invoke(interfaceC8645Wv7) : EnumC8411Vv7.a;
                                if (enumC8411Vv7 == EnumC8411Vv7.c) {
                                    return;
                                }
                                if (enumC8411Vv7 == EnumC8411Vv7.b) {
                                    break;
                                }
                            } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                                e.c cVarW2 = rg1H.w2();
                                int i = 0;
                                rg1H = rg1H;
                                c12544en42 = c12544en42;
                                while (cVarW2 != null) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i++;
                                        c12544en42 = c12544en42;
                                        if (i == 1) {
                                            rg1H = cVarW2;
                                        } else {
                                            if (c12544en42 == 0) {
                                                c12544en42 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (rg1H != 0) {
                                                c12544en42.d(rg1H);
                                                rg1H = 0;
                                            }
                                            c12544en42.d(cVarW2);
                                        }
                                    }
                                    cVarW2 = cVarW2.S1();
                                    rg1H = rg1H;
                                    c12544en42 = c12544en42;
                                }
                                if (i == 1) {
                                }
                            }
                            rg1H = KG1.h(c12544en42);
                        }
                    }
                }
            }
            KG1.c(c12544en4, cVar, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [ir.nasim.UA2] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static final void f(InterfaceC8645Wv7 interfaceC8645Wv7, UA2 ua2) {
        int iA = AbstractC9572aB4.a(262144);
        if (!interfaceC8645Wv7.h().b2()) {
            M73.b("visitSubtreeIf called on an unattached node");
        }
        C12544en4 c12544en4 = new C12544en4(new e.c[16], 0);
        e.c cVarS1 = interfaceC8645Wv7.h().S1();
        if (cVarS1 == null) {
            KG1.c(c12544en4, interfaceC8645Wv7.h(), false);
        } else {
            c12544en4.d(cVarS1);
        }
        while (c12544en4.o() != 0) {
            e.c cVar = (e.c) c12544en4.w(c12544en4.o() - 1);
            if ((cVar.R1() & iA) != 0) {
                for (e.c cVarS12 = cVar; cVarS12 != null; cVarS12 = cVarS12.S1()) {
                    if ((cVarS12.W1() & iA) != 0) {
                        RG1 rg1H = cVarS12;
                        ?? c12544en42 = 0;
                        while (rg1H != 0) {
                            if (rg1H instanceof InterfaceC8645Wv7) {
                                InterfaceC8645Wv7 interfaceC8645Wv72 = (InterfaceC8645Wv7) rg1H;
                                EnumC8411Vv7 enumC8411Vv7 = (AbstractC13042fc3.d(interfaceC8645Wv7.P(), interfaceC8645Wv72.P()) && AbstractC15754k7.a(interfaceC8645Wv7, interfaceC8645Wv72)) ? (EnumC8411Vv7) ua2.invoke(interfaceC8645Wv72) : EnumC8411Vv7.a;
                                if (enumC8411Vv7 == EnumC8411Vv7.c) {
                                    return;
                                }
                                if (enumC8411Vv7 == EnumC8411Vv7.b) {
                                    break;
                                }
                            } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                                e.c cVarW2 = rg1H.w2();
                                int i = 0;
                                rg1H = rg1H;
                                c12544en42 = c12544en42;
                                while (cVarW2 != null) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i++;
                                        c12544en42 = c12544en42;
                                        if (i == 1) {
                                            rg1H = cVarW2;
                                        } else {
                                            if (c12544en42 == 0) {
                                                c12544en42 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (rg1H != 0) {
                                                c12544en42.d(rg1H);
                                                rg1H = 0;
                                            }
                                            c12544en42.d(cVarW2);
                                        }
                                    }
                                    cVarW2 = cVarW2.S1();
                                    rg1H = rg1H;
                                    c12544en42 = c12544en42;
                                }
                                if (i == 1) {
                                }
                            }
                            rg1H = KG1.h(c12544en42);
                        }
                    }
                }
            }
            KG1.c(c12544en4, cVar, false);
        }
    }
}
