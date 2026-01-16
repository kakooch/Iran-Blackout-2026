package ir.nasim;

import livekit.org.webrtc.VideoDecoderFactory;

/* renamed from: ir.nasim.aO4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C9689aO4 implements InterfaceC19617qf2 {
    private final QN4 a;

    public C9689aO4(QN4 qn4) {
        this.a = qn4;
    }

    public static C9689aO4 a(QN4 qn4) {
        return new C9689aO4(qn4);
    }

    public static VideoDecoderFactory c(QN4 qn4) {
        return qn4.j();
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public VideoDecoderFactory get() {
        return c(this.a);
    }
}
