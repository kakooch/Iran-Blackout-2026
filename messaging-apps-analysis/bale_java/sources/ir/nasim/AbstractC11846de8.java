package ir.nasim;

/* renamed from: ir.nasim.de8, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC11846de8 {
    public static void a(byte[] bArr, Nd8 nd8) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        AbstractC20803sd8.a(iArr, nd8.c);
        AbstractC23266wd8.a(iArr2, nd8.a, iArr);
        AbstractC23266wd8.a(iArr3, nd8.b, iArr);
        Cd8.a(bArr, iArr3);
        bArr[31] = (byte) (bArr[31] ^ (AbstractC21423td8.a(iArr2) << 7));
    }
}
