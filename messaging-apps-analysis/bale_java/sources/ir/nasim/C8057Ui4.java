package ir.nasim;

/* renamed from: ir.nasim.Ui4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C8057Ui4 implements InterfaceC7821Ti4 {
    private final InterfaceC14123hO3 a;

    public C8057Ui4(InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(interfaceC14123hO3, "monitoringEventToSentryEventMapper");
        this.a = interfaceC14123hO3;
    }

    @Override // ir.nasim.InterfaceC7821Ti4
    public void a(InterfaceC8291Vi4 interfaceC8291Vi4) {
        AbstractC13042fc3.i(interfaceC8291Vi4, "event");
        io.sentry.Z1.g((io.sentry.L2) this.a.a(interfaceC8291Vi4));
    }

    public C8057Ui4() {
        this(C8791Xi4.a);
    }
}
