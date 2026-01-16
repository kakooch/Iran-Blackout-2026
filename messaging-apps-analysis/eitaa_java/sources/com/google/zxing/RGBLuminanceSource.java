package com.google.zxing;

/* loaded from: classes.dex */
public final class RGBLuminanceSource extends LuminanceSource {
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final byte[] luminances;
    private final int top;

    public RGBLuminanceSource(int width, int height, int[] pixels) {
        super(width, height);
        this.dataWidth = width;
        this.dataHeight = height;
        this.left = 0;
        this.top = 0;
        int i = width * height;
        this.luminances = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = pixels[i2];
            this.luminances[i2] = (byte) (((((i3 >> 16) & 255) + ((i3 >> 7) & 510)) + (i3 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int y, byte[] row) {
        if (y < 0 || y >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + y);
        }
        int width = getWidth();
        if (row == null || row.length < width) {
            row = new byte[width];
        }
        System.arraycopy(this.luminances, ((y + this.top) * this.dataWidth) + this.left, row, 0, width);
        return row;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i = this.dataWidth;
        if (width == i && height == this.dataHeight) {
            return this.luminances;
        }
        int i2 = width * height;
        byte[] bArr = new byte[i2];
        int i3 = (this.top * i) + this.left;
        if (width == i) {
            System.arraycopy(this.luminances, i3, bArr, 0, i2);
            return bArr;
        }
        for (int i4 = 0; i4 < height; i4++) {
            System.arraycopy(this.luminances, i3, bArr, i4 * width, width);
            i3 += this.dataWidth;
        }
        return bArr;
    }
}
