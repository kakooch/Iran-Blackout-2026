package com.bumptech.glide.load.engine;

import android.os.Process;
import com.bumptech.glide.load.engine.o;
import ir.nasim.AbstractC3322Aj5;
import ir.nasim.DW5;
import ir.nasim.InterfaceC14373ho3;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
final class a {
    private final boolean a;
    private final Executor b;
    final Map c;
    private final ReferenceQueue d;
    private o.a e;
    private volatile boolean f;

    /* renamed from: com.bumptech.glide.load.engine.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0148a implements ThreadFactory {

        /* renamed from: com.bumptech.glide.load.engine.a$a$a, reason: collision with other inner class name */
        class RunnableC0149a implements Runnable {
            final /* synthetic */ Runnable a;

            RunnableC0149a(Runnable runnable) {
                this.a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(10);
                this.a.run();
            }
        }

        ThreadFactoryC0148a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0149a(runnable), "glide-active-resources");
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    static final class c extends WeakReference {
        final InterfaceC14373ho3 a;
        final boolean b;
        DW5 c;

        c(InterfaceC14373ho3 interfaceC14373ho3, o oVar, ReferenceQueue referenceQueue, boolean z) {
            super(oVar, referenceQueue);
            this.a = (InterfaceC14373ho3) AbstractC3322Aj5.d(interfaceC14373ho3);
            this.c = (oVar.e() && z) ? (DW5) AbstractC3322Aj5.d(oVar.d()) : null;
            this.b = oVar.e();
        }

        void a() {
            this.c = null;
            clear();
        }
    }

    a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC0148a()));
    }

    synchronized void a(InterfaceC14373ho3 interfaceC14373ho3, o oVar) {
        c cVar = (c) this.c.put(interfaceC14373ho3, new c(interfaceC14373ho3, oVar, this.d, this.a));
        if (cVar != null) {
            cVar.a();
        }
    }

    void b() {
        while (!this.f) {
            try {
                c((c) this.d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(c cVar) {
        DW5 dw5;
        synchronized (this) {
            this.c.remove(cVar.a);
            if (cVar.b && (dw5 = cVar.c) != null) {
                this.e.b(cVar.a, new o(dw5, true, false, cVar.a, this.e));
            }
        }
    }

    synchronized void d(InterfaceC14373ho3 interfaceC14373ho3) {
        c cVar = (c) this.c.remove(interfaceC14373ho3);
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    synchronized o e(InterfaceC14373ho3 interfaceC14373ho3) {
        c cVar = (c) this.c.get(interfaceC14373ho3);
        if (cVar == null) {
            return null;
        }
        o oVar = (o) cVar.get();
        if (oVar == null) {
            c(cVar);
        }
        return oVar;
    }

    void f(o.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.e = aVar;
            }
        }
    }

    a(boolean z, Executor executor) {
        this.c = new HashMap();
        this.d = new ReferenceQueue();
        this.a = z;
        this.b = executor;
        executor.execute(new b());
    }
}
