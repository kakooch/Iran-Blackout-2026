package ir.nasim;

import livekit.org.webrtc.EglBase;

/* loaded from: classes3.dex */
public final class WN4 implements InterfaceC19617qf2 {
    private final QN4 a;

    public WN4(QN4 qn4) {
        this.a = qn4;
    }

    public static WN4 a(QN4 qn4) {
        return new WN4(qn4);
    }

    public static EglBase b(QN4 qn4) {
        return qn4.f();
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public EglBase get() {
        return b(this.a);
    }
}
