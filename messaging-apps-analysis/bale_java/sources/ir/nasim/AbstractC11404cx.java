package ir.nasim;

import android.hardware.camera2.CameraManager;

/* renamed from: ir.nasim.cx, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC11404cx {
    public static void a(CameraManager.AvailabilityCallback availabilityCallback) {
        availabilityCallback.onCameraAccessPrioritiesChanged();
    }
}
