package ir.nasim;

/* renamed from: ir.nasim.Lw1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC6028Lw1 {
    private static final InterfaceC3913Cw6 a = new a();

    /* renamed from: ir.nasim.Lw1$a */
    class a implements InterfaceC3913Cw6 {
        a() {
        }

        @Override // ir.nasim.InterfaceC3913Cw6
        public void a(byte[] bArr, byte[] bArr2, long j) {
            H76 h76 = new H76();
            h76.c(bArr2, 0, (int) j);
            h76.a(bArr, 0);
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        AbstractC25050ze8.a(bArr3, bArr, bArr2);
        return bArr3;
    }

    public static C6262Mw1 b(byte[] bArr) {
        byte[] bArrC = c(bArr);
        return new C6262Mw1(d(bArrC), bArrC);
    }

    public static byte[] c(byte[] bArr) {
        if (bArr.length < 32) {
            throw new RuntimeException("Random bytes too small");
        }
        byte[] bArr2 = new byte[32];
        CT1 ct1H = AbstractC7464Rv1.h();
        ct1H.c(bArr, 0, bArr.length);
        ct1H.a(bArr2, 0);
        bArr2[0] = (byte) (bArr2[0] & 248);
        byte b = (byte) (bArr2[31] & 127);
        bArr2[31] = b;
        bArr2[31] = (byte) (b | 64);
        return bArr2;
    }

    public static byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[32];
        AbstractC13675gd8.a(bArr2, bArr);
        return bArr2;
    }

    public static boolean e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return AbstractC13675gd8.b(a, bArr3, bArr, bArr2, bArr2.length) == 0;
    }
}
