package ir.nasim;

import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.j;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.BB0;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class DA0 {
    private final PA0 c;
    final Executor d;
    AbstractC16967mA0.a g;
    private boolean a = false;
    private boolean b = false;
    final Object e = new Object();
    private BB0.a f = new BB0.a();

    public DA0(PA0 pa0, Executor executor) {
        this.c = pa0;
        this.d = executor;
    }

    private void h(VF0 vf0) {
        synchronized (this.e) {
            this.f.d(vf0);
        }
    }

    private void k() {
        synchronized (this.e) {
            this.f = new BB0.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        AbstractC16967mA0.a aVar = this.g;
        if (aVar != null) {
            aVar.c(null);
            this.g = null;
        }
    }

    private void m(Exception exc) {
        AbstractC16967mA0.a aVar = this.g;
        if (aVar != null) {
            if (exc == null) {
                exc = new Exception("Camera2CameraControl failed with unknown error.");
            }
            aVar.f(exc);
            this.g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p(final AbstractC16967mA0.a aVar) {
        this.d.execute(new Runnable() { // from class: ir.nasim.CA0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o(aVar);
            }
        });
        return "addCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(final AbstractC16967mA0.a aVar) {
        this.d.execute(new Runnable() { // from class: ir.nasim.AA0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.q(aVar);
            }
        });
        return "clearCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void s(boolean z) {
        if (this.a == z) {
            return;
        }
        this.a = z;
        if (!z) {
            m(new CameraControl$OperationCanceledException("The camera control has became inactive."));
        } else if (this.b) {
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void q(AbstractC16967mA0.a aVar) {
        this.b = true;
        m(new CameraControl$OperationCanceledException("Camera2CameraControl was updated with new options."));
        this.g = aVar;
        if (this.a) {
            w();
        }
    }

    private void w() {
        this.c.W().j(new Runnable() { // from class: ir.nasim.BA0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l();
            }
        }, this.d);
        this.b = false;
    }

    public InterfaceFutureC15215jC3 g(VF0 vf0) {
        h(vf0);
        return WB2.t(AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.xA0
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.p(aVar);
            }
        }));
    }

    public void i(BB0.a aVar) {
        synchronized (this.e) {
            aVar.e(this.f.a(), j.c.ALWAYS_OVERRIDE);
        }
    }

    public InterfaceFutureC15215jC3 j() {
        k();
        return WB2.t(AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.zA0
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.r(aVar);
            }
        }));
    }

    public BB0 n() {
        BB0 bb0C;
        synchronized (this.e) {
            bb0C = this.f.c();
        }
        return bb0C;
    }

    public void t(final boolean z) {
        this.d.execute(new Runnable() { // from class: ir.nasim.yA0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s(z);
            }
        });
    }
}
