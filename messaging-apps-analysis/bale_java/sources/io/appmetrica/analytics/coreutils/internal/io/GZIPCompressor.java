package io.appmetrica.analytics.coreutils.internal.io;

import io.appmetrica.analytics.coreapi.internal.io.Compressor;

/* loaded from: classes3.dex */
public class GZIPCompressor implements Compressor {
    @Override // io.appmetrica.analytics.coreapi.internal.io.Compressor
    public byte[] compress(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return GZIPUtils.gzipBytes(bArr);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.Compressor
    public byte[] uncompress(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return GZIPUtils.unGzipBytes(bArr);
    }
}
