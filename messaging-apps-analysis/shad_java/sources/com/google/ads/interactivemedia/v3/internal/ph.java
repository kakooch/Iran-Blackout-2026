package com.google.ads.interactivemedia.v3.internal;

import com.facebook.stetho.websocket.CloseCodes;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ph extends js {
    public ph(aes aesVar, long j, long j2) {
        super(new jn(), new oy(aesVar), j, j + 1, 0L, j2, 188L, CloseCodes.NORMAL_CLOSURE);
    }

    static /* synthetic */ int h(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public ph(aes aesVar, long j, long j2, int i, int i2) {
        super(new jn(), new pg(i, aesVar, i2), j, j + 1, 0L, j2, 188L, 940);
    }
}
