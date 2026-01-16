package io.sentry.android.replay;

import android.graphics.Point;
import android.view.View;
import android.view.ViewTreeObserver;
import io.sentry.C3155n3;
import io.sentry.ILogger;
import io.sentry.InterfaceC3102d0;
import io.sentry.Y2;
import io.sentry.util.C3202a;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC14155hS;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.UA2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class y implements f, io.sentry.android.replay.d {
    public static final b l = new b(null);
    public static final int m = 8;
    private final C3155n3 a;
    private final t b;
    private final w c;
    private final io.sentry.android.replay.util.j d;
    private final ScheduledExecutorService e;
    private final AtomicBoolean f;
    private final ArrayList g;
    private Point h;
    private final C3202a i;
    private final C3202a j;
    private volatile a k;

    private static final class a implements Runnable {
        private final C3155n3 a;
        private final io.sentry.android.replay.util.j b;
        private s c;
        private u d;
        private final AtomicBoolean e;

        public a(C3155n3 c3155n3, io.sentry.android.replay.util.j jVar) {
            AbstractC13042fc3.i(c3155n3, "options");
            AbstractC13042fc3.i(jVar, "mainLooperHandler");
            this.a = c3155n3;
            this.b = jVar;
            this.e = new AtomicBoolean(true);
        }

        public final s a() {
            return this.c;
        }

        public final void b() {
            s sVar = this.c;
            if (sVar != null) {
                sVar.u();
            }
            this.e.getAndSet(false);
        }

        public final void c() {
            if (this.a.getSessionReplay().o()) {
                this.a.getLogger().c(Y2.DEBUG, "Resuming the capture runnable.", new Object[0]);
            }
            s sVar = this.c;
            if (sVar != null) {
                sVar.v();
            }
            this.e.getAndSet(true);
            this.b.d(this);
            if (this.b.b(this)) {
                return;
            }
            this.a.getLogger().c(Y2.WARNING, "Failed to post the capture runnable, main looper is not ready.", new Object[0]);
        }

        public final void d(u uVar) {
            this.d = uVar;
        }

        public final void e(s sVar) {
            this.c = sVar;
        }

        public final void f() {
            s sVar = this.c;
            if (sVar != null) {
                sVar.m();
            }
            this.c = null;
            this.e.getAndSet(false);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.e.get()) {
                if (this.a.getSessionReplay().o()) {
                    this.a.getLogger().c(Y2.DEBUG, "Not capturing frames, recording is not running.", new Object[0]);
                    return;
                }
                return;
            }
            try {
                if (this.a.getSessionReplay().o()) {
                    this.a.getLogger().c(Y2.DEBUG, "Capturing a frame.", new Object[0]);
                }
                s sVar = this.c;
                if (sVar != null) {
                    sVar.i();
                }
            } catch (Throwable th) {
                this.a.getLogger().b(Y2.ERROR, "Failed to capture a frame", th);
            }
            if (this.a.getSessionReplay().o()) {
                ILogger logger = this.a.getLogger();
                Y2 y2 = Y2.DEBUG;
                StringBuilder sb = new StringBuilder();
                sb.append("Posting the capture runnable again, frame rate is ");
                u uVar = this.d;
                sb.append(uVar != null ? uVar.b() : 1);
                sb.append(" fps.");
                logger.c(y2, sb.toString(), new Object[0]);
            }
            if (this.b.c(this, 1000 / (this.d != null ? r3.b() : 1))) {
                return;
            }
            this.a.getLogger().c(Y2.WARNING, "Failed to post the capture runnable, main looper is shutting down.", new Object[0]);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View b;

        c(View view) {
            this.b = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            WeakReference weakReference = (WeakReference) AbstractC15401jX0.F0(y.this.g);
            if (!AbstractC13042fc3.d(this.b, weakReference != null ? (View) weakReference.get() : null)) {
                io.sentry.android.replay.util.p.i(this.b, this);
                return true;
            }
            if (io.sentry.android.replay.util.p.e(this.b)) {
                io.sentry.android.replay.util.p.i(this.b, this);
                if (this.b.getWidth() != y.this.h.x && this.b.getHeight() != y.this.h.y) {
                    y.this.h.set(this.b.getWidth(), this.b.getHeight());
                    y.this.c.d(this.b.getWidth(), this.b.getHeight());
                }
            }
            return true;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ View e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(View view) {
            super(1);
            this.e = view;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(WeakReference weakReference) {
            AbstractC13042fc3.i(weakReference, "it");
            return Boolean.valueOf(AbstractC13042fc3.d(weakReference.get(), this.e));
        }
    }

    public y(C3155n3 c3155n3, t tVar, w wVar, io.sentry.android.replay.util.j jVar, ScheduledExecutorService scheduledExecutorService) {
        AbstractC13042fc3.i(c3155n3, "options");
        AbstractC13042fc3.i(wVar, "windowCallback");
        AbstractC13042fc3.i(jVar, "mainLooperHandler");
        AbstractC13042fc3.i(scheduledExecutorService, "replayExecutor");
        this.a = c3155n3;
        this.b = tVar;
        this.c = wVar;
        this.d = jVar;
        this.e = scheduledExecutorService;
        this.f = new AtomicBoolean(false);
        this.g = new ArrayList();
        this.h = new Point();
        this.i = new C3202a();
        this.j = new C3202a();
    }

    @Override // io.sentry.android.replay.d
    public void a(View view, boolean z) throws Exception {
        s sVarA;
        s sVarA2;
        s sVarA3;
        AbstractC13042fc3.i(view, "root");
        InterfaceC3102d0 interfaceC3102d0A = this.i.a();
        try {
            if (z) {
                this.g.add(new WeakReference(view));
                a aVar = this.k;
                if (aVar != null && (sVarA3 = aVar.a()) != null) {
                    sVarA3.h(view);
                }
                e(view);
            } else {
                a aVar2 = this.k;
                if (aVar2 != null && (sVarA2 = aVar2.a()) != null) {
                    sVarA2.w(view);
                }
                AbstractC13610gX0.K(this.g, new d(view));
                WeakReference weakReference = (WeakReference) AbstractC15401jX0.F0(this.g);
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && !AbstractC13042fc3.d(view, view2)) {
                    a aVar3 = this.k;
                    if (aVar3 != null && (sVarA = aVar3.a()) != null) {
                        sVarA.h(view2);
                    }
                    e(view2);
                }
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            AbstractC14155hS.a(interfaceC3102d0A, null);
        } finally {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Exception {
        reset();
        this.d.d(this.k);
        stop();
    }

    public final void e(View view) {
        AbstractC13042fc3.i(view, "root");
        if (!io.sentry.android.replay.util.p.e(view)) {
            io.sentry.android.replay.util.p.b(view, new c(view));
            return;
        }
        if (view.getWidth() != this.h.x) {
            int height = view.getHeight();
            Point point = this.h;
            if (height != point.y) {
                point.set(view.getWidth(), view.getHeight());
                this.c.d(view.getWidth(), view.getHeight());
            }
        }
    }

    @Override // io.sentry.android.replay.f
    public void h() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // io.sentry.android.replay.f
    public void reset() throws Exception {
        s sVarA;
        this.h.set(0, 0);
        InterfaceC3102d0 interfaceC3102d0A = this.i.a();
        try {
            for (WeakReference weakReference : this.g) {
                a aVar = this.k;
                if (aVar != null && (sVarA = aVar.a()) != null) {
                    sVarA.w((View) weakReference.get());
                }
            }
            this.g.clear();
            C19938rB7 c19938rB7 = C19938rB7.a;
            AbstractC14155hS.a(interfaceC3102d0A, null);
        } finally {
        }
    }

    @Override // io.sentry.android.replay.f
    public void start() {
        this.f.getAndSet(true);
    }

    @Override // io.sentry.android.replay.f
    public void stop() throws Exception {
        a aVar = this.k;
        if (aVar != null) {
            aVar.f();
        }
        InterfaceC3102d0 interfaceC3102d0A = this.j.a();
        try {
            this.k = null;
            C19938rB7 c19938rB7 = C19938rB7.a;
            AbstractC14155hS.a(interfaceC3102d0A, null);
            this.f.set(false);
        } finally {
        }
    }

    @Override // io.sentry.android.replay.f
    public void v() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // io.sentry.android.replay.f
    public void x(u uVar) throws Exception {
        a aVar;
        s sVarA;
        AbstractC13042fc3.i(uVar, "config");
        if (this.f.get()) {
            if (this.k == null) {
                InterfaceC3102d0 interfaceC3102d0A = this.j.a();
                try {
                    if (this.k == null) {
                        this.k = new a(this.a, this.d);
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    AbstractC14155hS.a(interfaceC3102d0A, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AbstractC14155hS.a(interfaceC3102d0A, th);
                        throw th2;
                    }
                }
            }
            a aVar2 = this.k;
            if (aVar2 != null) {
                aVar2.d(uVar);
            }
            a aVar3 = this.k;
            if (aVar3 != null) {
                aVar3.e(new s(uVar, this.a, this.d, this.e, this.b));
            }
            WeakReference weakReference = (WeakReference) AbstractC15401jX0.F0(this.g);
            View view = weakReference != null ? (View) weakReference.get() : null;
            if (view != null && (aVar = this.k) != null && (sVarA = aVar.a()) != null) {
                sVarA.h(view);
            }
            this.d.d(this.k);
            if (this.d.c(this.k, 100L)) {
                return;
            }
            this.a.getLogger().c(Y2.WARNING, "Failed to post the capture runnable, main looper is shutting down.", new Object[0]);
        }
    }
}
