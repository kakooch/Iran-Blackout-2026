package ir.nasim;

/* loaded from: classes8.dex */
public final class N92 extends AbstractC7068Qd1 {
    private final C24948zU0 b;
    private final C6432No4 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N92(C24948zU0 c24948zU0, C6432No4 c6432No4) {
        super(AbstractC4616Fw7.a(c24948zU0, c6432No4));
        AbstractC13042fc3.i(c24948zU0, "enumClassId");
        AbstractC13042fc3.i(c6432No4, "enumEntryName");
        this.b = c24948zU0;
        this.c = c6432No4;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public AbstractC4099Dr3 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        InterfaceC21331tU0 interfaceC21331tU0A = AbstractC23370wo2.a(interfaceC8507Wg4, this.b);
        XC6 xc6P = null;
        if (interfaceC21331tU0A != null) {
            if (!OI1.A(interfaceC21331tU0A)) {
                interfaceC21331tU0A = null;
            }
            if (interfaceC21331tU0A != null) {
                xc6P = interfaceC21331tU0A.p();
            }
        }
        if (xc6P != null) {
            return xc6P;
        }
        XC6 xc6J = AbstractC14230ha2.j("Containing class for error-class based enum entry " + this.b + '.' + this.c);
        AbstractC13042fc3.h(xc6J, "createErrorType(\"Containing class for error-class based enum entry $enumClassId.$enumEntryName\")");
        return xc6J;
    }

    public final C6432No4 c() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.j());
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }
}
