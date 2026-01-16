package ir.nasim;

import androidx.camera.camera2.internal.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.internal.compat.quirk.Nexus4AndroidLTargetAspectRatioQuirk;

/* renamed from: ir.nasim.wj7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C23325wj7 {
    public int a(String str, C19349qC0 c19349qC0) {
        Nexus4AndroidLTargetAspectRatioQuirk nexus4AndroidLTargetAspectRatioQuirk = (Nexus4AndroidLTargetAspectRatioQuirk) androidx.camera.camera2.internal.compat.quirk.b.b(Nexus4AndroidLTargetAspectRatioQuirk.class);
        if (nexus4AndroidLTargetAspectRatioQuirk != null) {
            return nexus4AndroidLTargetAspectRatioQuirk.c();
        }
        AspectRatioLegacyApi21Quirk aspectRatioLegacyApi21Quirk = (AspectRatioLegacyApi21Quirk) androidx.camera.camera2.internal.compat.quirk.a.a(str, c19349qC0).b(AspectRatioLegacyApi21Quirk.class);
        if (aspectRatioLegacyApi21Quirk != null) {
            return aspectRatioLegacyApi21Quirk.c();
        }
        return 3;
    }
}
