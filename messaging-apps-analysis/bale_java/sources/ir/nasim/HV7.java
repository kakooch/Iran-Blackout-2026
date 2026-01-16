package ir.nasim;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class HV7 {
    private final Executor a;
    private final AtomicInteger b;

    public HV7(Executor executor) {
        AbstractC13042fc3.i(executor, "executor");
        this.a = executor;
        this.b = new AtomicInteger(0);
    }

    public final void a() {
        this.b.set(0);
        PI3.a("VideoUsageControl", "resetDirectly: mVideoUsage reset!");
    }
}
