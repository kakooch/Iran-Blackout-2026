package ir.nasim;

/* loaded from: classes5.dex */
public final class WF2 {
    private final AbstractC13778go1 a;
    private final InterfaceC17587nD2 b;

    public WF2(AbstractC13778go1 abstractC13778go1, InterfaceC17587nD2 interfaceC17587nD2) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC17587nD2, "galleryRepository");
        this.a = abstractC13778go1;
        this.b = interfaceC17587nD2;
    }

    public final InterfaceC4557Fq2 a(String str) {
        AbstractC13042fc3.i(str, "key");
        return AbstractC6459Nq2.V(this.b.a(str), this.a);
    }
}
