package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.os.SystemClock;
import android.util.AndroidException;
import android.util.Range;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.webrtc.CameraEnumerationAndroid;
import org.webrtc.CameraVideoCapturer;

@TargetApi(21)
/* loaded from: classes3.dex */
public class Camera2Enumerator implements CameraEnumerator {
    private static final double NANO_SECONDS_PER_SECOND = 1.0E9d;
    private static final String TAG = "Camera2Enumerator";
    private static final Map<String, List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats = new HashMap();
    final CameraManager cameraManager;
    final Context context;

    public Camera2Enumerator(Context context) {
        this.context = context;
        this.cameraManager = (CameraManager) context.getSystemService("camera");
    }

    @Override // org.webrtc.CameraEnumerator
    public String[] getDeviceNames() {
        try {
            return this.cameraManager.getCameraIdList();
        } catch (AndroidException e) {
            Logging.e(TAG, "Camera access exception: " + e);
            return new String[0];
        }
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isFrontFacing(String deviceName) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(deviceName);
        return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0;
    }

    @Override // org.webrtc.CameraEnumerator
    public boolean isBackFacing(String deviceName) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(deviceName);
        return cameraCharacteristics != null && ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1;
    }

    @Override // org.webrtc.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String deviceName) {
        return getSupportedFormats(this.context, deviceName);
    }

    @Override // org.webrtc.CameraEnumerator
    public CameraVideoCapturer createCapturer(String deviceName, CameraVideoCapturer.CameraEventsHandler eventsHandler) {
        return new Camera2Capturer(this.context, deviceName, eventsHandler);
    }

    private CameraCharacteristics getCameraCharacteristics(String deviceName) {
        try {
            return this.cameraManager.getCameraCharacteristics(deviceName);
        } catch (AndroidException e) {
            Logging.e(TAG, "Camera access exception: " + e);
            return null;
        }
    }

    public static boolean isSupported(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        try {
            for (String str : cameraManager.getCameraIdList()) {
                if (((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            Logging.e(TAG, "Camera access exception: " + th);
            return false;
        }
    }

    static int getFpsUnitFactor(Range<Integer>[] fpsRanges) {
        return (fpsRanges.length != 0 && ((Integer) fpsRanges[0].getUpper()).intValue() >= 1000) ? 1 : 1000;
    }

    static List<Size> getSupportedSizes(CameraCharacteristics cameraCharacteristics) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        int iIntValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        List<Size> listConvertSizes = convertSizes(streamConfigurationMap.getOutputSizes(SurfaceTexture.class));
        if (Build.VERSION.SDK_INT >= 22 || iIntValue != 2) {
            return listConvertSizes;
        }
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        ArrayList arrayList = new ArrayList();
        for (Size size : listConvertSizes) {
            if (rect.width() * size.height == rect.height() * size.width) {
                arrayList.add(size);
            }
        }
        return arrayList;
    }

    static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(Context context, String cameraId) {
        return getSupportedFormats((CameraManager) context.getSystemService("camera"), cameraId);
    }

    static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(CameraManager cameraManager, String cameraId) {
        long outputMinFrameDuration;
        int iRound;
        Map<String, List<CameraEnumerationAndroid.CaptureFormat>> map = cachedSupportedFormats;
        synchronized (map) {
            if (map.containsKey(cameraId)) {
                return map.get(cameraId);
            }
            Logging.d(TAG, "Get supported formats for camera index " + cameraId + ".");
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraId);
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> listConvertFramerates = convertFramerates(rangeArr, getFpsUnitFactor(rangeArr));
                List<Size> supportedSizes = getSupportedSizes(cameraCharacteristics);
                Iterator<CameraEnumerationAndroid.CaptureFormat.FramerateRange> it = listConvertFramerates.iterator();
                int iMax = 0;
                while (it.hasNext()) {
                    iMax = Math.max(iMax, it.next().max);
                }
                ArrayList arrayList = new ArrayList();
                for (Size size : supportedSizes) {
                    try {
                        outputMinFrameDuration = streamConfigurationMap.getOutputMinFrameDuration(SurfaceTexture.class, new android.util.Size(size.width, size.height));
                    } catch (Exception unused) {
                        outputMinFrameDuration = 0;
                    }
                    if (outputMinFrameDuration == 0) {
                        iRound = iMax;
                    } else {
                        double d = outputMinFrameDuration;
                        Double.isNaN(d);
                        iRound = ((int) Math.round(NANO_SECONDS_PER_SECOND / d)) * 1000;
                    }
                    arrayList.add(new CameraEnumerationAndroid.CaptureFormat(size.width, size.height, 0, iRound));
                    Logging.d(TAG, "Format: " + size.width + "x" + size.height + "@" + iRound);
                }
                cachedSupportedFormats.put(cameraId, arrayList);
                Logging.d(TAG, "Get supported formats for camera index " + cameraId + " done. Time spent: " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms.");
                return arrayList;
            } catch (Exception e) {
                Logging.e(TAG, "getCameraCharacteristics(): " + e);
                return new ArrayList();
            }
        }
    }

    private static List<Size> convertSizes(android.util.Size[] cameraSizes) {
        ArrayList arrayList = new ArrayList();
        for (android.util.Size size : cameraSizes) {
            arrayList.add(new Size(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(Range<Integer>[] arrayRanges, int unitFactor) {
        ArrayList arrayList = new ArrayList();
        for (Range<Integer> range : arrayRanges) {
            arrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(((Integer) range.getLower()).intValue() * unitFactor, ((Integer) range.getUpper()).intValue() * unitFactor));
        }
        return arrayList;
    }
}
