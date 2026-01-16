package ir.nasim;

import java.util.concurrent.Executor;

/* loaded from: classes8.dex */
final class ZU1 implements Executor {
    public final AbstractC13778go1 a;

    public ZU1(AbstractC13778go1 abstractC13778go1) {
        this.a = abstractC13778go1;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        AbstractC13778go1 abstractC13778go1 = this.a;
        C18712p72 c18712p72 = C18712p72.a;
        if (abstractC13778go1.A0(c18712p72)) {
            this.a.x0(c18712p72, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.a.toString();
    }
}
