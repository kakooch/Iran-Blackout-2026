package ir.nasim;

import java.util.List;

/* loaded from: classes5.dex */
public final class W34 implements PO6 {
    @Override // ir.nasim.PO6
    public InterfaceC3570Bk5 b() {
        return new T34();
    }

    @Override // ir.nasim.PO6
    public void d(List list) {
        AbstractC13042fc3.i(list, "tablesToClear");
    }

    @Override // ir.nasim.PO6
    public long e() {
        return -1L;
    }

    @Override // ir.nasim.PO6
    public void f(String str) {
        AbstractC13042fc3.i(str, "tablesPrefixForClear");
    }

    @Override // ir.nasim.PO6
    public XB3 g(String str) {
        AbstractC13042fc3.i(str, "name");
        return new Q34();
    }

    @Override // ir.nasim.PO6
    public AbstractC9119Yo3 h(C86 c86, String str, InterfaceC17311ml0 interfaceC17311ml0, InterfaceC15345jQ7 interfaceC15345jQ7) {
        AbstractC13042fc3.i(c86, "sqLiteType");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(interfaceC17311ml0, "bserCreator");
        return new M34(str);
    }

    @Override // ir.nasim.PO6
    public void a() {
    }

    @Override // ir.nasim.PO6
    public void c() {
    }
}
