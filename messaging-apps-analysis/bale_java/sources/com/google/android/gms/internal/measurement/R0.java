package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public abstract class R0 {
    static final Charset a = Charset.forName("US-ASCII");
    static final Charset b = Charset.forName("UTF-8");
    static final Charset c = Charset.forName("ISO-8859-1");
    public static final byte[] d;
    public static final ByteBuffer e;
    public static final C0 f;

    static {
        byte[] bArr = new byte[0];
        d = bArr;
        e = ByteBuffer.wrap(bArr);
        int i = C0.a;
        B0 b0 = new B0(bArr, 0, 0, false, null);
        try {
            b0.c(0);
            f = b0;
        } catch (zzkp e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        int iD = d(length, bArr, 0, length);
        if (iD == 0) {
            return 1;
        }
        return iD;
    }

    public static int c(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static int d(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object e(Object obj) {
        obj.getClass();
        return obj;
    }

    static Object f(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static String g(byte[] bArr) {
        return new String(bArr, b);
    }

    public static boolean h(byte[] bArr) {
        return E1.e(bArr);
    }
}
