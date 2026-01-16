package io.sentry.hints;

import io.sentry.ILogger;
import io.sentry.Y2;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class d implements f, i {
    private final CountDownLatch a = new CountDownLatch(1);
    private final long b;
    private final ILogger c;

    public d(long j, ILogger iLogger) {
        this.b = j;
        this.c = iLogger;
    }

    @Override // io.sentry.hints.f
    public void d() {
        this.a.countDown();
    }

    @Override // io.sentry.hints.i
    public boolean g() {
        try {
            return this.a.await(this.b, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.c.b(Y2.ERROR, "Exception while awaiting for flush in BlockingFlushHint", e);
            return false;
        }
    }
}
