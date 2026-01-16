package ir.nasim;

import livekit.org.webrtc.AudioTrack;
import livekit.org.webrtc.RtpReceiver;

/* renamed from: ir.nasim.dN5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C11655dN5 extends AbstractC23128wP {
    private final RtpReceiver l;

    /* renamed from: ir.nasim.dN5$a */
    public interface a {
        C11655dN5 a(String str, AudioTrack audioTrack, RtpReceiver rtpReceiver);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11655dN5(String str, AudioTrack audioTrack, RtpReceiver rtpReceiver, FF5 ff5) {
        super(str, audioTrack, ff5);
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(audioTrack, "rtcTrack");
        AbstractC13042fc3.i(rtpReceiver, "receiver");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.l = rtpReceiver;
    }
}
