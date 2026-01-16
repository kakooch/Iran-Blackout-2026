package com.google.ads.interactivemedia.v3.api;

import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public interface AdDisplayContainer extends BaseDisplayContainer {
    VideoAdPlayer getPlayer();

    @Deprecated
    void setPlayer(VideoAdPlayer videoAdPlayer);
}
