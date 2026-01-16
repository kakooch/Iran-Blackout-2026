package io.sentry;

import io.sentry.util.C3202a;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public final class W2 {
    private static volatile W2 c;
    private static final C3202a d = new C3202a();
    private static volatile Boolean e = null;
    private static final C3202a f = new C3202a();
    private final Set a = new CopyOnWriteArraySet();
    private final Set b = new CopyOnWriteArraySet();

    private W2() {
    }

    public static W2 d() {
        if (c == null) {
            InterfaceC3102d0 interfaceC3102d0A = d.a();
            try {
                if (c == null) {
                    c = new W2();
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } catch (Throwable th) {
                if (interfaceC3102d0A != null) {
                    try {
                        interfaceC3102d0A.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        return c;
    }

    public void a(String str) {
        io.sentry.util.u.c(str, "integration is required.");
        this.a.add(str);
    }

    public void b(String str, String str2) {
        io.sentry.util.u.c(str, "name is required.");
        io.sentry.util.u.c(str2, "version is required.");
        this.b.add(new io.sentry.protocol.w(str, str2));
        InterfaceC3102d0 interfaceC3102d0A = f.a();
        try {
            e = null;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean c(ILogger iLogger) {
        Boolean bool = e;
        if (bool != null) {
            return bool.booleanValue();
        }
        InterfaceC3102d0 interfaceC3102d0A = f.a();
        try {
            boolean z = false;
            for (io.sentry.protocol.w wVar : this.b) {
                if (wVar.a().startsWith("maven:io.sentry:") && !"8.20.0".equalsIgnoreCase(wVar.b())) {
                    iLogger.c(Y2.ERROR, "The Sentry SDK has been configured with mixed versions. Expected %s to match core SDK version %s but was %s", wVar.a(), "8.20.0", wVar.b());
                    z = true;
                }
            }
            if (z) {
                Y2 y2 = Y2.ERROR;
                iLogger.c(y2, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
                iLogger.c(y2, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
                iLogger.c(y2, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
                iLogger.c(y2, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^", new Object[0]);
            }
            e = Boolean.valueOf(z);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return z;
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public Set e() {
        return this.a;
    }

    public Set f() {
        return this.b;
    }
}
