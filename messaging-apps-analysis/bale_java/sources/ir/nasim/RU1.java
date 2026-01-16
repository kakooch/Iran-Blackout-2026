package ir.nasim;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class RU1 {
    ThreadPoolExecutor a = new a(1, 1, 60, TimeUnit.SECONDS, new PriorityBlockingQueue(10, new b()));
    private volatile CountDownLatch b;

    class a extends ThreadPoolExecutor {
        a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue) {
            super(i, i2, j, timeUnit, blockingQueue);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void beforeExecute(Thread thread, Runnable runnable) throws InterruptedException {
            CountDownLatch countDownLatch = RU1.this.b;
            if (countDownLatch != null) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    AbstractC6403Nl2.d(e);
                }
            }
        }
    }

    class b implements Comparator {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Runnable runnable, Runnable runnable2) {
            return (runnable2 instanceof c ? ((c) runnable2).a : 1) - (runnable instanceof c ? ((c) runnable).a : 1);
        }
    }

    private static class c implements Runnable {
        final int a;
        final Runnable b;

        @Override // java.lang.Runnable
        public void run() {
            this.b.run();
        }

        private c(int i, Runnable runnable) {
            this.a = i;
            this.b = runnable;
        }
    }

    public RU1(String str) {
    }

    public void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.a.remove(runnable);
    }

    public Runnable c(Runnable runnable, int i) {
        if (i != 1) {
            runnable = new c(i, runnable);
        }
        d(runnable);
        return runnable;
    }

    public void d(Runnable runnable) {
        this.a.execute(runnable);
    }
}
