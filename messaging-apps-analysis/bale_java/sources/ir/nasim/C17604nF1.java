package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProcessingUtil;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.AbstractC9579aC2;
import ir.nasim.G27;
import ir.nasim.Z27;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.nF1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C17604nF1 implements L27, SurfaceTexture.OnFrameAvailableListener {
    private final C9662aL4 a;
    final HandlerThread b;
    private final Executor c;
    final Handler d;
    private final AtomicBoolean e;
    private final float[] f;
    private final float[] g;
    final Map h;
    private int i;
    private boolean j;
    private final List k;

    /* renamed from: ir.nasim.nF1$a */
    public static class a {
        private static InterfaceC21819uB2 a = new InterfaceC21819uB2() { // from class: ir.nasim.mF1
            @Override // ir.nasim.InterfaceC21819uB2
            public final Object apply(Object obj) {
                return new C17604nF1((C15116j22) obj);
            }
        };

        public static L27 a(C15116j22 c15116j22) {
            return (L27) a.apply(c15116j22);
        }
    }

    /* renamed from: ir.nasim.nF1$b */
    static abstract class b {
        abstract AbstractC16967mA0.a a();

        abstract int b();

        abstract int c();
    }

    C17604nF1(C15116j22 c15116j22) {
        this(c15116j22, Collections.emptyMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(final G27 g27) {
        Surface surfaceG0 = g27.g0(this.c, new InterfaceC25043ze1() { // from class: ir.nasim.iF1
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                this.a.z(g27, (G27.b) obj);
            }
        });
        this.a.j(surfaceG0);
        this.h.put(g27, surfaceG0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        this.j = true;
        m();
    }

    private void C(C17428mw7 c17428mw7) throws IOException {
        if (this.k.isEmpty()) {
            return;
        }
        if (c17428mw7 == null) {
            p(new Exception("Failed to snapshot: no JPEG Surface."));
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Iterator it = this.k.iterator();
                int iC = -1;
                int iB = -1;
                Bitmap bitmapQ = null;
                byte[] byteArray = null;
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (iC != bVar.c() || bitmapQ == null) {
                        iC = bVar.c();
                        if (bitmapQ != null) {
                            bitmapQ.recycle();
                        }
                        bitmapQ = q((Size) c17428mw7.g(), (float[]) c17428mw7.j(), iC);
                        iB = -1;
                    }
                    if (iB != bVar.b()) {
                        byteArrayOutputStream.reset();
                        iB = bVar.b();
                        bitmapQ.compress(Bitmap.CompressFormat.JPEG, iB, byteArrayOutputStream);
                        byteArray = byteArrayOutputStream.toByteArray();
                    }
                    Surface surface = (Surface) c17428mw7.f();
                    Objects.requireNonNull(byteArray);
                    ImageProcessingUtil.k(surface, byteArray);
                    bVar.a().c(null);
                    it.remove();
                }
                byteArrayOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            p(e);
        }
    }

    private void m() {
        if (this.j && this.i == 0) {
            Iterator it = this.h.keySet().iterator();
            while (it.hasNext()) {
                ((G27) it.next()).close();
            }
            Iterator it2 = this.k.iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).a().f(new Exception("Failed to snapshot: DefaultSurfaceProcessor is released."));
            }
            this.h.clear();
            this.a.k();
            this.b.quit();
        }
    }

    private void n(Runnable runnable) {
        o(runnable, new Runnable() { // from class: ir.nasim.bF1
            @Override // java.lang.Runnable
            public final void run() {
                C17604nF1.s();
            }
        });
    }

    private void o(final Runnable runnable, final Runnable runnable2) {
        try {
            this.c.execute(new Runnable() { // from class: ir.nasim.cF1
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.t(runnable2, runnable);
                }
            });
        } catch (RejectedExecutionException e) {
            PI3.m("DefaultSurfaceProcessor", "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    private void p(Throwable th) {
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a().f(th);
        }
        this.k.clear();
    }

    private Bitmap q(Size size, float[] fArr, int i) {
        float[] fArr2 = (float[]) fArr.clone();
        DV3.c(fArr2, i, 0.5f, 0.5f);
        DV3.d(fArr2, 0.5f);
        return this.a.p(AbstractC14447hv7.o(size, i), fArr2);
    }

    private void r(final C15116j22 c15116j22, final Map map) throws ExecutionException, InterruptedException {
        try {
            AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.aF1
                @Override // ir.nasim.AbstractC16967mA0.c
                public final Object a(AbstractC16967mA0.a aVar) {
                    return this.a.u(c15116j22, map, aVar);
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
    public /* synthetic */ void t(Runnable runnable, Runnable runnable2) {
        if (this.j) {
            runnable.run();
        } else {
            runnable2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object u(final C15116j22 c15116j22, final Map map, final AbstractC16967mA0.a aVar) {
        n(new Runnable() { // from class: ir.nasim.lF1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.v(c15116j22, map, aVar);
            }
        });
        return "Init GlRenderer";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(C15116j22 c15116j22, Map map, AbstractC16967mA0.a aVar) throws Throwable {
        try {
            this.a.h(c15116j22, map);
            aVar.c(null);
        } catch (RuntimeException e) {
            aVar.f(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(Z27 z27, Z27.h hVar) {
        AbstractC9579aC2.e eVar = AbstractC9579aC2.e.DEFAULT;
        if (z27.n().d() && hVar.e()) {
            eVar = AbstractC9579aC2.e.YUV;
        }
        this.a.o(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(Z27 z27, SurfaceTexture surfaceTexture, Surface surface, Z27.g gVar) {
        z27.k();
        surfaceTexture.setOnFrameAvailableListener(null);
        surfaceTexture.release();
        surface.release();
        this.i--;
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(final Z27 z27) throws ExecutionException, InterruptedException {
        this.i++;
        final SurfaceTexture surfaceTexture = new SurfaceTexture(this.a.g());
        surfaceTexture.setDefaultBufferSize(z27.o().getWidth(), z27.o().getHeight());
        final Surface surface = new Surface(surfaceTexture);
        z27.C(this.c, new Z27.i() { // from class: ir.nasim.jF1
            @Override // ir.nasim.Z27.i
            public final void a(Z27.h hVar) {
                this.a.w(z27, hVar);
            }
        });
        z27.B(surface, this.c, new InterfaceC25043ze1() { // from class: ir.nasim.kF1
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                this.a.x(z27, surfaceTexture, surface, (Z27.g) obj);
            }
        });
        surfaceTexture.setOnFrameAvailableListener(this, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(G27 g27, G27.b bVar) {
        g27.close();
        Surface surface = (Surface) this.h.remove(g27);
        if (surface != null) {
            this.a.r(surface);
        }
    }

    @Override // ir.nasim.K27
    public void a(final Z27 z27) {
        if (this.e.get()) {
            z27.E();
            return;
        }
        Runnable runnable = new Runnable() { // from class: ir.nasim.fF1
            @Override // java.lang.Runnable
            public final void run() throws ExecutionException, InterruptedException {
                this.a.y(z27);
            }
        };
        Objects.requireNonNull(z27);
        o(runnable, new RunnableC13449gF1(z27));
    }

    @Override // ir.nasim.K27
    public void b(final G27 g27) {
        if (this.e.get()) {
            g27.close();
            return;
        }
        Runnable runnable = new Runnable() { // from class: ir.nasim.dF1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.A(g27);
            }
        };
        Objects.requireNonNull(g27);
        o(runnable, new RunnableC12222eF1(g27));
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) throws IOException {
        if (this.e.get()) {
            return;
        }
        surfaceTexture.updateTexImage();
        surfaceTexture.getTransformMatrix(this.f);
        C17428mw7 c17428mw7 = null;
        for (Map.Entry entry : this.h.entrySet()) {
            Surface surface = (Surface) entry.getValue();
            G27 g27 = (G27) entry.getKey();
            g27.V0(this.g, this.f);
            if (g27.C() == 34) {
                try {
                    this.a.n(surfaceTexture.getTimestamp(), this.g, surface);
                } catch (RuntimeException e) {
                    PI3.d("DefaultSurfaceProcessor", "Failed to render with OpenGL.", e);
                }
            } else {
                AbstractC4980Hj5.j(g27.C() == 256, "Unsupported format: " + g27.C());
                AbstractC4980Hj5.j(c17428mw7 == null, "Only one JPEG output is supported.");
                c17428mw7 = new C17428mw7(surface, g27.f(), (float[]) this.g.clone());
            }
        }
        try {
            C(c17428mw7);
        } catch (RuntimeException e2) {
            p(e2);
        }
    }

    @Override // ir.nasim.L27
    public void release() {
        if (this.e.getAndSet(true)) {
            return;
        }
        n(new Runnable() { // from class: ir.nasim.hF1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.B();
            }
        });
    }

    C17604nF1(C15116j22 c15116j22, Map map) throws ExecutionException, InterruptedException {
        this.e = new AtomicBoolean(false);
        this.f = new float[16];
        this.g = new float[16];
        this.h = new LinkedHashMap();
        this.i = 0;
        this.j = false;
        this.k = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.d = handler;
        this.c = AbstractC20567sE0.d(handler);
        this.a = new C9662aL4();
        try {
            r(c15116j22, map);
        } catch (RuntimeException e) {
            release();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s() {
    }
}
