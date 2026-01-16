package ir.nasim;

import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.Am, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C3343Am {
    public static final C3343Am a = new C3343Am();
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.zm
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C3343Am.b();
        }
    });
    public static final int c = 8;

    private C3343Am() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6409Nm b() {
        C92 c92 = C92.a;
        return ((InterfaceC5001Hm) C92.a(C5721Ko.a.d(), InterfaceC5001Hm.class)).M();
    }

    private final C6409Nm c() {
        return (C6409Nm) b.getValue();
    }

    public static final void d(String str, String str2, int i) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(str2, "key");
        if (AbstractC21784u76.d()) {
            C17213mb2.k(str, str2, Integer.valueOf(i));
            a.c().c(str, str2, Integer.valueOf(i));
        }
    }

    public static final void e(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "params");
        if (AbstractC21784u76.d()) {
            C17213mb2.m(str, map);
            a.c().d(str, map);
        }
    }

    public static final void f(int i, int i2, boolean z) {
        HashMap map = new HashMap();
        map.put("permissions", Integer.valueOf(i));
        map.put("peer_id", Integer.valueOf(i2));
        map.put("is_active", Boolean.valueOf(z));
        map.put("peer_type", "channel");
        i("toggle_comment", map);
    }

    public static final void g(String str) {
        AbstractC13042fc3.i(str, "eventName");
        if (AbstractC21784u76.d()) {
            a.c().b(str);
        }
    }

    public static final void h(String str, String str2, int i) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(str2, "key");
        if (AbstractC21784u76.d()) {
            a.c().c(str, str2, Integer.valueOf(i));
        }
    }

    public static final void i(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "params");
        if (AbstractC21784u76.d()) {
            a.c().d(str, map);
        }
    }

    public static final void j(String str, Map map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "params");
        if (AbstractC21784u76.d()) {
            C17213mb2.m(str, map);
        }
    }
}
