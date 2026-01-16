package ir.nasim;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import livekit.org.webrtc.CameraVideoCapturer;

/* renamed from: ir.nasim.aD0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C9586aD0 implements CameraVideoCapturer.CameraEventsHandler {
    private final Set a = new LinkedHashSet();

    public final synchronized void a(CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        AbstractC13042fc3.i(cameraEventsHandler, "handler");
        this.a.add(cameraEventsHandler);
    }

    public final synchronized void b(CameraVideoCapturer.CameraEventsHandler cameraEventsHandler) {
        AbstractC13042fc3.i(cameraEventsHandler, "handler");
        this.a.remove(cameraEventsHandler);
    }

    @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onCameraClosed() {
        Iterator it = AbstractC15401jX0.q1(this.a).iterator();
        while (it.hasNext()) {
            ((CameraVideoCapturer.CameraEventsHandler) it.next()).onCameraClosed();
        }
    }

    @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onCameraDisconnected() {
        Iterator it = AbstractC15401jX0.q1(this.a).iterator();
        while (it.hasNext()) {
            ((CameraVideoCapturer.CameraEventsHandler) it.next()).onCameraDisconnected();
        }
    }

    @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onCameraError(String str) {
        AbstractC13042fc3.i(str, "errorDescription");
        Iterator it = AbstractC15401jX0.q1(this.a).iterator();
        while (it.hasNext()) {
            ((CameraVideoCapturer.CameraEventsHandler) it.next()).onCameraError(str);
        }
    }

    @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onCameraFreezed(String str) {
        AbstractC13042fc3.i(str, "errorDescription");
        Iterator it = AbstractC15401jX0.q1(this.a).iterator();
        while (it.hasNext()) {
            ((CameraVideoCapturer.CameraEventsHandler) it.next()).onCameraFreezed(str);
        }
    }

    @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onCameraOpening(String str) {
        AbstractC13042fc3.i(str, "cameraName");
        Iterator it = AbstractC15401jX0.q1(this.a).iterator();
        while (it.hasNext()) {
            ((CameraVideoCapturer.CameraEventsHandler) it.next()).onCameraOpening(str);
        }
    }

    @Override // livekit.org.webrtc.CameraVideoCapturer.CameraEventsHandler
    public void onFirstFrameAvailable() {
        Iterator it = AbstractC15401jX0.q1(this.a).iterator();
        while (it.hasNext()) {
            ((CameraVideoCapturer.CameraEventsHandler) it.next()).onFirstFrameAvailable();
        }
    }
}
