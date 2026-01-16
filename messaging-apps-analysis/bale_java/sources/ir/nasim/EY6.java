package ir.nasim;

/* loaded from: classes4.dex */
public final class EY6 implements AI5 {
    private final String a;
    private final String b;

    public EY6(String str, String str2) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(str2, "defaultValue");
        this.a = str;
        this.b = str2;
    }

    @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String a(InterfaceC9824ad1 interfaceC9824ad1, InterfaceC5239Im3 interfaceC5239Im3) {
        AbstractC13042fc3.i(interfaceC9824ad1, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        return interfaceC9824ad1.getString(this.a, this.b);
    }

    @Override // ir.nasim.AI5
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(InterfaceC9824ad1 interfaceC9824ad1, InterfaceC5239Im3 interfaceC5239Im3, String str) {
        AbstractC13042fc3.i(interfaceC9824ad1, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        AbstractC13042fc3.i(str, "value");
        interfaceC9824ad1.f(this.a, str);
    }
}
