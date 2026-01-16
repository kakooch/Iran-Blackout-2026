package ir.nasim;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.stats.zzi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ir.nasim.x18, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C23502x18 {
    private static final long r = TimeUnit.DAYS.toMillis(366);
    private static volatile ScheduledExecutorService s = null;
    private static final Object t = new Object();
    private static volatile Nl8 u = new C16708lj8();
    private final Object a;
    private final PowerManager.WakeLock b;
    private int c;
    private Future d;
    private long e;
    private final Set f;
    private boolean g;
    private int h;
    C14936ij8 i;
    private OV0 j;
    private WorkSource k;
    private final String l;
    private final String m;
    private final Context n;
    private final Map o;
    private AtomicInteger p;
    private final ScheduledExecutorService q;

    public C23502x18(Context context, int i, String str) {
        String packageName = context.getPackageName();
        this.a = new Object();
        this.c = 0;
        this.f = new HashSet();
        this.g = true;
        this.j = BD1.a();
        this.o = new HashMap();
        this.p = new AtomicInteger(0);
        AbstractC3795Cj5.k(context, "WakeLock: context must not be null");
        AbstractC3795Cj5.g(str, "WakeLock: wakeLockName must not be empty");
        this.n = context.getApplicationContext();
        this.m = str;
        this.i = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.l = str;
        } else {
            String strValueOf = String.valueOf(str);
            this.l = strValueOf.length() != 0 ? "*gcore*:".concat(strValueOf) : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new zzi(sb.toString());
        }
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(i, str);
        this.b = wakeLockNewWakeLock;
        if (AbstractC17219mb8.c(context)) {
            WorkSource workSourceB = AbstractC17219mb8.b(context, AbstractC13016fZ6.a(packageName) ? context.getPackageName() : packageName);
            this.k = workSourceB;
            if (workSourceB != null) {
                i(wakeLockNewWakeLock, workSourceB);
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = s;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (t) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = s;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        Jo8.a();
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        s = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.q = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public static /* synthetic */ void e(C23502x18 c23502x18) {
        synchronized (c23502x18.a) {
            try {
                if (c23502x18.b()) {
                    Log.e("WakeLock", String.valueOf(c23502x18.l).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                    c23502x18.g();
                    if (c23502x18.b()) {
                        c23502x18.c = 1;
                        c23502x18.h(0);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final String f(String str) {
        if (this.g) {
            TextUtils.isEmpty(null);
        }
        return null;
    }

    private final void g() {
        if (this.f.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f);
        this.f.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        AbstractC18350oW3.a(arrayList.get(0));
        throw null;
    }

    private final void h(int i) {
        synchronized (this.a) {
            try {
                if (b()) {
                    if (this.g) {
                        int i2 = this.c - 1;
                        this.c = i2;
                        if (i2 > 0) {
                            return;
                        }
                    } else {
                        this.c = 0;
                    }
                    g();
                    Iterator it = this.o.values().iterator();
                    while (it.hasNext()) {
                        ((Mk8) it.next()).a = 0;
                    }
                    this.o.clear();
                    Future future = this.d;
                    if (future != null) {
                        future.cancel(false);
                        this.d = null;
                        this.e = 0L;
                    }
                    this.h = 0;
                    if (this.b.isHeld()) {
                        try {
                            try {
                                this.b.release();
                                if (this.i != null) {
                                    this.i = null;
                                }
                            } catch (RuntimeException e) {
                                if (!e.getClass().equals(RuntimeException.class)) {
                                    throw e;
                                }
                                Log.e("WakeLock", String.valueOf(this.l).concat(" failed to release!"), e);
                                if (this.i != null) {
                                    this.i = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.i != null) {
                                this.i = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.l).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void i(PowerManager.WakeLock wakeLock, WorkSource workSource) {
        try {
            wakeLock.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            Log.wtf("WakeLock", e.toString());
        }
    }

    public void a(long j) {
        this.p.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, r), 1L);
        if (j > 0) {
            jMax = Math.min(j, jMax);
        }
        synchronized (this.a) {
            try {
                if (!b()) {
                    this.i = C14936ij8.a(false, null);
                    this.b.acquire();
                    this.j.elapsedRealtime();
                }
                this.c++;
                this.h++;
                f(null);
                Mk8 mk8 = (Mk8) this.o.get(null);
                if (mk8 == null) {
                    mk8 = new Mk8(null);
                    this.o.put(null, mk8);
                }
                mk8.a++;
                long jElapsedRealtime = this.j.elapsedRealtime();
                long j2 = Long.MAX_VALUE - jElapsedRealtime > jMax ? jElapsedRealtime + jMax : Long.MAX_VALUE;
                if (j2 > this.e) {
                    this.e = j2;
                    Future future = this.d;
                    if (future != null) {
                        future.cancel(false);
                    }
                    this.d = this.q.schedule(new Runnable() { // from class: ir.nasim.Sg8
                        @Override // java.lang.Runnable
                        public final void run() {
                            C23502x18.e(this.a);
                        }
                    }, jMax, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this.a) {
            z = this.c > 0;
        }
        return z;
    }

    public void c() {
        if (this.p.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.l).concat(" release without a matched acquire!"));
        }
        synchronized (this.a) {
            try {
                f(null);
                if (this.o.containsKey(null)) {
                    Mk8 mk8 = (Mk8) this.o.get(null);
                    if (mk8 != null) {
                        int i = mk8.a - 1;
                        mk8.a = i;
                        if (i == 0) {
                            this.o.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.l).concat(" counter does not exist"));
                }
                h(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(boolean z) {
        synchronized (this.a) {
            this.g = z;
        }
    }
}
