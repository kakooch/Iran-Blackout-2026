package ir.nasim;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: ir.nasim.lI0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class RunnableC16448lI0 extends NB2 implements Runnable {
    private FK c;
    private final BlockingQueue d = new LinkedBlockingQueue(1);
    private final CountDownLatch e = new CountDownLatch(1);
    private InterfaceFutureC15215jC3 f;
    volatile InterfaceFutureC15215jC3 g;

    /* renamed from: ir.nasim.lI0$a */
    class a implements Runnable {
        final /* synthetic */ InterfaceFutureC15215jC3 a;

        a(InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
            this.a = interfaceFutureC15215jC3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    RunnableC16448lI0.this.b(WB2.i(this.a));
                } catch (CancellationException unused) {
                    RunnableC16448lI0.this.cancel(false);
                    RunnableC16448lI0.this.g = null;
                    return;
                } catch (ExecutionException e) {
                    RunnableC16448lI0.this.c(e.getCause());
                }
                RunnableC16448lI0.this.g = null;
            } catch (Throwable th) {
                RunnableC16448lI0.this.g = null;
                throw th;
            }
        }
    }

    RunnableC16448lI0(FK fk, InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
        this.c = (FK) AbstractC4980Hj5.g(fk);
        this.f = (InterfaceFutureC15215jC3) AbstractC4980Hj5.g(interfaceFutureC15215jC3);
    }

    private void f(Future future, boolean z) {
        if (future != null) {
            future.cancel(z);
        }
    }

    private void g(BlockingQueue blockingQueue, Object obj) {
        boolean z = false;
        while (true) {
            try {
                blockingQueue.put(obj);
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private Object h(BlockingQueue blockingQueue) {
        Object objTake;
        boolean z = false;
        while (true) {
            try {
                objTake = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return objTake;
    }

    @Override // ir.nasim.NB2, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!super.cancel(z)) {
            return false;
        }
        g(this.d, Boolean.valueOf(z));
        f(this.f, z);
        f(this.g, z);
        return true;
    }

    @Override // ir.nasim.NB2, java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        if (!isDone()) {
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = this.f;
            if (interfaceFutureC15215jC3 != null) {
                interfaceFutureC15215jC3.get();
            }
            this.e.await();
            InterfaceFutureC15215jC3 interfaceFutureC15215jC32 = this.g;
            if (interfaceFutureC15215jC32 != null) {
                interfaceFutureC15215jC32.get();
            }
        }
        return super.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3Apply;
        try {
            try {
                try {
                    try {
                        try {
                            interfaceFutureC15215jC3Apply = this.c.apply(WB2.i(this.f));
                            this.g = interfaceFutureC15215jC3Apply;
                        } catch (Exception e) {
                            c(e);
                        }
                    } catch (Error e2) {
                        c(e2);
                    }
                } finally {
                    this.c = null;
                    this.f = null;
                    this.e.countDown();
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e3) {
                c(e3.getCause());
            }
        } catch (UndeclaredThrowableException e4) {
            c(e4.getCause());
        }
        if (!isCancelled()) {
            interfaceFutureC15215jC3Apply.j(new a(interfaceFutureC15215jC3Apply), AbstractC20567sE0.a());
        } else {
            interfaceFutureC15215jC3Apply.cancel(((Boolean) h(this.d)).booleanValue());
            this.g = null;
        }
    }

    @Override // ir.nasim.NB2, java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (!isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j = timeUnit2.convert(j, timeUnit);
                timeUnit = timeUnit2;
            }
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = this.f;
            if (interfaceFutureC15215jC3 != null) {
                long jNanoTime = System.nanoTime();
                interfaceFutureC15215jC3.get(j, timeUnit);
                j -= Math.max(0L, System.nanoTime() - jNanoTime);
            }
            long jNanoTime2 = System.nanoTime();
            if (this.e.await(j, timeUnit)) {
                j -= Math.max(0L, System.nanoTime() - jNanoTime2);
                InterfaceFutureC15215jC3 interfaceFutureC15215jC32 = this.g;
                if (interfaceFutureC15215jC32 != null) {
                    interfaceFutureC15215jC32.get(j, timeUnit);
                }
            } else {
                throw new TimeoutException();
            }
        }
        return super.get(j, timeUnit);
    }
}
