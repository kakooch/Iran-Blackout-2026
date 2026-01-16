package ir.nasim;

import ir.nasim.C22464vH3;
import livekit.org.webrtc.VideoCapturer;
import livekit.org.webrtc.VideoSource;
import livekit.org.webrtc.VideoTrack;

/* renamed from: ir.nasim.yH3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24240yH3 implements C22464vH3.b {
    private final C23650xH3 a;

    C24240yH3(C23650xH3 c23650xH3) {
        this.a = c23650xH3;
    }

    public static InterfaceC7720Sx5 b(C23650xH3 c23650xH3) {
        return C11006ca3.a(new C24240yH3(c23650xH3));
    }

    @Override // ir.nasim.C22464vH3.b
    public C22464vH3 a(VideoCapturer videoCapturer, VideoSource videoSource, String str, C23060wH3 c23060wH3, VideoTrack videoTrack, HF0 hf0) {
        return this.a.b(videoCapturer, videoSource, str, c23060wH3, videoTrack, hf0);
    }
}
