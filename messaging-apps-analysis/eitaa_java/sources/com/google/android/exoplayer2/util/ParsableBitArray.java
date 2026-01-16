package com.google.android.exoplayer2.util;

/* loaded from: classes.dex */
public final class ParsableBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    public byte[] data;

    public ParsableBitArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    public ParsableBitArray(byte[] data) {
        this(data, data.length);
    }

    public ParsableBitArray(byte[] data, int limit) {
        this.data = data;
        this.byteLimit = limit;
    }

    public void reset(byte[] data) {
        reset(data, data.length);
    }

    public void reset(ParsableByteArray parsableByteArray) {
        reset(parsableByteArray.data, parsableByteArray.limit());
        setPosition(parsableByteArray.getPosition() * 8);
    }

    public void reset(byte[] data, int limit) {
        this.data = data;
        this.byteOffset = 0;
        this.bitOffset = 0;
        this.byteLimit = limit;
    }

    public int bitsLeft() {
        return ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public int getBytePosition() {
        Assertions.checkState(this.bitOffset == 0);
        return this.byteOffset;
    }

    public void setPosition(int position) {
        int i = position / 8;
        this.byteOffset = i;
        this.bitOffset = position - (i * 8);
        assertValidOffset();
    }

    public void skipBit() {
        int i = this.bitOffset + 1;
        this.bitOffset = i;
        if (i == 8) {
            this.bitOffset = 0;
            this.byteOffset++;
        }
        assertValidOffset();
    }

    public void skipBits(int numBits) {
        int i = numBits / 8;
        int i2 = this.byteOffset + i;
        this.byteOffset = i2;
        int i3 = this.bitOffset + (numBits - (i * 8));
        this.bitOffset = i3;
        if (i3 > 7) {
            this.byteOffset = i2 + 1;
            this.bitOffset = i3 - 8;
        }
        assertValidOffset();
    }

    public boolean readBit() {
        boolean z = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        skipBit();
        return z;
    }

    public int readBits(int numBits) {
        int i;
        if (numBits == 0) {
            return 0;
        }
        this.bitOffset += numBits;
        int i2 = 0;
        while (true) {
            i = this.bitOffset;
            if (i <= 8) {
                break;
            }
            int i3 = i - 8;
            this.bitOffset = i3;
            byte[] bArr = this.data;
            int i4 = this.byteOffset;
            this.byteOffset = i4 + 1;
            i2 |= (bArr[i4] & 255) << i3;
        }
        byte[] bArr2 = this.data;
        int i5 = this.byteOffset;
        int i6 = ((-1) >>> (32 - numBits)) & (i2 | ((bArr2[i5] & 255) >> (8 - i)));
        if (i == 8) {
            this.bitOffset = 0;
            this.byteOffset = i5 + 1;
        }
        assertValidOffset();
        return i6;
    }

    public long readBitsToLong(int numBits) {
        if (numBits <= 32) {
            return Util.toUnsignedLong(readBits(numBits));
        }
        return Util.toLong(readBits(numBits - 32), readBits(32));
    }

    public void readBits(byte[] buffer, int offset, int numBits) {
        int i = (numBits >> 3) + offset;
        while (offset < i) {
            byte[] bArr = this.data;
            int i2 = this.byteOffset;
            int i3 = i2 + 1;
            this.byteOffset = i3;
            byte b = bArr[i2];
            int i4 = this.bitOffset;
            buffer[offset] = (byte) (b << i4);
            buffer[offset] = (byte) (((255 & bArr[i3]) >> (8 - i4)) | buffer[offset]);
            offset++;
        }
        int i5 = numBits & 7;
        if (i5 == 0) {
            return;
        }
        buffer[i] = (byte) (buffer[i] & (255 >> i5));
        int i6 = this.bitOffset;
        if (i6 + i5 > 8) {
            int i7 = buffer[i];
            byte[] bArr2 = this.data;
            int i8 = this.byteOffset;
            this.byteOffset = i8 + 1;
            buffer[i] = (byte) (i7 | ((bArr2[i8] & 255) << i6));
            this.bitOffset = i6 - 8;
        }
        int i9 = this.bitOffset + i5;
        this.bitOffset = i9;
        byte[] bArr3 = this.data;
        int i10 = this.byteOffset;
        buffer[i] = (byte) (((byte) (((255 & bArr3[i10]) >> (8 - i9)) << (8 - i5))) | buffer[i]);
        if (i9 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i10 + 1;
        }
        assertValidOffset();
    }

    public void byteAlign() {
        if (this.bitOffset == 0) {
            return;
        }
        this.bitOffset = 0;
        this.byteOffset++;
        assertValidOffset();
    }

    public void readBytes(byte[] buffer, int offset, int length) {
        Assertions.checkState(this.bitOffset == 0);
        System.arraycopy(this.data, this.byteOffset, buffer, offset, length);
        this.byteOffset += length;
        assertValidOffset();
    }

    public void skipBytes(int length) {
        Assertions.checkState(this.bitOffset == 0);
        this.byteOffset += length;
        assertValidOffset();
    }

    public void putInt(int value, int numBits) {
        if (numBits < 32) {
            value &= (1 << numBits) - 1;
        }
        int iMin = Math.min(8 - this.bitOffset, numBits);
        int i = this.bitOffset;
        int i2 = (8 - i) - iMin;
        byte[] bArr = this.data;
        int i3 = this.byteOffset;
        bArr[i3] = (byte) (((65280 >> i) | ((1 << i2) - 1)) & bArr[i3]);
        int i4 = numBits - iMin;
        bArr[i3] = (byte) (((value >>> i4) << i2) | bArr[i3]);
        int i5 = i3 + 1;
        while (i4 > 8) {
            this.data[i5] = (byte) (value >>> (i4 - 8));
            i4 -= 8;
            i5++;
        }
        int i6 = 8 - i4;
        byte[] bArr2 = this.data;
        bArr2[i5] = (byte) (bArr2[i5] & ((1 << i6) - 1));
        bArr2[i5] = (byte) (((value & ((1 << i4) - 1)) << i6) | bArr2[i5]);
        skipBits(numBits);
        assertValidOffset();
    }

    private void assertValidOffset() {
        int i;
        int i2 = this.byteOffset;
        Assertions.checkState(i2 >= 0 && (i2 < (i = this.byteLimit) || (i2 == i && this.bitOffset == 0)));
    }
}
