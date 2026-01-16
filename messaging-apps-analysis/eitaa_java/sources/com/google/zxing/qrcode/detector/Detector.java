package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

/* loaded from: classes.dex */
public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix image) {
        this.image = image;
    }

    public final DetectorResult detect(Map<DecodeHintType, ?> hints) throws NotFoundException, FormatException {
        this.resultPointCallback = hints == null ? null : (ResultPointCallback) hints.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return processFinderPatternInfo(new FinderPatternFinder(this.image, this.resultPointCallback).find(hints));
    }

    protected final DetectorResult processFinderPatternInfo(FinderPatternInfo info) throws NotFoundException, FormatException {
        FinderPattern topLeft = info.getTopLeft();
        FinderPattern topRight = info.getTopRight();
        FinderPattern bottomLeft = info.getBottomLeft();
        float fCalculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (fCalculateModuleSize < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iComputeDimension = computeDimension(topLeft, topRight, bottomLeft, fCalculateModuleSize);
        Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(iComputeDimension);
        int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
        AlignmentPattern alignmentPatternFindAlignmentInRegion = null;
        if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
            float x = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
            float y = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
            float f = 1.0f - (3.0f / dimensionForVersion);
            int x2 = (int) (topLeft.getX() + ((x - topLeft.getX()) * f));
            int y2 = (int) (topLeft.getY() + (f * (y - topLeft.getY())));
            for (int i = 4; i <= 16; i <<= 1) {
                try {
                    alignmentPatternFindAlignmentInRegion = findAlignmentInRegion(fCalculateModuleSize, x2, y2, i);
                    break;
                } catch (NotFoundException unused) {
                }
            }
        }
        return new DetectorResult(sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPatternFindAlignmentInRegion, iComputeDimension), iComputeDimension), alignmentPatternFindAlignmentInRegion == null ? new ResultPoint[]{bottomLeft, topLeft, topRight} : new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPatternFindAlignmentInRegion});
    }

    private static PerspectiveTransform createTransform(ResultPoint topLeft, ResultPoint topRight, ResultPoint bottomLeft, ResultPoint alignmentPattern, int dimension) {
        float x;
        float y;
        float f;
        float f2 = dimension - 3.5f;
        if (alignmentPattern != null) {
            x = alignmentPattern.getX();
            y = alignmentPattern.getY();
            f = f2 - 3.0f;
        } else {
            x = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
            y = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
            f = f2;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f2, 3.5f, f, f, 3.5f, f2, topLeft.getX(), topLeft.getY(), topRight.getX(), topRight.getY(), x, y, bottomLeft.getX(), bottomLeft.getY());
    }

    private static BitMatrix sampleGrid(BitMatrix image, PerspectiveTransform transform, int dimension) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(image, dimension, dimension, transform);
    }

    private static int computeDimension(ResultPoint topLeft, ResultPoint topRight, ResultPoint bottomLeft, float moduleSize) throws NotFoundException {
        int iRound = ((MathUtils.round(ResultPoint.distance(topLeft, topRight) / moduleSize) + MathUtils.round(ResultPoint.distance(topLeft, bottomLeft) / moduleSize)) / 2) + 7;
        int i = iRound & 3;
        return i != 0 ? i != 2 ? i != 3 ? iRound : iRound + 2 : iRound - 1 : iRound + 1;
    }

    protected final float calculateModuleSize(ResultPoint topLeft, ResultPoint topRight, ResultPoint bottomLeft) {
        return (calculateModuleSizeOneWay(topLeft, topRight) + calculateModuleSizeOneWay(topLeft, bottomLeft)) / 2.0f;
    }

    private float calculateModuleSizeOneWay(ResultPoint pattern, ResultPoint otherPattern) {
        float fSizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) pattern.getX(), (int) pattern.getY(), (int) otherPattern.getX(), (int) otherPattern.getY());
        float fSizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) otherPattern.getX(), (int) otherPattern.getY(), (int) pattern.getX(), (int) pattern.getY());
        return Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays) ? fSizeOfBlackWhiteBlackRunBothWays2 / 7.0f : Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays2) ? fSizeOfBlackWhiteBlackRunBothWays / 7.0f : (fSizeOfBlackWhiteBlackRunBothWays + fSizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int fromX, int fromY, int toX, int toY) {
        float width;
        float height;
        float fSizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(fromX, fromY, toX, toY);
        int width2 = fromX - (toX - fromX);
        int height2 = 0;
        if (width2 < 0) {
            width = fromX / (fromX - width2);
            width2 = 0;
        } else if (width2 >= this.image.getWidth()) {
            width = ((this.image.getWidth() - 1) - fromX) / (width2 - fromX);
            width2 = this.image.getWidth() - 1;
        } else {
            width = 1.0f;
        }
        float f = fromY;
        int i = (int) (f - ((toY - fromY) * width));
        if (i < 0) {
            height = f / (fromY - i);
        } else if (i >= this.image.getHeight()) {
            height = ((this.image.getHeight() - 1) - fromY) / (i - fromY);
            height2 = this.image.getHeight() - 1;
        } else {
            height2 = i;
            height = 1.0f;
        }
        return (fSizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(fromX, fromY, (int) (fromX + ((width2 - fromX) * height)), height2)) - 1.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0085, code lost:
    
        if (r15 != 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        return com.google.zxing.common.detector.MathUtils.distance(r19, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float sizeOfBlackWhiteBlackRun(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r4 = r18
            r1 = r19
            r6 = r20
            r5 = r21
            goto L25
        L1d:
            r1 = r18
            r4 = r19
            r5 = r20
            r6 = r21
        L25:
            int r7 = r5 - r1
            int r7 = java.lang.Math.abs(r7)
            int r8 = r6 - r4
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r1 >= r5) goto L39
            r12 = 1
            goto L3a
        L39:
            r12 = -1
        L3a:
            if (r4 >= r6) goto L3d
            r11 = 1
        L3d:
            int r5 = r5 + r12
            r13 = r1
            r14 = r4
            r15 = 0
        L41:
            if (r13 == r5) goto L80
            if (r0 == 0) goto L47
            r2 = r14
            goto L48
        L47:
            r2 = r13
        L48:
            if (r0 == 0) goto L4c
            r10 = r13
            goto L4d
        L4c:
            r10 = r14
        L4d:
            if (r15 != r3) goto L57
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 1
            goto L5e
        L57:
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 0
        L5e:
            com.google.zxing.common.BitMatrix r5 = r3.image
            boolean r2 = r5.get(r2, r10)
            if (r0 != r2) goto L70
            r0 = 2
            if (r15 != r0) goto L6e
            float r0 = com.google.zxing.common.detector.MathUtils.distance(r13, r14, r1, r4)
            return r0
        L6e:
            int r15 = r15 + 1
        L70:
            int r9 = r9 + r8
            if (r9 <= 0) goto L78
            if (r14 != r6) goto L76
            goto L84
        L76:
            int r14 = r14 + r11
            int r9 = r9 - r7
        L78:
            int r13 = r13 + r12
            r5 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L41
        L80:
            r3 = r17
            r19 = r5
        L84:
            r0 = 2
            if (r15 != r0) goto L8e
            r5 = r19
            float r0 = com.google.zxing.common.detector.MathUtils.distance(r5, r6, r1, r4)
            return r0
        L8e:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.Detector.sizeOfBlackWhiteBlackRun(int, int, int, int):float");
    }

    protected final AlignmentPattern findAlignmentInRegion(float overallEstModuleSize, int estAlignmentX, int estAlignmentY, float allowanceFactor) throws NotFoundException {
        int i = (int) (allowanceFactor * overallEstModuleSize);
        int iMax = Math.max(0, estAlignmentX - i);
        int iMin = Math.min(this.image.getWidth() - 1, estAlignmentX + i) - iMax;
        float f = 3.0f * overallEstModuleSize;
        if (iMin < f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, estAlignmentY - i);
        int iMin2 = Math.min(this.image.getHeight() - 1, estAlignmentY + i) - iMax2;
        if (iMin2 < f) {
            throw NotFoundException.getNotFoundInstance();
        }
        return new AlignmentPatternFinder(this.image, iMax, iMax2, iMin, iMin2, overallEstModuleSize, this.resultPointCallback).find();
    }
}
