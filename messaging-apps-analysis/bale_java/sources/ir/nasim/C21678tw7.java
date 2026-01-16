package ir.nasim;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC22268uw7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.tw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21678tw7 implements InterfaceC9262Ze2 {
    public static final InterfaceC12462ef2 t = new InterfaceC12462ef2() { // from class: ir.nasim.sw7
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return C21678tw7.w();
        }
    };
    private final int a;
    private final int b;
    private final List c;
    private final EW4 d;
    private final SparseIntArray e;
    private final InterfaceC22268uw7.c f;
    private final SparseArray g;
    private final SparseBooleanArray h;
    private final SparseBooleanArray i;
    private final C20401rw7 j;
    private C19792qw7 k;
    private InterfaceC10465bf2 l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private InterfaceC22268uw7 q;
    private int r;
    private int s;

    public C21678tw7() {
        this(0);
    }

    static /* synthetic */ int k(C21678tw7 c21678tw7) {
        int i = c21678tw7.m;
        c21678tw7.m = i + 1;
        return i;
    }

    private boolean u(InterfaceC9845af2 interfaceC9845af2) {
        byte[] bArrE = this.d.e();
        if (9400 - this.d.f() < 188) {
            int iA = this.d.a();
            if (iA > 0) {
                System.arraycopy(bArrE, this.d.f(), bArrE, 0, iA);
            }
            this.d.Q(bArrE, iA);
        }
        while (this.d.a() < 188) {
            int iG = this.d.g();
            int i = interfaceC9845af2.read(bArrE, iG, 9400 - iG);
            if (i == -1) {
                return false;
            }
            this.d.R(iG + i);
        }
        return true;
    }

    private int v() throws ParserException {
        int iF = this.d.f();
        int iG = this.d.g();
        int iA = AbstractC22864vw7.a(this.d.e(), iF, iG);
        this.d.S(iA);
        int i = iA + 188;
        if (i > iG) {
            int i2 = this.r + (iA - iF);
            this.r = i2;
            if (this.a == 2 && i2 > 376) {
                throw ParserException.a("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.r = 0;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] w() {
        return new InterfaceC9262Ze2[]{new C21678tw7()};
    }

    private void x(long j) {
        if (this.o) {
            return;
        }
        this.o = true;
        if (this.j.b() == -9223372036854775807L) {
            this.l.o(new InterfaceC22148uk6.b(this.j.b()));
            return;
        }
        C19792qw7 c19792qw7 = new C19792qw7(this.j.c(), this.j.b(), j, this.s, this.b);
        this.k = c19792qw7;
        this.l.o(c19792qw7.b());
    }

    private void y() {
        this.h.clear();
        this.g.clear();
        SparseArray sparseArrayA = this.f.a();
        int size = sparseArrayA.size();
        for (int i = 0; i < size; i++) {
            this.g.put(sparseArrayA.keyAt(i), (InterfaceC22268uw7) sparseArrayA.valueAt(i));
        }
        this.g.put(0, new C20260ri6(new a()));
        this.q = null;
    }

    private boolean z(int i) {
        return this.a == 2 || this.n || !this.i.get(i, false);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        C19792qw7 c19792qw7;
        AbstractC20011rK.g(this.a != 2);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            C5045Hq7 c5045Hq7 = (C5045Hq7) this.c.get(i);
            boolean z = c5045Hq7.e() == -9223372036854775807L;
            if (!z) {
                long jC = c5045Hq7.c();
                z = (jC == -9223372036854775807L || jC == 0 || jC == j2) ? false : true;
            }
            if (z) {
                c5045Hq7.g(j2);
            }
        }
        if (j2 != 0 && (c19792qw7 = this.k) != null) {
            c19792qw7.h(j2);
        }
        this.d.O(0);
        this.e.clear();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            ((InterfaceC22268uw7) this.g.valueAt(i2)).b();
        }
        this.r = 0;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.l = interfaceC10465bf2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        r1 = r1 + 1;
     */
    @Override // ir.nasim.InterfaceC9262Ze2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(ir.nasim.InterfaceC9845af2 r7) {
        /*
            r6 = this;
            ir.nasim.EW4 r0 = r6.d
            byte[] r0 = r0.e()
            r1 = 940(0x3ac, float:1.317E-42)
            r2 = 0
            r7.m(r0, r2, r1)
            r1 = r2
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L29
            r3 = r2
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r1
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r1 = r1 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.k(r1)
            r7 = 1
            return r7
        L29:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21678tw7.d(ir.nasim.af2):boolean");
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        long length = interfaceC9845af2.getLength();
        if (this.n) {
            if (length != -1 && this.a != 2 && !this.j.d()) {
                return this.j.e(interfaceC9845af2, c8292Vi5, this.s);
            }
            x(length);
            if (this.p) {
                this.p = false;
                a(0L, 0L);
                if (interfaceC9845af2.getPosition() != 0) {
                    c8292Vi5.a = 0L;
                    return 1;
                }
            }
            C19792qw7 c19792qw7 = this.k;
            if (c19792qw7 != null && c19792qw7.d()) {
                return this.k.c(interfaceC9845af2, c8292Vi5);
            }
        }
        if (!u(interfaceC9845af2)) {
            return -1;
        }
        int iV = v();
        int iG = this.d.g();
        if (iV > iG) {
            return 0;
        }
        int iO = this.d.o();
        if ((8388608 & iO) != 0) {
            this.d.S(iV);
            return 0;
        }
        int i = (4194304 & iO) != 0 ? 1 : 0;
        int i2 = (2096896 & iO) >> 8;
        boolean z = (iO & 32) != 0;
        InterfaceC22268uw7 interfaceC22268uw7 = (iO & 16) != 0 ? (InterfaceC22268uw7) this.g.get(i2) : null;
        if (interfaceC22268uw7 == null) {
            this.d.S(iV);
            return 0;
        }
        if (this.a != 2) {
            int i3 = iO & 15;
            int i4 = this.e.get(i2, i3 - 1);
            this.e.put(i2, i3);
            if (i4 == i3) {
                this.d.S(iV);
                return 0;
            }
            if (i3 != ((i4 + 1) & 15)) {
                interfaceC22268uw7.b();
            }
        }
        if (z) {
            int iF = this.d.F();
            i |= (this.d.F() & 64) != 0 ? 2 : 0;
            this.d.T(iF - 1);
        }
        boolean z2 = this.n;
        if (z(i2)) {
            this.d.R(iV);
            interfaceC22268uw7.a(this.d, i);
            this.d.R(iG);
        }
        if (this.a != 2 && !z2 && this.n && length != -1) {
            this.p = true;
        }
        this.d.S(iV);
        return 0;
    }

    public C21678tw7(int i) {
        this(1, i, 112800);
    }

    public C21678tw7(int i, int i2, int i3) {
        this(i, new C5045Hq7(0L), new C16431lG1(i2), i3);
    }

    public C21678tw7(int i, C5045Hq7 c5045Hq7, InterfaceC22268uw7.c cVar) {
        this(i, c5045Hq7, cVar, 112800);
    }

    public C21678tw7(int i, C5045Hq7 c5045Hq7, InterfaceC22268uw7.c cVar, int i2) {
        this.f = (InterfaceC22268uw7.c) AbstractC20011rK.e(cVar);
        this.b = i2;
        this.a = i;
        if (i != 1 && i != 2) {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            arrayList.add(c5045Hq7);
        } else {
            this.c = Collections.singletonList(c5045Hq7);
        }
        this.d = new EW4(new byte[9400], 0);
        this.h = new SparseBooleanArray();
        this.i = new SparseBooleanArray();
        this.g = new SparseArray();
        this.e = new SparseIntArray();
        this.j = new C20401rw7(i2);
        this.l = InterfaceC10465bf2.j0;
        this.s = -1;
        y();
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }

    /* renamed from: ir.nasim.tw7$a */
    private class a implements InterfaceC19651qi6 {
        private final DW4 a = new DW4(new byte[4]);

        public a() {
        }

        @Override // ir.nasim.InterfaceC19651qi6
        public void a(EW4 ew4) {
            if (ew4.F() == 0 && (ew4.F() & 128) != 0) {
                ew4.T(6);
                int iA = ew4.a() / 4;
                for (int i = 0; i < iA; i++) {
                    ew4.i(this.a, 4);
                    int iH = this.a.h(16);
                    this.a.r(3);
                    if (iH == 0) {
                        this.a.r(13);
                    } else {
                        int iH2 = this.a.h(13);
                        if (C21678tw7.this.g.get(iH2) == null) {
                            C21678tw7.this.g.put(iH2, new C20260ri6(C21678tw7.this.new b(iH2)));
                            C21678tw7.k(C21678tw7.this);
                        }
                    }
                }
                if (C21678tw7.this.a != 2) {
                    C21678tw7.this.g.remove(0);
                }
            }
        }

        @Override // ir.nasim.InterfaceC19651qi6
        public void c(C5045Hq7 c5045Hq7, InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        }
    }

    /* renamed from: ir.nasim.tw7$b */
    private class b implements InterfaceC19651qi6 {
        private final DW4 a = new DW4(new byte[5]);
        private final SparseArray b = new SparseArray();
        private final SparseIntArray c = new SparseIntArray();
        private final int d;

        public b(int i) {
            this.d = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private ir.nasim.InterfaceC22268uw7.b b(ir.nasim.EW4 r13, int r14) {
            /*
                r12 = this;
                int r0 = r13.f()
                int r14 = r14 + r0
                r1 = -1
                r2 = 0
                r3 = r2
            L8:
                int r4 = r13.f()
                if (r4 >= r14) goto Lbd
                int r4 = r13.F()
                int r5 = r13.F()
                int r6 = r13.f()
                int r6 = r6 + r5
                if (r6 <= r14) goto L1f
                goto Lbd
            L1f:
                r5 = 5
                r7 = 172(0xac, float:2.41E-43)
                r8 = 135(0x87, float:1.89E-43)
                r9 = 129(0x81, float:1.81E-43)
                if (r4 != r5) goto L51
                long r4 = r13.H()
                r10 = 1094921523(0x41432d33, double:5.409631094E-315)
                int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r10 != 0) goto L34
                goto L55
            L34:
                r9 = 1161904947(0x45414333, double:5.74057318E-315)
                int r9 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r9 != 0) goto L3c
                goto L5b
            L3c:
                r8 = 1094921524(0x41432d34, double:5.4096311E-315)
                int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r8 != 0) goto L46
            L43:
                r1 = r7
                goto Lb3
            L46:
                r7 = 1212503619(0x48455643, double:5.990563836E-315)
                int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
                if (r4 != 0) goto Lb3
                r1 = 36
                goto Lb3
            L51:
                r5 = 106(0x6a, float:1.49E-43)
                if (r4 != r5) goto L57
            L55:
                r1 = r9
                goto Lb3
            L57:
                r5 = 122(0x7a, float:1.71E-43)
                if (r4 != r5) goto L5d
            L5b:
                r1 = r8
                goto Lb3
            L5d:
                r5 = 127(0x7f, float:1.78E-43)
                if (r4 != r5) goto L6a
                int r4 = r13.F()
                r5 = 21
                if (r4 != r5) goto Lb3
                goto L43
            L6a:
                r5 = 123(0x7b, float:1.72E-43)
                if (r4 != r5) goto L71
                r1 = 138(0x8a, float:1.93E-43)
                goto Lb3
            L71:
                r5 = 10
                r7 = 3
                if (r4 != r5) goto L7f
                java.lang.String r2 = r13.C(r7)
                java.lang.String r2 = r2.trim()
                goto Lb3
            L7f:
                r5 = 89
                if (r4 != r5) goto Lad
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
            L88:
                int r3 = r13.f()
                if (r3 >= r6) goto Laa
                java.lang.String r3 = r13.C(r7)
                java.lang.String r3 = r3.trim()
                int r4 = r13.F()
                r8 = 4
                byte[] r9 = new byte[r8]
                r10 = 0
                r13.j(r9, r10, r8)
                ir.nasim.uw7$a r8 = new ir.nasim.uw7$a
                r8.<init>(r3, r4, r9)
                r1.add(r8)
                goto L88
            Laa:
                r3 = r1
                r1 = r5
                goto Lb3
            Lad:
                r5 = 111(0x6f, float:1.56E-43)
                if (r4 != r5) goto Lb3
                r1 = 257(0x101, float:3.6E-43)
            Lb3:
                int r4 = r13.f()
                int r6 = r6 - r4
                r13.T(r6)
                goto L8
            Lbd:
                r13.S(r14)
                ir.nasim.uw7$b r4 = new ir.nasim.uw7$b
                byte[] r13 = r13.e()
                byte[] r13 = java.util.Arrays.copyOfRange(r13, r0, r14)
                r4.<init>(r1, r2, r3, r13)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21678tw7.b.b(ir.nasim.EW4, int):ir.nasim.uw7$b");
        }

        @Override // ir.nasim.InterfaceC19651qi6
        public void a(EW4 ew4) {
            C5045Hq7 c5045Hq7;
            if (ew4.F() != 2) {
                return;
            }
            if (C21678tw7.this.a == 1 || C21678tw7.this.a == 2 || C21678tw7.this.m == 1) {
                c5045Hq7 = (C5045Hq7) C21678tw7.this.c.get(0);
            } else {
                c5045Hq7 = new C5045Hq7(((C5045Hq7) C21678tw7.this.c.get(0)).c());
                C21678tw7.this.c.add(c5045Hq7);
            }
            if ((ew4.F() & 128) == 0) {
                return;
            }
            ew4.T(1);
            int iL = ew4.L();
            int i = 3;
            ew4.T(3);
            ew4.i(this.a, 2);
            this.a.r(3);
            int i2 = 13;
            C21678tw7.this.s = this.a.h(13);
            ew4.i(this.a, 2);
            int i3 = 4;
            this.a.r(4);
            ew4.T(this.a.h(12));
            if (C21678tw7.this.a == 2 && C21678tw7.this.q == null) {
                InterfaceC22268uw7.b bVar = new InterfaceC22268uw7.b(21, null, null, AbstractC9683aN7.f);
                C21678tw7 c21678tw7 = C21678tw7.this;
                c21678tw7.q = c21678tw7.f.b(21, bVar);
                if (C21678tw7.this.q != null) {
                    C21678tw7.this.q.c(c5045Hq7, C21678tw7.this.l, new InterfaceC22268uw7.d(iL, 21, 8192));
                }
            }
            this.b.clear();
            this.c.clear();
            int iA = ew4.a();
            while (iA > 0) {
                ew4.i(this.a, 5);
                int iH = this.a.h(8);
                this.a.r(i);
                int iH2 = this.a.h(i2);
                this.a.r(i3);
                int iH3 = this.a.h(12);
                InterfaceC22268uw7.b bVarB = b(ew4, iH3);
                if (iH == 6 || iH == 5) {
                    iH = bVarB.a;
                }
                iA -= iH3 + 5;
                int i4 = C21678tw7.this.a == 2 ? iH : iH2;
                if (!C21678tw7.this.h.get(i4)) {
                    InterfaceC22268uw7 interfaceC22268uw7B = (C21678tw7.this.a == 2 && iH == 21) ? C21678tw7.this.q : C21678tw7.this.f.b(iH, bVarB);
                    if (C21678tw7.this.a != 2 || iH2 < this.c.get(i4, 8192)) {
                        this.c.put(i4, iH2);
                        this.b.put(i4, interfaceC22268uw7B);
                    }
                }
                i = 3;
                i3 = 4;
                i2 = 13;
            }
            int size = this.c.size();
            for (int i5 = 0; i5 < size; i5++) {
                int iKeyAt = this.c.keyAt(i5);
                int iValueAt = this.c.valueAt(i5);
                C21678tw7.this.h.put(iKeyAt, true);
                C21678tw7.this.i.put(iValueAt, true);
                InterfaceC22268uw7 interfaceC22268uw7 = (InterfaceC22268uw7) this.b.valueAt(i5);
                if (interfaceC22268uw7 != null) {
                    if (interfaceC22268uw7 != C21678tw7.this.q) {
                        interfaceC22268uw7.c(c5045Hq7, C21678tw7.this.l, new InterfaceC22268uw7.d(iL, iKeyAt, 8192));
                    }
                    C21678tw7.this.g.put(iValueAt, interfaceC22268uw7);
                }
            }
            if (C21678tw7.this.a == 2) {
                if (C21678tw7.this.n) {
                    return;
                }
                C21678tw7.this.l.s();
                C21678tw7.this.m = 0;
                C21678tw7.this.n = true;
                return;
            }
            C21678tw7.this.g.remove(this.d);
            C21678tw7 c21678tw72 = C21678tw7.this;
            c21678tw72.m = c21678tw72.a == 1 ? 0 : C21678tw7.this.m - 1;
            if (C21678tw7.this.m == 0) {
                C21678tw7.this.l.s();
                C21678tw7.this.n = true;
            }
        }

        @Override // ir.nasim.InterfaceC19651qi6
        public void c(C5045Hq7 c5045Hq7, InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        }
    }
}
