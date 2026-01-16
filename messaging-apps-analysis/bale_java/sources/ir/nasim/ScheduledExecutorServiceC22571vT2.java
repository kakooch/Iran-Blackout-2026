package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import ir.nasim.AbstractC16967mA0;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.vT2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ScheduledExecutorServiceC22571vT2 extends AbstractExecutorService implements ScheduledExecutorService {
    private static ThreadLocal b = new a();
    private final Handler a;

    /* renamed from: ir.nasim.vT2$a */
    class a extends ThreadLocal {
        a() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScheduledExecutorService initialValue() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return AbstractC20567sE0.c();
            }
            if (Looper.myLooper() != null) {
                return new ScheduledExecutorServiceC22571vT2(new Handler(Looper.myLooper()));
            }
            return null;
        }
    }

    /* renamed from: ir.nasim.vT2$b */
    class b implements Callable {
        final /* synthetic */ Runnable a;

        b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            this.a.run();
            return null;
        }
    }

    /* renamed from: ir.nasim.vT2$c */
    private static class c implements RunnableScheduledFuture {
        final AtomicReference a = new AtomicReference(null);
        private final long b;
        private final Callable c;
        private final InterfaceFutureC15215jC3 d;

        /* renamed from: ir.nasim.vT2$c$a */
        class a implements AbstractC16967mA0.c {
            final /* synthetic */ Handler a;
            final /* synthetic */ Callable b;

            /* renamed from: ir.nasim.vT2$c$a$a, reason: collision with other inner class name */
            class RunnableC1666a implements Runnable {
                RunnableC1666a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.a.getAndSet(null) != null) {
                        a aVar = a.this;
                        aVar.a.removeCallbacks(c.this);
                    }
                }
            }

            a(Handler handler, Callable callable) {
                this.a = handler;
                this.b = callable;
            }

            @Override // ir.nasim.AbstractC16967mA0.c
            public Object a(AbstractC16967mA0.a aVar) {
                aVar.a(new RunnableC1666a(), AbstractC20567sE0.a());
                c.this.a.set(aVar);
                return "HandlerScheduledFuture-" + this.b.toString();
            }
        }

        c(Handler handler, long j, Callable callable) {
            this.b = j;
            this.c = callable;
            this.d = AbstractC16967mA0.a(new a(handler, callable));
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Delayed delayed) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            return Long.compare(getDelay(timeUnit), delayed.getDelay(timeUnit));
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return this.d.cancel(z);
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return this.d.get();
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(this.b - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.d.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.d.isDone();
        }

        @Override // java.util.concurrent.RunnableScheduledFuture
        public boolean isPeriodic() {
            return false;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            AbstractC16967mA0.a aVar = (AbstractC16967mA0.a) this.a.getAndSet(null);
            if (aVar != null) {
                try {
                    aVar.c(this.c.call());
                } catch (Exception e) {
                    aVar.f(e);
                }
            }
        }

        @Override // java.util.concurrent.Future
        public Object get(long j, TimeUnit timeUnit) {
            return this.d.get(j, timeUnit);
        }
    }

    ScheduledExecutorServiceC22571vT2(Handler handler) {
        this.a = handler;
    }

    private RejectedExecutionException a() {
        return new RejectedExecutionException(this.a + " is shutting down");
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(ScheduledExecutorServiceC22571vT2.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (!this.a.post(runnable)) {
            throw a();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return schedule(new b(runnable), j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(ScheduledExecutorServiceC22571vT2.class.getSimpleName() + " does not yet support fixed-rate scheduling.");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException(ScheduledExecutorServiceC22571vT2.class.getSimpleName() + " does not yet support fixed-delay scheduling.");
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException(ScheduledExecutorServiceC22571vT2.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        throw new UnsupportedOperationException(ScheduledExecutorServiceC22571vT2.class.getSimpleName() + " cannot be shut down. Use Looper.quitSafely().");
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        long jUptimeMillis = SystemClock.uptimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
        c cVar = new c(this.a, jUptimeMillis, callable);
        return this.a.postAtTime(cVar, jUptimeMillis) ? cVar : WB2.k(a());
    }
}
