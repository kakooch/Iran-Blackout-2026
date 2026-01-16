package com.google.zxing;

/* loaded from: classes.dex */
public final class PlanarYUVLuminanceSource extends LuminanceSource {
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final int top;
    private final byte[] yuvData;

    public PlanarYUVLuminanceSource(byte[] yuvData, int dataWidth, int dataHeight, int left, int top, int width, int height, boolean reverseHorizontal) {
        super(width, height);
        if (left + width > dataWidth || top + height > dataHeight) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.yuvData = yuvData;
        this.dataWidth = dataWidth;
        this.dataHeight = dataHeight;
        this.left = left;
        this.top = top;
        if (reverseHorizontal) {
            reverseHorizontal(width, height);
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
        System.arraycopy(this.yuvData, ((y + this.top) * this.dataWidth) + this.left, row, 0, width);
        return row;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i = this.dataWidth;
        if (width == i && height == this.dataHeight) {
            return this.yuvData;
        }
        int i2 = width * height;
        byte[] bArr = new byte[i2];
        int i3 = (this.top * i) + this.left;
        if (width == i) {
            System.arraycopy(this.yuvData, i3, bArr, 0, i2);
            return bArr;
        }
        for (int i4 = 0; i4 < height; i4++) {
            System.arraycopy(this.yuvData, i3, bArr, i4 * width, width);
            i3 += this.dataWidth;
        }
        return bArr;
    }

    private void reverseHorizontal(int width, int height) {
        byte[] bArr = this.yuvData;
        int i = (this.top * this.dataWidth) + this.left;
        int i2 = 0;
        while (i2 < height) {
            int i3 = (width / 2) + i;
            int i4 = (i + width) - 1;
            int i5 = i;
            while (i5 < i3) {
                byte b = bArr[i5];
                bArr[i5] = bArr[i4];
                bArr[i4] = b;
                i5++;
                i4--;
            }
            i2++;
            i += this.dataWidth;
        }
    }
}
