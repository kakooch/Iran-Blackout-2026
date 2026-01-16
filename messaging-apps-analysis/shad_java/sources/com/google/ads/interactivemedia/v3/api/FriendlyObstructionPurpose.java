package com.google.ads.interactivemedia.v3.api;

import com.google.ads.interactivemedia.v3.internal.k;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public enum FriendlyObstructionPurpose {
    VIDEO_CONTROLS,
    CLOSE_AD,
    NOT_VISIBLE,
    OTHER;

    public k getOmidPurpose() {
        return (k) Enum.valueOf(k.class, name());
    }
}
