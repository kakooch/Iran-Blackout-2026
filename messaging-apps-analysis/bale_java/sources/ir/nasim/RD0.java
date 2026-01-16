package ir.nasim;

import android.hardware.Camera;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class RD0 {
    public static Camera a(int i) {
        try {
            return i == -1 ? Camera.open() : Camera.open(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int b() {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i >= numberOfCameras) {
                return i4;
            }
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                return i;
            }
            i2 = i + 1;
        }
    }

    public static boolean c(Camera camera) {
        List<String> supportedFlashModes;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.getFlashMode() != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && !supportedFlashModes.isEmpty() && (supportedFlashModes.size() != 1 || !supportedFlashModes.get(0).equals("off"))) {
                return true;
            }
        }
        return false;
    }
}
