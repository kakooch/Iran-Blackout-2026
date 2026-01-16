package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class FinderPatternFinder {
    private static final EstimatedModuleComparator moduleComparator = new EstimatedModuleComparator();
    private boolean hasSkipped;
    private final BitMatrix image;
    private final ResultPointCallback resultPointCallback;
    private final List<FinderPattern> possibleCenters = new ArrayList();
    private final int[] crossCheckStateCount = new int[5];

    public FinderPatternFinder(BitMatrix image, ResultPointCallback resultPointCallback) {
        this.image = image;
        this.resultPointCallback = resultPointCallback;
    }

    final FinderPatternInfo find(Map<DecodeHintType, ?> hints) throws NotFoundException {
        boolean z = hints != null && hints.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = (height * 3) / 388;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        boolean zHaveMultiplyConfirmedCenters = false;
        while (i2 < height && !zHaveMultiplyConfirmedCenters) {
            clearCounts(iArr);
            int i3 = 0;
            int i4 = 0;
            while (i3 < width) {
                if (this.image.get(i3, i2)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 == 4) {
                    if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i3)) {
                        if (this.hasSkipped) {
                            zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                        } else {
                            int iFindRowSkip = findRowSkip();
                            if (iFindRowSkip > iArr[2]) {
                                i2 += (iFindRowSkip - iArr[2]) - 2;
                                i3 = width - 1;
                            }
                        }
                        clearCounts(iArr);
                        i = 2;
                        i4 = 0;
                    } else {
                        shiftCounts2(iArr);
                        i4 = 3;
                    }
                } else {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                }
                i3++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, width)) {
                i = iArr[0];
                if (this.hasSkipped) {
                    zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                }
            }
            i2 += i;
        }
        FinderPattern[] finderPatternArrSelectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(finderPatternArrSelectBestPatterns);
        return new FinderPatternInfo(finderPatternArrSelectBestPatterns);
    }

    private static float centerFromEnd(int[] stateCount, int end) {
        return ((end - stateCount[4]) - stateCount[3]) - (stateCount[2] / 2.0f);
    }

    protected static boolean foundPatternCross(int[] stateCount) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = stateCount[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) stateCount[0])) < f2 && Math.abs(f - ((float) stateCount[1])) < f2 && Math.abs((f * 3.0f) - ((float) stateCount[2])) < 3.0f * f2 && Math.abs(f - ((float) stateCount[3])) < f2 && Math.abs(f - ((float) stateCount[4])) < f2;
    }

    protected static boolean foundPatternDiagonal(int[] stateCount) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = stateCount[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 1.333f;
        return Math.abs(f - ((float) stateCount[0])) < f2 && Math.abs(f - ((float) stateCount[1])) < f2 && Math.abs((f * 3.0f) - ((float) stateCount[2])) < 3.0f * f2 && Math.abs(f - ((float) stateCount[3])) < f2 && Math.abs(f - ((float) stateCount[4])) < f2;
    }

    private int[] getCrossCheckStateCount() {
        clearCounts(this.crossCheckStateCount);
        return this.crossCheckStateCount;
    }

    protected final void clearCounts(int[] counts) {
        Arrays.fill(counts, 0);
    }

    protected final void shiftCounts2(int[] stateCount) {
        stateCount[0] = stateCount[2];
        stateCount[1] = stateCount[3];
        stateCount[2] = stateCount[4];
        stateCount[3] = 1;
        stateCount[4] = 0;
    }

    private boolean crossCheckDiagonal(int centerI, int centerJ) {
        int i;
        int i2;
        int i3;
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i4 = 0;
        while (centerI >= i4 && centerJ >= i4 && this.image.get(centerJ - i4, centerI - i4)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i4++;
        }
        if (crossCheckStateCount[2] == 0) {
            return false;
        }
        while (centerI >= i4 && centerJ >= i4 && !this.image.get(centerJ - i4, centerI - i4)) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i4++;
        }
        if (crossCheckStateCount[1] == 0) {
            return false;
        }
        while (centerI >= i4 && centerJ >= i4 && this.image.get(centerJ - i4, centerI - i4)) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i4++;
        }
        if (crossCheckStateCount[0] == 0) {
            return false;
        }
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i5 = 1;
        while (true) {
            int i6 = centerI + i5;
            if (i6 >= height || (i3 = centerJ + i5) >= width || !this.image.get(i3, i6)) {
                break;
            }
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5++;
        }
        while (true) {
            int i7 = centerI + i5;
            if (i7 >= height || (i2 = centerJ + i5) >= width || this.image.get(i2, i7)) {
                break;
            }
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i5++;
        }
        if (crossCheckStateCount[3] == 0) {
            return false;
        }
        while (true) {
            int i8 = centerI + i5;
            if (i8 >= height || (i = centerJ + i5) >= width || !this.image.get(i, i8)) {
                break;
            }
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i5++;
        }
        if (crossCheckStateCount[4] == 0) {
            return false;
        }
        return foundPatternDiagonal(crossCheckStateCount);
    }

    private float crossCheckVertical(int startI, int centerJ, int maxCount, int originalStateCountTotal) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i = startI;
        while (i >= 0 && bitMatrix.get(centerJ, i)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i--;
        }
        if (i < 0) {
            return Float.NaN;
        }
        while (i >= 0 && !bitMatrix.get(centerJ, i) && crossCheckStateCount[1] <= maxCount) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i--;
        }
        if (i < 0 || crossCheckStateCount[1] > maxCount) {
            return Float.NaN;
        }
        while (i >= 0 && bitMatrix.get(centerJ, i) && crossCheckStateCount[0] <= maxCount) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i--;
        }
        if (crossCheckStateCount[0] > maxCount) {
            return Float.NaN;
        }
        int i2 = startI + 1;
        while (i2 < height && bitMatrix.get(centerJ, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i2++;
        }
        if (i2 == height) {
            return Float.NaN;
        }
        while (i2 < height && !bitMatrix.get(centerJ, i2) && crossCheckStateCount[3] < maxCount) {
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i2++;
        }
        if (i2 == height || crossCheckStateCount[3] >= maxCount) {
            return Float.NaN;
        }
        while (i2 < height && bitMatrix.get(centerJ, i2) && crossCheckStateCount[4] < maxCount) {
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i2++;
        }
        if (crossCheckStateCount[4] < maxCount && Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - originalStateCountTotal) * 5 < originalStateCountTotal * 2 && foundPatternCross(crossCheckStateCount)) {
            return centerFromEnd(crossCheckStateCount, i2);
        }
        return Float.NaN;
    }

    private float crossCheckHorizontal(int startJ, int centerI, int maxCount, int originalStateCountTotal) {
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i = startJ;
        while (i >= 0 && bitMatrix.get(i, centerI)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i--;
        }
        if (i < 0) {
            return Float.NaN;
        }
        while (i >= 0 && !bitMatrix.get(i, centerI) && crossCheckStateCount[1] <= maxCount) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i--;
        }
        if (i < 0 || crossCheckStateCount[1] > maxCount) {
            return Float.NaN;
        }
        while (i >= 0 && bitMatrix.get(i, centerI) && crossCheckStateCount[0] <= maxCount) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i--;
        }
        if (crossCheckStateCount[0] > maxCount) {
            return Float.NaN;
        }
        int i2 = startJ + 1;
        while (i2 < width && bitMatrix.get(i2, centerI)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i2++;
        }
        if (i2 == width) {
            return Float.NaN;
        }
        while (i2 < width && !bitMatrix.get(i2, centerI) && crossCheckStateCount[3] < maxCount) {
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i2++;
        }
        if (i2 == width || crossCheckStateCount[3] >= maxCount) {
            return Float.NaN;
        }
        while (i2 < width && bitMatrix.get(i2, centerI) && crossCheckStateCount[4] < maxCount) {
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i2++;
        }
        if (crossCheckStateCount[4] < maxCount && Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - originalStateCountTotal) * 5 < originalStateCountTotal && foundPatternCross(crossCheckStateCount)) {
            return centerFromEnd(crossCheckStateCount, i2);
        }
        return Float.NaN;
    }

    protected final boolean handlePossibleCenter(int[] stateCount, int i, int j) {
        boolean z = false;
        int i2 = stateCount[0] + stateCount[1] + stateCount[2] + stateCount[3] + stateCount[4];
        int iCenterFromEnd = (int) centerFromEnd(stateCount, j);
        float fCrossCheckVertical = crossCheckVertical(i, iCenterFromEnd, stateCount[2], i2);
        if (!Float.isNaN(fCrossCheckVertical)) {
            int i3 = (int) fCrossCheckVertical;
            float fCrossCheckHorizontal = crossCheckHorizontal(iCenterFromEnd, i3, stateCount[2], i2);
            if (!Float.isNaN(fCrossCheckHorizontal) && crossCheckDiagonal(i3, (int) fCrossCheckHorizontal)) {
                float f = i2 / 7.0f;
                int i4 = 0;
                while (true) {
                    if (i4 >= this.possibleCenters.size()) {
                        break;
                    }
                    FinderPattern finderPattern = this.possibleCenters.get(i4);
                    if (finderPattern.aboutEquals(f, fCrossCheckVertical, fCrossCheckHorizontal)) {
                        this.possibleCenters.set(i4, finderPattern.combineEstimate(fCrossCheckVertical, fCrossCheckHorizontal, f));
                        z = true;
                        break;
                    }
                    i4++;
                }
                if (!z) {
                    FinderPattern finderPattern2 = new FinderPattern(fCrossCheckHorizontal, fCrossCheckVertical, f);
                    this.possibleCenters.add(finderPattern2);
                    ResultPointCallback resultPointCallback = this.resultPointCallback;
                    if (resultPointCallback != null) {
                        resultPointCallback.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float fAbs = 0.0f;
        int i = 0;
        float estimatedModuleSize = 0.0f;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i++;
                estimatedModuleSize += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f = estimatedModuleSize / size;
        Iterator<FinderPattern> it = this.possibleCenters.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().getEstimatedModuleSize() - f);
        }
        return fAbs <= estimatedModuleSize * 0.05f;
    }

    private static double squaredDistance(FinderPattern a, FinderPattern b) {
        double x = a.getX() - b.getX();
        double y = a.getY() - b.getY();
        Double.isNaN(x);
        Double.isNaN(x);
        Double.isNaN(y);
        Double.isNaN(y);
        return (x * x) + (y * y);
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        if (this.possibleCenters.size() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        Collections.sort(this.possibleCenters, moduleComparator);
        double[] dArr = new double[3];
        FinderPattern[] finderPatternArr = new FinderPattern[3];
        int i = 0;
        double d = Double.MAX_VALUE;
        while (i < this.possibleCenters.size() - 2) {
            FinderPattern finderPattern = this.possibleCenters.get(i);
            float estimatedModuleSize = finderPattern.getEstimatedModuleSize();
            i++;
            int i2 = i;
            while (i2 < this.possibleCenters.size() - 1) {
                FinderPattern finderPattern2 = this.possibleCenters.get(i2);
                double dSquaredDistance = squaredDistance(finderPattern, finderPattern2);
                i2++;
                for (int i3 = i2; i3 < this.possibleCenters.size(); i3++) {
                    FinderPattern finderPattern3 = this.possibleCenters.get(i3);
                    if (finderPattern3.getEstimatedModuleSize() <= 1.4f * estimatedModuleSize) {
                        dArr[0] = dSquaredDistance;
                        dArr[1] = squaredDistance(finderPattern2, finderPattern3);
                        dArr[2] = squaredDistance(finderPattern, finderPattern3);
                        Arrays.sort(dArr);
                        double dAbs = Math.abs(dArr[2] - (dArr[1] * 2.0d)) + Math.abs(dArr[2] - (dArr[0] * 2.0d));
                        if (dAbs < d) {
                            finderPatternArr[0] = finderPattern;
                            finderPatternArr[1] = finderPattern2;
                            finderPatternArr[2] = finderPattern3;
                            d = dAbs;
                        }
                    }
                }
            }
        }
        if (d != Double.MAX_VALUE) {
            return finderPatternArr;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static final class EstimatedModuleComparator implements Comparator<FinderPattern>, Serializable, j$.util.Comparator {
        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return a.E(this, Comparator.CC.comparing(function));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        private EstimatedModuleComparator() {
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(FinderPattern center1, FinderPattern center2) {
            return Float.compare(center1.getEstimatedModuleSize(), center2.getEstimatedModuleSize());
        }
    }
}
