package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int multiple;
    private final int rowSize;
    private final int width;

    public BitMatrix(int dimension) {
        this(dimension, dimension, 1);
    }

    public BitMatrix(int width, int height, int multiple) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = width;
        this.height = height;
        this.multiple = multiple;
        int i = (width + 31) / 32;
        this.rowSize = i;
        this.bits = new int[i * height];
    }

    private BitMatrix(int width, int height, int rowSize, int[] bits) {
        this.width = width;
        this.height = height;
        this.rowSize = rowSize;
        this.bits = bits;
        this.multiple = 1;
    }

    public boolean get(int x, int y) {
        return ((this.bits[(y * this.rowSize) + (x / 32)] >>> (x & 31)) & 1) != 0;
    }

    public void set(int x, int y) {
        int i = (y * this.rowSize) + (x / 32);
        int[] iArr = this.bits;
        iArr[i] = (1 << (x & 31)) | iArr[i];
    }

    public void flip(int x, int y) {
        int i = (y * this.rowSize) + (x / 32);
        int[] iArr = this.bits;
        iArr[i] = (1 << (x & 31)) ^ iArr[i];
    }

    public void setRegion(int left, int top, int width, int height) {
        if (top < 0 || left < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (height < 1 || width < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i = width + left;
        int i2 = height + top;
        if (i2 > this.height || i > this.width) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (top < i2) {
            int i3 = this.rowSize * top;
            for (int i4 = left; i4 < i; i4++) {
                int[] iArr = this.bits;
                int i5 = (i4 / 32) + i3;
                iArr[i5] = iArr[i5] | (1 << (i4 & 31));
            }
            top++;
        }
    }

    public int[] getTopLeftOnBit() {
        int[] iArr;
        int i = 0;
        while (true) {
            iArr = this.bits;
            if (i >= iArr.length || iArr[i] != 0) {
                break;
            }
            i++;
        }
        if (i == iArr.length) {
            return null;
        }
        int i2 = this.rowSize;
        int i3 = i / i2;
        int i4 = (i % i2) * 32;
        int i5 = iArr[i];
        int i6 = 0;
        while ((i5 << (31 - i6)) == 0) {
            i6++;
        }
        return new int[]{i4 + i6, i3};
    }

    public int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.rowSize;
        int i2 = length / i;
        int i3 = (length % i) * 32;
        int i4 = 31;
        while ((this.bits[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean equals(Object o) {
        if (!(o instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) o;
        return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
    }

    public int hashCode() {
        int i = this.width;
        return (((((((i * 31) + i) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public String toString(String setString, String unsetString) {
        return buildToString(setString, unsetString, "\n");
    }

    private String buildToString(String setString, String unsetString, String lineSeparator) {
        StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            for (int i2 = 0; i2 < this.width; i2++) {
                sb.append(get(i2, i) ? setString : unsetString);
            }
            sb.append(lineSeparator);
        }
        return sb.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitMatrix m13clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }
}
