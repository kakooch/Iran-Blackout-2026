package com.pedro.encoder;

/* loaded from: classes3.dex */
public class Frame {
    private byte[] buffer;
    private boolean flip;
    private int format;
    private int offset;
    private int orientation;
    private int size;

    public Frame(byte[] bArr, int i, boolean z, int i2) {
        this.format = 17;
        this.buffer = bArr;
        this.orientation = i;
        this.flip = z;
        this.format = i2;
        this.offset = 0;
        this.size = bArr.length;
    }

    public Frame(byte[] bArr, int i, int i2) {
        this.format = 17;
        this.buffer = bArr;
        this.offset = i;
        this.size = i2;
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public void setBuffer(byte[] bArr) {
        this.buffer = bArr;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean isFlip() {
        return this.flip;
    }

    public int getFormat() {
        return this.format;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSize() {
        return this.size;
    }
}
