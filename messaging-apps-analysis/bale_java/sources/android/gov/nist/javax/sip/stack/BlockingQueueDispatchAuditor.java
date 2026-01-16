package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class BlockingQueueDispatchAuditor extends TimerTask {
    private static StackLogger logger = CommonLogger.getLogger(BlockingQueueDispatchAuditor.class);
    private static int timerThreadCount;
    private Queue<? extends Runnable> queue;
    private Timer timer = null;
    private long totalReject = 0;
    private boolean started = false;
    private int timeout = 8000;

    public BlockingQueueDispatchAuditor(Queue<? extends Runnable> queue) {
        this.queue = queue;
    }

    public int getTimeout() {
        return this.timeout;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        int i;
        try {
            synchronized (this.queue) {
                try {
                    QueuedMessageDispatchBase queuedMessageDispatchBase = (QueuedMessageDispatchBase) this.queue.peek();
                    i = 0;
                    while (queuedMessageDispatchBase != null) {
                        if (System.currentTimeMillis() - queuedMessageDispatchBase.getReceptionTime() > this.timeout) {
                            this.queue.poll();
                            queuedMessageDispatchBase = (QueuedMessageDispatchBase) this.queue.peek();
                            i++;
                        } else {
                            queuedMessageDispatchBase = null;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (i > 0) {
                this.totalReject += i;
                StackLogger stackLogger = logger;
                if (stackLogger == null || !stackLogger.isLoggingEnabled(8)) {
                    return;
                }
                logger.logWarning("Removed stuck messages=" + i + " total rejected=" + this.totalReject + " stil in queue=" + this.queue.size());
            }
        } catch (Exception e) {
            StackLogger stackLogger2 = logger;
            if (stackLogger2 == null || !stackLogger2.isLoggingEnabled(8)) {
                return;
            }
            logger.logWarning("Problem reaping old requests. This is not a fatal error." + e);
        }
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public void start(int i) {
        if (this.started) {
            stop();
        }
        this.started = true;
        StringBuilder sb = new StringBuilder();
        sb.append("BlockingQueueDispatchAuditor-Timer-");
        int i2 = timerThreadCount;
        timerThreadCount = i2 + 1;
        sb.append(i2);
        Timer timer = new Timer(sb.toString(), true);
        this.timer = timer;
        long j = i;
        timer.scheduleAtFixedRate(this, j, j);
    }

    public void stop() {
        try {
            this.timer.cancel();
            this.timer = null;
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.started = false;
            throw th;
        }
        this.started = false;
    }
}
