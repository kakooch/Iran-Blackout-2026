package ir.nasim;

import ir.nasim.core.runtime.crypto.IntegrityException;

/* renamed from: ir.nasim.cp0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C11326cp0 {
    private final C10563bp0 a;
    private final VS2 b;
    private final WS2 c;
    private final QS4 d = new C20088rS4();
    private final boolean e;

    public C11326cp0(InterfaceC11073ch0 interfaceC11073ch0, CT1 ct1, byte[] bArr, boolean z) {
        this.a = new C10563bp0(interfaceC11073ch0);
        this.b = new VS2(bArr, ct1);
        WS2 ws2 = new WS2(new F76());
        this.c = ws2;
        ws2.c(new C4540Fo3(bArr));
        this.e = z;
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IntegrityException {
        if (bArr2.length != 16) {
            throw new IntegrityException("IV MUST be 16 bytes long!");
        }
        byte[] bArrB = this.a.b(bArr2, bArr3);
        byte[] bArr4 = new byte[32];
        int iA = AbstractC8107Uo0.a(bArrB);
        if (this.e) {
            this.c.d();
            this.c.e(bArr, 0, bArr.length);
            this.c.e(bArr2, 0, 16);
            this.c.e(bArrB, 0, iA + 4);
            this.c.a(bArr4, 0);
        } else {
            this.b.reset();
            this.b.c(bArr, 0, bArr.length);
            this.b.c(bArr2, 0, 16);
            this.b.c(bArrB, 0, iA + 4);
            this.b.a(bArr4, 0);
        }
        for (int i = 0; i < 32; i++) {
            if (bArr4[i] != bArrB[iA + 4 + i]) {
                throw new IntegrityException("Broken package!");
            }
        }
        int i2 = bArrB[bArrB.length - 1] & 255;
        if (this.d.a(bArrB, bArrB.length - i2, i2)) {
            return AbstractC8107Uo0.h(bArrB, 4, iA);
        }
        throw new IntegrityException("Broken package!");
    }

    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IntegrityException {
        int i;
        if (bArr2.length != 16) {
            throw new IntegrityException("IV MUST be 16 bytes long!");
        }
        int length = bArr3.length + 37;
        int i2 = length % 32;
        if (i2 != 0) {
            i = 32 - i2;
            length += i;
        } else {
            i = 0;
        }
        byte[] bArr4 = new byte[length];
        AbstractC8107Uo0.i(bArr4, 0, AbstractC8107Uo0.e(bArr3.length), 0, 4);
        AbstractC8107Uo0.i(bArr4, 4, bArr3, 0, bArr3.length);
        if (this.e) {
            this.c.d();
            this.c.e(bArr, 0, bArr.length);
            this.c.e(bArr2, 0, 16);
            this.c.e(bArr4, 0, bArr3.length + 4);
            this.c.a(bArr4, bArr3.length + 4);
        } else {
            this.b.reset();
            this.b.c(bArr, 0, bArr.length);
            this.b.c(bArr2, 0, 16);
            this.b.c(bArr4, 0, bArr3.length + 4);
            this.b.a(bArr4, bArr3.length + 4);
        }
        this.d.b(bArr4, (length - i) - 1, i);
        bArr4[length - 1] = (byte) i;
        return this.a.d(bArr2, bArr4);
    }
}
