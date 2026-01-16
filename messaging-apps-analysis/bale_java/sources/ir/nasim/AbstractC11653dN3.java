package ir.nasim;

import android.os.Handler;
import android.os.Looper;

/* renamed from: ir.nasim.dN3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC11653dN3 {
    private static volatile Handler a;

    public static Handler a() {
        if (a != null) {
            return a;
        }
        synchronized (AbstractC11653dN3.class) {
            try {
                if (a == null) {
                    a = AbstractC18913pT2.a(Looper.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }
}
