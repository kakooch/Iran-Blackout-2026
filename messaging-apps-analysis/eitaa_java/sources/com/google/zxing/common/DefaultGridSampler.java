package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public final class DefaultGridSampler extends GridSampler {
    @Override // com.google.zxing.common.GridSampler
    public BitMatrix sampleGrid(BitMatrix image, int dimensionX, int dimensionY, PerspectiveTransform transform) throws NotFoundException {
        if (dimensionX <= 0 || dimensionY <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        BitMatrix bitMatrix = new BitMatrix(dimensionX, dimensionY, 1);
        int i = dimensionX * 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < dimensionY; i2++) {
            float f = i2 + 0.5f;
            for (int i3 = 0; i3 < i; i3 += 2) {
                fArr[i3] = (i3 / 2) + 0.5f;
                fArr[i3 + 1] = f;
            }
            transform.transformPoints(fArr);
            GridSampler.checkAndNudgePoints(image, fArr);
            for (int i4 = 0; i4 < i; i4 += 2) {
                try {
                    if (image.get((int) fArr[i4], (int) fArr[i4 + 1])) {
                        bitMatrix.set(i4 / 2, i2);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
        return bitMatrix;
    }
}
