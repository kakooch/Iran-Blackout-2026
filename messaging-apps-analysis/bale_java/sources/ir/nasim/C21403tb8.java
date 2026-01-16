package ir.nasim;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.tb8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C21403tb8 {
    private static final String f = HI3.f("WorkTimer");
    private final ThreadFactory a;
    private final ScheduledExecutorService b;
    final Map c;
    final Map d;
    final Object e;

    /* renamed from: ir.nasim.tb8$a */
    class a implements ThreadFactory {
        private int a = 0;

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
            threadNewThread.setName("WorkManager-WorkTimer-thread-" + this.a);
            this.a = this.a + 1;
            return threadNewThread;
        }
    }

    /* renamed from: ir.nasim.tb8$b */
    public interface b {
        void a(String str);
    }

    /* renamed from: ir.nasim.tb8$c */
    public static class c implements Runnable {
        private final C21403tb8 a;
        private final String b;

        c(C21403tb8 c21403tb8, String str) {
            this.a = c21403tb8;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.e) {
                try {
                    if (((c) this.a.c.remove(this.b)) != null) {
                        b bVar = (b) this.a.d.remove(this.b);
                        if (bVar != null) {
                            bVar.a(this.b);
                        }
                    } else {
                        HI3.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.b), new Throwable[0]);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public C21403tb8() {
        a aVar = new a();
        this.a = aVar;
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new Object();
        this.b = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    public void a() {
        if (this.b.isShutdown()) {
            return;
        }
        this.b.shutdownNow();
    }

    public void b(String str, long j, b bVar) {
        synchronized (this.e) {
            HI3.c().a(f, String.format("Starting timer for %s", str), new Throwable[0]);
            c(str);
            c cVar = new c(this, str);
            this.c.put(str, cVar);
            this.d.put(str, bVar);
            this.b.schedule(cVar, j, TimeUnit.MILLISECONDS);
        }
    }

    public void c(String str) {
        synchronized (this.e) {
            try {
                if (((c) this.c.remove(str)) != null) {
                    HI3.c().a(f, String.format("Stopping timer for %s", str), new Throwable[0]);
                    this.d.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
