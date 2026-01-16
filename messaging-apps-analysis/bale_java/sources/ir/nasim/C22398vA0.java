package ir.nasim;

import android.content.Context;
import livekit.org.webrtc.Camera1Capturer;
import livekit.org.webrtc.Camera1Helper;
import livekit.org.webrtc.CameraVideoCapturer;
import livekit.org.webrtc.CapturerObserver;
import livekit.org.webrtc.Size;
import livekit.org.webrtc.SurfaceTextureHelper;

/* renamed from: ir.nasim.vA0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C22398vA0 extends AbstractC16985mC0 implements CameraVideoCapturer {
    private final Camera1Capturer b;
    private final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22398vA0(Camera1Capturer camera1Capturer, String str, C9586aD0 c9586aD0) {
        super(c9586aD0);
        AbstractC13042fc3.i(camera1Capturer, "capturer");
        AbstractC13042fc3.i(c9586aD0, "cameraEventsDispatchHandler");
        this.b = camera1Capturer;
        this.c = str;
    }

    @Override // ir.nasim.BS7
    public Size a(int i, int i2) {
        Camera1Helper.Companion companion = Camera1Helper.INSTANCE;
        return companion.findClosestCaptureFormat(companion.getCameraId(this.c), i, i2);
    }

    @Override // livekit.org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i, int i2, int i3) {
        this.b.changeCaptureFormat(i, i2, i3);
    }

    @Override // livekit.org.webrtc.VideoCapturer
    public void dispose() {
        this.b.dispose();
    }

    @Override // livekit.org.webrtc.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        this.b.initialize(surfaceTextureHelper, context, capturerObserver);
    }

    @Override // livekit.org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return this.b.isScreencast();
    }

    @Override // livekit.org.webrtc.VideoCapturer
    public void startCapture(int i, int i2, int i3) {
        this.b.startCapture(i, i2, i3);
    }

    @Override // livekit.org.webrtc.VideoCapturer
    public void stopCapture() {
        this.b.stopCapture();
    }

    @Override // livekit.org.webrtc.CameraVideoCapturer
    public void switchCamera(CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler) {
        this.b.switchCamera(cameraSwitchHandler);
    }

    @Override // livekit.org.webrtc.CameraVideoCapturer
    public void switchCamera(CameraVideoCapturer.CameraSwitchHandler cameraSwitchHandler, String str) {
        this.b.switchCamera(cameraSwitchHandler, str);
    }
}
