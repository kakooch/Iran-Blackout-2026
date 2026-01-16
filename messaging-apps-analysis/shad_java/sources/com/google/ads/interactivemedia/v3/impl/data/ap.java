package com.google.ads.interactivemedia.v3.impl.data;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ap extends bs {
    private Float volume;

    ap() {
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bs
    public bt build() {
        Float f = this.volume;
        String strConcat = BuildConfig.FLAVOR;
        if (f == null) {
            strConcat = BuildConfig.FLAVOR.concat(" volume");
        }
        if (strConcat.isEmpty()) {
            return new aq(this.volume.floatValue());
        }
        throw new IllegalStateException(strConcat.length() != 0 ? "Missing required properties:".concat(strConcat) : new String("Missing required properties:"));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.bs
    public bs volume(float f) {
        this.volume = Float.valueOf(f);
        return this;
    }
}
