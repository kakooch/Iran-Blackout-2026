package ir.nasim;

import java.util.List;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.RtpSender;

/* renamed from: ir.nasim.bD6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10186bD6 {
    private String a;
    private MediaStreamTrack b;
    private RtpSender c;
    private List d;

    public C10186bD6(String str, MediaStreamTrack mediaStreamTrack, RtpSender rtpSender, List list) {
        AbstractC13042fc3.i(str, "codec");
        AbstractC13042fc3.i(mediaStreamTrack, "rtcTrack");
        this.a = str;
        this.b = mediaStreamTrack;
        this.c = rtpSender;
        this.d = list;
    }

    public final MediaStreamTrack a() {
        return this.b;
    }

    public final RtpSender b() {
        return this.c;
    }

    public final void c(RtpSender rtpSender) {
        this.c = rtpSender;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10186bD6)) {
            return false;
        }
        C10186bD6 c10186bD6 = (C10186bD6) obj;
        return AbstractC13042fc3.d(this.a, c10186bD6.a) && AbstractC13042fc3.d(this.b, c10186bD6.b) && AbstractC13042fc3.d(this.c, c10186bD6.c) && AbstractC13042fc3.d(this.d, c10186bD6.d);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        RtpSender rtpSender = this.c;
        int iHashCode2 = (iHashCode + (rtpSender == null ? 0 : rtpSender.hashCode())) * 31;
        List list = this.d;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "SimulcastTrackInfo(codec=" + this.a + ", rtcTrack=" + this.b + ", sender=" + this.c + ", encodings=" + this.d + ')';
    }

    public /* synthetic */ C10186bD6(String str, MediaStreamTrack mediaStreamTrack, RtpSender rtpSender, List list, int i, ED1 ed1) {
        this(str, mediaStreamTrack, (i & 4) != 0 ? null : rtpSender, (i & 8) != 0 ? null : list);
    }
}
