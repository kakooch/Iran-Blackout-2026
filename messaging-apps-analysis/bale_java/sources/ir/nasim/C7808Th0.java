package ir.nasim;

/* renamed from: ir.nasim.Th0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C7808Th0 implements AI5 {
    private final String a;
    private final boolean b;

    public C7808Th0(String str, boolean z) {
        AbstractC13042fc3.i(str, "key");
        this.a = str;
        this.b = z;
    }

    @Override // ir.nasim.AI5
    public /* bridge */ /* synthetic */ void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
        d((InterfaceC9824ad1) obj, interfaceC5239Im3, ((Boolean) obj2).booleanValue());
    }

    @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean a(InterfaceC9824ad1 interfaceC9824ad1, InterfaceC5239Im3 interfaceC5239Im3) {
        AbstractC13042fc3.i(interfaceC9824ad1, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        return Boolean.valueOf(interfaceC9824ad1.getBoolean(this.a, this.b));
    }

    public void d(InterfaceC9824ad1 interfaceC9824ad1, InterfaceC5239Im3 interfaceC5239Im3, boolean z) {
        AbstractC13042fc3.i(interfaceC9824ad1, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        interfaceC9824ad1.h(this.a, z);
    }
}
