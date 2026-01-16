package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import java.util.Set;

/* renamed from: ir.nasim.q22, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19253q22 {
    private final a a;

    /* renamed from: ir.nasim.q22$a */
    interface a {
        DynamicRangeProfiles a();

        Set b(C15116j22 c15116j22);

        Set c();
    }

    C19253q22(a aVar) {
        this.a = aVar;
    }

    public static C19253q22 a(C19349qC0 c19349qC0) {
        C19253q22 c19253q22E = Build.VERSION.SDK_INT >= 33 ? e(AbstractC18662p22.a(c19349qC0.a(CameraCharacteristics.REQUEST_AVAILABLE_DYNAMIC_RANGE_PROFILES))) : null;
        return c19253q22E == null ? C20453s22.a : c19253q22E;
    }

    public static C19253q22 e(DynamicRangeProfiles dynamicRangeProfiles) {
        if (dynamicRangeProfiles == null) {
            return null;
        }
        AbstractC4980Hj5.j(Build.VERSION.SDK_INT >= 33, "DynamicRangeProfiles can only be converted to DynamicRangesCompat on API 33 or higher.");
        return new C19253q22(new C19844r22(dynamicRangeProfiles));
    }

    public Set b(C15116j22 c15116j22) {
        return this.a.b(c15116j22);
    }

    public Set c() {
        return this.a.c();
    }

    public DynamicRangeProfiles d() {
        AbstractC4980Hj5.j(Build.VERSION.SDK_INT >= 33, "DynamicRangesCompat can only be converted to DynamicRangeProfiles on API 33 or higher.");
        return this.a.a();
    }
}
