package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* compiled from: Dispatcher.kt */
/* loaded from: classes4.dex */
final class LimitingDispatcher extends ExecutorCoroutineDispatcher implements TaskContext, Executor {
    private static final AtomicIntegerFieldUpdater inFlightTasks$FU = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
    private final ExperimentalCoroutineDispatcher dispatcher;
    private final String name;
    private final int parallelism;
    private final int taskMode;
    private final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();
    private volatile int inFlightTasks = 0;

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return this.taskMode;
    }

    public LimitingDispatcher(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i, String str, int i2) {
        this.dispatcher = experimentalCoroutineDispatcher;
        this.parallelism = i;
        this.name = str;
        this.taskMode = i2;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch(runnable, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public void mo562dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        dispatch(runnable, false);
    }

    private final void dispatch(Runnable runnable, boolean z) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = inFlightTasks$FU;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.parallelism) {
                this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(runnable, this, z);
                return;
            }
            this.queue.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.parallelism) {
                return;
            } else {
                runnable = this.queue.poll();
            }
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.dispatcher + ']';
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
        Runnable runnablePoll = this.queue.poll();
        if (runnablePoll != null) {
            this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(runnablePoll, this, true);
            return;
        }
        inFlightTasks$FU.decrementAndGet(this);
        Runnable runnablePoll2 = this.queue.poll();
        if (runnablePoll2 != null) {
            dispatch(runnablePoll2, true);
        }
    }
}
