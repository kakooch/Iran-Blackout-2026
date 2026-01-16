package io.sentry.util;

import io.sentry.InterfaceC3102d0;

/* loaded from: classes3.dex */
public final class q {
    private final a b;
    private volatile Object a = null;
    private final C3202a c = new C3202a();

    public interface a {
        Object a();
    }

    public q(a aVar) {
        this.b = aVar;
    }

    public Object a() {
        if (this.a == null) {
            InterfaceC3102d0 interfaceC3102d0A = this.c.a();
            try {
                if (this.a == null) {
                    this.a = this.b.a();
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
        return this.a;
    }

    public void b() {
        InterfaceC3102d0 interfaceC3102d0A = this.c.a();
        try {
            this.a = null;
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

    public void c(Object obj) {
        InterfaceC3102d0 interfaceC3102d0A = this.c.a();
        try {
            this.a = obj;
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
}
