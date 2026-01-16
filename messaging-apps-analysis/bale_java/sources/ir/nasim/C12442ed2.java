package ir.nasim;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.ed2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C12442ed2 extends AbstractC11830dd2 implements GG1 {
    private final Executor d;

    public C12442ed2(Executor executor) {
        this.d = executor;
        AbstractC3255Ac1.a(C0());
    }

    private final void D0(InterfaceC11938do1 interfaceC11938do1, RejectedExecutionException rejectedExecutionException) {
        AbstractC19067pj3.c(interfaceC11938do1, AbstractC15450jc2.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture F0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, InterfaceC11938do1 interfaceC11938do1, long j) {
        try {
            return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            D0(interfaceC11938do1, e);
            return null;
        }
    }

    @Override // ir.nasim.AbstractC11830dd2
    public Executor C0() {
        return this.d;
    }

    @Override // ir.nasim.GG1
    public NV1 J(long j, Runnable runnable, InterfaceC11938do1 interfaceC11938do1) {
        Executor executorC0 = C0();
        ScheduledExecutorService scheduledExecutorService = executorC0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorC0 : null;
        ScheduledFuture scheduledFutureF0 = scheduledExecutorService != null ? F0(scheduledExecutorService, runnable, interfaceC11938do1, j) : null;
        return scheduledFutureF0 != null ? new MV1(scheduledFutureF0) : PD1.i.J(j, runnable, interfaceC11938do1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorC0 = C0();
        ExecutorService executorService = executorC0 instanceof ExecutorService ? (ExecutorService) executorC0 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // ir.nasim.GG1
    public void e0(long j, HE0 he0) {
        Executor executorC0 = C0();
        ScheduledExecutorService scheduledExecutorService = executorC0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorC0 : null;
        ScheduledFuture scheduledFutureF0 = scheduledExecutorService != null ? F0(scheduledExecutorService, new RunnableC16883m16(this, he0), he0.getContext(), j) : null;
        if (scheduledFutureF0 != null) {
            AbstractC19067pj3.l(he0, scheduledFutureF0);
        } else {
            PD1.i.e0(j, he0);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C12442ed2) && ((C12442ed2) obj).C0() == C0();
    }

    public int hashCode() {
        return System.identityHashCode(C0());
    }

    @Override // ir.nasim.AbstractC13778go1
    public String toString() {
        return C0().toString();
    }

    @Override // ir.nasim.AbstractC13778go1
    public void x0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        try {
            Executor executorC0 = C0();
            AbstractC10072b2.a();
            executorC0.execute(runnable);
        } catch (RejectedExecutionException e) {
            AbstractC10072b2.a();
            D0(interfaceC11938do1, e);
            C12366eV1.b().x0(interfaceC11938do1, runnable);
        }
    }
}
