package ir.nasim;

/* renamed from: ir.nasim.uh3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22115uh3 {
    public static final C22115uh3 a = new C22115uh3();
    private static long b = -1;
    public static final int c = 8;

    private C22115uh3() {
    }

    public static final void a(EnumC22705vh3 enumC22705vh3, EnumC22705vh3 enumC22705vh32) {
        AbstractC13042fc3.i(enumC22705vh3, "previousSelectedTab");
        AbstractC13042fc3.i(enumC22705vh32, "currentTab");
        if (enumC22705vh3 != enumC22705vh32) {
            a.d(enumC22705vh3);
        }
        b = -1L;
    }

    public static final void b() {
        b = System.currentTimeMillis();
    }

    public static final void c(EnumC22705vh3 enumC22705vh3) {
        AbstractC13042fc3.i(enumC22705vh3, "previousSelectedTab");
        a.d(enumC22705vh3);
        b = -1L;
    }

    private final void d(EnumC22705vh3 enumC22705vh3) {
        if (b < 0) {
            return;
        }
        XV4 xv4A = AbstractC4616Fw7.a("duration_seconds", Long.valueOf((System.currentTimeMillis() - b) / 1000));
        String lowerCase = enumC22705vh3.name().toLowerCase();
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        C3343Am.i("flow_tab_click", AbstractC20051rO3.n(xv4A, AbstractC4616Fw7.a("event_type", lowerCase)));
    }

    public final void e() {
        C3343Am.h("flow_search_v2", "action_type", 1);
    }
}
