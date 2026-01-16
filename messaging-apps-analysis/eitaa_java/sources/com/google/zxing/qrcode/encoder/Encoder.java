package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import ir.eitaa.tgnet.ConnectionsManager;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private static int calculateMaskPenalty(ByteMatrix matrix) {
        return MaskUtil.applyMaskPenaltyRule1(matrix) + MaskUtil.applyMaskPenaltyRule2(matrix) + MaskUtil.applyMaskPenaltyRule3(matrix) + MaskUtil.applyMaskPenaltyRule4(matrix);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.zxing.qrcode.encoder.QRCode encode(java.lang.String r7, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r8, java.util.Map<com.google.zxing.EncodeHintType, ?> r9) throws java.lang.NumberFormatException, com.google.zxing.WriterException, java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.encode(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.qrcode.encoder.QRCode");
    }

    private static Version recommendVersion(ErrorCorrectionLevel ecLevel, Mode mode, BitArray headerBits, BitArray dataBits) throws WriterException {
        return chooseVersion(calculateBitsNeeded(mode, headerBits, dataBits, chooseVersion(calculateBitsNeeded(mode, headerBits, dataBits, Version.getVersionForNumber(1)), ecLevel)), ecLevel);
    }

    private static int calculateBitsNeeded(Mode mode, BitArray headerBits, BitArray dataBits, Version version) {
        return headerBits.getSize() + mode.getCharacterCountBits(version) + dataBits.getSize();
    }

    static int getAlphanumericCode(int code) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (code < iArr.length) {
            return iArr[code];
        }
        return -1;
    }

    private static Mode chooseMode(String content, String encoding) {
        if ("Shift_JIS".equals(encoding) && isOnlyDoubleByteKanji(content)) {
            return Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < content.length(); i++) {
            char cCharAt = content.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (getAlphanumericCode(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return Mode.ALPHANUMERIC;
        }
        if (z2) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    private static boolean isOnlyDoubleByteKanji(String content) throws UnsupportedEncodingException {
        try {
            byte[] bytes = content.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int chooseMaskPattern(BitArray bits, ErrorCorrectionLevel ecLevel, Version version, ByteMatrix matrix) throws WriterException {
        int i = ConnectionsManager.DEFAULT_DATACENTER_ID;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            MatrixUtil.buildMatrix(bits, ecLevel, version, i3, matrix);
            int iCalculateMaskPenalty = calculateMaskPenalty(matrix);
            if (iCalculateMaskPenalty < i) {
                i2 = i3;
                i = iCalculateMaskPenalty;
            }
        }
        return i2;
    }

    private static Version chooseVersion(int numInputBits, ErrorCorrectionLevel ecLevel) throws WriterException {
        for (int i = 1; i <= 40; i++) {
            Version versionForNumber = Version.getVersionForNumber(i);
            if (willFit(numInputBits, versionForNumber, ecLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean willFit(int numInputBits, Version version, ErrorCorrectionLevel ecLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(ecLevel).getTotalECCodewords() >= (numInputBits + 7) / 8;
    }

    static void terminateBits(int numDataBytes, BitArray bits) throws WriterException {
        int i = numDataBytes * 8;
        if (bits.getSize() > i) {
            throw new WriterException("data bits cannot fit in the QR Code" + bits.getSize() + " > " + i);
        }
        for (int i2 = 0; i2 < 4 && bits.getSize() < i; i2++) {
            bits.appendBit(false);
        }
        int size = bits.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bits.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = numDataBytes - bits.getSizeInBytes();
        for (int i3 = 0; i3 < sizeInBytes; i3++) {
            bits.appendBits((i3 & 1) == 0 ? 236 : 17, 8);
        }
        if (bits.getSize() != i) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int numTotalBytes, int numDataBytes, int numRSBlocks, int blockID, int[] numDataBytesInBlock, int[] numECBytesInBlock) throws WriterException {
        if (blockID >= numRSBlocks) {
            throw new WriterException("Block ID too large");
        }
        int i = numTotalBytes % numRSBlocks;
        int i2 = numRSBlocks - i;
        int i3 = numTotalBytes / numRSBlocks;
        int i4 = i3 + 1;
        int i5 = numDataBytes / numRSBlocks;
        int i6 = i5 + 1;
        int i7 = i3 - i5;
        int i8 = i4 - i6;
        if (i7 != i8) {
            throw new WriterException("EC bytes mismatch");
        }
        if (numRSBlocks != i2 + i) {
            throw new WriterException("RS blocks mismatch");
        }
        if (numTotalBytes != ((i5 + i7) * i2) + ((i6 + i8) * i)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (blockID < i2) {
            numDataBytesInBlock[0] = i5;
            numECBytesInBlock[0] = i7;
        } else {
            numDataBytesInBlock[0] = i6;
            numECBytesInBlock[0] = i8;
        }
    }

    static BitArray interleaveWithECBytes(BitArray bits, int numTotalBytes, int numDataBytes, int numRSBlocks) throws WriterException {
        if (bits.getSizeInBytes() != numDataBytes) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(numRSBlocks);
        int i = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i2 = 0; i2 < numRSBlocks; i2++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(numTotalBytes, numDataBytes, numRSBlocks, i2, iArr, iArr2);
            int i3 = iArr[0];
            byte[] bArr = new byte[i3];
            bits.toBytes(i * 8, bArr, 0, i3);
            byte[] bArrGenerateECBytes = generateECBytes(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, bArrGenerateECBytes));
            iMax = Math.max(iMax, i3);
            iMax2 = Math.max(iMax2, bArrGenerateECBytes.length);
            i += iArr[0];
        }
        if (numDataBytes != i) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray = new BitArray();
        for (int i4 = 0; i4 < iMax; i4++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] dataBytes = ((BlockPair) it.next()).getDataBytes();
                if (i4 < dataBytes.length) {
                    bitArray.appendBits(dataBytes[i4], 8);
                }
            }
        }
        for (int i5 = 0; i5 < iMax2; i5++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] errorCorrectionBytes = ((BlockPair) it2.next()).getErrorCorrectionBytes();
                if (i5 < errorCorrectionBytes.length) {
                    bitArray.appendBits(errorCorrectionBytes[i5], 8);
                }
            }
        }
        if (numTotalBytes == bitArray.getSizeInBytes()) {
            return bitArray;
        }
        throw new WriterException("Interleaving error: " + numTotalBytes + " and " + bitArray.getSizeInBytes() + " differ.");
    }

    static byte[] generateECBytes(byte[] dataBytes, int numEcBytesInBlock) {
        int length = dataBytes.length;
        int[] iArr = new int[length + numEcBytesInBlock];
        for (int i = 0; i < length; i++) {
            iArr[i] = dataBytes[i] & 255;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, numEcBytesInBlock);
        byte[] bArr = new byte[numEcBytesInBlock];
        for (int i2 = 0; i2 < numEcBytesInBlock; i2++) {
            bArr[i2] = (byte) iArr[length + i2];
        }
        return bArr;
    }

    static void appendModeInfo(Mode mode, BitArray bits) {
        bits.appendBits(mode.getBits(), 4);
    }

    static void appendLengthInfo(int numLetters, Version version, Mode mode, BitArray bits) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i = 1 << characterCountBits;
        if (numLetters >= i) {
            throw new WriterException(numLetters + " is bigger than " + (i - 1));
        }
        bits.appendBits(numLetters, characterCountBits);
    }

    /* renamed from: com.google.zxing.qrcode.encoder.Encoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void appendBytes(String content, Mode mode, BitArray bits, String encoding) throws WriterException, UnsupportedEncodingException {
        int i = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode.ordinal()];
        if (i == 1) {
            appendNumericBytes(content, bits);
            return;
        }
        if (i == 2) {
            appendAlphanumericBytes(content, bits);
            return;
        }
        if (i == 3) {
            append8BitBytes(content, bits, encoding);
        } else {
            if (i == 4) {
                appendKanjiBytes(content, bits);
                return;
            }
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    static void appendNumericBytes(CharSequence content, BitArray bits) {
        int length = content.length();
        int i = 0;
        while (i < length) {
            int iCharAt = content.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                bits.appendBits((iCharAt * 100) + ((content.charAt(i + 1) - '0') * 10) + (content.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    bits.appendBits((iCharAt * 10) + (content.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    bits.appendBits(iCharAt, 4);
                }
            }
        }
    }

    static void appendAlphanumericBytes(CharSequence content, BitArray bits) throws WriterException {
        int length = content.length();
        int i = 0;
        while (i < length) {
            int alphanumericCode = getAlphanumericCode(content.charAt(i));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int alphanumericCode2 = getAlphanumericCode(content.charAt(i2));
                if (alphanumericCode2 == -1) {
                    throw new WriterException();
                }
                bits.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i += 2;
            } else {
                bits.appendBits(alphanumericCode, 6);
                i = i2;
            }
        }
    }

    static void append8BitBytes(String content, BitArray bits, String encoding) throws WriterException, UnsupportedEncodingException {
        try {
            for (byte b : content.getBytes(encoding)) {
                bits.appendBits(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    static void appendKanjiBytes(String content, BitArray bits) throws WriterException, UnsupportedEncodingException {
        int i;
        try {
            byte[] bytes = content.getBytes("Shift_JIS");
            if (bytes.length % 2 != 0) {
                throw new WriterException("Kanji byte size not even");
            }
            int length = bytes.length - 1;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                int i4 = 33088;
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - i4;
                } else if (i3 < 57408 || i3 > 60351) {
                    i = -1;
                } else {
                    i4 = 49472;
                    i = i3 - i4;
                }
                if (i == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bits.appendBits(((i >> 8) * 192) + (i & 255), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    private static void appendECI(CharacterSetECI eci, BitArray bits) {
        bits.appendBits(Mode.ECI.getBits(), 4);
        bits.appendBits(eci.getValue(), 8);
    }
}
