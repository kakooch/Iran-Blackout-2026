package io.sentry;

import io.sentry.util.C3202a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class P2 implements InterfaceC3097c0 {
    private final ScheduledThreadPoolExecutor a;
    private final C3202a b;
    private final Runnable c;
    private final C3155n3 d;

    private static final class b implements Future {
        private b() {
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return true;
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            throw new CancellationException();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public Object get(long j, TimeUnit timeUnit) {
            throw new CancellationException();
        }
    }

    private static final class c implements ThreadFactory {
        private int a;

        private c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryExecutorServiceThreadFactory-");
            int i = this.a;
            this.a = i + 1;
            sb.append(i);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    P2(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, C3155n3 c3155n3) {
        this.b = new C3202a();
        this.c = new Runnable() { // from class: io.sentry.N2
            @Override // java.lang.Runnable
            public final void run() {
                P2.f();
            }
        };
        this.a = scheduledThreadPoolExecutor;
        this.d = c3155n3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        for (int i = 0; i < 40; i++) {
            try {
                this.a.schedule(this.c, 365L, TimeUnit.DAYS).cancel(true);
            } catch (RejectedExecutionException unused) {
                return;
            }
        }
        this.a.purge();
    }

    @Override // io.sentry.InterfaceC3097c0
    public void a() {
        this.a.submit(new Runnable() { // from class: io.sentry.O2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g();
            }
        });
    }

    @Override // io.sentry.InterfaceC3097c0
    public void b(long j) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            if (!this.a.isShutdown()) {
                this.a.shutdown();
                try {
                    if (!this.a.awaitTermination(j, TimeUnit.MILLISECONDS)) {
                        this.a.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    this.a.shutdownNow();
                    Thread.currentThread().interrupt();
                }
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

    @Override // io.sentry.InterfaceC3097c0
    public Future c(Runnable runnable, long j) {
        if (this.a.getQueue().size() < 271) {
            return this.a.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
        C3155n3 c3155n3 = this.d;
        if (c3155n3 != null) {
            c3155n3.getLogger().c(Y2.WARNING, "Task " + runnable + " rejected from " + this.a, new Object[0]);
        }
        return new b();
    }

    @Override // io.sentry.InterfaceC3097c0
    public boolean isClosed() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            boolean zIsShutdown = this.a.isShutdown();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return zIsShutdown;
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

    @Override // io.sentry.InterfaceC3097c0
    public Future submit(Runnable runnable) {
        if (this.a.getQueue().size() < 271) {
            return this.a.submit(runnable);
        }
        C3155n3 c3155n3 = this.d;
        if (c3155n3 != null) {
            c3155n3.getLogger().c(Y2.WARNING, "Task " + runnable + " rejected from " + this.a, new Object[0]);
        }
        return new b();
    }

    public P2(C3155n3 c3155n3) {
        this(new ScheduledThreadPoolExecutor(1, new c()), c3155n3);
    }

    public P2() {
        this(new ScheduledThreadPoolExecutor(1, new c()), null);
    }
}
