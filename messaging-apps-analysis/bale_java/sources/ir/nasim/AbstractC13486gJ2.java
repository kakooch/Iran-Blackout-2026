package ir.nasim;

import com.google.zxing.NotFoundException;

/* renamed from: ir.nasim.gJ2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC13486gJ2 extends AbstractC6099Me0 {
    private static final byte[] d = new byte[0];
    private byte[] b;
    private final int[] c;

    public AbstractC13486gJ2(AbstractC20633sL3 abstractC20633sL3) {
        super(abstractC20633sL3);
        this.b = d;
        this.c = new int[32];
    }

    private static int g(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            if (i5 > i) {
                i3 = i4;
                i = i5;
            }
            if (i5 > i2) {
                i2 = i5;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i3;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i3 <= i6) {
            int i11 = i3;
            i3 = i6;
            i6 = i11;
        }
        if (i3 - i6 <= length / 16) {
            throw NotFoundException.a();
        }
        int i12 = i3 - 1;
        int i13 = -1;
        int i14 = i12;
        while (i12 > i6) {
            int i15 = i12 - i6;
            int i16 = i15 * i15 * (i3 - i12) * (i2 - iArr[i12]);
            if (i16 > i13) {
                i14 = i12;
                i13 = i16;
            }
            i12--;
        }
        return i14 << 3;
    }

    private void h(int i) {
        if (this.b.length < i) {
            this.b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.c[i2] = 0;
        }
    }

    @Override // ir.nasim.AbstractC6099Me0
    public C4705Gf0 b() throws NotFoundException {
        AbstractC20633sL3 abstractC20633sL3E = e();
        int iD = abstractC20633sL3E.d();
        int iA = abstractC20633sL3E.a();
        C4705Gf0 c4705Gf0 = new C4705Gf0(iD, iA);
        h(iD);
        int[] iArr = this.c;
        for (int i = 1; i < 5; i++) {
            byte[] bArrC = abstractC20633sL3E.c((iA * i) / 5, this.b);
            int i2 = (iD << 2) / 5;
            for (int i3 = iD / 5; i3 < i2; i3++) {
                int i4 = (bArrC[i3] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int iG = g(iArr);
        byte[] bArrB = abstractC20633sL3E.b();
        for (int i5 = 0; i5 < iA; i5++) {
            int i6 = i5 * iD;
            for (int i7 = 0; i7 < iD; i7++) {
                if ((bArrB[i6 + i7] & 255) < iG) {
                    c4705Gf0.o(i7, i5);
                }
            }
        }
        return c4705Gf0;
    }

    @Override // ir.nasim.AbstractC6099Me0
    public C3988Df0 c(int i, C3988Df0 c3988Df0) throws NotFoundException {
        AbstractC20633sL3 abstractC20633sL3E = e();
        int iD = abstractC20633sL3E.d();
        if (c3988Df0 == null || c3988Df0.n() < iD) {
            c3988Df0 = new C3988Df0(iD);
        } else {
            c3988Df0.e();
        }
        h(iD);
        byte[] bArrC = abstractC20633sL3E.c(i, this.b);
        int[] iArr = this.c;
        for (int i2 = 0; i2 < iD; i2++) {
            int i3 = (bArrC[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int iG = g(iArr);
        if (iD < 3) {
            for (int i4 = 0; i4 < iD; i4++) {
                if ((bArrC[i4] & 255) < iG) {
                    c3988Df0.s(i4);
                }
            }
        } else {
            int i5 = 1;
            int i6 = bArrC[0] & 255;
            int i7 = bArrC[1] & 255;
            while (i5 < iD - 1) {
                int i8 = i5 + 1;
                int i9 = bArrC[i8] & 255;
                if ((((i7 << 2) - i6) - i9) / 2 < iG) {
                    c3988Df0.s(i5);
                }
                i6 = i7;
                i5 = i8;
                i7 = i9;
            }
        }
        return c3988Df0;
    }
}
