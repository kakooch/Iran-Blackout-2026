package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class bs {
    public abstract bt build();

    public abstract bs volume(float f);

    public bs volumePercentage(int i) {
        return volume(i / 100.0f);
    }
}
