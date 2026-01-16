package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    BitArray(int[] bits, int size) {
        this.bits = bits;
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    private void ensureCapacity(int size) {
        if (size > this.bits.length * 32) {
            int[] iArrMakeArray = makeArray(size);
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, iArrMakeArray, 0, iArr.length);
            this.bits = iArrMakeArray;
        }
    }

    public boolean get(int i) {
        return ((1 << (i & 31)) & this.bits[i / 32]) != 0;
    }

    public void appendBit(boolean bit) {
        ensureCapacity(this.size + 1);
        if (bit) {
            int[] iArr = this.bits;
            int i = this.size;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.size++;
    }

    public void appendBits(int value, int numBits) {
        if (numBits < 0 || numBits > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + numBits);
        while (numBits > 0) {
            boolean z = true;
            if (((value >> (numBits - 1)) & 1) != 1) {
                z = false;
            }
            appendBit(z);
            numBits--;
        }
    }

    public void appendBitArray(BitArray other) {
        int i = other.size;
        ensureCapacity(this.size + i);
        for (int i2 = 0; i2 < i; i2++) {
            appendBit(other.get(i2));
        }
    }

    public void xor(BitArray other) {
        if (this.size != other.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = iArr[i] ^ other.bits[i];
            i++;
        }
    }

    public void toBytes(int bitOffset, byte[] array, int offset, int numBytes) {
        for (int i = 0; i < numBytes; i++) {
            int i2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                if (get(bitOffset)) {
                    i2 |= 1 << (7 - i3);
                }
                bitOffset++;
            }
            array[offset + i] = (byte) i2;
        }
    }

    private static int[] makeArray(int size) {
        return new int[(size + 31) / 32];
    }

    public boolean equals(Object o) {
        if (!(o instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) o;
        return this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits);
    }

    public int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.bits);
    }

    public String toString() {
        int i = this.size;
        StringBuilder sb = new StringBuilder(i + (i / 8) + 1);
        for (int i2 = 0; i2 < this.size; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitArray m12clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }
}
