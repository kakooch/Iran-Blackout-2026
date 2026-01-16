package ir.nasim;

import android.os.Process;

/* renamed from: ir.nasim.dh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C11876dh8 extends Thread {
    C11876dh8(ThreadGroup threadGroup, String str) {
        super(threadGroup, "GmsDynamite");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(19);
        synchronized (this) {
            while (true) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }
}
