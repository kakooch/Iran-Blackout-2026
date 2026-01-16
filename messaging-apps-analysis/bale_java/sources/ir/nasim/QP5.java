package ir.nasim;

/* loaded from: classes6.dex */
public final class QP5 {
    public static final QP5 a = new QP5();
    private static final InterfaceC3570Bk5 b = C7183Qq.q(EnumC18608ow5.f);
    public static final int c = 8;

    private QP5() {
    }

    public final int a() {
        return b.getInt("ir.nasim.features.pfm.data.default_tab_index", 0);
    }

    public final boolean b() {
        return b.h("ir.nasim.features.pfm.data.show_description_tooltip", true);
    }

    public final boolean c() {
        return b.h("ir.nasim.features.pfm.data.is_first_intro", true);
    }

    public final boolean d() {
        return b.h("ir.nasim.features.pfm.data.handle_first", false);
    }

    public final boolean e() {
        return b.h("ir.nasim.features.pfm.data.select_first", false);
    }

    public final void f(int i) {
        b.putInt("ir.nasim.features.pfm.data.default_tab_index", i);
    }

    public final void g(boolean z) {
        b.g("ir.nasim.features.pfm.data.show_description_tooltip", z);
    }

    public final void h(boolean z) {
        b.g("ir.nasim.features.pfm.data.is_first_intro", z);
    }

    public final void i(boolean z) {
        b.g("ir.nasim.features.pfm.data.handle_first", z);
    }

    public final void j(boolean z) {
        b.g("ir.nasim.features.pfm.data.select_first", z);
    }
}
