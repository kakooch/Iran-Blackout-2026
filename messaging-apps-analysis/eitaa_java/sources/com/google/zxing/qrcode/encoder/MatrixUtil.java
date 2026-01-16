package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.R;

/* loaded from: classes.dex */
final class MatrixUtil {
    private static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, -1, -1}, new int[]{6, 28, 54, 80, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, -1, -1}, new int[]{6, 32, 58, 84, R.styleable.AppCompatTheme_viewInflaterClass, -1, -1}, new int[]{6, 30, 58, 86, R.styleable.AppCompatTheme_windowFixedHeightMajor, -1, -1}, new int[]{6, 34, 62, 90, R.styleable.AppCompatTheme_windowMinWidthMajor, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, 126, -1}, new int[]{6, 26, 52, 78, R.styleable.AppCompatTheme_textColorAlertDialogListItem, 130, -1}, new int[]{6, 30, 56, 82, R.styleable.AppCompatTheme_tooltipForegroundColor, 134, -1}, new int[]{6, 34, 60, 86, R.styleable.AppCompatTheme_windowActionBarOverlay, 138, -1}, new int[]{6, 30, 58, 86, R.styleable.AppCompatTheme_windowFixedHeightMajor, 142, -1}, new int[]{6, 34, 62, 90, R.styleable.AppCompatTheme_windowMinWidthMajor, 146, -1}, new int[]{6, 30, 54, 78, R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, 126, ImageReceiver.DEFAULT_CROSSFADE_DURATION}, new int[]{6, 24, 50, 76, R.styleable.AppCompatTheme_textAppearanceSearchResultTitle, 128, 154}, new int[]{6, 28, 54, 80, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle, 132, 158}, new int[]{6, 32, 58, 84, R.styleable.AppCompatTheme_viewInflaterClass, 136, 162}, new int[]{6, 26, 54, 82, R.styleable.AppCompatTheme_viewInflaterClass, 138, 166}, new int[]{6, 30, 58, 86, R.styleable.AppCompatTheme_windowFixedHeightMajor, 142, 170}};
    private static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private static boolean isEmpty(int value) {
        return value == -1;
    }

    static void clearMatrix(ByteMatrix matrix) {
        matrix.clear((byte) -1);
    }

    static void buildMatrix(BitArray dataBits, ErrorCorrectionLevel ecLevel, Version version, int maskPattern, ByteMatrix matrix) throws WriterException {
        clearMatrix(matrix);
        embedBasicPatterns(version, matrix);
        embedTypeInfo(ecLevel, maskPattern, matrix);
        maybeEmbedVersionInfo(version, matrix);
        embedDataBits(dataBits, maskPattern, matrix);
    }

    static void embedBasicPatterns(Version version, ByteMatrix matrix) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(matrix);
        embedDarkDotAtLeftBottomCorner(matrix);
        maybeEmbedPositionAdjustmentPatterns(version, matrix);
        embedTimingPatterns(matrix);
    }

    static void embedTypeInfo(ErrorCorrectionLevel ecLevel, int maskPattern, ByteMatrix matrix) throws WriterException {
        BitArray bitArray = new BitArray();
        makeTypeInfoBits(ecLevel, maskPattern, bitArray);
        for (int i = 0; i < bitArray.getSize(); i++) {
            boolean z = bitArray.get((bitArray.getSize() - 1) - i);
            int[] iArr = TYPE_INFO_COORDINATES[i];
            matrix.set(iArr[0], iArr[1], z);
            if (i < 8) {
                matrix.set((matrix.getWidth() - i) - 1, 8, z);
            } else {
                matrix.set(8, (matrix.getHeight() - 7) + (i - 8), z);
            }
        }
    }

    static void maybeEmbedVersionInfo(Version version, ByteMatrix matrix) throws WriterException {
        if (version.getVersionNumber() < 7) {
            return;
        }
        BitArray bitArray = new BitArray();
        makeVersionInfoBits(version, bitArray);
        int i = 17;
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                boolean z = bitArray.get(i);
                i--;
                matrix.set(i2, (matrix.getHeight() - 11) + i3, z);
                matrix.set((matrix.getHeight() - 11) + i3, i2, z);
            }
        }
    }

    static void embedDataBits(BitArray dataBits, int maskPattern, ByteMatrix matrix) throws WriterException {
        boolean z;
        int width = matrix.getWidth() - 1;
        int height = matrix.getHeight() - 1;
        int i = 0;
        int i2 = -1;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < matrix.getHeight()) {
                for (int i3 = 0; i3 < 2; i3++) {
                    int i4 = width - i3;
                    if (isEmpty(matrix.get(i4, height))) {
                        if (i < dataBits.getSize()) {
                            z = dataBits.get(i);
                            i++;
                        } else {
                            z = false;
                        }
                        if (maskPattern != -1 && MaskUtil.getDataMaskBit(maskPattern, i4, height)) {
                            z = !z;
                        }
                        matrix.set(i4, height, z);
                    }
                }
                height += i2;
            }
            i2 = -i2;
            height += i2;
            width -= 2;
        }
        if (i == dataBits.getSize()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i + '/' + dataBits.getSize());
    }

    static int findMSBSet(int value) {
        return 32 - Integer.numberOfLeadingZeros(value);
    }

    static int calculateBCHCode(int value, int poly) {
        if (poly == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iFindMSBSet = findMSBSet(poly);
        int iFindMSBSet2 = value << (iFindMSBSet - 1);
        while (findMSBSet(iFindMSBSet2) >= iFindMSBSet) {
            iFindMSBSet2 ^= poly << (findMSBSet(iFindMSBSet2) - iFindMSBSet);
        }
        return iFindMSBSet2;
    }

    static void makeTypeInfoBits(ErrorCorrectionLevel ecLevel, int maskPattern, BitArray bits) throws WriterException {
        if (!QRCode.isValidMaskPattern(maskPattern)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits2 = (ecLevel.getBits() << 3) | maskPattern;
        bits.appendBits(bits2, 5);
        bits.appendBits(calculateBCHCode(bits2, 1335), 10);
        BitArray bitArray = new BitArray();
        bitArray.appendBits(21522, 15);
        bits.xor(bitArray);
        if (bits.getSize() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bits.getSize());
    }

    static void makeVersionInfoBits(Version version, BitArray bits) throws WriterException {
        bits.appendBits(version.getVersionNumber(), 6);
        bits.appendBits(calculateBCHCode(version.getVersionNumber(), 7973), 12);
        if (bits.getSize() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bits.getSize());
    }

    private static void embedTimingPatterns(ByteMatrix matrix) {
        int i = 8;
        while (i < matrix.getWidth() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (isEmpty(matrix.get(i, 6))) {
                matrix.set(i, 6, i3);
            }
            if (isEmpty(matrix.get(6, i))) {
                matrix.set(6, i, i3);
            }
            i = i2;
        }
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix matrix) throws WriterException {
        if (matrix.get(8, matrix.getHeight() - 8) == 0) {
            throw new WriterException();
        }
        matrix.set(8, matrix.getHeight() - 8, 1);
    }

    private static void embedHorizontalSeparationPattern(int xStart, int yStart, ByteMatrix matrix) throws WriterException {
        for (int i = 0; i < 8; i++) {
            int i2 = xStart + i;
            if (!isEmpty(matrix.get(i2, yStart))) {
                throw new WriterException();
            }
            matrix.set(i2, yStart, 0);
        }
    }

    private static void embedVerticalSeparationPattern(int xStart, int yStart, ByteMatrix matrix) throws WriterException {
        for (int i = 0; i < 7; i++) {
            int i2 = yStart + i;
            if (!isEmpty(matrix.get(xStart, i2))) {
                throw new WriterException();
            }
            matrix.set(xStart, i2, 0);
        }
    }

    private static void embedPositionAdjustmentPattern(int xStart, int yStart, ByteMatrix matrix) {
        for (int i = 0; i < 5; i++) {
            int[] iArr = POSITION_ADJUSTMENT_PATTERN[i];
            for (int i2 = 0; i2 < 5; i2++) {
                matrix.set(xStart + i2, yStart + i, iArr[i2]);
            }
        }
    }

    private static void embedPositionDetectionPattern(int xStart, int yStart, ByteMatrix matrix) {
        for (int i = 0; i < 7; i++) {
            int[] iArr = POSITION_DETECTION_PATTERN[i];
            for (int i2 = 0; i2 < 7; i2++) {
                matrix.set(xStart + i2, yStart + i, iArr[i2]);
            }
        }
    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix matrix) throws WriterException {
        int length = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, matrix);
        embedPositionDetectionPattern(matrix.getWidth() - length, 0, matrix);
        embedPositionDetectionPattern(0, matrix.getWidth() - length, matrix);
        embedHorizontalSeparationPattern(0, 7, matrix);
        embedHorizontalSeparationPattern(matrix.getWidth() - 8, 7, matrix);
        embedHorizontalSeparationPattern(0, matrix.getWidth() - 8, matrix);
        embedVerticalSeparationPattern(7, 0, matrix);
        embedVerticalSeparationPattern((matrix.getHeight() - 7) - 1, 0, matrix);
        embedVerticalSeparationPattern(7, matrix.getHeight() - 7, matrix);
    }

    private static void maybeEmbedPositionAdjustmentPatterns(Version version, ByteMatrix matrix) {
        if (version.getVersionNumber() < 2) {
            return;
        }
        int[] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[version.getVersionNumber() - 1];
        for (int i : iArr) {
            if (i >= 0) {
                for (int i2 : iArr) {
                    if (i2 >= 0 && isEmpty(matrix.get(i2, i))) {
                        embedPositionAdjustmentPattern(i2 - 2, i - 2, matrix);
                    }
                }
            }
        }
    }
}
