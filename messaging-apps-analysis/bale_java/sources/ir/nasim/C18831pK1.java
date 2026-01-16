package ir.nasim;

/* renamed from: ir.nasim.pK1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18831pK1 {
    private final C9057Yh4 a;

    public C18831pK1(C9057Yh4 c9057Yh4) {
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.a = c9057Yh4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 c(C18831pK1 c18831pK1) {
        AbstractC13042fc3.i(c18831pK1, "this$0");
        return new C10860cK1(c18831pK1.a);
    }

    public final void b() {
        C12736f7.n().d("device_info/notifier", new V6() { // from class: ir.nasim.oK1
            @Override // ir.nasim.V6
            public final K6 create() {
                return C18831pK1.c(this.a);
            }
        });
    }
}
