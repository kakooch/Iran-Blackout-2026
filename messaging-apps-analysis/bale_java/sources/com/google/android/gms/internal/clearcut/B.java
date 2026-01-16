package com.google.android.gms.internal.clearcut;

import ir.nasim.InterfaceC20302rm8;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public abstract class B {
    static final Charset a = Charset.forName("UTF-8");
    private static final Charset b = Charset.forName("ISO-8859-1");
    public static final byte[] c;
    private static final ByteBuffer d;
    private static final AbstractC2091o e;

    static {
        byte[] bArr = new byte[0];
        c = bArr;
        d = ByteBuffer.wrap(bArr);
        e = AbstractC2091o.b(bArr, 0, bArr.length, false);
    }

    static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        int iC = c(length, bArr, 0, length);
        if (iC == 0) {
            return 1;
        }
        return iC;
    }

    static int c(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object d(Object obj, Object obj2) {
        return ((InterfaceC20302rm8) obj).b().S1((InterfaceC20302rm8) obj2).s0();
    }

    static Object e(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int f(boolean z) {
        return z ? 1231 : 1237;
    }

    public static boolean g(byte[] bArr) {
        return q0.h(bArr);
    }

    public static String h(byte[] bArr) {
        return new String(bArr, a);
    }

    public static int i(long j) {
        return (int) (j ^ (j >>> 32));
    }
}
