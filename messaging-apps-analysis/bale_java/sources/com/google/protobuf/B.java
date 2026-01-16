package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public abstract class B {
    static final Charset a = Charset.forName("US-ASCII");
    static final Charset b = Charset.forName("UTF-8");
    static final Charset c = Charset.forName("ISO-8859-1");
    public static final byte[] d;
    public static final ByteBuffer e;
    public static final AbstractC2384h f;

    public interface a extends j {
        @Override // com.google.protobuf.B.j, com.google.protobuf.B.g
        a b(int i);
    }

    public interface b extends j {
        double S0(int i, double d);

        @Override // com.google.protobuf.B.j, com.google.protobuf.B.g
        b b(int i);

        double getDouble(int i);

        void s1(double d);
    }

    public interface c {
        int getNumber();
    }

    public interface d {
        c a(int i);
    }

    public interface e {
        boolean a(int i);
    }

    public interface f extends j {
        void M(float f);

        @Override // com.google.protobuf.B.j, com.google.protobuf.B.g
        f b(int i);

        float getFloat(int i);

        float m0(int i, float f);
    }

    public interface g extends j {
        int U(int i, int i2);

        g b(int i);

        void b1(int i);

        int getInt(int i);
    }

    public static class h extends AbstractList {
        private final List a;
        private final a b;

        public interface a {
            Object a(Object obj);
        }

        public h(List list, a aVar) {
            this.a = list;
            this.b = aVar;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            return this.b.a(this.a.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.a.size();
        }
    }

    public interface i extends j {
        @Override // com.google.protobuf.B.j, com.google.protobuf.B.g
        i b(int i);

        long getLong(int i);

        void l1(long j);

        long z1(int i, long j);
    }

    public interface j extends List, RandomAccess {
        j b(int i);

        void s();

        boolean u();
    }

    static {
        byte[] bArr = new byte[0];
        d = bArr;
        e = ByteBuffer.wrap(bArr);
        f = AbstractC2384h.l(bArr);
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

    static int e(byte[] bArr, int i2, int i3) {
        int i4 = i(i3, bArr, i2, i3);
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    public static int f(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return p0.s(bArr);
    }

    static Object h(Object obj, Object obj2) {
        return ((P) obj).toBuilder().A0((P) obj2).j();
    }

    static int i(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, b);
    }
}
