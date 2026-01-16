package ir.nasim;

/* loaded from: classes3.dex */
public final class CX7 implements AI5 {
    private final SA2 a;
    private Object b;

    public CX7(Object obj, SA2 sa2) {
        AbstractC13042fc3.i(sa2, "invalidator");
        this.a = sa2;
        this.b = obj;
    }

    @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
    public Object a(Object obj, InterfaceC5239Im3 interfaceC5239Im3) {
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        return this.b;
    }

    @Override // ir.nasim.AI5
    public void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        if (AbstractC13042fc3.d(this.b, obj2)) {
            return;
        }
        this.b = obj2;
        this.a.invoke();
    }
}
