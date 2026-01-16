package com.google.android.gms.internal.vision;

import okio.Utf8;

/* loaded from: classes3.dex */
abstract class m1 {
    /* JADX INFO: Access modifiers changed from: private */
    public static void f(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzjk {
        if (o(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || o(b3) || o(b4)) {
            throw zzjk.f();
        }
        int i2 = ((b & 7) << 18) | ((b2 & Utf8.REPLACEMENT_BYTE) << 12) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(byte b, byte b2, byte b3, char[] cArr, int i) throws zzjk {
        if (o(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || o(b3)))) {
            throw zzjk.f();
        }
        cArr[i] = (char) (((b & 15) << 12) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(byte b, byte b2, char[] cArr, int i) throws zzjk {
        if (b < -62 || o(b2)) {
            throw zzjk.f();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(byte b) {
        return b >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(byte b) {
        return b < -32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(byte b) {
        return b < -16;
    }

    private static boolean o(byte b) {
        return b > -65;
    }
}
