package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.decoder.CryptoInfo;

/* loaded from: classes.dex */
class SynchronousMediaCodecBufferEnqueuer implements MediaCodecInputBufferEnqueuer {
    private final MediaCodec codec;

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void flush() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void shutdown() {
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void start() {
    }

    SynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec) {
        this.codec = mediaCodec;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) throws MediaCodec.CryptoException {
        this.codec.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecInputBufferEnqueuer
    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) throws MediaCodec.CryptoException {
        this.codec.queueSecureInputBuffer(i, i2, cryptoInfo.getFrameworkCryptoInfo(), j, i3);
    }
}
