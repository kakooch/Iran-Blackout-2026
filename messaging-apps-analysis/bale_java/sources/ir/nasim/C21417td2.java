package ir.nasim;

import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;
import androidx.camera.core.internal.utils.ImageUtil;

/* renamed from: ir.nasim.td2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C21417td2 {
    public boolean a() {
        ImageCaptureRotationOptionQuirk imageCaptureRotationOptionQuirk = (ImageCaptureRotationOptionQuirk) androidx.camera.core.internal.compat.quirk.a.b(ImageCaptureRotationOptionQuirk.class);
        return imageCaptureRotationOptionQuirk == null || imageCaptureRotationOptionQuirk.g(androidx.camera.core.impl.i.i);
    }

    public boolean b(androidx.camera.core.f fVar) {
        return a() && ImageUtil.g(fVar.C());
    }
}
