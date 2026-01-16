package ir.nasim;

import livekit.org.webrtc.AudioProcessingFactory;

/* renamed from: ir.nasim.qF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19381qF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C19381qF5(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static AudioProcessingFactory a(C7239Qw1 c7239Qw1) {
        return (AudioProcessingFactory) AbstractC4746Gj5.d(C17017mF5.a.i(c7239Qw1));
    }

    public static C19381qF5 b(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C19381qF5(interfaceC7720Sx5);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AudioProcessingFactory get() {
        return a((C7239Qw1) this.a.get());
    }
}
