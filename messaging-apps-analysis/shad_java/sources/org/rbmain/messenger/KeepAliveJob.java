package org.rbmain.messenger;

import android.content.Intent;
import com.facebook.stetho.websocket.CloseCodes;
import java.util.concurrent.CountDownLatch;
import org.rbmain.messenger.support.JobIntentService;

/* loaded from: classes4.dex */
public class KeepAliveJob extends JobIntentService {
    private static volatile CountDownLatch countDownLatch;
    private static volatile boolean startingJob;
    private static final Object sync = new Object();
    private static Runnable finishJobByTimeoutRunnable = new Runnable() { // from class: org.rbmain.messenger.KeepAliveJob.3
        @Override // java.lang.Runnable
        public void run() {
            KeepAliveJob.finishJobInternal();
        }
    };

    public static void startJob() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.KeepAliveJob.1
            @Override // java.lang.Runnable
            public void run() {
                if (KeepAliveJob.startingJob || KeepAliveJob.countDownLatch != null) {
                    return;
                }
                try {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("starting keep-alive job");
                    }
                    synchronized (KeepAliveJob.sync) {
                        boolean unused = KeepAliveJob.startingJob = true;
                    }
                    JobIntentService.enqueueWork(ApplicationLoader.applicationContext, KeepAliveJob.class, CloseCodes.NORMAL_CLOSURE, new Intent());
                } catch (Exception unused2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void finishJobInternal() {
        synchronized (sync) {
            if (countDownLatch != null) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("finish keep-alive job");
                }
                countDownLatch.countDown();
            }
            if (startingJob) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("finish queued keep-alive job");
                }
                startingJob = false;
            }
        }
    }

    public static void finishJob() {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.messenger.KeepAliveJob.2
            @Override // java.lang.Runnable
            public void run() {
                KeepAliveJob.finishJobInternal();
            }
        });
    }

    @Override // org.rbmain.messenger.support.JobIntentService
    protected void onHandleWork(Intent intent) {
        synchronized (sync) {
            if (startingJob) {
                countDownLatch = new CountDownLatch(1);
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("started keep-alive job");
                }
                Utilities.globalQueue.postRunnable(finishJobByTimeoutRunnable, 60000L);
                try {
                    countDownLatch.await();
                } catch (Throwable unused) {
                }
                Utilities.globalQueue.cancelRunnable(finishJobByTimeoutRunnable);
                synchronized (sync) {
                    countDownLatch = null;
                }
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("ended keep-alive job");
                }
            }
        }
    }
}
