package android.gov.nist.javax.sip;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.NamingThreadFactory;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ThreadAffinityExecutor implements ScheduledExecutorService {
    private static StackLogger logger = CommonLogger.getLogger(ThreadAffinityExecutor.class);
    private final AtomicInteger nextThread = new AtomicInteger(0);
    private final List<MDCScheduledTHExecutor> executors = new ArrayList();

    public ThreadAffinityExecutor(int i) {
        NamingThreadFactory namingThreadFactory = new NamingThreadFactory("AffinityJAIN");
        for (int i2 = 0; i2 < i; i2++) {
            this.executors.add(new MDCScheduledTHExecutor(1, namingThreadFactory));
        }
        schedulePurgeTaskIfNeeded();
    }

    private int calculateAffinityThread(Runnable runnable) {
        if (!(runnable instanceof ThreadAffinityIdentifier)) {
            return retrieveNextThread();
        }
        Object threadHash = ((ThreadAffinityIdentifier) runnable).getThreadHash();
        if (threadHash == null) {
            return retrieveNextThread();
        }
        int iAbs = Math.abs(threadHash.hashCode() % this.executors.size());
        if (!logger.isLoggingEnabled(32)) {
            return iAbs;
        }
        logger.logDebug("Runnable assigned to thread (" + threadHash + "," + iAbs + Separators.RPAREN);
        return iAbs;
    }

    private synchronized int retrieveNextThread() {
        int iIncrementAndGet;
        try {
            iIncrementAndGet = this.nextThread.incrementAndGet();
            if (iIncrementAndGet >= this.executors.size()) {
                this.nextThread.set(0);
                iIncrementAndGet = 0;
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Next thread id=" + iIncrementAndGet);
            }
        } catch (Throwable th) {
            throw th;
        }
        return iIncrementAndGet;
    }

    private void schedulePurgeTaskIfNeeded() {
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.executors.get(0).awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.executors.get(calculateAffinityThread(runnable)).execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.executors.get(0).isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.executors.get(0).isTerminated();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.executors.get(calculateAffinityThread(runnable)).schedule(runnable, j, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.executors.get(calculateAffinityThread(runnable)).scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.executors.get(calculateAffinityThread(runnable)).scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        Iterator<MDCScheduledTHExecutor> it = this.executors.iterator();
        while (it.hasNext()) {
            it.next().shutdown();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.executors.get(calculateAffinityThread(runnable)).submit(runnable, t);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.executors.get(calculateAffinityThread(runnable)).submit(runnable);
    }
}
