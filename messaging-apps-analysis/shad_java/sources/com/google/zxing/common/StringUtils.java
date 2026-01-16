package com.google.zxing.common;

import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final Charset EUC_JP;
    public static final Charset GB2312_CHARSET;
    private static final Charset PLATFORM_DEFAULT_ENCODING;
    public static final Charset SHIFT_JIS_CHARSET;

    static {
        Charset charsetDefaultCharset = Charset.defaultCharset();
        PLATFORM_DEFAULT_ENCODING = charsetDefaultCharset;
        Charset charsetForName = Charset.forName("SJIS");
        SHIFT_JIS_CHARSET = charsetForName;
        GB2312_CHARSET = Charset.forName("GB2312");
        Charset charsetForName2 = Charset.forName("EUC_JP");
        EUC_JP = charsetForName2;
        ASSUME_SHIFT_JIS = charsetForName.equals(charsetDefaultCharset) || charsetForName2.equals(charsetDefaultCharset);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074 A[PHI: r10
      0x0074: PHI (r10v6 int) = (r10v1 int), (r10v5 int), (r10v1 int) binds: [B:45:0x007f, B:54:0x0098, B:39:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.nio.charset.Charset guessCharset(byte[] r19, java.util.Map<com.google.zxing.DecodeHintType, ?> r20) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.StringUtils.guessCharset(byte[], java.util.Map):java.nio.charset.Charset");
    }
}
