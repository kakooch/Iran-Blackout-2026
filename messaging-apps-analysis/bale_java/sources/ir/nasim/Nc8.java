package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Looper;
import android.util.Range;
import ir.nasim.BB0;
import ir.nasim.PA0;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class Nc8 {
    private final PA0 a;
    private final Executor b;
    private final Rc8 c;
    private final C20298rm4 d;
    final b e;
    private boolean f = false;
    private PA0.c g = new a();

    class a implements PA0.c {
        a() {
        }

        @Override // ir.nasim.PA0.c
        public boolean a(TotalCaptureResult totalCaptureResult) {
            Nc8.this.e.a(totalCaptureResult);
            return false;
        }
    }

    interface b {
        void a(TotalCaptureResult totalCaptureResult);

        float b();

        void c();

        void d(BB0.a aVar);

        float e();
    }

    Nc8(PA0 pa0, C19349qC0 c19349qC0, Executor executor) {
        this.a = pa0;
        this.b = executor;
        b bVarB = b(c19349qC0);
        this.e = bVarB;
        Rc8 rc8 = new Rc8(bVarB.e(), bVarB.b());
        this.c = rc8;
        rc8.f(1.0f);
        this.d = new C20298rm4(AbstractC15728k43.e(rc8));
        pa0.p(this.g);
    }

    private static b b(C19349qC0 c19349qC0) {
        return e(c19349qC0) ? new C7890Tq(c19349qC0) : new C22839vu1(c19349qC0);
    }

    private static Range c(C19349qC0 c19349qC0) {
        try {
            return (Range) c19349qC0.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        } catch (AssertionError e) {
            PI3.m("ZoomControl", "AssertionError, fail to get camera characteristic.", e);
            return null;
        }
    }

    static boolean e(C19349qC0 c19349qC0) {
        return Build.VERSION.SDK_INT >= 30 && c(c19349qC0) != null;
    }

    private void g(Qc8 qc8) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.d.p(qc8);
        } else {
            this.d.n(qc8);
        }
    }

    void a(BB0.a aVar) {
        this.e.d(aVar);
    }

    androidx.lifecycle.r d() {
        return this.d;
    }

    void f(boolean z) {
        Qc8 qc8E;
        if (this.f == z) {
            return;
        }
        this.f = z;
        if (z) {
            return;
        }
        synchronized (this.c) {
            this.c.f(1.0f);
            qc8E = AbstractC15728k43.e(this.c);
        }
        g(qc8E);
        this.e.c();
        this.a.X();
    }
}
