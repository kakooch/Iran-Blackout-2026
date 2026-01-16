package ir.nasim;

/* renamed from: ir.nasim.cJ3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C10853cJ3 implements AI5 {
    private final String a;
    private final long b;

    public C10853cJ3(String str, long j) {
        AbstractC13042fc3.i(str, "key");
        this.a = str;
        this.b = j;
    }

    @Override // ir.nasim.AI5
    public /* bridge */ /* synthetic */ void b(Object obj, InterfaceC5239Im3 interfaceC5239Im3, Object obj2) {
        d((InterfaceC9824ad1) obj, interfaceC5239Im3, ((Number) obj2).longValue());
    }

    @Override // ir.nasim.AI5, ir.nasim.InterfaceC23661xI5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long a(InterfaceC9824ad1 interfaceC9824ad1, InterfaceC5239Im3 interfaceC5239Im3) {
        AbstractC13042fc3.i(interfaceC9824ad1, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        return Long.valueOf(interfaceC9824ad1.getLong(this.a, this.b));
    }

    public void d(InterfaceC9824ad1 interfaceC9824ad1, InterfaceC5239Im3 interfaceC5239Im3, long j) {
        AbstractC13042fc3.i(interfaceC9824ad1, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        interfaceC9824ad1.b(this.a, j);
    }
}
