package com.pedro.encoder.input.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import com.facebook.stetho.websocket.CloseCodes;
import com.pedro.encoder.Frame;
import com.pedro.encoder.input.video.CameraHelper;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class Camera1ApiManager implements Camera.PreviewCallback, Camera.FaceDetectionListener {
    public static Camera staticCamera;
    private int cameraSelect;
    private Context context;
    private FaceDetectorCallback faceDetectorCallback;
    private GetCameraData getCameraData;
    private List<Camera.Size> previewSizeBack;
    private List<Camera.Size> previewSizeFront;
    private SurfaceTexture surfaceTexture;
    private SurfaceView surfaceView;
    private TextureView textureView;
    private byte[] yuvBuffer;
    private String TAG = "Camera1ApiManager";
    private Camera camera = null;
    private boolean running = false;
    private boolean isFrontCamera = false;
    private boolean isPortrait = false;
    private int cameraFacing = 1;
    private int width = 640;
    private int height = 480;
    private int fps = 30;
    private int rotation = 0;
    private int imageFormat = 17;

    public interface FaceDetectorCallback {
        void onGetFaces(Camera.Face[] faceArr);
    }

    public Camera getCamera() {
        return this.camera;
    }

    public Camera1ApiManager(SurfaceView surfaceView, GetCameraData getCameraData) {
        this.surfaceView = surfaceView;
        this.getCameraData = getCameraData;
        this.context = surfaceView.getContext();
        init();
    }

    private void init() {
        this.cameraSelect = selectCameraBack();
        this.previewSizeBack = getPreviewSize();
        this.cameraSelect = selectCameraFront();
        this.previewSizeFront = getPreviewSize();
    }

    public void setRotation(int i) {
        this.rotation = i;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.surfaceTexture = surfaceTexture;
    }

    public void start(CameraHelper.Facing facing, int i, int i2, int i3) throws IOException {
        int i4 = facing == CameraHelper.Facing.BACK ? 0 : 1;
        this.width = i;
        this.height = i2;
        this.fps = i3;
        this.cameraFacing = i4;
        this.cameraSelect = i4 == 0 ? selectCameraBack() : selectCameraFront();
        start();
    }

    public void start(int i, int i2, int i3) throws IOException {
        start(this.cameraFacing == 0 ? CameraHelper.Facing.BACK : CameraHelper.Facing.FRONT, i, i2, i3);
    }

    private void start() throws IOException {
        if (!checkCanOpen()) {
            throw new CameraOpenException("This camera resolution cant be opened");
        }
        this.yuvBuffer = new byte[((this.width * this.height) * 3) / 2];
        try {
            Camera camera = staticCamera;
            if (camera != null) {
                this.camera = camera;
                staticCamera = null;
            } else {
                this.camera = Camera.open(this.cameraSelect);
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(this.cameraSelect, cameraInfo);
            this.isFrontCamera = cameraInfo.facing == 1;
            this.isPortrait = this.context.getResources().getConfiguration().orientation == 1;
            Camera.Parameters parameters = this.camera.getParameters();
            parameters.setPreviewSize(this.width, this.height);
            parameters.setPreviewFormat(this.imageFormat);
            int[] iArrAdaptFpsRange = adaptFpsRange(this.fps, parameters.getSupportedPreviewFpsRange());
            parameters.setPreviewFpsRange(iArrAdaptFpsRange[0], iArrAdaptFpsRange[1]);
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null && !supportedFocusModes.isEmpty()) {
                if (supportedFocusModes.contains("continuous-picture")) {
                    parameters.setFocusMode("continuous-picture");
                } else if (supportedFocusModes.contains("auto")) {
                    parameters.setFocusMode("auto");
                } else {
                    parameters.setFocusMode(supportedFocusModes.get(0));
                }
            }
            this.camera.setParameters(parameters);
            this.camera.setDisplayOrientation(this.rotation);
            SurfaceView surfaceView = this.surfaceView;
            if (surfaceView != null) {
                this.camera.setPreviewDisplay(surfaceView.getHolder());
                this.camera.addCallbackBuffer(this.yuvBuffer);
                this.camera.setPreviewCallbackWithBuffer(this);
            } else {
                TextureView textureView = this.textureView;
                if (textureView != null) {
                    this.camera.setPreviewTexture(textureView.getSurfaceTexture());
                    this.camera.addCallbackBuffer(this.yuvBuffer);
                    this.camera.setPreviewCallbackWithBuffer(this);
                } else {
                    this.camera.setPreviewTexture(this.surfaceTexture);
                }
            }
            this.camera.startPreview();
            this.running = true;
            Log.i(this.TAG, this.width + "X" + this.height);
        } catch (IOException e) {
            Log.e(this.TAG, "Error", e);
        }
    }

    private int selectCameraBack() {
        return selectCamera(0);
    }

    private int selectCameraFront() {
        return selectCamera(1);
    }

    private int selectCamera(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return 0;
    }

    public void stop() {
        Camera camera = this.camera;
        if (camera != null) {
            camera.stopPreview();
            this.camera.setPreviewCallback(null);
            this.camera.setPreviewCallbackWithBuffer(null);
            this.camera.release();
            this.camera = null;
        }
        this.running = false;
    }

    public boolean isRunning() {
        return this.running;
    }

    private int[] adaptFpsRange(int i, List<int[]> list) {
        int iAbs;
        int i2 = i * CloseCodes.NORMAL_CLOSURE;
        int[] iArr = list.get(0);
        int iAbs2 = Math.abs(iArr[0] - i2) + Math.abs(iArr[1] - i2);
        for (int[] iArr2 : list) {
            if (iArr2[0] <= i2 && iArr2[1] >= i2 && (iAbs = Math.abs(iArr2[0] - i2) + Math.abs(iArr2[1] - i2)) < iAbs2) {
                iArr = iArr2;
                iAbs2 = iAbs;
            }
        }
        return iArr;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.getCameraData.inputYUVData(new Frame(bArr, this.rotation, this.isFrontCamera && this.isPortrait, this.imageFormat));
        camera.addCallbackBuffer(this.yuvBuffer);
    }

    private List<Camera.Size> getPreviewSize() {
        Camera.Size maxEncoderSizeSupported;
        List<Camera.Size> supportedPreviewSizes;
        if (this.camera != null) {
            maxEncoderSizeSupported = getMaxEncoderSizeSupported();
            supportedPreviewSizes = this.camera.getParameters().getSupportedPreviewSizes();
        } else {
            Camera camera = staticCamera;
            if (camera != null) {
                this.camera = camera;
                staticCamera = null;
            } else {
                this.camera = Camera.open(this.cameraSelect);
            }
            maxEncoderSizeSupported = getMaxEncoderSizeSupported();
            List<Camera.Size> supportedPreviewSizes2 = this.camera.getParameters().getSupportedPreviewSizes();
            this.camera.release();
            this.camera = null;
            supportedPreviewSizes = supportedPreviewSizes2;
        }
        Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
        while (it.hasNext()) {
            Camera.Size next = it.next();
            if (next.width > maxEncoderSizeSupported.width || next.height > maxEncoderSizeSupported.height) {
                Log.i(this.TAG, next.width + "X" + next.height + ", not supported for encoder");
                it.remove();
            }
        }
        return supportedPreviewSizes;
    }

    public List<Camera.Size> getPreviewSizeFront() {
        return this.previewSizeFront;
    }

    private Camera.Size getMaxEncoderSizeSupported() {
        if (CamcorderProfile.hasProfile(8)) {
            Camera camera = this.camera;
            camera.getClass();
            return new Camera.Size(camera, 3840, 2160);
        }
        if (CamcorderProfile.hasProfile(6)) {
            Camera camera2 = this.camera;
            camera2.getClass();
            return new Camera.Size(camera2, 1920, 1080);
        }
        if (CamcorderProfile.hasProfile(5)) {
            Camera camera3 = this.camera;
            camera3.getClass();
            return new Camera.Size(camera3, 1280, 720);
        }
        Camera camera4 = this.camera;
        camera4.getClass();
        return new Camera.Size(camera4, 640, 480);
    }

    public void switchCamera() throws IOException, CameraOpenException {
        if (this.camera != null) {
            int i = this.cameraSelect;
            int numberOfCameras = Camera.getNumberOfCameras();
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                if (this.cameraSelect != i2) {
                    this.cameraSelect = i2;
                    if (!checkCanOpen()) {
                        this.cameraSelect = i;
                        throw new CameraOpenException("This camera resolution cant be opened");
                    }
                    stop();
                    this.cameraFacing = this.cameraFacing == 0 ? 1 : 0;
                    start();
                    return;
                }
            }
        }
    }

    private boolean checkCanOpen() {
        List<Camera.Size> list;
        if (this.cameraSelect == selectCameraBack()) {
            list = this.previewSizeBack;
        } else {
            list = this.previewSizeFront;
        }
        for (Camera.Size size : list) {
            if (size.width == this.width && size.height == this.height) {
                return true;
            }
        }
        return false;
    }

    @Override // android.hardware.Camera.FaceDetectionListener
    public void onFaceDetection(Camera.Face[] faceArr, Camera camera) {
        FaceDetectorCallback faceDetectorCallback = this.faceDetectorCallback;
        if (faceDetectorCallback != null) {
            faceDetectorCallback.onGetFaces(faceArr);
        }
    }
}
