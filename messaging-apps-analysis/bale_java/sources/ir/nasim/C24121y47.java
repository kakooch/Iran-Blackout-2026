package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.quirk.IncorrectCaptureStateQuirk;
import androidx.camera.core.impl.DeferrableSurface;
import ir.nasim.C8397Vu2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.y47, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C24121y47 extends AbstractC21755u47 {
    private final ScheduledExecutorService o;
    private final Object p;
    private List q;
    InterfaceFutureC15215jC3 r;
    private final C8631Wu2 s;
    private final C8397Vu2 t;
    private final C17743nU5 u;
    private final C12616eu6 v;
    private final AtomicBoolean w;

    C24121y47(C6293Mz5 c6293Mz5, C6293Mz5 c6293Mz52, C15248jG0 c15248jG0, Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler) {
        super(c15248jG0, executor, scheduledExecutorService, handler);
        this.p = new Object();
        this.w = new AtomicBoolean(false);
        this.s = new C8631Wu2(c6293Mz5, c6293Mz52);
        this.u = new C17743nU5(c6293Mz5.a(CaptureSessionStuckQuirk.class) || c6293Mz5.a(IncorrectCaptureStateQuirk.class));
        this.t = new C8397Vu2(c6293Mz52);
        this.v = new C12616eu6(c6293Mz52);
        this.o = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        O("Session call super.close()");
        super.close();
    }

    private void N() {
        Iterator it = this.b.d().iterator();
        while (it.hasNext()) {
            ((InterfaceC18096o47) it.next()).close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(InterfaceC18096o47 interfaceC18096o47) {
        super.s(interfaceC18096o47);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InterfaceFutureC15215jC3 Q(CameraDevice cameraDevice, C8626Wt6 c8626Wt6, List list, List list2) {
        if (this.v.a()) {
            N();
        }
        O("start openCaptureSession");
        return super.f(cameraDevice, c8626Wt6, list);
    }

    void O(String str) {
        PI3.a("SyncCaptureSessionImpl", "[" + this + "] " + str);
    }

    @Override // ir.nasim.AbstractC21755u47, ir.nasim.InterfaceC18096o47
    public void close() {
        if (!this.w.compareAndSet(false, true)) {
            O("close() has been called. Skip this invocation.");
            return;
        }
        if (this.v.a()) {
            try {
                O("Call abortCaptures() before closing session.");
                a();
            } catch (Exception e) {
                O("Exception when calling abortCaptures()" + e);
            }
        }
        O("Session call close()");
        this.u.e().j(new Runnable() { // from class: ir.nasim.w47
            @Override // java.lang.Runnable
            public final void run() {
                this.a.E();
            }
        }, b());
    }

    @Override // ir.nasim.AbstractC21755u47, ir.nasim.InterfaceC18096o47
    public void e() {
        super.e();
        this.u.i();
    }

    @Override // ir.nasim.AbstractC21755u47, ir.nasim.InterfaceC18096o47.a
    public InterfaceFutureC15215jC3 f(final CameraDevice cameraDevice, final C8626Wt6 c8626Wt6, final List list) {
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3T;
        synchronized (this.p) {
            try {
                List listD = this.b.d();
                ArrayList arrayList = new ArrayList();
                Iterator it = listD.iterator();
                while (it.hasNext()) {
                    arrayList.add(((InterfaceC18096o47) it.next()).n());
                }
                InterfaceFutureC15215jC3 interfaceFutureC15215jC3X = WB2.x(arrayList);
                this.r = interfaceFutureC15215jC3X;
                interfaceFutureC15215jC3T = WB2.t(NB2.a(interfaceFutureC15215jC3X).e(new FK() { // from class: ir.nasim.x47
                    @Override // ir.nasim.FK
                    public final InterfaceFutureC15215jC3 apply(Object obj) {
                        return this.a.Q(cameraDevice, c8626Wt6, list, (List) obj);
                    }
                }, b()));
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceFutureC15215jC3T;
    }

    @Override // ir.nasim.AbstractC21755u47, ir.nasim.InterfaceC18096o47
    public void g(int i) {
        super.g(i);
        if (i == 5) {
            synchronized (this.p) {
                try {
                    if (D() && this.q != null) {
                        O("Close DeferrableSurfaces for CameraDevice error.");
                        Iterator it = this.q.iterator();
                        while (it.hasNext()) {
                            ((DeferrableSurface) it.next()).d();
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // ir.nasim.AbstractC21755u47, ir.nasim.InterfaceC18096o47
    public int i(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        return super.i(captureRequest, this.u.d(captureCallback));
    }

    @Override // ir.nasim.AbstractC21755u47, ir.nasim.InterfaceC18096o47.a
    public InterfaceFutureC15215jC3 j(List list, long j) {
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3J;
        synchronized (this.p) {
            this.q = list;
            interfaceFutureC15215jC3J = super.j(list, j);
        }
        return interfaceFutureC15215jC3J;
    }

    @Override // ir.nasim.AbstractC21755u47, ir.nasim.InterfaceC18096o47
    public int l(List list, CameraCaptureSession.CaptureCallback captureCallback) {
        return super.l(list, this.u.d(captureCallback));
    }

    @Override // ir.nasim.InterfaceC18096o47
    public InterfaceFutureC15215jC3 n() {
        return WB2.s(1500L, this.o, this.u.e());
    }

    @Override // ir.nasim.AbstractC21755u47, ir.nasim.InterfaceC18096o47.c
    public void q(InterfaceC18096o47 interfaceC18096o47) {
        synchronized (this.p) {
            this.s.a(this.q);
        }
        O("onClosed()");
        super.q(interfaceC18096o47);
    }

    @Override // ir.nasim.AbstractC21755u47, ir.nasim.InterfaceC18096o47.c
    public void s(InterfaceC18096o47 interfaceC18096o47) {
        O("Session onConfigured()");
        this.t.c(interfaceC18096o47, this.b.e(), this.b.d(), new C8397Vu2.a() { // from class: ir.nasim.v47
            @Override // ir.nasim.C8397Vu2.a
            public final void a(InterfaceC18096o47 interfaceC18096o472) {
                this.a.P(interfaceC18096o472);
            }
        });
    }

    @Override // ir.nasim.AbstractC21755u47, ir.nasim.InterfaceC18096o47.a
    public boolean stop() {
        boolean zStop;
        synchronized (this.p) {
            try {
                if (D()) {
                    this.s.a(this.q);
                } else {
                    InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = this.r;
                    if (interfaceFutureC15215jC3 != null) {
                        interfaceFutureC15215jC3.cancel(true);
                    }
                }
                zStop = super.stop();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zStop;
    }
}
