package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.HashMap;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aln implements VideoAdPlayer.VideoAdPlayerCallback {
    private final alm a;
    private boolean c = false;
    private final HashMap<AdMediaInfo, Boolean> b = asn.g(2);

    aln(alm almVar) {
        this.a = almVar;
    }

    private final void c(amw amwVar, AdMediaInfo adMediaInfo) {
        d(amwVar, adMediaInfo, null);
    }

    private final void d(amw amwVar, AdMediaInfo adMediaInfo, Object obj) {
        this.a.a(amwVar, adMediaInfo, obj);
    }

    final void a() {
        this.c = true;
    }

    final void b() {
        this.c = false;
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onAdProgress(AdMediaInfo adMediaInfo, VideoProgressUpdate videoProgressUpdate) {
        if (this.c && videoProgressUpdate != null && videoProgressUpdate.getDuration() > 0.0f) {
            if (this.b.get(adMediaInfo) == null && videoProgressUpdate.getCurrentTime() > 0.0f) {
                c(amw.start, adMediaInfo);
                this.b.put(adMediaInfo, Boolean.TRUE);
            }
            d(amw.timeupdate, adMediaInfo, com.google.ads.interactivemedia.v3.impl.data.bo.create(videoProgressUpdate));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onBuffering(AdMediaInfo adMediaInfo) {
        if (this.c) {
            c(amw.waiting, adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onContentComplete() {
        this.a.b(amv.adsLoader, amw.contentComplete);
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onEnded(AdMediaInfo adMediaInfo) {
        if (this.c) {
            c(amw.end, adMediaInfo);
            this.b.remove(adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onError(AdMediaInfo adMediaInfo) {
        if (this.c) {
            c(amw.error, adMediaInfo);
            this.b.remove(adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onLoaded(AdMediaInfo adMediaInfo) {
        if (this.c) {
            c(amw.loaded, adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onPause(AdMediaInfo adMediaInfo) {
        if (this.c) {
            c(amw.pause, adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onPlay(AdMediaInfo adMediaInfo) {
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onResume(AdMediaInfo adMediaInfo) {
        if (this.c) {
            c(amw.play, adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer.VideoAdPlayerCallback
    public final void onVolumeChanged(AdMediaInfo adMediaInfo, int i) {
        if (this.c) {
            d(amw.volumeChange, adMediaInfo, com.google.ads.interactivemedia.v3.impl.data.bt.builder().volumePercentage(i).build());
        }
    }
}
