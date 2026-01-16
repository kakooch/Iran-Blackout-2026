package ir.nasim;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: ir.nasim.dr8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC11975dr8 {
    private static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static long b(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    public static long c(byte[] bArr) {
        int length = bArr.length;
        if (length < 0 || length > bArr.length) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("Out of bound index with offput: 0 and length: ");
            sb.append(length);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        char c = 0;
        if (length <= 32) {
            if (length > 16) {
                long j = (length << 1) - 7286425919675154353L;
                long jE = e(bArr, 0) * (-5435081209227447693L);
                long jE2 = e(bArr, 8);
                long jE3 = e(bArr, length - 8) * j;
                return b(Long.rotateRight(jE + jE2, 43) + Long.rotateRight(jE3, 30) + (e(bArr, length - 16) * (-7286425919675154353L)), jE + Long.rotateRight(jE2 - 7286425919675154353L, 18) + jE3, j);
            }
            if (length >= 8) {
                long j2 = (length << 1) - 7286425919675154353L;
                long jE4 = e(bArr, 0) - 7286425919675154353L;
                long jE5 = e(bArr, length - 8);
                return b((Long.rotateRight(jE5, 37) * j2) + jE4, (Long.rotateRight(jE4, 25) + jE5) * j2, j2);
            }
            if (length >= 4) {
                return b(((a(bArr, 0) & 4294967295L) << 3) + length, a(bArr, length - 4) & 4294967295L, (length << 1) - 7286425919675154353L);
            }
            if (length <= 0) {
                return -7286425919675154353L;
            }
            long j3 = (((bArr[0] & 255) + ((bArr[length >> 1] & 255) << 8)) * (-7286425919675154353L)) ^ ((length + ((bArr[length - 1] & 255) << 2)) * (-4348849565147123417L));
            return (j3 ^ (j3 >>> 47)) * (-7286425919675154353L);
        }
        if (length <= 64) {
            long j4 = (length << 1) - 7286425919675154353L;
            long jE6 = e(bArr, 0) * (-7286425919675154353L);
            long jE7 = e(bArr, 8);
            long jE8 = e(bArr, length - 8) * j4;
            long jRotateRight = Long.rotateRight(jE6 + jE7, 43) + Long.rotateRight(jE8, 30) + (e(bArr, length - 16) * (-7286425919675154353L));
            long jB = b(jRotateRight, jE8 + jE6 + Long.rotateRight(jE7 - 7286425919675154353L, 18), j4);
            long jE9 = e(bArr, 16) * j4;
            long jE10 = e(bArr, 24);
            long jE11 = (jRotateRight + e(bArr, length - 32)) * j4;
            return b(Long.rotateRight(jE9 + jE10, 43) + Long.rotateRight(jE11, 30) + ((jB + e(bArr, length - 24)) * j4), jE9 + Long.rotateRight(jE10 + jE6, 18) + jE11, j4);
        }
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long jE12 = e(bArr, 0) + 95310865018149119L;
        int i = length - 1;
        int i2 = (i / 64) << 6;
        int i3 = i & 63;
        int i4 = i2 + i3;
        int i5 = i4 - 63;
        long j5 = 2480279821605975764L;
        long j6 = 1390051526045402406L;
        int i6 = 0;
        while (true) {
            int i7 = i2;
            long jRotateRight2 = Long.rotateRight(jE12 + j5 + jArr[c] + e(bArr, i6 + 8), 37) * (-5435081209227447693L);
            long jRotateRight3 = Long.rotateRight(j5 + jArr[1] + e(bArr, i6 + 48), 42) * (-5435081209227447693L);
            long j7 = jRotateRight2 ^ jArr2[1];
            long jE13 = jRotateRight3 + jArr[c] + e(bArr, i6 + 40);
            long jRotateRight4 = Long.rotateRight(j6 + jArr2[c], 33) * (-5435081209227447693L);
            char c2 = c;
            int i8 = i3;
            d(bArr, i6, jArr[1] * (-5435081209227447693L), j7 + jArr2[c], jArr);
            d(bArr, i6 + 32, jRotateRight4 + jArr2[1], jE13 + e(bArr, i6 + 16), jArr2);
            int i9 = i6 + 64;
            if (i9 == i7) {
                long j8 = (-5435081209227447693L) + ((j7 & 255) << 1);
                long j9 = jArr2[c2] + i8;
                jArr2[c2] = j9;
                long j10 = jArr[c2] + j9;
                jArr[c2] = j10;
                jArr2[c2] = jArr2[c2] + j10;
                long jRotateRight5 = Long.rotateRight(jRotateRight4 + jE13 + jArr[c2] + e(bArr, i4 - 55), 37) * j8;
                long jRotateRight6 = Long.rotateRight(jE13 + jArr[1] + e(bArr, i4 - 15), 42) * j8;
                long j11 = jRotateRight5 ^ (jArr2[1] * 9);
                long jE14 = jRotateRight6 + (jArr[c2] * 9) + e(bArr, i4 - 23);
                long jRotateRight7 = Long.rotateRight(j7 + jArr2[c2], 33) * j8;
                d(bArr, i5, jArr[1] * j8, j11 + jArr2[c2], jArr);
                d(bArr, i4 - 31, jRotateRight7 + jArr2[1], e(bArr, i4 - 47) + jE14, jArr2);
                return b(b(jArr[c2], jArr2[c2], j8) + (((jE14 >>> 47) ^ jE14) * (-4348849565147123417L)) + j11, b(jArr[1], jArr2[1], j8) + jRotateRight7, j8);
            }
            i6 = i9;
            i3 = i8;
            i2 = i7;
            c = c2;
            j5 = jE13;
            jE12 = jRotateRight4;
            j6 = j7;
        }
    }

    private static void d(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long jE = e(bArr, i);
        long jE2 = e(bArr, i + 8);
        long jE3 = e(bArr, i + 16);
        long jE4 = e(bArr, i + 24);
        long j3 = j + jE;
        long j4 = jE2 + j3 + jE3;
        long jRotateRight = Long.rotateRight(j2 + j3 + jE4, 21) + Long.rotateRight(j4, 44);
        jArr[0] = j4 + jE4;
        jArr[1] = jRotateRight + j3;
    }

    private static long e(byte[] bArr, int i) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, 8);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        return byteBufferWrap.getLong();
    }
}
