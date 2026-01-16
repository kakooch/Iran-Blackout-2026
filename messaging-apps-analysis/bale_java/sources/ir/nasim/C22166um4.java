package ir.nasim;

/* renamed from: ir.nasim.um4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22166um4 extends AbstractC14078hJ3 {
    private int f;

    public /* synthetic */ C22166um4(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    private final int i(long j) {
        int iHashCode = Long.hashCode(j) * (-862048943);
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
            long j2 = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j3 = i3;
            int i9 = i6;
            long j4 = j2 ^ (j3 * 72340172838076673L);
            for (long j5 = (~j4) & (j4 - 72340172838076673L) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j5) >> 3) + i5) & i4;
                if (this.b[iNumberOfTrailingZeros] == j) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j2) << 6) & j2 & (-9187201950435737472L)) != 0) {
                int iJ = j(i2);
                if (this.f == 0 && ((this.a[iJ >> 3] >> ((iJ & 7) << 3)) & 255) != 254) {
                    f();
                    iJ = j(i2);
                }
                this.e++;
                int i10 = this.f;
                long[] jArr2 = this.a;
                int i11 = iJ >> 3;
                long j6 = jArr2[i11];
                int i12 = (iJ & 7) << 3;
                this.f = i10 - (((j6 >> i12) & 255) == 128 ? 1 : 0);
                int i13 = this.d;
                long j7 = ((~(255 << i12)) & j6) | (j3 << i12);
                jArr2[i11] = j7;
                jArr2[(((iJ - 7) & i13) + (i13 & 7)) >> 3] = j7;
                return iJ;
            }
            i6 = i9 + 8;
            i5 = (i5 + i6) & i4;
        }
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

    private final void k() {
        this.f = AbstractC22068uc6.a(c()) - this.e;
    }

    private final void l(int i) {
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
        k();
    }

    private final void m(int i) {
        int iMax = i > 0 ? Math.max(7, AbstractC22068uc6.d(i)) : 0;
        this.d = iMax;
        l(iMax);
        this.b = new long[iMax];
        this.c = new Object[iMax];
    }

    public final void f() {
        if (this.d <= 8 || Long.compare(C14599iA7.h(C14599iA7.h(this.e) * 32) ^ Long.MIN_VALUE, C14599iA7.h(C14599iA7.h(this.d) * 25) ^ Long.MIN_VALUE) > 0) {
            p(AbstractC22068uc6.c(this.d));
        } else {
            h();
        }
    }

    public final void g() {
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
        AbstractC9648aK.v(this.c, null, 0, this.d);
        k();
    }

    public final void h() {
        long[] jArr = this.a;
        int i = this.d;
        long[] jArr2 = this.b;
        Object[] objArr = this.c;
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
                int iHashCode = Long.hashCode(jArr2[i5]) * (-862048943);
                int i8 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                int iJ = j(i8);
                int i9 = i8 & i;
                if (((iJ - i9) & i) / 8 == ((i5 - i9) & i) / 8) {
                    jArr[i6] = ((r8 & 127) << i7) | ((~(255 << i7)) & jArr[i6]);
                    jArr[AbstractC10242bK.k0(jArr)] = (jArr[c] & j2) | Long.MIN_VALUE;
                } else {
                    int i10 = iJ >> 3;
                    long j4 = jArr[i10];
                    int i11 = (iJ & 7) << 3;
                    if (((j4 >> i11) & 255) == 128) {
                        jArr[i10] = ((~(255 << i11)) & j4) | ((r8 & 127) << i11);
                        jArr[i6] = (jArr[i6] & (~(255 << i7))) | (128 << i7);
                        jArr2[iJ] = jArr2[i5];
                        jArr2[i5] = 0;
                        objArr[iJ] = objArr[i5];
                        objArr[i5] = null;
                    } else {
                        jArr[i10] = ((r8 & 127) << i11) | ((~(255 << i11)) & j4);
                        long j5 = jArr2[iJ];
                        jArr2[iJ] = jArr2[i5];
                        jArr2[i5] = j5;
                        Object obj = objArr[iJ];
                        objArr[iJ] = objArr[i5];
                        objArr[i5] = obj;
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
        k();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0064, code lost:
    
        if (((r5 & ((~r5) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0066, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(long r16) {
        /*
            r15 = this;
            r0 = r15
            int r1 = java.lang.Long.hashCode(r16)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0.d
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
        L14:
            long[] r5 = r0.a
            int r6 = r1 >> 3
            r7 = r1 & 7
            int r7 = r7 << 3
            r8 = r5[r6]
            long r8 = r8 >>> r7
            int r6 = r6 + 1
            r10 = r5[r6]
            int r5 = 64 - r7
            long r5 = r10 << r5
            long r10 = (long) r7
            long r10 = -r10
            r7 = 63
            long r10 = r10 >> r7
            long r5 = r5 & r10
            long r5 = r5 | r8
            long r7 = (long) r2
            r9 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r7 = r7 * r9
            long r7 = r7 ^ r5
            long r9 = r7 - r9
            long r7 = ~r7
            long r7 = r7 & r9
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
        L40:
            r11 = 0
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 == 0) goto L5d
            int r11 = java.lang.Long.numberOfTrailingZeros(r7)
            int r11 = r11 >> 3
            int r11 = r11 + r1
            r11 = r11 & r3
            long[] r12 = r0.b
            r13 = r12[r11]
            int r12 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r12 != 0) goto L57
            goto L67
        L57:
            r11 = 1
            long r11 = r7 - r11
            long r7 = r7 & r11
            goto L40
        L5d:
            long r7 = ~r5
            r13 = 6
            long r7 = r7 << r13
            long r5 = r5 & r7
            long r5 = r5 & r9
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 == 0) goto L70
            r11 = -1
        L67:
            if (r11 < 0) goto L6e
            java.lang.Object r1 = r15.o(r11)
            return r1
        L6e:
            r1 = 0
            return r1
        L70:
            int r4 = r4 + 8
            int r1 = r1 + r4
            r1 = r1 & r3
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22166um4.n(long):java.lang.Object");
    }

    public final Object o(int i) {
        this.e--;
        long[] jArr = this.a;
        int i2 = this.d;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
        Object[] objArr = this.c;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    public final void p(int i) {
        long[] jArr;
        C22166um4 c22166um4 = this;
        long[] jArr2 = c22166um4.a;
        long[] jArr3 = c22166um4.b;
        Object[] objArr = c22166um4.c;
        int i2 = c22166um4.d;
        m(i);
        long[] jArr4 = c22166um4.a;
        long[] jArr5 = c22166um4.b;
        Object[] objArr2 = c22166um4.c;
        int i3 = c22166um4.d;
        int i4 = 0;
        while (i4 < i2) {
            if (((jArr2[i4 >> 3] >> ((i4 & 7) << 3)) & 255) < 128) {
                long j = jArr3[i4];
                int iHashCode = Long.hashCode(j) * (-862048943);
                int i5 = iHashCode ^ (iHashCode << 16);
                int iJ = c22166um4.j(i5 >>> 7);
                long j2 = i5 & 127;
                int i6 = iJ >> 3;
                int i7 = (iJ & 7) << 3;
                jArr = jArr2;
                long j3 = (jArr4[i6] & (~(255 << i7))) | (j2 << i7);
                jArr4[i6] = j3;
                jArr4[(((iJ - 7) & i3) + (i3 & 7)) >> 3] = j3;
                jArr5[iJ] = j;
                objArr2[iJ] = objArr[i4];
            } else {
                jArr = jArr2;
            }
            i4++;
            c22166um4 = this;
            jArr2 = jArr;
        }
    }

    public final void q(long j, Object obj) {
        int i = i(j);
        this.b[i] = j;
        this.c[i] = obj;
    }

    public C22166um4(int i) {
        super(null);
        if (!(i >= 0)) {
            AbstractC22970w76.a("Capacity must be a positive value.");
        }
        m(AbstractC22068uc6.e(i));
    }
}
