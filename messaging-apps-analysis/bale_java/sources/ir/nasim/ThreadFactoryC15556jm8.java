package ir.nasim;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: ir.nasim.jm8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class ThreadFactoryC15556jm8 implements ThreadFactory {
    private final ThreadFactory a = Executors.defaultThreadFactory();

    ThreadFactoryC15556jm8(C15566jn8 c15566jn8) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.a.newThread(runnable);
        threadNewThread.setName("ScionFrontendApi");
        return threadNewThread;
    }
}
