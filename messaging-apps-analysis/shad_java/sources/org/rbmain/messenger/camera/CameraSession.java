package org.rbmain.messenger.camera;

import android.graphics.Rect;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.facebook.stetho.websocket.CloseCodes;
import java.util.ArrayList;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;

/* loaded from: classes4.dex */
public class CameraSession {
    public static final int ORIENTATION_HYSTERESIS = 5;
    public CameraInfo cameraInfo;
    private String currentFlashMode;
    private int currentOrientation;
    private float currentZoom;
    private int diffOrientation;
    private boolean initied;
    private boolean isVideo;
    private int jpegOrientation;
    private int maxZoom;
    private boolean meteringAreaSupported;
    private boolean optimizeForBarcode;
    private OrientationEventListener orientationEventListener;
    private final int pictureFormat;
    private final Size pictureSize;
    private final Size previewSize;
    private boolean sameTakePictureOrientation;
    private int lastOrientation = -1;
    private int lastDisplayOrientation = -1;
    private boolean flipFront = true;
    private Camera.AutoFocusCallback autoFocusCallback = new Camera.AutoFocusCallback() { // from class: org.rbmain.messenger.camera.CameraSession$$ExternalSyntheticLambda0
        @Override // android.hardware.Camera.AutoFocusCallback
        public final void onAutoFocus(boolean z, Camera camera) {
            CameraSession.lambda$new$0(z, camera);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(boolean z, Camera camera) {
    }

    public CameraSession(CameraInfo cameraInfo, Size size, Size size2, int i) {
        this.previewSize = size;
        this.pictureSize = size2;
        this.pictureFormat = i;
        this.cameraInfo = cameraInfo;
        this.currentFlashMode = ApplicationLoader.applicationContext.getSharedPreferences("camera", 0).getString(this.cameraInfo.frontCamera != 0 ? "flashMode_front" : "flashMode", "off");
        OrientationEventListener orientationEventListener = new OrientationEventListener(ApplicationLoader.applicationContext) { // from class: org.rbmain.messenger.camera.CameraSession.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i2) {
                if (CameraSession.this.orientationEventListener == null || !CameraSession.this.initied || i2 == -1) {
                    return;
                }
                CameraSession cameraSession = CameraSession.this;
                cameraSession.jpegOrientation = cameraSession.roundOrientation(i2, cameraSession.jpegOrientation);
                int rotation = ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
                if (CameraSession.this.lastOrientation == CameraSession.this.jpegOrientation && rotation == CameraSession.this.lastDisplayOrientation) {
                    return;
                }
                if (!CameraSession.this.isVideo) {
                    CameraSession.this.configurePhotoCamera();
                }
                CameraSession.this.lastDisplayOrientation = rotation;
                CameraSession cameraSession2 = CameraSession.this;
                cameraSession2.lastOrientation = cameraSession2.jpegOrientation;
            }
        };
        this.orientationEventListener = orientationEventListener;
        if (orientationEventListener.canDetectOrientation()) {
            this.orientationEventListener.enable();
        } else {
            this.orientationEventListener.disable();
            this.orientationEventListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int roundOrientation(int i, int i2) {
        boolean z = true;
        if (i2 != -1) {
            int iAbs = Math.abs(i - i2);
            if (Math.min(iAbs, 360 - iAbs) < 50) {
                z = false;
            }
        }
        return z ? (((i + 45) / 90) * 90) % 360 : i2;
    }

    public void setOptimizeForBarcode(boolean z) {
        this.optimizeForBarcode = z;
        configurePhotoCamera();
    }

    public void checkFlashMode(String str) {
        if (CameraController.getInstance().availableFlashModes.contains(this.currentFlashMode)) {
            return;
        }
        this.currentFlashMode = str;
        configurePhotoCamera();
        ApplicationLoader.applicationContext.getSharedPreferences("camera", 0).edit().putString(this.cameraInfo.frontCamera != 0 ? "flashMode_front" : "flashMode", str).apply();
    }

    public void setCurrentFlashMode(String str) {
        this.currentFlashMode = str;
        configurePhotoCamera();
        ApplicationLoader.applicationContext.getSharedPreferences("camera", 0).edit().putString(this.cameraInfo.frontCamera != 0 ? "flashMode_front" : "flashMode", str).apply();
    }

    public void setTorchEnabled(boolean z) {
        try {
            this.currentFlashMode = z ? "torch" : "off";
            configurePhotoCamera();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public String getCurrentFlashMode() {
        return this.currentFlashMode;
    }

    public String getNextFlashMode() {
        ArrayList<String> arrayList = CameraController.getInstance().availableFlashModes;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(this.currentFlashMode)) {
                if (i < arrayList.size() - 1) {
                    return arrayList.get(i + 1);
                }
                return arrayList.get(0);
            }
        }
        return this.currentFlashMode;
    }

    public void setInitied() {
        this.initied = true;
    }

    public boolean isInitied() {
        return this.initied;
    }

    public int getCurrentOrientation() {
        return this.currentOrientation;
    }

    public boolean isFlipFront() {
        return this.flipFront;
    }

    public void setFlipFront(boolean z) {
        this.flipFront = z;
    }

    public int getWorldAngle() {
        return this.diffOrientation;
    }

    public boolean isSameTakePictureOrientation() {
        return this.sameTakePictureOrientation;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058 A[Catch: all -> 0x0155, TryCatch #1 {all -> 0x0155, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x000f, B:11:0x0018, B:13:0x0030, B:34:0x006f, B:36:0x007b, B:39:0x0081, B:40:0x00a7, B:42:0x00ba, B:43:0x00e0, B:45:0x0103, B:49:0x0116, B:51:0x011b, B:53:0x011f, B:57:0x012e, B:59:0x0135, B:62:0x013c, B:65:0x0142, B:66:0x0144, B:67:0x0149, B:68:0x014c, B:70:0x0152, B:54:0x0127, B:46:0x0107, B:48:0x0113, B:27:0x0053, B:29:0x0058, B:30:0x005a, B:32:0x005e, B:33:0x0068, B:10:0x0015), top: B:79:0x0001, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e A[Catch: all -> 0x0155, TryCatch #1 {all -> 0x0155, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x000f, B:11:0x0018, B:13:0x0030, B:34:0x006f, B:36:0x007b, B:39:0x0081, B:40:0x00a7, B:42:0x00ba, B:43:0x00e0, B:45:0x0103, B:49:0x0116, B:51:0x011b, B:53:0x011f, B:57:0x012e, B:59:0x0135, B:62:0x013c, B:65:0x0142, B:66:0x0144, B:67:0x0149, B:68:0x014c, B:70:0x0152, B:54:0x0127, B:46:0x0107, B:48:0x0113, B:27:0x0053, B:29:0x0058, B:30:0x005a, B:32:0x005e, B:33:0x0068, B:10:0x0015), top: B:79:0x0001, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068 A[Catch: all -> 0x0155, TryCatch #1 {all -> 0x0155, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x000f, B:11:0x0018, B:13:0x0030, B:34:0x006f, B:36:0x007b, B:39:0x0081, B:40:0x00a7, B:42:0x00ba, B:43:0x00e0, B:45:0x0103, B:49:0x0116, B:51:0x011b, B:53:0x011f, B:57:0x012e, B:59:0x0135, B:62:0x013c, B:65:0x0142, B:66:0x0144, B:67:0x0149, B:68:0x014c, B:70:0x0152, B:54:0x0127, B:46:0x0107, B:48:0x0113, B:27:0x0053, B:29:0x0058, B:30:0x005a, B:32:0x005e, B:33:0x0068, B:10:0x0015), top: B:79:0x0001, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void configureRoundCamera() {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.camera.CameraSession.configureRoundCamera():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058 A[Catch: all -> 0x0121, TryCatch #1 {all -> 0x0121, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x000e, B:11:0x0017, B:13:0x0030, B:34:0x006f, B:36:0x0076, B:38:0x00b4, B:40:0x00ba, B:42:0x00c0, B:43:0x00c3, B:45:0x00cf, B:49:0x00e2, B:51:0x00e7, B:53:0x00eb, B:57:0x00fa, B:59:0x0101, B:62:0x0108, B:65:0x010e, B:66:0x0110, B:67:0x0115, B:68:0x0118, B:70:0x011e, B:54:0x00f3, B:46:0x00d3, B:48:0x00df, B:27:0x0053, B:29:0x0058, B:30:0x005a, B:32:0x005e, B:33:0x0068, B:10:0x0014), top: B:78:0x0002, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005e A[Catch: all -> 0x0121, TryCatch #1 {all -> 0x0121, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x000e, B:11:0x0017, B:13:0x0030, B:34:0x006f, B:36:0x0076, B:38:0x00b4, B:40:0x00ba, B:42:0x00c0, B:43:0x00c3, B:45:0x00cf, B:49:0x00e2, B:51:0x00e7, B:53:0x00eb, B:57:0x00fa, B:59:0x0101, B:62:0x0108, B:65:0x010e, B:66:0x0110, B:67:0x0115, B:68:0x0118, B:70:0x011e, B:54:0x00f3, B:46:0x00d3, B:48:0x00df, B:27:0x0053, B:29:0x0058, B:30:0x005a, B:32:0x005e, B:33:0x0068, B:10:0x0014), top: B:78:0x0002, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068 A[Catch: all -> 0x0121, TryCatch #1 {all -> 0x0121, blocks: (B:3:0x0002, B:5:0x0008, B:7:0x000e, B:11:0x0017, B:13:0x0030, B:34:0x006f, B:36:0x0076, B:38:0x00b4, B:40:0x00ba, B:42:0x00c0, B:43:0x00c3, B:45:0x00cf, B:49:0x00e2, B:51:0x00e7, B:53:0x00eb, B:57:0x00fa, B:59:0x0101, B:62:0x0108, B:65:0x010e, B:66:0x0110, B:67:0x0115, B:68:0x0118, B:70:0x011e, B:54:0x00f3, B:46:0x00d3, B:48:0x00df, B:27:0x0053, B:29:0x0058, B:30:0x005a, B:32:0x005e, B:33:0x0068, B:10:0x0014), top: B:78:0x0002, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void configurePhotoCamera() {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.camera.CameraSession.configurePhotoCamera():void");
    }

    public void focusToRect(Rect rect, Rect rect2) {
        try {
            Camera camera = this.cameraInfo.camera;
            if (camera != null) {
                camera.cancelAutoFocus();
                Camera.Parameters parameters = null;
                try {
                    parameters = camera.getParameters();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                if (parameters != null) {
                    parameters.setFocusMode("auto");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Camera.Area(rect, CloseCodes.NORMAL_CLOSURE));
                    parameters.setFocusAreas(arrayList);
                    if (this.meteringAreaSupported) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new Camera.Area(rect2, CloseCodes.NORMAL_CLOSURE));
                        parameters.setMeteringAreas(arrayList2);
                    }
                    try {
                        camera.setParameters(parameters);
                        camera.autoFocus(this.autoFocusCallback);
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                }
            }
        } catch (Exception e3) {
            FileLog.e(e3);
        }
    }

    protected int getMaxZoom() {
        return this.maxZoom;
    }

    protected void setZoom(float f) {
        this.currentZoom = f;
        configurePhotoCamera();
    }

    protected void configureRecorder(int i, MediaRecorder mediaRecorder) {
        int i2;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.cameraInfo.cameraId, cameraInfo);
        getDisplayOrientation(cameraInfo, false);
        int i3 = this.jpegOrientation;
        if (i3 == -1) {
            i2 = 0;
        } else if (cameraInfo.facing == 1) {
            i2 = ((cameraInfo.orientation - i3) + 360) % 360;
        } else {
            i2 = (cameraInfo.orientation + i3) % 360;
        }
        mediaRecorder.setOrientationHint(i2);
        int high = getHigh();
        boolean zHasProfile = CamcorderProfile.hasProfile(this.cameraInfo.cameraId, high);
        boolean zHasProfile2 = CamcorderProfile.hasProfile(this.cameraInfo.cameraId, 0);
        if (zHasProfile && (i == 1 || !zHasProfile2)) {
            mediaRecorder.setProfile(CamcorderProfile.get(this.cameraInfo.cameraId, high));
        } else if (zHasProfile2) {
            mediaRecorder.setProfile(CamcorderProfile.get(this.cameraInfo.cameraId, 0));
        } else {
            throw new IllegalStateException("cannot find valid CamcorderProfile");
        }
        this.isVideo = true;
    }

    protected void stopVideoRecording() {
        this.isVideo = false;
        configurePhotoCamera();
    }

    private int getHigh() {
        return ("LGE".equals(Build.MANUFACTURER) && "g3_tmo_us".equals(Build.PRODUCT)) ? 4 : 1;
    }

    private int getDisplayOrientation(Camera.CameraInfo cameraInfo, boolean z) {
        int rotation = ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay().getRotation();
        int i = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i = 90;
            } else if (rotation == 2) {
                i = 180;
            } else if (rotation == 3) {
                i = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            int i2 = (360 - ((cameraInfo.orientation + i) % 360)) % 360;
            if (!z && i2 == 90) {
                i2 = 270;
            }
            if (!z && "Huawei".equals(Build.MANUFACTURER) && "angler".equals(Build.PRODUCT) && i2 == 270) {
                return 90;
            }
            return i2;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    public int getDisplayOrientation() {
        try {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.cameraInfo.getCameraId(), cameraInfo);
            return getDisplayOrientation(cameraInfo, true);
        } catch (Exception e) {
            FileLog.e(e);
            return 0;
        }
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        this.cameraInfo.camera.setPreviewCallback(previewCallback);
    }

    public void setOneShotPreviewCallback(Camera.PreviewCallback previewCallback) {
        Camera camera;
        CameraInfo cameraInfo = this.cameraInfo;
        if (cameraInfo == null || (camera = cameraInfo.camera) == null) {
            return;
        }
        try {
            camera.setOneShotPreviewCallback(previewCallback);
        } catch (Exception unused) {
        }
    }

    public void destroy() {
        this.initied = false;
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.orientationEventListener = null;
        }
    }
}
