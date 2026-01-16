package ir.nasim;

import ir.nasim.InterfaceC22148uk6;

/* renamed from: ir.nasim.Qe0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC7076Qe0 {
    protected final a a;
    protected final f b;
    protected c c;
    private final int d;

    /* renamed from: ir.nasim.Qe0$a */
    public static class a implements InterfaceC22148uk6 {
        private final d a;
        private final long b;
        private final long c;
        private final long d;
        private final long e;
        private final long f;
        private final long g;

        public a(d dVar, long j, long j2, long j3, long j4, long j5, long j6) {
            this.a = dVar;
            this.b = j;
            this.c = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public InterfaceC22148uk6.a c(long j) {
            return new InterfaceC22148uk6.a(new C23334wk6(j, c.h(this.a.a(j), this.c, this.d, this.e, this.f, this.g)));
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public boolean g() {
            return true;
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public long i() {
            return this.b;
        }

        public long k(long j) {
            return this.a.a(j);
        }
    }

    /* renamed from: ir.nasim.Qe0$c */
    protected static class c {
        private final long a;
        private final long b;
        private final long c;
        private long d;
        private long e;
        private long f;
        private long g;
        private long h;

        protected c(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.a = j;
            this.b = j2;
            this.d = j3;
            this.e = j4;
            this.f = j5;
            this.g = j6;
            this.c = j7;
            this.h = h(j2, j3, j4, j5, j6, j7);
        }

        protected static long h(long j, long j2, long j3, long j4, long j5, long j6) {
            if (j4 + 1 >= j5 || j2 + 1 >= j3) {
                return j4;
            }
            long j7 = (long) ((j - j2) * ((j5 - j4) / (j3 - j2)));
            return AbstractC9683aN7.q(((j7 + j4) - j6) - (j7 / 20), j4, j5 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long i() {
            return this.g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long j() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long k() {
            return this.h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long l() {
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long m() {
            return this.b;
        }

        private void n() {
            this.h = h(this.b, this.d, this.e, this.f, this.g, this.c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(long j, long j2) {
            this.e = j;
            this.g = j2;
            n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(long j, long j2) {
            this.d = j;
            this.f = j2;
            n();
        }
    }

    /* renamed from: ir.nasim.Qe0$d */
    protected interface d {
        long a(long j);
    }

    /* renamed from: ir.nasim.Qe0$e */
    public static final class e {
        public static final e d = new e(-3, -9223372036854775807L, -1);
        private final int a;
        private final long b;
        private final long c;

        private e(int i, long j, long j2) {
            this.a = i;
            this.b = j;
            this.c = j2;
        }

        public static e d(long j, long j2) {
            return new e(-1, j, j2);
        }

        public static e e(long j) {
            return new e(0, -9223372036854775807L, j);
        }

        public static e f(long j, long j2) {
            return new e(-2, j, j2);
        }
    }

    protected AbstractC7076Qe0(d dVar, f fVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.b = fVar;
        this.d = i;
        this.a = new a(dVar, j, j2, j3, j4, j5, j6);
    }

    protected c a(long j) {
        return new c(j, this.a.k(j), this.a.c, this.a.d, this.a.e, this.a.f, this.a.g);
    }

    public final InterfaceC22148uk6 b() {
        return this.a;
    }

    public int c(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        while (true) {
            c cVar = (c) AbstractC20011rK.i(this.c);
            long j = cVar.j();
            long jI = cVar.i();
            long jK = cVar.k();
            if (jI - j <= this.d) {
                e(false, j);
                return g(interfaceC9845af2, j, c8292Vi5);
            }
            if (!i(interfaceC9845af2, jK)) {
                return g(interfaceC9845af2, jK, c8292Vi5);
            }
            interfaceC9845af2.e();
            e eVarA = this.b.a(interfaceC9845af2, cVar.m());
            int i = eVarA.a;
            if (i == -3) {
                e(false, jK);
                return g(interfaceC9845af2, jK, c8292Vi5);
            }
            if (i == -2) {
                cVar.p(eVarA.b, eVarA.c);
            } else {
                if (i != -1) {
                    if (i != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(interfaceC9845af2, eVarA.c);
                    e(true, eVarA.c);
                    return g(interfaceC9845af2, eVarA.c, c8292Vi5);
                }
                cVar.o(eVarA.b, eVarA.c);
            }
        }
    }

    public final boolean d() {
        return this.c != null;
    }

    protected final void e(boolean z, long j) {
        this.c = null;
        this.b.b();
        f(z, j);
    }

    protected final int g(InterfaceC9845af2 interfaceC9845af2, long j, C8292Vi5 c8292Vi5) {
        if (j == interfaceC9845af2.getPosition()) {
            return 0;
        }
        c8292Vi5.a = j;
        return 1;
    }

    public final void h(long j) {
        c cVar = this.c;
        if (cVar == null || cVar.l() != j) {
            this.c = a(j);
        }
    }

    protected final boolean i(InterfaceC9845af2 interfaceC9845af2, long j) {
        long position = j - interfaceC9845af2.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        interfaceC9845af2.k((int) position);
        return true;
    }

    /* renamed from: ir.nasim.Qe0$f */
    protected interface f {
        e a(InterfaceC9845af2 interfaceC9845af2, long j);

        default void b() {
        }
    }

    /* renamed from: ir.nasim.Qe0$b */
    public static final class b implements d {
        @Override // ir.nasim.AbstractC7076Qe0.d
        public long a(long j) {
            return j;
        }
    }

    protected void f(boolean z, long j) {
    }
}
