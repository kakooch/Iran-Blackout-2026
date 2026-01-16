package com.google.ads.interactivemedia.v3.internal;

import com.google.ads.interactivemedia.v3.api.CuePoint;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class amn implements CuePoint {
    private final double a;
    private final double b;
    private final boolean c;

    amn(double d, double d2, boolean z) {
        this.a = d;
        this.b = d2;
        this.c = z;
    }

    @Override // com.google.ads.interactivemedia.v3.api.CuePoint
    public final double getEndTime() {
        return this.b;
    }

    @Override // com.google.ads.interactivemedia.v3.api.CuePoint
    public final double getStartTime() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.api.CuePoint
    public final boolean isPlayed() {
        return this.c;
    }
}
