package ir.nasim;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.G27;
import ir.nasim.Z27;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class K12 implements L27, SurfaceTexture.OnFrameAvailableListener {
    private final C24086y12 a;
    final HandlerThread b;
    private final Executor c;
    final Handler d;
    private int e;
    private boolean f;
    private final AtomicBoolean g;
    final Map h;
    private SurfaceTexture i;
    private SurfaceTexture j;

    public static class a {
        private static InterfaceC15796kB2 a = new InterfaceC15796kB2() { // from class: ir.nasim.J12
            @Override // ir.nasim.InterfaceC15796kB2
            public final Object q(Object obj, Object obj2, Object obj3) {
                return new K12((C15116j22) obj, (C6012Lu3) obj2, (C6012Lu3) obj3);
            }
        };

        public static L27 a(C15116j22 c15116j22, C6012Lu3 c6012Lu3, C6012Lu3 c6012Lu32) {
            return (L27) a.q(c15116j22, c6012Lu3, c6012Lu32);
        }
    }

    K12(C15116j22 c15116j22, C6012Lu3 c6012Lu3, C6012Lu3 c6012Lu32) {
        this(c15116j22, Collections.emptyMap(), c6012Lu3, c6012Lu32);
    }

    private void l() {
        if (this.f && this.e == 0) {
            Iterator it = this.h.keySet().iterator();
            while (it.hasNext()) {
                ((G27) it.next()).close();
            }
            this.h.clear();
            this.a.k();
            this.b.quit();
        }
    }

    private void m(Runnable runnable) {
        n(runnable, new Runnable() { // from class: ir.nasim.H12
            @Override // java.lang.Runnable
            public final void run() {
                K12.p();
            }
        });
    }

    private void n(final Runnable runnable, final Runnable runnable2) {
        try {
            this.c.execute(new Runnable() { // from class: ir.nasim.G12
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.q(runnable2, runnable);
                }
            });
        } catch (RejectedExecutionException e) {
            PI3.m("DualSurfaceProcessor", "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    private void o(final C15116j22 c15116j22, final Map map) throws ExecutionException, InterruptedException {
        try {
            AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.C12
                @Override // ir.nasim.AbstractC16967mA0.c
                public final Object a(AbstractC16967mA0.a aVar) {
                    return this.a.s(c15116j22, map, aVar);
                }
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            e = e;
            if (e instanceof ExecutionException) {
                e = e.getCause();
            }
            if (!(e instanceof RuntimeException)) {
                throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
            }
            throw ((RuntimeException) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(Runnable runnable, Runnable runnable2) {
        if (this.f) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(C15116j22 c15116j22, Map map, AbstractC16967mA0.a aVar) throws Throwable {
        try {
            this.a.h(c15116j22, map);
            aVar.c(null);
        } catch (RuntimeException e) {
            aVar.f(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(final C15116j22 c15116j22, final Map map, final AbstractC16967mA0.a aVar) {
        m(new Runnable() { // from class: ir.nasim.E12
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.r(c15116j22, map, aVar);
            }
        });
        return "Init GlRenderer";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(SurfaceTexture surfaceTexture, Surface surface, Z27.g gVar) {
        surfaceTexture.setOnFrameAvailableListener(null);
        surfaceTexture.release();
        surface.release();
        this.e--;
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(Z27 z27) throws ExecutionException, InterruptedException {
        this.e++;
        final SurfaceTexture surfaceTexture = new SurfaceTexture(this.a.t(z27.r()));
        surfaceTexture.setDefaultBufferSize(z27.o().getWidth(), z27.o().getHeight());
        final Surface surface = new Surface(surfaceTexture);
        z27.B(surface, this.c, new InterfaceC25043ze1() { // from class: ir.nasim.I12
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                this.a.t(surfaceTexture, surface, (Z27.g) obj);
            }
        });
        if (z27.r()) {
            this.i = surfaceTexture;
        } else {
            this.j = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(G27 g27, G27.b bVar) {
        g27.close();
        Surface surface = (Surface) this.h.remove(g27);
        if (surface != null) {
            this.a.r(surface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(final G27 g27) {
        Surface surfaceG0 = g27.g0(this.c, new InterfaceC25043ze1() { // from class: ir.nasim.F12
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                this.a.v(g27, (G27.b) obj);
            }
        });
        this.a.j(surfaceG0);
        this.h.put(g27, surfaceG0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        this.f = true;
        l();
    }

    @Override // ir.nasim.K27
    public void a(final Z27 z27) {
        if (this.g.get()) {
            z27.E();
            return;
        }
        Runnable runnable = new Runnable() { // from class: ir.nasim.B12
            @Override // java.lang.Runnable
            public final void run() throws ExecutionException, InterruptedException {
                this.a.u(z27);
            }
        };
        Objects.requireNonNull(z27);
        n(runnable, new RunnableC13449gF1(z27));
    }

    @Override // ir.nasim.K27
    public void b(final G27 g27) {
        if (this.g.get()) {
            g27.close();
            return;
        }
        Runnable runnable = new Runnable() { // from class: ir.nasim.D12
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w(g27);
            }
        };
        Objects.requireNonNull(g27);
        n(runnable, new RunnableC12222eF1(g27));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2;
        if (this.g.get() || (surfaceTexture2 = this.i) == null || this.j == null) {
            return;
        }
        surfaceTexture2.updateTexImage();
        this.j.updateTexImage();
        for (Map.Entry entry : this.h.entrySet()) {
            Surface surface = (Surface) entry.getValue();
            G27 g27 = (G27) entry.getKey();
            if (g27.C() == 34) {
                try {
                    this.a.v(surfaceTexture.getTimestamp(), surface, g27, this.i, this.j);
                } catch (RuntimeException e) {
                    PI3.d("DualSurfaceProcessor", "Failed to render with OpenGL.", e);
                }
            }
        }
    }

    @Override // ir.nasim.L27
    public void release() {
        if (this.g.getAndSet(true)) {
            return;
        }
        m(new Runnable() { // from class: ir.nasim.A12
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x();
            }
        });
    }

    K12(C15116j22 c15116j22, Map map, C6012Lu3 c6012Lu3, C6012Lu3 c6012Lu32) throws ExecutionException, InterruptedException {
        this.e = 0;
        this.f = false;
        this.g = new AtomicBoolean(false);
        this.h = new LinkedHashMap();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.d = handler;
        this.c = AbstractC20567sE0.d(handler);
        this.a = new C24086y12(c6012Lu3, c6012Lu32);
        try {
            o(c15116j22, map);
        } catch (RuntimeException e) {
            release();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p() {
    }
}
