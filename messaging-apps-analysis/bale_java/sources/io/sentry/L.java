package io.sentry;

import io.sentry.util.C3202a;
import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class L {
    private static volatile L i;
    private final long a;
    private volatile String b;
    private volatile long c;
    private final AtomicBoolean d;
    private final Callable e;
    private final ExecutorService f;
    private static final long g = TimeUnit.HOURS.toMillis(5);
    private static final long h = TimeUnit.SECONDS.toMillis(1);
    private static final C3202a j = new C3202a();

    private static final class b implements ThreadFactory {
        private int a;

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryHostnameCache-");
            int i = this.a;
            this.a = i + 1;
            sb.append(i);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    private L() {
        this(g);
    }

    public static L e() {
        if (i == null) {
            InterfaceC3102d0 interfaceC3102d0A = j.a();
            try {
                if (i == null) {
                    i = new L();
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
        return i;
    }

    private void f() {
        this.c = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void h() {
        try {
            this.b = ((InetAddress) this.e.call()).getCanonicalHostName();
            this.c = System.currentTimeMillis() + this.a;
            this.d.set(false);
            return null;
        } catch (Throwable th) {
            this.d.set(false);
            throw th;
        }
    }

    private void i() throws ExecutionException, InterruptedException, TimeoutException {
        try {
            this.f.submit(new Callable() { // from class: io.sentry.K
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.a.h();
                }
            }).get(h, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            f();
        } catch (RuntimeException | ExecutionException | TimeoutException unused2) {
            f();
        }
    }

    void c() {
        this.f.shutdown();
    }

    public String d() throws ExecutionException, InterruptedException, TimeoutException {
        if (this.c < System.currentTimeMillis() && this.d.compareAndSet(false, true)) {
            i();
        }
        return this.b;
    }

    L(long j2) {
        this(j2, new Callable() { // from class: io.sentry.J
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return InetAddress.getLocalHost();
            }
        });
    }

    L(long j2, Callable callable) throws ExecutionException, InterruptedException, TimeoutException {
        this.d = new AtomicBoolean(false);
        this.f = Executors.newSingleThreadExecutor(new b());
        this.a = j2;
        this.e = (Callable) io.sentry.util.u.c(callable, "getLocalhost is required");
        i();
    }
}
