package ir.eitaa.messenger.voip;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Point;
import android.media.projection.MediaProjection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.voip.VideoCapturerDevice;
import org.webrtc.Camera1Enumerator;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.CapturerObserver;
import org.webrtc.EglBase;
import org.webrtc.Logging;
import org.webrtc.ScreenCapturerAndroid;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.VideoCapturer;
import org.webrtc.voiceengine.WebRtcAudioRecord;

@TargetApi(18)
/* loaded from: classes.dex */
public class VideoCapturerDevice {
    private static final int CAPTURE_FPS = 30;
    private static final int CAPTURE_HEIGHT;
    private static final int CAPTURE_WIDTH;
    public static EglBase eglBase;
    private static VideoCapturerDevice[] instance;
    public static Intent mediaProjectionPermissionResultData;
    private int currentHeight;
    private int currentWidth;
    private Handler handler;
    private CapturerObserver nativeCapturerObserver;
    private long nativePtr;
    private HandlerThread thread;
    private VideoCapturer videoCapturer;
    private SurfaceTextureHelper videoCapturerSurfaceTextureHelper;

    private static native CapturerObserver nativeGetJavaVideoCapturerObserver(long ptr);

    private void onAspectRatioRequested(float aspectRatio) {
    }

    static {
        int i = Build.VERSION.SDK_INT;
        CAPTURE_WIDTH = i <= 19 ? 480 : 1280;
        CAPTURE_HEIGHT = i <= 19 ? 320 : 720;
        instance = new VideoCapturerDevice[2];
    }

    public VideoCapturerDevice(final boolean screencast) {
        if (Build.VERSION.SDK_INT < 18) {
            return;
        }
        Logging.enableLogToDebugOutput(Logging.Severity.LS_INFO);
        Logging.d("VideoCapturerDevice", "device model = " + Build.MANUFACTURER + Build.MODEL);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$SzNCUvDgxS5A65g5EQc7ssZlFiE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$VideoCapturerDevice(screencast);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$VideoCapturerDevice(boolean z) {
        if (eglBase == null) {
            eglBase = EglBase.CC.create(null, EglBase.CONFIG_PLAIN);
        }
        instance[z ? 1 : 0] = this;
        HandlerThread handlerThread = new HandlerThread("CallThread");
        this.thread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.thread.getLooper());
    }

    public static void checkScreenCapturerSize() {
        if (instance[1] == null) {
            return;
        }
        final Point screenCaptureSize = getScreenCaptureSize();
        VideoCapturerDevice[] videoCapturerDeviceArr = instance;
        int i = videoCapturerDeviceArr[1].currentWidth;
        int i2 = screenCaptureSize.x;
        if (i == i2 && videoCapturerDeviceArr[1].currentHeight == screenCaptureSize.y) {
            return;
        }
        videoCapturerDeviceArr[1].currentWidth = i2;
        videoCapturerDeviceArr[1].currentHeight = screenCaptureSize.y;
        final VideoCapturerDevice videoCapturerDevice = videoCapturerDeviceArr[1];
        videoCapturerDeviceArr[1].handler.post(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$KIc2cY13AEFwhoYEYWwQBH5A8ck
            @Override // java.lang.Runnable
            public final void run() {
                VideoCapturerDevice.lambda$checkScreenCapturerSize$1(this.f$0, screenCaptureSize);
            }
        });
    }

    static /* synthetic */ void lambda$checkScreenCapturerSize$1(VideoCapturerDevice videoCapturerDevice, Point point) {
        VideoCapturer videoCapturer = videoCapturerDevice.videoCapturer;
        if (videoCapturer != null) {
            videoCapturer.changeCaptureFormat(point.x, point.y, 30);
        }
    }

    private static Point getScreenCaptureSize() {
        int i;
        int i2;
        Display defaultDisplay = ((WindowManager) ApplicationLoader.applicationContext.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int i3 = point.x;
        int i4 = point.y;
        float f = i3 > i4 ? i4 / i3 : i3 / i4;
        int i5 = 1;
        while (true) {
            if (i5 > 100) {
                i5 = -1;
                i = -1;
                break;
            }
            float f2 = i5 * f;
            i = (int) f2;
            if (f2 != i) {
                i5++;
            } else if (point.x <= point.y) {
                i = i5;
                i5 = i;
            }
        }
        if (i5 != -1 && f != 1.0f) {
            while (true) {
                int i6 = point.x;
                if (i6 <= 1000 && (i2 = point.y) <= 1000 && i6 % 4 == 0 && i2 % 4 == 0) {
                    break;
                }
                int i7 = i6 - i5;
                point.x = i7;
                int i8 = point.y - i;
                point.y = i8;
                if (i7 < 800 && i8 < 800) {
                    i5 = -1;
                    break;
                }
            }
        }
        if (i5 == -1 || f == 1.0f) {
            float fMax = Math.max(point.x / 970.0f, point.y / 970.0f);
            point.x = ((int) Math.ceil((point.x / fMax) / 4.0f)) * 4;
            point.y = ((int) Math.ceil((point.y / fMax) / 4.0f)) * 4;
        }
        return point;
    }

    private void init(final long ptr, final String deviceName) {
        if (Build.VERSION.SDK_INT < 18) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$C2Gav1bxHaZpgpZAXd--YUf7qI0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$init$5$VideoCapturerDevice(ptr, deviceName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$init$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$init$5$VideoCapturerDevice(long j, String str) {
        if (eglBase == null) {
            return;
        }
        this.nativePtr = j;
        if ("screen".equals(str)) {
            if (Build.VERSION.SDK_INT >= 21 && this.videoCapturer == null) {
                this.videoCapturer = new ScreenCapturerAndroid(mediaProjectionPermissionResultData, new AnonymousClass1());
                final Point screenCaptureSize = getScreenCaptureSize();
                this.currentWidth = screenCaptureSize.x;
                this.currentHeight = screenCaptureSize.y;
                this.videoCapturerSurfaceTextureHelper = SurfaceTextureHelper.create("ScreenCapturerThread", eglBase.getEglBaseContext());
                this.handler.post(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$kCThsikqZ-5oqwb35I8Y64j0m8k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$init$2$VideoCapturerDevice(screenCaptureSize);
                    }
                });
                return;
            }
            return;
        }
        CameraEnumerator camera2Enumerator = Camera2Enumerator.isSupported(ApplicationLoader.applicationContext) ? new Camera2Enumerator(ApplicationLoader.applicationContext) : new Camera1Enumerator();
        String[] deviceNames = camera2Enumerator.getDeviceNames();
        int i = 0;
        while (true) {
            if (i >= deviceNames.length) {
                i = -1;
                break;
            } else if (camera2Enumerator.isFrontFacing(deviceNames[i]) == "front".equals(str)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        final String str2 = deviceNames[i];
        if (this.videoCapturer == null) {
            this.videoCapturer = camera2Enumerator.createCapturer(str2, new AnonymousClass2());
            this.videoCapturerSurfaceTextureHelper = SurfaceTextureHelper.create("VideoCapturerThread", eglBase.getEglBaseContext());
            this.handler.post(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$o2hbvw_9X8VcDGM9-l-G-NSgMLI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$init$3$VideoCapturerDevice();
                }
            });
            return;
        }
        this.handler.post(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$EtL-y8AErFVAsVhKVTQYgezGuz0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$init$4$VideoCapturerDevice(str2);
            }
        });
    }

    /* renamed from: ir.eitaa.messenger.voip.VideoCapturerDevice$1, reason: invalid class name */
    class AnonymousClass1 extends MediaProjection.Callback {
        AnonymousClass1() {
        }

        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$1$QdnN__Ay3S6H4Rv5fHRa1sDA06o
                @Override // java.lang.Runnable
                public final void run() {
                    VideoCapturerDevice.AnonymousClass1.lambda$onStop$0();
                }
            });
        }

        static /* synthetic */ void lambda$onStop$0() {
            if (VoIPService.getSharedInstance() != null) {
                VoIPService.getSharedInstance().stopScreenCapture();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$init$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$init$2$VideoCapturerDevice(Point point) {
        if (this.videoCapturerSurfaceTextureHelper != null) {
            long j = this.nativePtr;
            if (j == 0) {
                return;
            }
            this.nativeCapturerObserver = nativeGetJavaVideoCapturerObserver(j);
            this.videoCapturer.initialize(this.videoCapturerSurfaceTextureHelper, ApplicationLoader.applicationContext, this.nativeCapturerObserver);
            this.videoCapturer.startCapture(point.x, point.y, 30);
            WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.Instance;
            if (webRtcAudioRecord != null) {
                webRtcAudioRecord.initDeviceAudioRecord(((ScreenCapturerAndroid) this.videoCapturer).getMediaProjection());
            }
        }
    }

    /* renamed from: ir.eitaa.messenger.voip.VideoCapturerDevice$2, reason: invalid class name */
    class AnonymousClass2 implements CameraVideoCapturer.CameraEventsHandler {
        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onCameraClosed() {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onCameraDisconnected() {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onCameraError(String errorDescription) {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onCameraFreezed(String errorDescription) {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onCameraOpening(String cameraName) {
        }

        AnonymousClass2() {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraEventsHandler
        public void onFirstFrameAvailable() {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$2$yYVfOsPo9SDSv8GiMXHMEA1pddo
                @Override // java.lang.Runnable
                public final void run() {
                    VideoCapturerDevice.AnonymousClass2.lambda$onFirstFrameAvailable$0();
                }
            });
        }

        static /* synthetic */ void lambda$onFirstFrameAvailable$0() {
            if (VoIPService.getSharedInstance() != null) {
                VoIPService.getSharedInstance().onCameraFirstFrameAvailable();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$init$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$init$3$VideoCapturerDevice() {
        if (this.videoCapturerSurfaceTextureHelper == null) {
            return;
        }
        this.nativeCapturerObserver = nativeGetJavaVideoCapturerObserver(this.nativePtr);
        this.videoCapturer.initialize(this.videoCapturerSurfaceTextureHelper, ApplicationLoader.applicationContext, this.nativeCapturerObserver);
        this.videoCapturer.startCapture(CAPTURE_WIDTH, CAPTURE_HEIGHT, 30);
    }

    /* renamed from: ir.eitaa.messenger.voip.VideoCapturerDevice$3, reason: invalid class name */
    class AnonymousClass3 implements CameraVideoCapturer.CameraSwitchHandler {
        @Override // org.webrtc.CameraVideoCapturer.CameraSwitchHandler
        public void onCameraSwitchError(String errorDescription) {
        }

        AnonymousClass3() {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraSwitchHandler
        public void onCameraSwitchDone(final boolean isFrontCamera) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$3$cliNhuNzjRB5Wh32SUromEg9x0Y
                @Override // java.lang.Runnable
                public final void run() {
                    VideoCapturerDevice.AnonymousClass3.lambda$onCameraSwitchDone$0(isFrontCamera);
                }
            });
        }

        static /* synthetic */ void lambda$onCameraSwitchDone$0(boolean z) {
            if (VoIPService.getSharedInstance() != null) {
                VoIPService.getSharedInstance().setSwitchingCamera(false, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$init$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$init$4$VideoCapturerDevice(String str) {
        ((CameraVideoCapturer) this.videoCapturer).switchCamera(new AnonymousClass3(), str);
    }

    public static MediaProjection getMediaProjection() {
        VideoCapturerDevice[] videoCapturerDeviceArr = instance;
        if (videoCapturerDeviceArr[1] == null) {
            return null;
        }
        return ((ScreenCapturerAndroid) videoCapturerDeviceArr[1].videoCapturer).getMediaProjection();
    }

    private void onStateChanged(final long ptr, final int state) {
        if (Build.VERSION.SDK_INT < 18) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$zenacH2CxgOrevrujdHDmTNXFyo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStateChanged$7$VideoCapturerDevice(ptr, state);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onStateChanged$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onStateChanged$7$VideoCapturerDevice(long j, final int i) {
        if (this.nativePtr != j) {
            return;
        }
        this.handler.post(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$RcSC5XWUouUIZn7e-3sK21KIb3E
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStateChanged$6$VideoCapturerDevice(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onStateChanged$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onStateChanged$6$VideoCapturerDevice(int i) {
        VideoCapturer videoCapturer = this.videoCapturer;
        if (videoCapturer == null) {
            return;
        }
        if (i == 2) {
            videoCapturer.startCapture(CAPTURE_WIDTH, CAPTURE_HEIGHT, 30);
            return;
        }
        try {
            videoCapturer.stopCapture();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void onDestroy() {
        if (Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.nativePtr = 0L;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$ckNj860IUAgoD1oKfIaD2r66QXg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDestroy$9$VideoCapturerDevice();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDestroy$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDestroy$9$VideoCapturerDevice() {
        int i = 0;
        while (true) {
            VideoCapturerDevice[] videoCapturerDeviceArr = instance;
            if (i >= videoCapturerDeviceArr.length) {
                break;
            }
            if (videoCapturerDeviceArr[i] == this) {
                videoCapturerDeviceArr[i] = null;
                break;
            }
            i++;
        }
        this.handler.post(new Runnable() { // from class: ir.eitaa.messenger.voip.-$$Lambda$VideoCapturerDevice$VxnLZrsh6-t5JtbavgXqxDBwuBY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDestroy$8$VideoCapturerDevice();
            }
        });
        try {
            this.thread.quitSafely();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDestroy$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDestroy$8$VideoCapturerDevice() {
        WebRtcAudioRecord webRtcAudioRecord;
        if ((this.videoCapturer instanceof ScreenCapturerAndroid) && (webRtcAudioRecord = WebRtcAudioRecord.Instance) != null) {
            webRtcAudioRecord.stopDeviceAudioRecord();
        }
        VideoCapturer videoCapturer = this.videoCapturer;
        if (videoCapturer != null) {
            try {
                videoCapturer.stopCapture();
                this.videoCapturer.dispose();
                this.videoCapturer = null;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        SurfaceTextureHelper surfaceTextureHelper = this.videoCapturerSurfaceTextureHelper;
        if (surfaceTextureHelper != null) {
            surfaceTextureHelper.dispose();
            this.videoCapturerSurfaceTextureHelper = null;
        }
    }

    private EglBase.Context getSharedEGLContext() {
        if (eglBase == null) {
            eglBase = EglBase.CC.create(null, EglBase.CONFIG_PLAIN);
        }
        EglBase eglBase2 = eglBase;
        if (eglBase2 != null) {
            return eglBase2.getEglBaseContext();
        }
        return null;
    }

    public static EglBase getEglBase() {
        if (eglBase == null) {
            eglBase = EglBase.CC.create(null, EglBase.CONFIG_PLAIN);
        }
        return eglBase;
    }
}
