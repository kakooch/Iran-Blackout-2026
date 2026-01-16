package ir.nasim;

/* renamed from: ir.nasim.vm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22756vm4 extends AbstractC20615sJ3 {
    private int e;

    public C22756vm4(int i) {
        super(null);
        if (!(i >= 0)) {
            AbstractC22970w76.a("Capacity must be a positive value.");
        }
        k(AbstractC22068uc6.e(i));
    }

    private final int g(long j) {
        int iHashCode = Long.hashCode(j) * (-862048943);
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i >>> 7;
        int i3 = i & 127;
        int i4 = this.c;
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
                int iH = h(i2);
                if (this.e == 0 && ((this.a[iH >> 3] >> ((iH & 7) << 3)) & 255) != 254) {
                    e();
                    iH = h(i2);
                }
                this.d++;
                int i10 = this.e;
                long[] jArr2 = this.a;
                int i11 = iH >> 3;
                long j6 = jArr2[i11];
                int i12 = (iH & 7) << 3;
                this.e = i10 - (((j6 >> i12) & 255) == 128 ? 1 : 0);
                int i13 = this.c;
                long j7 = ((~(255 << i12)) & j6) | (j3 << i12);
                jArr2[i11] = j7;
                jArr2[(((iH - 7) & i13) + (i13 & 7)) >> 3] = j7;
                return iH;
            }
            i6 = i9 + 8;
            i5 = (i5 + i6) & i4;
        }
    }

    private final int h(int i) {
        int i2 = this.c;
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

    private final void i() {
        this.e = AbstractC22068uc6.a(b()) - this.d;
    }

    private final void j(int i) {
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
        i();
    }

    private final void k(int i) {
        int iMax = i > 0 ? Math.max(7, AbstractC22068uc6.d(i)) : 0;
        this.c = iMax;
        j(iMax);
        this.b = new long[iMax];
    }

    private final void n(int i) {
        this.d--;
        long[] jArr = this.a;
        int i2 = this.c;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
    }

    public final void e() {
        if (this.c <= 8 || Long.compare(C14599iA7.h(C14599iA7.h(this.d) * 32) ^ Long.MIN_VALUE, C14599iA7.h(C14599iA7.h(this.c) * 25) ^ Long.MIN_VALUE) > 0) {
            o(AbstractC22068uc6.c(this.c));
        } else {
            f();
        }
    }

    public final void f() {
        long[] jArr = this.a;
        int i = this.c;
        long[] jArr2 = this.b;
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
                int iH = h(i8);
                int i9 = i8 & i;
                if (((iH - i9) & i) / 8 == ((i5 - i9) & i) / 8) {
                    jArr[i6] = ((r7 & 127) << i7) | ((~(255 << i7)) & jArr[i6]);
                    jArr[AbstractC10242bK.k0(jArr)] = (jArr[c] & j2) | Long.MIN_VALUE;
                } else {
                    int i10 = iH >> 3;
                    long j4 = jArr[i10];
                    int i11 = (iH & 7) << 3;
                    if (((j4 >> i11) & 255) == 128) {
                        jArr[i10] = ((~(255 << i11)) & j4) | ((r7 & 127) << i11);
                        jArr[i6] = (jArr[i6] & (~(255 << i7))) | (128 << i7);
                        jArr2[iH] = jArr2[i5];
                        jArr2[i5] = 0;
                    } else {
                        jArr[i10] = ((r7 & 127) << i11) | ((~(255 << i11)) & j4);
                        long j5 = jArr2[iH];
                        jArr2[iH] = jArr2[i5];
                        jArr2[i5] = j5;
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
        i();
    }

    public final void l(long j) {
        this.b[g(j)] = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(long r18) {
        /*
            r17 = this;
            r0 = r17
            int r1 = java.lang.Long.hashCode(r18)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0.c
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
            r5 = r4
        L16:
            long[] r6 = r0.a
            int r7 = r1 >> 3
            r8 = r1 & 7
            int r8 = r8 << 3
            r9 = r6[r7]
            long r9 = r9 >>> r8
            r11 = 1
            int r7 = r7 + r11
            r12 = r6[r7]
            int r6 = 64 - r8
            long r6 = r12 << r6
            long r12 = (long) r8
            long r12 = -r12
            r8 = 63
            long r12 = r12 >> r8
            long r6 = r6 & r12
            long r6 = r6 | r9
            long r8 = (long) r2
            r12 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r12
            long r8 = r8 ^ r6
            long r12 = r8 - r12
            long r8 = ~r8
            long r8 = r8 & r12
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r12
        L42:
            r14 = 0
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 == 0) goto L5f
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            long[] r14 = r0.b
            r15 = r14[r10]
            int r14 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r14 != 0) goto L59
            goto L69
        L59:
            r14 = 1
            long r14 = r8 - r14
            long r8 = r8 & r14
            goto L42
        L5f:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 == 0) goto L72
            r10 = -1
        L69:
            if (r10 < 0) goto L6c
            r4 = r11
        L6c:
            if (r4 == 0) goto L71
            r0.n(r10)
        L71:
            return r4
        L72:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22756vm4.m(long):boolean");
    }

    public final void o(int i) {
        long[] jArr = this.a;
        long[] jArr2 = this.b;
        int i2 = this.c;
        k(i);
        long[] jArr3 = this.a;
        long[] jArr4 = this.b;
        int i3 = this.c;
        for (int i4 = 0; i4 < i2; i4++) {
            if (((jArr[i4 >> 3] >> ((i4 & 7) << 3)) & 255) < 128) {
                long j = jArr2[i4];
                int iHashCode = Long.hashCode(j) * (-862048943);
                int i5 = iHashCode ^ (iHashCode << 16);
                int iH = h(i5 >>> 7);
                long j2 = i5 & 127;
                int i6 = iH >> 3;
                int i7 = (iH & 7) << 3;
                long j3 = (jArr3[i6] & (~(255 << i7))) | (j2 << i7);
                jArr3[i6] = j3;
                jArr3[(((iH - 7) & i3) + (i3 & 7)) >> 3] = j3;
                jArr4[iH] = j;
            }
        }
    }
}
