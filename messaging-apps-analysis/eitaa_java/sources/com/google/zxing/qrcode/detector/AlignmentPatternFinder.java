package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class AlignmentPatternFinder {
    private final int height;
    private final BitMatrix image;
    private final float moduleSize;
    private final ResultPointCallback resultPointCallback;
    private final int startX;
    private final int startY;
    private final int width;
    private final List<AlignmentPattern> possibleCenters = new ArrayList(5);
    private final int[] crossCheckStateCount = new int[3];

    AlignmentPatternFinder(BitMatrix image, int startX, int startY, int width, int height, float moduleSize, ResultPointCallback resultPointCallback) {
        this.image = image;
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.moduleSize = moduleSize;
        this.resultPointCallback = resultPointCallback;
    }

    AlignmentPattern find() throws NotFoundException {
        AlignmentPattern alignmentPatternHandlePossibleCenter;
        AlignmentPattern alignmentPatternHandlePossibleCenter2;
        int i = this.startX;
        int i2 = this.height;
        int i3 = this.width + i;
        int i4 = this.startY + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2)) + i4;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.image.get(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            while (i7 < i3) {
                if (!this.image.get(i7, i6)) {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i8 == 2) {
                    if (foundPatternCross(iArr) && (alignmentPatternHandlePossibleCenter2 = handlePossibleCenter(iArr, i6, i7)) != null) {
                        return alignmentPatternHandlePossibleCenter2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i8 = 1;
                } else {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                }
                i7++;
            }
            if (foundPatternCross(iArr) && (alignmentPatternHandlePossibleCenter = handlePossibleCenter(iArr, i6, i3)) != null) {
                return alignmentPatternHandlePossibleCenter;
            }
        }
        if (!this.possibleCenters.isEmpty()) {
            return this.possibleCenters.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static float centerFromEnd(int[] stateCount, int end) {
        return (end - stateCount[2]) - (stateCount[1] / 2.0f);
    }

    private boolean foundPatternCross(int[] stateCount) {
        float f = this.moduleSize;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - stateCount[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    private float crossCheckVertical(int startI, int centerJ, int maxCount, int originalStateCountTotal) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i = startI;
        while (i >= 0 && bitMatrix.get(centerJ, i) && iArr[1] <= maxCount) {
            iArr[1] = iArr[1] + 1;
            i--;
        }
        if (i < 0 || iArr[1] > maxCount) {
            return Float.NaN;
        }
        while (i >= 0 && !bitMatrix.get(centerJ, i) && iArr[0] <= maxCount) {
            iArr[0] = iArr[0] + 1;
            i--;
        }
        if (iArr[0] > maxCount) {
            return Float.NaN;
        }
        int i2 = startI + 1;
        while (i2 < height && bitMatrix.get(centerJ, i2) && iArr[1] <= maxCount) {
            iArr[1] = iArr[1] + 1;
            i2++;
        }
        if (i2 == height || iArr[1] > maxCount) {
            return Float.NaN;
        }
        while (i2 < height && !bitMatrix.get(centerJ, i2) && iArr[2] <= maxCount) {
            iArr[2] = iArr[2] + 1;
            i2++;
        }
        if (iArr[2] <= maxCount && Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - originalStateCountTotal) * 5 < originalStateCountTotal * 2 && foundPatternCross(iArr)) {
            return centerFromEnd(iArr, i2);
        }
        return Float.NaN;
    }

    private AlignmentPattern handlePossibleCenter(int[] stateCount, int i, int j) {
        int i2 = stateCount[0] + stateCount[1] + stateCount[2];
        float fCenterFromEnd = centerFromEnd(stateCount, j);
        float fCrossCheckVertical = crossCheckVertical(i, (int) fCenterFromEnd, stateCount[1] * 2, i2);
        if (Float.isNaN(fCrossCheckVertical)) {
            return null;
        }
        float f = ((stateCount[0] + stateCount[1]) + stateCount[2]) / 3.0f;
        for (AlignmentPattern alignmentPattern : this.possibleCenters) {
            if (alignmentPattern.aboutEquals(f, fCrossCheckVertical, fCenterFromEnd)) {
                return alignmentPattern.combineEstimate(fCrossCheckVertical, fCenterFromEnd, f);
            }
        }
        AlignmentPattern alignmentPattern2 = new AlignmentPattern(fCenterFromEnd, fCrossCheckVertical, f);
        this.possibleCenters.add(alignmentPattern2);
        ResultPointCallback resultPointCallback = this.resultPointCallback;
        if (resultPointCallback == null) {
            return null;
        }
        resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
        return null;
    }
}
