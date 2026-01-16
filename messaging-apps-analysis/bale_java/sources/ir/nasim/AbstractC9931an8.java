package ir.nasim;

import android.os.StrictMode;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.an8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC9931an8 {
    public static Object a(Callable callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            return callable.call();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
