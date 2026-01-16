package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.ECIStringBuilder;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import ir.aaap.messengercore.db.DBHelper;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class DecodedBitStreamParser {
    private static final BigInteger[] EXP900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int i;
        ECIStringBuilder eCIStringBuilder = new ECIStringBuilder(iArr.length * 2);
        int iTextCompaction = textCompaction(iArr, 1, eCIStringBuilder);
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        while (iTextCompaction < iArr[0]) {
            int i2 = iTextCompaction + 1;
            int i3 = iArr[iTextCompaction];
            if (i3 != 913) {
                switch (i3) {
                    case DBHelper.GET_STICKER_LIMIT /* 900 */:
                        iTextCompaction = textCompaction(iArr, i2, eCIStringBuilder);
                        continue;
                    case 901:
                        break;
                    case 902:
                        iTextCompaction = numericCompaction(iArr, i2, eCIStringBuilder);
                        continue;
                    default:
                        switch (i3) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                i = i2 + 1;
                                iTextCompaction = i;
                                break;
                            case 926:
                                i = i2 + 2;
                                iTextCompaction = i;
                                break;
                            case 927:
                                iTextCompaction = i2 + 1;
                                eCIStringBuilder.appendECI(iArr[i2]);
                                break;
                            case 928:
                                iTextCompaction = decodeMacroBlock(iArr, i2, pDF417ResultMetadata);
                                break;
                            default:
                                iTextCompaction = textCompaction(iArr, i2 - 1, eCIStringBuilder);
                                break;
                        }
                }
                iTextCompaction = byteCompaction(i3, iArr, i2, eCIStringBuilder);
            } else {
                iTextCompaction = i2 + 1;
                eCIStringBuilder.append((char) iArr[i2]);
            }
        }
        if (eCIStringBuilder.isEmpty() && pDF417ResultMetadata.getFileId() == null) {
            throw FormatException.getFormatInstance();
        }
        DecoderResult decoderResult = new DecoderResult(null, eCIStringBuilder.toString(), null, str);
        decoderResult.setOther(pDF417ResultMetadata);
        return decoderResult;
    }

    static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        String strDecodeBase900toBase10 = decodeBase900toBase10(iArr2, 2);
        if (strDecodeBase900toBase10.isEmpty()) {
            pDF417ResultMetadata.setSegmentIndex(0);
        } else {
            try {
                pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(strDecodeBase900toBase10));
            } catch (NumberFormatException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (i < iArr[0] && i < iArr.length && iArr[i] != 922 && iArr[i] != 923) {
            sb.append(String.format("%03d", Integer.valueOf(iArr[i])));
            i++;
        }
        if (sb.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        pDF417ResultMetadata.setFileId(sb.toString());
        int i3 = iArr[i] == 923 ? i + 1 : -1;
        while (i < iArr[0]) {
            int i4 = iArr[i];
            if (i4 == 922) {
                i++;
                pDF417ResultMetadata.setLastSegment(true);
            } else if (i4 == 923) {
                int i5 = i + 1;
                switch (iArr[i5]) {
                    case 0:
                        ECIStringBuilder eCIStringBuilder = new ECIStringBuilder();
                        i = textCompaction(iArr, i5 + 1, eCIStringBuilder);
                        pDF417ResultMetadata.setFileName(eCIStringBuilder.toString());
                        break;
                    case 1:
                        ECIStringBuilder eCIStringBuilder2 = new ECIStringBuilder();
                        i = numericCompaction(iArr, i5 + 1, eCIStringBuilder2);
                        pDF417ResultMetadata.setSegmentCount(Integer.parseInt(eCIStringBuilder2.toString()));
                        break;
                    case 2:
                        ECIStringBuilder eCIStringBuilder3 = new ECIStringBuilder();
                        i = numericCompaction(iArr, i5 + 1, eCIStringBuilder3);
                        pDF417ResultMetadata.setTimestamp(Long.parseLong(eCIStringBuilder3.toString()));
                        break;
                    case 3:
                        ECIStringBuilder eCIStringBuilder4 = new ECIStringBuilder();
                        i = textCompaction(iArr, i5 + 1, eCIStringBuilder4);
                        pDF417ResultMetadata.setSender(eCIStringBuilder4.toString());
                        break;
                    case 4:
                        ECIStringBuilder eCIStringBuilder5 = new ECIStringBuilder();
                        i = textCompaction(iArr, i5 + 1, eCIStringBuilder5);
                        pDF417ResultMetadata.setAddressee(eCIStringBuilder5.toString());
                        break;
                    case 5:
                        ECIStringBuilder eCIStringBuilder6 = new ECIStringBuilder();
                        i = numericCompaction(iArr, i5 + 1, eCIStringBuilder6);
                        pDF417ResultMetadata.setFileSize(Long.parseLong(eCIStringBuilder6.toString()));
                        break;
                    case 6:
                        ECIStringBuilder eCIStringBuilder7 = new ECIStringBuilder();
                        i = numericCompaction(iArr, i5 + 1, eCIStringBuilder7);
                        pDF417ResultMetadata.setChecksum(Integer.parseInt(eCIStringBuilder7.toString()));
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i3 != -1) {
            int i6 = i - i3;
            if (pDF417ResultMetadata.isLastSegment()) {
                i6--;
            }
            pDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(iArr, i3, i6 + i3));
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int textCompaction(int[] r10, int r11, com.google.zxing.common.ECIStringBuilder r12) throws com.google.zxing.FormatException {
        /*
            r0 = 0
            r1 = r10[r0]
            int r1 = r1 - r11
            int r1 = r1 * 2
            int[] r1 = new int[r1]
            r2 = r10[r0]
            int r2 = r2 - r11
            int r2 = r2 * 2
            int[] r2 = new int[r2]
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r4 = 0
            r5 = 0
        L13:
            r6 = r10[r0]
            if (r11 >= r6) goto L77
            if (r4 != 0) goto L77
            int r6 = r11 + 1
            r11 = r10[r11]
            r7 = 900(0x384, float:1.261E-42)
            if (r11 >= r7) goto L2e
            int r7 = r11 / 30
            r1[r5] = r7
            int r7 = r5 + 1
            int r11 = r11 % 30
            r1[r7] = r11
            int r5 = r5 + 2
            goto L40
        L2e:
            r8 = 913(0x391, float:1.28E-42)
            if (r11 == r8) goto L6c
            r8 = 927(0x39f, float:1.299E-42)
            if (r11 == r8) goto L4c
            r8 = 928(0x3a0, float:1.3E-42)
            if (r11 == r8) goto L48
            switch(r11) {
                case 900: goto L42;
                case 901: goto L48;
                case 902: goto L48;
                default: goto L3d;
            }
        L3d:
            switch(r11) {
                case 922: goto L48;
                case 923: goto L48;
                case 924: goto L48;
                default: goto L40;
            }
        L40:
            r11 = r6
            goto L13
        L42:
            int r11 = r5 + 1
            r1[r5] = r7
            r5 = r11
            goto L40
        L48:
            int r6 = r6 + (-1)
            r4 = 1
            goto L40
        L4c:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r11 = decodeTextCompaction(r1, r2, r5, r12, r3)
            int r1 = r6 + 1
            r2 = r10[r6]
            r12.appendECI(r2)
            r2 = r10[r0]
            int r2 = r2 - r1
            int r2 = r2 * 2
            int[] r2 = new int[r2]
            r3 = r10[r0]
            int r3 = r3 - r1
            int r3 = r3 * 2
            int[] r3 = new int[r3]
            r5 = 0
            r9 = r3
            r3 = r11
            r11 = r1
            r1 = r2
            r2 = r9
            goto L13
        L6c:
            r1[r5] = r8
            int r11 = r6 + 1
            r6 = r10[r6]
            r2[r5] = r6
            int r5 = r5 + 1
            goto L13
        L77:
            decodeTextCompaction(r1, r2, r5, r12, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.textCompaction(int[], int, com.google.zxing.common.ECIStringBuilder):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0020. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode decodeTextCompaction(int[] r15, int[] r16, int r17, com.google.zxing.common.ECIStringBuilder r18, com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode r19) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, com.google.zxing.common.ECIStringBuilder, com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode):com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode");
    }

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static int byteCompaction(int i, int[] iArr, int i2, ECIStringBuilder eCIStringBuilder) throws FormatException {
        int i3;
        boolean z = false;
        while (i2 < iArr[0] && !z) {
            while (i2 < iArr[0] && iArr[i2] == 927) {
                int i4 = i2 + 1;
                eCIStringBuilder.appendECI(iArr[i4]);
                i2 = i4 + 1;
            }
            if (i2 >= iArr[0] || iArr[i2] >= 900) {
                z = true;
            } else {
                long j = 0;
                int i5 = 0;
                while (true) {
                    i3 = i2 + 1;
                    j = (j * 900) + iArr[i2];
                    i5++;
                    if (i5 >= 5 || i3 >= iArr[0] || iArr[i3] >= 900) {
                        break;
                    }
                    i2 = i3;
                }
                if (i5 != 5 || (i != 924 && (i3 >= iArr[0] || iArr[i3] >= 900))) {
                    i3 -= i5;
                    while (i3 < iArr[0] && !z) {
                        int i6 = i3 + 1;
                        int i7 = iArr[i3];
                        if (i7 < 900) {
                            eCIStringBuilder.append((byte) i7);
                            i3 = i6;
                        } else if (i7 == 927) {
                            eCIStringBuilder.appendECI(iArr[i6]);
                            i3 = i6 + 1;
                        } else {
                            i3 = i6 - 1;
                            z = true;
                        }
                    }
                } else {
                    for (int i8 = 0; i8 < 6; i8++) {
                        eCIStringBuilder.append((byte) (j >> ((5 - i8) * 8)));
                    }
                }
                i2 = i3;
            }
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int numericCompaction(int[] r7, int r8, com.google.zxing.common.ECIStringBuilder r9) throws com.google.zxing.FormatException {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = 0
            r3 = 0
        L7:
            r4 = r7[r1]
            if (r8 >= r4) goto L4b
            if (r2 != 0) goto L4b
            int r4 = r8 + 1
            r8 = r7[r8]
            r5 = r7[r1]
            r6 = 1
            if (r4 != r5) goto L17
            r2 = 1
        L17:
            r5 = 900(0x384, float:1.261E-42)
            if (r8 >= r5) goto L20
            r0[r3] = r8
            int r3 = r3 + 1
            goto L35
        L20:
            if (r8 == r5) goto L32
            r5 = 901(0x385, float:1.263E-42)
            if (r8 == r5) goto L32
            r5 = 927(0x39f, float:1.299E-42)
            if (r8 == r5) goto L32
            r5 = 928(0x3a0, float:1.3E-42)
            if (r8 == r5) goto L32
            switch(r8) {
                case 922: goto L32;
                case 923: goto L32;
                case 924: goto L32;
                default: goto L31;
            }
        L31:
            goto L35
        L32:
            int r4 = r4 + (-1)
            r2 = 1
        L35:
            int r5 = r3 % 15
            if (r5 == 0) goto L3f
            r5 = 902(0x386, float:1.264E-42)
            if (r8 == r5) goto L3f
            if (r2 == 0) goto L49
        L3f:
            if (r3 <= 0) goto L49
            java.lang.String r8 = decodeBase900toBase10(r0, r3)
            r9.append(r8)
            r3 = 0
        L49:
            r8 = r4
            goto L7
        L4b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.numericCompaction(int[], int, com.google.zxing.common.ECIStringBuilder):int");
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) != '1') {
            throw FormatException.getFormatInstance();
        }
        return string.substring(1);
    }
}
