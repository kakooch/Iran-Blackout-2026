package ir.nasim;

/* renamed from: ir.nasim.aZ6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9790aZ6 extends AbstractC7068Qd1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9790aZ6(String str) {
        super(str);
        AbstractC13042fc3.i(str, "value");
    }

    @Override // ir.nasim.AbstractC7068Qd1
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public XC6 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        XC6 xc6V = interfaceC8507Wg4.n().V();
        AbstractC13042fc3.h(xc6V, "module.builtIns.stringType");
        return xc6V;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public String toString() {
        return '\"' + ((String) b()) + '\"';
    }
}
