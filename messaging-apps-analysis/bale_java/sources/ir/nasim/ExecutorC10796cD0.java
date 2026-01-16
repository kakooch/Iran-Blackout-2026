package ir.nasim;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ir.nasim.cD0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ExecutorC10796cD0 implements Executor {
    private static final ThreadFactory c = new a();
    private final Object a = new Object();
    private ThreadPoolExecutor b = b();

    /* renamed from: ir.nasim.cD0$a */
    class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(Locale.US, "CameraX-core_camera_%d", Integer.valueOf(this.a.getAndIncrement())));
            return thread;
        }
    }

    private static ThreadPoolExecutor b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), c);
        threadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: ir.nasim.bD0
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                PI3.c("CameraExecutor", "A rejected execution occurred in CameraExecutor!");
            }
        });
        return threadPoolExecutor;
    }

    void c(InterfaceC11560dD0 interfaceC11560dD0) {
        ThreadPoolExecutor threadPoolExecutor;
        AbstractC4980Hj5.g(interfaceC11560dD0);
        synchronized (this.a) {
            try {
                if (this.b.isShutdown()) {
                    this.b = b();
                }
                threadPoolExecutor = this.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        int iMax = Math.max(1, interfaceC11560dD0.b().size());
        threadPoolExecutor.setMaximumPoolSize(iMax);
        threadPoolExecutor.setCorePoolSize(iMax);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        AbstractC4980Hj5.g(runnable);
        synchronized (this.a) {
            this.b.execute(runnable);
        }
    }
}
