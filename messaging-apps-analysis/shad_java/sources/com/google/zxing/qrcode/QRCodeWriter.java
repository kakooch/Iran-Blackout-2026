package com.google.zxing.qrcode;

import com.google.zxing.qrcode.encoder.ByteMatrix;

/* loaded from: classes3.dex */
public final class QRCodeWriter {
    private int imageBlockX;
    private int imageBloks;
    private int imageSize;
    private ByteMatrix input;
    private float[] radii = new float[8];
    private int sideQuadSize;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041 A[PHI: r4
      0x0041: PHI (r4v3 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel) = 
      (r4v2 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel)
      (r4v16 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel)
     binds: [B:7:0x0014, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap encode(java.lang.String r24, com.google.zxing.BarcodeFormat r25, int r26, int r27, java.util.Map<com.google.zxing.EncodeHintType, ?> r28, android.graphics.Bitmap r29, android.content.Context r30) throws java.lang.NumberFormatException, com.google.zxing.WriterException {
        /*
            Method dump skipped, instructions count: 838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.QRCodeWriter.encode(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map, android.graphics.Bitmap, android.content.Context):android.graphics.Bitmap");
    }

    private boolean has(int i, int i2) {
        int i3 = this.imageBlockX;
        if (i >= i3) {
            int i4 = this.imageBloks;
            if (i < i3 + i4 && i2 >= i3 && i2 < i3 + i4) {
                return false;
            }
        }
        if ((i < this.sideQuadSize || i >= this.input.getWidth() - this.sideQuadSize) && i2 < this.sideQuadSize) {
            return false;
        }
        return (i >= this.sideQuadSize || i2 < this.input.getHeight() - this.sideQuadSize) && i >= 0 && i2 >= 0 && i < this.input.getWidth() && i2 < this.input.getHeight() && this.input.get(i, i2) == 1;
    }

    public int getImageSize() {
        return this.imageSize;
    }
}
