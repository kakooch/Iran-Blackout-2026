package ir.eitaa.messenger.camera;

import android.graphics.Rect;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CameraSession {
    public static final int ORIENTATION_HYSTERESIS = 5;
    protected CameraInfo cameraInfo;
    private String currentFlashMode;
    private int currentOrientation;
    private float currentZoom;
    private boolean destroyed;
    private int diffOrientation;
    private int displayOrientation;
    private boolean initied;
    private boolean isRound;
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
    private boolean useTorch;
    private int lastOrientation = -1;
    private int lastDisplayOrientation = -1;
    private boolean flipFront = true;
    Camera.CameraInfo info = new Camera.CameraInfo();
    private Camera.AutoFocusCallback autoFocusCallback = new Camera.AutoFocusCallback() { // from class: ir.eitaa.messenger.camera.-$$Lambda$CameraSession$LYR08cBZ6y36stoIZdzzJRuU9v0
        @Override // android.hardware.Camera.AutoFocusCallback
        public final void onAutoFocus(boolean z, Camera camera) {
            CameraSession.lambda$new$0(z, camera);
        }
    };

    static /* synthetic */ void lambda$new$0(boolean z, Camera camera) {
    }

    public CameraSession(CameraInfo info, Size preview, Size picture, int format, boolean round) {
        this.previewSize = preview;
        this.pictureSize = picture;
        this.pictureFormat = format;
        this.cameraInfo = info;
        this.isRound = round;
        this.currentFlashMode = ApplicationLoader.applicationContext.getSharedPreferences("camera", 0).getString(this.cameraInfo.frontCamera != 0 ? "flashMode_front" : "flashMode", "off");
        OrientationEventListener orientationEventListener = new OrientationEventListener(ApplicationLoader.applicationContext) { // from class: ir.eitaa.messenger.camera.CameraSession.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                if (CameraSession.this.orientationEventListener == null || !CameraSession.this.initied || orientation == -1) {
                    return;
                }
                CameraSession cameraSession = CameraSession.this;
                cameraSession.jpegOrientation = cameraSession.roundOrientation(orientation, cameraSession.jpegOrientation);
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
    public int roundOrientation(int orientation, int orientationHistory) {
        boolean z = true;
        if (orientationHistory != -1) {
            int iAbs = Math.abs(orientation - orientationHistory);
            if (Math.min(iAbs, 360 - iAbs) < 50) {
                z = false;
            }
        }
        return z ? (((orientation + 45) / 90) * 90) % 360 : orientationHistory;
    }

    public void setOptimizeForBarcode(boolean value) {
        this.optimizeForBarcode = value;
        configurePhotoCamera();
    }

    public void checkFlashMode(String mode) {
        if (CameraController.getInstance().availableFlashModes.contains(this.currentFlashMode)) {
            return;
        }
        this.currentFlashMode = mode;
        configurePhotoCamera();
        ApplicationLoader.applicationContext.getSharedPreferences("camera", 0).edit().putString(this.cameraInfo.frontCamera != 0 ? "flashMode_front" : "flashMode", mode).commit();
    }

    public void setCurrentFlashMode(String mode) {
        this.currentFlashMode = mode;
        configurePhotoCamera();
        ApplicationLoader.applicationContext.getSharedPreferences("camera", 0).edit().putString(this.cameraInfo.frontCamera != 0 ? "flashMode_front" : "flashMode", mode).commit();
    }

    public void setTorchEnabled(boolean enabled) {
        try {
            this.currentFlashMode = enabled ? "torch" : "off";
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

    public void setFlipFront(boolean value) {
        this.flipFront = value;
    }

    public int getWorldAngle() {
        return this.diffOrientation;
    }

    public boolean isSameTakePictureOrientation() {
        return this.sameTakePictureOrientation;
    }

    protected void configureRoundCamera(boolean initial) {
        int i;
        try {
            this.isVideo = true;
            Camera camera = this.cameraInfo.camera;
            if (camera != null) {
                Camera.Parameters parameters = null;
                try {
                    parameters = camera.getParameters();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                Camera.getCameraInfo(this.cameraInfo.getCameraId(), this.info);
                updateRotation();
                if (parameters != null) {
                    if (initial && BuildVars.LOGS_ENABLED) {
                        FileLog.d("set preview size = " + this.previewSize.getWidth() + " " + this.previewSize.getHeight());
                    }
                    parameters.setPreviewSize(this.previewSize.getWidth(), this.previewSize.getHeight());
                    if (initial && BuildVars.LOGS_ENABLED) {
                        FileLog.d("set picture size = " + this.pictureSize.getWidth() + " " + this.pictureSize.getHeight());
                    }
                    parameters.setPictureSize(this.pictureSize.getWidth(), this.pictureSize.getHeight());
                    parameters.setPictureFormat(this.pictureFormat);
                    parameters.setRecordingHint(true);
                    this.maxZoom = parameters.getMaxZoom();
                    if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                        parameters.setFocusMode("continuous-video");
                    } else if (parameters.getSupportedFocusModes().contains("auto")) {
                        parameters.setFocusMode("auto");
                    }
                    int i2 = this.jpegOrientation;
                    if (i2 != -1) {
                        Camera.CameraInfo cameraInfo = this.info;
                        if (cameraInfo.facing == 1) {
                            i = ((cameraInfo.orientation - i2) + 360) % 360;
                        } else {
                            i = (cameraInfo.orientation + i2) % 360;
                        }
                    } else {
                        i = 0;
                    }
                    try {
                        parameters.setRotation(i);
                        if (this.info.facing == 1) {
                            this.sameTakePictureOrientation = (360 - this.displayOrientation) % 360 == i;
                        } else {
                            this.sameTakePictureOrientation = this.displayOrientation == i;
                        }
                    } catch (Exception unused) {
                    }
                    parameters.setFlashMode("off");
                    parameters.setZoom((int) (this.currentZoom * this.maxZoom));
                    try {
                        camera.setParameters(parameters);
                        if (parameters.getMaxNumMeteringAreas() > 0) {
                            this.meteringAreaSupported = true;
                        }
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateRotation() {
        /*
            r7 = this;
            ir.eitaa.messenger.camera.CameraInfo r0 = r7.cameraInfo
            if (r0 != 0) goto L5
            return
        L5:
            int r0 = r0.getCameraId()     // Catch: java.lang.Throwable -> L89
            android.hardware.Camera$CameraInfo r1 = r7.info     // Catch: java.lang.Throwable -> L89
            android.hardware.Camera.getCameraInfo(r0, r1)     // Catch: java.lang.Throwable -> L89
            ir.eitaa.messenger.camera.CameraInfo r0 = r7.cameraInfo
            if (r0 == 0) goto L1a
            boolean r1 = r7.destroyed
            if (r1 == 0) goto L17
            goto L1a
        L17:
            android.hardware.Camera r0 = r0.camera
            goto L1b
        L1a:
            r0 = 0
        L1b:
            android.hardware.Camera$CameraInfo r1 = r7.info
            r2 = 1
            int r1 = r7.getDisplayOrientation(r1, r2)
            r7.displayOrientation = r1
            java.lang.String r1 = android.os.Build.MANUFACTURER
            java.lang.String r3 = "samsung"
            boolean r1 = r3.equals(r1)
            r3 = 0
            if (r1 == 0) goto L3a
            java.lang.String r1 = android.os.Build.PRODUCT
            java.lang.String r4 = "sf2wifixx"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L3a
            goto L72
        L3a:
            int r1 = r7.displayOrientation
            r4 = 90
            if (r1 == 0) goto L48
            if (r1 == r2) goto L50
            r5 = 2
            if (r1 == r5) goto L4d
            r5 = 3
            if (r1 == r5) goto L4a
        L48:
            r1 = 0
            goto L52
        L4a:
            r1 = 270(0x10e, float:3.78E-43)
            goto L52
        L4d:
            r1 = 180(0xb4, float:2.52E-43)
            goto L52
        L50:
            r1 = 90
        L52:
            android.hardware.Camera$CameraInfo r5 = r7.info
            int r6 = r5.orientation
            int r6 = r6 % r4
            if (r6 == 0) goto L5b
            r5.orientation = r3
        L5b:
            int r3 = r5.facing
            if (r3 != r2) goto L6a
            int r2 = r5.orientation
            int r2 = r2 + r1
            int r2 = r2 % 360
            int r1 = 360 - r2
            int r1 = r1 % 360
            r3 = r1
            goto L72
        L6a:
            int r2 = r5.orientation
            int r2 = r2 - r1
            int r2 = r2 + 360
            int r2 = r2 % 360
            r3 = r2
        L72:
            r7.currentOrientation = r3
            if (r0 == 0) goto L7b
            r0.setDisplayOrientation(r3)     // Catch: java.lang.Throwable -> L7a
            goto L7b
        L7a:
        L7b:
            int r0 = r7.currentOrientation
            int r1 = r7.displayOrientation
            int r0 = r0 - r1
            r7.diffOrientation = r0
            if (r0 >= 0) goto L88
            int r0 = r0 + 360
            r7.diffOrientation = r0
        L88:
            return
        L89:
            r0 = move-exception
            ir.eitaa.messenger.FileLog.e(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.camera.CameraSession.updateRotation():void");
    }

    protected void configurePhotoCamera() {
        int i;
        try {
            Camera camera = this.cameraInfo.camera;
            if (camera != null) {
                Camera.Parameters parameters = null;
                try {
                    parameters = camera.getParameters();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                Camera.getCameraInfo(this.cameraInfo.getCameraId(), this.info);
                updateRotation();
                int i2 = this.currentOrientation - this.displayOrientation;
                this.diffOrientation = i2;
                if (i2 < 0) {
                    this.diffOrientation = i2 + 360;
                }
                if (parameters != null) {
                    parameters.setPreviewSize(this.previewSize.getWidth(), this.previewSize.getHeight());
                    parameters.setPictureSize(this.pictureSize.getWidth(), this.pictureSize.getHeight());
                    parameters.setPictureFormat(this.pictureFormat);
                    parameters.setJpegQuality(100);
                    parameters.setJpegThumbnailQuality(100);
                    int maxZoom = parameters.getMaxZoom();
                    this.maxZoom = maxZoom;
                    parameters.setZoom((int) (this.currentZoom * maxZoom));
                    if (this.optimizeForBarcode) {
                        List<String> supportedSceneModes = parameters.getSupportedSceneModes();
                        if (supportedSceneModes != null && supportedSceneModes.contains("barcode")) {
                            parameters.setSceneMode("barcode");
                        }
                        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
                            parameters.setFocusMode("continuous-video");
                        }
                    } else if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
                        parameters.setFocusMode("continuous-picture");
                    }
                    int i3 = this.jpegOrientation;
                    if (i3 != -1) {
                        Camera.CameraInfo cameraInfo = this.info;
                        if (cameraInfo.facing == 1) {
                            i = ((cameraInfo.orientation - i3) + 360) % 360;
                        } else {
                            i = (cameraInfo.orientation + i3) % 360;
                        }
                    } else {
                        i = 0;
                    }
                    try {
                        parameters.setRotation(i);
                        if (this.info.facing == 1) {
                            this.sameTakePictureOrientation = (360 - this.displayOrientation) % 360 == i;
                        } else {
                            this.sameTakePictureOrientation = this.displayOrientation == i;
                        }
                    } catch (Exception unused) {
                    }
                    parameters.setFlashMode(this.useTorch ? "torch" : this.currentFlashMode);
                    try {
                        camera.setParameters(parameters);
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    protected void focusToRect(Rect focusRect, Rect meteringRect) {
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
                    arrayList.add(new Camera.Area(focusRect, 1000));
                    parameters.setFocusAreas(arrayList);
                    if (this.meteringAreaSupported) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new Camera.Area(meteringRect, 1000));
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

    public void onStartRecord() {
        this.isVideo = true;
    }

    public void setZoom(float value) {
        this.currentZoom = value;
        if (this.isVideo && "on".equals(this.currentFlashMode)) {
            this.useTorch = true;
        }
        if (this.isRound) {
            configureRoundCamera(false);
        } else {
            configurePhotoCamera();
        }
    }

    protected void configureRecorder(int quality, MediaRecorder recorder) {
        int i;
        Camera.getCameraInfo(this.cameraInfo.cameraId, this.info);
        int i2 = this.jpegOrientation;
        if (i2 != -1) {
            Camera.CameraInfo cameraInfo = this.info;
            if (cameraInfo.facing == 1) {
                i = ((cameraInfo.orientation - i2) + 360) % 360;
            } else {
                i = (cameraInfo.orientation + i2) % 360;
            }
        } else {
            i = 0;
        }
        recorder.setOrientationHint(i);
        int high = getHigh();
        boolean zHasProfile = CamcorderProfile.hasProfile(this.cameraInfo.cameraId, high);
        boolean zHasProfile2 = CamcorderProfile.hasProfile(this.cameraInfo.cameraId, 0);
        if (zHasProfile && (quality == 1 || !zHasProfile2)) {
            recorder.setProfile(CamcorderProfile.get(this.cameraInfo.cameraId, high));
        } else if (zHasProfile2) {
            recorder.setProfile(CamcorderProfile.get(this.cameraInfo.cameraId, 0));
        } else {
            throw new IllegalStateException("cannot find valid CamcorderProfile");
        }
        this.isVideo = true;
    }

    protected void stopVideoRecording() {
        this.isVideo = false;
        this.useTorch = false;
        configurePhotoCamera();
    }

    private int getHigh() {
        return ("LGE".equals(Build.MANUFACTURER) && "g3_tmo_us".equals(Build.PRODUCT)) ? 4 : 1;
    }

    private int getDisplayOrientation(Camera.CameraInfo info, boolean isStillCapture) {
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
        if (info.facing == 1) {
            int i2 = (360 - ((info.orientation + i) % 360)) % 360;
            if (!isStillCapture && i2 == 90) {
                i2 = 270;
            }
            if (!isStillCapture && "Huawei".equals(Build.MANUFACTURER) && "angler".equals(Build.PRODUCT) && i2 == 270) {
                return 90;
            }
            return i2;
        }
        return ((info.orientation - i) + 360) % 360;
    }

    public int getDisplayOrientation() {
        try {
            Camera.getCameraInfo(this.cameraInfo.getCameraId(), this.info);
            return getDisplayOrientation(this.info, true);
        } catch (Exception e) {
            FileLog.e(e);
            return 0;
        }
    }

    public void setPreviewCallback(Camera.PreviewCallback callback) {
        this.cameraInfo.camera.setPreviewCallback(callback);
    }

    public void setOneShotPreviewCallback(Camera.PreviewCallback callback) {
        Camera camera;
        CameraInfo cameraInfo = this.cameraInfo;
        if (cameraInfo == null || (camera = cameraInfo.camera) == null) {
            return;
        }
        try {
            camera.setOneShotPreviewCallback(callback);
        } catch (Exception unused) {
        }
    }

    public void destroy() {
        this.initied = false;
        this.destroyed = true;
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.orientationEventListener = null;
        }
    }
}
