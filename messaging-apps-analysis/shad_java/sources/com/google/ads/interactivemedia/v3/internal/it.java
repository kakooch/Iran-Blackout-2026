package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class it {
    public byte[] a;
    public int[] b;
    public int[] c;
    private final MediaCodec.CryptoInfo d;
    private final is e;

    public it() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.d = cryptoInfo;
        this.e = aeu.a >= 24 ? new is(cryptoInfo) : null;
    }

    public final void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.b = iArr;
        this.c = iArr2;
        this.a = bArr2;
        MediaCodec.CryptoInfo cryptoInfo = this.d;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (aeu.a >= 24) {
            is isVar = this.e;
            ary.t(isVar);
            is.a(isVar, i3, i4);
        }
    }

    public final MediaCodec.CryptoInfo b() {
        return this.d;
    }

    public final void c(int i) {
        if (i == 0) {
            return;
        }
        if (this.b == null) {
            int[] iArr = new int[1];
            this.b = iArr;
            this.d.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.b;
        iArr2[0] = iArr2[0] + i;
    }
}
