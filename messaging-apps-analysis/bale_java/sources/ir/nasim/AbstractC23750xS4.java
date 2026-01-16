package ir.nasim;

/* renamed from: ir.nasim.xS4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC23750xS4 {
    public static int a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | (bArr[i] << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static long b(byte[] bArr, int i) {
        return (a(bArr, i + 4) & 4294967295L) | ((a(bArr, i) & 4294967295L) << 32);
    }

    public static void c(int i, byte[] bArr, int i2) {
        bArr[i2] = e((byte) (i >>> 24));
        bArr[i2 + 1] = e((byte) (i >>> 16));
        bArr[i2 + 2] = e((byte) (i >>> 8));
        bArr[i2 + 3] = e((byte) i);
    }

    public static void d(int i, byte[] bArr, int i2) {
        bArr[i2] = e((byte) i);
        bArr[i2 + 1] = e((byte) (i >>> 8));
        bArr[i2 + 2] = e((byte) (i >>> 16));
        bArr[i2 + 3] = e((byte) (i >>> 24));
    }

    public static byte e(byte b) {
        return (byte) (b & 255);
    }

    public static int g(byte[] bArr, int i) {
        return (bArr[i + 3] << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static void h(long j, byte[] bArr, int i) {
        c((int) (j >>> 32), bArr, i);
        c((int) (j & 4294967295L), bArr, i + 4);
    }

    public static int f(int i) {
        return i;
    }
}
