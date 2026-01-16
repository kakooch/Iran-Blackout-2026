package com.google.zxing.common;

/* loaded from: classes.dex */
public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bytes) {
        this.bytes = bytes;
    }

    public int readBits(int numBits) {
        if (numBits < 1 || numBits > 32 || numBits > available()) {
            throw new IllegalArgumentException(String.valueOf(numBits));
        }
        int i = this.bitOffset;
        int i2 = 0;
        if (i > 0) {
            int i3 = 8 - i;
            int iMin = Math.min(numBits, i3);
            int i4 = i3 - iMin;
            byte[] bArr = this.bytes;
            int i5 = this.byteOffset;
            int i6 = (((255 >> (8 - iMin)) << i4) & bArr[i5]) >> i4;
            numBits -= iMin;
            int i7 = this.bitOffset + iMin;
            this.bitOffset = i7;
            if (i7 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i5 + 1;
            }
            i2 = i6;
        }
        if (numBits <= 0) {
            return i2;
        }
        while (numBits >= 8) {
            int i8 = i2 << 8;
            byte[] bArr2 = this.bytes;
            int i9 = this.byteOffset;
            i2 = (bArr2[i9] & 255) | i8;
            this.byteOffset = i9 + 1;
            numBits -= 8;
        }
        if (numBits <= 0) {
            return i2;
        }
        int i10 = 8 - numBits;
        int i11 = (i2 << numBits) | ((((255 >> i10) << i10) & this.bytes[this.byteOffset]) >> i10);
        this.bitOffset += numBits;
        return i11;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }
}
