package ir.nasim;

import ir.nasim.HG3;
import livekit.org.webrtc.AudioTrack;

/* loaded from: classes3.dex */
public final class KG3 implements HG3.b {
    private final JG3 a;

    KG3(JG3 jg3) {
        this.a = jg3;
    }

    public static InterfaceC7720Sx5 b(JG3 jg3) {
        return C11006ca3.a(new KG3(jg3));
    }

    @Override // ir.nasim.HG3.b
    public HG3 a(String str, AudioTrack audioTrack, IG3 ig3) {
        return this.a.b(str, audioTrack, ig3);
    }
}
