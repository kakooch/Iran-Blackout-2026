package ir.nasim;

import ir.nasim.InterfaceC6170Mm;

/* loaded from: classes5.dex */
public final class KI5 {
    private long a;
    private long b;

    public final long a() {
        return this.b;
    }

    public final void b(InterfaceC6170Mm.a aVar) {
        AbstractC13042fc3.i(aVar, "eventTime");
        this.b += aVar.a - this.a;
        this.a = 0L;
    }

    public final void c(InterfaceC6170Mm.a aVar) {
        AbstractC13042fc3.i(aVar, "eventTime");
        this.a = aVar.a;
    }

    public final void d() {
        this.a = 0L;
        this.b = 0L;
    }
}
