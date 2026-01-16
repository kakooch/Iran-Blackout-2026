package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes5.dex */
public class NZ extends Thread {
    private static int e;
    private volatile Handler a;
    private CountDownLatch b;
    private long c;
    private int d;
    public final int index;

    public NZ(String str) {
        this(str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean b(Message message) {
        handleMessage(message);
        return true;
    }

    public void cancelRunnable(Runnable runnable) throws InterruptedException {
        try {
            this.b.await();
            this.a.removeCallbacks(runnable);
        } catch (Exception e2) {
            C19406qI3.d("baleMessenger", e2);
        }
    }

    public void cancelRunnables(Runnable[] runnableArr) throws InterruptedException {
        try {
            this.b.await();
            for (Runnable runnable : runnableArr) {
                this.a.removeCallbacks(runnable);
            }
        } catch (Exception e2) {
            C19406qI3.d("baleMessenger", e2);
        }
    }

    public void cleanupQueue() throws InterruptedException {
        try {
            this.b.await();
            this.a.removeCallbacksAndMessages(null);
        } catch (Exception e2) {
            C19406qI3.d("baleMessenger", e2);
        }
    }

    public Handler getHandler() {
        return this.a;
    }

    public long getLastTaskTime() {
        return this.c;
    }

    public boolean isReady() {
        return this.b.getCount() == 0;
    }

    public boolean postRunnable(Runnable runnable) {
        this.c = SystemClock.elapsedRealtime();
        return postRunnable(runnable, 0L);
    }

    public void recycle() {
        this.a.getLooper().quit();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws SecurityException, IllegalArgumentException {
        Looper.prepare();
        this.a = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: ir.nasim.MZ
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.b(message);
            }
        });
        this.b.countDown();
        int i = this.d;
        if (i != -1000) {
            Process.setThreadPriority(i);
        }
        Looper.loop();
    }

    public void sendMessage(Message message, int i) throws InterruptedException {
        try {
            this.b.await();
            if (i <= 0) {
                this.a.sendMessage(message);
            } else {
                this.a.sendMessageDelayed(message, i);
            }
        } catch (Exception unused) {
        }
    }

    public NZ(String str, boolean z) {
        this.a = null;
        this.b = new CountDownLatch(1);
        int i = e;
        e = i + 1;
        this.index = i;
        this.d = -1000;
        setName(str);
        if (z) {
            start();
        }
    }

    public boolean postRunnable(Runnable runnable, long j) throws InterruptedException {
        try {
            this.b.await();
        } catch (Exception e2) {
            C19406qI3.d("baleMessenger", e2);
        }
        if (j <= 0) {
            return this.a.post(runnable);
        }
        return this.a.postDelayed(runnable, j);
    }

    public void handleMessage(Message message) {
    }
}
