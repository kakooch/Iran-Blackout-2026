package ir.nasim;

import android.os.Handler;
import android.os.Looper;

/* renamed from: ir.nasim.np7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC17949np7 {
    public static void a() {
        AbstractC4980Hj5.j(c(), "Not in application's main thread");
    }

    private static Handler b() {
        return new Handler(Looper.getMainLooper());
    }

    public static boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void d(Runnable runnable) {
        if (c()) {
            runnable.run();
        } else {
            AbstractC4980Hj5.j(b().post(runnable), "Unable to post to main thread");
        }
    }
}
