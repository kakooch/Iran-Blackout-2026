package ir.nasim;

import java.util.List;

/* loaded from: classes.dex */
public final class PJ5 implements InterfaceC20208rd6, OJ5 {
    public static final a h = new a(null);
    public static final int i = 8;
    private int a;
    private RJ5 b;
    private C6669Om c;
    private InterfaceC14603iB2 d;
    private int e;
    private C3348Am4 f;
    private C7386Rm4 g;

    public static final class a {
        private a() {
        }

        public final void a(C24216yE6 c24216yE6, List list, RJ5 rj5) {
            List list2 = list;
            if (!list2.isEmpty()) {
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    Object objW0 = c24216yE6.W0((C6669Om) list.get(i), 0);
                    PJ5 pj5 = objW0 instanceof PJ5 ? (PJ5) objW0 : null;
                    if (pj5 != null) {
                        pj5.e(rj5);
                    }
                }
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int f;
        final /* synthetic */ C3348Am4 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, C3348Am4 c3348Am4) {
            super(1);
            this.f = i;
            this.g = c3348Am4;
        }

        public final void a(InterfaceC6806Pb1 interfaceC6806Pb1) {
            int i;
            if (PJ5.this.e != this.f || !AbstractC13042fc3.d(this.g, PJ5.this.f) || !(interfaceC6806Pb1 instanceof C8225Vb1)) {
                return;
            }
            C3348Am4 c3348Am4 = this.g;
            int i2 = this.f;
            PJ5 pj5 = PJ5.this;
            long[] jArr = c3348Am4.a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                long j = jArr[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8;
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((255 & j) < 128) {
                            int i7 = (i3 << 3) + i6;
                            Object obj = c3348Am4.b[i7];
                            boolean z = c3348Am4.c[i7] != i2;
                            if (z) {
                                C8225Vb1 c8225Vb1 = (C8225Vb1) interfaceC6806Pb1;
                                c8225Vb1.M(obj, pj5);
                                if (obj instanceof InterfaceC19404qI1) {
                                    c8225Vb1.L((InterfaceC19404qI1) obj);
                                    C7386Rm4 c7386Rm4 = pj5.g;
                                    if (c7386Rm4 != null) {
                                        c7386Rm4.u(obj);
                                    }
                                }
                            }
                            if (z) {
                                c3348Am4.s(i7);
                            }
                            i = 8;
                        } else {
                            i = i4;
                        }
                        j >>= i;
                        i6++;
                        i4 = i;
                    }
                    if (i5 != i4) {
                        return;
                    }
                }
                if (i3 == length) {
                    return;
                } else {
                    i3++;
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC6806Pb1) obj);
            return C19938rB7.a;
        }
    }

    public PJ5(RJ5 rj5) {
        this.b = rj5;
    }

    private final void J(boolean z) {
        if (z) {
            this.a |= 32;
        } else {
            this.a &= -33;
        }
    }

    private final void L(boolean z) {
        if (z) {
            this.a |= 16;
        } else {
            this.a &= -17;
        }
    }

    private final boolean f(InterfaceC19404qI1 interfaceC19404qI1, C7386Rm4 c7386Rm4) {
        AbstractC13042fc3.g(interfaceC19404qI1, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        ZG6 zg6C = interfaceC19404qI1.c();
        if (zg6C == null) {
            zg6C = AbstractC10222bH6.s();
        }
        return !zg6C.b(interfaceC19404qI1.y().a(), c7386Rm4.e(interfaceC19404qI1));
    }

    private final boolean p() {
        return (this.a & 32) != 0;
    }

    public final void A() {
        RJ5 rj5 = this.b;
        if (rj5 != null) {
            rj5.c(this);
        }
        this.b = null;
        this.f = null;
        this.g = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B() {
        /*
            r17 = this;
            r1 = r17
            ir.nasim.RJ5 r0 = r1.b
            if (r0 == 0) goto L60
            ir.nasim.Am4 r2 = r1.f
            if (r2 == 0) goto L60
            r3 = 1
            r1.J(r3)
            r3 = 0
            java.lang.Object[] r4 = r2.b     // Catch: java.lang.Throwable -> L4b
            int[] r5 = r2.c     // Catch: java.lang.Throwable -> L4b
            long[] r2 = r2.a     // Catch: java.lang.Throwable -> L4b
            int r6 = r2.length     // Catch: java.lang.Throwable -> L4b
            int r6 = r6 + (-2)
            if (r6 < 0) goto L58
            r7 = r3
        L1b:
            r8 = r2[r7]     // Catch: java.lang.Throwable -> L4b
            long r10 = ~r8     // Catch: java.lang.Throwable -> L4b
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L53
            int r10 = r7 - r6
            int r10 = ~r10     // Catch: java.lang.Throwable -> L4b
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r3
        L35:
            if (r12 >= r10) goto L51
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L4d
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r4[r13]     // Catch: java.lang.Throwable -> L4b
            r13 = r5[r13]     // Catch: java.lang.Throwable -> L4b
            r0.b(r14)     // Catch: java.lang.Throwable -> L4b
            goto L4d
        L4b:
            r0 = move-exception
            goto L5c
        L4d:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L35
        L51:
            if (r10 != r11) goto L58
        L53:
            if (r7 == r6) goto L58
            int r7 = r7 + 1
            goto L1b
        L58:
            r1.J(r3)
            goto L60
        L5c:
            r1.J(r3)
            throw r0
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PJ5.B():void");
    }

    public final void C() {
        if (r()) {
            return;
        }
        L(true);
    }

    public final void D(C6669Om c6669Om) {
        this.c = c6669Om;
    }

    public final void E(boolean z) {
        if (z) {
            this.a |= 2;
        } else {
            this.a &= -3;
        }
    }

    public final void F(boolean z) {
        if (z) {
            this.a |= 4;
        } else {
            this.a &= -5;
        }
    }

    public final void G(boolean z) {
        if (z) {
            this.a |= 64;
        } else {
            this.a &= -65;
        }
    }

    public final void H(boolean z) {
        this.a = z ? this.a | 256 : this.a & (-257);
    }

    public final void I(boolean z) {
        if (z) {
            this.a |= 8;
        } else {
            this.a &= -9;
        }
    }

    public final void K(boolean z) {
        this.a = z ? this.a | 512 : this.a & (-513);
    }

    public final void M(boolean z) {
        this.a = z ? this.a | 1 : this.a & (-2);
    }

    public final void N(int i2) {
        this.e = i2;
        L(false);
    }

    @Override // ir.nasim.InterfaceC20208rd6
    public void a(InterfaceC14603iB2 interfaceC14603iB2) {
        this.d = interfaceC14603iB2;
    }

    public final void e(RJ5 rj5) {
        this.b = rj5;
    }

    public final void g(InterfaceC22053ub1 interfaceC22053ub1) {
        C19938rB7 c19938rB7;
        InterfaceC14603iB2 interfaceC14603iB2 = this.d;
        if (interfaceC14603iB2 != null) {
            interfaceC14603iB2.invoke(interfaceC22053ub1, 1);
            c19938rB7 = C19938rB7.a;
        } else {
            c19938rB7 = null;
        }
        if (c19938rB7 == null) {
            throw new IllegalStateException("Invalid restart scope".toString());
        }
    }

    public final UA2 h(int i2) {
        C3348Am4 c3348Am4 = this.f;
        if (c3348Am4 == null || s()) {
            return null;
        }
        Object[] objArr = c3348Am4.b;
        int[] iArr = c3348Am4.c;
        long[] jArr = c3348Am4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return null;
        }
        int i3 = 0;
        while (true) {
            long j = jArr[i3];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j) < 128) {
                        int i6 = (i3 << 3) + i5;
                        Object obj = objArr[i6];
                        if (iArr[i6] != i2) {
                            return new b(i2, c3348Am4);
                        }
                    }
                    j >>= 8;
                }
                if (i4 != 8) {
                    return null;
                }
            }
            if (i3 == length) {
                return null;
            }
            i3++;
        }
    }

    public final C6669Om i() {
        return this.c;
    }

    @Override // ir.nasim.OJ5
    public void invalidate() {
        RJ5 rj5 = this.b;
        if (rj5 != null) {
            rj5.k(this, null);
        }
    }

    public final boolean j() {
        return this.d != null;
    }

    public final boolean k() {
        return (this.a & 2) != 0;
    }

    public final boolean l() {
        return (this.a & 4) != 0;
    }

    public final boolean m() {
        return (this.a & 64) != 0;
    }

    public final boolean n() {
        return (this.a & 256) != 0;
    }

    public final boolean o() {
        return (this.a & 8) != 0;
    }

    public final boolean q() {
        return (this.a & 512) != 0;
    }

    public final boolean r() {
        return (this.a & 128) != 0;
    }

    public final boolean s() {
        return (this.a & 16) != 0;
    }

    public final boolean t() {
        return (this.a & 1) != 0;
    }

    public final boolean u() {
        if (this.b == null) {
            return false;
        }
        C6669Om c6669Om = this.c;
        return c6669Om != null ? c6669Om.b() : false;
    }

    public final EnumC11036cd3 v(Object obj) {
        EnumC11036cd3 enumC11036cd3K;
        RJ5 rj5 = this.b;
        return (rj5 == null || (enumC11036cd3K = rj5.k(this, obj)) == null) ? EnumC11036cd3.a : enumC11036cd3K;
    }

    public final boolean w() {
        return this.g != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 1
            if (r1 != 0) goto L8
            return r2
        L8:
            ir.nasim.Rm4 r3 = r0.g
            if (r3 != 0) goto Ld
            return r2
        Ld:
            boolean r4 = r1 instanceof ir.nasim.InterfaceC19404qI1
            if (r4 == 0) goto L18
            ir.nasim.qI1 r1 = (ir.nasim.InterfaceC19404qI1) r1
            boolean r2 = r0.f(r1, r3)
            goto L72
        L18:
            boolean r4 = r1 instanceof ir.nasim.AbstractC22658vc6
            if (r4 == 0) goto L72
            ir.nasim.vc6 r1 = (ir.nasim.AbstractC22658vc6) r1
            boolean r4 = r1.e()
            r5 = 0
            if (r4 == 0) goto L71
            java.lang.Object[] r4 = r1.b
            long[] r1 = r1.a
            int r6 = r1.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L71
            r7 = r5
        L2f:
            r8 = r1[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L6c
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r5
        L49:
            if (r12 >= r10) goto L6a
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L66
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r4[r13]
            boolean r14 = r13 instanceof ir.nasim.InterfaceC19404qI1
            if (r14 == 0) goto L72
            ir.nasim.qI1 r13 = (ir.nasim.InterfaceC19404qI1) r13
            boolean r13 = r0.f(r13, r3)
            if (r13 == 0) goto L66
            goto L72
        L66:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L49
        L6a:
            if (r10 != r11) goto L71
        L6c:
            if (r7 == r6) goto L71
            int r7 = r7 + 1
            goto L2f
        L71:
            r2 = r5
        L72:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.PJ5.x(java.lang.Object):boolean");
    }

    public final void y(InterfaceC19404qI1 interfaceC19404qI1, Object obj) {
        C7386Rm4 c7386Rm4 = this.g;
        if (c7386Rm4 == null) {
            c7386Rm4 = new C7386Rm4(0, 1, null);
            this.g = c7386Rm4;
        }
        c7386Rm4.x(interfaceC19404qI1, obj);
    }

    public final boolean z(Object obj) {
        if (p()) {
            return false;
        }
        C3348Am4 c3348Am4 = this.f;
        if (c3348Am4 == null) {
            c3348Am4 = new C3348Am4(0, 1, null);
            this.f = c3348Am4;
        }
        return c3348Am4.q(obj, this.e, -1) == this.e;
    }
}
