package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class alj extends amg implements AdDisplayContainer {
    private VideoAdPlayer a;

    public alj(ViewGroup viewGroup, VideoAdPlayer videoAdPlayer) {
        super(viewGroup);
        this.a = videoAdPlayer;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdDisplayContainer
    public final VideoAdPlayer getPlayer() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdDisplayContainer
    public final void setPlayer(VideoAdPlayer videoAdPlayer) {
        aqd.j(videoAdPlayer);
        this.a = videoAdPlayer;
    }

    public alj(Context context, VideoAdPlayer videoAdPlayer) {
        this(new amc(context), videoAdPlayer);
    }
}
