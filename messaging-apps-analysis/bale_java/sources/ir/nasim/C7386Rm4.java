package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.Rm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7386Rm4 extends AbstractC21411tc6 {
    private int f;

    public /* synthetic */ C7386Rm4(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    private final int m(int i) {
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

    private final void o() {
        this.f = AbstractC22068uc6.a(f()) - this.e;
    }

    private final void p(int i) {
        long[] jArr;
        if (i == 0) {
            jArr = AbstractC22068uc6.a;
        } else {
            long[] jArr2 = new long[((i + 15) & (-8)) >> 3];
            AbstractC9648aK.x(jArr2, -9187201950435737472L, 0, 0, 6, null);
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i2] = (jArr2[i2] & (~j)) | j;
            jArr = jArr2;
        }
        this.a = jArr;
        o();
    }

    private final void q(int i) {
        int iMax = i > 0 ? Math.max(7, AbstractC22068uc6.d(i)) : 0;
        this.d = iMax;
        p(iMax);
        this.b = iMax == 0 ? AbstractC13738gk1.c : new Object[iMax];
        this.c = iMax == 0 ? AbstractC13738gk1.c : new Object[iMax];
    }

    public final void j() {
        if (this.d <= 8 || Long.compare(C14599iA7.h(C14599iA7.h(this.e) * 32) ^ Long.MIN_VALUE, C14599iA7.h(C14599iA7.h(this.d) * 25) ^ Long.MIN_VALUE) > 0) {
            w(AbstractC22068uc6.c(this.d));
        } else {
            l();
        }
    }

    public final void k() {
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
        AbstractC9648aK.v(this.b, null, 0, this.d);
        o();
    }

    public final void l() {
        int i;
        Object[] objArr;
        long[] jArr = this.a;
        int i2 = this.d;
        Object[] objArr2 = this.b;
        Object[] objArr3 = this.c;
        int i3 = (i2 + 7) >> 3;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            long j = jArr[i5] & (-9187201950435737472L);
            jArr[i5] = (-72340172838076674L) & ((~j) + (j >>> 7));
        }
        int iK0 = AbstractC10242bK.k0(jArr);
        int i6 = iK0 - 1;
        jArr[i6] = (jArr[i6] & 72057594037927935L) | (-72057594037927936L);
        jArr[iK0] = jArr[0];
        int i7 = 0;
        while (i7 != i2) {
            int i8 = i7 >> 3;
            int i9 = (i7 & 7) << 3;
            long j2 = (jArr[i8] >> i9) & 255;
            if (j2 != 128 && j2 == 254) {
                Object obj = objArr2[i7];
                int iHashCode = (obj != null ? obj.hashCode() : i4) * (-862048943);
                int i10 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                int iM = m(i10);
                int i11 = i10 & i2;
                if (((iM - i11) & i2) / 8 == ((i7 - i11) & i2) / 8) {
                    jArr[i8] = ((r8 & 127) << i9) | ((~(255 << i9)) & jArr[i8]);
                    jArr[AbstractC10242bK.k0(jArr)] = jArr[i4];
                } else {
                    int i12 = iM >> 3;
                    long j3 = jArr[i12];
                    int i13 = (iM & 7) << 3;
                    if (((j3 >> i13) & 255) == 128) {
                        i = i2;
                        objArr = objArr2;
                        jArr[i12] = ((~(255 << i13)) & j3) | ((r8 & 127) << i13);
                        jArr[i8] = (jArr[i8] & (~(255 << i9))) | (128 << i9);
                        objArr[iM] = objArr[i7];
                        objArr[i7] = null;
                        objArr3[iM] = objArr3[i7];
                        objArr3[i7] = null;
                    } else {
                        i = i2;
                        objArr = objArr2;
                        jArr[i12] = ((r8 & 127) << i13) | ((~(255 << i13)) & j3);
                        Object obj2 = objArr[iM];
                        objArr[iM] = objArr[i7];
                        objArr[i7] = obj2;
                        Object obj3 = objArr3[iM];
                        objArr3[iM] = objArr3[i7];
                        objArr3[i7] = obj3;
                        i7--;
                    }
                    jArr[AbstractC10242bK.k0(jArr)] = jArr[0];
                    i7++;
                    i4 = 0;
                    i2 = i;
                    objArr2 = objArr;
                }
            }
            i7++;
        }
        o();
    }

    public final int n(Object obj) {
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
                int iM = m(i2);
                if (this.f == 0 && ((this.a[iM >> 3] >> ((iM & 7) << 3)) & 255) != 254) {
                    j();
                    iM = m(i2);
                }
                this.e++;
                int i10 = this.f;
                long[] jArr2 = this.a;
                int i11 = iM >> 3;
                long j5 = jArr2[i11];
                int i12 = (iM & 7) << 3;
                this.f = i10 - (((j5 >> i12) & 255) == 128 ? 1 : 0);
                int i13 = this.d;
                long j6 = ((~(255 << i12)) & j5) | (j2 << i12);
                jArr2[i11] = j6;
                jArr2[(((iM - 7) & i13) + (i13 & 7)) >> 3] = j6;
                return ~iM;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
            i3 = i9;
        }
    }

    public final Object r(Object obj, Object obj2) {
        int iN = n(obj);
        if (iN < 0) {
            iN = ~iN;
        }
        Object[] objArr = this.c;
        Object obj3 = objArr[iN];
        this.b[iN] = obj;
        objArr[iN] = obj2;
        return obj3;
    }

    public final void s(AbstractC21411tc6 abstractC21411tc6) {
        AbstractC13042fc3.i(abstractC21411tc6, "from");
        Object[] objArr = abstractC21411tc6.b;
        Object[] objArr2 = abstractC21411tc6.c;
        long[] jArr = abstractC21411tc6.a;
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
                        x(objArr[i4], objArr2[i4]);
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

    public final void t(Map map) {
        AbstractC13042fc3.i(map, "from");
        for (Map.Entry entry : map.entrySet()) {
            x(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(java.lang.Object r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L8
            int r1 = r14.hashCode()
            goto L9
        L8:
            r1 = r0
        L9:
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r13.d
            int r1 = r1 >>> 7
        L16:
            r1 = r1 & r3
            long[] r4 = r13.a
            int r5 = r1 >> 3
            r6 = r1 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r2
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L43:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L62
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            java.lang.Object[] r11 = r13.b
            r11 = r11[r10]
            boolean r11 = ir.nasim.AbstractC13042fc3.d(r11, r14)
            if (r11 == 0) goto L5c
            goto L6c
        L5c:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L43
        L62:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L75
            r10 = -1
        L6c:
            if (r10 < 0) goto L73
            java.lang.Object r14 = r13.v(r10)
            return r14
        L73:
            r14 = 0
            return r14
        L75:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7386Rm4.u(java.lang.Object):java.lang.Object");
    }

    public final Object v(int i) {
        this.e--;
        long[] jArr = this.a;
        int i2 = this.d;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
        this.b[i] = null;
        Object[] objArr = this.c;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    public final void w(int i) {
        int i2;
        long[] jArr = this.a;
        Object[] objArr = this.b;
        Object[] objArr2 = this.c;
        int i3 = this.d;
        q(i);
        long[] jArr2 = this.a;
        Object[] objArr3 = this.b;
        Object[] objArr4 = this.c;
        int i4 = this.d;
        int i5 = 0;
        while (i5 < i3) {
            if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i5];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i6 = iHashCode ^ (iHashCode << 16);
                int iM = m(i6 >>> 7);
                i2 = i5;
                long j = i6 & 127;
                int i7 = iM >> 3;
                int i8 = (iM & 7) << 3;
                long j2 = (j << i8) | (jArr2[i7] & (~(255 << i8)));
                jArr2[i7] = j2;
                jArr2[(((iM - 7) & i4) + (i4 & 7)) >> 3] = j2;
                objArr3[iM] = obj;
                objArr4[iM] = objArr2[i2];
            } else {
                i2 = i5;
            }
            i5 = i2 + 1;
        }
    }

    public final void x(Object obj, Object obj2) {
        int iN = n(obj);
        if (iN < 0) {
            iN = ~iN;
        }
        this.b[iN] = obj;
        this.c[iN] = obj2;
    }

    public C7386Rm4(int i) {
        super(null);
        if (!(i >= 0)) {
            AbstractC22970w76.a("Capacity must be a positive value.");
        }
        q(AbstractC22068uc6.e(i));
    }
}
