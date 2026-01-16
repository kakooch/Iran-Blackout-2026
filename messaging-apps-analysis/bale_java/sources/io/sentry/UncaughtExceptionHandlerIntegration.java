package io.sentry;

import android.gov.nist.core.Separators;
import io.sentry.Z3;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.util.C3202a;
import java.io.Closeable;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class UncaughtExceptionHandlerIntegration implements InterfaceC3157o0, Thread.UncaughtExceptionHandler, Closeable {
    private static final C3202a f = new C3202a();
    private Thread.UncaughtExceptionHandler a;
    private Z b;
    private C3155n3 c;
    private boolean d;
    private final Z3 e;

    public static class a extends io.sentry.hints.d implements io.sentry.hints.l, io.sentry.hints.q {
        private final AtomicReference d;

        public a(long j, ILogger iLogger) {
            super(j, iLogger);
            this.d = new AtomicReference();
        }

        @Override // io.sentry.hints.f
        public boolean b(io.sentry.protocol.v vVar) {
            io.sentry.protocol.v vVar2 = (io.sentry.protocol.v) this.d.get();
            return vVar2 != null && vVar2.equals(vVar);
        }

        @Override // io.sentry.hints.f
        public void c(io.sentry.protocol.v vVar) {
            this.d.set(vVar);
        }
    }

    public UncaughtExceptionHandlerIntegration() {
        this(Z3.a.c());
    }

    static Throwable a(Thread thread, Throwable th) {
        io.sentry.protocol.j jVar = new io.sentry.protocol.j();
        jVar.n(Boolean.FALSE);
        jVar.p("UncaughtExceptionHandler");
        return new ExceptionMechanismException(jVar, th, thread);
    }

    private void b(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        d(uncaughtExceptionHandler, new HashSet());
    }

    private void d(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Set set) {
        if (uncaughtExceptionHandler == null) {
            C3155n3 c3155n3 = this.c;
            if (c3155n3 != null) {
                c3155n3.getLogger().c(Y2.DEBUG, "Found no UncaughtExceptionHandler to remove.", new Object[0]);
                return;
            }
            return;
        }
        if (!set.add(uncaughtExceptionHandler)) {
            C3155n3 c3155n32 = this.c;
            if (c3155n32 != null) {
                c3155n32.getLogger().c(Y2.WARNING, "Cycle detected in UncaughtExceptionHandler chain while removing handler.", new Object[0]);
                return;
            }
            return;
        }
        if (uncaughtExceptionHandler instanceof UncaughtExceptionHandlerIntegration) {
            UncaughtExceptionHandlerIntegration uncaughtExceptionHandlerIntegration = (UncaughtExceptionHandlerIntegration) uncaughtExceptionHandler;
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = uncaughtExceptionHandlerIntegration.a;
            if (this != uncaughtExceptionHandler2) {
                d(uncaughtExceptionHandler2, set);
                return;
            }
            uncaughtExceptionHandlerIntegration.a = this.a;
            C3155n3 c3155n33 = this.c;
            if (c3155n33 != null) {
                c3155n33.getLogger().c(Y2.DEBUG, "UncaughtExceptionHandlerIntegration removed.", new Object[0]);
            }
        }
    }

    @Override // io.sentry.InterfaceC3157o0
    public final void c(Z z, C3155n3 c3155n3) {
        if (this.d) {
            c3155n3.getLogger().c(Y2.ERROR, "Attempt to register a UncaughtExceptionHandlerIntegration twice.", new Object[0]);
            return;
        }
        this.d = true;
        this.b = (Z) io.sentry.util.u.c(z, "Scopes are required");
        C3155n3 c3155n32 = (C3155n3) io.sentry.util.u.c(c3155n3, "SentryOptions is required");
        this.c = c3155n32;
        ILogger logger = c3155n32.getLogger();
        Y2 y2 = Y2.DEBUG;
        logger.c(y2, "UncaughtExceptionHandlerIntegration enabled: %s", Boolean.valueOf(this.c.isEnableUncaughtExceptionHandler()));
        if (this.c.isEnableUncaughtExceptionHandler()) {
            InterfaceC3102d0 interfaceC3102d0A = f.a();
            try {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandlerB = this.e.b();
                if (uncaughtExceptionHandlerB != null) {
                    this.c.getLogger().c(y2, "default UncaughtExceptionHandler class='" + uncaughtExceptionHandlerB.getClass().getName() + Separators.QUOTE, new Object[0]);
                    if (uncaughtExceptionHandlerB instanceof UncaughtExceptionHandlerIntegration) {
                        UncaughtExceptionHandlerIntegration uncaughtExceptionHandlerIntegration = (UncaughtExceptionHandlerIntegration) uncaughtExceptionHandlerB;
                        if (uncaughtExceptionHandlerIntegration.b == null || z.D() != uncaughtExceptionHandlerIntegration.b.D()) {
                            this.a = uncaughtExceptionHandlerB;
                        } else {
                            this.a = uncaughtExceptionHandlerIntegration.a;
                        }
                    } else {
                        this.a = uncaughtExceptionHandlerB;
                    }
                }
                this.e.a(this);
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
                this.c.getLogger().c(y2, "UncaughtExceptionHandlerIntegration installed.", new Object[0]);
                io.sentry.util.o.a("UncaughtExceptionHandler");
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InterfaceC3102d0 interfaceC3102d0A = f.a();
        try {
            if (this == this.e.b()) {
                this.e.a(this.a);
                C3155n3 c3155n3 = this.c;
                if (c3155n3 != null) {
                    c3155n3.getLogger().c(Y2.DEBUG, "UncaughtExceptionHandlerIntegration removed.", new Object[0]);
                }
            } else {
                b(this.e.b());
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

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        C3155n3 c3155n3 = this.c;
        if (c3155n3 == null || this.b == null) {
            return;
        }
        c3155n3.getLogger().c(Y2.INFO, "Uncaught exception received.", new Object[0]);
        try {
            a aVar = new a(this.c.getFlushTimeoutMillis(), this.c.getLogger());
            L2 l2 = new L2(a(thread, th));
            l2.D0(Y2.FATAL);
            if (this.b.f() == null && l2.G() != null) {
                aVar.c(l2.G());
            }
            I iE = io.sentry.util.m.e(aVar);
            boolean zEquals = this.b.I(l2, iE).equals(io.sentry.protocol.v.b);
            io.sentry.hints.h hVarF = io.sentry.util.m.f(iE);
            if ((!zEquals || io.sentry.hints.h.MULTITHREADED_DEDUPLICATION.equals(hVarF)) && !aVar.g()) {
                this.c.getLogger().c(Y2.WARNING, "Timed out waiting to flush event to disk before crashing. Event: %s", l2.G());
            }
        } catch (Throwable th2) {
            this.c.getLogger().b(Y2.ERROR, "Error sending uncaught exception to Sentry.", th2);
        }
        if (this.a != null) {
            this.c.getLogger().c(Y2.INFO, "Invoking inner uncaught exception handler.", new Object[0]);
            this.a.uncaughtException(thread, th);
        } else if (this.c.isPrintUncaughtStackTrace()) {
            th.printStackTrace();
        }
    }

    UncaughtExceptionHandlerIntegration(Z3 z3) {
        this.d = false;
        this.e = (Z3) io.sentry.util.u.c(z3, "threadAdapter is required.");
    }
}
