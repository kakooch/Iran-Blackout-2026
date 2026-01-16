package ir.nasim;

/* renamed from: ir.nasim.Iz6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5359Iz6 extends AbstractC7511Sa3 {
    public C5359Iz6(short s) {
        super(Short.valueOf(s));
    }

    @Override // ir.nasim.AbstractC7068Qd1
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public XC6 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        XC6 xc6S = interfaceC8507Wg4.n().S();
        AbstractC13042fc3.h(xc6S, "module.builtIns.shortType");
        return xc6S;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public String toString() {
        return ((Number) b()).intValue() + ".toShort()";
    }
}
