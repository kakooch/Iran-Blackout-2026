package androidx.compose.ui.focus;

import androidx.compose.ui.e;
import androidx.compose.ui.focus.d;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC9572aB4;
import ir.nasim.C12544en4;
import ir.nasim.C3419Au3;
import ir.nasim.InterfaceC15468je0;
import ir.nasim.KG1;
import ir.nasim.M73;
import ir.nasim.RG1;
import ir.nasim.UA2;
import ir.nasim.VA4;

/* loaded from: classes2.dex */
public abstract class a {
    public static final Object a(FocusTargetNode focusTargetNode, int i, UA2 ua2) {
        e.c cVarH;
        InterfaceC15468je0 interfaceC15468je0D2;
        int iC;
        VA4 va4T0;
        int iA = AbstractC9572aB4.a(1024);
        if (!focusTargetNode.h().b2()) {
            M73.b("visitAncestors called on an unattached node");
        }
        e.c cVarY1 = focusTargetNode.h().Y1();
        C3419Au3 c3419Au3O = KG1.o(focusTargetNode);
        loop0: while (true) {
            if (c3419Au3O == null) {
                cVarH = null;
                break;
            }
            if ((c3419Au3O.t0().k().R1() & iA) != 0) {
                while (cVarY1 != null) {
                    if ((cVarY1.W1() & iA) != 0) {
                        cVarH = cVarY1;
                        C12544en4 c12544en4 = null;
                        while (cVarH != null) {
                            if (cVarH instanceof FocusTargetNode) {
                                break loop0;
                            }
                            if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                                int i2 = 0;
                                for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            cVarH = cVarW2;
                                        } else {
                                            if (c12544en4 == null) {
                                                c12544en4 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (cVarH != null) {
                                                c12544en4.d(cVarH);
                                                cVarH = null;
                                            }
                                            c12544en4.d(cVarW2);
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            cVarH = KG1.h(c12544en4);
                        }
                    }
                    cVarY1 = cVarY1.Y1();
                }
            }
            c3419Au3O = c3419Au3O.A0();
            cVarY1 = (c3419Au3O == null || (va4T0 = c3419Au3O.t0()) == null) ? null : va4T0.p();
        }
        FocusTargetNode focusTargetNode2 = (FocusTargetNode) cVarH;
        if ((focusTargetNode2 != null && AbstractC13042fc3.d(focusTargetNode2.D2(), focusTargetNode.D2())) || (interfaceC15468je0D2 = focusTargetNode.D2()) == null) {
            return null;
        }
        d.a aVar = d.b;
        if (d.l(i, aVar.h())) {
            iC = InterfaceC15468je0.b.a.a();
        } else if (d.l(i, aVar.a())) {
            iC = InterfaceC15468je0.b.a.d();
        } else if (d.l(i, aVar.d())) {
            iC = InterfaceC15468je0.b.a.e();
        } else if (d.l(i, aVar.g())) {
            iC = InterfaceC15468je0.b.a.f();
        } else if (d.l(i, aVar.e())) {
            iC = InterfaceC15468je0.b.a.b();
        } else {
            if (!d.l(i, aVar.f())) {
                throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
            }
            iC = InterfaceC15468je0.b.a.c();
        }
        return interfaceC15468je0D2.A0(iC, ua2);
    }
}
