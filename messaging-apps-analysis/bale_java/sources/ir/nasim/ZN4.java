package ir.nasim;

import livekit.org.webrtc.PeerConnectionFactory;

/* loaded from: classes3.dex */
public final class ZN4 implements InterfaceC19617qf2 {
    private final QN4 a;

    public ZN4(QN4 qn4) {
        this.a = qn4;
    }

    public static ZN4 a(QN4 qn4) {
        return new ZN4(qn4);
    }

    public static PeerConnectionFactory.Options c(QN4 qn4) {
        return qn4.i();
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PeerConnectionFactory.Options get() {
        return c(this.a);
    }
}
