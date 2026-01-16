package ir.nasim;

/* renamed from: ir.nasim.Uo0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC8107Uo0 {
    public static int a(byte[] bArr) {
        return b(bArr, 0);
    }

    public static int b(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) + ((bArr[i + 2] & 255) << 8) + ((bArr[i + 1] & 255) << 16) + ((bArr[i] & 255) << 24);
    }

    public static long c(byte[] bArr) {
        return d(bArr, 0);
    }

    public static long d(byte[] bArr, int i) {
        int i2 = i + 4;
        return (bArr[i + 7] & 255) + ((bArr[i + 6] & 255) << 8) + ((bArr[i + 5] & 255) << 16) + ((bArr[i2] & 255) << 24) + (((((bArr[i + 3] & 255) + ((bArr[i + 2] & 255) << 8)) + ((bArr[i + 1] & 255) << 16)) + ((bArr[i] & 255) << 24)) << 32);
    }

    public static byte[] e(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] f(long j) {
        return new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (j & 255)};
    }

    public static byte[] g(byte[]... bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int i = 0;
        for (byte[] bArr4 : bArr) {
            int i2 = 0;
            while (i2 < bArr4.length) {
                bArr3[i] = bArr4[i2];
                i2++;
                i++;
            }
        }
        return bArr3;
    }

    public static byte[] h(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[i3 + i];
        }
        return bArr2;
    }

    public static void i(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i + i4] = bArr2[i2 + i4];
        }
    }
}
