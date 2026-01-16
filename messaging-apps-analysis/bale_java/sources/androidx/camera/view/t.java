package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.view.PreviewView;
import androidx.camera.view.i;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.AbstractC20567sE0;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.InterfaceC25043ze1;
import ir.nasim.InterfaceFutureC15215jC3;
import ir.nasim.MB2;
import ir.nasim.PI3;
import ir.nasim.WB2;
import ir.nasim.Z27;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
final class t extends i {
    TextureView e;
    SurfaceTexture f;
    InterfaceFutureC15215jC3 g;
    Z27 h;
    boolean i;
    SurfaceTexture j;
    AtomicReference k;
    i.a l;
    Executor m;

    class a implements TextureView.SurfaceTextureListener {

        /* renamed from: androidx.camera.view.t$a$a, reason: collision with other inner class name */
        class C0019a implements MB2 {
            final /* synthetic */ SurfaceTexture a;

            C0019a(SurfaceTexture surfaceTexture) {
                this.a = surfaceTexture;
            }

            @Override // ir.nasim.MB2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Z27.g gVar) {
                AbstractC4980Hj5.j(gVar.a() != 3, "Unexpected result from SurfaceRequest. Surface was provided twice.");
                PI3.a("TextureViewImpl", "SurfaceTexture about to manually be destroyed");
                this.a.release();
                t tVar = t.this;
                if (tVar.j != null) {
                    tVar.j = null;
                }
            }

            @Override // ir.nasim.MB2
            public void onFailure(Throwable th) {
                throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th);
            }
        }

        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            PI3.a("TextureViewImpl", "SurfaceTexture available. Size: " + i + "x" + i2);
            t tVar = t.this;
            tVar.f = surfaceTexture;
            if (tVar.g == null) {
                tVar.v();
                return;
            }
            AbstractC4980Hj5.g(tVar.h);
            PI3.a("TextureViewImpl", "Surface invalidated " + t.this.h);
            t.this.h.m().d();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            t tVar = t.this;
            tVar.f = null;
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = tVar.g;
            if (interfaceFutureC15215jC3 == null) {
                PI3.a("TextureViewImpl", "SurfaceTexture about to be destroyed");
                return true;
            }
            WB2.g(interfaceFutureC15215jC3, new C0019a(surfaceTexture), AbstractC4043Dl1.i(t.this.e.getContext()));
            t.this.j = surfaceTexture;
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            PI3.a("TextureViewImpl", "SurfaceTexture size changed: " + i + "x" + i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            AbstractC16967mA0.a aVar = (AbstractC16967mA0.a) t.this.k.getAndSet(null);
            if (aVar != null) {
                aVar.c(null);
            }
            t.this.getClass();
            Executor executor = t.this.m;
        }
    }

    t(FrameLayout frameLayout, e eVar) {
        super(frameLayout, eVar);
        this.i = false;
        this.k = new AtomicReference();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(Z27 z27) {
        Z27 z272 = this.h;
        if (z272 != null && z272 == z27) {
            this.h = null;
            this.g = null;
        }
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(Surface surface, final AbstractC16967mA0.a aVar) throws ExecutionException, InterruptedException {
        PI3.a("TextureViewImpl", "Surface set on Preview.");
        Z27 z27 = this.h;
        Executor executorA = AbstractC20567sE0.a();
        Objects.requireNonNull(aVar);
        z27.B(surface, executorA, new InterfaceC25043ze1() { // from class: ir.nasim.so7
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                aVar.c((Z27.g) obj);
            }
        });
        return "provideSurface[request=" + this.h + " surface=" + surface + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(Surface surface, InterfaceFutureC15215jC3 interfaceFutureC15215jC3, Z27 z27) {
        PI3.a("TextureViewImpl", "Safe to release surface.");
        t();
        surface.release();
        if (this.g == interfaceFutureC15215jC3) {
            this.g = null;
        }
        if (this.h == z27) {
            this.h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(AbstractC16967mA0.a aVar) {
        this.k.set(aVar);
        return "textureViewImpl_waitForNextFrame";
    }

    private void t() {
        i.a aVar = this.l;
        if (aVar != null) {
            aVar.a();
            this.l = null;
        }
    }

    private void u() {
        if (!this.i || this.j == null) {
            return;
        }
        SurfaceTexture surfaceTexture = this.e.getSurfaceTexture();
        SurfaceTexture surfaceTexture2 = this.j;
        if (surfaceTexture != surfaceTexture2) {
            this.e.setSurfaceTexture(surfaceTexture2);
            this.j = null;
            this.i = false;
        }
    }

    @Override // androidx.camera.view.i
    View b() {
        return this.e;
    }

    @Override // androidx.camera.view.i
    Bitmap c() {
        TextureView textureView = this.e;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        return this.e.getBitmap();
    }

    @Override // androidx.camera.view.i
    void d() {
        u();
    }

    @Override // androidx.camera.view.i
    void e() {
        this.i = true;
    }

    @Override // androidx.camera.view.i
    void g(final Z27 z27, i.a aVar) {
        this.a = z27.o();
        this.l = aVar;
        o();
        Z27 z272 = this.h;
        if (z272 != null) {
            z272.E();
        }
        this.h = z27;
        z27.j(AbstractC4043Dl1.i(this.e.getContext()), new Runnable() { // from class: androidx.camera.view.p
            @Override // java.lang.Runnable
            public final void run() {
                this.a.p(z27);
            }
        });
        v();
    }

    @Override // androidx.camera.view.i
    void i(Executor executor, PreviewView.d dVar) {
        this.m = executor;
    }

    @Override // androidx.camera.view.i
    InterfaceFutureC15215jC3 j() {
        return AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: androidx.camera.view.q
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.s(aVar);
            }
        });
    }

    public void o() {
        AbstractC4980Hj5.g(this.b);
        AbstractC4980Hj5.g(this.a);
        TextureView textureView = new TextureView(this.b.getContext());
        this.e = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.a.getWidth(), this.a.getHeight()));
        this.e.setSurfaceTextureListener(new a());
        this.b.removeAllViews();
        this.b.addView(this.e);
    }

    void v() {
        SurfaceTexture surfaceTexture;
        Size size = this.a;
        if (size == null || (surfaceTexture = this.f) == null || this.h == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(size.getWidth(), this.a.getHeight());
        final Surface surface = new Surface(this.f);
        final Z27 z27 = this.h;
        final InterfaceFutureC15215jC3 interfaceFutureC15215jC3A = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: androidx.camera.view.r
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.q(surface, aVar);
            }
        });
        this.g = interfaceFutureC15215jC3A;
        interfaceFutureC15215jC3A.j(new Runnable() { // from class: androidx.camera.view.s
            @Override // java.lang.Runnable
            public final void run() {
                this.a.r(surface, interfaceFutureC15215jC3A, z27);
            }
        }, AbstractC4043Dl1.i(this.e.getContext()));
        f();
    }
}
