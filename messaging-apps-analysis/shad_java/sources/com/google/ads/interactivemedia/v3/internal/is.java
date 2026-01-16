package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class is {
    private final MediaCodec.CryptoInfo a;
    private final MediaCodec.CryptoInfo.Pattern b = new MediaCodec.CryptoInfo.Pattern(0, 0);

    static /* synthetic */ void a(is isVar, int i, int i2) {
        isVar.b.set(i, i2);
        isVar.a.setPattern(isVar.b);
    }
}
