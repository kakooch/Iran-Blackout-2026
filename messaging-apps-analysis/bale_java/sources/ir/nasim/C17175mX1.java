package ir.nasim;

/* renamed from: ir.nasim.mX1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17175mX1 extends AbstractC7068Qd1 {
    public C17175mX1(double d) {
        super(Double.valueOf(d));
    }

    @Override // ir.nasim.AbstractC7068Qd1
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public XC6 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        XC6 xc6Z = interfaceC8507Wg4.n().z();
        AbstractC13042fc3.h(xc6Z, "module.builtIns.doubleType");
        return xc6Z;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public String toString() {
        return ((Number) b()).doubleValue() + ".toDouble()";
    }
}
