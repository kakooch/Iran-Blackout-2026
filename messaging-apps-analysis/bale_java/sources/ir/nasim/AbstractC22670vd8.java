package ir.nasim;

/* renamed from: ir.nasim.vd8, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22670vd8 {
    public static void a(int[] iArr, int[] iArr2) {
        int i = iArr2[0];
        int i2 = iArr2[1];
        int i3 = iArr2[2];
        int i4 = iArr2[3];
        int i5 = iArr2[4];
        int i6 = iArr2[5];
        int i7 = iArr2[6];
        long j = i2 * 121666;
        long j2 = i4 * 121666;
        long j3 = i6 * 121666;
        long j4 = i7 * 121666;
        long j5 = iArr2[7] * 121666;
        long j6 = iArr2[9] * 121666;
        long j7 = (j6 + 16777216) >> 25;
        long j8 = (i * 121666) + (19 * j7);
        long j9 = j6 - (j7 << 25);
        long j10 = (j + 16777216) >> 25;
        long j11 = (i3 * 121666) + j10;
        long j12 = j - (j10 << 25);
        long j13 = (j2 + 16777216) >> 25;
        long j14 = (i5 * 121666) + j13;
        long j15 = j2 - (j13 << 25);
        long j16 = (j3 + 16777216) >> 25;
        long j17 = j4 + j16;
        long j18 = j3 - (j16 << 25);
        long j19 = (16777216 + j5) >> 25;
        long j20 = (iArr2[8] * 121666) + j19;
        long j21 = j5 - (j19 << 25);
        long j22 = (j8 + 33554432) >> 26;
        long j23 = j12 + j22;
        long j24 = j8 - (j22 << 26);
        long j25 = (j11 + 33554432) >> 26;
        long j26 = j15 + j25;
        long j27 = j11 - (j25 << 26);
        long j28 = (j14 + 33554432) >> 26;
        long j29 = j18 + j28;
        long j30 = j14 - (j28 << 26);
        long j31 = (j17 + 33554432) >> 26;
        long j32 = (j20 + 33554432) >> 26;
        iArr[0] = (int) j24;
        iArr[1] = (int) j23;
        iArr[2] = (int) j27;
        iArr[3] = (int) j26;
        iArr[4] = (int) j30;
        iArr[5] = (int) j29;
        iArr[6] = (int) (j17 - (j31 << 26));
        iArr[7] = (int) (j21 + j31);
        iArr[8] = (int) (j20 - (j32 << 26));
        iArr[9] = (int) (j9 + j32);
    }
}
