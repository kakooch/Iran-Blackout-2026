package ir.nasim;

import livekit.org.webrtc.EglBase;

/* renamed from: ir.nasim.tF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21184tF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C21184tF5(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static C21184tF5 a(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C21184tF5(interfaceC7720Sx5);
    }

    public static EglBase.Context b(EglBase eglBase) {
        return (EglBase.Context) AbstractC4746Gj5.d(C17017mF5.a.m(eglBase));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public EglBase.Context get() {
        return b((EglBase) this.a.get());
    }
}
