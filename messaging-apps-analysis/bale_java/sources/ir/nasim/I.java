package ir.nasim;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* loaded from: classes2.dex */
public class I extends Thread {
    private static final f l = new a();
    private static final e m = new b();
    private static final g n = new c();
    private f a;
    private e b;
    private g c;
    private final Handler d;
    private final int e;
    private String f;
    private boolean g;
    private boolean h;
    private volatile long i;
    private volatile boolean j;
    private final Runnable k;

    static class b implements e {
        b() {
        }

        @Override // ir.nasim.I.e
        public long a(long j) {
            return 0L;
        }
    }

    static class c implements g {
        c() {
        }

        @Override // ir.nasim.I.g
        public void a(InterruptedException interruptedException) {
            Log.w("ANRWatchdog", "Interrupted: " + interruptedException.getMessage());
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            I.this.i = 0L;
            I.this.j = false;
        }
    }

    public interface e {
        long a(long j);
    }

    public interface f {
        void a(H h);
    }

    public interface g {
        void a(InterruptedException interruptedException);
    }

    public I() {
        this(5000);
    }

    public I c(f fVar) {
        if (fVar == null) {
            this.a = l;
        } else {
            this.a = fVar;
        }
        return this;
    }

    public I d(boolean z) {
        this.h = z;
        return this;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws InterruptedException {
        setName("|ANR-WatchDog|");
        long jA = this.e;
        while (!isInterrupted()) {
            boolean z = this.i == 0;
            this.i += jA;
            if (z) {
                this.d.post(this.k);
            }
            try {
                Thread.sleep(jA);
                if (this.i != 0 && !this.j) {
                    if (this.h || !(Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        jA = this.b.a(this.i);
                        if (jA <= 0) {
                            this.a.a(this.f != null ? H.a(this.i, this.f, this.g) : H.b(this.i));
                            jA = this.e;
                            this.j = true;
                        }
                    } else {
                        Log.w("ANRWatchdog", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        this.j = true;
                    }
                }
            } catch (InterruptedException e2) {
                this.c.a(e2);
                return;
            }
        }
    }

    public I(int i) {
        this.a = l;
        this.b = m;
        this.c = n;
        this.d = new Handler(Looper.getMainLooper());
        this.f = "";
        this.g = false;
        this.h = false;
        this.i = 0L;
        this.j = false;
        this.k = new d();
        this.e = i;
    }

    static class a implements f {
        a() {
        }

        @Override // ir.nasim.I.f
        public void a(H h) {
            throw h;
        }
    }
}
