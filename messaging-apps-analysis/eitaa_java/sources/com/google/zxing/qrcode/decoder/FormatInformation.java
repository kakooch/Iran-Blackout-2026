package com.google.zxing.qrcode.decoder;

import ir.eitaa.tgnet.ConnectionsManager;

/* loaded from: classes.dex */
final class FormatInformation {
    private static final int[][] FORMAT_INFO_DECODE_LOOKUP = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};
    private final byte dataMask;
    private final ErrorCorrectionLevel errorCorrectionLevel;

    private FormatInformation(int formatInfo) {
        this.errorCorrectionLevel = ErrorCorrectionLevel.forBits((formatInfo >> 3) & 3);
        this.dataMask = (byte) (formatInfo & 7);
    }

    static int numBitsDiffering(int a, int b) {
        return Integer.bitCount(a ^ b);
    }

    static FormatInformation decodeFormatInformation(int maskedFormatInfo1, int maskedFormatInfo2) {
        FormatInformation formatInformationDoDecodeFormatInformation = doDecodeFormatInformation(maskedFormatInfo1, maskedFormatInfo2);
        return formatInformationDoDecodeFormatInformation != null ? formatInformationDoDecodeFormatInformation : doDecodeFormatInformation(maskedFormatInfo1 ^ 21522, maskedFormatInfo2 ^ 21522);
    }

    private static FormatInformation doDecodeFormatInformation(int maskedFormatInfo1, int maskedFormatInfo2) {
        int iNumBitsDiffering;
        int[][] iArr = FORMAT_INFO_DECODE_LOOKUP;
        int i = ConnectionsManager.DEFAULT_DATACENTER_ID;
        int i2 = 0;
        for (int[] iArr2 : iArr) {
            int i3 = iArr2[0];
            if (i3 == maskedFormatInfo1 || i3 == maskedFormatInfo2) {
                return new FormatInformation(iArr2[1]);
            }
            int iNumBitsDiffering2 = numBitsDiffering(maskedFormatInfo1, i3);
            if (iNumBitsDiffering2 < i) {
                i2 = iArr2[1];
                i = iNumBitsDiffering2;
            }
            if (maskedFormatInfo1 != maskedFormatInfo2 && (iNumBitsDiffering = numBitsDiffering(maskedFormatInfo2, i3)) < i) {
                i2 = iArr2[1];
                i = iNumBitsDiffering;
            }
        }
        if (i <= 3) {
            return new FormatInformation(i2);
        }
        return null;
    }

    ErrorCorrectionLevel getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    byte getDataMask() {
        return this.dataMask;
    }

    public int hashCode() {
        return (this.errorCorrectionLevel.ordinal() << 3) | this.dataMask;
    }

    public boolean equals(Object o) {
        if (!(o instanceof FormatInformation)) {
            return false;
        }
        FormatInformation formatInformation = (FormatInformation) o;
        return this.errorCorrectionLevel == formatInformation.errorCorrectionLevel && this.dataMask == formatInformation.dataMask;
    }
}
