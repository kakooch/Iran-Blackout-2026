package ir.nasim;

/* renamed from: ir.nasim.wZ2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23221wZ2 extends AbstractC13486gJ2 {
    private C4705Gf0 e;

    public C23221wZ2(AbstractC20633sL3 abstractC20633sL3) {
        super(abstractC20633sL3);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009a A[PHI: r5
      0x009a: PHI (r5v4 int) = (r5v3 int), (r5v7 int), (r5v7 int) binds: [B:31:0x007a, B:33:0x007e, B:34:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int[][] i(byte[] r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23221wZ2.i(byte[], int, int, int, int):int[][]");
    }

    private static void j(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, C4705Gf0 c4705Gf0) {
        int i5 = i4 - 8;
        int i6 = i3 - 8;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i7 << 3;
            int i9 = i8 > i5 ? i5 : i8;
            int iK = k(i7, 2, i2 - 3);
            for (int i10 = 0; i10 < i; i10++) {
                int i11 = i10 << 3;
                int i12 = i11 > i6 ? i6 : i11;
                int iK2 = k(i10, 2, i - 3);
                int i13 = 0;
                for (int i14 = -2; i14 <= 2; i14++) {
                    int[] iArr2 = iArr[iK + i14];
                    i13 += iArr2[iK2 - 2] + iArr2[iK2 - 1] + iArr2[iK2] + iArr2[iK2 + 1] + iArr2[iK2 + 2];
                }
                l(bArr, i12, i9, i13 / 25, i3, c4705Gf0);
            }
        }
    }

    private static int k(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static void l(byte[] bArr, int i, int i2, int i3, int i4, C4705Gf0 c4705Gf0) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    c4705Gf0.o(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    @Override // ir.nasim.AbstractC6099Me0
    public AbstractC6099Me0 a(AbstractC20633sL3 abstractC20633sL3) {
        return new C23221wZ2(abstractC20633sL3);
    }

    @Override // ir.nasim.AbstractC13486gJ2, ir.nasim.AbstractC6099Me0
    public C4705Gf0 b() {
        C4705Gf0 c4705Gf0 = this.e;
        if (c4705Gf0 != null) {
            return c4705Gf0;
        }
        AbstractC20633sL3 abstractC20633sL3E = e();
        int iD = abstractC20633sL3E.d();
        int iA = abstractC20633sL3E.a();
        if (iD < 40 || iA < 40) {
            this.e = super.b();
        } else {
            byte[] bArrB = abstractC20633sL3E.b();
            int i = iD >> 3;
            if ((iD & 7) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = iA >> 3;
            if ((iA & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] iArrI = i(bArrB, i2, i4, iD, iA);
            C4705Gf0 c4705Gf02 = new C4705Gf0(iD, iA);
            j(bArrB, i2, i4, iD, iA, iArrI, c4705Gf02);
            this.e = c4705Gf02;
        }
        return this.e;
    }
}
