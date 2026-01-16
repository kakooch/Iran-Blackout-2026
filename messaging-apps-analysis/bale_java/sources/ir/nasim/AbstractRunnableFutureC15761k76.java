package ir.nasim;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: ir.nasim.k76, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractRunnableFutureC15761k76 implements RunnableFuture {
    private final C3962Dc1 a = new C3962Dc1();
    private final C3962Dc1 b = new C3962Dc1();
    private final Object c = new Object();
    private Exception d;
    private Object e;
    private Thread f;
    private boolean g;

    protected AbstractRunnableFutureC15761k76() {
    }

    private Object d() throws ExecutionException {
        if (this.g) {
            throw new CancellationException();
        }
        if (this.d == null) {
            return this.e;
        }
        throw new ExecutionException(this.d);
    }

    public final void a() {
        this.b.c();
    }

    protected abstract void b();

    protected abstract Object c();

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        synchronized (this.c) {
            try {
                if (!this.g && !this.b.e()) {
                    this.g = true;
                    b();
                    Thread thread = this.f;
                    if (thread == null) {
                        this.a.f();
                        this.b.f();
                    } else if (z) {
                        thread.interrupt();
                    }
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        this.b.a();
        return d();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.g;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.b.e();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        synchronized (this.c) {
            try {
                if (this.g) {
                    return;
                }
                this.f = Thread.currentThread();
                this.a.f();
                try {
                    try {
                        this.e = c();
                        synchronized (this.c) {
                            this.b.f();
                            this.f = null;
                            Thread.interrupted();
                        }
                    } catch (Throwable th) {
                        synchronized (this.c) {
                            this.b.f();
                            this.f = null;
                            Thread.interrupted();
                            throw th;
                        }
                    }
                } catch (Exception e) {
                    this.d = e;
                    synchronized (this.c) {
                        this.b.f();
                        this.f = null;
                        Thread.interrupted();
                    }
                }
            } finally {
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws TimeoutException {
        if (this.b.b(TimeUnit.MILLISECONDS.convert(j, timeUnit))) {
            return d();
        }
        throw new TimeoutException();
    }
}
