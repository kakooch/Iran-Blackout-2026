package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.crypto.tink.shaded.protobuf.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2360w {
    static final Charset a = Charset.forName("US-ASCII");
    static final Charset b = Charset.forName("UTF-8");
    static final Charset c = Charset.forName("ISO-8859-1");
    public static final byte[] d;
    public static final ByteBuffer e;
    public static final AbstractC2346h f;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.w$a */
    public interface a {
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.w$b */
    public interface b {
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.w$c */
    public interface c {
        boolean a(int i);
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.w$d */
    public interface d extends List, RandomAccess {
        d b(int i);

        void s();

        boolean u();
    }

    static {
        byte[] bArr = new byte[0];
        d = bArr;
        e = ByteBuffer.wrap(bArr);
        f = AbstractC2346h.h(bArr);
    }

    static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i, int i2) {
        int iH = h(i2, bArr, i, i2);
        if (iH == 0) {
            return 1;
        }
        return iH;
    }

    public static int f(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return e0.m(bArr);
    }

    static int h(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static String i(byte[] bArr) {
        return new String(bArr, b);
    }
}
