package ir.nasim;

/* renamed from: ir.nasim.hn7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14367hn7 {
    private final C13774gn7 a;
    private InterfaceC11379cu3 b;
    private InterfaceC11379cu3 c;

    public C14367hn7(C13774gn7 c13774gn7, InterfaceC11379cu3 interfaceC11379cu3, InterfaceC11379cu3 interfaceC11379cu32) {
        this.a = c13774gn7;
        this.b = interfaceC11379cu3;
        this.c = interfaceC11379cu32;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long a(long r6) {
        /*
            r5 = this;
            ir.nasim.cu3 r0 = r5.b
            if (r0 == 0) goto L1e
            boolean r1 = r0.b()
            if (r1 == 0) goto L16
            ir.nasim.cu3 r1 = r5.c
            r2 = 0
            if (r1 == 0) goto L1c
            r3 = 0
            r4 = 2
            ir.nasim.CK5 r2 = ir.nasim.InterfaceC11379cu3.W(r1, r0, r3, r4, r2)
            goto L1c
        L16:
            ir.nasim.CK5$a r0 = ir.nasim.CK5.e
            ir.nasim.CK5 r2 = r0.a()
        L1c:
            if (r2 != 0) goto L24
        L1e:
            ir.nasim.CK5$a r0 = ir.nasim.CK5.e
            ir.nasim.CK5 r2 = r0.a()
        L24:
            long r6 = ir.nasim.AbstractC14975in7.a(r6, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14367hn7.a(long):long");
    }

    public static /* synthetic */ int e(C14367hn7 c14367hn7, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return c14367hn7.d(j, z);
    }

    public final InterfaceC11379cu3 b() {
        return this.c;
    }

    public final InterfaceC11379cu3 c() {
        return this.b;
    }

    public final int d(long j, boolean z) {
        if (z) {
            j = a(j);
        }
        return this.a.x(j(j));
    }

    public final C13774gn7 f() {
        return this.a;
    }

    public final boolean g(long j) {
        long j2 = j(a(j));
        int iR = this.a.r(Float.intBitsToFloat((int) (4294967295L & j2)));
        int i = (int) (j2 >> 32);
        return Float.intBitsToFloat(i) >= this.a.s(iR) && Float.intBitsToFloat(i) <= this.a.t(iR);
    }

    public final void h(InterfaceC11379cu3 interfaceC11379cu3) {
        this.c = interfaceC11379cu3;
    }

    public final void i(InterfaceC11379cu3 interfaceC11379cu3) {
        this.b = interfaceC11379cu3;
    }

    public final long j(long j) {
        InterfaceC11379cu3 interfaceC11379cu3;
        InterfaceC11379cu3 interfaceC11379cu32 = this.b;
        if (interfaceC11379cu32 == null) {
            return j;
        }
        if (!interfaceC11379cu32.b()) {
            interfaceC11379cu32 = null;
        }
        if (interfaceC11379cu32 == null || (interfaceC11379cu3 = this.c) == null) {
            return j;
        }
        InterfaceC11379cu3 interfaceC11379cu33 = interfaceC11379cu3.b() ? interfaceC11379cu3 : null;
        return interfaceC11379cu33 == null ? j : interfaceC11379cu32.F(interfaceC11379cu33, j);
    }

    public final long k(long j) {
        InterfaceC11379cu3 interfaceC11379cu3;
        InterfaceC11379cu3 interfaceC11379cu32 = this.b;
        if (interfaceC11379cu32 == null) {
            return j;
        }
        if (!interfaceC11379cu32.b()) {
            interfaceC11379cu32 = null;
        }
        if (interfaceC11379cu32 == null || (interfaceC11379cu3 = this.c) == null) {
            return j;
        }
        InterfaceC11379cu3 interfaceC11379cu33 = interfaceC11379cu3.b() ? interfaceC11379cu3 : null;
        return interfaceC11379cu33 == null ? j : interfaceC11379cu33.F(interfaceC11379cu32, j);
    }

    public /* synthetic */ C14367hn7(C13774gn7 c13774gn7, InterfaceC11379cu3 interfaceC11379cu3, InterfaceC11379cu3 interfaceC11379cu32, int i, ED1 ed1) {
        this(c13774gn7, (i & 2) != 0 ? null : interfaceC11379cu3, (i & 4) != 0 ? null : interfaceC11379cu32);
    }
}
