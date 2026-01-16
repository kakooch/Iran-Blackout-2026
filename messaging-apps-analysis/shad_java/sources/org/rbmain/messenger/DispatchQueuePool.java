package org.rbmain.messenger;

import android.os.SystemClock;
import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class DispatchQueuePool {
    private boolean cleanupScheduled;
    private int createdCount;
    private int maxCount;
    private int totalTasksCount;
    private LinkedList<DispatchQueue> queues = new LinkedList<>();
    private HashMap<DispatchQueue, Integer> busyQueuesMap = new HashMap<>();
    private LinkedList<DispatchQueue> busyQueues = new LinkedList<>();
    private Runnable cleanupRunnable = new Runnable() { // from class: org.rbmain.messenger.DispatchQueuePool.1
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

    public DispatchQueuePool(int i) {
        this.maxCount = i;
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
        Integer num = this.busyQueuesMap.get(dispatchQueueRemove);
        if (num == null) {
            num = 0;
        }
        this.busyQueuesMap.put(dispatchQueueRemove, Integer.valueOf(num.intValue() + 1));
        dispatchQueueRemove.postRunnable(new Runnable() { // from class: org.rbmain.messenger.DispatchQueuePool$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$execute$1(runnable, dispatchQueueRemove);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$1(Runnable runnable, final DispatchQueue dispatchQueue) {
        runnable.run();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.DispatchQueuePool$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$execute$0(dispatchQueue);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0(DispatchQueue dispatchQueue) {
        this.totalTasksCount--;
        int iIntValue = this.busyQueuesMap.get(dispatchQueue).intValue() - 1;
        if (iIntValue == 0) {
            this.busyQueuesMap.remove(dispatchQueue);
            this.busyQueues.remove(dispatchQueue);
            this.queues.add(dispatchQueue);
            return;
        }
        this.busyQueuesMap.put(dispatchQueue, Integer.valueOf(iIntValue));
    }
}
