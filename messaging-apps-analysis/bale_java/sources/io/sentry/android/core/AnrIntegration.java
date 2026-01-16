package io.sentry.android.core;

import android.content.Context;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3157o0;
import io.sentry.L2;
import io.sentry.Y2;
import io.sentry.android.core.C3040c;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.util.C3202a;
import java.io.Closeable;

/* loaded from: classes3.dex */
public final class AnrIntegration implements InterfaceC3157o0, Closeable {
    private static C3040c e;
    protected static final C3202a f = new C3202a();
    private final Context a;
    private boolean b = false;
    private final C3202a c = new C3202a();
    private C3155n3 d;

    static final class a implements io.sentry.hints.a, io.sentry.hints.q {
        private final boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // io.sentry.hints.a
        public Long e() {
            return null;
        }

        @Override // io.sentry.hints.a
        public boolean f() {
            return true;
        }

        @Override // io.sentry.hints.a
        public String h() {
            return this.a ? "anr_background" : "anr_foreground";
        }
    }

    public AnrIntegration(Context context) {
        this.a = AbstractC3060k0.g(context);
    }

    private Throwable d(boolean z, SentryAndroidOptions sentryAndroidOptions, ApplicationNotResponding applicationNotResponding) {
        String str = "ANR for at least " + sentryAndroidOptions.getAnrTimeoutIntervalMillis() + " ms.";
        if (z) {
            str = "Background " + str;
        }
        ApplicationNotResponding applicationNotResponding2 = new ApplicationNotResponding(str, applicationNotResponding.a());
        io.sentry.protocol.j jVar = new io.sentry.protocol.j();
        jVar.p("ANR");
        return new ExceptionMechanismException(jVar, applicationNotResponding2, applicationNotResponding2.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(io.sentry.Z z, SentryAndroidOptions sentryAndroidOptions) {
        InterfaceC3102d0 interfaceC3102d0A = this.c.a();
        try {
            if (!this.b) {
                l(z, sentryAndroidOptions);
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

    private void j(final io.sentry.Z z, final SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.getLogger().c(Y2.DEBUG, "AnrIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isAnrEnabled()));
        if (sentryAndroidOptions.isAnrEnabled()) {
            io.sentry.util.o.a("Anr");
            try {
                sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.K
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e(z, sentryAndroidOptions);
                    }
                });
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(Y2.DEBUG, "Failed to start AnrIntegration on executor thread.", th);
            }
        }
    }

    private void l(final io.sentry.Z z, final SentryAndroidOptions sentryAndroidOptions) {
        InterfaceC3102d0 interfaceC3102d0A = f.a();
        try {
            if (e == null) {
                ILogger logger = sentryAndroidOptions.getLogger();
                Y2 y2 = Y2.DEBUG;
                logger.c(y2, "ANR timeout in milliseconds: %d", Long.valueOf(sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                C3040c c3040c = new C3040c(sentryAndroidOptions.getAnrTimeoutIntervalMillis(), sentryAndroidOptions.isAnrReportInDebug(), new C3040c.a() { // from class: io.sentry.android.core.L
                    @Override // io.sentry.android.core.C3040c.a
                    public final void a(ApplicationNotResponding applicationNotResponding) {
                        this.a.g(z, sentryAndroidOptions, applicationNotResponding);
                    }
                }, sentryAndroidOptions.getLogger(), this.a);
                e = c3040c;
                c3040c.start();
                sentryAndroidOptions.getLogger().c(y2, "AnrIntegration installed.", new Object[0]);
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

    @Override // io.sentry.InterfaceC3157o0
    public final void c(io.sentry.Z z, C3155n3 c3155n3) {
        this.d = (C3155n3) io.sentry.util.u.c(c3155n3, "SentryOptions is required");
        j(z, (SentryAndroidOptions) c3155n3);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InterfaceC3102d0 interfaceC3102d0A = this.c.a();
        try {
            this.b = true;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            interfaceC3102d0A = f.a();
            try {
                C3040c c3040c = e;
                if (c3040c != null) {
                    c3040c.interrupt();
                    e = null;
                    C3155n3 c3155n3 = this.d;
                    if (c3155n3 != null) {
                        c3155n3.getLogger().c(Y2.DEBUG, "AnrIntegration removed.", new Object[0]);
                    }
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void g(io.sentry.Z z, SentryAndroidOptions sentryAndroidOptions, ApplicationNotResponding applicationNotResponding) {
        sentryAndroidOptions.getLogger().c(Y2.INFO, "ANR triggered with message: %s", applicationNotResponding.getMessage());
        boolean zEquals = Boolean.TRUE.equals(X.j().k());
        L2 l2 = new L2(d(zEquals, sentryAndroidOptions, applicationNotResponding));
        l2.D0(Y2.ERROR);
        z.I(l2, io.sentry.util.m.e(new a(zEquals)));
    }
}
