package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdsManager;
import com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.v3.api.StreamManager;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class alx implements AdsManagerLoadedEvent {
    private final AdsManager a;
    private final StreamManager b;
    private final Object c;

    alx(AdsManager adsManager, Object obj) {
        this.a = adsManager;
        this.b = null;
        this.c = obj;
    }

    alx(StreamManager streamManager, Object obj) {
        this.a = null;
        this.b = streamManager;
        this.c = obj;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent
    public final AdsManager getAdsManager() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent
    public final StreamManager getStreamManager() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdsManagerLoadedEvent
    public final Object getUserRequestContext() {
        return this.c;
    }
}
