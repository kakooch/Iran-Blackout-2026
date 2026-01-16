package ir.nasim;

import androidx.compose.ui.e;
import androidx.compose.ui.focus.FocusTargetNode;

/* renamed from: ir.nasim.bB4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10166bB4 {
    private static final C3348Am4 a = AbstractC21866uG4.b();

    public static final void a(e.c cVar) {
        if (!cVar.b2()) {
            M73.b("autoInvalidateInsertedNode called on unattached node");
        }
        b(cVar, -1, 1);
    }

    public static final void b(e.c cVar, int i, int i2) {
        if (!(cVar instanceof RG1)) {
            c(cVar, i & cVar.W1(), i2);
            return;
        }
        RG1 rg1 = (RG1) cVar;
        c(cVar, rg1.x2() & i, i2);
        int i3 = (~rg1.x2()) & i;
        for (e.c cVarW2 = rg1.w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
            b(cVarW2, i3, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void c(e.c cVar, int i, int i2) {
        if (i2 != 0 || cVar.getShouldAutoInvalidate()) {
            if ((AbstractC9572aB4.a(2) & i) != 0 && (cVar instanceof InterfaceC21655tu3)) {
                AbstractC23431wu3.b((InterfaceC21655tu3) cVar);
                if (i2 == 2) {
                    KG1.j(cVar, AbstractC9572aB4.a(2)).h3();
                }
            }
            if ((AbstractC9572aB4.a(128) & i) != 0 && (cVar instanceof InterfaceC9398Zt3) && i2 != 2) {
                KG1.o(cVar).O0();
            }
            if ((AbstractC9572aB4.a(256) & i) != 0 && (cVar instanceof InterfaceC15868kJ2) && i2 != 2) {
                KG1.o(cVar).P0();
            }
            if ((AbstractC9572aB4.a(4) & i) != 0 && (cVar instanceof InterfaceC15687k02)) {
                AbstractC16278l02.a((InterfaceC15687k02) cVar);
            }
            if ((AbstractC9572aB4.a(8) & i) != 0 && (cVar instanceof InterfaceC7163Qn6)) {
                KG1.o(cVar).X1(true);
            }
            if ((AbstractC9572aB4.a(64) & i) != 0 && (cVar instanceof InterfaceC24970zW4)) {
                AW4.a((InterfaceC24970zW4) cVar);
            }
            if ((AbstractC9572aB4.a(2048) & i) != 0 && (cVar instanceof InterfaceC4815Gr2)) {
                InterfaceC4815Gr2 interfaceC4815Gr2 = (InterfaceC4815Gr2) cVar;
                if (k(interfaceC4815Gr2)) {
                    if (C15439jb1.g || i2 == 2) {
                        j(interfaceC4815Gr2);
                    } else {
                        AbstractC5049Hr2.a(interfaceC4815Gr2);
                    }
                }
            }
            if ((i & AbstractC9572aB4.a(4096)) == 0 || !(cVar instanceof InterfaceC20937sr2)) {
                return;
            }
            AbstractC21624tr2.b((InterfaceC20937sr2) cVar);
        }
    }

    public static final void d(e.c cVar) {
        if (!cVar.b2()) {
            M73.b("autoInvalidateRemovedNode called on unattached node");
        }
        b(cVar, -1, 2);
    }

    public static final void e(e.c cVar) {
        if (!cVar.b2()) {
            M73.b("autoInvalidateUpdatedNode called on unattached node");
        }
        b(cVar, -1, 0);
    }

    public static final int f(e.b bVar) {
        int iA = AbstractC9572aB4.a(1);
        if (bVar instanceof InterfaceC20377ru3) {
            iA |= AbstractC9572aB4.a(2);
        }
        if (bVar instanceof InterfaceC15096j02) {
            iA |= AbstractC9572aB4.a(4);
        }
        if (bVar instanceof InterfaceC6685On6) {
            iA |= AbstractC9572aB4.a(8);
        }
        if (bVar instanceof InterfaceC8274Vg5) {
            iA |= AbstractC9572aB4.a(16);
        }
        if ((bVar instanceof InterfaceC20236rg4) || (bVar instanceof InterfaceC23882xg4)) {
            iA |= AbstractC9572aB4.a(32);
        }
        if (bVar instanceof InterfaceC17052mJ4) {
            iA |= AbstractC9572aB4.a(256);
        }
        if (bVar instanceof InterfaceC24376yW4) {
            iA |= AbstractC9572aB4.a(64);
        }
        return bVar instanceof InterfaceC6886Pk0 ? iA | AbstractC9572aB4.a(524288) : iA;
    }

    public static final int g(e.c cVar) {
        if (cVar.W1() != 0) {
            return cVar.W1();
        }
        C3348Am4 c3348Am4 = a;
        Object objB = AbstractC15754k7.b(cVar);
        int iB = c3348Am4.b(objB);
        if (iB >= 0) {
            return c3348Am4.c[iB];
        }
        int iA = AbstractC9572aB4.a(1);
        if (cVar instanceof InterfaceC21655tu3) {
            iA |= AbstractC9572aB4.a(2);
        }
        if (cVar instanceof InterfaceC15687k02) {
            iA |= AbstractC9572aB4.a(4);
        }
        if (cVar instanceof InterfaceC7163Qn6) {
            iA |= AbstractC9572aB4.a(8);
        }
        if (cVar instanceof InterfaceC8508Wg5) {
            iA |= AbstractC9572aB4.a(16);
        }
        if (cVar instanceof InterfaceC22696vg4) {
            iA |= AbstractC9572aB4.a(32);
        }
        if (cVar instanceof InterfaceC24970zW4) {
            iA |= AbstractC9572aB4.a(64);
        }
        if (cVar instanceof InterfaceC9398Zt3) {
            iA |= AbstractC9572aB4.a(128);
        }
        if (cVar instanceof InterfaceC15868kJ2) {
            iA |= AbstractC9572aB4.a(256);
        }
        if (cVar instanceof FocusTargetNode) {
            iA |= AbstractC9572aB4.a(1024);
        }
        if (cVar instanceof InterfaceC4815Gr2) {
            iA |= AbstractC9572aB4.a(2048);
        }
        if (cVar instanceof InterfaceC20937sr2) {
            iA |= AbstractC9572aB4.a(4096);
        }
        if (cVar instanceof InterfaceC24551yo3) {
            iA |= AbstractC9572aB4.a(8192);
        }
        if (cVar instanceof E46) {
            iA |= AbstractC9572aB4.a(16384);
        }
        if (cVar instanceof InterfaceC9814ac1) {
            iA |= AbstractC9572aB4.a(32768);
        }
        if (cVar instanceof InterfaceC8645Wv7) {
            iA |= AbstractC9572aB4.a(262144);
        }
        int iA2 = cVar instanceof InterfaceC6886Pk0 ? AbstractC9572aB4.a(524288) | iA : iA;
        c3348Am4.u(objB, iA2);
        return iA2;
    }

    public static final int h(e.c cVar) {
        if (!(cVar instanceof RG1)) {
            return g(cVar);
        }
        RG1 rg1 = (RG1) cVar;
        int iX2 = rg1.x2();
        for (e.c cVarW2 = rg1.w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
            iX2 |= h(cVarW2);
        }
        return iX2;
    }

    public static final boolean i(int i) {
        return (i & AbstractC9572aB4.a(128)) != 0;
    }

    private static final void j(InterfaceC4815Gr2 interfaceC4815Gr2) {
        int iA = AbstractC9572aB4.a(1024);
        if (!interfaceC4815Gr2.h().b2()) {
            M73.b("visitChildren called on an unattached node");
        }
        C12544en4 c12544en4 = new C12544en4(new e.c[16], 0);
        e.c cVarS1 = interfaceC4815Gr2.h().S1();
        if (cVarS1 == null) {
            KG1.c(c12544en4, interfaceC4815Gr2.h(), false);
        } else {
            c12544en4.d(cVarS1);
        }
        while (c12544en4.o() != 0) {
            e.c cVarH = (e.c) c12544en4.w(c12544en4.o() - 1);
            if ((cVarH.R1() & iA) == 0) {
                KG1.c(c12544en4, cVarH, false);
            } else {
                while (true) {
                    if (cVarH == null) {
                        break;
                    }
                    if ((cVarH.W1() & iA) != 0) {
                        C12544en4 c12544en42 = null;
                        while (cVarH != null) {
                            if (cVarH instanceof FocusTargetNode) {
                                AbstractC6218Mr2.b((FocusTargetNode) cVarH);
                            } else if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                                int i = 0;
                                for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i++;
                                        if (i == 1) {
                                            cVarH = cVarW2;
                                        } else {
                                            if (c12544en42 == null) {
                                                c12544en42 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (cVarH != null) {
                                                c12544en42.d(cVarH);
                                                cVarH = null;
                                            }
                                            c12544en42.d(cVarW2);
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            cVarH = KG1.h(c12544en42);
                        }
                    } else {
                        cVarH = cVarH.S1();
                    }
                }
            }
        }
    }

    private static final boolean k(InterfaceC4815Gr2 interfaceC4815Gr2) {
        C21170tE0 c21170tE0 = C21170tE0.a;
        c21170tE0.c();
        interfaceC4815Gr2.b1(c21170tE0);
        return c21170tE0.a();
    }
}
