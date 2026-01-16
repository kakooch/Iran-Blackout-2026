package com.google.ads.interactivemedia.v3.internal;

import android.util.Base64;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aoo implements apm {
    aoo() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.apm
    public final byte[] a(String str) throws IllegalArgumentException {
        return Base64.decode(str, 2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.apm
    public final String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }
}
