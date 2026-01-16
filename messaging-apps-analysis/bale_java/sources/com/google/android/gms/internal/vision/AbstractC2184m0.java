package com.google.android.gms.internal.vision;

import ir.nasim.InterfaceC18561or8;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.vision.m0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2184m0 {
    static final Charset a = Charset.forName("UTF-8");
    private static final Charset b = Charset.forName("ISO-8859-1");
    public static final byte[] c;
    private static final ByteBuffer d;
    private static final W e;

    static {
        byte[] bArr = new byte[0];
        c = bArr;
        d = ByteBuffer.wrap(bArr);
        e = W.b(bArr, 0, bArr.length, false);
    }

    static int a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static int b(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int c(boolean z) {
        return z ? 1231 : 1237;
    }

    static Object d(Object obj) {
        obj.getClass();
        return obj;
    }

    static Object e(Object obj, Object obj2) {
        return ((InterfaceC18561or8) obj).b().J0((InterfaceC18561or8) obj2).g();
    }

    static Object f(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    static boolean g(InterfaceC18561or8 interfaceC18561or8) {
        return false;
    }

    public static boolean h(byte[] bArr) {
        return k1.f(bArr);
    }

    public static String i(byte[] bArr) {
        return new String(bArr, a);
    }

    public static int j(byte[] bArr) {
        int length = bArr.length;
        int iA = a(length, bArr, 0, length);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }
}
