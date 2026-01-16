package ir.nasim;

import java.util.Iterator;
import java.util.Set;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.Cm4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3821Cm4 extends RL4 {
    private int h;

    public /* synthetic */ C3821Cm4(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    private final int m(Object obj) {
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i >>> 7;
        int i3 = i & 127;
        int i4 = this.f;
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
                int iN = n(i2);
                if (this.h == 0 && ((this.a[iN >> 3] >> ((iN & 7) << 3)) & 255) != 254) {
                    i();
                    iN = n(i2);
                }
                this.g++;
                int i10 = this.h;
                long[] jArr2 = this.a;
                int i11 = iN >> 3;
                long j5 = jArr2[i11];
                int i12 = (iN & 7) << 3;
                this.h = i10 - (((j5 >> i12) & 255) == 128 ? 1 : 0);
                int i13 = this.f;
                long j6 = ((~(255 << i12)) & j5) | (j2 << i12);
                jArr2[i11] = j6;
                jArr2[(((iN - 7) & i13) + (i13 & 7)) >> 3] = j6;
                return iN;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
            i3 = i9;
        }
    }

    private final int n(int i) {
        int i2 = this.f;
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

    private final void o(int[] iArr) {
        long[] jArr = this.c;
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            if (i >= length) {
                break;
            }
            long j = jArr[i];
            int i3 = (int) ((j >> 31) & TTL.MAX_VALUE);
            int i4 = (int) (j & TTL.MAX_VALUE);
            long j2 = ((j & (-4611686018427387904L)) | (i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : iArr[i3])) << 31;
            if (i4 != Integer.MAX_VALUE) {
                i2 = iArr[i4];
            }
            jArr[i] = j2 | i2;
            i++;
        }
        int i5 = this.d;
        if (i5 != Integer.MAX_VALUE) {
            this.d = iArr[i5];
        }
        int i6 = this.e;
        if (i6 != Integer.MAX_VALUE) {
            this.e = iArr[i6];
        }
    }

    private final void p(long[] jArr) {
        long[] jArr2 = this.c;
        int length = jArr2.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            if (i >= length) {
                break;
            }
            long j = jArr2[i];
            int i3 = (int) ((j >> 31) & TTL.MAX_VALUE);
            int i4 = (int) (j & TTL.MAX_VALUE);
            long j2 = ((j & (-4611686018427387904L)) | (i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) (jArr[i3] & 4294967295L))) << 31;
            if (i4 != Integer.MAX_VALUE) {
                i2 = (int) (4294967295L & jArr[i4]);
            }
            jArr2[i] = i2 | j2;
            i++;
        }
        int i5 = this.d;
        if (i5 != Integer.MAX_VALUE) {
            this.d = (int) (jArr[i5] & 4294967295L);
        }
        int i6 = this.e;
        if (i6 != Integer.MAX_VALUE) {
            this.e = (int) (jArr[i6] & 4294967295L);
        }
    }

    private final void q() {
        this.h = AbstractC22068uc6.a(b()) - this.g;
    }

    private final void r(int i) {
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
        q();
    }

    private final void s(int i) {
        long[] jArrA;
        int iMax = i > 0 ? Math.max(7, AbstractC22068uc6.d(i)) : 0;
        this.f = iMax;
        r(iMax);
        this.b = iMax == 0 ? AbstractC13738gk1.c : new Object[iMax];
        if (iMax == 0) {
            jArrA = OB6.a();
        } else {
            jArrA = new long[iMax];
            AbstractC9648aK.x(jArrA, 4611686018427387903L, 0, 0, 6, null);
        }
        this.c = jArrA;
    }

    public final void A(int i) {
        long[] jArr;
        Object[] objArr;
        long[] jArr2 = this.a;
        Object[] objArr2 = this.b;
        long[] jArr3 = this.c;
        int i2 = this.f;
        int[] iArr = new int[i2];
        s(i);
        long[] jArr4 = this.a;
        Object[] objArr3 = this.b;
        long[] jArr5 = this.c;
        int i3 = this.f;
        int i4 = 0;
        while (i4 < i2) {
            if (((jArr2[i4 >> 3] >> ((i4 & 7) << 3)) & 255) < 128) {
                Object obj = objArr2[i4];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i5 = iHashCode ^ (iHashCode << 16);
                int iN = n(i5 >>> 7);
                long j = i5 & 127;
                int i6 = iN >> 3;
                int i7 = (iN & 7) << 3;
                jArr = jArr2;
                objArr = objArr2;
                long j2 = (jArr4[i6] & (~(255 << i7))) | (j << i7);
                jArr4[i6] = j2;
                jArr4[(((iN - 7) & i3) + (i3 & 7)) >> 3] = j2;
                objArr3[iN] = obj;
                jArr5[iN] = jArr3[i4];
                iArr[i4] = iN;
            } else {
                jArr = jArr2;
                objArr = objArr2;
            }
            i4++;
            jArr2 = jArr;
            objArr2 = objArr;
        }
        o(iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B(java.util.Collection r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "elements"
            ir.nasim.AbstractC13042fc3.i(r1, r2)
            java.lang.Object[] r2 = r0.b
            int r3 = r0.g
            long[] r4 = r0.a
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L57
            r7 = r6
        L16:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L52
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L30:
            if (r12 >= r10) goto L50
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L4c
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r1
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            r15 = r2[r13]
            boolean r14 = ir.nasim.ZW0.i0(r14, r15)
            if (r14 != 0) goto L4c
            r0.z(r13)
        L4c:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L30
        L50:
            if (r10 != r11) goto L57
        L52:
            if (r7 == r5) goto L57
            int r7 = r7 + 1
            goto L16
        L57:
            int r1 = r0.g
            if (r3 == r1) goto L5c
            r6 = 1
        L5c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3821Cm4.B(java.util.Collection):boolean");
    }

    public final boolean g(Object obj) {
        int iC = c();
        int iM = m(obj);
        this.b[iM] = obj;
        long[] jArr = this.c;
        int i = this.d;
        jArr[iM] = (i & TTL.MAX_VALUE) | 4611686016279904256L;
        if (i != Integer.MAX_VALUE) {
            jArr[i] = ((iM & TTL.MAX_VALUE) << 31) | (jArr[i] & (-4611686016279904257L));
        }
        this.d = iM;
        if (this.e == Integer.MAX_VALUE) {
            this.e = iM;
        }
        return c() != iC;
    }

    public final boolean h(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "elements");
        int iC = c();
        v(iterable);
        return iC != c();
    }

    public final void i() {
        if (this.f <= 8 || Long.compare(C14599iA7.h(C14599iA7.h(this.g) * 32) ^ Long.MIN_VALUE, C14599iA7.h(C14599iA7.h(this.f) * 25) ^ Long.MIN_VALUE) > 0) {
            A(AbstractC22068uc6.c(this.f));
        } else {
            l();
        }
    }

    public final Set j() {
        return new C4055Dm4(this);
    }

    public final void k() {
        this.g = 0;
        long[] jArr = this.a;
        if (jArr != AbstractC22068uc6.a) {
            AbstractC9648aK.x(jArr, -9187201950435737472L, 0, 0, 6, null);
            long[] jArr2 = this.a;
            int i = this.f;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i2] = (jArr2[i2] & (~j)) | j;
        }
        AbstractC9648aK.v(this.b, null, 0, this.f);
        AbstractC9648aK.x(this.c, 4611686018427387903L, 0, 0, 6, null);
        this.d = Integer.MAX_VALUE;
        this.e = Integer.MAX_VALUE;
        q();
    }

    public final void l() {
        long[] jArr;
        long[] jArr2;
        char c;
        long[] jArr3 = this.a;
        if (jArr3 == null) {
            return;
        }
        int i = this.f;
        Object[] objArr = this.b;
        long[] jArr4 = this.c;
        long[] jArr5 = new long[i];
        int i2 = 0;
        AbstractC9648aK.u(jArr5, 9223372034707292159L, 0, i);
        int i3 = (i + 7) >> 3;
        for (int i4 = 0; i4 < i3; i4++) {
            long j = jArr3[i4] & (-9187201950435737472L);
            jArr3[i4] = (-72340172838076674L) & ((~j) + (j >>> 7));
        }
        int iK0 = AbstractC10242bK.k0(jArr3);
        int i5 = iK0 - 1;
        jArr3[i5] = (jArr3[i5] & 72057594037927935L) | (-72057594037927936L);
        jArr3[iK0] = jArr3[0];
        int i6 = 0;
        while (i6 != i) {
            int i7 = i6 >> 3;
            int i8 = (i6 & 7) << 3;
            long j2 = (jArr3[i7] >> i8) & 255;
            if (j2 != 128 && j2 == 254) {
                Object obj = objArr[i6];
                int iHashCode = (obj != null ? obj.hashCode() : i2) * (-862048943);
                int i9 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                int iN = n(i9);
                int i10 = i9 & i;
                if (((iN - i10) & i) / 8 == ((i6 - i10) & i) / 8) {
                    jArr3[i7] = ((r11 & 127) << i8) | (jArr3[i7] & (~(255 << i8)));
                    if (jArr5[i6] == 9223372034707292159L) {
                        long j3 = i6;
                        jArr5[i6] = j3 | (j3 << 32);
                    }
                    jArr3[jArr3.length - 1] = jArr3[0];
                    i6++;
                    i2 = 0;
                } else {
                    int i11 = iN >> 3;
                    long j4 = jArr3[i11];
                    int i12 = (iN & 7) << 3;
                    if (((j4 >> i12) & 255) == 128) {
                        jArr = jArr4;
                        jArr2 = jArr5;
                        jArr3[i11] = (j4 & (~(255 << i12))) | ((r11 & 127) << i12);
                        jArr3[i7] = (jArr3[i7] & (~(255 << i8))) | (128 << i8);
                        objArr[iN] = objArr[i6];
                        objArr[i6] = null;
                        jArr[iN] = jArr[i6];
                        jArr[i6] = 4611686018427387903L;
                        int i13 = (int) ((jArr2[i6] >> 32) & 4294967295L);
                        if (i13 != Integer.MAX_VALUE) {
                            jArr2[i13] = (jArr2[i13] & (-4294967296L)) | iN;
                            jArr2[i6] = (jArr2[i6] & 4294967295L) | (-4294967296L);
                            c = ' ';
                        } else {
                            c = ' ';
                            jArr2[i6] = (Integer.MAX_VALUE << 32) | iN;
                        }
                        jArr2[iN] = Integer.MAX_VALUE | (i6 << c);
                    } else {
                        jArr = jArr4;
                        jArr2 = jArr5;
                        jArr3[i11] = ((r11 & 127) << i12) | (j4 & (~(255 << i12)));
                        Object obj2 = objArr[iN];
                        objArr[iN] = objArr[i6];
                        objArr[i6] = obj2;
                        long j5 = jArr[iN];
                        jArr[iN] = jArr[i6];
                        jArr[i6] = j5;
                        int i14 = (int) ((jArr2[i6] >> 32) & 4294967295L);
                        if (i14 != Integer.MAX_VALUE) {
                            long j6 = iN;
                            jArr2[i14] = (jArr2[i14] & (-4294967296L)) | j6;
                            jArr2[i6] = (jArr2[i6] & 4294967295L) | (j6 << 32);
                        } else {
                            long j7 = iN;
                            jArr2[i6] = j7 | (j7 << 32);
                            i14 = i6;
                        }
                        jArr2[iN] = (i14 << 32) | i6;
                        i6--;
                    }
                    jArr3[jArr3.length - 1] = jArr3[0];
                    i6++;
                    i2 = 0;
                    jArr4 = jArr;
                    jArr5 = jArr2;
                }
            } else {
                i6++;
            }
        }
        q();
        p(jArr5);
    }

    public final void t(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "elements");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            u(it.next());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(java.lang.Object r14) {
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
            int r3 = r13.f
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
            if (r4 == 0) goto L72
            r10 = -1
        L6c:
            if (r10 < 0) goto L71
            r13.z(r10)
        L71:
            return
        L72:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3821Cm4.u(java.lang.Object):void");
    }

    public final void v(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "elements");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            w(it.next());
        }
    }

    public final void w(Object obj) {
        int iM = m(obj);
        this.b[iM] = obj;
        long[] jArr = this.c;
        int i = this.d;
        jArr[iM] = (i & TTL.MAX_VALUE) | 4611686016279904256L;
        if (i != Integer.MAX_VALUE) {
            jArr[i] = ((iM & TTL.MAX_VALUE) << 31) | (jArr[i] & (-4611686016279904257L));
        }
        this.d = iM;
        if (this.e == Integer.MAX_VALUE) {
            this.e = iM;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0070, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            int r3 = r18.hashCode()
            goto Ld
        Lc:
            r3 = r2
        Ld:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0.f
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.a
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L48:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L67
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.b
            r15 = r15[r11]
            boolean r15 = ir.nasim.AbstractC13042fc3.d(r15, r1)
            if (r15 == 0) goto L61
            goto L71
        L61:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L48
        L67:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L7a
            r11 = -1
        L71:
            if (r11 < 0) goto L74
            r2 = r12
        L74:
            if (r2 == 0) goto L79
            r0.z(r11)
        L79:
            return r2
        L7a:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3821Cm4.x(java.lang.Object):boolean");
    }

    public final boolean y(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "elements");
        int iC = c();
        t(iterable);
        return iC != c();
    }

    public final void z(int i) {
        this.g--;
        long[] jArr = this.a;
        int i2 = this.f;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
        this.b[i] = null;
        long[] jArr2 = this.c;
        long j2 = jArr2[i];
        int i5 = (int) ((j2 >> 31) & TTL.MAX_VALUE);
        int i6 = (int) (j2 & TTL.MAX_VALUE);
        if (i5 != Integer.MAX_VALUE) {
            jArr2[i5] = (jArr2[i5] & (-2147483648L)) | (i6 & TTL.MAX_VALUE);
        } else {
            this.d = i6;
        }
        if (i6 != Integer.MAX_VALUE) {
            jArr2[i6] = ((i5 & TTL.MAX_VALUE) << 31) | (jArr2[i6] & (-4611686016279904257L));
        } else {
            this.e = i5;
        }
        jArr2[i] = 4611686018427387903L;
    }

    public C3821Cm4(int i) {
        super(null);
        if (!(i >= 0)) {
            AbstractC22970w76.a("Capacity must be a positive value.");
        }
        s(AbstractC22068uc6.e(i));
    }
}
