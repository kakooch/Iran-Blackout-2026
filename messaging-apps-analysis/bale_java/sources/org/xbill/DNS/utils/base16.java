package org.xbill.DNS.utils;

import java.io.ByteArrayOutputStream;

/* loaded from: classes8.dex */
public class base16 {
    private static final String BASE_16_CHARS = "0123456789ABCDEF";

    private base16() {
    }

    public static byte[] fromString(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt >= '0' && cCharAt <= '9') || (cCharAt >= 'A' && cCharAt <= 'F')) {
                byteArrayOutputStream.write(cCharAt);
            } else if (cCharAt >= 'a' && cCharAt <= 'f') {
                byteArrayOutputStream.write(cCharAt - ' ');
            } else if (!Character.isWhitespace(cCharAt)) {
                return null;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if ((byteArray.length & 1) != 0) {
            return null;
        }
        byteArrayOutputStream.reset();
        for (int i2 = 0; i2 < byteArray.length; i2 += 2) {
            byteArrayOutputStream.write((((byte) BASE_16_CHARS.indexOf(byteArray[i2])) << 4) + (((byte) BASE_16_CHARS.indexOf(byteArray[i2 + 1])) & 15));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String toString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            short s = (short) (b & 255);
            sb.append(BASE_16_CHARS.charAt((byte) (s >> 4)));
            sb.append(BASE_16_CHARS.charAt((byte) (s & 15)));
        }
        return sb.toString();
    }

    public static String toString(byte[] bArr, int i, String str, boolean z) {
        return BaseUtils.wrapLines(toString(bArr), i, str, z);
    }
}
