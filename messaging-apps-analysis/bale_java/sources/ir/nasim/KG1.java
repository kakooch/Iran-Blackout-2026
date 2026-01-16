package ir.nasim;

import androidx.compose.ui.e;
import kotlin.KotlinNothingValueException;

/* loaded from: classes2.dex */
public abstract class KG1 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(C12544en4 c12544en4, e.c cVar, boolean z) {
        C12544en4 c12544en4E = e(o(cVar), z);
        int iO = c12544en4E.o() - 1;
        Object[] objArr = c12544en4E.a;
        if (iO < objArr.length) {
            while (iO >= 0) {
                c12544en4.d(((C3419Au3) objArr[iO]).t0().k());
                iO--;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final InterfaceC21655tu3 d(e.c cVar) {
        if ((AbstractC9572aB4.a(2) & cVar.W1()) != 0) {
            if (cVar instanceof InterfaceC21655tu3) {
                return (InterfaceC21655tu3) cVar;
            }
            if (cVar instanceof RG1) {
                e.c cVarW2 = ((RG1) cVar).w2();
                while (cVarW2 != 0) {
                    if (cVarW2 instanceof InterfaceC21655tu3) {
                        return (InterfaceC21655tu3) cVarW2;
                    }
                    cVarW2 = (!(cVarW2 instanceof RG1) || (AbstractC9572aB4.a(2) & cVarW2.W1()) == 0) ? cVarW2.S1() : ((RG1) cVarW2).w2();
                }
            }
        }
        return null;
    }

    private static final C12544en4 e(C3419Au3 c3419Au3, boolean z) {
        return z ? c3419Au3.F0() : c3419Au3.G0();
    }

    public static final boolean f(JG1 jg1, int i) {
        return (jg1.h().R1() & i) != 0;
    }

    public static final boolean g(JG1 jg1) {
        return jg1.h() == jg1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e.c h(C12544en4 c12544en4) {
        if (c12544en4 == null || c12544en4.o() == 0) {
            return null;
        }
        return (e.c) c12544en4.w(c12544en4.o() - 1);
    }

    public static final void i(JG1 jg1) {
        o(jg1).x1();
    }

    public static final XA4 j(JG1 jg1, int i) {
        XA4 xa4T1 = jg1.h().T1();
        AbstractC13042fc3.f(xa4T1);
        if (xa4T1.J2() != jg1 || !AbstractC10166bB4.i(i)) {
            return xa4T1;
        }
        XA4 xa4K2 = xa4T1.K2();
        AbstractC13042fc3.f(xa4K2);
        return xa4K2;
    }

    public static final WH1 k(JG1 jg1) {
        return o(jg1).T();
    }

    public static final InterfaceC20014rK2 l(JG1 jg1) {
        return p(jg1).getGraphicsContext();
    }

    public static final InterfaceC11379cu3 m(JG1 jg1) {
        if (!jg1.h().b2()) {
            M73.b("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        InterfaceC11379cu3 interfaceC11379cu3K1 = j(jg1, AbstractC9572aB4.a(2)).k1();
        if (!interfaceC11379cu3K1.b()) {
            M73.b("LayoutCoordinates is not attached.");
        }
        return interfaceC11379cu3K1;
    }

    public static final EnumC12613eu3 n(JG1 jg1) {
        return o(jg1).getLayoutDirection();
    }

    public static final C3419Au3 o(JG1 jg1) {
        XA4 xa4T1 = jg1.h().T1();
        if (xa4T1 != null) {
            return xa4T1.G1();
        }
        M73.c("Cannot obtain node coordinator. Is the Modifier.Node attached?");
        throw new KotlinNothingValueException();
    }

    public static final InterfaceC23714xO4 p(JG1 jg1) {
        InterfaceC23714xO4 interfaceC23714xO4Z0 = o(jg1).z0();
        if (interfaceC23714xO4Z0 != null) {
            return interfaceC23714xO4Z0;
        }
        M73.c("This node does not have an owner.");
        throw new KotlinNothingValueException();
    }

    public static final InterfaceC5953Ln6 q(JG1 jg1) {
        return o(jg1);
    }
}
