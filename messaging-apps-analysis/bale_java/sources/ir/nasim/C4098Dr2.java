package ir.nasim;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.util.Rational;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.impl.i;
import androidx.camera.core.impl.j;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.BB0;
import ir.nasim.PA0;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* renamed from: ir.nasim.Dr2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C4098Dr2 {
    private static final MeteringRectangle[] x = new MeteringRectangle[0];
    private final PA0 a;
    final Executor b;
    private final ScheduledExecutorService c;
    private final C4451Fe4 f;
    private ScheduledFuture i;
    private ScheduledFuture j;
    private MeteringRectangle[] q;
    private MeteringRectangle[] r;
    private MeteringRectangle[] s;
    AbstractC16967mA0.a t;
    AbstractC16967mA0.a u;
    private boolean v;
    private PA0.c w;
    private volatile boolean d = false;
    private volatile Rational e = null;
    private boolean g = false;
    Integer h = 0;
    long k = 0;
    boolean l = false;
    boolean m = false;
    private int n = 1;
    private PA0.c o = null;
    private PA0.c p = null;

    C4098Dr2(PA0 pa0, ScheduledExecutorService scheduledExecutorService, Executor executor, C6293Mz5 c6293Mz5) {
        MeteringRectangle[] meteringRectangleArr = x;
        this.q = meteringRectangleArr;
        this.r = meteringRectangleArr;
        this.s = meteringRectangleArr;
        this.t = null;
        this.u = null;
        this.v = false;
        this.w = null;
        this.a = pa0;
        this.b = executor;
        this.c = scheduledExecutorService;
        this.f = new C4451Fe4(c6293Mz5);
    }

    private void f() {
        ScheduledFuture scheduledFuture = this.j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.j = null;
        }
    }

    private void g() {
        AbstractC16967mA0.a aVar = this.u;
        if (aVar != null) {
            aVar.c(null);
            this.u = null;
        }
    }

    private void h() {
        ScheduledFuture scheduledFuture = this.i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.i = null;
        }
    }

    private void i(String str) {
        this.a.O(this.o);
        AbstractC16967mA0.a aVar = this.t;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException(str));
            this.t = null;
        }
    }

    private void j(String str) {
        this.a.O(this.p);
        AbstractC16967mA0.a aVar = this.u;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException(str));
            this.u = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean m(int i, long j, TotalCaptureResult totalCaptureResult) {
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)).intValue() != i || !PA0.F(totalCaptureResult, j)) {
            return false;
        }
        g();
        return true;
    }

    private boolean q() {
        return this.q.length > 0;
    }

    void b(BB0.a aVar) {
        int iK = this.g ? 1 : k();
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_MODE;
        Object objValueOf = Integer.valueOf(this.a.x(iK));
        j.c cVar = j.c.REQUIRED;
        aVar.g(key, objValueOf, cVar);
        MeteringRectangle[] meteringRectangleArr = this.q;
        if (meteringRectangleArr.length != 0) {
            aVar.g(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr, cVar);
        }
        MeteringRectangle[] meteringRectangleArr2 = this.r;
        if (meteringRectangleArr2.length != 0) {
            aVar.g(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2, cVar);
        }
        MeteringRectangle[] meteringRectangleArr3 = this.s;
        if (meteringRectangleArr3.length != 0) {
            aVar.g(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr3, cVar);
        }
    }

    void c(boolean z, boolean z2) {
        if (this.d) {
            i.a aVar = new i.a();
            aVar.s(true);
            aVar.r(this.n);
            BB0.a aVar2 = new BB0.a();
            if (z) {
                aVar2.f(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            }
            if (z2) {
                aVar2.f(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
            }
            aVar.e(aVar2.c());
            this.a.V(Collections.singletonList(aVar.h()));
        }
    }

    void d(AbstractC16967mA0.a aVar) {
        j("Cancelled by another cancelFocusAndMetering()");
        i("Cancelled by cancelFocusAndMetering()");
        this.u = aVar;
        h();
        f();
        if (q()) {
            c(true, false);
        }
        MeteringRectangle[] meteringRectangleArr = x;
        this.q = meteringRectangleArr;
        this.r = meteringRectangleArr;
        this.s = meteringRectangleArr;
        this.g = false;
        final long jX = this.a.X();
        if (this.u != null) {
            final int iX = this.a.x(k());
            PA0.c cVar = new PA0.c() { // from class: ir.nasim.Cr2
                @Override // ir.nasim.PA0.c
                public final boolean a(TotalCaptureResult totalCaptureResult) {
                    return this.a.m(iX, jX, totalCaptureResult);
                }
            };
            this.p = cVar;
            this.a.p(cVar);
        }
    }

    void e() {
        d(null);
    }

    int k() {
        return this.n != 3 ? 4 : 3;
    }

    boolean l() {
        return this.v;
    }

    void n(boolean z) {
        if (z == this.d) {
            return;
        }
        this.d = z;
        if (this.d) {
            return;
        }
        e();
    }

    public void o(Rational rational) {
        this.e = rational;
    }

    void p(int i) {
        this.n = i;
    }
}
