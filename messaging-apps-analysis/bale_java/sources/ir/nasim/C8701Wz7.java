package ir.nasim;

import ir.nasim.PJ6;

/* renamed from: ir.nasim.Wz7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8701Wz7 extends AbstractC10178bC7 {
    public C8701Wz7(byte b) {
        super(Byte.valueOf(b));
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public AbstractC4099Dr3 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        InterfaceC21331tU0 interfaceC21331tU0A = AbstractC23370wo2.a(interfaceC8507Wg4, PJ6.a.t0);
        XC6 xc6P = interfaceC21331tU0A == null ? null : interfaceC21331tU0A.p();
        if (xc6P != null) {
            return xc6P;
        }
        XC6 xc6J = AbstractC14230ha2.j("Unsigned type UByte not found");
        AbstractC13042fc3.h(xc6J, "createErrorType(\"Unsigned type UByte not found\")");
        return xc6J;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public String toString() {
        return ((Number) b()).intValue() + ".toUByte()";
    }
}
