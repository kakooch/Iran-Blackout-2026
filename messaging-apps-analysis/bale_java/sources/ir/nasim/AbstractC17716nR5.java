package ir.nasim;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: ir.nasim.nR5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC17716nR5 {

    /* renamed from: ir.nasim.nR5$a */
    private static class a implements ThreadFactory {
        private String a;
        private int b;

        /* renamed from: ir.nasim.nR5$a$a, reason: collision with other inner class name */
        private static class C1410a extends Thread {
            private final int a;

            C1410a(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.a = i;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(this.a);
                super.run();
            }
        }

        a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C1410a(runnable, this.a, this.b);
        }
    }

    /* renamed from: ir.nasim.nR5$b */
    private static class b implements Runnable {
        private Callable a;
        private InterfaceC25043ze1 b;
        private Handler c;

        /* renamed from: ir.nasim.nR5$b$a */
        class a implements Runnable {
            final /* synthetic */ InterfaceC25043ze1 a;
            final /* synthetic */ Object b;

            a(InterfaceC25043ze1 interfaceC25043ze1, Object obj) {
                this.a = interfaceC25043ze1;
                this.b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.accept(this.b);
            }
        }

        b(Handler handler, Callable callable, InterfaceC25043ze1 interfaceC25043ze1) {
            this.a = callable;
            this.b = interfaceC25043ze1;
            this.c = handler;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            Object objCall;
            try {
                objCall = this.a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.c.post(new a(this.b, objCall));
        }
    }

    static ThreadPoolExecutor a(String str, int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static void b(Executor executor, Callable callable, InterfaceC25043ze1 interfaceC25043ze1) {
        executor.execute(new b(AbstractC18149oA0.a(), callable, interfaceC25043ze1));
    }

    static Object c(ExecutorService executorService, Callable callable, int i) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
