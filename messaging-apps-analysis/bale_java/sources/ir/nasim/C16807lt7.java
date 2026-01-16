package ir.nasim;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: ir.nasim.lt7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16807lt7 {
    public static final C16807lt7 a = new C16807lt7();
    private static long b;
    private static Method c;
    private static Method d;

    private C16807lt7() {
    }

    public static final void a(String str) {
        AbstractC13042fc3.i(str, "label");
        Trace.beginSection(a.h(str));
    }

    public static final void b() {
        Trace.endSection();
    }

    private final void c(String str, Exception exc) throws Throwable {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = ((InvocationTargetException) exc).getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw cause;
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static final boolean d() {
        return Build.VERSION.SDK_INT >= 29 ? C17989nt7.a.a() : a.e();
    }

    private final boolean e() throws Throwable {
        try {
            if (c == null) {
                b = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                c = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            Method method = c;
            if (method == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            Object objInvoke = method.invoke(null, Long.valueOf(b));
            AbstractC13042fc3.g(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            c("isTagEnabled", e);
            return false;
        }
    }

    public static final void f(String str, int i) throws Throwable {
        AbstractC13042fc3.i(str, "counterName");
        if (Build.VERSION.SDK_INT >= 29) {
            C17989nt7.a.b(a.h(str), i);
        } else {
            C16807lt7 c16807lt7 = a;
            c16807lt7.g(c16807lt7.h(str), i);
        }
    }

    private final void g(String str, int i) throws Throwable {
        try {
            if (d == null) {
                d = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            Method method = d;
            if (method == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            method.invoke(null, Long.valueOf(b), str, Integer.valueOf(i));
        } catch (Exception e) {
            c("traceCounter", e);
        }
    }

    private final String h(String str) {
        String str2 = str.length() <= 127 ? str : null;
        if (str2 != null) {
            return str2;
        }
        String strSubstring = str.substring(0, 127);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }
}
