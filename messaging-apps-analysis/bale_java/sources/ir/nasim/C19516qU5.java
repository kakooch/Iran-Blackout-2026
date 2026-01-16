package ir.nasim;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.impl.j;

/* renamed from: ir.nasim.qU5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C19516qU5 implements androidx.camera.core.impl.u {
    private androidx.camera.core.impl.j H;

    /* renamed from: ir.nasim.qU5$b */
    public static class b {
        private androidx.camera.core.impl.q a = androidx.camera.core.impl.q.Z();

        public C19516qU5 a() {
            return new C19516qU5(androidx.camera.core.impl.r.X(this.a));
        }

        public b b(CaptureRequest.Key key, Object obj) {
            this.a.p(C19516qU5.V(key), obj);
            return this;
        }
    }

    static j.a V(CaptureRequest.Key key) {
        return j.a.b("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }

    @Override // androidx.camera.core.impl.u
    public androidx.camera.core.impl.j getConfig() {
        return this.H;
    }

    private C19516qU5(androidx.camera.core.impl.j jVar) {
        this.H = jVar;
    }
}
