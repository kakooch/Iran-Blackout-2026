package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isCompleted() {
        return this._isCompleted;
    }

    private final void setCompleted(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    protected boolean isEmpty() {
        if (!isUnconfinedQueueEmpty()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                return ((LockFreeTaskQueueCore) obj).isEmpty();
            }
            if (obj != EventLoop_commonKt.CLOSED_EMPTY) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.EventLoop
    protected long getNextTime() {
        if (super.getNextTime() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                return obj == EventLoop_commonKt.CLOSED_EMPTY ? Long.MAX_VALUE : 0L;
            }
            if (!((LockFreeTaskQueueCore) obj).isEmpty()) {
                return 0L;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        DelayedTask delayedTaskPeek = delayedTaskQueue == null ? null : delayedTaskQueue.peek();
        if (delayedTaskPeek == null) {
            return Long.MAX_VALUE;
        }
        long j = delayedTaskPeek.nanoTime;
        if (AbstractTimeSourceKt.getTimeSource() == null) {
            return RangesKt___RangesKt.coerceAtLeast(j - System.nanoTime(), 0L);
        }
        throw null;
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        setCompleted(true);
        closeQueue();
        while (processNextEvent() <= 0) {
        }
        rescheduleAllDelayed();
    }

    public long processNextEvent() {
        DelayedTask delayedTaskRemoveAtImpl;
        if (processUnconfinedEvent()) {
            return 0L;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null && !delayedTaskQueue.isEmpty()) {
            if (AbstractTimeSourceKt.getTimeSource() != null) {
                throw null;
            }
            long jNanoTime = System.nanoTime();
            do {
                synchronized (delayedTaskQueue) {
                    DelayedTask delayedTaskFirstImpl = delayedTaskQueue.firstImpl();
                    if (delayedTaskFirstImpl == null) {
                        delayedTaskRemoveAtImpl = null;
                    } else {
                        DelayedTask delayedTask = delayedTaskFirstImpl;
                        delayedTaskRemoveAtImpl = delayedTask.timeToExecute(jNanoTime) ? enqueueImpl(delayedTask) : false ? delayedTaskQueue.removeAtImpl(0) : null;
                    }
                }
            } while (delayedTaskRemoveAtImpl != null);
        }
        Runnable runnableDequeue = dequeue();
        if (runnableDequeue != null) {
            runnableDequeue.run();
            return 0L;
        }
        return getNextTime();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: dispatch */
    public final void mo39dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        enqueue(runnable);
    }

    public void enqueue(Runnable runnable) {
        if (enqueueImpl(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.enqueue(runnable);
        }
    }

    private final void closeQueue() {
        if (DebugKt.getASSERTIONS_ENABLED() && !isCompleted()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (_queue$FU.compareAndSet(this, null, EventLoop_commonKt.CLOSED_EMPTY)) {
                    return;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                    return;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.addLast((Runnable) obj);
                if (_queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                    return;
                }
            } else {
                ((LockFreeTaskQueueCore) obj).close();
                return;
            }
        }
    }

    public final void schedule(long j, DelayedTask delayedTask) {
        int iScheduleImpl = scheduleImpl(j, delayedTask);
        if (iScheduleImpl == 0) {
            if (shouldUnpark(delayedTask)) {
                unpark();
            }
        } else if (iScheduleImpl == 1) {
            reschedule(j, delayedTask);
        } else if (iScheduleImpl != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    private final boolean shouldUnpark(DelayedTask delayedTask) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        return (delayedTaskQueue == null ? null : delayedTaskQueue.peek()) == delayedTask;
    }

    private final int scheduleImpl(long j, DelayedTask delayedTask) {
        if (isCompleted()) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null) {
            _delayed$FU.compareAndSet(this, null, new DelayedTaskQueue(j));
            Object obj = this._delayed;
            Intrinsics.checkNotNull(obj);
            delayedTaskQueue = (DelayedTaskQueue) obj;
        }
        return delayedTask.scheduleTask(j, delayedTaskQueue, this);
    }

    protected final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    private final void rescheduleAllDelayed() {
        if (AbstractTimeSourceKt.getTimeSource() != null) {
            throw null;
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            DelayedTask delayedTaskRemoveFirstOrNull = delayedTaskQueue == null ? null : delayedTaskQueue.removeFirstOrNull();
            if (delayedTaskRemoveFirstOrNull == null) {
                return;
            } else {
                reschedule(jNanoTime, delayedTaskRemoveFirstOrNull);
            }
        }
    }

    /* compiled from: EventLoop.common.kt */
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private Object _heap;
        private int index;
        public long nanoTime;

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(ThreadSafeHeap<?> threadSafeHeap) {
            if (!(this._heap != EventLoop_commonKt.DISPOSED_TASK)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = threadSafeHeap;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int i) {
            this.index = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(DelayedTask delayedTask) {
            long j = this.nanoTime - delayedTask.nanoTime;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        public final boolean timeToExecute(long j) {
            return j - this.nanoTime >= 0;
        }

        public final synchronized int scheduleTask(long j, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            if (this._heap == EventLoop_commonKt.DISPOSED_TASK) {
                return 2;
            }
            synchronized (delayedTaskQueue) {
                DelayedTask delayedTaskFirstImpl = delayedTaskQueue.firstImpl();
                if (eventLoopImplBase.isCompleted()) {
                    return 1;
                }
                if (delayedTaskFirstImpl == null) {
                    delayedTaskQueue.timeNow = j;
                } else {
                    long j2 = delayedTaskFirstImpl.nanoTime;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - delayedTaskQueue.timeNow > 0) {
                        delayedTaskQueue.timeNow = j;
                    }
                }
                long j3 = this.nanoTime;
                long j4 = delayedTaskQueue.timeNow;
                if (j3 - j4 < 0) {
                    this.nanoTime = j4;
                }
                delayedTaskQueue.addImpl(this);
                return 0;
            }
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void dispose() {
            Object obj = this._heap;
            if (obj == EventLoop_commonKt.DISPOSED_TASK) {
                return;
            }
            DelayedTaskQueue delayedTaskQueue = obj instanceof DelayedTaskQueue ? (DelayedTaskQueue) obj : null;
            if (delayedTaskQueue != null) {
                delayedTaskQueue.remove(this);
            }
            this._heap = EventLoop_commonKt.DISPOSED_TASK;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        public long timeNow;

        public DelayedTaskQueue(long j) {
            this.timeNow = j;
        }
    }

    private final boolean enqueueImpl(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (_queue$FU.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                    return false;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.addLast((Runnable) obj);
                lockFreeTaskQueueCore.addLast(runnable);
                if (_queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                    return true;
                }
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = (LockFreeTaskQueueCore) obj;
                int iAddLast = lockFreeTaskQueueCore2.addLast(runnable);
                if (iAddLast == 0) {
                    return true;
                }
                if (iAddLast == 1) {
                    _queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore2.next());
                } else if (iAddLast == 2) {
                    return false;
                }
            }
        }
    }

    private final Runnable dequeue() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                if (obj == EventLoop_commonKt.CLOSED_EMPTY) {
                    return null;
                }
                if (_queue$FU.compareAndSet(this, obj, null)) {
                    return (Runnable) obj;
                }
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object objRemoveFirstOrNull = lockFreeTaskQueueCore.removeFirstOrNull();
                if (objRemoveFirstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return (Runnable) objRemoveFirstOrNull;
                }
                _queue$FU.compareAndSet(this, obj, lockFreeTaskQueueCore.next());
            }
        }
    }
}
