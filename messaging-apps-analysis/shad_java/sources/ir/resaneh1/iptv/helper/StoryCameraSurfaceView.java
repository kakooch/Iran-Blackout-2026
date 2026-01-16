package ir.resaneh1.iptv.helper;

import android.app.Activity;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.facebook.stetho.websocket.CloseCodes;
import ir.resaneh1.iptv.helper.StoryUtils;
import ir.resaneh1.iptv.logger.MyLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class StoryCameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private Camera.Size backCameraSizePicture;
    public int basedOnSizeRotation;
    private int cameraFacingType;
    private int currentRotation;
    public String currentVideoPath;
    private Camera.Size frontCameraSizePicture;
    public boolean isVideo;
    public Camera mCamera;
    private SurfaceHolder mHolder;
    private float maxDistance;
    private MediaRecorder mediaRecorder;
    public Map<Integer, StoryUtils.MyPoint> startPositionMap;
    private float startTouchDistance;
    private int startZoom;
    private SurfaceChangeListener surfaceChangeListener;

    public interface SurfaceChangeListener {
        void onSurfaceCreated();

        void onZoomFinished();

        void onZoomStarted();
    }

    public StoryCameraSurfaceView(Activity activity, Camera camera, int i, boolean z, SurfaceChangeListener surfaceChangeListener) {
        super(activity);
        this.startTouchDistance = 0.0f;
        this.mCamera = camera;
        SurfaceHolder holder = getHolder();
        this.mHolder = holder;
        this.isVideo = z;
        holder.addCallback(this);
        this.surfaceChangeListener = surfaceChangeListener;
        this.cameraFacingType = i;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) throws IOException {
        Camera camera;
        MyLog.e("storytest StoryCameraSurfaceView", "surfaceCreated");
        if (surfaceHolder == null || (camera = this.mCamera) == null) {
            return;
        }
        try {
            camera.setPreviewDisplay(surfaceHolder);
            this.startPositionMap = new HashMap();
            setOnTouchListener(new View.OnTouchListener() { // from class: ir.resaneh1.iptv.helper.StoryCameraSurfaceView.1
                /* JADX WARN: Removed duplicated region for block: B:15:0x001e  */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
                @Override // android.view.View.OnTouchListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public boolean onTouch(android.view.View r3, android.view.MotionEvent r4) {
                    /*
                        r2 = this;
                        int r3 = r4.getAction()
                        r3 = r3 & 255(0xff, float:3.57E-43)
                        r0 = 1
                        if (r3 == 0) goto L36
                        if (r3 == r0) goto L1e
                        r1 = 2
                        if (r3 == r1) goto L18
                        r1 = 3
                        if (r3 == r1) goto L1e
                        r1 = 5
                        if (r3 == r1) goto L36
                        r1 = 6
                        if (r3 == r1) goto L1e
                        goto L3b
                    L18:
                        ir.resaneh1.iptv.helper.StoryCameraSurfaceView r3 = ir.resaneh1.iptv.helper.StoryCameraSurfaceView.this
                        ir.resaneh1.iptv.helper.StoryCameraSurfaceView.access$200(r3, r4)
                        goto L3b
                    L1e:
                        ir.resaneh1.iptv.helper.StoryCameraSurfaceView r3 = ir.resaneh1.iptv.helper.StoryCameraSurfaceView.this
                        r1 = 0
                        ir.resaneh1.iptv.helper.StoryCameraSurfaceView.access$000(r3, r4, r1)
                        ir.resaneh1.iptv.helper.StoryCameraSurfaceView r3 = ir.resaneh1.iptv.helper.StoryCameraSurfaceView.this
                        ir.resaneh1.iptv.helper.StoryCameraSurfaceView$SurfaceChangeListener r3 = ir.resaneh1.iptv.helper.StoryCameraSurfaceView.access$100(r3)
                        if (r3 == 0) goto L3b
                        ir.resaneh1.iptv.helper.StoryCameraSurfaceView r3 = ir.resaneh1.iptv.helper.StoryCameraSurfaceView.this
                        ir.resaneh1.iptv.helper.StoryCameraSurfaceView$SurfaceChangeListener r3 = ir.resaneh1.iptv.helper.StoryCameraSurfaceView.access$100(r3)
                        r3.onZoomFinished()
                        goto L3b
                    L36:
                        ir.resaneh1.iptv.helper.StoryCameraSurfaceView r3 = ir.resaneh1.iptv.helper.StoryCameraSurfaceView.this
                        ir.resaneh1.iptv.helper.StoryCameraSurfaceView.access$000(r3, r4, r0)
                    L3b:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.helper.StoryCameraSurfaceView.AnonymousClass1.onTouch(android.view.View, android.view.MotionEvent):boolean");
                }
            });
            this.mCamera.startPreview();
        } catch (Exception unused) {
        }
        SurfaceChangeListener surfaceChangeListener = this.surfaceChangeListener;
        if (surfaceChangeListener != null) {
            surfaceChangeListener.onSurfaceCreated();
        }
    }

    public void refreshCamera(Camera camera) throws IOException {
        if (camera == null || this.mHolder.getSurface() == null) {
            return;
        }
        try {
            this.mCamera.stopPreview();
        } catch (Exception unused) {
        }
        setCamera(camera);
        try {
            this.mCamera.setPreviewDisplay(this.mHolder);
            setPictureVideoMode(this.isVideo);
            this.mCamera.startPreview();
        } catch (Exception e) {
            Log.d("View", "Error starting camera preview: " + e.getMessage());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) throws IOException {
        MyLog.e("StoryCameraSurfaceView", "w " + i2 + " h " + i3);
        this.maxDistance = (float) Math.sqrt((double) ((i2 * i2) + (i3 * i3)));
        refreshCamera(this.mCamera);
    }

    public void setCamera(Camera camera) {
        this.mCamera = camera;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.reset();
            this.mediaRecorder.release();
            this.mediaRecorder = null;
        }
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.stopPreview();
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    private int findFacingCameraId(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    public void setCameraDisplayOrientation() {
        int i;
        int i2;
        if (ApplicationLoader.applicationActivity == null || this.mCamera == null) {
            return;
        }
        int iFindFacingCameraId = findFacingCameraId(this.cameraFacingType);
        Camera.Parameters parameters = this.mCamera.getParameters();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(iFindFacingCameraId, cameraInfo);
        int rotation = ApplicationLoader.applicationActivity.getWindowManager().getDefaultDisplay().getRotation();
        int i3 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i3 = 90;
            } else if (rotation == 2) {
                i3 = 180;
            } else if (rotation == 3) {
                i3 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            i = (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
        } else {
            i = ((cameraInfo.orientation - i3) + 360) % 360;
        }
        this.mCamera.setDisplayOrientation(i);
        this.currentRotation = i;
        int i4 = cameraInfo.facing;
        if (i4 == 1) {
            i2 = ((cameraInfo.orientation + 360) + i3) % 360;
        } else {
            i2 = ((cameraInfo.orientation + 360) - i3) % 360;
        }
        if (i4 == 1) {
            this.currentRotation = ((cameraInfo.orientation - i3) + 360) % 360;
        } else {
            this.currentRotation = (cameraInfo.orientation + i3) % 360;
        }
        MyLog.e("StoryCameraSurfaceView", "currentRotation " + this.currentRotation + " rotate " + i2 + " rotation " + rotation);
        parameters.setRotation(i2);
        Camera.Size pictureOrVideoSize = getPictureOrVideoSize(parameters);
        if (pictureOrVideoSize != null) {
            parameters.setPictureSize(pictureOrVideoSize.width, pictureOrVideoSize.height);
        }
        Camera.Size previewSize = getPreviewSize(parameters);
        if (previewSize != null) {
            parameters.setPreviewSize(previewSize.width, previewSize.height);
        }
        this.mCamera.setParameters(parameters);
    }

    public boolean isRotated() {
        return this.basedOnSizeRotation != 0;
    }

    public float getBackCameraPictureSizeHWRatio() {
        Camera camera;
        if (this.backCameraSizePicture == null && (camera = this.mCamera) != null) {
            this.backCameraSizePicture = getPictureOrVideoSize(camera.getParameters());
        }
        if (this.backCameraSizePicture != null) {
            float f = (r0.height * 1.0f) / (r0.width * 1.0f);
            return (f >= 1.0f || f == 0.0f) ? f : 1.0f / f;
        }
        return DimensionHelper.getStoryHWRatio();
    }

    public float getFrontCameraPictureSizeHWRatio() {
        Camera camera;
        if (this.frontCameraSizePicture == null && (camera = this.mCamera) != null) {
            this.frontCameraSizePicture = getPictureOrVideoSize(camera.getParameters());
        }
        if (this.frontCameraSizePicture != null) {
            float f = (r0.height * 1.0f) / (r0.width * 1.0f);
            return (f >= 1.0f || f == 0.0f) ? f : 1.0f / f;
        }
        return DimensionHelper.getStoryHWRatio();
    }

    private Camera.Size getPictureOrVideoSize(Camera.Parameters parameters) {
        return getSize(parameters, false);
    }

    private Camera.Size getPreviewSize(Camera.Parameters parameters) {
        return getSize(parameters, true);
    }

    private Camera.Size getSize(Camera.Parameters parameters, boolean z) {
        List<Camera.Size> supportedPictureSizes;
        Camera.Size size = null;
        if (parameters == null) {
            return null;
        }
        if (z) {
            supportedPictureSizes = parameters.getSupportedPreviewSizes();
        } else if (this.isVideo) {
            supportedPictureSizes = parameters.getSupportedVideoSizes();
        } else {
            supportedPictureSizes = parameters.getSupportedPictureSizes();
        }
        if (supportedPictureSizes == null) {
            return null;
        }
        int iDp = AndroidUtilities.dp(DimensionHelper.getStoryWidth()) * 2;
        float storyHWRatio = DimensionHelper.getStoryHWRatio();
        float f = 100.0f;
        float f2 = 10000.0f;
        for (Camera.Size size2 : supportedPictureSizes) {
            float fAbs = Math.abs(((size2.width * 1.0f) / size2.height) - storyHWRatio);
            if (fAbs <= f) {
                if (fAbs != 0.0f || f != 0.0f || Math.abs(size2.height - iDp) <= f2) {
                    float fAbs2 = Math.abs(size2.height - iDp);
                    this.basedOnSizeRotation = 90;
                    f2 = fAbs2;
                    size = size2;
                    f = fAbs;
                }
            }
            float fAbs3 = Math.abs(((size2.height * 1.0f) / size2.width) - storyHWRatio);
            if (fAbs3 <= f && (fAbs3 != 0.0f || f != 0.0f || Math.abs(size2.width - iDp) <= f2)) {
                float fAbs4 = Math.abs(size2.width - iDp);
                this.basedOnSizeRotation = 0;
                f2 = fAbs4;
                size = size2;
                f = fAbs3;
            }
        }
        MyLog.e("StoryCameraSurfaceView", size != null ? size.width + " " + size.height + " " + (((size.height * 1.0f) / size.width) * 1.0f) : " null ");
        return size;
    }

    private void initRecorder(int i, Camera.Parameters parameters) throws IllegalStateException, IOException, IllegalArgumentException {
        if (this.mHolder.getSurface() == null || this.mCamera == null) {
            return;
        }
        try {
            MediaRecorder mediaRecorder = new MediaRecorder();
            this.mediaRecorder = mediaRecorder;
            mediaRecorder.setPreviewDisplay(this.mHolder.getSurface());
            this.mediaRecorder.setCamera(this.mCamera);
            String absolutePath = AndroidUtilities.generateVideoPath().getAbsolutePath();
            this.currentVideoPath = absolutePath;
            this.mediaRecorder.setOutputFile(absolutePath);
            this.mediaRecorder.setMaxFileSize(1073741824L);
            CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
            this.mediaRecorder.setAudioSource(1);
            this.mediaRecorder.setAudioSamplingRate(camcorderProfile.audioSampleRate);
            this.mediaRecorder.setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            this.mediaRecorder.setVideoSource(0);
            this.mediaRecorder.setOutputFormat(2);
            this.mediaRecorder.setAudioEncoder(3);
            this.mediaRecorder.setVideoEncoder(2);
            this.mediaRecorder.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
            this.mediaRecorder.setVideoFrameRate(camcorderProfile.videoFrameRate);
            Camera.Size pictureOrVideoSize = getPictureOrVideoSize(parameters);
            if (pictureOrVideoSize != null) {
                this.mediaRecorder.setVideoSize(pictureOrVideoSize.width, pictureOrVideoSize.height);
            }
            this.mediaRecorder.setMaxDuration(i * CloseCodes.NORMAL_CLOSURE);
            this.mediaRecorder.setOrientationHint(this.currentRotation);
            this.mediaRecorder.prepare();
            this.mediaRecorder.start();
        } catch (IllegalStateException e) {
            MyLog.handleException(e);
            MediaRecorder mediaRecorder2 = this.mediaRecorder;
            if (mediaRecorder2 != null) {
                mediaRecorder2.release();
            }
            this.mediaRecorder = null;
        }
    }

    public void startRecord(int i) throws IllegalStateException, IllegalArgumentException {
        if (this.mCamera == null) {
            this.mCamera = Camera.open();
        }
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        this.mCamera.unlock();
        try {
            initRecorder(i, parameters);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopRecord() throws IllegalStateException {
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
                this.mediaRecorder.release();
                this.mediaRecorder = null;
            } catch (Exception unused) {
            }
        }
    }

    public String getCurrentVideoPath() {
        return this.currentVideoPath;
    }

    public void setPictureVideoMode(boolean z) {
        if (this.mCamera == null) {
            return;
        }
        this.isVideo = z;
        setCameraDisplayOrientation();
        Camera.Parameters parameters = this.mCamera.getParameters();
        ArrayList arrayList = new ArrayList(parameters.getSupportedFocusModes());
        String str = arrayList.contains("continuous-video") ? z ? "continuous-video" : "continuous-picture" : null;
        if (str != null && arrayList.contains(str)) {
            parameters.setFocusMode(str);
        } else if (arrayList.contains("auto")) {
            parameters.setFocusMode("auto");
        }
        this.mCamera.setParameters(parameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUpAndDownEvents(MotionEvent motionEvent, boolean z) {
        int pointerCount = motionEvent.getPointerCount();
        int actionIndex = motionEvent.getActionIndex();
        if (actionIndex == 0 || actionIndex == 1) {
            for (int i = 0; i < pointerCount; i++) {
                this.startPositionMap.put(Integer.valueOf(motionEvent.getPointerId(i)), new StoryUtils.MyPoint(motionEvent.getPointerId(i), motionEvent.getX(i), motionEvent.getY(i)));
            }
        }
        if (pointerCount == 2) {
            this.startTouchDistance = distance(motionEvent, 0, 1);
            Camera camera = this.mCamera;
            if (camera != null) {
                this.startZoom = camera.getParameters().getZoom();
            }
        } else {
            this.startTouchDistance = 0.0f;
        }
        if (z) {
            this.startPositionMap.put(Integer.valueOf(motionEvent.getPointerId(actionIndex)), new StoryUtils.MyPoint(motionEvent.getPointerId(actionIndex), motionEvent.getX(actionIndex), motionEvent.getY(actionIndex)));
        } else {
            this.startPositionMap.remove(Integer.valueOf(motionEvent.getPointerId(actionIndex)));
            if (actionIndex == 0) {
                for (int i2 = 1; i2 < pointerCount; i2++) {
                    this.startPositionMap.put(Integer.valueOf(motionEvent.getPointerId(i2)), new StoryUtils.MyPoint(motionEvent.getPointerId(i2), motionEvent.getX(i2), motionEvent.getY(i2)));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "down" : "up");
        sb.append(" ");
        sb.append(motionEvent.getPointerId(motionEvent.getActionIndex()));
        sb.append(" index ");
        sb.append(motionEvent.getActionIndex());
        MyLog.e("AddStoryFragment", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIsPinchGesture(MotionEvent motionEvent) {
        if (this.mCamera != null && motionEvent.getPointerCount() == 2) {
            float fDistance = distance(motionEvent, 0, 1);
            if (this.startTouchDistance != 0.0f && this.maxDistance > 0.0f) {
                Camera.Parameters parameters = this.mCamera.getParameters();
                int maxZoom = parameters.getMaxZoom();
                parameters.setZoom(Math.max(0, Math.min(this.startZoom + ((int) (((fDistance - this.startTouchDistance) / this.maxDistance) * maxZoom)), maxZoom)));
                this.mCamera.setParameters(parameters);
                SurfaceChangeListener surfaceChangeListener = this.surfaceChangeListener;
                if (surfaceChangeListener != null) {
                    surfaceChangeListener.onZoomStarted();
                }
                return true;
            }
        }
        return false;
    }

    public float distance(MotionEvent motionEvent, int i, int i2) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(i) - motionEvent.getX(i2);
        float y = motionEvent.getY(i) - motionEvent.getY(i2);
        return (float) Math.sqrt((x * x) + (y * y));
    }
}
