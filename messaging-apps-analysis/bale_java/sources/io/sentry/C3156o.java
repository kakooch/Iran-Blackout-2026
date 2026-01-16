package io.sentry;

import io.sentry.util.C3202a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: io.sentry.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3156o implements InterfaceC3126i {
    private final boolean f;
    private final C3155n3 g;
    private final C3202a a = new C3202a();
    private volatile Timer b = null;
    private final Map c = new ConcurrentHashMap();
    private final AtomicBoolean h = new AtomicBoolean(false);
    private long i = 0;
    private final List d = new ArrayList();
    private final List e = new ArrayList();

    /* renamed from: io.sentry.o$a */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Iterator it = C3156o.this.d.iterator();
            while (it.hasNext()) {
                ((W) it.next()).c();
            }
        }
    }

    /* renamed from: io.sentry.o$b */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - C3156o.this.i <= 10) {
                return;
            }
            C3156o.this.i = jCurrentTimeMillis;
            C3148m1 c3148m1 = new C3148m1(new C3115f3().p());
            Iterator it = C3156o.this.d.iterator();
            while (it.hasNext()) {
                ((W) it.next()).d(c3148m1);
            }
            Iterator it2 = C3156o.this.c.values().iterator();
            while (it2.hasNext()) {
                ((List) it2.next()).add(c3148m1);
            }
        }
    }

    public C3156o(C3155n3 c3155n3) {
        boolean z = false;
        this.g = (C3155n3) io.sentry.util.u.c(c3155n3, "The options object is required.");
        for (U u : c3155n3.getPerformanceCollectors()) {
            if (u instanceof W) {
                this.d.add((W) u);
            }
            if (u instanceof V) {
                this.e.add((V) u);
            }
        }
        if (this.d.isEmpty() && this.e.isEmpty()) {
            z = true;
        }
        this.f = z;
    }

    @Override // io.sentry.InterfaceC3126i
    public void a(InterfaceC3117g0 interfaceC3117g0) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((V) it.next()).a(interfaceC3117g0);
        }
    }

    @Override // io.sentry.InterfaceC3126i
    public void b(InterfaceC3117g0 interfaceC3117g0) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((V) it.next()).b(interfaceC3117g0);
        }
    }

    @Override // io.sentry.InterfaceC3126i
    public List c(String str) {
        List list = (List) this.c.remove(str);
        if (this.c.isEmpty()) {
            close();
        }
        return list;
    }

    @Override // io.sentry.InterfaceC3126i
    public void close() {
        this.g.getLogger().c(Y2.DEBUG, "stop collecting all performance info for transactions", new Object[0]);
        this.c.clear();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((V) it.next()).clear();
        }
        if (this.h.getAndSet(false)) {
            InterfaceC3102d0 interfaceC3102d0A = this.a.a();
            try {
                if (this.b != null) {
                    this.b.cancel();
                    this.b = null;
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } catch (Throwable th) {
                if (interfaceC3102d0A != null) {
                    try {
                        interfaceC3102d0A.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // io.sentry.InterfaceC3126i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public List l(InterfaceC3127i0 interfaceC3127i0) {
        this.g.getLogger().c(Y2.DEBUG, "stop collecting performance info for transactions %s (%s)", interfaceC3127i0.getName(), interfaceC3127i0.v().n().toString());
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((V) it.next()).a(interfaceC3127i0);
        }
        return c(interfaceC3127i0.b().toString());
    }

    @Override // io.sentry.InterfaceC3126i
    public void e(final InterfaceC3127i0 interfaceC3127i0) {
        if (this.f) {
            this.g.getLogger().c(Y2.INFO, "No collector found. Performance stats will not be captured during transactions.", new Object[0]);
            return;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((V) it.next()).b(interfaceC3127i0);
        }
        if (!this.c.containsKey(interfaceC3127i0.b().toString())) {
            this.c.put(interfaceC3127i0.b().toString(), new ArrayList());
            try {
                this.g.getExecutorService().c(new Runnable() { // from class: io.sentry.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.l(interfaceC3127i0);
                    }
                }, 30000L);
            } catch (RejectedExecutionException e) {
                this.g.getLogger().b(Y2.ERROR, "Failed to call the executor. Performance collector will not be automatically finished. Did you call Sentry.close()?", e);
            }
        }
        f(interfaceC3127i0.b().toString());
    }

    @Override // io.sentry.InterfaceC3126i
    public void f(String str) {
        if (this.f) {
            this.g.getLogger().c(Y2.INFO, "No collector found. Performance stats will not be captured during transactions.", new Object[0]);
            return;
        }
        if (!this.c.containsKey(str)) {
            this.c.put(str, new ArrayList());
        }
        if (this.h.getAndSet(true)) {
            return;
        }
        InterfaceC3102d0 interfaceC3102d0A = this.a.a();
        try {
            if (this.b == null) {
                this.b = new Timer(true);
            }
            this.b.schedule(new a(), 0L);
            this.b.scheduleAtFixedRate(new b(), 100L, 100L);
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
