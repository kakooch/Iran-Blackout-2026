package ir.eitaa.messenger;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public class DispatchQueue extends Thread {
    private static int indexPointer;
    public volatile Handler handler;
    public final int index;
    private long lastTaskTime;
    private CountDownLatch syncLatch;

    public void handleMessage(Message inputMessage) {
    }

    public DispatchQueue(final String threadName) {
        this(threadName, true);
    }

    public DispatchQueue(final String threadName, boolean start) {
        this.handler = null;
        this.syncLatch = new CountDownLatch(1);
        int i = indexPointer;
        indexPointer = i + 1;
        this.index = i;
        setName(threadName);
        if (start) {
            start();
        }
    }

    public void sendMessage(Message msg, int delay) throws InterruptedException {
        try {
            this.syncLatch.await();
            if (delay <= 0) {
                this.handler.sendMessage(msg);
            } else {
                this.handler.sendMessageDelayed(msg, delay);
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

    public void cancelRunnables(Runnable[] runnables) throws InterruptedException {
        try {
            this.syncLatch.await();
            for (Runnable runnable : runnables) {
                this.handler.removeCallbacks(runnable);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public boolean postRunnable(Runnable runnable) {
        this.lastTaskTime = SystemClock.elapsedRealtime();
        return postRunnable(runnable, 0L);
    }

    public boolean postRunnable(Runnable runnable, long delay) throws InterruptedException {
        try {
            this.syncLatch.await();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (delay <= 0) {
            return this.handler.post(runnable);
        }
        return this.handler.postDelayed(runnable, delay);
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
        this.handler = new Handler() { // from class: ir.eitaa.messenger.DispatchQueue.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                DispatchQueue.this.handleMessage(msg);
            }
        };
        this.syncLatch.countDown();
        Looper.loop();
    }
}
