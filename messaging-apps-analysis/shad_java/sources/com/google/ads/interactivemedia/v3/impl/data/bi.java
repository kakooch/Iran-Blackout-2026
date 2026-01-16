package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.aps;

/* compiled from: IMASDK */
@aps(a = ab.class)
/* loaded from: classes.dex */
public abstract class bi {
    public static bi create(String str, String str2, String str3) {
        return new ab(str, str2, str3);
    }

    public abstract String content();

    public abstract String contentType();

    public abstract String id();
}
