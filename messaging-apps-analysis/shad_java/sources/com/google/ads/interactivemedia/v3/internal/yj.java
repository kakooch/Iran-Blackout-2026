package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.util.LinkedHashMap;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class yj {
    private final LinkedHashMap<Uri, byte[]> a = new yi();

    public final byte[] a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.a.get(uri);
    }

    public final byte[] b(Uri uri) {
        return this.a.remove(uri);
    }

    public final void c(Uri uri, byte[] bArr) {
        LinkedHashMap<Uri, byte[]> linkedHashMap = this.a;
        ary.t(uri);
        linkedHashMap.put(uri, bArr);
    }
}
