package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: ir.nasim.eN3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC12296eN3 {
    private static volatile ScheduledExecutorService a;

    static ScheduledExecutorService a() {
        if (a != null) {
            return a;
        }
        synchronized (AbstractC12296eN3.class) {
            try {
                if (a == null) {
                    a = new ScheduledExecutorServiceC22571vT2(new Handler(Looper.getMainLooper()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }
}
