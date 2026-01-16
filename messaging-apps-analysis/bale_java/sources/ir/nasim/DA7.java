package ir.nasim;

import ir.nasim.PJ6;

/* loaded from: classes8.dex */
public final class DA7 extends AbstractC10178bC7 {
    public DA7(short s) {
        super(Short.valueOf(s));
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public AbstractC4099Dr3 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        InterfaceC21331tU0 interfaceC21331tU0A = AbstractC23370wo2.a(interfaceC8507Wg4, PJ6.a.u0);
        XC6 xc6P = interfaceC21331tU0A == null ? null : interfaceC21331tU0A.p();
        if (xc6P != null) {
            return xc6P;
        }
        XC6 xc6J = AbstractC14230ha2.j("Unsigned type UShort not found");
        AbstractC13042fc3.h(xc6J, "createErrorType(\"Unsigned type UShort not found\")");
        return xc6J;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public String toString() {
        return ((Number) b()).intValue() + ".toUShort()";
    }
}
