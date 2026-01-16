package io.sentry.transport;

import io.sentry.AbstractC3141l;
import io.sentry.C3134j2;
import io.sentry.C3155n3;
import io.sentry.C3227y1;
import io.sentry.I;
import io.sentry.ILogger;
import io.sentry.InterfaceC3129i2;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.Y2;
import io.sentry.util.m;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class e implements q {
    private final w a;
    private final io.sentry.cache.g b;
    private final C3155n3 c;
    private final A d;
    private final r e;
    private final o f;
    private volatile Runnable g;

    private static final class b implements ThreadFactory {
        private int a;

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryAsyncConnection-");
            int i = this.a;
            this.a = i + 1;
            sb.append(i);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class c implements Runnable {
        private final C3134j2 a;
        private final I b;
        private final io.sentry.cache.g c;
        private final C d = C.a();

        c(C3134j2 c3134j2, I i, io.sentry.cache.g gVar) {
            this.a = (C3134j2) io.sentry.util.u.c(c3134j2, "Envelope is required.");
            this.b = i;
            this.c = (io.sentry.cache.g) io.sentry.util.u.c(gVar, "EnvelopeCache is required.");
        }

        private C j() {
            C c = this.d;
            this.a.b().d(null);
            final boolean zO1 = this.c.o1(this.a, this.b);
            io.sentry.util.m.o(this.b, io.sentry.hints.f.class, new m.a() { // from class: io.sentry.transport.g
                @Override // io.sentry.util.m.a
                public final void accept(Object obj) {
                    this.a.k((io.sentry.hints.f) obj);
                }
            });
            if (!e.this.e.a()) {
                io.sentry.util.m.p(this.b, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.k
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        ((io.sentry.hints.k) obj).d(true);
                    }
                }, new m.b() { // from class: io.sentry.transport.l
                    @Override // io.sentry.util.m.b
                    public final void a(Object obj, Class cls) {
                        this.a.p(zO1, obj, cls);
                    }
                });
                return c;
            }
            final C3134j2 c3134j2E = e.this.c.getClientReportRecorder().e(this.a);
            try {
                c3134j2E.b().d(AbstractC3141l.k(e.this.c.getDateProvider().a().p()));
                C cH = e.this.f.h(c3134j2E);
                if (cH.d()) {
                    this.c.J(this.a);
                    return cH;
                }
                String str = "The transport failed to send the envelope with response code " + cH.c();
                e.this.c.getLogger().c(Y2.ERROR, str, new Object[0]);
                if (cH.c() >= 400 && cH.c() != 429 && !zO1) {
                    io.sentry.util.m.n(this.b, io.sentry.hints.k.class, new m.c() { // from class: io.sentry.transport.h
                        @Override // io.sentry.util.m.c
                        public final void accept(Object obj) {
                            this.a.l(c3134j2E, obj);
                        }
                    });
                }
                throw new IllegalStateException(str);
            } catch (IOException e) {
                io.sentry.util.m.p(this.b, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.i
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        ((io.sentry.hints.k) obj).d(true);
                    }
                }, new m.b() { // from class: io.sentry.transport.j
                    @Override // io.sentry.util.m.b
                    public final void a(Object obj, Class cls) {
                        this.a.n(zO1, c3134j2E, obj, cls);
                    }
                });
                throw new IllegalStateException("Sending the event failed.", e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(io.sentry.hints.f fVar) {
            if (!fVar.b(this.a.b().a())) {
                e.this.c.getLogger().c(Y2.DEBUG, "Not firing envelope flush as there's an ongoing transaction", new Object[0]);
            } else {
                fVar.d();
                e.this.c.getLogger().c(Y2.DEBUG, "Disk flush envelope fired", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(C3134j2 c3134j2, Object obj) {
            e.this.c.getClientReportRecorder().b(io.sentry.clientreport.f.NETWORK_ERROR, c3134j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(boolean z, C3134j2 c3134j2, Object obj, Class cls) {
            if (z) {
                return;
            }
            io.sentry.util.s.a(cls, obj, e.this.c.getLogger());
            e.this.c.getClientReportRecorder().b(io.sentry.clientreport.f.NETWORK_ERROR, c3134j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(boolean z, Object obj, Class cls) {
            if (z) {
                return;
            }
            io.sentry.util.s.a(cls, obj, e.this.c.getLogger());
            e.this.c.getClientReportRecorder().b(io.sentry.clientreport.f.NETWORK_ERROR, this.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(C c, io.sentry.hints.p pVar) {
            e.this.c.getLogger().c(Y2.DEBUG, "Marking envelope submission result: %s", Boolean.valueOf(c.d()));
            pVar.c(c.d());
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.g = this;
            final C cJ = this.d;
            try {
                cJ = j();
                e.this.c.getLogger().c(Y2.DEBUG, "Envelope flushed", new Object[0]);
            } finally {
            }
        }
    }

    public e(C3155n3 c3155n3, A a2, r rVar, C3227y1 c3227y1) {
        this(l(c3155n3.getMaxQueueSize(), c3155n3.getEnvelopeDiskCache(), c3155n3.getLogger(), c3155n3.getDateProvider()), c3155n3, a2, rVar, new o(c3155n3, c3227y1, a2));
    }

    private static w l(int i, final io.sentry.cache.g gVar, final ILogger iLogger, InterfaceC3129i2 interfaceC3129i2) {
        return new w(1, i, new b(), new RejectedExecutionHandler() { // from class: io.sentry.transport.a
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                e.m(gVar, iLogger, runnable, threadPoolExecutor);
            }
        }, iLogger, interfaceC3129i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(io.sentry.cache.g gVar, ILogger iLogger, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (runnable instanceof c) {
            c cVar = (c) runnable;
            if (!io.sentry.util.m.h(cVar.b, io.sentry.hints.e.class)) {
                gVar.o1(cVar.a, cVar.b);
            }
            s(cVar.b, true);
            iLogger.c(Y2.WARNING, "Envelope rejected", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(io.sentry.hints.g gVar) {
        gVar.b();
        this.c.getLogger().c(Y2.DEBUG, "Envelope enqueued", new Object[0]);
    }

    private static void s(I i, final boolean z) {
        io.sentry.util.m.o(i, io.sentry.hints.p.class, new m.a() { // from class: io.sentry.transport.c
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                ((io.sentry.hints.p) obj).c(false);
            }
        });
        io.sentry.util.m.o(i, io.sentry.hints.k.class, new m.a() { // from class: io.sentry.transport.d
            @Override // io.sentry.util.m.a
            public final void accept(Object obj) {
                ((io.sentry.hints.k) obj).d(z);
            }
        });
    }

    @Override // io.sentry.transport.q
    public void c0(C3134j2 c3134j2, I i) {
        io.sentry.cache.g gVarF = this.b;
        boolean z = false;
        if (io.sentry.util.m.h(i, io.sentry.hints.e.class)) {
            gVarF = s.f();
            this.c.getLogger().c(Y2.DEBUG, "Captured Envelope is already cached", new Object[0]);
            z = true;
        }
        C3134j2 c3134j2J = this.d.j(c3134j2, i);
        if (c3134j2J == null) {
            if (z) {
                this.b.J(c3134j2);
                return;
            }
            return;
        }
        if (io.sentry.util.m.h(i, UncaughtExceptionHandlerIntegration.a.class)) {
            c3134j2J = this.c.getClientReportRecorder().e(c3134j2J);
        }
        Future futureSubmit = this.a.submit(new c(c3134j2J, i, gVarF));
        if (futureSubmit == null || !futureSubmit.isCancelled()) {
            io.sentry.util.m.o(i, io.sentry.hints.g.class, new m.a() { // from class: io.sentry.transport.b
                @Override // io.sentry.util.m.a
                public final void accept(Object obj) {
                    this.a.q((io.sentry.hints.g) obj);
                }
            });
        } else {
            this.c.getClientReportRecorder().b(io.sentry.clientreport.f.QUEUE_OVERFLOW, c3134j2J);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        i(false);
    }

    @Override // io.sentry.transport.q
    public void i(boolean z) {
        this.d.close();
        this.a.shutdown();
        this.c.getLogger().c(Y2.DEBUG, "Shutting down", new Object[0]);
        if (z) {
            return;
        }
        try {
            long flushTimeoutMillis = this.c.getFlushTimeoutMillis();
            if (this.a.awaitTermination(flushTimeoutMillis, TimeUnit.MILLISECONDS)) {
                return;
            }
            this.c.getLogger().c(Y2.WARNING, "Failed to shutdown the async connection async sender  within " + flushTimeoutMillis + " ms. Trying to force it now.", new Object[0]);
            this.a.shutdownNow();
            if (this.g != null) {
                this.a.getRejectedExecutionHandler().rejectedExecution(this.g, this.a);
            }
        } catch (InterruptedException unused) {
            this.c.getLogger().c(Y2.DEBUG, "Thread interrupted while closing the connection.", new Object[0]);
            Thread.currentThread().interrupt();
        }
    }

    @Override // io.sentry.transport.q
    public void r(long j) {
        this.a.c(j);
    }

    @Override // io.sentry.transport.q
    public boolean t() {
        return (this.d.m() || this.a.a()) ? false : true;
    }

    @Override // io.sentry.transport.q
    public A w() {
        return this.d;
    }

    public e(w wVar, C3155n3 c3155n3, A a2, r rVar, o oVar) {
        this.g = null;
        this.a = (w) io.sentry.util.u.c(wVar, "executor is required");
        this.b = (io.sentry.cache.g) io.sentry.util.u.c(c3155n3.getEnvelopeDiskCache(), "envelopeCache is required");
        this.c = (C3155n3) io.sentry.util.u.c(c3155n3, "options is required");
        this.d = (A) io.sentry.util.u.c(a2, "rateLimiter is required");
        this.e = (r) io.sentry.util.u.c(rVar, "transportGate is required");
        this.f = (o) io.sentry.util.u.c(oVar, "httpConnection is required");
    }
}
