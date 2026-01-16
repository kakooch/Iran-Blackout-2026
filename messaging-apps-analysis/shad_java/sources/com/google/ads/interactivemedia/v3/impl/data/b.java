package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.aps;

/* compiled from: IMASDK */
@aps(a = j.class)
/* loaded from: classes.dex */
public abstract class b {
    public static a builder() {
        return new i();
    }

    public abstract String appState();

    public abstract String eventId();

    public abstract long nativeTime();

    public abstract boolean nativeViewAttached();

    public abstract as nativeViewBounds();

    public abstract boolean nativeViewHidden();

    public abstract as nativeViewVisibleBounds();

    public abstract double nativeVolume();

    public abstract String queryId();
}
