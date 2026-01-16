package ir.nasim;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.oq6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ExecutorC18549oq6 implements Executor {
    private final Executor b;
    private volatile Runnable d;
    private final ArrayDeque a = new ArrayDeque();
    private final Object c = new Object();

    /* renamed from: ir.nasim.oq6$a */
    static class a implements Runnable {
        final ExecutorC18549oq6 a;
        final Runnable b;

        a(ExecutorC18549oq6 executorC18549oq6, Runnable runnable) {
            this.a = executorC18549oq6;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } finally {
                this.a.b();
            }
        }
    }

    public ExecutorC18549oq6(Executor executor) {
        this.b = executor;
    }

    public boolean a() {
        boolean z;
        synchronized (this.c) {
            z = !this.a.isEmpty();
        }
        return z;
    }

    void b() {
        synchronized (this.c) {
            try {
                Runnable runnable = (Runnable) this.a.poll();
                this.d = runnable;
                if (runnable != null) {
                    this.b.execute(this.d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.c) {
            try {
                this.a.add(new a(this, runnable));
                if (this.d == null) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
