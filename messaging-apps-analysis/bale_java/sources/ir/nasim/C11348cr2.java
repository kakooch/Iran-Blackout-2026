package ir.nasim;

import ir.nasim.AbstractC13218fr2;

/* renamed from: ir.nasim.cr2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C11348cr2 {
    private final int a;
    private final C13809gr2 b;
    private final long c;
    private final int d;
    private final int e;
    private final int f;

    /* renamed from: ir.nasim.cr2$a */
    public static final class a {
        private final ZV3 a;
        private final AbstractC21430te5 b;
        private final long c;
        private boolean d;

        public /* synthetic */ a(ZV3 zv3, AbstractC21430te5 abstractC21430te5, long j, boolean z, ED1 ed1) {
            this(zv3, abstractC21430te5, j, z);
        }

        public final ZV3 a() {
            return this.a;
        }

        public final long b() {
            return this.c;
        }

        public final boolean c() {
            return this.d;
        }

        public final AbstractC21430te5 d() {
            return this.b;
        }

        public final void e(boolean z) {
            this.d = z;
        }

        private a(ZV3 zv3, AbstractC21430te5 abstractC21430te5, long j, boolean z) {
            this.a = zv3;
            this.b = abstractC21430te5;
            this.c = j;
            this.d = z;
        }

        public /* synthetic */ a(ZV3 zv3, AbstractC21430te5 abstractC21430te5, long j, boolean z, int i, ED1 ed1) {
            this(zv3, abstractC21430te5, j, (i & 8) != 0 ? true : z, null);
        }
    }

    /* renamed from: ir.nasim.cr2$b */
    public static final class b {
        private final boolean a;
        private final boolean b;

        public b(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        public final boolean a() {
            return this.b;
        }

        public final boolean b() {
            return this.a;
        }
    }

    public /* synthetic */ C11348cr2(int i, C13809gr2 c13809gr2, long j, int i2, int i3, int i4, ED1 ed1) {
        this(i, c13809gr2, j, i2, i3, i4);
    }

    public final a a(b bVar, boolean z, int i, int i2, int i3, int i4) {
        a aVarE;
        if (!bVar.a() || (aVarE = this.b.e(z, i, i2)) == null) {
            return null;
        }
        aVarE.e(i >= 0 && (i4 == 0 || (i3 - C17795na3.e(aVarE.b()) >= 0 && i4 < this.a)));
        return aVarE;
    }

    public final b b(boolean z, int i, long j, C17795na3 c17795na3, int i2, int i3, int i4, boolean z2, boolean z3) {
        int i5 = i3 + i4;
        if (c17795na3 == null) {
            return new b(true, true);
        }
        if (this.b.i() != AbstractC13218fr2.a.a && (i2 >= this.d || C17795na3.f(j) - C17795na3.f(c17795na3.i()) < 0)) {
            return new b(true, true);
        }
        if (i != 0 && (i >= this.a || C17795na3.e(j) - C17795na3.e(c17795na3.i()) < 0)) {
            return z2 ? new b(true, true) : new b(true, b(z, 0, C17795na3.b(C17833ne1.l(this.c), (C17795na3.f(j) - this.f) - i4), C17795na3.a(C17795na3.b(C17795na3.e(c17795na3.i()) - this.e, C17795na3.f(c17795na3.i()))), i2 + 1, i5, 0, true, false).a());
        }
        int iMax = i3 + Math.max(i4, C17795na3.f(c17795na3.i()));
        C17795na3 c17795na3F = z3 ? null : this.b.f(z, i2, iMax);
        if (c17795na3F != null) {
            c17795na3F.i();
            if (i + 1 >= this.a || ((C17795na3.e(j) - C17795na3.e(c17795na3.i())) - this.e) - C17795na3.e(c17795na3F.i()) < 0) {
                if (z3) {
                    return new b(true, true);
                }
                b bVarB = b(false, 0, C17795na3.b(C17833ne1.l(this.c), (C17795na3.f(j) - this.f) - Math.max(i4, C17795na3.f(c17795na3.i()))), c17795na3F, i2 + 1, iMax, 0, true, true);
                return new b(bVarB.a(), bVarB.a());
            }
        }
        return new b(false, false);
    }

    private C11348cr2(int i, C13809gr2 c13809gr2, long j, int i2, int i3, int i4) {
        this.a = i;
        this.b = c13809gr2;
        this.c = j;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }
}
