package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;

/* renamed from: ir.nasim.jV7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC15390jV7 {
    public static boolean a(C19349qC0 c19349qC0) {
        int[] iArr;
        if (Build.VERSION.SDK_INT >= 33 && (iArr = (int[]) c19349qC0.a(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) != null && iArr.length != 0) {
            for (int i : iArr) {
                if (i == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
