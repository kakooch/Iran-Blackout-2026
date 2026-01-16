package ir.nasim;

import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.VideoDecoderFactory;
import livekit.org.webrtc.VideoEncoderFactory;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class XC3 {
    private final OkHttpClient a;
    private final VideoEncoderFactory b;
    private final VideoDecoderFactory c;
    private final WN d;
    private final EglBase e;
    private final PeerConnectionFactory.Options f;

    public XC3(OkHttpClient okHttpClient, VideoEncoderFactory videoEncoderFactory, VideoDecoderFactory videoDecoderFactory, WN wn, EglBase eglBase, PeerConnectionFactory.Options options) {
        this.a = okHttpClient;
        this.b = videoEncoderFactory;
        this.c = videoDecoderFactory;
        this.d = wn;
        this.e = eglBase;
        this.f = options;
    }

    public final WN a() {
        return this.d;
    }

    public final EglBase b() {
        return this.e;
    }

    public final OkHttpClient c() {
        return this.a;
    }

    public final PeerConnectionFactory.Options d() {
        return this.f;
    }

    public final VideoDecoderFactory e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XC3)) {
            return false;
        }
        XC3 xc3 = (XC3) obj;
        return AbstractC13042fc3.d(this.a, xc3.a) && AbstractC13042fc3.d(this.b, xc3.b) && AbstractC13042fc3.d(this.c, xc3.c) && AbstractC13042fc3.d(this.d, xc3.d) && AbstractC13042fc3.d(this.e, xc3.e) && AbstractC13042fc3.d(this.f, xc3.f);
    }

    public final VideoEncoderFactory f() {
        return this.b;
    }

    public int hashCode() {
        OkHttpClient okHttpClient = this.a;
        int iHashCode = (okHttpClient == null ? 0 : okHttpClient.hashCode()) * 31;
        VideoEncoderFactory videoEncoderFactory = this.b;
        int iHashCode2 = (iHashCode + (videoEncoderFactory == null ? 0 : videoEncoderFactory.hashCode())) * 31;
        VideoDecoderFactory videoDecoderFactory = this.c;
        int iHashCode3 = (iHashCode2 + (videoDecoderFactory == null ? 0 : videoDecoderFactory.hashCode())) * 31;
        WN wn = this.d;
        int iHashCode4 = (iHashCode3 + (wn == null ? 0 : wn.hashCode())) * 31;
        EglBase eglBase = this.e;
        int iHashCode5 = (iHashCode4 + (eglBase == null ? 0 : eglBase.hashCode())) * 31;
        PeerConnectionFactory.Options options = this.f;
        return iHashCode5 + (options != null ? options.hashCode() : 0);
    }

    public String toString() {
        return "LiveKitOverrides(okHttpClient=" + this.a + ", videoEncoderFactory=" + this.b + ", videoDecoderFactory=" + this.c + ", audioOptions=" + this.d + ", eglBase=" + this.e + ", peerConnectionFactoryOptions=" + this.f + ')';
    }

    public /* synthetic */ XC3(OkHttpClient okHttpClient, VideoEncoderFactory videoEncoderFactory, VideoDecoderFactory videoDecoderFactory, WN wn, EglBase eglBase, PeerConnectionFactory.Options options, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : okHttpClient, (i & 2) != 0 ? null : videoEncoderFactory, (i & 4) != 0 ? null : videoDecoderFactory, (i & 8) != 0 ? null : wn, (i & 16) != 0 ? null : eglBase, (i & 32) != 0 ? null : options);
    }
}
