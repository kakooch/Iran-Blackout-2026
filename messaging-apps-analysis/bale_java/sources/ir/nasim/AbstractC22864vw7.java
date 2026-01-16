package ir.nasim;

/* renamed from: ir.nasim.vw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22864vw7 {
    public static int a(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static boolean b(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        for (int i5 = -4; i5 <= 4; i5++) {
            int i6 = (i5 * 188) + i3;
            if (i6 < i || i6 >= i2 || bArr[i6] != 71) {
                i4 = 0;
            } else {
                i4++;
                if (i4 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long c(EW4 ew4, int i, int i2) {
        ew4.S(i);
        if (ew4.a() < 5) {
            return -9223372036854775807L;
        }
        int iO = ew4.o();
        if ((8388608 & iO) != 0 || ((2096896 & iO) >> 8) != i2 || (iO & 32) == 0 || ew4.F() < 7 || ew4.a() < 7 || (ew4.F() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        ew4.j(bArr, 0, 6);
        return d(bArr);
    }

    private static long d(byte[] bArr) {
        return ((bArr[0] & 255) << 25) | ((bArr[1] & 255) << 17) | ((bArr[2] & 255) << 9) | ((bArr[3] & 255) << 1) | ((255 & bArr[4]) >> 7);
    }
}
