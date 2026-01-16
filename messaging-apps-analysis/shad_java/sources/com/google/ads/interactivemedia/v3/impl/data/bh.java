package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.aps;

/* compiled from: IMASDK */
@aps(a = aa.class)
/* loaded from: classes.dex */
public abstract class bh {
    public static bh create(bg bgVar, String str, String str2, String str3, int i, int i2) {
        return new aa(bgVar, str, str2, str3, i, i2);
    }

    public abstract int connectionTimeoutMs();

    public abstract String id();

    public abstract int readTimeoutMs();

    public abstract bg requestType();

    public abstract String url();

    public abstract String userAgent();
}
