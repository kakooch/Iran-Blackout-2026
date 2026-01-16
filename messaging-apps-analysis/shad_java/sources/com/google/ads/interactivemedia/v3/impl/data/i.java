package com.google.ads.interactivemedia.v3.impl.data;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class i implements a {
    private String appState;
    private String eventId;
    private Long nativeTime;
    private Boolean nativeViewAttached;
    private as nativeViewBounds;
    private Boolean nativeViewHidden;
    private as nativeViewVisibleBounds;
    private Double nativeVolume;
    private String queryId;

    i() {
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.a
    public a appState(String str) {
        if (str == null) {
            throw new NullPointerException("Null appState");
        }
        this.appState = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.a
    public b build() {
        String str = this.queryId;
        String strConcat = BuildConfig.FLAVOR;
        if (str == null) {
            strConcat = BuildConfig.FLAVOR.concat(" queryId");
        }
        if (this.eventId == null) {
            strConcat = String.valueOf(strConcat).concat(" eventId");
        }
        if (this.appState == null) {
            strConcat = String.valueOf(strConcat).concat(" appState");
        }
        if (this.nativeTime == null) {
            strConcat = String.valueOf(strConcat).concat(" nativeTime");
        }
        if (this.nativeVolume == null) {
            strConcat = String.valueOf(strConcat).concat(" nativeVolume");
        }
        if (this.nativeViewAttached == null) {
            strConcat = String.valueOf(strConcat).concat(" nativeViewAttached");
        }
        if (this.nativeViewHidden == null) {
            strConcat = String.valueOf(strConcat).concat(" nativeViewHidden");
        }
        if (this.nativeViewBounds == null) {
            strConcat = String.valueOf(strConcat).concat(" nativeViewBounds");
        }
        if (this.nativeViewVisibleBounds == null) {
            strConcat = String.valueOf(strConcat).concat(" nativeViewVisibleBounds");
        }
        if (strConcat.isEmpty()) {
            return new j(this.queryId, this.eventId, this.appState, this.nativeTime.longValue(), this.nativeVolume.doubleValue(), this.nativeViewAttached.booleanValue(), this.nativeViewHidden.booleanValue(), this.nativeViewBounds, this.nativeViewVisibleBounds);
        }
        throw new IllegalStateException(strConcat.length() != 0 ? "Missing required properties:".concat(strConcat) : new String("Missing required properties:"));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.a
    public a eventId(String str) {
        if (str == null) {
            throw new NullPointerException("Null eventId");
        }
        this.eventId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.a
    public a nativeTime(long j) {
        this.nativeTime = Long.valueOf(j);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.a
    public a nativeViewAttached(boolean z) {
        this.nativeViewAttached = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.a
    public a nativeViewBounds(as asVar) {
        if (asVar == null) {
            throw new NullPointerException("Null nativeViewBounds");
        }
        this.nativeViewBounds = asVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.a
    public a nativeViewHidden(boolean z) {
        this.nativeViewHidden = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.a
    public a nativeViewVisibleBounds(as asVar) {
        if (asVar == null) {
            throw new NullPointerException("Null nativeViewVisibleBounds");
        }
        this.nativeViewVisibleBounds = asVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.a
    public a nativeVolume(double d) {
        this.nativeVolume = Double.valueOf(d);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.a
    public a queryId(String str) {
        if (str == null) {
            throw new NullPointerException("Null queryId");
        }
        this.queryId = str;
        return this;
    }
}
