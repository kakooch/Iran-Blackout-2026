package ir.nasim;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.CameraControl$OperationCanceledException;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.PA0;
import java.util.Objects;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.gt7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C13834gt7 {
    private final PA0 a;
    private final C20298rm4 b;
    private final boolean c;
    private final Executor d;
    private boolean e;
    AbstractC16967mA0.a f;
    boolean g;

    C13834gt7(PA0 pa0, C19349qC0 c19349qC0, Executor executor) {
        this.a = pa0;
        this.d = executor;
        Objects.requireNonNull(c19349qC0);
        this.c = AbstractC5265Ip2.a(new C20540sB0(c19349qC0));
        this.b = new C20298rm4(0);
        pa0.p(new PA0.c() { // from class: ir.nasim.ft7
            @Override // ir.nasim.PA0.c
            public final boolean a(TotalCaptureResult totalCaptureResult) {
                return this.a.c(totalCaptureResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c(TotalCaptureResult totalCaptureResult) {
        if (this.f != null) {
            Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
            if ((num != null && num.intValue() == 2) == this.g) {
                this.f.c(null);
                this.f = null;
            }
        }
        return false;
    }

    private void e(C20298rm4 c20298rm4, Object obj) {
        if (AbstractC17949np7.c()) {
            c20298rm4.p(obj);
        } else {
            c20298rm4.n(obj);
        }
    }

    androidx.lifecycle.r b() {
        return this.b;
    }

    void d(boolean z) {
        if (this.e == z) {
            return;
        }
        this.e = z;
        if (z) {
            return;
        }
        if (this.g) {
            this.g = false;
            this.a.s(false);
            e(this.b, 0);
        }
        AbstractC16967mA0.a aVar = this.f;
        if (aVar != null) {
            aVar.f(new CameraControl$OperationCanceledException("Camera is not active."));
            this.f = null;
        }
    }
}
