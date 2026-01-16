package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import ir.nasim.CD0;
import ir.nasim.ED0;
import ir.nasim.PI3;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public abstract class CameraValidator {
    private static final ED0 a = new ED0.a().b(2).a();

    public static class CameraIdListIncorrectException extends Exception {
        private int a;

        public CameraIdListIncorrectException(String str, int i, Throwable th) {
            super(str, th);
            this.a = i;
        }

        public int a() {
            return this.a;
        }
    }

    private static class a {
        static int a(Context context) {
            return context.getDeviceId();
        }
    }

    public static void a(Context context, CD0 cd0, ED0 ed0) throws CameraIdListIncorrectException {
        Integer numD;
        int i = 0;
        IllegalArgumentException illegalArgumentException = null;
        if (Build.VERSION.SDK_INT >= 34 && a.a(context) != 0) {
            LinkedHashSet linkedHashSetA = cd0.a();
            if (linkedHashSetA.isEmpty()) {
                throw new CameraIdListIncorrectException("No cameras available", 0, null);
            }
            PI3.a("CameraValidator", "Virtual device with ID: " + a.a(context) + " has " + linkedHashSetA.size() + " cameras. Skipping validation.");
            return;
        }
        if (ed0 != null) {
            try {
                numD = ed0.d();
                if (numD == null) {
                    PI3.l("CameraValidator", "No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                    return;
                }
            } catch (IllegalStateException e) {
                PI3.d("CameraValidator", "Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", e);
                return;
            }
        } else {
            numD = null;
        }
        PI3.a("CameraValidator", "Verifying camera lens facing on " + Build.DEVICE + ", lensFacingInteger: " + numD);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera") && (ed0 == null || numD.intValue() == 1)) {
                ED0.d.e(cd0.a());
                i = 1;
            }
        } catch (IllegalArgumentException e2) {
            illegalArgumentException = e2;
            PI3.m("CameraValidator", "Camera LENS_FACING_BACK verification failed", illegalArgumentException);
        }
        try {
            if (packageManager.hasSystemFeature("android.hardware.camera.front") && (ed0 == null || numD.intValue() == 0)) {
                ED0.c.e(cd0.a());
                i++;
            }
        } catch (IllegalArgumentException e3) {
            illegalArgumentException = e3;
            PI3.m("CameraValidator", "Camera LENS_FACING_FRONT verification failed", illegalArgumentException);
        }
        try {
            a.e(cd0.a());
            PI3.a("CameraValidator", "Found a LENS_FACING_EXTERNAL camera");
            i++;
        } catch (IllegalArgumentException unused) {
        }
        if (illegalArgumentException == null) {
            return;
        }
        PI3.c("CameraValidator", "Camera LensFacing verification failed, existing cameras: " + cd0.a());
        throw new CameraIdListIncorrectException("Expected camera missing from device.", i, illegalArgumentException);
    }
}
