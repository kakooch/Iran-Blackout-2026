package org.rbmain.messenger.voip;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.voip.VideoCameraCapturer;
import org.webrtc.Camera1Enumerator;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.CapturerObserver;
import org.webrtc.EglBase;
import org.webrtc.Logging;
import org.webrtc.SurfaceTextureHelper;

/* loaded from: classes4.dex */
public class VideoCameraCapturer {
    private static final int CAPTURE_FPS = 30;
    private static final int CAPTURE_HEIGHT;
    private static final int CAPTURE_WIDTH;
    public static EglBase eglBase;
    private static VideoCameraCapturer instance;
    private Handler handler;
    private CapturerObserver nativeCapturerObserver;
    private long nativePtr;
    private HandlerThread thread;
    private CameraVideoCapturer videoCapturer;
    private SurfaceTextureHelper videoCapturerSurfaceTextureHelper;

    private static native CapturerObserver nativeGetJavaVideoCapturerObserver(long j);

    private void onAspectRatioRequested(float f) {
    }

    static {
        int i = Build.VERSION.SDK_INT;
        CAPTURE_WIDTH = i <= 19 ? 480 : 1280;
        CAPTURE_HEIGHT = i <= 19 ? 320 : 720;
    }

    public static VideoCameraCapturer getInstance() {
        return instance;
    }

    public VideoCameraCapturer() {
        if (Build.VERSION.SDK_INT < 18) {
            return;
        }
        Logging.enableLogToDebugOutput(Logging.Severity.LS_INFO);
        Logging.d("VideoCameraCapturer", "device model = " + Build.MANUFACTURER + Build.MODEL);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VideoCameraCapturer$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        instance = this;
        HandlerThread handlerThread = new HandlerThread("CallThread");
        this.thread = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.thread.getLooper());
        if (eglBase == null) {
            eglBase = EglBase.CC.create(null, EglBase.CONFIG_PLAIN);
        }
    }

    private void init(final long j, final boolean z) {
        if (Build.VERSION.SDK_INT < 18) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VideoCameraCapturer$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$init$3(j, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(long j, boolean z) {
        if (eglBase == null) {
            return;
        }
        this.nativePtr = j;
        CameraEnumerator camera2Enumerator = Camera2Enumerator.isSupported(ApplicationLoader.applicationContext) ? new Camera2Enumerator(ApplicationLoader.applicationContext) : new Camera1Enumerator();
        String[] deviceNames = camera2Enumerator.getDeviceNames();
        int i = 0;
        while (true) {
            if (i >= deviceNames.length) {
                i = -1;
                break;
            } else if (camera2Enumerator.isFrontFacing(deviceNames[i]) == z) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        final String str = deviceNames[i];
        if (this.videoCapturer == null) {
            this.videoCapturer = camera2Enumerator.createCapturer(str, null);
            this.videoCapturerSurfaceTextureHelper = SurfaceTextureHelper.create("VideoCapturerThread", eglBase.getEglBaseContext());
            this.handler.post(new Runnable() { // from class: org.rbmain.messenger.voip.VideoCameraCapturer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$init$1();
                }
            });
            return;
        }
        this.handler.post(new Runnable() { // from class: org.rbmain.messenger.voip.VideoCameraCapturer$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$init$2(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1() {
        this.nativeCapturerObserver = nativeGetJavaVideoCapturerObserver(this.nativePtr);
        this.videoCapturer.initialize(this.videoCapturerSurfaceTextureHelper, ApplicationLoader.applicationContext, this.nativeCapturerObserver);
        this.videoCapturer.startCapture(CAPTURE_WIDTH, CAPTURE_HEIGHT, 30);
    }

    /* renamed from: org.rbmain.messenger.voip.VideoCameraCapturer$1, reason: invalid class name */
    class AnonymousClass1 implements CameraVideoCapturer.CameraSwitchHandler {
        @Override // org.webrtc.CameraVideoCapturer.CameraSwitchHandler
        public void onCameraSwitchError(String str) {
        }

        AnonymousClass1() {
        }

        @Override // org.webrtc.CameraVideoCapturer.CameraSwitchHandler
        public void onCameraSwitchDone(final boolean z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VideoCameraCapturer$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    VideoCameraCapturer.AnonymousClass1.lambda$onCameraSwitchDone$0(z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onCameraSwitchDone$0(boolean z) {
            if (VoIPService.getSharedInstance() != null) {
                VoIPService.getSharedInstance().setSwitchingCamera(false, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(String str) {
        this.videoCapturer.switchCamera(new AnonymousClass1(), str);
    }

    private void onStateChanged(final long j, final int i) {
        if (Build.VERSION.SDK_INT < 18) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VideoCameraCapturer$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStateChanged$5(j, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStateChanged$5(long j, final int i) {
        if (this.nativePtr != j) {
            return;
        }
        this.handler.post(new Runnable() { // from class: org.rbmain.messenger.voip.VideoCameraCapturer$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onStateChanged$4(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStateChanged$4(int i) {
        CameraVideoCapturer cameraVideoCapturer = this.videoCapturer;
        if (cameraVideoCapturer == null) {
            return;
        }
        if (i == 2) {
            cameraVideoCapturer.startCapture(CAPTURE_WIDTH, CAPTURE_HEIGHT, 30);
            return;
        }
        try {
            cameraVideoCapturer.stopCapture();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void onDestroy() {
        if (Build.VERSION.SDK_INT < 18) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.voip.VideoCameraCapturer$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDestroy$7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDestroy$7() {
        EglBase eglBase2 = eglBase;
        if (eglBase2 != null) {
            eglBase2.release();
            eglBase = null;
        }
        if (instance == this) {
            instance = null;
        }
        this.handler.post(new Runnable() { // from class: org.rbmain.messenger.voip.VideoCameraCapturer$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDestroy$6();
            }
        });
        try {
            this.thread.quitSafely();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDestroy$6() {
        CameraVideoCapturer cameraVideoCapturer = this.videoCapturer;
        if (cameraVideoCapturer != null) {
            try {
                cameraVideoCapturer.stopCapture();
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
}
