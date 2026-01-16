package ir.nasim;

import ir.nasim.C9475a16;

/* renamed from: ir.nasim.Hg1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4949Hg1 {
    private final InterfaceC3570Bk5 a;
    private final C4933He3 b;
    private final EnumC4715Gg1 c;
    private final InterfaceC9336Zm4 d;

    public C4949Hg1(InterfaceC3570Bk5 interfaceC3570Bk5, C4933He3 c4933He3) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "mainConfig");
        AbstractC13042fc3.i(c4933He3, "canUserSortContactsList");
        this.a = interfaceC3570Bk5;
        this.b = c4933He3;
        this.c = EnumC4715Gg1.d;
        this.d = AbstractC12281eL6.a(c());
    }

    private final EnumC4715Gg1 c() {
        return !((Boolean) this.b.b().getValue()).booleanValue() ? EnumC4715Gg1.c : d(this.a.getString("LAST_SAVED_SORT_TYPE_KEY", ""));
    }

    private final EnumC4715Gg1 d(String str) {
        Object objB;
        if (str == null || AbstractC20762sZ6.n0(str)) {
            return this.c;
        }
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b(EnumC4715Gg1.valueOf(str));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        EnumC4715Gg1 enumC4715Gg1 = this.c;
        if (C9475a16.g(objB)) {
            objB = enumC4715Gg1;
        }
        return (EnumC4715Gg1) objB;
    }

    public final void a(EnumC4715Gg1 enumC4715Gg1) {
        AbstractC13042fc3.i(enumC4715Gg1, "sortType");
        this.d.setValue(enumC4715Gg1);
        this.a.putString("LAST_SAVED_SORT_TYPE_KEY", enumC4715Gg1.name());
    }

    public final InterfaceC10258bL6 b() {
        return AbstractC6459Nq2.c(this.d);
    }
}
