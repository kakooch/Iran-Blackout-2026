package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.AdProgressInfo;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class alo implements AdProgressInfo {
    private final double a;
    private final double b;
    private final int c;
    private final int d;
    private final double e;
    private final double f;

    alo(double d, double d2, int i, int i2, double d3, double d4) {
        this.a = d;
        this.b = d2;
        this.c = i;
        this.d = i2;
        this.e = d3;
        this.f = d4;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final double getAdBreakDuration() {
        return this.e;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final double getAdPeriodDuration() {
        return this.f;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final int getAdPosition() {
        return this.c;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final double getCurrentTime() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final double getDuration() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdProgressInfo
    public final int getTotalAds() {
        return this.d;
    }
}
