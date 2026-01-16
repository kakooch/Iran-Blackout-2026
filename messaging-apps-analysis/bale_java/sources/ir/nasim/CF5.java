package ir.nasim;

import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.VideoDecoderFactory;

/* loaded from: classes3.dex */
public final class CF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;

    public CF5(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
    }

    public static CF5 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54) {
        return new CF5(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54);
    }

    public static VideoDecoderFactory c(C8668Wy3 c8668Wy3, boolean z, EglBase.Context context, VideoDecoderFactory videoDecoderFactory) {
        return (VideoDecoderFactory) AbstractC4746Gj5.d(C17017mF5.a.v(c8668Wy3, z, context, videoDecoderFactory));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public VideoDecoderFactory get() {
        return c((C8668Wy3) this.a.get(), ((Boolean) this.b.get()).booleanValue(), (EglBase.Context) this.c.get(), (VideoDecoderFactory) this.d.get());
    }
}
