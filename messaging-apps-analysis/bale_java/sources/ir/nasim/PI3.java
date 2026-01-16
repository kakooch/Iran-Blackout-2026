package ir.nasim;

import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class PI3 {
    private static int a = 3;

    public static void a(String str, String str2) {
        String strK = k(str);
        if (g(strK, 3)) {
            Log.d(strK, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        String strK = k(str);
        if (g(strK, 3)) {
            Log.d(strK, str2, th);
        }
    }

    public static void c(String str, String str2) {
        String strK = k(str);
        if (g(strK, 6)) {
            Log.e(strK, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        String strK = k(str);
        if (g(strK, 6)) {
            Log.e(strK, str2, th);
        }
    }

    public static void e(String str, String str2) {
        String strK = k(str);
        if (g(strK, 4)) {
            Log.i(strK, str2);
        }
    }

    public static boolean f(String str) {
        return g(k(str), 3);
    }

    private static boolean g(String str, int i) {
        return a <= i || Log.isLoggable(str, i);
    }

    public static boolean h(String str) {
        return g(k(str), 2);
    }

    static void i() {
        a = 3;
    }

    static void j(int i) {
        a = i;
    }

    private static String k(String str) {
        return (Build.VERSION.SDK_INT > 25 || 23 >= str.length()) ? str : str.substring(0, 23);
    }

    public static void l(String str, String str2) {
        String strK = k(str);
        if (g(strK, 5)) {
            Log.w(strK, str2);
        }
    }

    public static void m(String str, String str2, Throwable th) {
        String strK = k(str);
        if (g(strK, 5)) {
            Log.w(strK, str2, th);
        }
    }
}
