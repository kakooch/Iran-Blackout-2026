package ir.nasim;

import livekit.org.webrtc.AudioProcessingFactory;
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.VideoDecoderFactory;
import livekit.org.webrtc.VideoEncoderFactory;
import livekit.org.webrtc.audio.AudioDeviceModule;

/* renamed from: ir.nasim.yF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24224yF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;
    private final InterfaceC7720Sx5 f;
    private final InterfaceC7720Sx5 g;

    public C24224yF5(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56, InterfaceC7720Sx5 interfaceC7720Sx57) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
        this.f = interfaceC7720Sx56;
        this.g = interfaceC7720Sx57;
    }

    public static C24224yF5 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56, InterfaceC7720Sx5 interfaceC7720Sx57) {
        return new C24224yF5(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55, interfaceC7720Sx56, interfaceC7720Sx57);
    }

    public static C24689z25 c(C8668Wy3 c8668Wy3, AudioDeviceModule audioDeviceModule, VideoEncoderFactory videoEncoderFactory, VideoDecoderFactory videoDecoderFactory, PeerConnectionFactory.Options options, ZV0 zv0, AudioProcessingFactory audioProcessingFactory) {
        return (C24689z25) AbstractC4746Gj5.d(C17017mF5.a.r(c8668Wy3, audioDeviceModule, videoEncoderFactory, videoDecoderFactory, options, zv0, audioProcessingFactory));
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C24689z25 get() {
        return c((C8668Wy3) this.a.get(), (AudioDeviceModule) this.b.get(), (VideoEncoderFactory) this.c.get(), (VideoDecoderFactory) this.d.get(), (PeerConnectionFactory.Options) this.e.get(), (ZV0) this.f.get(), (AudioProcessingFactory) this.g.get());
    }
}
