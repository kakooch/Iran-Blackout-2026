package ir.nasim;

/* renamed from: ir.nasim.rd8, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC20210rd8 {
    public static void a(int[] iArr, byte[] bArr) {
        long jC = c(bArr, 0);
        long jB = b(bArr, 4) << 6;
        long jB2 = b(bArr, 7) << 5;
        long jB3 = b(bArr, 10) << 3;
        long jB4 = b(bArr, 13) << 2;
        long jC2 = c(bArr, 16);
        long jB5 = b(bArr, 20) << 7;
        long jB6 = b(bArr, 23) << 5;
        long jB7 = b(bArr, 26) << 4;
        long jB8 = (b(bArr, 29) & 8388607) << 2;
        long j = (jB8 + 16777216) >> 25;
        long j2 = jC + (19 * j);
        long j3 = jB8 - (j << 25);
        long j4 = (jB + 16777216) >> 25;
        long j5 = jB2 + j4;
        long j6 = jB - (j4 << 25);
        long j7 = (jB3 + 16777216) >> 25;
        long j8 = jB4 + j7;
        long j9 = jB3 - (j7 << 25);
        long j10 = (jC2 + 16777216) >> 25;
        long j11 = jB5 + j10;
        long j12 = jC2 - (j10 << 25);
        long j13 = (jB6 + 16777216) >> 25;
        long j14 = jB7 + j13;
        long j15 = (j2 + 33554432) >> 26;
        long j16 = j6 + j15;
        long j17 = j2 - (j15 << 26);
        long j18 = (j5 + 33554432) >> 26;
        long j19 = j9 + j18;
        long j20 = j5 - (j18 << 26);
        long j21 = (j8 + 33554432) >> 26;
        long j22 = j12 + j21;
        long j23 = (j11 + 33554432) >> 26;
        long j24 = (jB6 - (j13 << 25)) + j23;
        long j25 = j11 - (j23 << 26);
        long j26 = (j14 + 33554432) >> 26;
        iArr[0] = (int) j17;
        iArr[1] = (int) j16;
        iArr[2] = (int) j20;
        iArr[3] = (int) j19;
        iArr[4] = (int) (j8 - (j21 << 26));
        iArr[5] = (int) j22;
        iArr[6] = (int) j25;
        iArr[7] = (int) j24;
        iArr[8] = (int) (j14 - (j26 << 26));
        iArr[9] = (int) (j3 + j26);
    }

    public static long b(byte[] bArr, int i) {
        return ((bArr[i + 2] << 16) & 16711680) | (bArr[i] & 255) | ((bArr[i + 1] << 8) & 65280);
    }

    public static long c(byte[] bArr, int i) {
        return ((bArr[i + 3] << 24) & 4278190080L) | (bArr[i] & 255) | ((bArr[i + 1] << 8) & 65280) | ((bArr[i + 2] << 16) & 16711680);
    }
}
