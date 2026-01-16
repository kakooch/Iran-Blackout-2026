package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class qt implements qr {
    private final int a;
    private MediaCodecInfo[] b;

    public qt(boolean z, boolean z2) {
        int i = 1;
        if (!z && !z2) {
            i = 0;
        }
        this.a = i;
    }

    private final void f() {
        if (this.b == null) {
            this.b = new MediaCodecList(this.a).getCodecInfos();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qr
    public final int a() {
        f();
        return this.b.length;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qr
    public final MediaCodecInfo b(int i) {
        f();
        return this.b[i];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qr
    public final boolean c() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qr
    public final boolean d(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qr
    public final boolean e(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }
}
