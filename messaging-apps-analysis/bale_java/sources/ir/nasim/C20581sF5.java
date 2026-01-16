package ir.nasim;

import livekit.org.webrtc.EglBase;

/* renamed from: ir.nasim.sF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20581sF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;

    public C20581sF5(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
    }

    public static C20581sF5 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52) {
        return new C20581sF5(interfaceC7720Sx5, interfaceC7720Sx52);
    }

    public static EglBase b(EglBase eglBase, ZV0 zv0) {
        return (EglBase) AbstractC4746Gj5.d(C17017mF5.a.k(eglBase, zv0));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public EglBase get() {
        return b((EglBase) this.a.get(), (ZV0) this.b.get());
    }
}
