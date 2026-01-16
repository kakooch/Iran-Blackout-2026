package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.aps;

/* compiled from: IMASDK */
@aps(a = t.class)
/* loaded from: classes.dex */
public abstract class aw {
    static aw create(int i, boolean z) {
        return new t(i, z);
    }

    public abstract int experimentId();

    public abstract boolean shouldReport();
}
