package ir.nasim;

import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

/* loaded from: classes8.dex */
public abstract class RI3 {
    static volatile int a;
    static final C21041t07 b = new C21041t07();
    static final C5726Ko4 c = new C5726Ko4();
    static boolean d = AbstractC12909fN7.f("slf4j.detectLoggerNameMismatch");
    private static final String[] e = {"1.6", "1.7"};
    private static String f = "org/slf4j/impl/StaticLoggerBinder.class";

    private static final void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Set setF;
        try {
            try {
                if (l()) {
                    setF = null;
                } else {
                    setF = f();
                    t(setF);
                }
                StaticLoggerBinder.getSingleton();
                a = 3;
                s(setF);
            } catch (Exception e2) {
                e(e2);
                throw new IllegalStateException("Unexpected initialization failure", e2);
            } catch (NoClassDefFoundError e3) {
                if (!m(e3.getMessage())) {
                    e(e3);
                    throw e3;
                }
                a = 4;
                AbstractC12909fN7.c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                AbstractC12909fN7.c("Defaulting to no-operation (NOP) logger implementation");
                AbstractC12909fN7.c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
            } catch (NoSuchMethodError e4) {
                String message = e4.getMessage();
                if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                    a = 2;
                    AbstractC12909fN7.c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                    AbstractC12909fN7.c("Your binding is version 1.5.5 or earlier.");
                    AbstractC12909fN7.c("Upgrade your binding to version 1.6.x.");
                }
                throw e4;
            }
            p();
        } catch (Throwable th) {
            p();
            throw th;
        }
    }

    private static void b(C21715u07 c21715u07, int i) {
        if (c21715u07.a().o()) {
            c(i);
        } else {
            if (c21715u07.a().t()) {
                return;
            }
            d();
        }
    }

    private static void c(int i) {
        AbstractC12909fN7.c("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        AbstractC12909fN7.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        AbstractC12909fN7.c("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        AbstractC12909fN7.c("The following set of substitute loggers may have been accessed");
        AbstractC12909fN7.c("during the initialization phase. Logging calls during this");
        AbstractC12909fN7.c("phase were not honored. However, subsequent logging calls to these");
        AbstractC12909fN7.c("loggers will work as normally expected.");
        AbstractC12909fN7.c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static void e(Throwable th) {
        a = 2;
        AbstractC12909fN7.d("Failed to instantiate SLF4J LoggerFactory", th);
    }

    static Set f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = RI3.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f) : classLoader.getResources(f);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e2) {
            AbstractC12909fN7.d("Error getting resources from path", e2);
        }
        return linkedHashSet;
    }

    private static void g() {
        C21041t07 c21041t07 = b;
        synchronized (c21041t07) {
            try {
                c21041t07.e();
                for (C20438s07 c20438s07 : c21041t07.d()) {
                    c20438s07.A(j(c20438s07.getName()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ILoggerFactory h() {
        if (a == 0) {
            synchronized (RI3.class) {
                try {
                    if (a == 0) {
                        a = 1;
                        o();
                    }
                } finally {
                }
            }
        }
        int i = a;
        if (i == 1) {
            return b;
        }
        if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        if (i == 4) {
            return c;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static OI3 i(Class cls) {
        Class clsA;
        OI3 oi3J = j(cls.getName());
        if (d && (clsA = AbstractC12909fN7.a()) != null && n(cls, clsA)) {
            AbstractC12909fN7.c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", oi3J.getName(), clsA.getName()));
            AbstractC12909fN7.c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return oi3J;
    }

    public static OI3 j(String str) {
        return h().a(str);
    }

    private static boolean k(Set set) {
        return set.size() > 1;
    }

    private static boolean l() {
        String strG = AbstractC12909fN7.g("java.vendor.url");
        if (strG == null) {
            return false;
        }
        return strG.toLowerCase().contains(ConstantDeviceInfo.APP_PLATFORM);
    }

    private static boolean m(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    private static boolean n(Class cls, Class cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    private static final void o() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a();
        if (a == 3) {
            u();
        }
    }

    private static void p() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        g();
        q();
        b.b();
    }

    private static void q() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        LinkedBlockingQueue linkedBlockingQueueC = b.c();
        int size = linkedBlockingQueueC.size();
        ArrayList<C21715u07> arrayList = new ArrayList(128);
        int i = 0;
        while (linkedBlockingQueueC.drainTo(arrayList, 128) != 0) {
            for (C21715u07 c21715u07 : arrayList) {
                r(c21715u07);
                int i2 = i + 1;
                if (i == 0) {
                    b(c21715u07, size);
                }
                i = i2;
            }
            arrayList.clear();
        }
    }

    private static void r(C21715u07 c21715u07) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (c21715u07 == null) {
            return;
        }
        C20438s07 c20438s07A = c21715u07.a();
        String name = c20438s07A.getName();
        if (c20438s07A.v()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (c20438s07A.t()) {
            return;
        }
        if (c20438s07A.o()) {
            c20438s07A.x(c21715u07);
        } else {
            AbstractC12909fN7.c(name);
        }
    }

    private static void s(Set set) {
        if (set == null || !k(set)) {
            return;
        }
        AbstractC12909fN7.c("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
    }

    private static void t(Set set) {
        if (k(set)) {
            AbstractC12909fN7.c("Class path contains multiple SLF4J bindings.");
            Iterator it = set.iterator();
            while (it.hasNext()) {
                AbstractC12909fN7.c("Found binding in [" + ((URL) it.next()) + "]");
            }
            AbstractC12909fN7.c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static final void u() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z = false;
            for (String str2 : e) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            AbstractC12909fN7.c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(e).toString());
            AbstractC12909fN7.c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            AbstractC12909fN7.d("Unexpected problem occured during version sanity check", th);
        }
    }
}
