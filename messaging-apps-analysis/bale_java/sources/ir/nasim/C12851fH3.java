package ir.nasim;

import ir.nasim.C11599dH3;
import livekit.org.webrtc.VideoCapturer;
import livekit.org.webrtc.VideoSource;
import livekit.org.webrtc.VideoTrack;

/* renamed from: ir.nasim.fH3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12851fH3 implements C11599dH3.c {
    private final C12242eH3 a;

    C12851fH3(C12242eH3 c12242eH3) {
        this.a = c12242eH3;
    }

    public static InterfaceC7720Sx5 b(C12242eH3 c12242eH3) {
        return C11006ca3.a(new C12851fH3(c12242eH3));
    }

    @Override // ir.nasim.C11599dH3.c
    public C11599dH3 a(VideoCapturer videoCapturer, VideoSource videoSource, String str, C23060wH3 c23060wH3, VideoTrack videoTrack, C11599dH3.d dVar) {
        return this.a.b(videoCapturer, videoSource, str, c23060wH3, videoTrack, dVar);
    }
}
