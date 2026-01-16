package ir.nasim;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.Set;

/* renamed from: ir.nasim.qD0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C19358qD0 extends C18767pD0 {
    C19358qD0(Context context) {
        super(context);
    }

    @Override // ir.nasim.C19949rD0, ir.nasim.C17585nD0.b
    public Set c() throws CameraAccessExceptionCompat {
        try {
            return this.a.getConcurrentCameraIds();
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.e(e);
        }
    }
}
