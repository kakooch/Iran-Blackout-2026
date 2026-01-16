package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;
import kotlin.UninitializedPropertyAccessException;

/* renamed from: ir.nasim.fc3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13042fc3 {

    /* renamed from: ir.nasim.fc3$a */
    public static class a {
    }

    public static boolean a(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    public static boolean b(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    public static boolean c(Float f, Float f2) {
        if (f == null) {
            if (f2 != null) {
                return false;
            }
        } else if (f2 == null || f.floatValue() != f2.floatValue()) {
            return false;
        }
        return true;
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) o(new IllegalStateException(str + " must not be null")));
    }

    public static void f(Object obj) {
        if (obj == null) {
            r();
        }
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            s(str);
        }
    }

    public static void h(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) o(new NullPointerException(str + " must not be null")));
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            u(str);
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            t(str);
        }
    }

    public static int k(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int l(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    private static String m(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = AbstractC13042fc3.class.getName();
        int i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + Separators.DOT + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void n(int i, String str) {
        v();
    }

    private static Throwable o(Throwable th) {
        return p(th, AbstractC13042fc3.class.getName());
    }

    static Throwable p(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return th;
    }

    public static String q(String str, Object obj) {
        return str + obj;
    }

    public static void r() {
        throw ((NullPointerException) o(new NullPointerException()));
    }

    public static void s(String str) {
        throw ((NullPointerException) o(new NullPointerException(str)));
    }

    private static void t(String str) {
        throw ((IllegalArgumentException) o(new IllegalArgumentException(m(str))));
    }

    private static void u(String str) {
        throw ((NullPointerException) o(new NullPointerException(m(str))));
    }

    public static void v() {
        w("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void w(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void x(String str) {
        throw ((UninitializedPropertyAccessException) o(new UninitializedPropertyAccessException(str)));
    }

    public static void y(String str) {
        x("lateinit property " + str + " has not been initialized");
    }
}
