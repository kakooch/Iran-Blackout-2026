package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes7.dex */
public class HU1 extends Thread {
    private static int f;
    private volatile Handler a;
    private CountDownLatch b;
    private long c;
    public final int d;
    private int e;

    public HU1(String str) {
        this(str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean h(Message message) {
        f(message);
        return true;
    }

    public void b(Runnable runnable) throws InterruptedException {
        try {
            this.b.await();
            this.a.removeCallbacks(runnable);
        } catch (Exception e) {
            AbstractC6403Nl2.e(e, false);
        }
    }

    public void c() throws InterruptedException {
        try {
            this.b.await();
            this.a.removeCallbacksAndMessages(null);
        } catch (Exception e) {
            AbstractC6403Nl2.e(e, false);
        }
    }

    public Handler d() {
        return this.a;
    }

    public long e() {
        return this.c;
    }

    public boolean g() {
        return this.b.getCount() == 0;
    }

    public boolean i(Runnable runnable) {
        this.c = SystemClock.elapsedRealtime();
        return j(runnable, 0L);
    }

    public boolean j(Runnable runnable, long j) throws InterruptedException {
        try {
            this.b.await();
        } catch (Exception e) {
            AbstractC6403Nl2.e(e, false);
        }
        return j <= 0 ? this.a.post(runnable) : this.a.postDelayed(runnable, j);
    }

    public void k() {
        this.a.getLooper().quit();
    }

    public void l(Message message, int i) {
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

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.a = new Handler(Looper.myLooper(), new Handler.Callback() { // from class: ir.nasim.FU1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.h(message);
            }
        });
        this.b.countDown();
        int i = this.e;
        if (i != -1000) {
            Process.setThreadPriority(i);
        }
        Looper.loop();
    }

    public HU1(String str, boolean z) {
        this.a = null;
        this.b = new CountDownLatch(1);
        int i = f;
        f = i + 1;
        this.d = i;
        this.e = -1000;
        setName(str);
        if (z) {
            start();
        }
    }

    public HU1(String str, boolean z, int i) {
        this.a = null;
        this.b = new CountDownLatch(1);
        int i2 = f;
        f = i2 + 1;
        this.d = i2;
        this.e = i;
        setName(str);
        if (z) {
            start();
        }
    }

    public void f(Message message) {
    }
}
