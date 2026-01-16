package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.ads.interactivemedia.v3.internal.acw;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class acv<T extends acw> extends Handler implements Runnable {
    public final int a;
    final /* synthetic */ ada b;
    private final T c;
    private final long d;
    private act<T> e;
    private IOException f;
    private int g;
    private Thread h;
    private boolean i;
    private volatile boolean j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public acv(ada adaVar, Looper looper, T t, act<T> actVar, int i, long j) {
        super(looper);
        this.b = adaVar;
        this.c = t;
        this.e = actVar;
        this.a = i;
        this.d = j;
    }

    private final void d() {
        this.f = null;
        ExecutorService executorService = this.b.c;
        acv acvVar = this.b.d;
        ary.t(acvVar);
        executorService.execute(acvVar);
    }

    private final void e() {
        this.b.d = null;
    }

    public final void a(int i) throws IOException {
        IOException iOException = this.f;
        if (iOException != null && this.g > i) {
            throw iOException;
        }
    }

    public final void b(long j) {
        ary.q(this.b.d == null);
        this.b.d = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            d();
        }
    }

    public final void c(boolean z) {
        this.j = z;
        this.f = null;
        if (hasMessages(0)) {
            this.i = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.i = true;
                this.c.b();
                Thread thread = this.h;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            e();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            act<T> actVar = this.e;
            ary.t(actVar);
            actVar.w(this.c, jElapsedRealtime, jElapsedRealtime - this.d, true);
            this.e = null;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.j) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            d();
            return;
        }
        if (i == 3) {
            throw ((Error) message.obj);
        }
        e();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.d;
        act<T> actVar = this.e;
        ary.t(actVar);
        if (this.i) {
            actVar.w(this.c, jElapsedRealtime, j, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            try {
                actVar.x(this.c, jElapsedRealtime, j);
                return;
            } catch (RuntimeException e) {
                adu.b("LoadTask", "Unexpected exception handling load completed", e);
                this.b.e = new acz(e);
                return;
            }
        }
        if (i2 != 2) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.f = iOException;
        int i3 = this.g + 1;
        this.g = i3;
        acu acuVarV = actVar.v(this.c, jElapsedRealtime, j, iOException, i3);
        if (acuVarV.a == 3) {
            this.b.e = this.f;
        } else if (acuVarV.a != 2) {
            if (acuVarV.a == 1) {
                this.g = 1;
            }
            b(acuVarV.b != -9223372036854775807L ? acuVarV.b : Math.min((this.g - 1) * CloseCodes.NORMAL_CLOSURE, 5000));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = !this.i;
                this.h = Thread.currentThread();
            }
            if (z) {
                String simpleName = this.c.getClass().getSimpleName();
                atv.k(simpleName.length() != 0 ? "load:".concat(simpleName) : new String("load:"));
                try {
                    this.c.c();
                    atv.l();
                } catch (Throwable th) {
                    atv.l();
                    throw th;
                }
            }
            synchronized (this) {
                this.h = null;
                Thread.interrupted();
            }
            if (this.j) {
                return;
            }
            sendEmptyMessage(1);
        } catch (IOException e) {
            if (this.j) {
                return;
            }
            obtainMessage(2, e).sendToTarget();
        } catch (Error e2) {
            adu.b("LoadTask", "Unexpected error loading stream", e2);
            if (!this.j) {
                obtainMessage(3, e2).sendToTarget();
            }
            throw e2;
        } catch (Exception e3) {
            adu.b("LoadTask", "Unexpected exception loading stream", e3);
            if (this.j) {
                return;
            }
            obtainMessage(2, new acz(e3)).sendToTarget();
        } catch (OutOfMemoryError e4) {
            adu.b("LoadTask", "OutOfMemory error loading stream", e4);
            if (this.j) {
                return;
            }
            obtainMessage(2, new acz(e4)).sendToTarget();
        }
    }
}
