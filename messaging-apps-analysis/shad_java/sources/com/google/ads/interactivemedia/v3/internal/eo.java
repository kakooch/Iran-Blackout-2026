package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import java.util.Iterator;
import org.webrtc.MediaStreamTrack;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class eo {
    private final Context a;
    private final Handler b;
    private final el c;
    private final AudioManager d;
    private final en e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;

    public eo(Context context, Handler handler, el elVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = handler;
        this.c = elVar;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        ary.s(audioManager);
        this.d = audioManager;
        this.f = 3;
        this.g = audioManager.getStreamVolume(3);
        this.h = h(audioManager, this.f);
        en enVar = new en(this);
        this.e = enVar;
        applicationContext.registerReceiver(enVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        int streamVolume = this.d.getStreamVolume(this.f);
        boolean zH = h(this.d, this.f);
        if (this.g == streamVolume && this.h == zH) {
            return;
        }
        this.g = streamVolume;
        this.h = zH;
        Iterator it = ((ei) this.c).a.h.iterator();
        while (it.hasNext()) {
            ((iy) it.next()).b();
        }
    }

    private static boolean h(AudioManager audioManager, int i) {
        return aeu.a >= 23 ? audioManager.isStreamMute(i) : audioManager.getStreamVolume(i) == 0;
    }

    public final void a(int i) {
        if (this.f == 3) {
            return;
        }
        this.f = 3;
        g();
        ei eiVar = (ei) this.c;
        ix ixVarAf = ej.af(eiVar.a.n);
        if (ixVarAf.equals(eiVar.a.H)) {
            return;
        }
        eiVar.a.H = ixVarAf;
        Iterator it = eiVar.a.h.iterator();
        while (it.hasNext()) {
            ((iy) it.next()).a();
        }
    }

    public final int b() {
        if (aeu.a >= 28) {
            return this.d.getStreamMinVolume(this.f);
        }
        return 0;
    }

    public final int c() {
        return this.d.getStreamMaxVolume(this.f);
    }

    public final void d() {
        if (this.i) {
            return;
        }
        this.a.unregisterReceiver(this.e);
        this.i = true;
    }
}
