package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class wv implements adc<Long> {
    private wv() {
    }

    /* synthetic */ wv(byte[] bArr) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adc
    public final /* bridge */ /* synthetic */ Long a(Uri uri, InputStream inputStream) throws IOException {
        return Long.valueOf(aeu.M(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
    }
}
