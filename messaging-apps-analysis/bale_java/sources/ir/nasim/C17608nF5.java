package ir.nasim;

import android.content.Context;
import android.media.AudioAttributes;
import livekit.org.webrtc.audio.AudioDeviceModule;

/* renamed from: ir.nasim.nF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17608nF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC7720Sx5 b;
    private final InterfaceC7720Sx5 c;
    private final InterfaceC7720Sx5 d;
    private final InterfaceC7720Sx5 e;
    private final InterfaceC7720Sx5 f;
    private final InterfaceC7720Sx5 g;
    private final InterfaceC7720Sx5 h;

    public C17608nF5(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56, InterfaceC7720Sx5 interfaceC7720Sx57, InterfaceC7720Sx5 interfaceC7720Sx58) {
        this.a = interfaceC7720Sx5;
        this.b = interfaceC7720Sx52;
        this.c = interfaceC7720Sx53;
        this.d = interfaceC7720Sx54;
        this.e = interfaceC7720Sx55;
        this.f = interfaceC7720Sx56;
        this.g = interfaceC7720Sx57;
        this.h = interfaceC7720Sx58;
    }

    public static AudioDeviceModule a(AudioDeviceModule audioDeviceModule, UA2 ua2, AudioAttributes audioAttributes, Context context, ZV0 zv0, InterfaceC10670c01 interfaceC10670c01, JO jo, QM qm) {
        return (AudioDeviceModule) AbstractC4746Gj5.d(C17017mF5.a.e(audioDeviceModule, ua2, audioAttributes, context, zv0, interfaceC10670c01, jo, qm));
    }

    public static C17608nF5 b(InterfaceC7720Sx5 interfaceC7720Sx5, InterfaceC7720Sx5 interfaceC7720Sx52, InterfaceC7720Sx5 interfaceC7720Sx53, InterfaceC7720Sx5 interfaceC7720Sx54, InterfaceC7720Sx5 interfaceC7720Sx55, InterfaceC7720Sx5 interfaceC7720Sx56, InterfaceC7720Sx5 interfaceC7720Sx57, InterfaceC7720Sx5 interfaceC7720Sx58) {
        return new C17608nF5(interfaceC7720Sx5, interfaceC7720Sx52, interfaceC7720Sx53, interfaceC7720Sx54, interfaceC7720Sx55, interfaceC7720Sx56, interfaceC7720Sx57, interfaceC7720Sx58);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AudioDeviceModule get() {
        return a((AudioDeviceModule) this.a.get(), (UA2) this.b.get(), (AudioAttributes) this.c.get(), (Context) this.d.get(), (ZV0) this.e.get(), (InterfaceC10670c01) this.f.get(), (JO) this.g.get(), (QM) this.h.get());
    }
}
