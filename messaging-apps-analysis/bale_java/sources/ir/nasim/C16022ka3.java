package ir.nasim;

/* renamed from: ir.nasim.ka3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C16022ka3 implements AI5 {
    private final String a;
    private final int b;

    public C16022ka3(String str, int i) {
        AbstractC13042fc3.i(str, "key");
        this.a = str;
        this.b = i;
    }

    @Override // ir.nasim.AI5
    public /* bridge */ /* synthetic */ void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
        d((InterfaceC9824ad1) obj, interfaceC5239Im3, ((Number) obj2).intValue());
    }

    @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Integer a(InterfaceC9824ad1 interfaceC9824ad1, InterfaceC5239Im3 interfaceC5239Im3) {
        AbstractC13042fc3.i(interfaceC9824ad1, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        return Integer.valueOf(interfaceC9824ad1.getInt(this.a, this.b));
    }

    public void d(InterfaceC9824ad1 interfaceC9824ad1, InterfaceC5239Im3 interfaceC5239Im3, int i) {
        AbstractC13042fc3.i(interfaceC9824ad1, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        interfaceC9824ad1.e(this.a, i);
    }
}
