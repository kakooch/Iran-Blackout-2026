package io.sentry.backpressure;

import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.sentry.C3155n3;
import io.sentry.InterfaceC3097c0;
import io.sentry.InterfaceC3102d0;
import io.sentry.Y2;
import io.sentry.Z;
import io.sentry.util.C3202a;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public final class a implements b, Runnable {
    private final C3155n3 a;
    private final Z b;
    private int c = 0;
    private volatile Future d = null;
    private final C3202a e = new C3202a();

    public a(C3155n3 c3155n3, Z z) {
        this.a = c3155n3;
        this.b = z;
    }

    private boolean c() {
        return this.b.t();
    }

    private void d(int i) {
        InterfaceC3097c0 executorService = this.a.getExecutorService();
        if (executorService.isClosed()) {
            return;
        }
        InterfaceC3102d0 interfaceC3102d0A = this.e.a();
        try {
            this.d = executorService.c(this, i);
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

    @Override // io.sentry.backpressure.b
    public int a() {
        return this.c;
    }

    void b() {
        if (c()) {
            if (this.c > 0) {
                this.a.getLogger().c(Y2.DEBUG, "Health check positive, reverting to normal sampling.", new Object[0]);
            }
            this.c = 0;
        } else {
            int i = this.c;
            if (i < 10) {
                this.c = i + 1;
                this.a.getLogger().c(Y2.DEBUG, "Health check negative, downsampling with a factor of %d", Integer.valueOf(this.c));
            }
        }
    }

    @Override // io.sentry.backpressure.b
    public void close() {
        Future future = this.d;
        if (future != null) {
            InterfaceC3102d0 interfaceC3102d0A = this.e.a();
            try {
                future.cancel(true);
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

    @Override // java.lang.Runnable
    public void run() {
        b();
        d(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND);
    }

    @Override // io.sentry.backpressure.b
    public void start() {
        d(SIPTransactionStack.BASE_TIMER_INTERVAL);
    }
}
