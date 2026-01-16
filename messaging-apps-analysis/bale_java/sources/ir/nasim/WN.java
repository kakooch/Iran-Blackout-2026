package ir.nasim;

import livekit.org.webrtc.audio.AudioDeviceModule;

/* loaded from: classes3.dex */
public final class WN {
    private final AbstractC24902zP a;
    private final IN b;
    private final AudioDeviceModule c;
    private final UA2 d;
    private final boolean e;
    private final CO f;

    public WN(AbstractC24902zP abstractC24902zP, IN in, AudioDeviceModule audioDeviceModule, UA2 ua2, boolean z, CO co) {
        this.a = abstractC24902zP;
        this.b = in;
        this.c = audioDeviceModule;
        this.d = ua2;
        this.e = z;
        this.f = co;
    }

    public final AudioDeviceModule a() {
        return this.c;
    }

    public final IN b() {
        return this.b;
    }

    public final AbstractC24902zP c() {
        return this.a;
    }

    public final CO d() {
        return this.f;
    }

    public final boolean e() {
        return this.e;
    }

    public final UA2 f() {
        return this.d;
    }

    public /* synthetic */ WN(AbstractC24902zP abstractC24902zP, IN in, AudioDeviceModule audioDeviceModule, UA2 ua2, boolean z, CO co, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : abstractC24902zP, (i & 2) != 0 ? null : in, (i & 4) != 0 ? null : audioDeviceModule, (i & 8) != 0 ? null : ua2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : co);
    }
}
