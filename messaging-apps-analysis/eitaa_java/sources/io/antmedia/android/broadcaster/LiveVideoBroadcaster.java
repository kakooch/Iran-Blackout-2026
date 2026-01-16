package io.antmedia.android.broadcaster;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.AudioRecord;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import io.antmedia.android.R$string;
import io.antmedia.android.broadcaster.CameraHandler;
import io.antmedia.android.broadcaster.ILiveVideoBroadcaster;
import io.antmedia.android.broadcaster.encoder.AudioHandler;
import io.antmedia.android.broadcaster.encoder.CameraSurfaceRenderer;
import io.antmedia.android.broadcaster.encoder.TextureMovieEncoder;
import io.antmedia.android.broadcaster.encoder.VideoEncoderCore;
import io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram;
import io.antmedia.android.broadcaster.network.RTMPStreamer;
import io.antmedia.android.broadcaster.utils.Resolution;
import io.antmedia.android.broadcaster.utils.Utils;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class LiveVideoBroadcaster extends Service implements ILiveVideoBroadcaster, CameraHandler.ICameraViewer, SurfaceTexture.OnFrameAvailableListener {
    private static volatile CameraProxy sCameraProxy;
    private static volatile boolean sCameraReleased;
    private AudioHandler audioHandler;
    private HandlerThread audioHandlerThread;
    private AudioRecorderThread audioThread;
    private ArrayList<Resolution> choosenPreviewsSizeList;
    private ConnectivityManager connectivityManager;
    private Activity context;
    private Delegate delegate;
    private AlertDialog mAlertDialog;
    private CameraHandler mCameraHandler;
    private GLSurfaceView mGLView;
    private CameraSurfaceRenderer mRenderer;
    private HandlerThread mRtmpHandlerThread;
    private RTMPStreamer mRtmpStreamer;
    private Resolution previewSize;
    private ILiveVideoBroadcaster.TakePhotoCallback takePhotoCallback;
    private static final String TAG = LiveVideoBroadcaster.class.getSimpleName();
    private static TextureMovieEncoder sVideoEncoder = new TextureMovieEncoder();
    private boolean isRecording = false;
    private final IBinder mBinder = new LocalBinder();
    private int currentCameraId = 0;
    private int frameRate = 20;
    private boolean adaptiveStreamingEnabled = false;
    private Timer adaptiveStreamingTimer = null;
    private int maxVideoWidth = 720;
    private boolean takePhoto = false;
    private boolean videoMuteFromUser = false;
    private Boolean videoMute = Boolean.FALSE;

    public interface Delegate {
        void onNewFrameAvailable();

        void onPreviewSizeChanged(int width, int height);

        void onVideoMuted(boolean muted, boolean fromUser);
    }

    public boolean isConnected() {
        RTMPStreamer rTMPStreamer = this.mRtmpStreamer;
        if (rTMPStreamer != null) {
            return rTMPStreamer.isConnected();
        }
        return false;
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Delegate delegate = this.delegate;
        if (delegate != null) {
            delegate.onNewFrameAvailable();
        }
        this.mGLView.requestRender();
    }

    public void pause() throws IllegalStateException, InterruptedException {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.mAlertDialog.dismiss();
        }
        this.mGLView.setVisibility(8);
        stopBroadcasting();
        this.mGLView.queueEvent(new Runnable() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.1
            @Override // java.lang.Runnable
            public void run() {
                LiveVideoBroadcaster.this.mRenderer.notifyPausing();
                boolean unused = LiveVideoBroadcaster.sCameraReleased;
                LiveVideoBroadcaster.this.releaseCamera();
            }
        });
        this.mGLView.onPause();
        this.mGLView.setOnTouchListener(null);
    }

    public ArrayList<Resolution> getPreviewSizeList() {
        return this.choosenPreviewsSizeList;
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public ILiveVideoBroadcaster getService() {
            return LiveVideoBroadcaster.this;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.audioHandlerThread.quitSafely();
            this.mRtmpHandlerThread.quitSafely();
            this.mCameraHandler.invalidateHandler();
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    public void init(Activity activity, GLSurfaceView glView) {
        try {
            HandlerThread handlerThread = new HandlerThread("AudioHandlerThread", -16);
            this.audioHandlerThread = handlerThread;
            handlerThread.start();
            this.audioHandler = new AudioHandler(this.audioHandlerThread.getLooper());
            this.mCameraHandler = new CameraHandler(this);
            this.context = activity;
            CameraSurfaceRenderer cameraSurfaceRenderer = new CameraSurfaceRenderer(this.mCameraHandler, sVideoEncoder) { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.2
                @Override // io.antmedia.android.broadcaster.encoder.CameraSurfaceRenderer, android.opengl.GLSurfaceView.Renderer
                public void onDrawFrame(GL10 unused) {
                    int measuredHeight;
                    super.onDrawFrame(unused);
                    if (LiveVideoBroadcaster.this.takePhoto) {
                        LiveVideoBroadcaster.this.takePhoto = false;
                        int measuredWidth = 400;
                        if (LiveVideoBroadcaster.this.mGLView != null) {
                            measuredWidth = LiveVideoBroadcaster.this.mGLView.getMeasuredWidth();
                            measuredHeight = LiveVideoBroadcaster.this.mGLView.getMeasuredHeight();
                        } else {
                            measuredHeight = 400;
                        }
                        int i = measuredWidth * measuredHeight;
                        final int[] iArr = new int[i];
                        final int[] iArr2 = new int[i];
                        IntBuffer intBufferWrap = IntBuffer.wrap(iArr);
                        intBufferWrap.position(0);
                        try {
                            GLES20.glReadPixels(0, 0, measuredWidth, measuredHeight, 6408, 5121, intBufferWrap);
                        } catch (Exception e) {
                            Log.e(LiveVideoBroadcaster.TAG, "createBitmapFromGLSurface: " + e.getMessage(), e);
                        }
                        final int i2 = measuredHeight;
                        final int i3 = measuredWidth;
                        new Thread() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.2.1
                            @Override // java.lang.Thread, java.lang.Runnable
                            public void run() {
                                int i4;
                                int i5 = 0;
                                while (true) {
                                    i4 = i2;
                                    if (i5 >= i4) {
                                        break;
                                    }
                                    int i6 = i3;
                                    int i7 = i5 * i6;
                                    int i8 = ((i4 - i5) - 1) * i6;
                                    for (int i9 = 0; i9 < i3; i9++) {
                                        int i10 = iArr[i7 + i9];
                                        iArr2[i8 + i9] = (i10 & (-16711936)) | ((i10 << 16) & 16711680) | ((i10 >> 16) & 255);
                                    }
                                    i5++;
                                }
                                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr2, i3, i4, Bitmap.Config.ARGB_8888);
                                if (LiveVideoBroadcaster.this.takePhotoCallback != null) {
                                    LiveVideoBroadcaster.this.takePhotoCallback.onTakePhoto(bitmapCreateBitmap);
                                }
                            }
                        }.start();
                    }
                }
            };
            this.mRenderer = cameraSurfaceRenderer;
            int i = this.maxVideoWidth;
            int i2 = 240;
            if (i >= 720) {
                i2 = 720;
            } else if (i >= 480) {
                i2 = 480;
            } else if (i >= 360) {
                i2 = 360;
            } else if (i >= 288) {
                i2 = 288;
            } else if (i < 240) {
                i2 = 144;
            }
            cameraSurfaceRenderer.setEncoderWidth(i2);
            this.mGLView = glView;
            glView.setRenderer(this.mRenderer);
            this.mGLView.setRenderMode(0);
            HandlerThread handlerThread2 = new HandlerThread("RtmpStreamerThread");
            this.mRtmpHandlerThread = handlerThread2;
            handlerThread2.start();
            this.mRtmpStreamer = new RTMPStreamer(this.mRtmpHandlerThread.getLooper());
            this.connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void takePhoto(ILiveVideoBroadcaster.TakePhotoCallback takePhotoCallback) {
        this.takePhotoCallback = takePhotoCallback;
        this.takePhoto = true;
    }

    public boolean hasConnection() {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public int startBroadcasting(String rtmpUrl) {
        this.isRecording = false;
        if (sCameraProxy == null || sCameraProxy.isReleased()) {
            Log.w(TAG, "Camera should be opened before calling this function");
            return -1000;
        }
        if (!hasConnection()) {
            Log.w(TAG, "There is no active network connection");
        }
        if (Utils.doesEncoderWorks(this.context) != 1) {
            Log.w(TAG, "This device does not have hardware encoder");
            showAlert(getString(R$string.not_eligible_for_broadcast));
            return -2000;
        }
        int iOpen = -3000;
        try {
            iOpen = this.mRtmpStreamer.open(rtmpUrl);
            if (iOpen > 0) {
                final long jCurrentTimeMillis = System.currentTimeMillis();
                this.mGLView.queueEvent(new Runnable() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveVideoBroadcaster.this.mRenderer.setOptions(LiveVideoBroadcaster.this.mRtmpStreamer);
                        LiveVideoBroadcaster.this.setRendererPreviewSize();
                        LiveVideoBroadcaster.this.mRenderer.startRecording(jCurrentTimeMillis);
                    }
                });
                this.audioHandler.startAudioEncoder(this.mRtmpStreamer, 44100, AudioRecord.getMinBufferSize(44100, 16, 2));
                AudioRecorderThread audioRecorderThread = new AudioRecorderThread(44100, jCurrentTimeMillis, this.audioHandler);
                this.audioThread = audioRecorderThread;
                audioRecorderThread.start();
                this.isRecording = true;
                if (this.adaptiveStreamingEnabled) {
                    if (!this.videoMuteFromUser) {
                        setVideoMuted(false, false);
                    }
                    Timer timer = new Timer();
                    this.adaptiveStreamingTimer = timer;
                    timer.schedule(new TimerTask() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.4
                        private float changeRange = 0.02f;
                        private boolean bitrateDecreased = false;
                        private boolean bitrateIncreased = false;
                        private int oldBitrate = -1;
                        private int adaptiveBitrate = -1;

                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            int lastVideoFrameTimeStampInQueue = LiveVideoBroadcaster.this.mRtmpStreamer.getLastVideoFrameTimeStampInQueue() - LiveVideoBroadcaster.this.mRtmpStreamer.getLastVideoFrameTimeStamp();
                            Log.v("bytesInQueue", "lastTimeStampInQueue: " + LiveVideoBroadcaster.this.mRtmpStreamer.getLastVideoFrameTimeStampInQueue());
                            Log.v("bytesInQueue", "lastTimeStampSent: " + LiveVideoBroadcaster.this.mRtmpStreamer.getLastVideoFrameTimeStamp());
                            Log.v("bytesInQueue", "delta: " + lastVideoFrameTimeStampInQueue);
                            synchronized (LiveVideoBroadcaster.this.videoMute) {
                                if (!LiveVideoBroadcaster.this.videoMuteFromUser) {
                                    if (lastVideoFrameTimeStampInQueue <= 15000 || LiveVideoBroadcaster.this.videoMute.booleanValue()) {
                                        if (lastVideoFrameTimeStampInQueue < 3000 && LiveVideoBroadcaster.this.videoMute.booleanValue()) {
                                            LiveVideoBroadcaster.this.setVideoMuted(false, false);
                                        }
                                    } else {
                                        LiveVideoBroadcaster.this.setVideoMuted(true, false);
                                    }
                                }
                            }
                        }
                    }, 0L, 1000L);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iOpen;
    }

    public void stopBroadcasting() throws IllegalStateException, InterruptedException {
        if (this.isRecording) {
            this.mGLView.queueEvent(new Runnable() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.5
                @Override // java.lang.Runnable
                public void run() {
                    LiveVideoBroadcaster.this.mRenderer.stopRecording();
                }
            });
            Timer timer = this.adaptiveStreamingTimer;
            if (timer != null) {
                timer.cancel();
                this.adaptiveStreamingTimer = null;
            }
            AudioRecorderThread audioRecorderThread = this.audioThread;
            if (audioRecorderThread != null) {
                audioRecorderThread.stopAudioRecording();
            }
            AudioHandler audioHandler = this.audioHandler;
            if (audioHandler != null) {
                audioHandler.sendEmptyMessage(2);
            }
            int i = 0;
            while (sVideoEncoder.isRecording()) {
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i > 5) {
                    sVideoEncoder.stopRecording();
                    return;
                }
                i++;
            }
        }
    }

    public void setMaxVideoWidth(int maxVideoWidth) {
        this.maxVideoWidth = maxVideoWidth;
        CameraSurfaceRenderer cameraSurfaceRenderer = this.mRenderer;
        if (cameraSurfaceRenderer != null) {
            cameraSurfaceRenderer.setEncoderWidth(maxVideoWidth);
        }
    }

    public int getCurrentBitrate() {
        CameraSurfaceRenderer cameraSurfaceRenderer = this.mRenderer;
        if (cameraSurfaceRenderer != null) {
            return cameraSurfaceRenderer.getBitrate();
        }
        return 0;
    }

    public int getCurrentFrameRate() {
        CameraSurfaceRenderer cameraSurfaceRenderer = this.mRenderer;
        if (cameraSurfaceRenderer != null) {
            return cameraSurfaceRenderer.getFrameRate();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRendererPreviewSize() {
        int rotation = this.context.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0 || rotation == 2) {
            this.mGLView.queueEvent(new Runnable() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.6
                @Override // java.lang.Runnable
                public void run() {
                    LiveVideoBroadcaster.this.mRenderer.setCameraPreviewSize(LiveVideoBroadcaster.this.previewSize.height, LiveVideoBroadcaster.this.previewSize.width);
                }
            });
        } else {
            this.mGLView.queueEvent(new Runnable() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.7
                @Override // java.lang.Runnable
                public void run() {
                    LiveVideoBroadcaster.this.mRenderer.setCameraPreviewSize(LiveVideoBroadcaster.this.previewSize.width, LiveVideoBroadcaster.this.previewSize.height);
                }
            });
        }
    }

    @Override // io.antmedia.android.broadcaster.CameraHandler.ICameraViewer
    public void handleSetSurfaceTexture(SurfaceTexture st) {
        if (sCameraProxy == null || this.context.isFinishing() || st == null) {
            return;
        }
        st.setOnFrameAvailableListener(this);
        sCameraProxy.stopPreview();
        sCameraProxy.setPreviewTexture(st);
        sCameraProxy.startPreview();
    }

    public void openCamera(int cameraId) {
        if (!isPermissionGranted()) {
            requestPermission();
            return;
        }
        if (cameraId == 1 && !getPackageManager().hasSystemFeature("android.hardware.camera.front")) {
            cameraId = 0;
        }
        this.currentCameraId = cameraId;
        this.mGLView.setVisibility(8);
        new AsyncTask<Integer, Void, Camera.Parameters>() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.8
            @Override // android.os.AsyncTask
            protected void onPreExecute() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Camera.Parameters doInBackground(Integer... params) throws Throwable {
                Camera.Parameters parameters;
                boolean unused = LiveVideoBroadcaster.sCameraReleased = false;
                System.out.println("--- releaseCamera call in doInBackground --- ");
                LiveVideoBroadcaster.this.releaseCamera();
                int i = 0;
                do {
                    parameters = null;
                    try {
                        CameraProxy unused2 = LiveVideoBroadcaster.sCameraProxy = new CameraProxy(params[0].intValue());
                        if (LiveVideoBroadcaster.sCameraProxy.isCameraAvailable()) {
                            break;
                        }
                        Thread.sleep(1000L);
                        i++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } while (i <= 3);
                if (!LiveVideoBroadcaster.sCameraProxy.isCameraAvailable()) {
                    CameraProxy unused3 = LiveVideoBroadcaster.sCameraProxy = null;
                } else {
                    System.out.println("--- camera opened --- ");
                    parameters = LiveVideoBroadcaster.sCameraProxy.getParameters();
                    if (parameters != null) {
                        LiveVideoBroadcaster.this.setCameraParameters(parameters);
                        if (Utils.doesEncoderWorks(LiveVideoBroadcaster.this.context) == -1) {
                            Utils.setEncoderWorks(LiveVideoBroadcaster.this.context, VideoEncoderCore.doesEncoderWork(LiveVideoBroadcaster.this.previewSize.width, LiveVideoBroadcaster.this.previewSize.height, 300000, 20));
                        }
                    }
                }
                Log.d(LiveVideoBroadcaster.TAG, "onResume complete: " + this);
                return parameters;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Camera.Parameters parameters) {
                if (LiveVideoBroadcaster.this.context.isFinishing()) {
                    LiveVideoBroadcaster.this.releaseCamera();
                    return;
                }
                if (LiveVideoBroadcaster.sCameraProxy != null && parameters != null) {
                    LiveVideoBroadcaster.this.mGLView.setVisibility(0);
                    LiveVideoBroadcaster.this.mGLView.onResume();
                    LiveVideoBroadcaster.this.setRendererPreviewSize();
                    if (Utils.doesEncoderWorks(LiveVideoBroadcaster.this.context) != 1) {
                        LiveVideoBroadcaster.this.showEncoderNotExistDialog();
                        return;
                    }
                    return;
                }
                LiveVideoBroadcaster liveVideoBroadcaster = LiveVideoBroadcaster.this;
                liveVideoBroadcaster.showAlert(liveVideoBroadcaster.getString(R$string.camera_not_running_properly));
            }
        }.execute(Integer.valueOf(this.currentCameraId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCamera() {
        try {
            if (sCameraProxy != null) {
                System.out.println("releaseCamera stop preview");
                sCameraProxy.release();
                sCameraProxy = null;
                sCameraReleased = true;
                System.out.println("-- camera released --");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAdaptiveStreaming(boolean enable) {
        this.adaptiveStreamingEnabled = enable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCameraParameters(Camera.Parameters parameters) {
        int i = Resources.getSystem().getDisplayMetrics().heightPixels;
        int i2 = Resources.getSystem().getDisplayMetrics().widthPixels;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        Collections.sort(supportedPreviewSizes, new AnonymousClass9());
        this.choosenPreviewsSizeList = new ArrayList<>();
        float fMax = Math.max(i2, i) / Math.min(i2, i);
        Camera.Size sizeChooseOptimalSize = chooseOptimalSize(supportedPreviewSizes, 480, 270, 1.7777778f);
        if (sizeChooseOptimalSize.width >= 1280 && sizeChooseOptimalSize.height >= 1280) {
            Camera.Size sizeChooseOptimalSize2 = chooseOptimalSize(supportedPreviewSizes, 270, 480, Math.abs(fMax - 1.3333334f) < 0.1f ? 0.75f : 0.5625f);
            if (sizeChooseOptimalSize2.width < 1280 || sizeChooseOptimalSize2.height < 1280) {
                sizeChooseOptimalSize = sizeChooseOptimalSize2;
            }
        }
        int i3 = this.frameRate;
        int[] iArrFindBestFrameRate = findBestFrameRate(parameters.getSupportedPreviewFpsRange(), new int[]{i3 * 1000, i3 * 1000});
        parameters.setPreviewFpsRange(iArrFindBestFrameRate[0], iArrFindBestFrameRate[1]);
        this.choosenPreviewsSizeList.add(new Resolution(sizeChooseOptimalSize.width, sizeChooseOptimalSize.height));
        parameters.setPreviewSize(sizeChooseOptimalSize.width, sizeChooseOptimalSize.height);
        parameters.setRecordingHint(true);
        if (parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
        sCameraProxy.setDisplayOrientation(getCameraDisplayOrientation());
        if (parameters.isVideoStabilizationSupported()) {
            parameters.setVideoStabilization(true);
        }
        sCameraProxy.setParameters(parameters);
        Camera.Size previewSize = parameters.getPreviewSize();
        setPreviewSize(new Resolution(previewSize.width, previewSize.height));
    }

    /* renamed from: io.antmedia.android.broadcaster.LiveVideoBroadcaster$9, reason: invalid class name */
    class AnonymousClass9 implements Comparator<Camera.Size>, j$.util.Comparator {
        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return a.E(this, Comparator.CC.comparing(function));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        AnonymousClass9() {
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Camera.Size lhs, Camera.Size rhs) {
            int i = lhs.height;
            int i2 = rhs.height;
            if (i != i2) {
                return i > i2 ? 1 : -1;
            }
            int i3 = lhs.width;
            int i4 = rhs.width;
            if (i3 == i4) {
                return 0;
            }
            return i3 > i4 ? 1 : -1;
        }
    }

    private static Camera.Size chooseOptimalSize(List<Camera.Size> choices, int width, int height, float aspectRatio) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < choices.size(); i++) {
            Camera.Size size = choices.get(i);
            int i2 = size.height;
            float f = i2;
            int i3 = size.width;
            if (f == i3 / aspectRatio && i3 >= width && i2 >= height) {
                arrayList.add(size);
            }
        }
        if (arrayList.size() > 0) {
            return (Camera.Size) Collections.min(arrayList, new CompareSizesByArea());
        }
        return (Camera.Size) Collections.max(choices, new CompareSizesByArea());
    }

    private static class CompareSizesByArea implements java.util.Comparator<Camera.Size>, j$.util.Comparator {
        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return a.E(this, Comparator.CC.comparing(function));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        private CompareSizesByArea() {
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(Camera.Size lhs, Camera.Size rhs) {
            return Long.signum((lhs.width * lhs.height) - (rhs.width * rhs.height));
        }
    }

    private void setPreviewSize(Resolution resolution) {
        this.previewSize = resolution;
        Delegate delegate = this.delegate;
        if (delegate != null) {
            delegate.onPreviewSizeChanged(resolution.width, resolution.height);
        }
    }

    public boolean isPermissionGranted() {
        return (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) && (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") == 0);
    }

    public void requestPermission() {
        boolean z = ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0;
        boolean z2 = ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") == 0;
        final ArrayList arrayList = new ArrayList();
        if (!z) {
            arrayList.add("android.permission.CAMERA");
        }
        if (!z2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (arrayList.size() > 0) {
            if (!z) {
                AlertDialog alertDialogShow = new AlertDialog.Builder(this.context).setTitle(R$string.permission).setCancelable(false).setMessage(getString(R$string.camera_permission_is_required)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.11
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                        List list = arrayList;
                        ActivityCompat.requestPermissions(LiveVideoBroadcaster.this.context, (String[]) list.toArray(new String[list.size()]), 8954);
                    }
                }).setNegativeButton("Settings", new DialogInterface.OnClickListener() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.10
                    @Override // android.content.DialogInterface.OnClickListener
                    @TargetApi(9)
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.parse("package:" + LiveVideoBroadcaster.this.context.getPackageName()));
                            LiveVideoBroadcaster.this.startActivity(intent);
                        } catch (Exception unused) {
                        }
                    }
                }).show();
                this.mAlertDialog = alertDialogShow;
                alertDialogShow.setCanceledOnTouchOutside(false);
            } else {
                if (!z2) {
                    AlertDialog alertDialogShow2 = new AlertDialog.Builder(this.context).setTitle(R$string.permission).setCancelable(false).setMessage(getString(R$string.microphone_permission_is_required)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.13
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                            List list = arrayList;
                            ActivityCompat.requestPermissions(LiveVideoBroadcaster.this.context, (String[]) list.toArray(new String[list.size()]), 8954);
                        }
                    }).setNegativeButton("Settings", new DialogInterface.OnClickListener() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.12
                        @Override // android.content.DialogInterface.OnClickListener
                        @TargetApi(9)
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.parse("package:" + LiveVideoBroadcaster.this.context.getPackageName()));
                                LiveVideoBroadcaster.this.startActivity(intent);
                            } catch (Exception unused) {
                            }
                        }
                    }).show();
                    this.mAlertDialog = alertDialogShow2;
                    alertDialogShow2.setCanceledOnTouchOutside(false);
                    return;
                }
                ActivityCompat.requestPermissions(this.context, (String[]) arrayList.toArray(new String[arrayList.size()]), 8954);
            }
        }
    }

    public int[] findBestFrameRate(List<int[]> frameRateList, int[] requestedFrameRate) {
        int[] iArr = frameRateList.get(0);
        int i = (requestedFrameRate[0] + requestedFrameRate[1]) / 2;
        int i2 = (iArr[0] + iArr[1]) / 2;
        int size = frameRateList.size();
        for (int i3 = 1; i3 < size; i3++) {
            int[] iArr2 = frameRateList.get(i3);
            int i4 = (iArr2[0] + iArr2[1]) / 2;
            if (Math.abs(i - i2) >= Math.abs(i - i4) && (Math.abs(requestedFrameRate[0] - iArr2[0]) <= Math.abs(requestedFrameRate[0] - iArr[0]) || Math.abs(requestedFrameRate[1] - iArr2[1]) <= Math.abs(requestedFrameRate[1] - iArr[1]))) {
                iArr = iArr2;
                i2 = i4;
            }
        }
        return iArr;
    }

    public void showEncoderNotExistDialog() {
        this.mAlertDialog = new AlertDialog.Builder(this.context).setMessage(R$string.not_eligible_for_broadcast).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
            }
        }).show();
    }

    public int getCameraDisplayOrientation() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.currentCameraId, cameraInfo);
        int rotation = this.context.getWindowManager().getDefaultDisplay().getRotation();
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
            return (360 - ((cameraInfo.orientation + i) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i) + 360) % 360;
    }

    public void changeCamera() {
        if (!getPackageManager().hasSystemFeature("android.hardware.camera.front")) {
            showAlert(getString(R$string.only_one_camera_exists));
            return;
        }
        if (sCameraProxy == null) {
            showAlert(getString(R$string.first_call_open_camera));
            return;
        }
        if (this.currentCameraId == 0) {
            this.currentCameraId = 1;
        } else {
            this.currentCameraId = 0;
        }
        new AsyncTask<Void, Void, Camera.Parameters>() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.15
            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                super.onPreExecute();
                LiveVideoBroadcaster.this.mGLView.queueEvent(new Runnable() { // from class: io.antmedia.android.broadcaster.LiveVideoBroadcaster.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LiveVideoBroadcaster.this.mRenderer.notifyPausing();
                    }
                });
                LiveVideoBroadcaster.this.mGLView.onPause();
                LiveVideoBroadcaster.this.mGLView.setOnTouchListener(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Camera.Parameters doInBackground(Void... voids) {
                LiveVideoBroadcaster.this.releaseCamera();
                try {
                    CameraProxy unused = LiveVideoBroadcaster.sCameraProxy = new CameraProxy(LiveVideoBroadcaster.this.currentCameraId);
                    Camera.Parameters parameters = LiveVideoBroadcaster.sCameraProxy.getParameters();
                    if (parameters == null) {
                        return null;
                    }
                    LiveVideoBroadcaster.this.setCameraParameters(parameters);
                    return parameters;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Camera.Parameters parameters) {
                super.onPostExecute((AnonymousClass15) parameters);
                if (parameters != null) {
                    LiveVideoBroadcaster.this.mGLView.onResume();
                    LiveVideoBroadcaster.this.setRendererPreviewSize();
                } else {
                    LiveVideoBroadcaster liveVideoBroadcaster = LiveVideoBroadcaster.this;
                    liveVideoBroadcaster.showAlert(liveVideoBroadcaster.getString(R$string.camera_not_running_properly));
                }
            }
        }.execute(new Void[0]);
    }

    public void setAudioEnable(boolean enable) {
        AudioRecorderThread audioRecorderThread = this.audioThread;
        if (audioRecorderThread != null) {
            audioRecorderThread.setAudioEnable(enable);
        }
    }

    public void setVideoMuted(boolean mute, boolean fromUser) {
        synchronized (this.videoMute) {
            this.videoMute = Boolean.valueOf(mute);
            if (fromUser) {
                this.videoMuteFromUser = mute;
            }
            CameraSurfaceRenderer cameraSurfaceRenderer = this.mRenderer;
            if (cameraSurfaceRenderer != null) {
                cameraSurfaceRenderer.setPreviewResolution(this.mGLView.getWidth(), this.mGLView.getHeight());
                this.mRenderer.setMuteVideo(mute);
                if (mute && fromUser) {
                    this.mRenderer.setEffect(Texture2dProgram.ProgramType.TEXTURE_EXT_TOGGLE_VIDEO_OFF);
                } else if (mute && !fromUser) {
                    this.mRenderer.setEffect(Texture2dProgram.ProgramType.TEXTURE_EXT_NO_VIDEO);
                } else {
                    this.mRenderer.setEffect(Texture2dProgram.ProgramType.TEXTURE_EXT);
                }
            }
            Delegate delegate = this.delegate;
            if (delegate != null) {
                delegate.onVideoMuted(mute, fromUser);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlert(String message) {
        Toast.makeText(this, message, 1).show();
    }
}
