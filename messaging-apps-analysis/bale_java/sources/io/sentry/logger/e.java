package io.sentry.logger;

import io.sentry.C3035a3;
import io.sentry.C3100c3;
import io.sentry.C3155n3;
import io.sentry.InterfaceC3092b0;
import io.sentry.InterfaceC3097c0;
import io.sentry.InterfaceC3102d0;
import io.sentry.P2;
import io.sentry.Y2;
import io.sentry.transport.B;
import io.sentry.util.C3202a;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class e implements io.sentry.logger.b {
    private static final C3202a h = new C3202a();
    private final C3155n3 a;
    private final InterfaceC3092b0 b;
    private final InterfaceC3097c0 d;
    private volatile Future e;
    private volatile boolean f = false;
    private final B g = new B();
    private final Queue c = new ConcurrentLinkedQueue();

    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.c();
        }
    }

    public e(C3155n3 c3155n3, InterfaceC3092b0 interfaceC3092b0) {
        this.a = c3155n3;
        this.b = interfaceC3092b0;
        this.d = new P2(c3155n3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        e();
        InterfaceC3102d0 interfaceC3102d0A = h.a();
        try {
            if (this.c.isEmpty()) {
                this.f = false;
            } else {
                g(true, false);
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

    private void d() {
        ArrayList arrayList = new ArrayList(100);
        do {
            C3035a3 c3035a3 = (C3035a3) this.c.poll();
            if (c3035a3 != null) {
                arrayList.add(c3035a3);
            }
            if (this.c.isEmpty()) {
                break;
            }
        } while (arrayList.size() < 100);
        if (arrayList.isEmpty()) {
            return;
        }
        this.b.e(new C3100c3(arrayList));
        for (int i = 0; i < arrayList.size(); i++) {
            this.g.a();
        }
    }

    private void e() {
        do {
            d();
        } while (this.c.size() >= 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.d.b(this.a.getShutdownTimeoutMillis());
    }

    private void g(boolean z, boolean z2) {
        if (!this.f || z) {
            InterfaceC3102d0 interfaceC3102d0A = h.a();
            try {
                Future future = this.e;
                if (z || future == null || future.isDone() || future.isCancelled()) {
                    this.f = true;
                    this.e = this.d.c(new b(), z2 ? 0 : 5000);
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

    @Override // io.sentry.logger.b
    public void i(boolean z) {
        if (z) {
            g(true, true);
            this.d.submit(new Runnable() { // from class: io.sentry.logger.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f();
                }
            });
        } else {
            this.d.b(this.a.getShutdownTimeoutMillis());
            while (!this.c.isEmpty()) {
                d();
            }
        }
    }

    @Override // io.sentry.logger.b
    public void r(long j) {
        g(true, true);
        try {
            this.g.d(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            this.a.getLogger().b(Y2.ERROR, "Failed to flush log events", e);
            Thread.currentThread().interrupt();
        }
    }
}
