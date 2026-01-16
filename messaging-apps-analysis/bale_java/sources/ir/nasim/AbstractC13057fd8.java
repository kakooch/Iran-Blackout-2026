package ir.nasim;

/* renamed from: ir.nasim.fd8, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC13057fd8 {
    public static int a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        for (int i2 = 0; i2 < 32; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i;
    }
}
