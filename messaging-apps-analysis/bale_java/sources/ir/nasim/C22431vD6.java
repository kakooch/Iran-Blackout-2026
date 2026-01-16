package ir.nasim;

/* renamed from: ir.nasim.vD6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22431vD6 implements InterfaceC7566Sg4 {
    public C11881di3 a;

    @Override // ir.nasim.InterfaceC7566Sg4
    public InterfaceC21331tU0 a(InterfaceC7106Qh3 interfaceC7106Qh3) {
        AbstractC13042fc3.i(interfaceC7106Qh3, "javaClass");
        return b().b(interfaceC7106Qh3);
    }

    public final C11881di3 b() {
        C11881di3 c11881di3 = this.a;
        if (c11881di3 != null) {
            return c11881di3;
        }
        AbstractC13042fc3.y("resolver");
        throw null;
    }

    public final void c(C11881di3 c11881di3) {
        AbstractC13042fc3.i(c11881di3, "<set-?>");
        this.a = c11881di3;
    }
}
