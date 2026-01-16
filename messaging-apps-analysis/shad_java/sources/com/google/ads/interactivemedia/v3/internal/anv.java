package com.google.ads.interactivemedia.v3.internal;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class anv extends amg implements StreamDisplayContainer {
    private VideoStreamPlayer a;

    public anv(ViewGroup viewGroup, VideoStreamPlayer videoStreamPlayer) {
        super(viewGroup);
        this.a = videoStreamPlayer;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamDisplayContainer
    public final VideoStreamPlayer getVideoStreamPlayer() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.api.StreamDisplayContainer
    public final void setVideoStreamPlayer(VideoStreamPlayer videoStreamPlayer) {
        aqd.j(videoStreamPlayer);
        this.a = videoStreamPlayer;
    }
}
