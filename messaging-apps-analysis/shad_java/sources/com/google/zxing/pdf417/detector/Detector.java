package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Detector {
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    private static final int[] ROTATIONS = {0, 180, 270, 90};

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        for (int i : ROTATIONS) {
            BitMatrix bitMatrixApplyRotation = applyRotation(blackMatrix, i);
            List<ResultPoint[]> listDetect = detect(z, bitMatrixApplyRotation);
            if (!listDetect.isEmpty()) {
                return new PDF417DetectorResult(bitMatrixApplyRotation, listDetect, i);
            }
        }
        return new PDF417DetectorResult(blackMatrix, new ArrayList(), 0);
    }

    private static BitMatrix applyRotation(BitMatrix bitMatrix, int i) {
        if (i % 360 == 0) {
            return bitMatrix;
        }
        BitMatrix bitMatrixM273clone = bitMatrix.m273clone();
        bitMatrixM273clone.rotate(i);
        return bitMatrixM273clone;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r4.hasNext() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        r5 = (com.google.zxing.ResultPoint[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r5[1] == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].getY());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        if (r5[3] == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].getY());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.google.zxing.ResultPoint[]> detect(boolean r8, com.google.zxing.common.BitMatrix r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            r4 = 0
            r5 = 0
        La:
            int r6 = r9.getHeight()
            if (r3 >= r6) goto L7e
            com.google.zxing.ResultPoint[] r4 = findVertices(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L53
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L53
            if (r5 != 0) goto L20
            goto L7e
        L20:
            java.util.Iterator r4 = r0.iterator()
        L24:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L50
            java.lang.Object r5 = r4.next()
            com.google.zxing.ResultPoint[] r5 = (com.google.zxing.ResultPoint[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L40
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.getY()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L40:
            r7 = r5[r6]
            if (r7 == 0) goto L24
            r5 = r5[r6]
            float r5 = r5.getY()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L24
        L50:
            int r3 = r3 + 5
            goto L8
        L53:
            r0.add(r4)
            if (r8 != 0) goto L59
            goto L7e
        L59:
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6c
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
            goto L7a
        L6c:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.getX()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.getY()
        L7a:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto La
        L7e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.detector.Detector.detect(boolean, com.google.zxing.common.BitMatrix):java.util.List");
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i, int i2) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, START_PATTERN), INDEXES_START_PATTERN);
        if (resultPointArr[4] != null) {
            i2 = (int) resultPointArr[4].getX();
            i = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            resultPointArr[iArr[i]] = resultPointArr2[i];
        }
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        int i6;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr2 = new int[iArr.length];
        int i7 = i3;
        while (true) {
            if (i7 >= i) {
                z = false;
                break;
            }
            int[] iArrFindGuardPattern = findGuardPattern(bitMatrix, i4, i7, i2, iArr, iArr2);
            if (iArrFindGuardPattern != null) {
                int i8 = i7;
                int[] iArr3 = iArrFindGuardPattern;
                int i9 = i8;
                while (true) {
                    if (i9 <= 0) {
                        i6 = i9;
                        break;
                    }
                    int i10 = i9 - 1;
                    int[] iArrFindGuardPattern2 = findGuardPattern(bitMatrix, i4, i10, i2, iArr, iArr2);
                    if (iArrFindGuardPattern2 == null) {
                        i6 = i10 + 1;
                        break;
                    }
                    iArr3 = iArrFindGuardPattern2;
                    i9 = i10;
                }
                float f = i6;
                resultPointArr[0] = new ResultPoint(iArr3[0], f);
                resultPointArr[1] = new ResultPoint(iArr3[1], f);
                i7 = i6;
                z = true;
            } else {
                i7 += 5;
            }
        }
        int i11 = i7 + 1;
        if (z) {
            int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i12 = i11;
            int i13 = 0;
            while (true) {
                if (i12 >= i) {
                    i5 = i13;
                    break;
                }
                i5 = i13;
                int[] iArrFindGuardPattern3 = findGuardPattern(bitMatrix, iArr4[0], i12, i2, iArr, iArr2);
                if (iArrFindGuardPattern3 != null && Math.abs(iArr4[0] - iArrFindGuardPattern3[0]) < 5 && Math.abs(iArr4[1] - iArrFindGuardPattern3[1]) < 5) {
                    iArr4 = iArrFindGuardPattern3;
                    i13 = 0;
                } else {
                    if (i5 > 25) {
                        break;
                    }
                    i13 = i5 + 1;
                }
                i12++;
            }
            i11 = i12 - (i5 + 1);
            float f2 = i11;
            resultPointArr[2] = new ResultPoint(iArr4[0], f2);
            resultPointArr[3] = new ResultPoint(iArr4[1], f2);
        }
        if (i11 - i7 < 10) {
            Arrays.fill(resultPointArr, (Object) null);
        }
        return resultPointArr;
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i, int i2, int i3, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bitMatrix.get(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i;
        int i7 = 0;
        boolean z = false;
        while (i < i3) {
            if (bitMatrix.get(i, i2) != z) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                if (i7 != length - 1) {
                    i7++;
                } else {
                    if (patternMatchVariance(iArr2, iArr) < 0.42f) {
                        return new int[]{i6, i};
                    }
                    i6 += iArr2[0] + iArr2[1];
                    int i8 = i7 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i7] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z = !z;
            }
            i++;
        }
        if (i7 != length - 1 || patternMatchVariance(iArr2, iArr) >= 0.42f) {
            return null;
        }
        return new int[]{i6, i - 1};
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f = i;
        float f2 = f / i2;
        float f3 = 0.8f * f2;
        float f4 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f5 = iArr2[i4] * f2;
            float f6 = iArr[i4];
            float f7 = f6 > f5 ? f6 - f5 : f5 - f6;
            if (f7 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f7;
        }
        return f4 / f;
    }
}
