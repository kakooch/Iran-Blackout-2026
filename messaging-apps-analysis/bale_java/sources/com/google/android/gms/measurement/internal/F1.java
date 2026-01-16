package com.google.android.gms.measurement.internal;

import ir.nasim.AbstractC3795Cj5;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class F1 extends AbstractC2218b2 {
    private static final AtomicLong l = new AtomicLong(Long.MIN_VALUE);
    private E1 c;
    private E1 d;
    private final PriorityBlockingQueue e;
    private final BlockingQueue f;
    private final Thread.UncaughtExceptionHandler g;
    private final Thread.UncaughtExceptionHandler h;
    private final Object i;
    private final Semaphore j;
    private volatile boolean k;

    F1(H1 h1) {
        super(h1);
        this.i = new Object();
        this.j = new Semaphore(2);
        this.e = new PriorityBlockingQueue();
        this.f = new LinkedBlockingQueue();
        this.g = new C1(this, "Thread death: Uncaught exception on worker thread");
        this.h = new C1(this, "Thread death: Uncaught exception on network thread");
    }

    static /* bridge */ /* synthetic */ boolean B(F1 f1) {
        boolean z = f1.k;
        return false;
    }

    private final void D(D1 d1) {
        synchronized (this.i) {
            try {
                this.e.add(d1);
                E1 e1 = this.c;
                if (e1 == null) {
                    E1 e12 = new E1(this, "Measurement Worker", this.e);
                    this.c = e12;
                    e12.setUncaughtExceptionHandler(this.g);
                    this.c.start();
                } else {
                    e1.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void A(Runnable runnable) {
        k();
        AbstractC3795Cj5.j(runnable);
        D(new D1(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean C() {
        return Thread.currentThread() == this.c;
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2213a2
    public final void g() {
        if (Thread.currentThread() != this.d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2213a2
    public final void h() {
        if (Thread.currentThread() != this.c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2218b2
    protected final boolean j() {
        return false;
    }

    final Object r(AtomicReference atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.a.a().z(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                this.a.b().w().a("Interrupted waiting for " + str);
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            this.a.b().w().a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final Future s(Callable callable) {
        k();
        AbstractC3795Cj5.j(callable);
        D1 d1 = new D1(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.c) {
            if (!this.e.isEmpty()) {
                this.a.b().w().a("Callable skipped the worker queue.");
            }
            d1.run();
        } else {
            D(d1);
        }
        return d1;
    }

    public final Future t(Callable callable) {
        k();
        AbstractC3795Cj5.j(callable);
        D1 d1 = new D1(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.c) {
            d1.run();
        } else {
            D(d1);
        }
        return d1;
    }

    public final void y(Runnable runnable) {
        k();
        AbstractC3795Cj5.j(runnable);
        D1 d1 = new D1(this, runnable, false, "Task exception on network thread");
        synchronized (this.i) {
            try {
                this.f.add(d1);
                E1 e1 = this.d;
                if (e1 == null) {
                    E1 e12 = new E1(this, "Measurement Network", this.f);
                    this.d = e12;
                    e12.setUncaughtExceptionHandler(this.h);
                    this.d.start();
                } else {
                    e1.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(Runnable runnable) {
        k();
        AbstractC3795Cj5.j(runnable);
        D(new D1(this, runnable, false, "Task exception on worker thread"));
    }
}
