package io.sentry.android.core;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.Y2;
import io.sentry.util.C3202a;
import ir.nasim.InterfaceC18633oz3;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class X implements Closeable {
    private static X e = new X();
    private volatile b b;
    private final C3202a a = new C3202a();
    private C3089z0 c = new C3089z0();
    private volatile Boolean d = null;

    public interface a {
        void a();

        void b();
    }

    public final class b implements DefaultLifecycleObserver {
        final List a = new a();

        class a extends CopyOnWriteArrayList {
            a() {
            }

            @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
            /* renamed from: f, reason: merged with bridge method [inline-methods] */
            public boolean add(a aVar) {
                boolean zAdd = super.add(aVar);
                if (Boolean.FALSE.equals(X.this.d)) {
                    aVar.a();
                } else if (Boolean.TRUE.equals(X.this.d)) {
                    aVar.b();
                }
                return zAdd;
            }
        }

        public b() {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(InterfaceC18633oz3 interfaceC18633oz3) {
            X.this.s(false);
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a();
            }
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStop(InterfaceC18633oz3 interfaceC18633oz3) {
            X.this.s(true);
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((a) it.next()).b();
            }
        }
    }

    private X() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void l(ILogger iLogger) {
        b bVar = this.b;
        if (bVar != null) {
            try {
                ProcessLifecycleOwner.l().getLifecycle().a(bVar);
            } catch (Throwable th) {
                this.b = null;
                iLogger.b(Y2.ERROR, "AppState failed to get Lifecycle and could not install lifecycle observer.", th);
            }
        }
    }

    private void g(final ILogger iLogger) {
        if (this.b != null) {
            return;
        }
        try {
            ProcessLifecycleOwner.Companion companion = ProcessLifecycleOwner.INSTANCE;
            this.b = new b();
            if (io.sentry.android.core.internal.util.i.e().a()) {
                l(iLogger);
            } else {
                this.c.b(new Runnable() { // from class: io.sentry.android.core.V
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.l(iLogger);
                    }
                });
            }
        } catch (ClassNotFoundException unused) {
            iLogger.c(Y2.WARNING, "androidx.lifecycle is not available, some features might not be properly working,e.g. Session Tracking, Network and System Events breadcrumbs, etc.", new Object[0]);
        } catch (Throwable th) {
            iLogger.b(Y2.ERROR, "AppState could not register lifecycle observer", th);
        }
    }

    public static X j() {
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void m(b bVar) {
        if (bVar != null) {
            ProcessLifecycleOwner.l().getLifecycle().d(bVar);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        u();
    }

    public void d(a aVar) {
        InterfaceC3102d0 interfaceC3102d0A = this.a.a();
        try {
            g(io.sentry.L0.e());
            if (this.b != null) {
                this.b.a.add(aVar);
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

    public Boolean k() {
        return this.d;
    }

    public void n(C3155n3 c3155n3) {
        if (this.b != null) {
            return;
        }
        InterfaceC3102d0 interfaceC3102d0A = this.a.a();
        try {
            g(c3155n3 != null ? c3155n3.getLogger() : io.sentry.L0.e());
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

    public void p(a aVar) {
        InterfaceC3102d0 interfaceC3102d0A = this.a.a();
        try {
            if (this.b != null) {
                this.b.a.remove(aVar);
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

    void s(boolean z) {
        this.d = Boolean.valueOf(z);
    }

    public void u() {
        if (this.b == null) {
            return;
        }
        InterfaceC3102d0 interfaceC3102d0A = this.a.a();
        try {
            final b bVar = this.b;
            this.b.a.clear();
            this.b = null;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            if (io.sentry.android.core.internal.util.i.e().a()) {
                m(bVar);
            } else {
                this.c.b(new Runnable() { // from class: io.sentry.android.core.W
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.m(bVar);
                    }
                });
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
