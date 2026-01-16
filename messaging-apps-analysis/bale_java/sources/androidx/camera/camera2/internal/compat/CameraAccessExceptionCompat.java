package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class CameraAccessExceptionCompat extends Exception {
    static final Set c = Collections.unmodifiableSet(new HashSet(Arrays.asList(4, 5, 1, 2, 3)));
    static final Set d = Collections.unmodifiableSet(new HashSet(Arrays.asList(10001, 10002)));
    private final int a;
    private final CameraAccessException b;

    public CameraAccessExceptionCompat(int i, String str, Throwable th) {
        super(a(i, str), th);
        this.a = i;
        this.b = c.contains(Integer.valueOf(i)) ? new CameraAccessException(i, str, th) : null;
    }

    private static String a(int i, String str) {
        return String.format("%s (%d): %s", c(i), Integer.valueOf(i), str);
    }

    private static String b(int i) {
        if (i == 1) {
            return "The camera is disabled due to a device policy, and cannot be opened.";
        }
        if (i == 2) {
            return "The camera device is removable and has been disconnected from the Android device, or the camera service has shut down the connection due to a higher-priority access request for the camera device.";
        }
        if (i == 3) {
            return "The camera device is currently in the error state; no further calls to it will succeed.";
        }
        if (i == 4) {
            return "The camera device is in use already";
        }
        if (i == 5) {
            return "The system-wide limit for number of open cameras has been reached, and more camera devices cannot be opened until previous instances are closed.";
        }
        if (i == 10001) {
            return "Some API 28 devices cannot access the camera when the device is in \"Do Not Disturb\" mode. The camera will not be accessible until \"Do Not Disturb\" mode is disabled.";
        }
        if (i != 10002) {
            return null;
        }
        return "Failed to create CameraCharacteristics.";
    }

    private static String c(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 1000 ? i != 10001 ? i != 10002 ? "<UNKNOWN ERROR>" : "CAMERA_CHARACTERISTICS_CREATION_ERROR" : "CAMERA_UNAVAILABLE_DO_NOT_DISTURB" : "CAMERA_DEPRECATED_HAL" : "MAX_CAMERAS_IN_USE" : "CAMERA_IN_USE" : "CAMERA_ERROR" : "CAMERA_DISCONNECTED" : "CAMERA_DISABLED";
    }

    public static CameraAccessExceptionCompat e(CameraAccessException cameraAccessException) {
        if (cameraAccessException != null) {
            return new CameraAccessExceptionCompat(cameraAccessException);
        }
        throw new NullPointerException("cameraAccessException should not be null");
    }

    public final int d() {
        return this.a;
    }

    public CameraAccessExceptionCompat(int i, Throwable th) {
        super(b(i), th);
        this.a = i;
        this.b = c.contains(Integer.valueOf(i)) ? new CameraAccessException(i, null, th) : null;
    }

    private CameraAccessExceptionCompat(CameraAccessException cameraAccessException) {
        super(cameraAccessException.getMessage(), cameraAccessException.getCause());
        this.a = cameraAccessException.getReason();
        this.b = cameraAccessException;
    }
}
