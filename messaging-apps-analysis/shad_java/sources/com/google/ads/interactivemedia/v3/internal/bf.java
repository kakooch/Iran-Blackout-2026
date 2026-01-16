package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import android.util.Log;
import org.webrtc.MediaStreamTrack;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class bf {
    private final AudioManager a;
    private final bd b;
    private be c;
    private gs d;
    private int e;
    private int f;
    private float g = 1.0f;
    private AudioFocusRequest h;

    public bf(Context context, Handler handler, be beVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        ary.t(audioManager);
        this.a = audioManager;
        this.c = beVar;
        this.b = new bd(this, handler);
        this.e = 0;
    }

    static /* synthetic */ void e(bf bfVar, int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                bfVar.g(3);
                return;
            } else {
                bfVar.h(0);
                bfVar.g(2);
                return;
            }
        }
        if (i == -1) {
            bfVar.h(-1);
            bfVar.f();
        } else if (i == 1) {
            bfVar.g(1);
            bfVar.h(1);
        } else {
            StringBuilder sb = new StringBuilder(38);
            sb.append("Unknown focus change type: ");
            sb.append(i);
            Log.w("AudioFocusManager", sb.toString());
        }
    }

    private final void f() {
        if (this.e == 0) {
            return;
        }
        if (aeu.a >= 26) {
            AudioFocusRequest audioFocusRequest = this.h;
            if (audioFocusRequest != null) {
                this.a.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            this.a.abandonAudioFocus(this.b);
        }
        g(0);
    }

    private final void g(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.g == f) {
            return;
        }
        this.g = f;
        be beVar = this.c;
        if (beVar != null) {
            ej ejVar = ((ei) beVar).a;
            ejVar.ae(1, 2, Float.valueOf(ejVar.D * ejVar.m.a()));
        }
    }

    private final void h(int i) {
        be beVar = this.c;
        if (beVar != null) {
            ei eiVar = (ei) beVar;
            boolean zJ = eiVar.a.j();
            eiVar.a.ac(zJ, i, ej.ag(zJ, i));
        }
    }

    public final float a() {
        return this.g;
    }

    public final void b(gs gsVar) {
        if (aeu.c(null, null)) {
            return;
        }
        this.d = null;
        this.f = 0;
        ary.p(true, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final int c(boolean z, int i) {
        int iRequestAudioFocus;
        if (i == 1 || this.f != 1) {
            f();
            return z ? 1 : -1;
        }
        if (!z) {
            return -1;
        }
        if (this.e != 1) {
            if (aeu.a >= 26) {
                AudioFocusRequest audioFocusRequest = this.h;
                if (audioFocusRequest == null) {
                    new AudioFocusRequest.Builder(this.f);
                    ary.t(null);
                    throw null;
                }
                iRequestAudioFocus = this.a.requestAudioFocus(audioFocusRequest);
            } else {
                AudioManager audioManager = this.a;
                bd bdVar = this.b;
                ary.t(null);
                iRequestAudioFocus = audioManager.requestAudioFocus(bdVar, 3, this.f);
            }
            if (iRequestAudioFocus != 1) {
                g(0);
                return -1;
            }
            g(1);
        }
        return 1;
    }

    public final void d() {
        this.c = null;
        f();
    }
}
