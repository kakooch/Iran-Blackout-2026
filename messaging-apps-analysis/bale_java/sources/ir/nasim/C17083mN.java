package ir.nasim;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;

/* renamed from: ir.nasim.mN, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17083mN {
    private int a;
    private boolean b;
    private boolean c;
    private AudioFocusRequest d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final Context j;
    private final NI3 k;
    private final AudioManager l;
    private final C9089Yl0 m;
    private final HN n;
    private final AudioManager.OnAudioFocusChangeListener o;

    public C17083mN(Context context, NI3 ni3, AudioManager audioManager, C9089Yl0 c9089Yl0, HN hn, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(ni3, "logger");
        AbstractC13042fc3.i(audioManager, "audioManager");
        AbstractC13042fc3.i(c9089Yl0, "build");
        AbstractC13042fc3.i(hn, "audioFocusRequest");
        AbstractC13042fc3.i(onAudioFocusChangeListener, "audioFocusChangeListener");
        this.j = context;
        this.k = ni3;
        this.l = audioManager;
        this.m = c9089Yl0;
        this.n = hn;
        this.o = onAudioFocusChangeListener;
        this.e = 3;
        this.f = 2;
        this.h = 2;
        this.i = 1;
    }

    public final void a() {
        this.a = this.l.getMode();
        this.b = this.l.isMicrophoneMute();
        this.c = this.l.isSpeakerphoneOn();
    }

    public final void b(boolean z) {
        AudioManager audioManager = this.l;
        if (z) {
            audioManager.startBluetoothSco();
        } else {
            audioManager.stopBluetoothSco();
        }
    }

    public final void c(boolean z) {
        this.l.setSpeakerphoneOn(z);
    }

    public final int d() {
        return this.e;
    }

    public final boolean e() {
        boolean zHasSystemFeature = this.j.getPackageManager().hasSystemFeature("android.hardware.telephony");
        if (zHasSystemFeature) {
            this.k.a("AudioDeviceManager", "Earpiece available");
        }
        return zHasSystemFeature;
    }

    public final void f(boolean z) {
        this.l.setMicrophoneMute(z);
    }

    public final void g() {
        this.l.setMode(this.a);
        f(this.b);
        c(this.c);
        if (this.m.a() < 26) {
            this.l.abandonAudioFocus(this.o);
            return;
        }
        AudioFocusRequest audioFocusRequest = this.d;
        if (audioFocusRequest != null) {
            this.l.abandonAudioFocusRequest(audioFocusRequest);
        }
        this.d = FN.a(null);
    }

    public final void h(int i) {
        this.i = i;
    }

    public final void i(int i) {
        this.h = i;
    }

    public final void j() {
        if (this.m.a() >= 26) {
            AudioFocusRequest audioFocusRequestA = this.n.a(this.o, this.f, this.h, this.i);
            this.d = audioFocusRequestA;
            if (audioFocusRequestA != null) {
                this.l.requestAudioFocus(audioFocusRequestA);
            }
        } else {
            this.l.requestAudioFocus(this.o, this.g, this.f);
        }
        this.l.setMode(this.e);
    }

    public final void k(int i) {
        this.e = i;
    }

    public final void l(int i) {
        this.g = i;
    }

    public final void m(int i) {
        this.f = i;
    }

    public /* synthetic */ C17083mN(Context context, NI3 ni3, AudioManager audioManager, C9089Yl0 c9089Yl0, HN hn, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, int i, ED1 ed1) {
        this(context, ni3, audioManager, (i & 8) != 0 ? new C9089Yl0() : c9089Yl0, (i & 16) != 0 ? new HN() : hn, onAudioFocusChangeListener);
    }
}
