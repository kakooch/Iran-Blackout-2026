package ir.nasim;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes5.dex */
public final class EL implements ThreadFactory {
    private final ThreadFactory a;
    private final String b;

    /* JADX WARN: Multi-variable type inference failed */
    public EL() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        AbstractC13042fc3.i(runnable, "r");
        Thread threadNewThread = this.a.newThread(runnable);
        if (threadNewThread == null) {
            return null;
        }
        threadNewThread.setName(this.b + "-" + threadNewThread.getName());
        return threadNewThread;
    }

    public EL(ThreadFactory threadFactory, String str) {
        AbstractC13042fc3.i(threadFactory, "defaultFactory");
        AbstractC13042fc3.i(str, "threadNamePrefix");
        this.a = threadFactory;
        this.b = str;
    }

    public /* synthetic */ EL(ThreadFactory threadFactory, String str, int i, ED1 ed1) {
        this((i & 1) != 0 ? Executors.defaultThreadFactory() : threadFactory, (i & 2) != 0 ? "S_ATC_Connect" : str);
    }
}
