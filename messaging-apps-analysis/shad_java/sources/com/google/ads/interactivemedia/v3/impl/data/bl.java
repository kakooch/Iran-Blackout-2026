package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;
import com.google.ads.interactivemedia.v3.internal.aps;

/* compiled from: IMASDK */
@aps(a = ah.class)
/* loaded from: classes.dex */
public abstract class bl {
    public static bk builder() {
        return new ag();
    }

    abstract boolean attached();

    abstract as bounds();

    abstract String detailedReason();

    abstract boolean hidden();

    abstract FriendlyObstructionPurpose purpose();

    abstract String type();
}
