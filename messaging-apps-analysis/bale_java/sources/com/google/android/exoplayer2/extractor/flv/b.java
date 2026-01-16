package com.google.android.exoplayer2.extractor.flv;

import ir.nasim.AbstractC20011rK;
import ir.nasim.C8292Vi5;
import ir.nasim.EW4;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC12462ef2;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC9262Ze2;
import ir.nasim.InterfaceC9845af2;
import org.xbill.DNS.Type;

/* loaded from: classes2.dex */
public final class b implements InterfaceC9262Ze2 {
    public static final InterfaceC12462ef2 q = new InterfaceC12462ef2() { // from class: ir.nasim.qr2
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return com.google.android.exoplayer2.extractor.flv.b.h();
        }
    };
    private InterfaceC10465bf2 f;
    private boolean h;
    private long i;
    private int j;
    private int k;
    private int l;
    private long m;
    private boolean n;
    private a o;
    private d p;
    private final EW4 a = new EW4(4);
    private final EW4 b = new EW4(9);
    private final EW4 c = new EW4(11);
    private final EW4 d = new EW4();
    private final c e = new c();
    private int g = 1;

    private void f() {
        if (this.n) {
            return;
        }
        this.f.o(new InterfaceC22148uk6.b(-9223372036854775807L));
        this.n = true;
    }

    private long g() {
        if (this.h) {
            return this.i + this.m;
        }
        if (this.e.d() == -9223372036854775807L) {
            return 0L;
        }
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] h() {
        return new InterfaceC9262Ze2[]{new b()};
    }

    private EW4 i(InterfaceC9845af2 interfaceC9845af2) {
        if (this.l > this.d.b()) {
            EW4 ew4 = this.d;
            ew4.Q(new byte[Math.max(ew4.b() * 2, this.l)], 0);
        } else {
            this.d.S(0);
        }
        this.d.R(this.l);
        interfaceC9845af2.readFully(this.d.e(), 0, this.l);
        return this.d;
    }

    private boolean j(InterfaceC9845af2 interfaceC9845af2) {
        if (!interfaceC9845af2.f(this.b.e(), 0, 9, true)) {
            return false;
        }
        this.b.S(0);
        this.b.T(4);
        int iF = this.b.F();
        boolean z = (iF & 4) != 0;
        boolean z2 = (iF & 1) != 0;
        if (z && this.o == null) {
            this.o = new a(this.f.b(8, 1));
        }
        if (z2 && this.p == null) {
            this.p = new d(this.f.b(9, 2));
        }
        this.f.s();
        this.j = this.b.o() - 5;
        this.g = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean k(ir.nasim.InterfaceC9845af2 r10) {
        /*
            r9 = this;
            long r0 = r9.g()
            int r2 = r9.k
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L23
            com.google.android.exoplayer2.extractor.flv.a r3 = r9.o
            if (r3 == 0) goto L23
            r9.f()
            com.google.android.exoplayer2.extractor.flv.a r2 = r9.o
            ir.nasim.EW4 r10 = r9.i(r10)
            boolean r10 = r2.a(r10, r0)
        L21:
            r0 = r6
            goto L75
        L23:
            r3 = 9
            if (r2 != r3) goto L39
            com.google.android.exoplayer2.extractor.flv.d r3 = r9.p
            if (r3 == 0) goto L39
            r9.f()
            com.google.android.exoplayer2.extractor.flv.d r2 = r9.p
            ir.nasim.EW4 r10 = r9.i(r10)
            boolean r10 = r2.a(r10, r0)
            goto L21
        L39:
            r3 = 18
            if (r2 != r3) goto L6e
            boolean r2 = r9.n
            if (r2 != 0) goto L6e
            com.google.android.exoplayer2.extractor.flv.c r2 = r9.e
            ir.nasim.EW4 r10 = r9.i(r10)
            boolean r10 = r2.a(r10, r0)
            com.google.android.exoplayer2.extractor.flv.c r0 = r9.e
            long r0 = r0.d()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L21
            ir.nasim.bf2 r2 = r9.f
            ir.nasim.f63 r3 = new ir.nasim.f63
            com.google.android.exoplayer2.extractor.flv.c r7 = r9.e
            long[] r7 = r7.e()
            com.google.android.exoplayer2.extractor.flv.c r8 = r9.e
            long[] r8 = r8.f()
            r3.<init>(r7, r8, r0)
            r2.o(r3)
            r9.n = r6
            goto L21
        L6e:
            int r0 = r9.l
            r10.k(r0)
            r10 = 0
            r0 = r10
        L75:
            boolean r1 = r9.h
            if (r1 != 0) goto L8f
            if (r10 == 0) goto L8f
            r9.h = r6
            com.google.android.exoplayer2.extractor.flv.c r10 = r9.e
            long r1 = r10.d()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L8b
            long r1 = r9.m
            long r1 = -r1
            goto L8d
        L8b:
            r1 = 0
        L8d:
            r9.i = r1
        L8f:
            r10 = 4
            r9.j = r10
            r10 = 2
            r9.g = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.flv.b.k(ir.nasim.af2):boolean");
    }

    private boolean l(InterfaceC9845af2 interfaceC9845af2) {
        if (!interfaceC9845af2.f(this.c.e(), 0, 11, true)) {
            return false;
        }
        this.c.S(0);
        this.k = this.c.F();
        this.l = this.c.I();
        this.m = this.c.I();
        this.m = ((this.c.F() << 24) | this.m) * 1000;
        this.c.T(3);
        this.g = 4;
        return true;
    }

    private void m(InterfaceC9845af2 interfaceC9845af2) {
        interfaceC9845af2.k(this.j);
        this.j = 0;
        this.g = 3;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        if (j == 0) {
            this.g = 1;
            this.h = false;
        } else {
            this.g = 3;
        }
        this.j = 0;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.f = interfaceC10465bf2;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        interfaceC9845af2.m(this.a.e(), 0, 3);
        this.a.S(0);
        if (this.a.I() != 4607062) {
            return false;
        }
        interfaceC9845af2.m(this.a.e(), 0, 2);
        this.a.S(0);
        if ((this.a.L() & Type.TSIG) != 0) {
            return false;
        }
        interfaceC9845af2.m(this.a.e(), 0, 4);
        this.a.S(0);
        int iO = this.a.o();
        interfaceC9845af2.e();
        interfaceC9845af2.h(iO);
        interfaceC9845af2.m(this.a.e(), 0, 4);
        this.a.S(0);
        return this.a.o() == 0;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        AbstractC20011rK.i(this.f);
        while (true) {
            int i = this.g;
            if (i != 1) {
                if (i == 2) {
                    m(interfaceC9845af2);
                } else if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException();
                    }
                    if (k(interfaceC9845af2)) {
                        return 0;
                    }
                } else if (!l(interfaceC9845af2)) {
                    return -1;
                }
            } else if (!j(interfaceC9845af2)) {
                return -1;
            }
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }
}
