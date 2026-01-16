package com.google.ads.interactivemedia.v3.internal;

import j$.util.DesugarTimeZone;
import java.util.TimeZone;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class akv {
    private static final TimeZone a = DesugarTimeZone.getTimeZone("UTC");

    /* JADX WARN: Removed duplicated region for block: B:59:0x00e3 A[Catch: IllegalArgumentException -> 0x01d2, NumberFormatException -> 0x01d4, NumberFormatException | IllegalArgumentException | IndexOutOfBoundsException -> 0x01d6, TryCatch #2 {NumberFormatException | IllegalArgumentException | IndexOutOfBoundsException -> 0x01d6, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0034, B:13:0x003a, B:17:0x0051, B:19:0x0061, B:20:0x0063, B:22:0x006f, B:23:0x0071, B:25:0x0077, B:29:0x0081, B:34:0x0091, B:36:0x0099, B:37:0x009d, B:39:0x00a3, B:44:0x00b0, B:46:0x00ba, B:57:0x00dd, B:59:0x00e3, B:61:0x00ea, B:85:0x0198, B:66:0x00f6, B:67:0x0111, B:68:0x0112, B:70:0x011c, B:71:0x012d, B:73:0x013a, B:76:0x0143, B:78:0x0162, B:81:0x0171, B:82:0x0193, B:84:0x0196, B:87:0x01ca, B:88:0x01d1, B:50:0x00ca, B:51:0x00cd, B:45:0x00b5), top: B:105:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ca A[Catch: IllegalArgumentException -> 0x01d2, NumberFormatException -> 0x01d4, NumberFormatException | IllegalArgumentException | IndexOutOfBoundsException -> 0x01d6, TryCatch #2 {NumberFormatException | IllegalArgumentException | IndexOutOfBoundsException -> 0x01d6, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0034, B:13:0x003a, B:17:0x0051, B:19:0x0061, B:20:0x0063, B:22:0x006f, B:23:0x0071, B:25:0x0077, B:29:0x0081, B:34:0x0091, B:36:0x0099, B:37:0x009d, B:39:0x00a3, B:44:0x00b0, B:46:0x00ba, B:57:0x00dd, B:59:0x00e3, B:61:0x00ea, B:85:0x0198, B:66:0x00f6, B:67:0x0111, B:68:0x0112, B:70:0x011c, B:71:0x012d, B:73:0x013a, B:76:0x0143, B:78:0x0162, B:81:0x0171, B:82:0x0193, B:84:0x0196, B:87:0x01ca, B:88:0x01d1, B:50:0x00ca, B:51:0x00cd, B:45:0x00b5), top: B:105:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date a(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.akv.a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static boolean b(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int c(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -iDigit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - iDigit2;
            i4 = i5;
        }
        return -i3;
    }
}
