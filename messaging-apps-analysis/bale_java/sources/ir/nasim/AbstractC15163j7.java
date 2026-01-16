package ir.nasim;

import android.os.Handler;
import android.os.Looper;

/* renamed from: ir.nasim.j7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15163j7 {
    private static final Handler a = new Handler(Looper.getMainLooper());

    public static final long b() {
        return System.currentTimeMillis();
    }

    public static final Object c(long j, final SA2 sa2) {
        Runnable runnable = new Runnable() { // from class: ir.nasim.i7
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC15163j7.d(sa2);
            }
        };
        a.postDelayed(runnable, j);
        return runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(SA2 sa2) {
        sa2.invoke();
    }

    public static final void e(Object obj) {
        if ((obj instanceof Runnable ? (Runnable) obj : null) == null) {
            return;
        }
        a.removeCallbacks((Runnable) obj);
    }
}
