package io.appmetrica.analytics.coreapi.internal.executors;

/* loaded from: classes3.dex */
public class InterruptionSafeThread extends Thread implements IInterruptionSafeThread {
    private volatile boolean a;

    public InterruptionSafeThread() {
        this.a = true;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized boolean isRunning() {
        return this.a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public synchronized void stopRunning() {
        this.a = false;
        interrupt();
    }

    public InterruptionSafeThread(Runnable runnable, String str) {
        super(runnable, str);
        this.a = true;
    }

    public InterruptionSafeThread(String str) {
        super(str);
        this.a = true;
    }

    public InterruptionSafeThread(Runnable runnable) {
        super(runnable);
        this.a = true;
    }
}
