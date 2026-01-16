package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* loaded from: classes.dex */
public final class AlignmentPattern extends ResultPoint {
    private final float estimatedModuleSize;

    AlignmentPattern(float posX, float posY, float estimatedModuleSize) {
        super(posX, posY);
        this.estimatedModuleSize = estimatedModuleSize;
    }

    boolean aboutEquals(float moduleSize, float i, float j) {
        if (Math.abs(i - getY()) > moduleSize || Math.abs(j - getX()) > moduleSize) {
            return false;
        }
        float fAbs = Math.abs(moduleSize - this.estimatedModuleSize);
        return fAbs <= 1.0f || fAbs <= this.estimatedModuleSize;
    }

    AlignmentPattern combineEstimate(float i, float j, float newModuleSize) {
        return new AlignmentPattern((getX() + j) / 2.0f, (getY() + i) / 2.0f, (this.estimatedModuleSize + newModuleSize) / 2.0f);
    }
}
