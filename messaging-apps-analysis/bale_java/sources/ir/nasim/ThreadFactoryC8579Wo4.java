package ir.nasim;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: ir.nasim.Wo4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class ThreadFactoryC8579Wo4 implements ThreadFactory {
    private final String a;
    private final ThreadFactory b = Executors.defaultThreadFactory();

    public ThreadFactoryC8579Wo4(String str) {
        AbstractC3795Cj5.k(str, "Name must not be null");
        this.a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.b.newThread(new RunnableC11081ch8(runnable, 0));
        threadNewThread.setName(this.a);
        return threadNewThread;
    }
}
