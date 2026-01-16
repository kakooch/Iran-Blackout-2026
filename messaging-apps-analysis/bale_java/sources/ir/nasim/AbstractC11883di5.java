package ir.nasim;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: ir.nasim.di5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC11883di5 {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        int i = 0;
        long jC = c(bArr, 0, 0) & 67108863;
        int i2 = 3;
        long jC2 = c(bArr, 3, 2) & 67108611;
        long jC3 = c(bArr, 6, 4) & 67092735;
        long jC4 = c(bArr, 9, 6) & 66076671;
        long jC5 = c(bArr, 12, 8) & 1048575;
        long j = jC2 * 5;
        long j2 = jC3 * 5;
        long j3 = jC4 * 5;
        long j4 = jC5 * 5;
        byte[] bArr3 = new byte[17];
        long j5 = 0;
        int i3 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        while (i3 < bArr2.length) {
            b(bArr3, bArr2, i3);
            long jC6 = j9 + c(bArr3, i, i);
            long jC7 = j5 + c(bArr3, i2, 2);
            long jC8 = j6 + c(bArr3, 6, 4);
            long jC9 = j7 + c(bArr3, 9, 6);
            long jC10 = j8 + (c(bArr3, 12, 8) | (bArr3[16] << 24));
            long j10 = (jC6 * jC) + (jC7 * j4) + (jC8 * j3) + (jC9 * j2) + (jC10 * j);
            long j11 = (jC6 * jC2) + (jC7 * jC) + (jC8 * j4) + (jC9 * j3) + (jC10 * j2);
            long j12 = (jC6 * jC3) + (jC7 * jC2) + (jC8 * jC) + (jC9 * j4) + (jC10 * j3);
            long j13 = (jC6 * jC4) + (jC7 * jC3) + (jC8 * jC2) + (jC9 * jC) + (jC10 * j4);
            long j14 = j11 + (j10 >> 26);
            long j15 = j12 + (j14 >> 26);
            long j16 = j13 + (j15 >> 26);
            long j17 = (jC6 * jC5) + (jC7 * jC4) + (jC8 * jC3) + (jC9 * jC2) + (jC10 * jC) + (j16 >> 26);
            long j18 = (j10 & 67108863) + ((j17 >> 26) * 5);
            j5 = (j14 & 67108863) + (j18 >> 26);
            i3 += 16;
            j6 = j15 & 67108863;
            j7 = j16 & 67108863;
            j8 = j17 & 67108863;
            i2 = 3;
            j9 = j18 & 67108863;
            i = 0;
        }
        long j19 = j6 + (j5 >> 26);
        long j20 = j19 & 67108863;
        long j21 = j7 + (j19 >> 26);
        long j22 = j21 & 67108863;
        long j23 = j8 + (j21 >> 26);
        long j24 = j23 & 67108863;
        long j25 = j9 + ((j23 >> 26) * 5);
        long j26 = j25 & 67108863;
        long j27 = (j5 & 67108863) + (j25 >> 26);
        long j28 = j26 + 5;
        long j29 = j28 & 67108863;
        long j30 = (j28 >> 26) + j27;
        long j31 = j20 + (j30 >> 26);
        long j32 = j22 + (j31 >> 26);
        long j33 = (j24 + (j32 >> 26)) - 67108864;
        long j34 = j33 >> 63;
        long j35 = j26 & j34;
        long j36 = j27 & j34;
        long j37 = j20 & j34;
        long j38 = j22 & j34;
        long j39 = j24 & j34;
        long j40 = ~j34;
        long j41 = (j30 & 67108863 & j40) | j36;
        long j42 = (j31 & 67108863 & j40) | j37;
        long j43 = (j32 & 67108863 & j40) | j38;
        long j44 = (j33 & j40) | j39;
        long j45 = (j35 | (j29 & j40) | (j41 << 26)) & 4294967295L;
        long j46 = ((j41 >> 6) | (j42 << 20)) & 4294967295L;
        long j47 = ((j42 >> 12) | (j43 << 14)) & 4294967295L;
        long j48 = ((j43 >> 18) | (j44 << 8)) & 4294967295L;
        long jD = j45 + d(bArr, 16);
        long j49 = jD & 4294967295L;
        long jD2 = j46 + d(bArr, 20) + (jD >> 32);
        long j50 = jD2 & 4294967295L;
        long jD3 = j47 + d(bArr, 24) + (jD2 >> 32);
        long j51 = jD3 & 4294967295L;
        long jD4 = (j48 + d(bArr, 28) + (jD3 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        e(bArr4, j49, 0);
        e(bArr4, j50, 4);
        e(bArr4, j51, 8);
        e(bArr4, jD4, 12);
        return bArr4;
    }

    private static void b(byte[] bArr, byte[] bArr2, int i) {
        int iMin = Math.min(16, bArr2.length - i);
        System.arraycopy(bArr2, i, bArr, 0, iMin);
        bArr[iMin] = 1;
        if (iMin != 16) {
            Arrays.fill(bArr, iMin + 1, bArr.length, (byte) 0);
        }
    }

    private static long c(byte[] bArr, int i, int i2) {
        return (d(bArr, i) >> i2) & 67108863;
    }

    private static long d(byte[] bArr, int i) {
        return (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16)) & 4294967295L;
    }

    private static void e(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) (255 & j);
            i2++;
            j >>= 8;
        }
    }

    public static void f(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (!AbstractC8841Xo0.b(a(bArr, bArr2), bArr3)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
