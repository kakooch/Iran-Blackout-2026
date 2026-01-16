package ir.nasim;

import ir.nasim.CN5;
import livekit.org.webrtc.RtpReceiver;
import livekit.org.webrtc.VideoTrack;

/* loaded from: classes3.dex */
public final class EN5 implements CN5.a {
    private final DN5 a;

    EN5(DN5 dn5) {
        this.a = dn5;
    }

    public static InterfaceC7720Sx5 b(DN5 dn5) {
        return C11006ca3.a(new EN5(dn5));
    }

    @Override // ir.nasim.CN5.a
    public CN5 a(String str, VideoTrack videoTrack, boolean z, RtpReceiver rtpReceiver) {
        return this.a.b(str, videoTrack, z, rtpReceiver);
    }
}
