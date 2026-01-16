package ir.nasim;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.InterfaceC18096o47;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: ir.nasim.u47, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC21755u47 extends InterfaceC18096o47.c implements InterfaceC18096o47, InterfaceC18096o47.a {
    final C15248jG0 b;
    final Handler c;
    final Executor d;
    private final ScheduledExecutorService e;
    InterfaceC18096o47.c f;
    TB0 g;
    InterfaceFutureC15215jC3 h;
    AbstractC16967mA0.a i;
    private InterfaceFutureC15215jC3 j;
    final Object a = new Object();
    private List k = null;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;

    /* renamed from: ir.nasim.u47$b */
    class b extends CameraCaptureSession.StateCallback {
        b() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(CameraCaptureSession cameraCaptureSession) {
            AbstractC21755u47.this.B(cameraCaptureSession);
            AbstractC21755u47 abstractC21755u47 = AbstractC21755u47.this;
            abstractC21755u47.o(abstractC21755u47);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
            AbstractC21755u47.this.B(cameraCaptureSession);
            AbstractC21755u47 abstractC21755u47 = AbstractC21755u47.this;
            abstractC21755u47.p(abstractC21755u47);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            AbstractC21755u47.this.B(cameraCaptureSession);
            AbstractC21755u47 abstractC21755u47 = AbstractC21755u47.this;
            abstractC21755u47.q(abstractC21755u47);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            AbstractC16967mA0.a aVar;
            try {
                AbstractC21755u47.this.B(cameraCaptureSession);
                AbstractC21755u47 abstractC21755u47 = AbstractC21755u47.this;
                abstractC21755u47.r(abstractC21755u47);
                synchronized (AbstractC21755u47.this.a) {
                    AbstractC4980Hj5.h(AbstractC21755u47.this.i, "OpenCaptureSession completer should not null");
                    AbstractC21755u47 abstractC21755u472 = AbstractC21755u47.this;
                    aVar = abstractC21755u472.i;
                    abstractC21755u472.i = null;
                }
                aVar.f(new IllegalStateException("onConfigureFailed"));
            } catch (Throwable th) {
                synchronized (AbstractC21755u47.this.a) {
                    AbstractC4980Hj5.h(AbstractC21755u47.this.i, "OpenCaptureSession completer should not null");
                    AbstractC21755u47 abstractC21755u473 = AbstractC21755u47.this;
                    AbstractC16967mA0.a aVar2 = abstractC21755u473.i;
                    abstractC21755u473.i = null;
                    aVar2.f(new IllegalStateException("onConfigureFailed"));
                    throw th;
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            AbstractC16967mA0.a aVar;
            try {
                AbstractC21755u47.this.B(cameraCaptureSession);
                AbstractC21755u47 abstractC21755u47 = AbstractC21755u47.this;
                abstractC21755u47.s(abstractC21755u47);
                synchronized (AbstractC21755u47.this.a) {
                    AbstractC4980Hj5.h(AbstractC21755u47.this.i, "OpenCaptureSession completer should not null");
                    AbstractC21755u47 abstractC21755u472 = AbstractC21755u47.this;
                    aVar = abstractC21755u472.i;
                    abstractC21755u472.i = null;
                }
                aVar.c(null);
            } catch (Throwable th) {
                synchronized (AbstractC21755u47.this.a) {
                    AbstractC4980Hj5.h(AbstractC21755u47.this.i, "OpenCaptureSession completer should not null");
                    AbstractC21755u47 abstractC21755u473 = AbstractC21755u47.this;
                    AbstractC16967mA0.a aVar2 = abstractC21755u473.i;
                    abstractC21755u473.i = null;
                    aVar2.c(null);
                    throw th;
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(CameraCaptureSession cameraCaptureSession) {
            AbstractC21755u47.this.B(cameraCaptureSession);
            AbstractC21755u47 abstractC21755u47 = AbstractC21755u47.this;
            abstractC21755u47.t(abstractC21755u47);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
            AbstractC21755u47.this.B(cameraCaptureSession);
            AbstractC21755u47 abstractC21755u47 = AbstractC21755u47.this;
            abstractC21755u47.v(abstractC21755u47, surface);
        }
    }

    AbstractC21755u47(C15248jG0 c15248jG0, Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler) {
        this.b = c15248jG0;
        this.c = handler;
        this.d = executor;
        this.e = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        u(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(InterfaceC18096o47 interfaceC18096o47) {
        this.b.g(this);
        u(interfaceC18096o47);
        if (this.g != null) {
            Objects.requireNonNull(this.f);
            this.f.q(interfaceC18096o47);
            return;
        }
        PI3.l("SyncCaptureSessionBase", "[" + this + "] Cannot call onClosed() when the CameraCaptureSession is not correctly configured.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(InterfaceC18096o47 interfaceC18096o47) {
        Objects.requireNonNull(this.f);
        this.f.u(interfaceC18096o47);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object H(List list, NC0 nc0, C8626Wt6 c8626Wt6, AbstractC16967mA0.a aVar) {
        String str;
        synchronized (this.a) {
            C(list);
            AbstractC4980Hj5.j(this.i == null, "The openCaptureSessionCompleter can only set once!");
            this.i = aVar;
            nc0.a(c8626Wt6);
            str = "openCaptureSession[session=" + this + "]";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InterfaceFutureC15215jC3 I(List list, List list2) {
        PI3.a("SyncCaptureSessionBase", "[" + this + "] getSurface done with results: " + list2);
        return list2.isEmpty() ? WB2.j(new IllegalArgumentException("Unable to open capture session without surfaces")) : list2.contains(null) ? WB2.j(new DeferrableSurface.SurfaceClosedException("Surface closed", (DeferrableSurface) list.get(list2.indexOf(null)))) : WB2.l(list2);
    }

    void B(CameraCaptureSession cameraCaptureSession) {
        if (this.g == null) {
            this.g = TB0.d(cameraCaptureSession, this.c);
        }
    }

    void C(List list) {
        synchronized (this.a) {
            J();
            androidx.camera.core.impl.k.d(list);
            this.k = list;
        }
    }

    boolean D() {
        boolean z;
        synchronized (this.a) {
            z = this.h != null;
        }
        return z;
    }

    void J() {
        synchronized (this.a) {
            try {
                List list = this.k;
                if (list != null) {
                    androidx.camera.core.impl.k.c(list);
                    this.k = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC18096o47
    public void a() {
        AbstractC4980Hj5.h(this.g, "Need to call openCaptureSession before using this API.");
        this.g.c().abortCaptures();
    }

    @Override // ir.nasim.InterfaceC18096o47.a
    public Executor b() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC18096o47
    public void close() {
        AbstractC4980Hj5.h(this.g, "Need to call openCaptureSession before using this API.");
        this.b.h(this);
        this.g.c().close();
        b().execute(new Runnable() { // from class: ir.nasim.s47
            @Override // java.lang.Runnable
            public final void run() {
                this.a.E();
            }
        });
    }

    @Override // ir.nasim.InterfaceC18096o47
    public void d() throws CameraAccessException {
        AbstractC4980Hj5.h(this.g, "Need to call openCaptureSession before using this API.");
        this.g.c().stopRepeating();
    }

    @Override // ir.nasim.InterfaceC18096o47
    public void e() {
        J();
    }

    @Override // ir.nasim.InterfaceC18096o47.a
    public InterfaceFutureC15215jC3 f(CameraDevice cameraDevice, final C8626Wt6 c8626Wt6, final List list) {
        synchronized (this.a) {
            try {
                if (this.m) {
                    return WB2.j(new CancellationException("Opener is disabled"));
                }
                this.b.k(this);
                final NC0 nc0B = NC0.b(cameraDevice, this.c);
                InterfaceFutureC15215jC3 interfaceFutureC15215jC3A = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.t47
                    @Override // ir.nasim.AbstractC16967mA0.c
                    public final Object a(AbstractC16967mA0.a aVar) {
                        return this.a.H(list, nc0B, c8626Wt6, aVar);
                    }
                });
                this.h = interfaceFutureC15215jC3A;
                WB2.g(interfaceFutureC15215jC3A, new a(), AbstractC20567sE0.a());
                return WB2.t(this.h);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC18096o47
    public CameraDevice h() {
        AbstractC4980Hj5.g(this.g);
        return this.g.c().getDevice();
    }

    @Override // ir.nasim.InterfaceC18096o47
    public int i(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        AbstractC4980Hj5.h(this.g, "Need to call openCaptureSession before using this API.");
        return this.g.b(captureRequest, b(), captureCallback);
    }

    @Override // ir.nasim.InterfaceC18096o47.a
    public InterfaceFutureC15215jC3 j(final List list, long j) {
        synchronized (this.a) {
            try {
                if (this.m) {
                    return WB2.j(new CancellationException("Opener is disabled"));
                }
                NB2 nb2E = NB2.a(androidx.camera.core.impl.k.g(list, false, j, b(), this.e)).e(new FK() { // from class: ir.nasim.q47
                    @Override // ir.nasim.FK
                    public final InterfaceFutureC15215jC3 apply(Object obj) {
                        return this.a.I(list, (List) obj);
                    }
                }, b());
                this.j = nb2E;
                return WB2.t(nb2E);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC18096o47.a
    public C8626Wt6 k(int i, List list, InterfaceC18096o47.c cVar) {
        this.f = cVar;
        return new C8626Wt6(i, list, b(), new b());
    }

    @Override // ir.nasim.InterfaceC18096o47
    public int l(List list, CameraCaptureSession.CaptureCallback captureCallback) {
        AbstractC4980Hj5.h(this.g, "Need to call openCaptureSession before using this API.");
        return this.g.a(list, b(), captureCallback);
    }

    @Override // ir.nasim.InterfaceC18096o47
    public TB0 m() {
        AbstractC4980Hj5.g(this.g);
        return this.g;
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void o(InterfaceC18096o47 interfaceC18096o47) {
        Objects.requireNonNull(this.f);
        this.f.o(interfaceC18096o47);
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void p(InterfaceC18096o47 interfaceC18096o47) {
        Objects.requireNonNull(this.f);
        this.f.p(interfaceC18096o47);
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void q(final InterfaceC18096o47 interfaceC18096o47) {
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3;
        synchronized (this.a) {
            try {
                if (this.l) {
                    interfaceFutureC15215jC3 = null;
                } else {
                    this.l = true;
                    AbstractC4980Hj5.h(this.h, "Need to call openCaptureSession before using this API.");
                    interfaceFutureC15215jC3 = this.h;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        e();
        if (interfaceFutureC15215jC3 != null) {
            interfaceFutureC15215jC3.j(new Runnable() { // from class: ir.nasim.p47
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.F(interfaceC18096o47);
                }
            }, AbstractC20567sE0.a());
        }
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void r(InterfaceC18096o47 interfaceC18096o47) {
        Objects.requireNonNull(this.f);
        e();
        this.b.i(this);
        this.f.r(interfaceC18096o47);
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void s(InterfaceC18096o47 interfaceC18096o47) {
        Objects.requireNonNull(this.f);
        this.b.j(this);
        this.f.s(interfaceC18096o47);
    }

    @Override // ir.nasim.InterfaceC18096o47.a
    public boolean stop() {
        boolean z;
        try {
            synchronized (this.a) {
                try {
                    if (!this.m) {
                        InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = this.j;
                        interfaceFutureC15215jC3 = interfaceFutureC15215jC3 != null ? interfaceFutureC15215jC3 : null;
                        this.m = true;
                    }
                    z = !D();
                } finally {
                }
            }
            return z;
        } finally {
            if (interfaceFutureC15215jC3 != null) {
                interfaceFutureC15215jC3.cancel(true);
            }
        }
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void t(InterfaceC18096o47 interfaceC18096o47) {
        Objects.requireNonNull(this.f);
        this.f.t(interfaceC18096o47);
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    void u(final InterfaceC18096o47 interfaceC18096o47) {
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3;
        synchronized (this.a) {
            try {
                if (this.n) {
                    interfaceFutureC15215jC3 = null;
                } else {
                    this.n = true;
                    AbstractC4980Hj5.h(this.h, "Need to call openCaptureSession before using this API.");
                    interfaceFutureC15215jC3 = this.h;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (interfaceFutureC15215jC3 != null) {
            interfaceFutureC15215jC3.j(new Runnable() { // from class: ir.nasim.r47
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.G(interfaceC18096o47);
                }
            }, AbstractC20567sE0.a());
        }
    }

    @Override // ir.nasim.InterfaceC18096o47.c
    public void v(InterfaceC18096o47 interfaceC18096o47, Surface surface) {
        Objects.requireNonNull(this.f);
        this.f.v(interfaceC18096o47, surface);
    }

    @Override // ir.nasim.InterfaceC18096o47
    public InterfaceC18096o47.c c() {
        return this;
    }

    /* renamed from: ir.nasim.u47$a */
    class a implements MB2 {
        a() {
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            AbstractC21755u47.this.e();
            AbstractC21755u47 abstractC21755u47 = AbstractC21755u47.this;
            abstractC21755u47.b.i(abstractC21755u47);
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
        }
    }

    @Override // ir.nasim.InterfaceC18096o47
    public void g(int i) {
    }
}
