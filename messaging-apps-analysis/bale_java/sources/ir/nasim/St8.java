package ir.nasim;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
final class St8 implements ThreadFactory {
    private static final AtomicInteger a = new AtomicInteger();

    /* synthetic */ St8(AbstractC13835gt8 abstractC13835gt8) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int iIncrementAndGet = a.incrementAndGet();
        StringBuilder sb = new StringBuilder(23);
        sb.append("measurement-");
        sb.append(iIncrementAndGet);
        return new C23436wu8(runnable, sb.toString());
    }
}
