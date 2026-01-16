package ir.nasim;

import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Ye2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C9028Ye2 {
    private final ExtraSupportedSurfaceCombinationsQuirk a = (ExtraSupportedSurfaceCombinationsQuirk) androidx.camera.camera2.internal.compat.quirk.b.b(ExtraSupportedSurfaceCombinationsQuirk.class);

    public List a(String str) {
        ExtraSupportedSurfaceCombinationsQuirk extraSupportedSurfaceCombinationsQuirk = this.a;
        return extraSupportedSurfaceCombinationsQuirk == null ? new ArrayList() : extraSupportedSurfaceCombinationsQuirk.e(str);
    }
}
