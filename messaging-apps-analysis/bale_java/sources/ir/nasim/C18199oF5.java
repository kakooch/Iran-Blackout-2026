package ir.nasim;

import livekit.org.webrtc.audio.AudioDeviceModule;

/* renamed from: ir.nasim.oF5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18199oF5 implements InterfaceC19617qf2 {
    private final InterfaceC7720Sx5 a;

    public C18199oF5(InterfaceC7720Sx5 interfaceC7720Sx5) {
        this.a = interfaceC7720Sx5;
    }

    public static IO a(AudioDeviceModule audioDeviceModule) {
        return (IO) AbstractC4746Gj5.d(C17017mF5.a.g(audioDeviceModule));
    }

    public static C18199oF5 b(InterfaceC7720Sx5 interfaceC7720Sx5) {
        return new C18199oF5(interfaceC7720Sx5);
    }

    @Override // ir.nasim.InterfaceC7720Sx5
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public IO get() {
        return a((AudioDeviceModule) this.a.get());
    }
}
