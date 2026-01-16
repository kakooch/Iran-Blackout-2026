package ir.nasim;

/* renamed from: ir.nasim.sS4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20697sS4 {
    private CT1 a;

    public C20697sS4(CT1 ct1) {
        this.a = ct1;
    }

    public byte[] a(byte[] bArr, String str, byte[] bArr2, int i, boolean z) {
        VS2 vs2 = new VS2(bArr, this.a);
        WS2 ws2 = new WS2(new F76());
        ws2.c(new C4540Fo3(bArr));
        byte[] bArrG = AbstractC8107Uo0.g(str.getBytes(), bArr2);
        byte[] bArr3 = new byte[i];
        int iB = this.a.b();
        byte[] bArr4 = new byte[iB];
        byte[] bArr5 = bArrG;
        int i2 = 0;
        while (i2 * 32 < i) {
            if (z) {
                ws2.d();
                ws2.e(bArr5, 0, bArr5.length);
                ws2.a(bArr4, 0);
            } else {
                vs2.reset();
                vs2.c(bArr5, 0, bArr5.length);
                vs2.a(bArr4, 0);
            }
            int iB2 = this.a.b();
            byte[] bArr6 = new byte[iB2];
            AbstractC8107Uo0.i(bArr6, 0, bArr4, 0, iB2);
            this.a.reset();
            this.a.c(bArr, 0, bArr.length);
            this.a.c(bArr6, 0, iB2);
            this.a.c(bArrG, 0, bArrG.length);
            this.a.a(bArr4, 0);
            AbstractC8107Uo0.i(bArr3, this.a.b() * i2, bArr4, 0, Math.min(iB, i - (this.a.b() * i2)));
            i2++;
            bArr5 = bArr6;
        }
        return bArr3;
    }
}
