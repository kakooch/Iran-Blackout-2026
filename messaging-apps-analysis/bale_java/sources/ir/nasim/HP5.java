package ir.nasim;

/* loaded from: classes5.dex */
public final class HP5 {
    private final AbstractC13778go1 a;
    private final FP5 b;

    public HP5(AbstractC13778go1 abstractC13778go1, FP5 fp5) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(fp5, "reportRepository");
        this.a = abstractC13778go1;
        this.b = fp5;
    }

    public final InterfaceC4557Fq2 a(String str, String str2, OP5 op5) {
        AbstractC13042fc3.i(str, "storyId");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(op5, "reportType");
        return AbstractC6459Nq2.V(this.b.d(str, str2, op5), this.a);
    }
}
