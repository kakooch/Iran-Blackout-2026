package ir.nasim;

import ir.nasim.AbstractC8971Ya2;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes8.dex */
public final class PD1 extends AbstractC8971Ya2 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final PD1 i;
    private static final long j;

    static {
        Long l;
        PD1 pd1 = new PD1();
        i = pd1;
        AbstractC8717Xa2.N0(pd1, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        j = timeUnit.toNanos(l.longValue());
    }

    private PD1() {
    }

    private final synchronized void U1() {
        if (X1()) {
            debugStatus = 3;
            G1();
            AbstractC13042fc3.g(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread V1() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean W1() {
        return debugStatus == 4;
    }

    private final boolean X1() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    private final synchronized boolean Y1() {
        if (X1()) {
            return false;
        }
        debugStatus = 1;
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    private final void Z1() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // ir.nasim.AbstractC8971Ya2, ir.nasim.GG1
    public NV1 J(long j2, Runnable runnable, InterfaceC11938do1 interfaceC11938do1) {
        return R1(j2, runnable);
    }

    @Override // ir.nasim.AbstractC9226Za2
    protected Thread b1() {
        Thread thread = _thread;
        return thread == null ? V1() : thread;
    }

    @Override // ir.nasim.AbstractC9226Za2
    protected void d1(long j2, AbstractC8971Ya2.c cVar) {
        Z1();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zA1;
        C8582Wo7.a.d(this);
        AbstractC10072b2.a();
        try {
            if (!Y1()) {
                if (zA1) {
                    return;
                } else {
                    return;
                }
            }
            long j2 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jS0 = S0();
                if (jS0 == Long.MAX_VALUE) {
                    AbstractC10072b2.a();
                    long jNanoTime = System.nanoTime();
                    if (j2 == Long.MAX_VALUE) {
                        j2 = j + jNanoTime;
                    }
                    long j3 = j2 - jNanoTime;
                    if (j3 <= 0) {
                        _thread = null;
                        U1();
                        AbstractC10072b2.a();
                        if (A1()) {
                            return;
                        }
                        b1();
                        return;
                    }
                    jS0 = AbstractC23053wG5.j(jS0, j3);
                } else {
                    j2 = Long.MAX_VALUE;
                }
                if (jS0 > 0) {
                    if (X1()) {
                        _thread = null;
                        U1();
                        AbstractC10072b2.a();
                        if (A1()) {
                            return;
                        }
                        b1();
                        return;
                    }
                    AbstractC10072b2.a();
                    LockSupport.parkNanos(this, jS0);
                }
            }
        } finally {
            _thread = null;
            U1();
            AbstractC10072b2.a();
            if (!A1()) {
                b1();
            }
        }
    }

    @Override // ir.nasim.AbstractC8971Ya2, ir.nasim.AbstractC8717Xa2
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // ir.nasim.AbstractC8971Ya2
    public void w1(Runnable runnable) {
        if (W1()) {
            Z1();
        }
        super.w1(runnable);
    }
}
