package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;

/* loaded from: classes.dex */
abstract class Yc8 {
    public static boolean a(C19349qC0 c19349qC0, int i) {
        int[] iArr = (int[]) c19349qC0.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }
}
