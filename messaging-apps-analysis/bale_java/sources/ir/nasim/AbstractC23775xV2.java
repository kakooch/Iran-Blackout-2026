package ir.nasim;

import java.util.Locale;

/* renamed from: ir.nasim.xV2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC23775xV2 {
    public static byte[] a(String str) {
        char[] charArray = str.toLowerCase(Locale.US).replaceAll("[:\\s]", "").toCharArray();
        int length = charArray.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("HEX String length, with whitespace and semicolons removed, must be divisible by 2 as two characters are needed to decode a single byte!");
        }
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            char c = charArray[i];
            char c2 = charArray[i + 1];
            if (((c < 'a' || c > 'f') && (c < '0' || c > '9')) || ((c2 < 'a' || c2 > 'f') && (c2 < '0' || c2 > '9'))) {
                throw new IllegalArgumentException("HEX String must only contain whitespaces, semicolons (':'), and ASCII letters [a-fA-F] and numbers [0-9]!");
            }
            bArr[i / 2] = (byte) ((Character.digit(c, 16) << 4) + Character.digit(c2, 16));
        }
        return bArr;
    }

    public static String b(byte[] bArr) {
        return c(bArr, false, false);
    }

    public static String c(byte[] bArr, boolean z, boolean z2) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int i = z2 ? 3 : 2;
        char[] cArr2 = new char[(bArr.length * i) - (z2 ? 1 : 0)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2];
            int i4 = i2 * i;
            cArr2[i4] = cArr[(i3 & 255) >>> 4];
            cArr2[i4 + 1] = cArr[i3 & 15];
            if (i2 < bArr.length - 1) {
                cArr2[i4 + 2] = ':';
            }
        }
        return z ? new String(cArr2).toUpperCase(Locale.US) : new String(cArr2);
    }
}
