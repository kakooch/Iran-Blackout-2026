package io.sentry;

import io.sentry.util.C3202a;

/* renamed from: io.sentry.g2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3119g2 {
    private static final C3119g2 d = new C3119g2();
    private boolean a;
    private Boolean b;
    private final C3202a c = new C3202a();

    private C3119g2() {
    }

    public static C3119g2 a() {
        return d;
    }

    public void b(boolean z) {
        InterfaceC3102d0 interfaceC3102d0A = this.c.a();
        try {
            if (!this.a) {
                this.b = Boolean.valueOf(z);
                this.a = true;
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
}
