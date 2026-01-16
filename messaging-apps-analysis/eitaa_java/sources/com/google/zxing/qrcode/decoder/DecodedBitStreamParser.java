package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9 A[LOOP:0: B:53:0x001e->B:49:0x00d9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.zxing.common.DecoderResult decode(byte[] r17, com.google.zxing.qrcode.decoder.Version r18, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r19, java.util.Map<com.google.zxing.DecodeHintType, ?> r20) throws com.google.zxing.FormatException {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.DecodedBitStreamParser.decode(byte[], com.google.zxing.qrcode.decoder.Version, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.common.DecoderResult");
    }

    /* renamed from: com.google.zxing.qrcode.decoder.DecodedBitStreamParser$1, reason: invalid class name */
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
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private static void decodeHanziSegment(BitSource bits, StringBuilder result, int count) throws FormatException {
        if (count * 13 > bits.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[count * 2];
        int i = 0;
        while (count > 0) {
            int bits2 = bits.readBits(13);
            int i2 = (bits2 % 96) | ((bits2 / 96) << 8);
            int i3 = i2 + (i2 < 2560 ? 41377 : 42657);
            bArr[i] = (byte) ((i3 >> 8) & 255);
            bArr[i + 1] = (byte) (i3 & 255);
            i += 2;
            count--;
        }
        try {
            result.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bits, StringBuilder result, int count) throws FormatException {
        if (count * 13 > bits.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[count * 2];
        int i = 0;
        while (count > 0) {
            int bits2 = bits.readBits(13);
            int i2 = (bits2 % 192) | ((bits2 / 192) << 8);
            int i3 = i2 + (i2 < 7936 ? 33088 : 49472);
            bArr[i] = (byte) (i3 >> 8);
            bArr[i + 1] = (byte) i3;
            i += 2;
            count--;
        }
        try {
            result.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeByteSegment(BitSource bits, StringBuilder result, int count, CharacterSetECI currentCharacterSetECI, Collection<byte[]> byteSegments, Map<DecodeHintType, ?> hints) throws FormatException {
        String strName;
        if (count * 8 > bits.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[count];
        for (int i = 0; i < count; i++) {
            bArr[i] = (byte) bits.readBits(8);
        }
        if (currentCharacterSetECI == null) {
            strName = StringUtils.guessEncoding(bArr, hints);
        } else {
            strName = currentCharacterSetECI.name();
        }
        try {
            result.append(new String(bArr, strName));
            byteSegments.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static char toAlphaNumericChar(int value) throws FormatException {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (value >= cArr.length) {
            throw FormatException.getFormatInstance();
        }
        return cArr[value];
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void decodeAlphanumericSegment(com.google.zxing.common.BitSource r3, java.lang.StringBuilder r4, int r5, boolean r6) throws com.google.zxing.FormatException {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.available()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.readBits(r2)
            int r2 = r1 / 45
            char r2 = toAlphaNumericChar(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = toAlphaNumericChar(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            com.google.zxing.FormatException r3 = com.google.zxing.FormatException.getFormatInstance()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.available()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.readBits(r2)
            char r3 = toAlphaNumericChar(r3)
            r4.append(r3)
            goto L47
        L42:
            com.google.zxing.FormatException r3 = com.google.zxing.FormatException.getFormatInstance()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.DecodedBitStreamParser.decodeAlphanumericSegment(com.google.zxing.common.BitSource, java.lang.StringBuilder, int, boolean):void");
    }

    private static void decodeNumericSegment(BitSource bits, StringBuilder result, int count) throws FormatException {
        while (count >= 3) {
            if (bits.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int bits2 = bits.readBits(10);
            if (bits2 >= 1000) {
                throw FormatException.getFormatInstance();
            }
            result.append(toAlphaNumericChar(bits2 / 100));
            result.append(toAlphaNumericChar((bits2 / 10) % 10));
            result.append(toAlphaNumericChar(bits2 % 10));
            count -= 3;
        }
        if (count == 2) {
            if (bits.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            int bits3 = bits.readBits(7);
            if (bits3 >= 100) {
                throw FormatException.getFormatInstance();
            }
            result.append(toAlphaNumericChar(bits3 / 10));
            result.append(toAlphaNumericChar(bits3 % 10));
            return;
        }
        if (count == 1) {
            if (bits.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            int bits4 = bits.readBits(4);
            if (bits4 >= 10) {
                throw FormatException.getFormatInstance();
            }
            result.append(toAlphaNumericChar(bits4));
        }
    }

    private static int parseECIValue(BitSource bits) throws FormatException {
        int bits2 = bits.readBits(8);
        if ((bits2 & 128) == 0) {
            return bits2 & 127;
        }
        if ((bits2 & 192) == 128) {
            return bits.readBits(8) | ((bits2 & 63) << 8);
        }
        if ((bits2 & 224) == 192) {
            return bits.readBits(16) | ((bits2 & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }
}
