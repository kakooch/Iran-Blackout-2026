package ir.eitaa.messenger;

import android.os.SystemClock;
import android.util.SparseIntArray;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class DispatchQueuePool {
    private boolean cleanupScheduled;
    private int createdCount;
    private int maxCount;
    private int totalTasksCount;
    private LinkedList<DispatchQueue> queues = new LinkedList<>();
    private SparseIntArray busyQueuesMap = new SparseIntArray();
    private LinkedList<DispatchQueue> busyQueues = new LinkedList<>();
    private Runnable cleanupRunnable = new Runnable() { // from class: ir.eitaa.messenger.DispatchQueuePool.1
        @Override // java.lang.Runnable
        public void run() {
            if (!DispatchQueuePool.this.queues.isEmpty()) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int size = DispatchQueuePool.this.queues.size();
                int i = 0;
                while (i < size) {
                    DispatchQueue dispatchQueue = (DispatchQueue) DispatchQueuePool.this.queues.get(i);
                    if (dispatchQueue.getLastTaskTime() < jElapsedRealtime - 30000) {
                        dispatchQueue.recycle();
                        DispatchQueuePool.this.queues.remove(i);
                        DispatchQueuePool.access$110(DispatchQueuePool.this);
                        i--;
                        size--;
                    }
                    i++;
                }
            }
            if (DispatchQueuePool.this.queues.isEmpty() && DispatchQueuePool.this.busyQueues.isEmpty()) {
                DispatchQueuePool.this.cleanupScheduled = false;
            } else {
                AndroidUtilities.runOnUIThread(this, 30000L);
                DispatchQueuePool.this.cleanupScheduled = true;
            }
        }
    };
    private int guid = Utilities.random.nextInt();

    static /* synthetic */ int access$110(DispatchQueuePool dispatchQueuePool) {
        int i = dispatchQueuePool.createdCount;
        dispatchQueuePool.createdCount = i - 1;
        return i;
    }

    public DispatchQueuePool(int count) {
        this.maxCount = count;
    }

    public void execute(final Runnable runnable) {
        final DispatchQueue dispatchQueueRemove;
        if (!this.busyQueues.isEmpty() && (this.totalTasksCount / 2 <= this.busyQueues.size() || (this.queues.isEmpty() && this.createdCount >= this.maxCount))) {
            dispatchQueueRemove = this.busyQueues.remove(0);
        } else if (this.queues.isEmpty()) {
            dispatchQueueRemove = new DispatchQueue("DispatchQueuePool" + this.guid + "_" + Utilities.random.nextInt());
            dispatchQueueRemove.setPriority(10);
            this.createdCount = this.createdCount + 1;
        } else {
            dispatchQueueRemove = this.queues.remove(0);
        }
        if (!this.cleanupScheduled) {
            AndroidUtilities.runOnUIThread(this.cleanupRunnable, 30000L);
            this.cleanupScheduled = true;
        }
        this.totalTasksCount++;
        this.busyQueues.add(dispatchQueueRemove);
        this.busyQueuesMap.put(dispatchQueueRemove.index, this.busyQueuesMap.get(dispatchQueueRemove.index, 0) + 1);
        dispatchQueueRemove.postRunnable(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$DispatchQueuePool$SAEwUHo2Dz3tu4jcAbElZff36rQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$execute$1$DispatchQueuePool(runnable, dispatchQueueRemove);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$execute$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$execute$1$DispatchQueuePool(Runnable runnable, final DispatchQueue dispatchQueue) {
        runnable.run();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$DispatchQueuePool$N7TpxOS4P9bAPgCqyq8zaVq8q0A
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$execute$0$DispatchQueuePool(dispatchQueue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$execute$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$execute$0$DispatchQueuePool(DispatchQueue dispatchQueue) {
        this.totalTasksCount--;
        int i = this.busyQueuesMap.get(dispatchQueue.index) - 1;
        if (i == 0) {
            this.busyQueuesMap.delete(dispatchQueue.index);
            this.busyQueues.remove(dispatchQueue);
            this.queues.add(dispatchQueue);
            return;
        }
        this.busyQueuesMap.put(dispatchQueue.index, i);
    }
}
