package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.EventLoopImplBase;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes3.dex */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    public static final DefaultExecutor INSTANCE;
    private static final long KEEP_ALIVE_NANOS;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    private DefaultExecutor() {
    }

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        INSTANCE = defaultExecutor;
        EventLoop.incrementUseCount$default(defaultExecutor, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l.longValue());
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected Thread getThread() {
        Thread thread = _thread;
        return thread == null ? createThreadSync() : thread;
    }

    private final boolean isShutDown() {
        return debugStatus == 4;
    }

    private final boolean isShutdownRequested() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public void enqueue(Runnable runnable) {
        if (isShutDown()) {
            shutdownError();
        }
        super.enqueue(runnable);
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected void reschedule(long j, EventLoopImplBase.DelayedTask delayedTask) {
        shutdownError();
    }

    private final void shutdownError() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        if (AbstractTimeSourceKt.getTimeSource() != null) {
            throw null;
        }
        try {
            if (!notifyStartup()) {
                _thread = null;
                acknowledgeShutdownIfNeeded();
                if (AbstractTimeSourceKt.getTimeSource() != null) {
                    throw null;
                }
                if (isEmpty()) {
                    return;
                }
                getThread();
                return;
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jProcessNextEvent = processNextEvent();
                if (jProcessNextEvent != Long.MAX_VALUE) {
                    j = Long.MAX_VALUE;
                } else {
                    if (AbstractTimeSourceKt.getTimeSource() != null) {
                        throw null;
                    }
                    long jNanoTime = System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = KEEP_ALIVE_NANOS + jNanoTime;
                    }
                    long j2 = j - jNanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        acknowledgeShutdownIfNeeded();
                        if (AbstractTimeSourceKt.getTimeSource() != null) {
                            throw null;
                        }
                        if (isEmpty()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    jProcessNextEvent = RangesKt___RangesKt.coerceAtMost(jProcessNextEvent, j2);
                }
                if (jProcessNextEvent > 0) {
                    if (isShutdownRequested()) {
                        _thread = null;
                        acknowledgeShutdownIfNeeded();
                        if (AbstractTimeSourceKt.getTimeSource() != null) {
                            throw null;
                        }
                        if (isEmpty()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    if (AbstractTimeSourceKt.getTimeSource() != null) {
                        throw null;
                    }
                    LockSupport.parkNanos(this, jProcessNextEvent);
                }
            }
        } catch (Throwable th) {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            if (AbstractTimeSourceKt.getTimeSource() != null) {
                throw null;
            }
            if (!isEmpty()) {
                getThread();
            }
            throw th;
        }
    }

    private final synchronized Thread createThreadSync() {
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

    private final synchronized boolean notifyStartup() {
        if (isShutdownRequested()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        if (isShutdownRequested()) {
            debugStatus = 3;
            resetAll();
            notifyAll();
        }
    }
}
