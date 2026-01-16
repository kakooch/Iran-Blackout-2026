package ir.nasim;

import livekit.org.webrtc.AudioTrack;

/* loaded from: classes3.dex */
public final class JG3 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;
    private final InterfaceC7720Sx5 f;

    public JG3(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
        this.f = interfaceC7720Sx56;
    }

    public static JG3 a(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56) {
        return new JG3(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55, interfaceC7720Sx56);
    }

    public static HG3 c(String str, AudioTrack audioTrack, IG3 ig3, InterfaceC24893zO interfaceC24893zO, AbstractC13778go1 abstractC13778go1, JO jo, QM qm, IO io2, FF5 ff5) {
        return new HG3(str, audioTrack, ig3, interfaceC24893zO, abstractC13778go1, jo, qm, io2, ff5);
    }

    public HG3 b(String str, AudioTrack audioTrack, IG3 ig3) {
        return c(str, audioTrack, ig3, (InterfaceC24893zO) this.a.get(), (AbstractC13778go1) this.b.get(), (JO) this.c.get(), (QM) this.d.get(), (IO) this.e.get(), (FF5) this.f.get());
    }
}
