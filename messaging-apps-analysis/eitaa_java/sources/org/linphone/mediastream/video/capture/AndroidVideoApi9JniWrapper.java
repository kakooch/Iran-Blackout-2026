package org.linphone.mediastream.video.capture;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.linphone.mediastream.Log;

@TargetApi(9)
/* loaded from: classes3.dex */
public class AndroidVideoApi9JniWrapper {
    private static boolean compensateCameraTextureViewRotation = false;

    public static int detectCamerasCount() {
        return AndroidVideoApi5JniWrapper.detectCamerasCount();
    }

    public static int detectCameras(int[] iArr, int[] iArr2, int[] iArr3) {
        return AndroidVideoApi5JniWrapper.detectCameras(iArr, iArr2, iArr3);
    }

    public static int[] selectNearestResolutionAvailable(int i, int i2, int i3) {
        Log.d("selectNearestResolutionAvailable: " + i + ", " + i2 + "x" + i3);
        return AndroidVideoApi5JniWrapper.selectNearestResolutionAvailableForCamera(i, i2, i3);
    }

    public static Object startRecording(int i, int i2, int i3, int i4, int i5, final long j) {
        Log.i("startRecording(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ", " + j + ")");
        try {
            Camera cameraOpen = Camera.open(i);
            Camera.Parameters parameters = cameraOpen.getParameters();
            Iterator<String> it = parameters.getSupportedFocusModes().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().equalsIgnoreCase("continuous-video")) {
                    Log.i("FOCUS_MODE_CONTINUOUS_VIDEO is supported, let's use it");
                    parameters.setFocusMode("continuous-video");
                    break;
                }
            }
            if (parameters.isVideoStabilizationSupported()) {
                Log.i("Video stabilization is supported, let's use it");
                parameters.setVideoStabilization(true);
            }
            parameters.setPreviewSize(i2, i3);
            int[] iArrFindClosestEnclosingFpsRange = findClosestEnclosingFpsRange(i4 * 1000, parameters.getSupportedPreviewFpsRange());
            if (iArrFindClosestEnclosingFpsRange[0] != iArrFindClosestEnclosingFpsRange[1]) {
                parameters.setPreviewFpsRange(iArrFindClosestEnclosingFpsRange[0], iArrFindClosestEnclosingFpsRange[1]);
            }
            cameraOpen.setParameters(parameters);
            int bitsPerPixel = ((i2 * i3) * ImageFormat.getBitsPerPixel(parameters.getPreviewFormat())) / 8;
            cameraOpen.addCallbackBuffer(new byte[bitsPerPixel]);
            cameraOpen.addCallbackBuffer(new byte[bitsPerPixel]);
            cameraOpen.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() { // from class: org.linphone.mediastream.video.capture.AndroidVideoApi9JniWrapper.1
                @Override // android.hardware.Camera.PreviewCallback
                public void onPreviewFrame(byte[] bArr, Camera camera) {
                    if (bArr == null) {
                        Camera.Parameters parameters2 = camera.getParameters();
                        Camera.Size previewSize = parameters2.getPreviewSize();
                        int bitsPerPixel2 = ((previewSize.width * previewSize.height) * ImageFormat.getBitsPerPixel(parameters2.getPreviewFormat())) / 8;
                        camera.addCallbackBuffer(new byte[bitsPerPixel2 + (bitsPerPixel2 / 20)]);
                        return;
                    }
                    if (AndroidVideoApi5JniWrapper.isRecording) {
                        AndroidVideoApi5JniWrapper.putImage(j, bArr);
                        camera.addCallbackBuffer(bArr);
                    }
                }
            });
            setCameraDisplayOrientation(i5, i, cameraOpen);
            AndroidVideoApi5JniWrapper.isRecording = true;
            Log.d("Returning camera object: " + cameraOpen);
            return cameraOpen;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void stopRecording(Object obj) {
        AndroidVideoApi5JniWrapper.isRecording = false;
        AndroidVideoApi8JniWrapper.stopRecording(obj);
    }

    public static void setPreviewDisplaySurface(Object obj, Object obj2) throws IOException {
        AndroidVideoApi5JniWrapper.setPreviewDisplaySurface(obj, obj2);
        compensateCameraTextureViewRotation = false;
        if (obj2 instanceof CaptureTextureView) {
            compensateCameraTextureViewRotation = true;
        }
        Camera camera = (Camera) obj;
        camera.startPreview();
        Log.i("Camera [" + camera + "] preview started");
    }

    private static void setCameraDisplayOrientation(int i, int i2, Camera camera) {
        int i3;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        if (cameraInfo.facing == 1) {
            i3 = (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        } else {
            i3 = ((cameraInfo.orientation - i) + 360) % 360;
        }
        if (compensateCameraTextureViewRotation) {
            i3 = (i3 + i) % 360;
        }
        Log.w("Camera preview orientation: " + i3);
        try {
            camera.setDisplayOrientation(i3);
        } catch (Exception e) {
            Log.e("Failed to execute: camera[" + camera + "].setDisplayOrientation(" + i3 + ")");
            e.printStackTrace();
        }
    }

    private static int[] findClosestEnclosingFpsRange(int i, List<int[]> list) {
        int iAbs;
        Log.d("Searching for closest fps range from " + i);
        if (list == null || list.size() == 0) {
            return new int[]{0, 0};
        }
        int[] iArr = list.get(0);
        int iAbs2 = Math.abs(iArr[0] - i) + Math.abs(iArr[1] - i);
        for (int[] iArr2 : list) {
            if (iArr2[0] <= i && iArr2[1] >= i && (iAbs = Math.abs(iArr2[0] - i) + Math.abs(iArr2[1] - i)) < iAbs2 && iArr2[0] != iArr2[1]) {
                Log.d("A better range has been found: w=" + iArr2[0] + ",h=" + iArr2[1]);
                iArr = iArr2;
                iAbs2 = iAbs;
            }
        }
        Log.d("The closest fps range is w=" + iArr[0] + ",h=" + iArr[1]);
        return iArr;
    }
}
