package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ByteMatrix {
    private final byte[][] bytes;
    private final int height;
    private final int width;

    public ByteMatrix(int width, int height) {
        this.bytes = (byte[][]) Array.newInstance((Class<?>) byte.class, height, width);
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public byte get(int x, int y) {
        return this.bytes[y][x];
    }

    public byte[][] getArray() {
        return this.bytes;
    }

    public void set(int x, int y, int value) {
        this.bytes[y][x] = (byte) value;
    }

    public void set(int i, int i2, boolean z) {
        this.bytes[i2][i] = z ? (byte) 1 : (byte) 0;
    }

    public void clear(byte value) {
        for (byte[] bArr : this.bytes) {
            Arrays.fill(bArr, value);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.width * 2 * this.height) + 2);
        for (int i = 0; i < this.height; i++) {
            byte[] bArr = this.bytes[i];
            for (int i2 = 0; i2 < this.width; i2++) {
                byte b = bArr[i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b == 1) {
                    sb.append(" 1");
                } else {
                    sb.append("  ");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
