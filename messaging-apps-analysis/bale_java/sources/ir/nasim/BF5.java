package ir.nasim;

import livekit.org.webrtc.PeerConnectionFactory;

/* loaded from: classes3.dex */
public final class BF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public BF5(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static BF5 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new BF5(interfaceC7720Sx5);
    }

    public static UA2 c(PeerConnectionFactory peerConnectionFactory) {
        return (UA2) AbstractC4746Gj5.d(C17017mF5.a.u(peerConnectionFactory));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UA2 get() {
        return c((PeerConnectionFactory) this.a.get());
    }
}
