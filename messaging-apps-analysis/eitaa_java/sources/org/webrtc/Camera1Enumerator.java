package org.webrtc;

import android.hardware.Camera;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraVideoCapturer;

/* loaded from: classes3.dex */
public class Camera1Enumerator implements CameraEnumerator {
    private static final String TAG = "Camera1Enumerator";
    private static List<List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats;
    private final boolean captureToTexture;

    public Camera1Enumerator() {
        this(true);
    }

    public Camera1Enumerator(boolean captureToTexture) {
        this.captureToTexture = captureToTexture;
    }

    @Override // org.webrtc.CameraEnumerator
    public String[] getDeviceNames() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            String deviceName = getDeviceName(i);
            if (deviceName != null) {
                arrayList.add(deviceName);
                Logging.d(TAG, "Index: " + i + ". " + deviceName);
            } else {
                Logging.e(TAG, "Index: " + i + ". Failed to query camera name.");
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isFrontFacing(String deviceName) {
        Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(deviceName));
        return cameraInfo != null && cameraInfo.facing == 1;
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isBackFacing(String deviceName) {
        Camera.CameraInfo cameraInfo = getCameraInfo(getCameraIndex(deviceName));
        return cameraInfo != null && cameraInfo.facing == 0;
    }

    @Override // org.webrtc.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String deviceName) {
        return getSupportedFormats(getCameraIndex(deviceName));
    }

    @Override // org.webrtc.CameraEnumerator
    public CameraVideoCapturer createCapturer(String deviceName, CameraVideoCapturer.CameraEventsHandler eventsHandler) {
        return new Camera1Capturer(deviceName, eventsHandler, this.captureToTexture);
    }

    private static Camera.CameraInfo getCameraInfo(int index) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        try {
            Camera.getCameraInfo(index, cameraInfo);
            return cameraInfo;
        } catch (Exception e) {
            Logging.e(TAG, "getCameraInfo failed on index " + index, e);
            return null;
        }
    }

    static synchronized List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(int cameraId) {
        if (cachedSupportedFormats == null) {
            cachedSupportedFormats = new ArrayList();
            for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                cachedSupportedFormats.add(enumerateFormats(i));
            }
        }
        return cachedSupportedFormats.get(cameraId);
    }

    private static List<CameraEnumerationAndroid.CaptureFormat> enumerateFormats(int cameraId) {
        int i;
        Logging.d(TAG, "Get supported formats for camera index " + cameraId + ".");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Camera cameraOpen = null;
        try {
            try {
                Logging.d(TAG, "Opening camera with index " + cameraId);
                cameraOpen = Camera.open(cameraId);
                Camera.Parameters parameters = cameraOpen.getParameters();
                cameraOpen.release();
                ArrayList arrayList = new ArrayList();
                try {
                    List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                    int i2 = 0;
                    if (supportedPreviewFpsRange != null) {
                        int[] iArr = supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1);
                        i2 = iArr[0];
                        i = iArr[1];
                    } else {
                        i = 0;
                    }
                    for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
                        arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, i2, i));
                    }
                } catch (Exception e) {
                    Logging.e(TAG, "getSupportedFormats() failed on camera index " + cameraId, e);
                }
                Logging.d(TAG, "Get supported formats for camera index " + cameraId + " done. Time spent: " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms.");
                return arrayList;
            } catch (RuntimeException e2) {
                Logging.e(TAG, "Open camera failed on camera index " + cameraId, e2);
                ArrayList arrayList2 = new ArrayList();
                if (cameraOpen != null) {
                    cameraOpen.release();
                }
                return arrayList2;
            }
        } catch (Throwable th) {
            if (cameraOpen != null) {
                cameraOpen.release();
            }
            throw th;
        }
    }

    static List<Size> convertSizes(List<Camera.Size> cameraSizes) {
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : cameraSizes) {
            arrayList.add(new Size(size.width, size.height));
        }
        return arrayList;
    }

    static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(List<int[]> arrayRanges) {
        ArrayList arrayList = new ArrayList();
        for (int[] iArr : arrayRanges) {
            arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(iArr[0], iArr[1]));
        }
        return arrayList;
    }

    static int getCameraIndex(String deviceName) {
        Logging.d(TAG, "getCameraIndex: " + deviceName);
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            if (deviceName.equals(getDeviceName(i))) {
                return i;
            }
        }
        throw new IllegalArgumentException("No such camera: " + deviceName);
    }

    static String getDeviceName(int index) {
        Camera.CameraInfo cameraInfo = getCameraInfo(index);
        if (cameraInfo == null) {
            return null;
        }
        return "Camera " + index + ", Facing " + (cameraInfo.facing == 1 ? "front" : "back") + ", Orientation " + cameraInfo.orientation;
    }
}
