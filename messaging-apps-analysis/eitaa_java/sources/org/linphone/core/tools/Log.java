package org.linphone.core.tools;

/* loaded from: classes3.dex */
public final class Log {
    private static String domain = "linphone-android";
    private static Log logger;

    private native void d(String str, String str2);

    private native void e(String str, String str2);

    private native void f(String str, String str2);

    private native void i(String str, String str2);

    private native void setDomain(String str);

    private native void w(String str, String str2);

    private static Log instance() {
        if (logger == null) {
            logger = new Log();
            setLogDomain(domain);
        }
        return logger;
    }

    private Log() {
    }

    public static void setLogDomain(String str) {
        instance().setDomain(str);
        domain = str;
    }

    public static void d(Object... objArr) {
        instance().d(domain, toString(objArr));
    }

    public static void i(Object... objArr) {
        instance().i(domain, toString(objArr));
    }

    public static void w(Object... objArr) {
        instance().w(domain, toString(objArr));
    }

    public static void e(Object... objArr) {
        instance().e(domain, toString(objArr));
    }

    public static void f(Object... objArr) {
        instance().f(domain, toString(objArr));
    }

    private static String toString(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb.toString();
    }
}
