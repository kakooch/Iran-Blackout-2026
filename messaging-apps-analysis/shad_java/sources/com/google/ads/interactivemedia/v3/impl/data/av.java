package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.aps;

/* compiled from: IMASDK */
@aps(a = s.class)
/* loaded from: classes.dex */
public abstract class av {
    private static av create(double d, double d2, boolean z) {
        return new s(d, d2, z);
    }

    public abstract double end();

    public abstract boolean played();

    public abstract double start();
}
