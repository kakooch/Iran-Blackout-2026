package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioTrack;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class hv extends Thread {
    final /* synthetic */ AudioTrack a;
    final /* synthetic */ ie b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    hv(ie ieVar, AudioTrack audioTrack) {
        super("ExoPlayer:AudioTrackReleaseThread");
        this.b = ieVar;
        this.a = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.a.flush();
            this.a.release();
        } finally {
            this.b.g.open();
        }
    }
}
