package com.fasterxml.jackson.core.io;

/* loaded from: classes.dex */
public final class NumberInput {
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0075, code lost:
    
        return java.lang.Integer.parseInt(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int parseInt(java.lang.String r8) {
        /*
            r0 = 0
            char r1 = r8.charAt(r0)
            int r2 = r8.length()
            r3 = 1
            r4 = 45
            if (r1 != r4) goto Lf
            r0 = 1
        Lf:
            r4 = 10
            if (r0 == 0) goto L25
            if (r2 == r3) goto L20
            if (r2 <= r4) goto L18
            goto L20
        L18:
            r1 = 2
            char r3 = r8.charAt(r3)
            r1 = r3
            r3 = 2
            goto L2e
        L20:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L25:
            r5 = 9
            if (r2 <= r5) goto L2e
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L2e:
            r5 = 57
            if (r1 > r5) goto L84
            r6 = 48
            if (r1 >= r6) goto L37
            goto L84
        L37:
            int r1 = r1 - r6
            if (r3 >= r2) goto L80
            int r7 = r3 + 1
            char r3 = r8.charAt(r3)
            if (r3 > r5) goto L7b
            if (r3 >= r6) goto L45
            goto L7b
        L45:
            int r1 = r1 * 10
            int r3 = r3 - r6
            int r1 = r1 + r3
            if (r7 >= r2) goto L80
            int r3 = r7 + 1
            char r7 = r8.charAt(r7)
            if (r7 > r5) goto L76
            if (r7 >= r6) goto L56
            goto L76
        L56:
            int r1 = r1 * 10
            int r7 = r7 - r6
            int r1 = r1 + r7
            if (r3 >= r2) goto L80
        L5c:
            int r7 = r3 + 1
            char r3 = r8.charAt(r3)
            if (r3 > r5) goto L71
            if (r3 >= r6) goto L67
            goto L71
        L67:
            int r1 = r1 * 10
            int r3 = r3 + (-48)
            int r1 = r1 + r3
            if (r7 < r2) goto L6f
            goto L80
        L6f:
            r3 = r7
            goto L5c
        L71:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L76:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L7b:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        L80:
            if (r0 == 0) goto L83
            int r1 = -r1
        L83:
            return r1
        L84:
            int r8 = java.lang.Integer.parseInt(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.io.NumberInput.parseInt(java.lang.String):int");
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(String str, boolean z) {
        String str2 = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int iCharAt = str.charAt(i) - str2.charAt(i);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }
}
