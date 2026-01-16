package ir.nasim;

import livekit.org.webrtc.PeerConnectionFactory;

/* renamed from: ir.nasim.xF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23634xF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C23634xF5(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C23634xF5 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C23634xF5(interfaceC7720Sx5);
    }

    public static PeerConnectionFactory c(C24689z25 c24689z25) {
        return (PeerConnectionFactory) AbstractC4746Gj5.d(C17017mF5.a.q(c24689z25));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PeerConnectionFactory get() {
        return c((C24689z25) this.a.get());
    }
}
