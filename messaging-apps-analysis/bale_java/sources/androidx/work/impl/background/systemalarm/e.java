package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import ir.nasim.AbstractC24092y18;
import ir.nasim.C13231fs5;
import ir.nasim.C21403tb8;
import ir.nasim.ExecutorC18549oq6;
import ir.nasim.HI3;
import ir.nasim.InterfaceC5684Kj7;
import ir.nasim.InterfaceC9244Zc2;
import ir.nasim.Za8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class e implements InterfaceC9244Zc2 {
    static final String k = HI3.f("SystemAlarmDispatcher");
    final Context a;
    private final InterfaceC5684Kj7 b;
    private final C21403tb8 c;
    private final C13231fs5 d;
    private final Za8 e;
    final androidx.work.impl.background.systemalarm.b f;
    private final Handler g;
    final List h;
    Intent i;
    private c j;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            d dVar;
            synchronized (e.this.h) {
                e eVar2 = e.this;
                eVar2.i = (Intent) eVar2.h.get(0);
            }
            Intent intent = e.this.i;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = e.this.i.getIntExtra("KEY_START_ID", 0);
                HI3 hi3C = HI3.c();
                String str = e.k;
                hi3C.a(str, String.format("Processing command %s, %s", e.this.i, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock wakeLockB = AbstractC24092y18.b(e.this.a, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    HI3.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                    wakeLockB.acquire();
                    e eVar3 = e.this;
                    eVar3.f.o(eVar3.i, intExtra, eVar3);
                    HI3.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                    wakeLockB.release();
                    eVar = e.this;
                    dVar = new d(eVar);
                } catch (Throwable th) {
                    try {
                        HI3 hi3C2 = HI3.c();
                        String str2 = e.k;
                        hi3C2.b(str2, "Unexpected error in onHandleIntent", th);
                        HI3.c().a(str2, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                        wakeLockB.release();
                        eVar = e.this;
                        dVar = new d(eVar);
                    } catch (Throwable th2) {
                        HI3.c().a(e.k, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                        wakeLockB.release();
                        e eVar4 = e.this;
                        eVar4.k(new d(eVar4));
                        throw th2;
                    }
                }
                eVar.k(dVar);
            }
        }
    }

    static class b implements Runnable {
        private final e a;
        private final Intent b;
        private final int c;

        b(e eVar, Intent intent, int i) {
            this.a = eVar;
            this.b = intent;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.c);
        }
    }

    interface c {
        void b();
    }

    static class d implements Runnable {
        private final e a;

        d(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.c();
        }
    }

    e(Context context) {
        this(context, null, null);
    }

    private void b() {
        if (this.g.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    private boolean i(String str) {
        b();
        synchronized (this.h) {
            try {
                Iterator it = this.h.iterator();
                while (it.hasNext()) {
                    if (str.equals(((Intent) it.next()).getAction())) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void l() {
        b();
        PowerManager.WakeLock wakeLockB = AbstractC24092y18.b(this.a, "ProcessCommand");
        try {
            wakeLockB.acquire();
            this.e.p().b(new a());
        } finally {
            wakeLockB.release();
        }
    }

    public boolean a(Intent intent, int i) {
        HI3 hi3C = HI3.c();
        String str = k;
        hi3C.a(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i)), new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            HI3.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra("KEY_START_ID", i);
        synchronized (this.h) {
            try {
                boolean z = !this.h.isEmpty();
                this.h.add(intent);
                if (!z) {
                    l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    void c() {
        HI3 hi3C = HI3.c();
        String str = k;
        hi3C.a(str, "Checking if commands are complete.", new Throwable[0]);
        b();
        synchronized (this.h) {
            try {
                if (this.i != null) {
                    HI3.c().a(str, String.format("Removing command %s", this.i), new Throwable[0]);
                    if (!((Intent) this.h.remove(0)).equals(this.i)) {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                    this.i = null;
                }
                ExecutorC18549oq6 executorC18549oq6C = this.b.c();
                if (!this.f.n() && this.h.isEmpty() && !executorC18549oq6C.a()) {
                    HI3.c().a(str, "No more commands & intents.", new Throwable[0]);
                    c cVar = this.j;
                    if (cVar != null) {
                        cVar.b();
                    }
                } else if (!this.h.isEmpty()) {
                    l();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC9244Zc2
    public void d(String str, boolean z) {
        k(new b(this, androidx.work.impl.background.systemalarm.b.c(this.a, str, z), 0));
    }

    C13231fs5 e() {
        return this.d;
    }

    InterfaceC5684Kj7 f() {
        return this.b;
    }

    Za8 g() {
        return this.e;
    }

    C21403tb8 h() {
        return this.c;
    }

    void j() {
        HI3.c().a(k, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.d.i(this);
        this.c.a();
        this.j = null;
    }

    void k(Runnable runnable) {
        this.g.post(runnable);
    }

    void m(c cVar) {
        if (this.j != null) {
            HI3.c().b(k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.j = cVar;
        }
    }

    e(Context context, C13231fs5 c13231fs5, Za8 za8) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f = new androidx.work.impl.background.systemalarm.b(applicationContext);
        this.c = new C21403tb8();
        za8 = za8 == null ? Za8.k(context) : za8;
        this.e = za8;
        c13231fs5 = c13231fs5 == null ? za8.m() : c13231fs5;
        this.d = c13231fs5;
        this.b = za8.p();
        c13231fs5.c(this);
        this.h = new ArrayList();
        this.i = null;
        this.g = new Handler(Looper.getMainLooper());
    }
}
