package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class yi extends LinkedHashMap<Uri, byte[]> {
    final /* synthetic */ int a = 4;

    yi() {
        super(5, 1.0f, false);
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
        return size() > this.a;
    }
}
