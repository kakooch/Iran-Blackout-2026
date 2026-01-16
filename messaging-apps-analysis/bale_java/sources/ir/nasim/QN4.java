package ir.nasim;

import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.VideoDecoderFactory;
import livekit.org.webrtc.VideoEncoderFactory;
import livekit.org.webrtc.audio.AudioDeviceModule;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class QN4 {
    private final XC3 a;

    public QN4(XC3 xc3) {
        AbstractC13042fc3.i(xc3, "overrides");
        this.a = xc3;
    }

    public final AudioDeviceModule a() {
        WN wnA = this.a.a();
        if (wnA != null) {
            return wnA.a();
        }
        return null;
    }

    public final IN b() {
        WN wnA = this.a.a();
        if (wnA != null) {
            return wnA.b();
        }
        return null;
    }

    public final AbstractC24902zP c() {
        WN wnA = this.a.a();
        if (wnA != null) {
            return wnA.c();
        }
        return null;
    }

    public final CO d() {
        WN wnA = this.a.a();
        if (wnA != null) {
            return wnA.d();
        }
        return null;
    }

    public final boolean e() {
        WN wnA = this.a.a();
        if (wnA != null) {
            return wnA.e();
        }
        return false;
    }

    public final EglBase f() {
        return this.a.b();
    }

    public final UA2 g() {
        WN wnA = this.a.a();
        if (wnA != null) {
            return wnA.f();
        }
        return null;
    }

    public final OkHttpClient h() {
        return this.a.c();
    }

    public final PeerConnectionFactory.Options i() {
        return this.a.d();
    }

    public final VideoDecoderFactory j() {
        return this.a.e();
    }

    public final VideoEncoderFactory k() {
        return this.a.f();
    }
}
