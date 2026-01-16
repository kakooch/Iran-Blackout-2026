package ir.nasim;

import livekit.org.webrtc.AudioTrack;
import livekit.org.webrtc.RtpReceiver;

/* renamed from: ir.nasim.eN5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12298eN5 {
    private final InterfaceC7720Sx5 a;

    public C12298eN5(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C12298eN5 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C12298eN5(interfaceC7720Sx5);
    }

    public static C11655dN5 c(String str, AudioTrack audioTrack, RtpReceiver rtpReceiver, FF5 ff5) {
        return new C11655dN5(str, audioTrack, rtpReceiver, ff5);
    }

    public C11655dN5 b(String str, AudioTrack audioTrack, RtpReceiver rtpReceiver) {
        return c(str, audioTrack, rtpReceiver, (FF5) this.a.get());
    }
}
