package org.rbmain.messenger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidMessenger.utilites.MyLog;
import com.google.android.exoplayer2t.util.Log;
import java.lang.Thread;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public class DispatchQueue2 extends Thread {
    private volatile Handler handler;
    private long lastTaskTime;
    private CountDownLatch syncLatch;

    public void handleMessage(Message message) {
    }

    public DispatchQueue2(String str) {
        this(str, true);
    }

    public DispatchQueue2(String str, boolean z) {
        this.handler = null;
        this.syncLatch = new CountDownLatch(1);
        setName(str);
        setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: org.rbmain.messenger.DispatchQueue2$$ExternalSyntheticLambda1
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                DispatchQueue2.lambda$new$0(thread, th);
            }
        });
        if (z) {
            start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(Thread thread, Throwable th) {
        Log.e("THREAD EXCEPTION ", "MESSAAAAAAAAAGGGGGGGGGGEE: \t" + th.getMessage());
        th.printStackTrace();
    }

    public void sendMessage(Message message, int i) throws InterruptedException {
        try {
            this.syncLatch.await();
            if (i <= 0) {
                this.handler.sendMessage(message);
            } else {
                this.handler.sendMessageDelayed(message, i);
            }
        } catch (Exception unused) {
        }
    }

    public void cancelRunnable(Runnable runnable) throws InterruptedException {
        try {
            this.syncLatch.await();
            this.handler.removeCallbacks(runnable);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void cancelRunnables(Runnable[] runnableArr) throws InterruptedException {
        try {
            this.syncLatch.await();
            for (Runnable runnable : runnableArr) {
                this.handler.removeCallbacks(runnable);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public boolean postRunnable(final String str, final Runnable runnable) {
        if (MyLog.isDebugAble) {
            MyLog.e("postRunnable", "postRunnable Start" + str);
            return postRunnable(new Runnable() { // from class: org.rbmain.messenger.DispatchQueue2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DispatchQueue2.lambda$postRunnable$1(runnable, str);
                }
            });
        }
        return postRunnable(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$postRunnable$1(Runnable runnable, String str) {
        try {
            runnable.run();
        } catch (Exception e) {
            MyLog.handleExceptionThrowOnDebug(e);
        }
        MyLog.e("postRunnable", "postRunnable end" + str);
    }

    public boolean postRunnable(Runnable runnable) {
        this.lastTaskTime = SystemClock.elapsedRealtime();
        return postRunnable(runnable, 0L);
    }

    public boolean postRunnable(Runnable runnable, long j) throws InterruptedException {
        try {
            this.syncLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (j <= 0) {
            return this.handler.post(runnable);
        }
        return this.handler.postDelayed(runnable, j);
    }

    public void cleanupQueue() throws InterruptedException {
        try {
            this.syncLatch.await();
            this.handler.removeCallbacksAndMessages(null);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public long getLastTaskTime() {
        return this.lastTaskTime;
    }

    public void recycle() {
        this.handler.getLooper().quit();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.handler = new Handler() { // from class: org.rbmain.messenger.DispatchQueue2.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.syncLatch.countDown();
        Looper.loop();
    }
}
