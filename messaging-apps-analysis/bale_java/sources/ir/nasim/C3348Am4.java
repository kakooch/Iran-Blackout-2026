package ir.nasim;

/* renamed from: ir.nasim.Am4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3348Am4 extends AbstractC21192tG4 {
    private int f;

    public /* synthetic */ C3348Am4(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    private final int l(int i) {
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

    private final int m(Object obj) {
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
                int iL = l(i2);
                if (this.f == 0 && ((this.a[iL >> 3] >> ((iL & 7) << 3)) & 255) != 254) {
                    i();
                    iL = l(i2);
                }
                this.e++;
                int i10 = this.f;
                long[] jArr2 = this.a;
                int i11 = iL >> 3;
                long j5 = jArr2[i11];
                int i12 = (iL & 7) << 3;
                this.f = i10 - (((j5 >> i12) & 255) == 128 ? 1 : 0);
                int i13 = this.d;
                long j6 = ((~(255 << i12)) & j5) | (j2 << i12);
                jArr2[i11] = j6;
                jArr2[(((iL - 7) & i13) + (i13 & 7)) >> 3] = j6;
                return ~iL;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
            i3 = i9;
        }
    }

    private final void n() {
        this.f = AbstractC22068uc6.a(d()) - this.e;
    }

    private final void o(int i) {
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
        n();
    }

    private final void p(int i) {
        int iMax = i > 0 ? Math.max(7, AbstractC22068uc6.d(i)) : 0;
        this.d = iMax;
        o(iMax);
        this.b = new Object[iMax];
        this.c = new int[iMax];
    }

    public final void i() {
        if (this.d <= 8 || Long.compare(C14599iA7.h(C14599iA7.h(this.e) * 32) ^ Long.MIN_VALUE, C14599iA7.h(C14599iA7.h(this.d) * 25) ^ Long.MIN_VALUE) > 0) {
            t(AbstractC22068uc6.c(this.d));
        } else {
            k();
        }
    }

    public final void j() {
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
        n();
    }

    public final void k() {
        long[] jArr = this.a;
        int i = this.d;
        Object[] objArr = this.b;
        int[] iArr = this.c;
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
                int iL = l(i9);
                int i10 = i9 & i;
                if (((iL - i10) & i) / 8 == ((i6 - i10) & i) / 8) {
                    jArr[i7] = ((r8 & 127) << i8) | ((~(255 << i8)) & jArr[i7]);
                    jArr[AbstractC10242bK.k0(jArr)] = (jArr[i3] & j2) | Long.MIN_VALUE;
                } else {
                    int i11 = iL >> 3;
                    long j4 = jArr[i11];
                    int i12 = (iL & 7) << 3;
                    if (((j4 >> i12) & 255) == 128) {
                        jArr[i11] = ((~(255 << i12)) & j4) | ((r8 & 127) << i12);
                        jArr[i7] = (jArr[i7] & (~(255 << i8))) | (128 << i8);
                        objArr[iL] = objArr[i6];
                        objArr[i6] = null;
                        iArr[iL] = iArr[i6];
                        iArr[i6] = 0;
                    } else {
                        jArr[i11] = ((r8 & 127) << i12) | ((~(255 << i12)) & j4);
                        Object obj2 = objArr[iL];
                        objArr[iL] = objArr[i6];
                        objArr[i6] = obj2;
                        int i13 = iArr[iL];
                        iArr[iL] = iArr[i6];
                        iArr[i6] = i13;
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
        n();
    }

    public final int q(Object obj, int i, int i2) {
        int iM = m(obj);
        if (iM < 0) {
            iM = ~iM;
        } else {
            i2 = this.c[iM];
        }
        this.b[iM] = obj;
        this.c[iM] = i;
        return i2;
    }

    public final void r(Object obj) {
        int iB = b(obj);
        if (iB >= 0) {
            s(iB);
        }
    }

    public final void s(int i) {
        this.e--;
        long[] jArr = this.a;
        int i2 = this.d;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
        this.b[i] = null;
    }

    public final void t(int i) {
        int i2;
        long[] jArr = this.a;
        Object[] objArr = this.b;
        int[] iArr = this.c;
        int i3 = this.d;
        p(i);
        long[] jArr2 = this.a;
        Object[] objArr2 = this.b;
        int[] iArr2 = this.c;
        int i4 = this.d;
        int i5 = 0;
        while (i5 < i3) {
            if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i5];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i6 = iHashCode ^ (iHashCode << 16);
                int iL = l(i6 >>> 7);
                i2 = i5;
                long j = i6 & 127;
                int i7 = iL >> 3;
                int i8 = (iL & 7) << 3;
                long j2 = (j << i8) | (jArr2[i7] & (~(255 << i8)));
                jArr2[i7] = j2;
                jArr2[(((iL - 7) & i4) + (i4 & 7)) >> 3] = j2;
                objArr2[iL] = obj;
                iArr2[iL] = iArr[i2];
            } else {
                i2 = i5;
            }
            i5 = i2 + 1;
        }
    }

    public final void u(Object obj, int i) {
        int iM = m(obj);
        if (iM < 0) {
            iM = ~iM;
        }
        this.b[iM] = obj;
        this.c[iM] = i;
    }

    public C3348Am4(int i) {
        super(null);
        if (!(i >= 0)) {
            AbstractC22970w76.a("Capacity must be a positive value.");
        }
        p(AbstractC22068uc6.e(i));
    }
}
