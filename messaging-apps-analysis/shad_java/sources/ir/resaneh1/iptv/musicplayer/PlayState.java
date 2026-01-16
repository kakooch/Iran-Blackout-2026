package ir.resaneh1.iptv.musicplayer;

/* loaded from: classes3.dex */
public enum PlayState {
    none,
    prepareStreamUrl,
    preparingMedia,
    mediaPrepared,
    mediaPlaying,
    mediaPaused,
    complete,
    waitForRetry,
    serviceDestroyed
}
