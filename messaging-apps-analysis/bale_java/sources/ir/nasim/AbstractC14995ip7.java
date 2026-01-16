package ir.nasim;

import android.os.Looper;

/* renamed from: ir.nasim.ip7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC14995ip7 {
    private static Thread a;

    public static void a() {
        if (!b()) {
            throw new IllegalStateException("Must be called on the Main thread.");
        }
    }

    public static boolean b() {
        if (a == null) {
            a = Looper.getMainLooper().getThread();
        }
        return Thread.currentThread() == a;
    }
}
