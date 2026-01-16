package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b {
    static List a(t tVar) {
        ArrayList arrayList = new ArrayList();
        if (tVar.a(ImageCaptureRotationOptionQuirk.class, ImageCaptureRotationOptionQuirk.h())) {
            arrayList.add(new ImageCaptureRotationOptionQuirk());
        }
        if (tVar.a(SurfaceOrderQuirk.class, SurfaceOrderQuirk.c())) {
            arrayList.add(new SurfaceOrderQuirk());
        }
        if (tVar.a(CaptureFailedRetryQuirk.class, CaptureFailedRetryQuirk.c())) {
            arrayList.add(new CaptureFailedRetryQuirk());
        }
        if (tVar.a(LowMemoryQuirk.class, LowMemoryQuirk.c())) {
            arrayList.add(new LowMemoryQuirk());
        }
        if (tVar.a(LargeJpegImageQuirk.class, LargeJpegImageQuirk.f())) {
            arrayList.add(new LargeJpegImageQuirk());
        }
        if (tVar.a(IncorrectJpegMetadataQuirk.class, IncorrectJpegMetadataQuirk.g())) {
            arrayList.add(new IncorrectJpegMetadataQuirk());
        }
        return arrayList;
    }
}
