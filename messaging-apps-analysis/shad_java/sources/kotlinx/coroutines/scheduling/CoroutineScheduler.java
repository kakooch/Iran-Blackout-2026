package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.TimeSourceKt;
import kotlinx.coroutines.internal.Symbol;
import org.rbmain.tgnet.ConnectionsManager;

/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes4.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    public static final Symbol NOT_IN_STACK;
    private static final AtomicIntegerFieldUpdater _isTerminated$FU;
    static final AtomicLongFieldUpdater controlState$FU;
    private static final AtomicLongFieldUpdater parkedWorkersStack$FU;
    private volatile int _isTerminated;
    volatile long controlState;
    public final int corePoolSize;
    public final GlobalQueue globalBlockingQueue;
    public final GlobalQueue globalCpuQueue;
    public final long idleWorkerKeepAliveNs;
    public final int maxPoolSize;
    private volatile long parkedWorkersStack;
    public final String schedulerName;
    public final AtomicReferenceArray<Worker> workers;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* compiled from: CoroutineScheduler.kt */
    public final class Worker extends Thread {
        static final AtomicIntegerFieldUpdater workerCtl$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        private volatile int indexInArray;
        public final WorkQueue localQueue;
        public boolean mayHaveLocalTasks;
        private long minDelayUntilStealableTaskNs;
        private volatile Object nextParkedWorker;
        private int rngState;
        public WorkerState state;
        private long terminationDeadline;
        volatile int workerCtl;

        private final void executeTask(Task task) {
            int taskMode = task.taskContext.getTaskMode();
            idleReset(taskMode);
            beforeTask(taskMode);
            CoroutineScheduler.this.runSafely(task);
            afterTask(taskMode);
        }

        private Worker() {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.state = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.rngState = Random.Default.nextInt();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i) {
            this();
            setIndexInArray(i);
        }

        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void setNextParkedWorker(Object obj) {
            this.nextParkedWorker = obj;
        }

        private final boolean tryAcquireCpuPermit() {
            boolean z;
            if (this.state != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        z = false;
                        break;
                    }
                    if (CoroutineScheduler.controlState$FU.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.state = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        public final boolean tryReleaseCpu$kotlinx_coroutines_core(WorkerState workerState) {
            WorkerState workerState2 = this.state;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            runWorker();
        }

        private final void runWorker() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    Task taskFindTask = findTask(this.mayHaveLocalTasks);
                    if (taskFindTask != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        executeTask(taskFindTask);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            tryPark();
                        } else if (z) {
                            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
                break loop0;
            }
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.TERMINATED);
        }

        private final void tryPark() {
            if (!inStack()) {
                CoroutineScheduler.this.parkedWorkersStackPush$kotlinx_coroutines_core(this);
                return;
            }
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(this.localQueue.getSize$kotlinx_coroutines_core() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (inStack() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
                Thread.interrupted();
                park();
            }
        }

        private final boolean inStack() {
            return this.nextParkedWorker != CoroutineScheduler.NOT_IN_STACK;
        }

        private final void beforeTask(int i) {
            if (i != 0 && tryReleaseCpu$kotlinx_coroutines_core(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.signalCpuWork$kotlinx_coroutines_core();
            }
        }

        private final void afterTask(int i) {
            if (i == 0) {
                return;
            }
            CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, -2097152L);
            WorkerState workerState = this.state;
            if (workerState != WorkerState.TERMINATED) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(workerState == WorkerState.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.DORMANT;
            }
        }

        public final int nextInt$kotlinx_coroutines_core(int i) {
            int i2 = this.rngState;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.rngState = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & ConnectionsManager.DEFAULT_DATACENTER_ID) % i;
        }

        private final void park() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                tryTerminateWorker();
            }
        }

        private final void tryTerminateWorker() {
            synchronized (CoroutineScheduler.this.workers) {
                if (CoroutineScheduler.this.isTerminated()) {
                    return;
                }
                if (CoroutineScheduler.this.getCreatedWorkers() <= CoroutineScheduler.this.corePoolSize) {
                    return;
                }
                if (workerCtl$FU.compareAndSet(this, -1, 1)) {
                    int i = this.indexInArray;
                    setIndexInArray(0);
                    CoroutineScheduler.this.parkedWorkersStackTopUpdate$kotlinx_coroutines_core(this, i, 0);
                    int andDecrement = (int) (CoroutineScheduler.controlState$FU.getAndDecrement(CoroutineScheduler.this) & 2097151);
                    if (andDecrement != i) {
                        Worker worker = CoroutineScheduler.this.workers.get(andDecrement);
                        Intrinsics.checkNotNull(worker);
                        Worker worker2 = worker;
                        CoroutineScheduler.this.workers.set(i, worker2);
                        worker2.setIndexInArray(i);
                        CoroutineScheduler.this.parkedWorkersStackTopUpdate$kotlinx_coroutines_core(worker2, andDecrement, i);
                    }
                    CoroutineScheduler.this.workers.set(andDecrement, null);
                    Unit unit = Unit.INSTANCE;
                    this.state = WorkerState.TERMINATED;
                }
            }
        }

        private final void idleReset(int i) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(i == 1)) {
                        throw new AssertionError();
                    }
                }
                this.state = WorkerState.BLOCKING;
            }
        }

        public final Task findTask(boolean z) {
            Task taskRemoveFirstOrNull;
            if (tryAcquireCpuPermit()) {
                return findAnyTask(z);
            }
            if (!z || (taskRemoveFirstOrNull = this.localQueue.poll()) == null) {
                taskRemoveFirstOrNull = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            return taskRemoveFirstOrNull != null ? taskRemoveFirstOrNull : trySteal(true);
        }

        private final Task findAnyTask(boolean z) {
            Task taskPollGlobalQueues;
            Task taskPollGlobalQueues2;
            if (z) {
                boolean z2 = nextInt$kotlinx_coroutines_core(CoroutineScheduler.this.corePoolSize * 2) == 0;
                if (z2 && (taskPollGlobalQueues2 = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues2;
                }
                Task taskPoll = this.localQueue.poll();
                if (taskPoll != null) {
                    return taskPoll;
                }
                if (!z2 && (taskPollGlobalQueues = pollGlobalQueues()) != null) {
                    return taskPollGlobalQueues;
                }
            } else {
                Task taskPollGlobalQueues3 = pollGlobalQueues();
                if (taskPollGlobalQueues3 != null) {
                    return taskPollGlobalQueues3;
                }
            }
            return trySteal(false);
        }

        private final Task pollGlobalQueues() {
            if (nextInt$kotlinx_coroutines_core(2) == 0) {
                Task taskRemoveFirstOrNull = CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
                return taskRemoveFirstOrNull != null ? taskRemoveFirstOrNull : CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            }
            Task taskRemoveFirstOrNull2 = CoroutineScheduler.this.globalBlockingQueue.removeFirstOrNull();
            return taskRemoveFirstOrNull2 != null ? taskRemoveFirstOrNull2 : CoroutineScheduler.this.globalCpuQueue.removeFirstOrNull();
        }

        private final Task trySteal(boolean z) {
            long jTryStealFrom;
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(this.localQueue.getSize$kotlinx_coroutines_core() == 0)) {
                    throw new AssertionError();
                }
            }
            int createdWorkers = CoroutineScheduler.this.getCreatedWorkers();
            if (createdWorkers < 2) {
                return null;
            }
            int iNextInt$kotlinx_coroutines_core = nextInt$kotlinx_coroutines_core(createdWorkers);
            long jMin = Long.MAX_VALUE;
            for (int i = 0; i < createdWorkers; i++) {
                iNextInt$kotlinx_coroutines_core++;
                if (iNextInt$kotlinx_coroutines_core > createdWorkers) {
                    iNextInt$kotlinx_coroutines_core = 1;
                }
                Worker worker = CoroutineScheduler.this.workers.get(iNextInt$kotlinx_coroutines_core);
                if (worker != null && worker != this) {
                    if (DebugKt.getASSERTIONS_ENABLED()) {
                        if (!(this.localQueue.getSize$kotlinx_coroutines_core() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z) {
                        jTryStealFrom = this.localQueue.tryStealBlockingFrom(worker.localQueue);
                    } else {
                        jTryStealFrom = this.localQueue.tryStealFrom(worker.localQueue);
                    }
                    if (jTryStealFrom == -1) {
                        return this.localQueue.poll();
                    }
                    if (jTryStealFrom > 0) {
                        jMin = Math.min(jMin, jTryStealFrom);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.minDelayUntilStealableTaskNs = jMin;
            return null;
        }
    }

    private final boolean addToGlobalQueue(Task task) {
        if (task.taskContext.getTaskMode() == 1) {
            return this.globalBlockingQueue.addLast(task);
        }
        return this.globalCpuQueue.addLast(task);
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should be greater than or equals to core pool size " + i).toString());
        }
        if (!(i2 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.globalCpuQueue = new GlobalQueue();
        this.globalBlockingQueue = new GlobalQueue();
        this.parkedWorkersStack = 0L;
        this.workers = new AtomicReferenceArray<>(i2 + 1);
        this.controlState = i << 42;
        this._isTerminated = 0;
    }

    public final boolean parkedWorkersStackPush$kotlinx_coroutines_core(Worker worker) {
        long j;
        long j2;
        int indexInArray;
        if (worker.getNextParkedWorker() != NOT_IN_STACK) {
            return false;
        }
        do {
            j = this.parkedWorkersStack;
            int i = (int) (2097151 & j);
            j2 = (2097152 + j) & (-2097152);
            indexInArray = worker.getIndexInArray();
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(indexInArray != 0)) {
                    throw new AssertionError();
                }
            }
            worker.setNextParkedWorker(this.workers.get(i));
        } while (!parkedWorkersStack$FU.compareAndSet(this, j, indexInArray | j2));
        return true;
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCreatedWorkers() {
        return (int) (this.controlState & 2097151);
    }

    private final void signalBlockingWork(boolean z) {
        long jAddAndGet = controlState$FU.addAndGet(this, 2097152L);
        if (z || tryUnpark() || tryCreateWorker(jAddAndGet)) {
            return;
        }
        tryUnpark();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    /* compiled from: CoroutineScheduler.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        new Companion(null);
        NOT_IN_STACK = new Symbol("NOT_IN_STACK");
        parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
        controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
        _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch$default(this, runnable, null, false, 6, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        shutdown(10000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void shutdown(long r9) throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler._isTerminated$FU
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r0 = r8.currentWorker()
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$Worker> r3 = r8.workers
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lb5
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r3)
            if (r2 > r5) goto L5b
            r3 = 1
        L1d:
            java.util.concurrent.atomic.AtomicReferenceArray<kotlinx.coroutines.scheduling.CoroutineScheduler$Worker> r4 = r8.workers
            java.lang.Object r4 = r4.get(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r4 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r4
            if (r4 == r0) goto L56
        L2a:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L37
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r9)
            goto L2a
        L37:
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r6 = r4.state
            boolean r7 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r7 == 0) goto L4f
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            if (r6 != r7) goto L45
            r6 = 1
            goto L46
        L45:
            r6 = 0
        L46:
            if (r6 == 0) goto L49
            goto L4f
        L49:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L4f:
            kotlinx.coroutines.scheduling.WorkQueue r4 = r4.localQueue
            kotlinx.coroutines.scheduling.GlobalQueue r6 = r8.globalBlockingQueue
            r4.offloadAllWorkTo(r6)
        L56:
            if (r3 == r5) goto L5b
            int r3 = r3 + 1
            goto L1d
        L5b:
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalBlockingQueue
            r9.close()
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalCpuQueue
            r9.close()
        L65:
            if (r0 == 0) goto L6e
            kotlinx.coroutines.scheduling.Task r9 = r0.findTask(r2)
            if (r9 == 0) goto L6e
            goto L76
        L6e:
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalCpuQueue
            java.lang.Object r9 = r9.removeFirstOrNull()
            kotlinx.coroutines.scheduling.Task r9 = (kotlinx.coroutines.scheduling.Task) r9
        L76:
            if (r9 == 0) goto L79
            goto L81
        L79:
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalBlockingQueue
            java.lang.Object r9 = r9.removeFirstOrNull()
            kotlinx.coroutines.scheduling.Task r9 = (kotlinx.coroutines.scheduling.Task) r9
        L81:
            if (r9 == 0) goto L87
            r8.runSafely(r9)
            goto L65
        L87:
            if (r0 == 0) goto L8e
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.tryReleaseCpu$kotlinx_coroutines_core(r9)
        L8e:
            boolean r9 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r9 == 0) goto Lae
            long r9 = r8.controlState
            r3 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r3
            r0 = 42
            long r9 = r9 >> r0
            int r10 = (int) r9
            int r9 = r8.corePoolSize
            if (r10 != r9) goto La5
            r1 = 1
        La5:
            if (r1 == 0) goto La8
            goto Lae
        La8:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        Lae:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        Lb5:
            r9 = move-exception
            monitor-exit(r3)
            goto Lb9
        Lb8:
            throw r9
        Lb9:
            goto Lb8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.shutdown(long):void");
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            taskContext = NonBlockingContext.INSTANCE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z);
    }

    public final void dispatch(Runnable runnable, TaskContext taskContext, boolean z) {
        kotlinx.coroutines.TimeSource timeSource = TimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.trackTask();
        }
        Task taskCreateTask$kotlinx_coroutines_core = createTask$kotlinx_coroutines_core(runnable, taskContext);
        Worker workerCurrentWorker = currentWorker();
        Task taskSubmitToLocalQueue = submitToLocalQueue(workerCurrentWorker, taskCreateTask$kotlinx_coroutines_core, z);
        if (taskSubmitToLocalQueue == null || addToGlobalQueue(taskSubmitToLocalQueue)) {
            boolean z2 = z && workerCurrentWorker != null;
            if (taskCreateTask$kotlinx_coroutines_core.taskContext.getTaskMode() != 0) {
                signalBlockingWork(z2);
                return;
            } else {
                if (z2) {
                    return;
                }
                signalCpuWork$kotlinx_coroutines_core();
                return;
            }
        }
        throw new RejectedExecutionException(this.schedulerName + " was terminated");
    }

    public final Task createTask$kotlinx_coroutines_core(Runnable runnable, TaskContext taskContext) {
        long jNanoTime = TasksKt.schedulerTimeSource.nanoTime();
        if (runnable instanceof Task) {
            Task task = (Task) runnable;
            task.submissionTime = jNanoTime;
            task.taskContext = taskContext;
            return task;
        }
        return new TaskImpl(runnable, jNanoTime, taskContext);
    }

    public final void signalCpuWork$kotlinx_coroutines_core() {
        if (tryUnpark() || tryCreateWorker$default(this, 0L, 1, null)) {
            return;
        }
        tryUnpark();
    }

    static /* synthetic */ boolean tryCreateWorker$default(CoroutineScheduler coroutineScheduler, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = coroutineScheduler.controlState;
        }
        return coroutineScheduler.tryCreateWorker(j);
    }

    private final boolean tryCreateWorker(long j) {
        if (RangesKt___RangesKt.coerceAtLeast(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.corePoolSize) {
            int iCreateNewWorker = createNewWorker();
            if (iCreateNewWorker == 1 && this.corePoolSize > 1) {
                createNewWorker();
            }
            if (iCreateNewWorker > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean tryUnpark() {
        Worker workerParkedWorkersStackPop;
        do {
            workerParkedWorkersStackPop = parkedWorkersStackPop();
            if (workerParkedWorkersStackPop == null) {
                return false;
            }
        } while (!Worker.workerCtl$FU.compareAndSet(workerParkedWorkersStackPop, -1, 0));
        LockSupport.unpark(workerParkedWorkersStackPop);
        return true;
    }

    private final int createNewWorker() {
        synchronized (this.workers) {
            if (isTerminated()) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & 2097151);
            int iCoerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i - ((int) ((j & 4398044413952L) >> 21)), 0);
            if (iCoerceAtLeast >= this.corePoolSize) {
                return 0;
            }
            if (i >= this.maxPoolSize) {
                return 0;
            }
            int i2 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i2 > 0 && this.workers.get(i2) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            Worker worker = new Worker(this, i2);
            this.workers.set(i2, worker);
            if (!(i2 == ((int) (2097151 & controlState$FU.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            worker.start();
            return iCoerceAtLeast + 1;
        }
    }

    private final Task submitToLocalQueue(Worker worker, Task task, boolean z) {
        if (worker == null || worker.state == WorkerState.TERMINATED) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 0 && worker.state == WorkerState.BLOCKING) {
            return task;
        }
        worker.mayHaveLocalTasks = true;
        return worker.localQueue.add(task, z);
    }

    private final Worker currentWorker() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof Worker)) {
            threadCurrentThread = null;
        }
        Worker worker = (Worker) threadCurrentThread;
        if (worker == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.workers.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            Worker worker = this.workers.get(i6);
            if (worker != null) {
                int size$kotlinx_coroutines_core = worker.localQueue.getSize$kotlinx_coroutines_core();
                int i7 = WhenMappings.$EnumSwitchMapping$0[worker.state.ordinal()];
                if (i7 == 1) {
                    i3++;
                } else if (i7 == 2) {
                    i2++;
                    arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "b");
                } else if (i7 == 3) {
                    i++;
                    arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "c");
                } else if (i7 == 4) {
                    i4++;
                    if (size$kotlinx_coroutines_core > 0) {
                        arrayList.add(String.valueOf(size$kotlinx_coroutines_core) + "d");
                    }
                } else if (i7 == 5) {
                    i5++;
                }
            }
        }
        long j = this.controlState;
        return this.schedulerName + '@' + DebugStringsKt.getHexAddress(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.getSize() + ", global blocking queue size = " + this.globalBlockingQueue.getSize() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    public final void runSafely(Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                kotlinx.coroutines.TimeSource timeSource = TimeSourceKt.getTimeSource();
                if (timeSource == null) {
                }
            } finally {
                kotlinx.coroutines.TimeSource timeSource2 = TimeSourceKt.getTimeSource();
                if (timeSource2 != null) {
                    timeSource2.unTrackTask();
                }
            }
        }
    }

    public final void parkedWorkersStackTopUpdate$kotlinx_coroutines_core(Worker worker, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int iParkedWorkersStackNextIndex = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (iParkedWorkersStackNextIndex == i) {
                iParkedWorkersStackNextIndex = i2 == 0 ? parkedWorkersStackNextIndex(worker) : i2;
            }
            if (iParkedWorkersStackNextIndex >= 0 && parkedWorkersStack$FU.compareAndSet(this, j, j2 | iParkedWorkersStackNextIndex)) {
                return;
            }
        }
    }

    private final Worker parkedWorkersStackPop() {
        while (true) {
            long j = this.parkedWorkersStack;
            Worker worker = this.workers.get((int) (2097151 & j));
            if (worker == null) {
                return null;
            }
            long j2 = (2097152 + j) & (-2097152);
            int iParkedWorkersStackNextIndex = parkedWorkersStackNextIndex(worker);
            if (iParkedWorkersStackNextIndex >= 0 && parkedWorkersStack$FU.compareAndSet(this, j, iParkedWorkersStackNextIndex | j2)) {
                worker.setNextParkedWorker(NOT_IN_STACK);
                return worker;
            }
        }
    }
}
