package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Ck5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3804Ck5 {
    private final InterfaceC3570Bk5 a;
    private final KS2 b;

    public C3804Ck5(InterfaceC3570Bk5 interfaceC3570Bk5, KS2 ks2) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "prefs");
        AbstractC13042fc3.i(ks2, "gson");
        this.a = interfaceC3570Bk5;
        this.b = ks2;
    }

    public final void a(String str) {
        AbstractC13042fc3.i(str, "key");
        this.a.remove(str);
    }

    public final KS2 b() {
        return this.b;
    }

    public final InterfaceC3570Bk5 c() {
        return this.a;
    }

    public final void d(String str, List list) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(list, "list");
        this.a.putString(str, this.b.t(list));
    }

    public /* synthetic */ C3804Ck5(InterfaceC3570Bk5 interfaceC3570Bk5, KS2 ks2, int i, ED1 ed1) {
        this(interfaceC3570Bk5, (i & 2) != 0 ? new KS2() : ks2);
    }
}
