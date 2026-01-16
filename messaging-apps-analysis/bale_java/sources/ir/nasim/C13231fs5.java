package ir.nasim;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import ir.nasim.RunnableC23246wb8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* renamed from: ir.nasim.fs5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13231fs5 implements InterfaceC9244Zc2, InterfaceC13849gv2 {
    private static final String l = HI3.f("Processor");
    private Context b;
    private androidx.work.a c;
    private InterfaceC5684Kj7 d;
    private WorkDatabase e;
    private List h;
    private Map g = new HashMap();
    private Map f = new HashMap();
    private Set i = new HashSet();
    private final List j = new ArrayList();
    private PowerManager.WakeLock a = null;
    private final Object k = new Object();

    /* renamed from: ir.nasim.fs5$a */
    private static class a implements Runnable {
        private InterfaceC9244Zc2 a;
        private String b;
        private InterfaceFutureC15215jC3 c;

        a(InterfaceC9244Zc2 interfaceC9244Zc2, String str, InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
            this.a = interfaceC9244Zc2;
            this.b = str;
            this.c = interfaceFutureC15215jC3;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zBooleanValue;
            try {
                zBooleanValue = ((Boolean) this.c.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                zBooleanValue = true;
            }
            this.a.d(this.b, zBooleanValue);
        }
    }

    public C13231fs5(Context context, androidx.work.a aVar, InterfaceC5684Kj7 interfaceC5684Kj7, WorkDatabase workDatabase, List list) {
        this.b = context;
        this.c = aVar;
        this.d = interfaceC5684Kj7;
        this.e = workDatabase;
        this.h = list;
    }

    private static boolean e(String str, RunnableC23246wb8 runnableC23246wb8) {
        if (runnableC23246wb8 == null) {
            HI3.c().a(l, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
            return false;
        }
        runnableC23246wb8.d();
        HI3.c().a(l, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
        return true;
    }

    private void m() {
        synchronized (this.k) {
            try {
                if (!(!this.f.isEmpty())) {
                    try {
                        this.b.startService(androidx.work.impl.foreground.a.f(this.b));
                    } catch (Throwable th) {
                        HI3.c().b(l, "Unable to stop foreground service", th);
                    }
                    PowerManager.WakeLock wakeLock = this.a;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.a = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // ir.nasim.InterfaceC13849gv2
    public void a(String str, C13258fv2 c13258fv2) {
        synchronized (this.k) {
            try {
                HI3.c().d(l, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
                RunnableC23246wb8 runnableC23246wb8 = (RunnableC23246wb8) this.g.remove(str);
                if (runnableC23246wb8 != null) {
                    if (this.a == null) {
                        PowerManager.WakeLock wakeLockB = AbstractC24092y18.b(this.b, "ProcessorForegroundLck");
                        this.a = wakeLockB;
                        wakeLockB.acquire();
                    }
                    this.f.put(str, runnableC23246wb8);
                    AbstractC4043Dl1.p(this.b, androidx.work.impl.foreground.a.c(this.b, str, c13258fv2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC13849gv2
    public void b(String str) {
        synchronized (this.k) {
            this.f.remove(str);
            m();
        }
    }

    public void c(InterfaceC9244Zc2 interfaceC9244Zc2) {
        synchronized (this.k) {
            this.j.add(interfaceC9244Zc2);
        }
    }

    @Override // ir.nasim.InterfaceC9244Zc2
    public void d(String str, boolean z) {
        synchronized (this.k) {
            try {
                this.g.remove(str);
                HI3.c().a(l, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
                Iterator it = this.j.iterator();
                while (it.hasNext()) {
                    ((InterfaceC9244Zc2) it.next()).d(str, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean f(String str) {
        boolean zContains;
        synchronized (this.k) {
            zContains = this.i.contains(str);
        }
        return zContains;
    }

    public boolean g(String str) {
        boolean z;
        synchronized (this.k) {
            try {
                z = this.g.containsKey(str) || this.f.containsKey(str);
            } finally {
            }
        }
        return z;
    }

    public boolean h(String str) {
        boolean zContainsKey;
        synchronized (this.k) {
            zContainsKey = this.f.containsKey(str);
        }
        return zContainsKey;
    }

    public void i(InterfaceC9244Zc2 interfaceC9244Zc2) {
        synchronized (this.k) {
            this.j.remove(interfaceC9244Zc2);
        }
    }

    public boolean j(String str) {
        return k(str, null);
    }

    public boolean k(String str, WorkerParameters.a aVar) {
        synchronized (this.k) {
            try {
                if (g(str)) {
                    HI3.c().a(l, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                    return false;
                }
                RunnableC23246wb8 runnableC23246wb8A = new RunnableC23246wb8.c(this.b, this.c, this.d, this, this.e, str).c(this.h).b(aVar).a();
                InterfaceFutureC15215jC3 interfaceFutureC15215jC3B = runnableC23246wb8A.b();
                interfaceFutureC15215jC3B.j(new a(this, str, interfaceFutureC15215jC3B), this.d.a());
                this.g.put(str, runnableC23246wb8A);
                this.d.c().execute(runnableC23246wb8A);
                HI3.c().a(l, String.format("%s: processing %s", getClass().getSimpleName(), str), new Throwable[0]);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean l(String str) {
        boolean zE;
        synchronized (this.k) {
            try {
                HI3.c().a(l, String.format("Processor cancelling %s", str), new Throwable[0]);
                this.i.add(str);
                RunnableC23246wb8 runnableC23246wb8 = (RunnableC23246wb8) this.f.remove(str);
                boolean z = runnableC23246wb8 != null;
                if (runnableC23246wb8 == null) {
                    runnableC23246wb8 = (RunnableC23246wb8) this.g.remove(str);
                }
                zE = e(str, runnableC23246wb8);
                if (z) {
                    m();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zE;
    }

    public boolean n(String str) {
        boolean zE;
        synchronized (this.k) {
            HI3.c().a(l, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            zE = e(str, (RunnableC23246wb8) this.f.remove(str));
        }
        return zE;
    }

    public boolean o(String str) {
        boolean zE;
        synchronized (this.k) {
            HI3.c().a(l, String.format("Processor stopping background work %s", str), new Throwable[0]);
            zE = e(str, (RunnableC23246wb8) this.g.remove(str));
        }
        return zE;
    }
}
