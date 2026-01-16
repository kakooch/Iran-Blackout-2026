package android.gov.nist.javax.sip.stack.timers;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SipStackImpl;
import android.gov.nist.javax.sip.stack.SIPStackTimerTask;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class AffinitityExecutorSipTimer implements SipTimer {
    private static StackLogger logger = CommonLogger.getLogger(AffinitityExecutorSipTimer.class);
    protected SipStackImpl sipStackImpl;
    ScheduledExecutorService threadPoolExecutor;

    private class ScheduledSipTimerTask implements Runnable {
        private SIPStackTimerTask task;

        public ScheduledSipTimerTask(SIPStackTimerTask sIPStackTimerTask) {
            this.task = sIPStackTimerTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SIPStackTimerTask sIPStackTimerTask = this.task;
                if (sIPStackTimerTask != null) {
                    sIPStackTimerTask.runTask();
                }
            } catch (Throwable th) {
                System.out.println("SIP stack timer task failed due to exception:");
                th.printStackTrace();
            }
        }
    }

    @Override // android.gov.nist.javax.sip.stack.timers.SipTimer
    public boolean cancel(SIPStackTimerTask sIPStackTimerTask) {
        ScheduledFuture scheduledFuture = (ScheduledFuture) sIPStackTimerTask.getSipTimerTask();
        if (scheduledFuture == null) {
            return false;
        }
        sIPStackTimerTask.cleanUpBeforeCancel();
        sIPStackTimerTask.setSipTimerTask(null);
        return scheduledFuture.cancel(false);
    }

    @Override // android.gov.nist.javax.sip.stack.timers.SipTimer
    public boolean isStarted() {
        return !this.threadPoolExecutor.isShutdown();
    }

    @Override // android.gov.nist.javax.sip.stack.timers.SipTimer
    public boolean schedule(SIPStackTimerTask sIPStackTimerTask, long j) {
        if (this.threadPoolExecutor.isShutdown()) {
            throw new IllegalStateException("The SIP Stack Timer has been stopped, no new tasks can be scheduled !");
        }
        sIPStackTimerTask.setSipTimerTask(this.threadPoolExecutor.schedule(new ScheduledSipTimerTask(sIPStackTimerTask), j, TimeUnit.MILLISECONDS));
        return true;
    }

    @Override // android.gov.nist.javax.sip.stack.timers.SipTimer
    public boolean scheduleWithFixedDelay(SIPStackTimerTask sIPStackTimerTask, long j, long j2) {
        if (this.threadPoolExecutor.isShutdown()) {
            throw new IllegalStateException("The SIP Stack Timer has been stopped, no new tasks can be scheduled !");
        }
        sIPStackTimerTask.setSipTimerTask(this.threadPoolExecutor.scheduleWithFixedDelay(new ScheduledSipTimerTask(sIPStackTimerTask), j, j2, TimeUnit.MILLISECONDS));
        return true;
    }

    @Override // android.gov.nist.javax.sip.stack.timers.SipTimer
    public void start(SipStackImpl sipStackImpl, Properties properties) {
        this.sipStackImpl = sipStackImpl;
        this.threadPoolExecutor = sipStackImpl.getSelfRoutingThreadpoolExecutor();
        if (logger.isLoggingEnabled(16)) {
            logger.logInfo("the sip stack timer " + getClass().getName() + " has been started");
        }
    }

    @Override // android.gov.nist.javax.sip.stack.timers.SipTimer
    public void stop() {
        this.threadPoolExecutor.shutdown();
        logger.logStackTrace(32);
        if (logger.isLoggingEnabled(16)) {
            logger.logInfo("the sip stack timer " + getClass().getName() + " has been stopped");
        }
    }
}
