package androidx.camera.camera2.internal.compat.quirk;

import android.hardware.camera2.CameraCharacteristics;
import ir.nasim.C19349qC0;
import ir.nasim.InterfaceC5592Jz5;
import ir.nasim.PX6;
import java.util.List;

/* loaded from: classes.dex */
public class CamcorderProfileResolutionQuirk implements InterfaceC5592Jz5 {
    private final PX6 a;
    private List b = null;

    public CamcorderProfileResolutionQuirk(C19349qC0 c19349qC0) {
        this.a = c19349qC0.b();
    }

    static boolean c(C19349qC0 c19349qC0) {
        Integer num = (Integer) c19349qC0.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }
}
