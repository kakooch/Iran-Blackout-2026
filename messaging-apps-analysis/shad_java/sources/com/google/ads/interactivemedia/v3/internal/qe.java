package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public interface qe {
    void a();

    int b();

    int c(MediaCodec.BufferInfo bufferInfo);

    MediaFormat d();

    void e();

    MediaCodec f();

    void g(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto);

    void h(int i, int i2, long j, int i3);

    void i(int i, it itVar, long j);
}
