package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;
import ir.nasim.C19349qC0;

/* renamed from: ir.nasim.oC0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C18167oC0 implements C19349qC0.a {
    protected final CameraCharacteristics a;

    C18167oC0(CameraCharacteristics cameraCharacteristics) {
        this.a = cameraCharacteristics;
    }

    @Override // ir.nasim.C19349qC0.a
    public Object a(CameraCharacteristics.Key key) {
        return this.a.get(key);
    }
}
