package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/* renamed from: ir.nasim.Cj5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3795Cj5 {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void c(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void d(Handler handler) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != handler.getLooper()) {
            String name = looperMyLooper != null ? looperMyLooper.getThread().getName() : "null current looper";
            throw new IllegalStateException("Must be called on " + handler.getLooper().getThread().getName() + " thread, but got " + name + Separators.DOT);
        }
    }

    public static void e(String str) {
        if (!AbstractC22140uj8.a()) {
            throw new IllegalStateException(str);
        }
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    public static String g(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static void h() {
        i("Must not be called on the main application thread");
    }

    public static void i(String str) {
        if (AbstractC22140uj8.a()) {
            throw new IllegalStateException(str);
        }
    }

    public static Object j(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("null reference");
    }

    public static Object k(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static int l(int i) {
        if (i != 0) {
            return i;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    public static void m(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void n(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
