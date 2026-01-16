package ir.nasim;

import android.os.Process;

/* renamed from: ir.nasim.ch8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC11081ch8 implements Runnable {
    private final Runnable a;

    public RunnableC11081ch8(Runnable runnable, int i) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(0);
        this.a.run();
    }
}
