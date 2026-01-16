package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class qw implements qe {
    private final MediaCodec a;

    public qw(MediaCodec mediaCodec) {
        this.a = mediaCodec;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qe
    public final void a() {
        this.a.start();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qe
    public final int b() {
        return this.a.dequeueInputBuffer(0L);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qe
    public final int c(MediaCodec.BufferInfo bufferInfo) {
        return this.a.dequeueOutputBuffer(bufferInfo, 0L);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qe
    public final MediaFormat d() {
        return this.a.getOutputFormat();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qe
    public final void e() {
        this.a.flush();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qe
    public final MediaCodec f() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qe
    public final void g(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto) {
        this.a.configure(mediaFormat, surface, mediaCrypto, 0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qe
    public final void h(int i, int i2, long j, int i3) throws MediaCodec.CryptoException {
        this.a.queueInputBuffer(i, 0, i2, j, i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.qe
    public final void i(int i, it itVar, long j) throws MediaCodec.CryptoException {
        this.a.queueSecureInputBuffer(i, 0, itVar.b(), j, 0);
    }
}
