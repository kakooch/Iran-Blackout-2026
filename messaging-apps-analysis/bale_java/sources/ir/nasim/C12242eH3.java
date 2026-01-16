package ir.nasim;

import android.content.Context;
import ir.nasim.C11599dH3;
import ir.nasim.C22464vH3;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.VideoCapturer;
import livekit.org.webrtc.VideoSource;
import livekit.org.webrtc.VideoTrack;

/* renamed from: ir.nasim.eH3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12242eH3 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;
    private final InterfaceC7720Sx5 f;

    public C12242eH3(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
        this.f = interfaceC7720Sx56;
    }

    public static C12242eH3 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56) {
        return new C12242eH3(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55, interfaceC7720Sx56);
    }

    public static C11599dH3 c(VideoCapturer videoCapturer, VideoSource videoSource, String str, C23060wH3 c23060wH3, VideoTrack videoTrack, C11599dH3.d dVar, PeerConnectionFactory peerConnectionFactory, Context context, EglBase eglBase, C19977rG1 c19977rG1, C22464vH3.b bVar, FF5 ff5) {
        return new C11599dH3(videoCapturer, videoSource, str, c23060wH3, videoTrack, dVar, peerConnectionFactory, context, eglBase, c19977rG1, bVar, ff5);
    }

    public C11599dH3 b(VideoCapturer videoCapturer, VideoSource videoSource, String str, C23060wH3 c23060wH3, VideoTrack videoTrack, C11599dH3.d dVar) {
        return c(videoCapturer, videoSource, str, c23060wH3, videoTrack, dVar, (PeerConnectionFactory) this.a.get(), (Context) this.b.get(), (EglBase) this.c.get(), (C19977rG1) this.d.get(), (C22464vH3.b) this.e.get(), (FF5) this.f.get());
    }
}
