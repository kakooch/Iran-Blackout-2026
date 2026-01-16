package ir.nasim;

/* renamed from: ir.nasim.jm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15552jm4 extends AbstractC17204ma3 {
    private int f;

    public C15552jm4(int i) {
        super(null);
        if (!(i >= 0)) {
            AbstractC22970w76.a("Capacity must be a positive value.");
        }
        o(AbstractC22068uc6.e(i));
    }

    private final int k(int i) {
        int i2 = this.d;
        int i3 = i & i2;
        int i4 = 0;
        while (true) {
            long[] jArr = this.a;
            int i5 = i3 >> 3;
            int i6 = (i3 & 7) << 3;
            long j = ((jArr[i5 + 1] << (64 - i6)) & ((-i6) >> 63)) | (jArr[i5] >>> i6);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i3 + (Long.numberOfTrailingZeros(j2) >> 3)) & i2;
            }
            i4 += 8;
            i3 = (i3 + i4) & i2;
        }
    }

    private final int l(int i) {
        int iHashCode = Integer.hashCode(i) * (-862048943);
        int i2 = iHashCode ^ (iHashCode << 16);
        int i3 = i2 >>> 7;
        int i4 = i2 & 127;
        int i5 = this.d;
        int i6 = i3 & i5;
        int i7 = 0;
        while (true) {
            long[] jArr = this.a;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = i4;
            int i10 = i7;
            long j3 = j ^ (j2 * 72340172838076673L);
            for (long j4 = (~j3) & (j3 - 72340172838076673L) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i6) & i5;
                if (this.b[iNumberOfTrailingZeros] == i) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int iK = k(i3);
                if (this.f == 0 && ((this.a[iK >> 3] >> ((iK & 7) << 3)) & 255) != 254) {
                    h();
                    iK = k(i3);
                }
                this.e++;
                int i11 = this.f;
                long[] jArr2 = this.a;
                int i12 = iK >> 3;
                long j5 = jArr2[i12];
                int i13 = (iK & 7) << 3;
                this.f = i11 - (((j5 >> i13) & 255) == 128 ? 1 : 0);
                int i14 = this.d;
                long j6 = ((~(255 << i13)) & j5) | (j2 << i13);
                jArr2[i12] = j6;
                jArr2[(((iK - 7) & i14) + (i14 & 7)) >> 3] = j6;
                return ~iK;
            }
            i7 = i10 + 8;
            i6 = (i6 + i7) & i5;
        }
    }

    private final void m() {
        this.f = AbstractC22068uc6.a(d()) - this.e;
    }

    private final void n(int i) {
        long[] jArr;
        if (i == 0) {
            jArr = AbstractC22068uc6.a;
        } else {
            jArr = new long[((i + 15) & (-8)) >> 3];
            AbstractC9648aK.x(jArr, -9187201950435737472L, 0, 0, 6, null);
        }
        this.a = jArr;
        int i2 = i >> 3;
        long j = 255 << ((i & 7) << 3);
        jArr[i2] = (jArr[i2] & (~j)) | j;
        m();
    }

    private final void o(int i) {
        int iMax = i > 0 ? Math.max(7, AbstractC22068uc6.d(i)) : 0;
        this.d = iMax;
        n(iMax);
        this.b = new int[iMax];
        this.c = new int[iMax];
    }

    public final void h() {
        if (this.d <= 8 || Long.compare(C14599iA7.h(C14599iA7.h(this.e) * 32) ^ Long.MIN_VALUE, C14599iA7.h(C14599iA7.h(this.d) * 25) ^ Long.MIN_VALUE) > 0) {
            p(AbstractC22068uc6.c(this.d));
        } else {
            j();
        }
    }

    public final void i() {
        this.e = 0;
        long[] jArr = this.a;
        if (jArr != AbstractC22068uc6.a) {
            AbstractC9648aK.x(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.a;
            int i = this.d;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i2] = (jArr2[i2] & (~j)) | j;
        }
        m();
    }

    public final void j() {
        long[] jArr = this.a;
        int i = this.d;
        int[] iArr = this.b;
        int[] iArr2 = this.c;
        int i2 = (i + 7) >> 3;
        char c = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = jArr[i3] & (-9187201950435737472L);
            jArr[i3] = (-72340172838076674L) & ((~j) + (j >>> 7));
        }
        int iK0 = AbstractC10242bK.k0(jArr);
        int i4 = iK0 - 1;
        long j2 = 72057594037927935L;
        jArr[i4] = (jArr[i4] & 72057594037927935L) | (-72057594037927936L);
        jArr[iK0] = jArr[0];
        int i5 = 0;
        while (i5 != i) {
            int i6 = i5 >> 3;
            int i7 = (i5 & 7) << 3;
            long j3 = (jArr[i6] >> i7) & 255;
            if (j3 != 128 && j3 == 254) {
                int iHashCode = Integer.hashCode(iArr[i5]) * (-862048943);
                int i8 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                int iK = k(i8);
                int i9 = i8 & i;
                if (((iK - i9) & i) / 8 == ((i5 - i9) & i) / 8) {
                    jArr[i6] = ((r8 & 127) << i7) | ((~(255 << i7)) & jArr[i6]);
                    jArr[AbstractC10242bK.k0(jArr)] = (jArr[c] & j2) | Long.MIN_VALUE;
                } else {
                    int i10 = iK >> 3;
                    long j4 = jArr[i10];
                    int i11 = (iK & 7) << 3;
                    if (((j4 >> i11) & 255) == 128) {
                        jArr[i10] = ((~(255 << i11)) & j4) | ((r8 & 127) << i11);
                        jArr[i6] = (jArr[i6] & (~(255 << i7))) | (128 << i7);
                        iArr[iK] = iArr[i5];
                        iArr[i5] = 0;
                        iArr2[iK] = iArr2[i5];
                        iArr2[i5] = 0;
                    } else {
                        jArr[i10] = ((r8 & 127) << i11) | ((~(255 << i11)) & j4);
                        int i12 = iArr[iK];
                        iArr[iK] = iArr[i5];
                        iArr[i5] = i12;
                        int i13 = iArr2[iK];
                        iArr2[iK] = iArr2[i5];
                        iArr2[i5] = i13;
                        i5--;
                    }
                    j2 = 72057594037927935L;
                    jArr[AbstractC10242bK.k0(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                    i5++;
                    c = 0;
                }
            }
            i5++;
        }
        m();
    }

    public final void p(int i) {
        long[] jArr;
        C15552jm4 c15552jm4 = this;
        long[] jArr2 = c15552jm4.a;
        int[] iArr = c15552jm4.b;
        int[] iArr2 = c15552jm4.c;
        int i2 = c15552jm4.d;
        o(i);
        long[] jArr3 = c15552jm4.a;
        int[] iArr3 = c15552jm4.b;
        int[] iArr4 = c15552jm4.c;
        int i3 = c15552jm4.d;
        int i4 = 0;
        while (i4 < i2) {
            if (((jArr2[i4 >> 3] >> ((i4 & 7) << 3)) & 255) < 128) {
                int i5 = iArr[i4];
                int iHashCode = Integer.hashCode(i5) * (-862048943);
                int i6 = iHashCode ^ (iHashCode << 16);
                int iK = c15552jm4.k(i6 >>> 7);
                long j = i6 & 127;
                int i7 = iK >> 3;
                int i8 = (iK & 7) << 3;
                jArr = jArr2;
                long j2 = (jArr3[i7] & (~(255 << i8))) | (j << i8);
                jArr3[i7] = j2;
                jArr3[(((iK - 7) & i3) + (i3 & 7)) >> 3] = j2;
                iArr3[iK] = i5;
                iArr4[iK] = iArr2[i4];
            } else {
                jArr = jArr2;
            }
            i4++;
            c15552jm4 = this;
            jArr2 = jArr;
        }
    }

    public final void q(int i, int i2) {
        int iL = l(i);
        if (iL < 0) {
            iL = ~iL;
        }
        this.b[iL] = i;
        this.c[iL] = i2;
    }

    public /* synthetic */ C15552jm4(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 6 : i);
    }
}
