package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import com.google.ads.interactivemedia.v3.internal.so;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class sp<T extends so<T>> implements adc<T> {
    private final adc<? extends T> a;
    private final List<sr> b;

    public sp(adc<? extends T> adcVar, List<sr> list) {
        this.a = adcVar;
        this.b = list;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adc
    public final /* bridge */ /* synthetic */ Object a(Uri uri, InputStream inputStream) throws IOException {
        T tA = this.a.a(uri, inputStream);
        List<sr> list = this.b;
        return (list == null || list.isEmpty()) ? tA : (so) tA.a(this.b);
    }
}
