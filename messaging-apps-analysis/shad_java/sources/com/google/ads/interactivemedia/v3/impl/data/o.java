package com.google.ads.interactivemedia.v3.impl.data;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class o extends ar {
    private Integer height;
    private Integer left;
    private Integer top;
    private Integer width;

    o() {
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.ar
    public as build() {
        Integer num = this.left;
        String strConcat = BuildConfig.FLAVOR;
        if (num == null) {
            strConcat = BuildConfig.FLAVOR.concat(" left");
        }
        if (this.top == null) {
            strConcat = String.valueOf(strConcat).concat(" top");
        }
        if (this.height == null) {
            strConcat = String.valueOf(strConcat).concat(" height");
        }
        if (this.width == null) {
            strConcat = String.valueOf(strConcat).concat(" width");
        }
        if (strConcat.isEmpty()) {
            return new p(this.left.intValue(), this.top.intValue(), this.height.intValue(), this.width.intValue());
        }
        throw new IllegalStateException(strConcat.length() != 0 ? "Missing required properties:".concat(strConcat) : new String("Missing required properties:"));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.ar
    public ar height(int i) {
        this.height = Integer.valueOf(i);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.ar
    public ar left(int i) {
        this.left = Integer.valueOf(i);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.ar
    public ar top(int i) {
        this.top = Integer.valueOf(i);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.ar
    public ar width(int i) {
        this.width = Integer.valueOf(i);
        return this;
    }
}
