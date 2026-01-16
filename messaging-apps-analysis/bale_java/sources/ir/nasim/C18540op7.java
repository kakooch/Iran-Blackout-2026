package ir.nasim;

import ir.nasim.C22045ua3;

/* renamed from: ir.nasim.op7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18540op7 {
    private final C16734lm4 a = AbstractC21388ta3.c();
    private long b = -1;
    private long c;
    private long d;
    private float[] e;

    public C18540op7() {
        C22045ua3.a aVar = C22045ua3.b;
        this.c = aVar.b();
        this.d = aVar.b();
    }

    public final void b(long j) {
        C16734lm4 c16734lm4 = this.a;
        Object[] objArr = c16734lm4.c;
        long[] jArr = c16734lm4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j2 = jArr[i];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j2) < 128) {
                        AbstractC18350oW3.a(objArr[(i << 3) + i3]);
                    }
                    j2 >>= 8;
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

    public final void c(int i, long j, long j2, long j3) {
        AbstractC18350oW3.a(this.a.b(i));
    }

    public final long d() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(long r13) {
        /*
            r12 = this;
            long r0 = r12.b
            int r13 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r13 <= 0) goto L7
            return
        L7:
            ir.nasim.lm4 r13 = r12.a
            java.lang.Object[] r14 = r13.c
            long[] r13 = r13.a
            int r0 = r13.length
            int r0 = r0 + (-2)
            if (r0 < 0) goto L4c
            r1 = 0
            r2 = r1
        L14:
            r3 = r13[r2]
            long r5 = ~r3
            r7 = 7
            long r5 = r5 << r7
            long r5 = r5 & r3
            r7 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r5 = r5 & r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L47
            int r5 = r2 - r0
            int r5 = ~r5
            int r5 = r5 >>> 31
            r6 = 8
            int r5 = 8 - r5
            r7 = r1
        L2e:
            if (r7 >= r5) goto L45
            r8 = 255(0xff, double:1.26E-321)
            long r8 = r8 & r3
            r10 = 128(0x80, double:6.3E-322)
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 >= 0) goto L41
            int r8 = r2 << 3
            int r8 = r8 + r7
            r8 = r14[r8]
            ir.nasim.AbstractC18350oW3.a(r8)
        L41:
            long r3 = r3 >> r6
            int r7 = r7 + 1
            goto L2e
        L45:
            if (r5 != r6) goto L4c
        L47:
            if (r2 == r0) goto L4c
            int r2 = r2 + 1
            goto L14
        L4c:
            r13 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r0 = (r13 > r13 ? 1 : (r13 == r13 ? 0 : -1))
            if (r0 != 0) goto L57
            r13 = -1
        L57:
            r12.b = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18540op7.e(long):void");
    }

    public final boolean f(long j, long j2, float[] fArr) {
        boolean z;
        if (C22045ua3.j(j2, this.c)) {
            z = false;
        } else {
            this.c = j2;
            z = true;
        }
        if (!C22045ua3.j(j, this.d)) {
            this.d = j;
            z = true;
        }
        if (fArr == null) {
            return z;
        }
        this.e = fArr;
        return true;
    }

    public final void a(long j) {
    }
}
