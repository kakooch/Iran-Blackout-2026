package ir.nasim;

/* loaded from: classes8.dex */
public abstract class KG4 implements AI5 {
    private Object a;

    public KG4(Object obj) {
        this.a = obj;
    }

    @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
    public Object a(Object obj, InterfaceC5239Im3 interfaceC5239Im3) {
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        return this.a;
    }

    @Override // ir.nasim.AI5
    public void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        Object obj3 = this.a;
        if (d(interfaceC5239Im3, obj3, obj2)) {
            this.a = obj2;
            c(interfaceC5239Im3, obj3, obj2);
        }
    }

    protected void c(InterfaceC5239Im3 interfaceC5239Im3, Object obj, Object obj2) {
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
    }

    protected abstract boolean d(InterfaceC5239Im3 interfaceC5239Im3, Object obj, Object obj2);

    public String toString() {
        return "ObservableProperty(value=" + this.a + ')';
    }
}
