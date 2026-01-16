package ir.nasim;

/* renamed from: ir.nasim.zm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C25126zm4 extends AbstractC20589sG4 {
    private int f;

    public /* synthetic */ C25126zm4(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    private final int j(int i) {
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

    private final int k(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i >>> 7;
        int i3 = i & 127;
        int i4 = this.d;
        int i5 = i2 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.a;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = i3;
            int i9 = i3;
            long j3 = j ^ (j2 * 72340172838076673L);
            for (long j4 = (~j3) & (j3 - 72340172838076673L) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                int iNumberOfTrailingZeros = (i5 + (Long.numberOfTrailingZeros(j4) >> 3)) & i4;
                if (AbstractC13042fc3.d(this.b[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int iJ = j(i2);
                if (this.f == 0 && ((this.a[iJ >> 3] >> ((iJ & 7) << 3)) & 255) != 254) {
                    g();
                    iJ = j(i2);
                }
                this.e++;
                int i10 = this.f;
                long[] jArr2 = this.a;
                int i11 = iJ >> 3;
                long j5 = jArr2[i11];
                int i12 = (iJ & 7) << 3;
                this.f = i10 - (((j5 >> i12) & 255) == 128 ? 1 : 0);
                int i13 = this.d;
                long j6 = ((~(255 << i12)) & j5) | (j2 << i12);
                jArr2[i11] = j6;
                jArr2[(((iJ - 7) & i13) + (i13 & 7)) >> 3] = j6;
                return ~iJ;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
            i3 = i9;
        }
    }

    private final void l() {
        this.f = AbstractC22068uc6.a(c()) - this.e;
    }

    private final void m(int i) {
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
        l();
    }

    private final void n(int i) {
        int iMax = i > 0 ? Math.max(7, AbstractC22068uc6.d(i)) : 0;
        this.d = iMax;
        m(iMax);
        this.b = new Object[iMax];
        this.c = new float[iMax];
    }

    public final void g() {
        if (this.d <= 8 || Long.compare(C14599iA7.h(C14599iA7.h(this.e) * 32) ^ Long.MIN_VALUE, C14599iA7.h(C14599iA7.h(this.d) * 25) ^ Long.MIN_VALUE) > 0) {
            p(AbstractC22068uc6.c(this.d));
        } else {
            i();
        }
    }

    public final void h() {
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
        AbstractC9648aK.v(this.b, null, 0, this.d);
        l();
    }

    public final void i() {
        long[] jArr = this.a;
        int i = this.d;
        Object[] objArr = this.b;
        float[] fArr = this.c;
        int i2 = (i + 7) >> 3;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            long j = jArr[i4] & (-9187201950435737472L);
            jArr[i4] = (-72340172838076674L) & ((~j) + (j >>> 7));
        }
        int iK0 = AbstractC10242bK.k0(jArr);
        int i5 = iK0 - 1;
        long j2 = 72057594037927935L;
        jArr[i5] = (jArr[i5] & 72057594037927935L) | (-72057594037927936L);
        jArr[iK0] = jArr[0];
        int i6 = 0;
        while (i6 != i) {
            int i7 = i6 >> 3;
            int i8 = (i6 & 7) << 3;
            long j3 = (jArr[i7] >> i8) & 255;
            if (j3 != 128 && j3 == 254) {
                Object obj = objArr[i6];
                int iHashCode = (obj != null ? obj.hashCode() : i3) * (-862048943);
                int i9 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                int iJ = j(i9);
                int i10 = i9 & i;
                if (((iJ - i10) & i) / 8 == ((i6 - i10) & i) / 8) {
                    jArr[i7] = ((r8 & 127) << i8) | ((~(255 << i8)) & jArr[i7]);
                    jArr[AbstractC10242bK.k0(jArr)] = (jArr[i3] & j2) | Long.MIN_VALUE;
                } else {
                    int i11 = iJ >> 3;
                    long j4 = jArr[i11];
                    int i12 = (iJ & 7) << 3;
                    if (((j4 >> i12) & 255) == 128) {
                        jArr[i11] = ((~(255 << i12)) & j4) | ((r8 & 127) << i12);
                        jArr[i7] = (jArr[i7] & (~(255 << i8))) | (128 << i8);
                        objArr[iJ] = objArr[i6];
                        objArr[i6] = null;
                        fArr[iJ] = fArr[i6];
                        fArr[i6] = 0.0f;
                    } else {
                        jArr[i11] = ((r8 & 127) << i12) | ((~(255 << i12)) & j4);
                        Object obj2 = objArr[iJ];
                        objArr[iJ] = objArr[i6];
                        objArr[i6] = obj2;
                        float f = fArr[iJ];
                        fArr[iJ] = fArr[i6];
                        fArr[i6] = f;
                        i6--;
                    }
                    j2 = 72057594037927935L;
                    jArr[AbstractC10242bK.k0(jArr)] = (jArr[0] & 72057594037927935L) | Long.MIN_VALUE;
                    i6++;
                    i3 = 0;
                }
            }
            i6++;
        }
        l();
    }

    public final void o(AbstractC20589sG4 abstractC20589sG4) {
        AbstractC13042fc3.i(abstractC20589sG4, "from");
        Object[] objArr = abstractC20589sG4.b;
        float[] fArr = abstractC20589sG4.c;
        long[] jArr = abstractC20589sG4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        q(objArr[i4], fArr[i4]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void p(int i) {
        int i2;
        long[] jArr = this.a;
        Object[] objArr = this.b;
        float[] fArr = this.c;
        int i3 = this.d;
        n(i);
        long[] jArr2 = this.a;
        Object[] objArr2 = this.b;
        float[] fArr2 = this.c;
        int i4 = this.d;
        int i5 = 0;
        while (i5 < i3) {
            if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i5];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i6 = iHashCode ^ (iHashCode << 16);
                int iJ = j(i6 >>> 7);
                i2 = i5;
                long j = i6 & 127;
                int i7 = iJ >> 3;
                int i8 = (iJ & 7) << 3;
                long j2 = (j << i8) | (jArr2[i7] & (~(255 << i8)));
                jArr2[i7] = j2;
                jArr2[(((iJ - 7) & i4) + (i4 & 7)) >> 3] = j2;
                objArr2[iJ] = obj;
                fArr2[iJ] = fArr[i2];
            } else {
                i2 = i5;
            }
            i5 = i2 + 1;
        }
    }

    public final void q(Object obj, float f) {
        int iK = k(obj);
        if (iK < 0) {
            iK = ~iK;
        }
        this.b[iK] = obj;
        this.c[iK] = f;
    }

    public C25126zm4(int i) {
        super(null);
        if (!(i >= 0)) {
            AbstractC22970w76.a("Capacity must be a positive value.");
        }
        n(AbstractC22068uc6.e(i));
    }
}
