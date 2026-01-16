package com.google.zxing.qrcode;

import com.google.zxing.qrcode.encoder.ByteMatrix;

/* loaded from: classes.dex */
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
      (r4v12 com.google.zxing.qrcode.decoder.ErrorCorrectionLevel)
     binds: [B:7:0x0014, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap encode(java.lang.String r25, com.google.zxing.BarcodeFormat r26, int r27, int r28, java.util.Map<com.google.zxing.EncodeHintType, ?> r29, android.graphics.Bitmap r30, android.content.Context r31) throws org.xml.sax.SAXException, java.lang.NumberFormatException, java.io.IOException, com.google.zxing.WriterException {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.QRCodeWriter.encode(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map, android.graphics.Bitmap, android.content.Context):android.graphics.Bitmap");
    }

    private boolean has(int x, int y) {
        int i = this.imageBlockX;
        if (x >= i) {
            int i2 = this.imageBloks;
            if (x < i + i2 && y >= i && y < i + i2) {
                return false;
            }
        }
        if ((x < this.sideQuadSize || x >= this.input.getWidth() - this.sideQuadSize) && y < this.sideQuadSize) {
            return false;
        }
        return (x >= this.sideQuadSize || y < this.input.getHeight() - this.sideQuadSize) && x >= 0 && y >= 0 && x < this.input.getWidth() && y < this.input.getHeight() && this.input.get(x, y) == 1;
    }

    public int getImageSize() {
        return this.imageSize;
    }
}
