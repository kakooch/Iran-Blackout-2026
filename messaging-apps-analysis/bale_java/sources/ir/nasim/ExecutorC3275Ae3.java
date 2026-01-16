package ir.nasim;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ir.nasim.Ae3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ExecutorC3275Ae3 implements Executor {
    private static volatile Executor b;
    private final ExecutorService a = Executors.newFixedThreadPool(2, new a());

    /* renamed from: ir.nasim.Ae3$a */
    class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(Locale.US, "CameraX-camerax_io_%d", Integer.valueOf(this.a.getAndIncrement())));
            return thread;
        }
    }

    ExecutorC3275Ae3() {
    }

    static Executor a() {
        if (b != null) {
            return b;
        }
        synchronized (ExecutorC3275Ae3.class) {
            try {
                if (b == null) {
                    b = new ExecutorC3275Ae3();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.execute(runnable);
    }
}
