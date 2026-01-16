package ir.nasim;

/* renamed from: ir.nasim.yJ3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24258yJ3 extends AbstractC7511Sa3 {
    public C24258yJ3(long j) {
        super(Long.valueOf(j));
    }

    @Override // ir.nasim.AbstractC7068Qd1
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public XC6 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        XC6 xc6F = interfaceC8507Wg4.n().F();
        AbstractC13042fc3.h(xc6F, "module.builtIns.longType");
        return xc6F;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public String toString() {
        return ((Number) b()).longValue() + ".toLong()";
    }
}
