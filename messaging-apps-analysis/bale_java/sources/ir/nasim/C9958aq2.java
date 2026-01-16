package ir.nasim;

/* renamed from: ir.nasim.aq2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C9958aq2 implements AI5 {
    private final String a;
    private final float b;

    public C9958aq2(String str, float f) {
        AbstractC13042fc3.i(str, "key");
        this.a = str;
        this.b = f;
    }

    @Override // ir.nasim.AI5
    public /* bridge */ /* synthetic */ void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
        d((InterfaceC9824ad1) obj, interfaceC5239Im3, ((Number) obj2).floatValue());
    }

    @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float a(InterfaceC9824ad1 interfaceC9824ad1, InterfaceC5239Im3 interfaceC5239Im3) {
        AbstractC13042fc3.i(interfaceC9824ad1, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        return Float.valueOf(interfaceC9824ad1.getFloat(this.a, this.b));
    }

    public void d(InterfaceC9824ad1 interfaceC9824ad1, InterfaceC5239Im3 interfaceC5239Im3, float f) {
        AbstractC13042fc3.i(interfaceC9824ad1, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        interfaceC9824ad1.i(this.a, f);
    }
}
