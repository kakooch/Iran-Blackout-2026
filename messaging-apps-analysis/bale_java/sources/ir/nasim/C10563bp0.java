package ir.nasim;

import ir.nasim.core.runtime.crypto.IntegrityException;

/* renamed from: ir.nasim.bp0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C10563bp0 {
    private final InterfaceC11073ch0 a;
    private final int b;

    public C10563bp0(InterfaceC11073ch0 interfaceC11073ch0) {
        this.a = interfaceC11073ch0;
        this.b = interfaceC11073ch0.a();
    }

    private void a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i;
        byte[] bArr4 = new byte[this.b];
        int i2 = 0;
        while (true) {
            i = this.b;
            if (i2 >= i) {
                break;
            }
            bArr4[i2] = bArr[i2];
            i2++;
        }
        int length = bArr2.length / i;
        for (int i3 = 0; i3 < length; i3++) {
            InterfaceC11073ch0 interfaceC11073ch0 = this.a;
            int i4 = this.b;
            interfaceC11073ch0.c(bArr2, i3 * i4, bArr3, i4 * i3);
            int i5 = 0;
            while (true) {
                int i6 = this.b;
                if (i5 >= i6) {
                    break;
                }
                bArr3[(i3 * i6) + i5] = (byte) ((bArr3[(i6 * i3) + i5] & 255) ^ (bArr4[i5] & 255));
                i5++;
            }
            int i7 = 0;
            while (true) {
                int i8 = this.b;
                if (i7 < i8) {
                    bArr4[i7] = bArr2[(i8 * i3) + i7];
                    i7++;
                }
            }
        }
    }

    private void c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i;
        int i2;
        int i3 = this.b;
        byte[] bArr4 = new byte[i3];
        byte[] bArr5 = new byte[i3];
        int i4 = 0;
        while (true) {
            i = this.b;
            if (i4 >= i) {
                break;
            }
            bArr5[i4] = bArr[i4];
            i4++;
        }
        int length = bArr2.length / i;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = 0;
            while (true) {
                i2 = this.b;
                if (i6 >= i2) {
                    break;
                }
                bArr4[i6] = (byte) ((bArr2[(i2 * i5) + i6] & 255) ^ (bArr5[i6] & 255));
                i6++;
            }
            this.a.b(bArr4, 0, bArr3, i2 * i5);
            int i7 = 0;
            while (true) {
                int i8 = this.b;
                if (i7 < i8) {
                    bArr5[i7] = bArr3[(i8 * i5) + i7];
                    i7++;
                }
            }
        }
    }

    public byte[] b(byte[] bArr, byte[] bArr2) throws IntegrityException {
        int length = bArr2.length;
        int i = this.b;
        if (length % i != 0) {
            throw new IntegrityException("Incorrect data size");
        }
        if (bArr.length != i) {
            throw new IntegrityException("Incorrect iv size");
        }
        byte[] bArr3 = new byte[bArr2.length];
        a(bArr, bArr2, bArr3);
        return bArr3;
    }

    public byte[] d(byte[] bArr, byte[] bArr2) throws IntegrityException {
        int length = bArr2.length;
        int i = this.b;
        if (length % i != 0) {
            throw new IntegrityException("Incorrect data size");
        }
        if (bArr.length != i) {
            throw new IntegrityException("Incorrect iv size");
        }
        byte[] bArr3 = new byte[bArr2.length];
        c(bArr, bArr2, bArr3);
        return bArr3;
    }
}
