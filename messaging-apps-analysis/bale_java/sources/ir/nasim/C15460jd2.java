package ir.nasim;

import android.gov.nist.core.Separators;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* renamed from: ir.nasim.jd2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C15460jd2 {
    static final Charset e = StandardCharsets.US_ASCII;
    static final String[] f = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] g = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] h = {65, 83, 67, 73, 73, 0, 0, 0};
    public final int a;
    public final int b;
    public final long c;
    public final byte[] d;

    C15460jd2(int i, int i2, byte[] bArr) {
        this(i, i2, -1L, bArr);
    }

    public static C15460jd2 a(String str) {
        if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
            return new C15460jd2(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }
        byte[] bytes = str.getBytes(e);
        return new C15460jd2(1, bytes.length, bytes);
    }

    public static C15460jd2 b(double[] dArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[12] * dArr.length]);
        byteBufferWrap.order(byteOrder);
        for (double d : dArr) {
            byteBufferWrap.putDouble(d);
        }
        return new C15460jd2(12, dArr.length, byteBufferWrap.array());
    }

    public static C15460jd2 c(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[9] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i : iArr) {
            byteBufferWrap.putInt(i);
        }
        return new C15460jd2(9, iArr.length, byteBufferWrap.array());
    }

    public static C15460jd2 d(C18233oJ3[] c18233oJ3Arr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[10] * c18233oJ3Arr.length]);
        byteBufferWrap.order(byteOrder);
        for (C18233oJ3 c18233oJ3 : c18233oJ3Arr) {
            byteBufferWrap.putInt((int) c18233oJ3.b());
            byteBufferWrap.putInt((int) c18233oJ3.a());
        }
        return new C15460jd2(10, c18233oJ3Arr.length, byteBufferWrap.array());
    }

    public static C15460jd2 e(String str) {
        byte[] bytes = (str + (char) 0).getBytes(e);
        return new C15460jd2(2, bytes.length, bytes);
    }

    public static C15460jd2 f(long j, ByteOrder byteOrder) {
        return g(new long[]{j}, byteOrder);
    }

    public static C15460jd2 g(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[4] * jArr.length]);
        byteBufferWrap.order(byteOrder);
        for (long j : jArr) {
            byteBufferWrap.putInt((int) j);
        }
        return new C15460jd2(4, jArr.length, byteBufferWrap.array());
    }

    public static C15460jd2 h(C18233oJ3[] c18233oJ3Arr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[5] * c18233oJ3Arr.length]);
        byteBufferWrap.order(byteOrder);
        for (C18233oJ3 c18233oJ3 : c18233oJ3Arr) {
            byteBufferWrap.putInt((int) c18233oJ3.b());
            byteBufferWrap.putInt((int) c18233oJ3.a());
        }
        return new C15460jd2(5, c18233oJ3Arr.length, byteBufferWrap.array());
    }

    public static C15460jd2 i(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[g[3] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i : iArr) {
            byteBufferWrap.putShort((short) i);
        }
        return new C15460jd2(3, iArr.length, byteBufferWrap.array());
    }

    public int j() {
        return g[this.a] * this.b;
    }

    public String toString() {
        return Separators.LPAREN + f[this.a] + ", data length:" + this.d.length + Separators.RPAREN;
    }

    C15460jd2(int i, int i2, long j, byte[] bArr) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = bArr;
    }
}
