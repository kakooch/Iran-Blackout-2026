package ir.nasim;

/* renamed from: ir.nasim.wS4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23160wS4 {
    public static void a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
    }
}
