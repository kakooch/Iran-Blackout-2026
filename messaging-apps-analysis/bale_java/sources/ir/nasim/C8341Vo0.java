package ir.nasim;

/* renamed from: ir.nasim.Vo0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8341Vo0 extends AbstractC7511Sa3 {
    public C8341Vo0(byte b) {
        super(Byte.valueOf(b));
    }

    @Override // ir.nasim.AbstractC7068Qd1
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public XC6 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        XC6 xc6T = interfaceC8507Wg4.n().t();
        AbstractC13042fc3.h(xc6T, "module.builtIns.byteType");
        return xc6T;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public String toString() {
        return ((Number) b()).intValue() + ".toByte()";
    }
}
