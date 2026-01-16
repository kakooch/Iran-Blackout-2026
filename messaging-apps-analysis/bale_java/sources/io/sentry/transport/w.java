package io.sentry.transport;

import io.sentry.AbstractC3124h2;
import io.sentry.AbstractC3141l;
import io.sentry.ILogger;
import io.sentry.InterfaceC3129i2;
import io.sentry.Y2;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class w extends ThreadPoolExecutor {
    private static final long f = AbstractC3141l.i(2000);
    private final int a;
    private AbstractC3124h2 b;
    private final ILogger c;
    private final InterfaceC3129i2 d;
    private final B e;

    static final class a implements Future {
        a() {
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

    public w(int i, int i2, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ILogger iLogger, InterfaceC3129i2 interfaceC3129i2) {
        super(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler);
        this.b = null;
        this.e = new B();
        this.a = i2;
        this.c = iLogger;
        this.d = interfaceC3129i2;
    }

    public boolean a() {
        AbstractC3124h2 abstractC3124h2 = this.b;
        return abstractC3124h2 != null && this.d.a().h(abstractC3124h2) < f;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        try {
            super.afterExecute(runnable, th);
        } finally {
            this.e.a();
        }
    }

    public boolean b() {
        return this.e.b() < this.a;
    }

    void c(long j) {
        try {
            this.e.d(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            this.c.b(Y2.ERROR, "Failed to wait till idle", e);
            Thread.currentThread().interrupt();
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        if (b()) {
            this.e.c();
            return super.submit(runnable);
        }
        this.b = this.d.a();
        this.c.c(Y2.WARNING, "Submit cancelled", new Object[0]);
        return new a();
    }
}
