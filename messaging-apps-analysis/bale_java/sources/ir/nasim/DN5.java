package ir.nasim;

import livekit.org.webrtc.RtpReceiver;
import livekit.org.webrtc.VideoTrack;

/* loaded from: classes3.dex */
public final class DN5 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;

    public DN5(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
    }

    public static DN5 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        return new DN5(interfaceC7720Sx5, interfaceC7720Sx52);
    }

    public static CN5 c(String str, VideoTrack videoTrack, boolean z, AbstractC13778go1 abstractC13778go1, RtpReceiver rtpReceiver, FF5 ff5) {
        return new CN5(str, videoTrack, z, abstractC13778go1, rtpReceiver, ff5);
    }

    public CN5 b(String str, VideoTrack videoTrack, boolean z, RtpReceiver rtpReceiver) {
        return c(str, videoTrack, z, (AbstractC13778go1) this.a.get(), rtpReceiver, (FF5) this.b.get());
    }
}
