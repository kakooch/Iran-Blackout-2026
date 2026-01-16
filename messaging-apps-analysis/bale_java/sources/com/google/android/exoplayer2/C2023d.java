package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.BN;
import ir.nasim.CN;
import ir.nasim.DN;
import livekit.org.webrtc.MediaStreamTrack;

/* renamed from: com.google.android.exoplayer2.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C2023d {
    private final AudioManager a;
    private final a b;
    private b c;
    private com.google.android.exoplayer2.audio.a d;
    private int f;
    private AudioFocusRequest h;
    private boolean i;
    private float g = 1.0f;
    private int e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.d$a */
    class a implements AudioManager.OnAudioFocusChangeListener {
        private final Handler a;

        public a(Handler handler) {
            this.a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i) {
            C2023d.this.h(i);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i) {
            this.a.post(new Runnable() { // from class: com.google.android.exoplayer2.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(i);
                }
            });
        }
    }

    /* renamed from: com.google.android.exoplayer2.d$b */
    public interface b {
        void t(float f);

        void v(int i);
    }

    public C2023d(Context context, Handler handler, b bVar) {
        this.a = (AudioManager) AbstractC20011rK.e((AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND));
        this.c = bVar;
        this.b = new a(handler);
    }

    private void a() {
        this.a.abandonAudioFocus(this.b);
    }

    private void b() {
        if (this.e == 0) {
            return;
        }
        if (AbstractC9683aN7.a >= 26) {
            c();
        } else {
            a();
        }
        n(0);
    }

    private void c() {
        AudioFocusRequest audioFocusRequest = this.h;
        if (audioFocusRequest != null) {
            this.a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private static int e(com.google.android.exoplayer2.audio.a aVar) {
        if (aVar == null) {
            return 0;
        }
        switch (aVar.c) {
            case 0:
                AbstractC18815pI3.k("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (aVar.a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                AbstractC18815pI3.k("AudioFocusManager", "Unidentified audio usage: " + aVar.c);
                return 0;
            case 16:
                return AbstractC9683aN7.a >= 19 ? 4 : 2;
        }
    }

    private void f(int i) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.v(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i) {
        if (i == -3 || i == -2) {
            if (i != -2 && !q()) {
                n(3);
                return;
            } else {
                f(0);
                n(2);
                return;
            }
        }
        if (i == -1) {
            f(-1);
            b();
        } else if (i == 1) {
            n(1);
            f(1);
        } else {
            AbstractC18815pI3.k("AudioFocusManager", "Unknown focus change type: " + i);
        }
    }

    private int j() {
        if (this.e == 1) {
            return 1;
        }
        if ((AbstractC9683aN7.a >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    private int k() {
        return this.a.requestAudioFocus(this.b, AbstractC9683aN7.e0(((com.google.android.exoplayer2.audio.a) AbstractC20011rK.e(this.d)).c), this.f);
    }

    private int l() {
        AudioFocusRequest.Builder builderA;
        AudioFocusRequest audioFocusRequest = this.h;
        if (audioFocusRequest == null || this.i) {
            if (audioFocusRequest == null) {
                DN.a();
                builderA = BN.a(this.f);
            } else {
                DN.a();
                builderA = CN.a(this.h);
            }
            this.h = builderA.setAudioAttributes(((com.google.android.exoplayer2.audio.a) AbstractC20011rK.e(this.d)).c().a).setWillPauseWhenDucked(q()).setOnAudioFocusChangeListener(this.b).build();
            this.i = false;
        }
        return this.a.requestAudioFocus(this.h);
    }

    private void n(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.g == f) {
            return;
        }
        this.g = f;
        b bVar = this.c;
        if (bVar != null) {
            bVar.t(f);
        }
    }

    private boolean o(int i) {
        return i == 1 || this.f != 1;
    }

    private boolean q() {
        com.google.android.exoplayer2.audio.a aVar = this.d;
        return aVar != null && aVar.a == 1;
    }

    public float g() {
        return this.g;
    }

    public void i() {
        this.c = null;
        b();
    }

    public void m(com.google.android.exoplayer2.audio.a aVar) {
        if (AbstractC9683aN7.c(this.d, aVar)) {
            return;
        }
        this.d = aVar;
        int iE = e(aVar);
        this.f = iE;
        boolean z = true;
        if (iE != 1 && iE != 0) {
            z = false;
        }
        AbstractC20011rK.b(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public int p(boolean z, int i) {
        if (o(i)) {
            b();
            return z ? 1 : -1;
        }
        if (z) {
            return j();
        }
        return -1;
    }
}
