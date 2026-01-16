package ir.nasim;

import livekit.org.webrtc.VideoEncoderFactory;

/* renamed from: ir.nasim.bO4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10283bO4 implements InterfaceC19617qf2 {
    private final QN4 a;

    public C10283bO4(QN4 qn4) {
        this.a = qn4;
    }

    public static C10283bO4 a(QN4 qn4) {
        return new C10283bO4(qn4);
    }

    public static VideoEncoderFactory c(QN4 qn4) {
        return qn4.k();
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public VideoEncoderFactory get() {
        return c(this.a);
    }
}
