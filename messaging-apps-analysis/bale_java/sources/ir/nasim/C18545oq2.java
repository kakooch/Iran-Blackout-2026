package ir.nasim;

/* renamed from: ir.nasim.oq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18545oq2 extends AbstractC7068Qd1 {
    public C18545oq2(float f) {
        super(Float.valueOf(f));
    }

    @Override // ir.nasim.AbstractC7068Qd1
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public XC6 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        XC6 xc6B = interfaceC8507Wg4.n().B();
        AbstractC13042fc3.h(xc6B, "module.builtIns.floatType");
        return xc6B;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public String toString() {
        return ((Number) b()).floatValue() + ".toFloat()";
    }
}
