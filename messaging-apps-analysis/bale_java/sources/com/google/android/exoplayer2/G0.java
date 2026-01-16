package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import livekit.org.webrtc.MediaStreamTrack;

/* loaded from: classes2.dex */
final class G0 {
    private final Context a;
    private final Handler b;
    private final b c;
    private final AudioManager d;
    private c e;
    private int f;
    private int g;
    private boolean h;

    public interface b {
        void a(int i);

        void p(int i, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = G0.this.b;
            final G0 g0 = G0.this;
            handler.post(new Runnable() { // from class: com.google.android.exoplayer2.H0
                @Override // java.lang.Runnable
                public final void run() {
                    G0.b(g0);
                }
            });
        }
    }

    public G0(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = handler;
        this.c = bVar;
        AudioManager audioManager = (AudioManager) AbstractC20011rK.i((AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND));
        this.d = audioManager;
        this.f = 3;
        this.g = g(audioManager, 3);
        this.h = e(audioManager, this.f);
        c cVar = new c();
        try {
            AbstractC9683aN7.L0(applicationContext, cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.e = cVar;
        } catch (RuntimeException e) {
            AbstractC18815pI3.l("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(G0 g0) {
        g0.j();
    }

    private static boolean e(AudioManager audioManager, int i) {
        return AbstractC9683aN7.a >= 23 ? audioManager.isStreamMute(i) : g(audioManager, i) == 0;
    }

    private static int g(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            AbstractC18815pI3.l("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i, e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int iG = g(this.d, this.f);
        boolean zE = e(this.d, this.f);
        if (this.g == iG && this.h == zE) {
            return;
        }
        this.g = iG;
        this.h = zE;
        this.c.p(iG, zE);
    }

    public int c() {
        return this.d.getStreamMaxVolume(this.f);
    }

    public int d() {
        if (AbstractC9683aN7.a >= 28) {
            return this.d.getStreamMinVolume(this.f);
        }
        return 0;
    }

    public int f() {
        return this.g;
    }

    public void h() {
        c cVar = this.e;
        if (cVar != null) {
            try {
                this.a.unregisterReceiver(cVar);
            } catch (RuntimeException e) {
                AbstractC18815pI3.l("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            this.e = null;
        }
    }

    public void i(int i) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        j();
        this.c.a(i);
    }
}
