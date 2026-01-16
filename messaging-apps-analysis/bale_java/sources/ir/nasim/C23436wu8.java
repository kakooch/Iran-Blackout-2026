package ir.nasim;

import android.os.Process;

/* renamed from: ir.nasim.wu8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C23436wu8 extends Thread {
    C23436wu8(Runnable runnable, String str) {
        super(runnable, str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        super.run();
    }
}
