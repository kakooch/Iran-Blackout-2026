package ir.nasim;

import livekit.org.webrtc.audio.AudioDeviceModule;

/* loaded from: classes3.dex */
public final class RN4 implements InterfaceC19617qf2 {
    private final QN4 a;

    public RN4(QN4 qn4) {
        this.a = qn4;
    }

    public static AudioDeviceModule a(QN4 qn4) {
        return qn4.a();
    }

    public static RN4 b(QN4 qn4) {
        return new RN4(qn4);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AudioDeviceModule get() {
        return a(this.a);
    }
}
