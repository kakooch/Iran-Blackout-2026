package ir.nasim;

import ir.nasim.AbstractC16967mA0;
import ir.nasim.V33;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public abstract class WB2 {
    private static final InterfaceC21819uB2 a = new b();

    class a implements FK {
        final /* synthetic */ InterfaceC21819uB2 a;

        a(InterfaceC21819uB2 interfaceC21819uB2) {
            this.a = interfaceC21819uB2;
        }

        @Override // ir.nasim.FK
        public InterfaceFutureC15215jC3 apply(Object obj) {
            return WB2.l(this.a.apply(obj));
        }
    }

    class c implements MB2 {
        final /* synthetic */ AbstractC16967mA0.a a;
        final /* synthetic */ InterfaceC21819uB2 b;

        c(AbstractC16967mA0.a aVar, InterfaceC21819uB2 interfaceC21819uB2) {
            this.a = aVar;
            this.b = interfaceC21819uB2;
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            this.a.f(th);
        }

        @Override // ir.nasim.MB2
        public void onSuccess(Object obj) {
            try {
                this.a.c(this.b.apply(obj));
            } catch (Throwable th) {
                this.a.f(th);
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ InterfaceFutureC15215jC3 a;

        d(InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
            this.a = interfaceFutureC15215jC3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.cancel(true);
        }
    }

    private static final class e implements Runnable {
        final Future a;
        final MB2 b;

        e(Future future, MB2 mb2) {
            this.a = future;
            this.b = mb2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.onSuccess(WB2.h(this.a));
            } catch (Error e) {
                e = e;
                this.b.onFailure(e);
            } catch (RuntimeException e2) {
                e = e2;
                this.b.onFailure(e);
            } catch (ExecutionException e3) {
                Throwable cause = e3.getCause();
                if (cause == null) {
                    this.b.onFailure(e3);
                } else {
                    this.b.onFailure(cause);
                }
            }
        }

        public String toString() {
            return e.class.getSimpleName() + "," + this.b;
        }
    }

    public static InterfaceFutureC15215jC3 A(final InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
        return AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.TB2
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return WB2.r(interfaceFutureC15215jC3, aVar);
            }
        });
    }

    public static void g(InterfaceFutureC15215jC3 interfaceFutureC15215jC3, MB2 mb2, Executor executor) {
        AbstractC4980Hj5.g(mb2);
        interfaceFutureC15215jC3.j(new e(interfaceFutureC15215jC3, mb2), executor);
    }

    public static Object h(Future future) {
        AbstractC4980Hj5.j(future.isDone(), "Future was expected to be done, " + future);
        return i(future);
    }

    public static Object i(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
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
        return obj;
    }

    public static InterfaceFutureC15215jC3 j(Throwable th) {
        return new V33.a(th);
    }

    public static ScheduledFuture k(Throwable th) {
        return new V33.b(th);
    }

    public static InterfaceFutureC15215jC3 l(Object obj) {
        return obj == null ? V33.a() : new V33.c(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean m(AbstractC16967mA0.a aVar, InterfaceFutureC15215jC3 interfaceFutureC15215jC3, long j) {
        return Boolean.valueOf(aVar.f(new TimeoutException("Future[" + interfaceFutureC15215jC3 + "] is not done within " + j + " ms.")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object o(final InterfaceFutureC15215jC3 interfaceFutureC15215jC3, ScheduledExecutorService scheduledExecutorService, final long j, final AbstractC16967mA0.a aVar) {
        u(interfaceFutureC15215jC3, aVar);
        if (!interfaceFutureC15215jC3.isDone()) {
            final ScheduledFuture scheduledFutureSchedule = scheduledExecutorService.schedule(new Callable() { // from class: ir.nasim.RB2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return WB2.m(aVar, interfaceFutureC15215jC3, j);
                }
            }, j, TimeUnit.MILLISECONDS);
            interfaceFutureC15215jC3.j(new Runnable() { // from class: ir.nasim.SB2
                @Override // java.lang.Runnable
                public final void run() {
                    scheduledFutureSchedule.cancel(true);
                }
            }, AbstractC20567sE0.a());
        }
        return "TimeoutFuture[" + interfaceFutureC15215jC3 + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object p(InterfaceFutureC15215jC3 interfaceFutureC15215jC3, AbstractC16967mA0.a aVar) {
        w(false, interfaceFutureC15215jC3, a, aVar, AbstractC20567sE0.a());
        return "nonCancellationPropagating[" + interfaceFutureC15215jC3 + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object r(InterfaceFutureC15215jC3 interfaceFutureC15215jC3, final AbstractC16967mA0.a aVar) {
        interfaceFutureC15215jC3.j(new Runnable() { // from class: ir.nasim.UB2
            @Override // java.lang.Runnable
            public final void run() {
                aVar.c(null);
            }
        }, AbstractC20567sE0.a());
        return "transformVoidFuture [" + interfaceFutureC15215jC3 + "]";
    }

    public static InterfaceFutureC15215jC3 s(final long j, final ScheduledExecutorService scheduledExecutorService, final InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
        return AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.QB2
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return WB2.o(interfaceFutureC15215jC3, scheduledExecutorService, j, aVar);
            }
        });
    }

    public static InterfaceFutureC15215jC3 t(final InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
        AbstractC4980Hj5.g(interfaceFutureC15215jC3);
        return interfaceFutureC15215jC3.isDone() ? interfaceFutureC15215jC3 : AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.VB2
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return WB2.p(interfaceFutureC15215jC3, aVar);
            }
        });
    }

    public static void u(InterfaceFutureC15215jC3 interfaceFutureC15215jC3, AbstractC16967mA0.a aVar) {
        v(interfaceFutureC15215jC3, a, aVar, AbstractC20567sE0.a());
    }

    public static void v(InterfaceFutureC15215jC3 interfaceFutureC15215jC3, InterfaceC21819uB2 interfaceC21819uB2, AbstractC16967mA0.a aVar, Executor executor) {
        w(true, interfaceFutureC15215jC3, interfaceC21819uB2, aVar, executor);
    }

    private static void w(boolean z, InterfaceFutureC15215jC3 interfaceFutureC15215jC3, InterfaceC21819uB2 interfaceC21819uB2, AbstractC16967mA0.a aVar, Executor executor) {
        AbstractC4980Hj5.g(interfaceFutureC15215jC3);
        AbstractC4980Hj5.g(interfaceC21819uB2);
        AbstractC4980Hj5.g(aVar);
        AbstractC4980Hj5.g(executor);
        g(interfaceFutureC15215jC3, new c(aVar, interfaceC21819uB2), executor);
        if (z) {
            aVar.a(new d(interfaceFutureC15215jC3), AbstractC20567sE0.a());
        }
    }

    public static InterfaceFutureC15215jC3 x(Collection collection) {
        return new KB3(new ArrayList(collection), false, AbstractC20567sE0.a());
    }

    public static InterfaceFutureC15215jC3 y(InterfaceFutureC15215jC3 interfaceFutureC15215jC3, InterfaceC21819uB2 interfaceC21819uB2, Executor executor) {
        AbstractC4980Hj5.g(interfaceC21819uB2);
        return z(interfaceFutureC15215jC3, new a(interfaceC21819uB2), executor);
    }

    public static InterfaceFutureC15215jC3 z(InterfaceFutureC15215jC3 interfaceFutureC15215jC3, FK fk, Executor executor) {
        RunnableC16448lI0 runnableC16448lI0 = new RunnableC16448lI0(fk, interfaceFutureC15215jC3);
        interfaceFutureC15215jC3.j(runnableC16448lI0, executor);
        return runnableC16448lI0;
    }

    class b implements InterfaceC21819uB2 {
        b() {
        }

        @Override // ir.nasim.InterfaceC21819uB2
        public Object apply(Object obj) {
            return obj;
        }
    }
}
