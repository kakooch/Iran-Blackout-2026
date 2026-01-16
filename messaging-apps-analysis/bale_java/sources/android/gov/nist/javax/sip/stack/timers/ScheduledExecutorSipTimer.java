package android.gov.nist.javax.sip.stack.timers;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.NamingThreadFactory;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.SipStackImpl;
import android.gov.nist.javax.sip.stack.SIPStackTimerTask;
import java.util.Properties;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class ScheduledExecutorSipTimer implements SipTimer {
    private static StackLogger logger = CommonLogger.getLogger(ScheduledExecutorSipTimer.class);
    protected SipStackImpl sipStackImpl;
    ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamingThreadFactory("jain_sip_timer_executor"));

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

    private void schedulePurgeTaskIfNeeded() throws NumberFormatException {
        int i = Integer.parseInt(this.sipStackImpl.getConfigurationProperties().getProperty("android.gov.nist.javax.sip.timers.SCHEDULED_EXECUTOR_PURGE_DELAY", "1"));
        if (i > 0) {
            long j = i;
            this.threadPoolExecutor.scheduleWithFixedDelay(new Runnable() { // from class: android.gov.nist.javax.sip.stack.timers.ScheduledExecutorSipTimer.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ScheduledExecutorSipTimer.logger.isLoggingEnabled(32)) {
                            ScheduledExecutorSipTimer.logger.logDebug("Purging canceled timer tasks...");
                        }
                        ScheduledExecutorSipTimer.this.threadPoolExecutor.purge();
                        if (ScheduledExecutorSipTimer.logger.isLoggingEnabled(32)) {
                            ScheduledExecutorSipTimer.logger.logDebug("Purging canceled timer tasks completed.");
                        }
                    } catch (Exception e) {
                        ScheduledExecutorSipTimer.logger.logError("failed to execute purge", e);
                    }
                }
            }, j, j, TimeUnit.MINUTES);
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
        this.threadPoolExecutor.remove((Runnable) scheduledFuture);
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
    public void start(SipStackImpl sipStackImpl, Properties properties) throws NumberFormatException {
        this.sipStackImpl = sipStackImpl;
        this.threadPoolExecutor.prestartAllCoreThreads();
        schedulePurgeTaskIfNeeded();
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
