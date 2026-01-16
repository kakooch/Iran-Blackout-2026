package ir.nasim;

/* renamed from: ir.nasim.Jm, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5469Jm {
    public static final C5469Jm a = new C5469Jm();
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Im
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return Boolean.valueOf(C5469Jm.e());
        }
    });
    public static final int c = 8;

    private C5469Jm() {
    }

    private final boolean d() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e() {
        return AbstractC21784u76.d();
    }

    public final InterfaceC19567qa2 b(C13803gq6 c13803gq6) {
        AbstractC13042fc3.i(c13803gq6, "serajAnalytics");
        return d() ? c13803gq6 : PA1.a;
    }

    public final InterfaceC19567qa2 c(C22660vc8 c22660vc8) {
        AbstractC13042fc3.i(c22660vc8, "yandexMetricaAnalytics");
        return d() ? c22660vc8 : PA1.a;
    }
}
