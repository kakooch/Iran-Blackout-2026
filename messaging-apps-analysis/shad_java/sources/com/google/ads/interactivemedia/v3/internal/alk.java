package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class alk implements AdErrorEvent {
    private final AdError a;
    private final Object b;

    alk(AdError adError) {
        this.a = adError;
        this.b = null;
    }

    alk(AdError adError, Object obj) {
        this.a = adError;
        this.b = obj;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent
    public final AdError getError() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent
    public final Object getUserRequestContext() {
        return this.b;
    }
}
