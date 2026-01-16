package ir.nasim;

import ir.nasim.C11655dN5;
import livekit.org.webrtc.AudioTrack;
import livekit.org.webrtc.RtpReceiver;

/* renamed from: ir.nasim.fN5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12907fN5 implements C11655dN5.a {
    private final C12298eN5 a;

    C12907fN5(C12298eN5 c12298eN5) {
        this.a = c12298eN5;
    }

    public static InterfaceC7720Sx5 b(C12298eN5 c12298eN5) {
        return C11006ca3.a(new C12907fN5(c12298eN5));
    }

    @Override // ir.nasim.C11655dN5.a
    public C11655dN5 a(String str, AudioTrack audioTrack, RtpReceiver rtpReceiver) {
        return this.a.b(str, audioTrack, rtpReceiver);
    }
}
