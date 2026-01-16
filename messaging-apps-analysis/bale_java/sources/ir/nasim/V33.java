package ir.nasim;

import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
abstract class V33 implements InterfaceFutureC15215jC3 {

    static class a extends V33 {
        private final Throwable a;

        a(Throwable th) {
            this.a = th;
        }

        @Override // ir.nasim.V33, java.util.concurrent.Future
        public Object get() throws ExecutionException {
            throw new ExecutionException(this.a);
        }

        public String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + this.a + "]]";
        }
    }

    static final class b extends a implements ScheduledFuture {
        b(Throwable th) {
            super(th);
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return 0L;
        }

        @Override // java.lang.Comparable
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public int compareTo(Delayed delayed) {
            return -1;
        }
    }

    static final class c extends V33 {
        static final V33 b = new c(null);
        private final Object a;

        c(Object obj) {
            this.a = obj;
        }

        @Override // ir.nasim.V33, java.util.concurrent.Future
        public Object get() {
            return this.a;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.a + "]]";
        }
    }

    V33() {
    }

    public static InterfaceFutureC15215jC3 a() {
        return c.b;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract Object get();

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) {
        AbstractC4980Hj5.g(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    @Override // ir.nasim.InterfaceFutureC15215jC3
    public void j(Runnable runnable, Executor executor) {
        AbstractC4980Hj5.g(runnable);
        AbstractC4980Hj5.g(executor);
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            PI3.d("ImmediateFuture", "Experienced RuntimeException while attempting to notify " + runnable + " on Executor " + executor, e);
        }
    }
}
