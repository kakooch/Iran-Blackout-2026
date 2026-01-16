package ir.appp.rghapp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;
import org.rbmain.messenger.FileLog;

/* loaded from: classes3.dex */
public class DispatchQueue extends Thread {
    private volatile Handler handler;
    private CountDownLatch syncLatch;

    public void handleMessage(Message message) {
    }

    public DispatchQueue(String str) {
        this(str, true);
    }

    public DispatchQueue(String str, boolean z) {
        this.handler = null;
        this.syncLatch = new CountDownLatch(1);
        setName(str);
        if (z) {
            start();
        }
    }

    public boolean postRunnable(Runnable runnable) {
        SystemClock.elapsedRealtime();
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

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.handler = new Handler() { // from class: ir.appp.rghapp.DispatchQueue.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                DispatchQueue.this.handleMessage(message);
            }
        };
        this.syncLatch.countDown();
        Looper.loop();
    }
}
