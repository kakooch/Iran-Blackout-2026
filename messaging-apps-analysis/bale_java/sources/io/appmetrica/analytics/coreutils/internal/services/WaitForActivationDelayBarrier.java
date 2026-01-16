package io.appmetrica.analytics.coreutils.internal.services;

import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrier;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import io.appmetrica.analytics.coreutils.impl.l;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;

/* loaded from: classes3.dex */
public class WaitForActivationDelayBarrier implements ActivationBarrier {
    private long a;
    private final SystemTimeProvider b;

    public static class ActivationBarrierHelper {
        private boolean a = false;
        private final a b;
        private final WaitForActivationDelayBarrier c;

        public ActivationBarrierHelper(Runnable runnable, WaitForActivationDelayBarrier waitForActivationDelayBarrier) {
            this.b = new a(this, runnable);
            this.c = waitForActivationDelayBarrier;
        }

        public void subscribeIfNeeded(long j, ICommonExecutor iCommonExecutor) {
            if (this.a) {
                iCommonExecutor.execute(new b(this));
            } else {
                this.c.subscribe(j, iCommonExecutor, this.b);
            }
        }
    }

    public WaitForActivationDelayBarrier() {
        this(new SystemTimeProvider());
    }

    public void activate() {
        this.a = this.b.currentTimeMillis();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrier
    public void subscribe(long j, ICommonExecutor iCommonExecutor, ActivationBarrierCallback activationBarrierCallback) {
        iCommonExecutor.executeDelayed(new l(activationBarrierCallback), Math.max(j - (this.b.currentTimeMillis() - this.a), 0L));
    }

    WaitForActivationDelayBarrier(SystemTimeProvider systemTimeProvider) {
        this.b = systemTimeProvider;
    }
}
