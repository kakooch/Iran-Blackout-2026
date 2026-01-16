package ir.nasim;

import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.lifecycle.j;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.fz3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C13296fz3 implements InterfaceC18042nz3, HB0 {
    private final InterfaceC18633oz3 b;
    private final CameraUseCaseAdapter c;
    private final Object a = new Object();
    private volatile boolean d = false;
    private boolean e = false;
    private boolean f = false;

    C13296fz3(InterfaceC18633oz3 interfaceC18633oz3, CameraUseCaseAdapter cameraUseCaseAdapter) {
        this.b = interfaceC18633oz3;
        this.c = cameraUseCaseAdapter;
        if (interfaceC18633oz3.getLifecycle().b().j(j.b.STARTED)) {
            cameraUseCaseAdapter.k();
        } else {
            cameraUseCaseAdapter.z();
        }
        interfaceC18633oz3.getLifecycle().a(this);
    }

    @Override // ir.nasim.HB0
    public InterfaceC14021hD0 a() {
        return this.c.a();
    }

    void f(Collection collection) {
        synchronized (this.a) {
            this.c.g(collection);
        }
    }

    public CameraUseCaseAdapter g() {
        return this.c;
    }

    @androidx.lifecycle.t(j.a.ON_DESTROY)
    public void onDestroy(InterfaceC18633oz3 interfaceC18633oz3) {
        synchronized (this.a) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.c;
            cameraUseCaseAdapter.Y(cameraUseCaseAdapter.I());
        }
    }

    @androidx.lifecycle.t(j.a.ON_PAUSE)
    public void onPause(InterfaceC18633oz3 interfaceC18633oz3) {
        this.c.e(false);
    }

    @androidx.lifecycle.t(j.a.ON_RESUME)
    public void onResume(InterfaceC18633oz3 interfaceC18633oz3) {
        this.c.e(true);
    }

    @androidx.lifecycle.t(j.a.ON_START)
    public void onStart(InterfaceC18633oz3 interfaceC18633oz3) {
        synchronized (this.a) {
            try {
                if (!this.e && !this.f) {
                    this.c.k();
                    this.d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @androidx.lifecycle.t(j.a.ON_STOP)
    public void onStop(InterfaceC18633oz3 interfaceC18633oz3) {
        synchronized (this.a) {
            try {
                if (!this.e && !this.f) {
                    this.c.z();
                    this.d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public InterfaceC18633oz3 r() {
        InterfaceC18633oz3 interfaceC18633oz3;
        synchronized (this.a) {
            interfaceC18633oz3 = this.b;
        }
        return interfaceC18633oz3;
    }

    InterfaceC14021hD0 t() {
        return this.c.F();
    }

    public List u() {
        List listUnmodifiableList;
        synchronized (this.a) {
            listUnmodifiableList = Collections.unmodifiableList(this.c.I());
        }
        return listUnmodifiableList;
    }

    public boolean v(AbstractC15273jI7 abstractC15273jI7) {
        boolean zContains;
        synchronized (this.a) {
            zContains = this.c.I().contains(abstractC15273jI7);
        }
        return zContains;
    }

    public void w() {
        synchronized (this.a) {
            try {
                if (this.e) {
                    return;
                }
                onStop(this.b);
                this.e = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void x() {
        synchronized (this.a) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.c;
            cameraUseCaseAdapter.Y(cameraUseCaseAdapter.I());
        }
    }

    public void z() {
        synchronized (this.a) {
            try {
                if (this.e) {
                    this.e = false;
                    if (this.b.getLifecycle().b().j(j.b.STARTED)) {
                        onStart(this.b);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
