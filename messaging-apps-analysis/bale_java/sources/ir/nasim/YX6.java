package ir.nasim;

import ir.nasim.InterfaceC22148uk6;

/* loaded from: classes2.dex */
abstract class YX6 {
    private InterfaceC4589Ft7 b;
    private InterfaceC10465bf2 c;
    private InterfaceC15261jH4 d;
    private long e;
    private long f;
    private long g;
    private int h;
    private int i;
    private long k;
    private boolean l;
    private boolean m;
    private final C14061hH4 a = new C14061hH4();
    private b j = new b();

    static class b {
        com.google.android.exoplayer2.X a;
        InterfaceC15261jH4 b;

        b() {
        }
    }

    private void a() {
        AbstractC20011rK.i(this.b);
        AbstractC9683aN7.j(this.c);
    }

    private boolean h(InterfaceC9845af2 interfaceC9845af2) {
        while (this.a.d(interfaceC9845af2)) {
            this.k = interfaceC9845af2.getPosition() - this.f;
            if (!i(this.a.c(), this.f, this.j)) {
                return true;
            }
            this.f = interfaceC9845af2.getPosition();
        }
        this.h = 3;
        return false;
    }

    private int j(InterfaceC9845af2 interfaceC9845af2) {
        if (!h(interfaceC9845af2)) {
            return -1;
        }
        com.google.android.exoplayer2.X x = this.j.a;
        this.i = x.z;
        if (!this.m) {
            this.b.c(x);
            this.m = true;
        }
        InterfaceC15261jH4 interfaceC15261jH4 = this.j.b;
        if (interfaceC15261jH4 != null) {
            this.d = interfaceC15261jH4;
        } else if (interfaceC9845af2.getLength() == -1) {
            this.d = new c();
        } else {
            C14663iH4 c14663iH4B = this.a.b();
            this.d = new C22435vE1(this, this.f, interfaceC9845af2.getLength(), c14663iH4B.h + c14663iH4B.i, c14663iH4B.c, (c14663iH4B.b & 4) != 0);
        }
        this.h = 2;
        this.a.f();
        return 0;
    }

    private int k(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        long jA = this.d.a(interfaceC9845af2);
        if (jA >= 0) {
            c8292Vi5.a = jA;
            return 1;
        }
        if (jA < -1) {
            e(-(jA + 2));
        }
        if (!this.l) {
            this.c.o((InterfaceC22148uk6) AbstractC20011rK.i(this.d.b()));
            this.l = true;
        }
        if (this.k <= 0 && !this.a.d(interfaceC9845af2)) {
            this.h = 3;
            return -1;
        }
        this.k = 0L;
        EW4 ew4C = this.a.c();
        long jF = f(ew4C);
        if (jF >= 0) {
            long j = this.g;
            if (j + jF >= this.e) {
                long jB = b(j);
                this.b.d(ew4C, ew4C.g());
                this.b.b(jB, 1, ew4C.g(), 0, null);
                this.e = -1L;
            }
        }
        this.g += jF;
        return 0;
    }

    protected long b(long j) {
        return (j * 1000000) / this.i;
    }

    protected long c(long j) {
        return (this.i * j) / 1000000;
    }

    void d(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC4589Ft7 interfaceC4589Ft7) {
        this.c = interfaceC10465bf2;
        this.b = interfaceC4589Ft7;
        l(true);
    }

    protected void e(long j) {
        this.g = j;
    }

    protected abstract long f(EW4 ew4);

    final int g(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        a();
        int i = this.h;
        if (i == 0) {
            return j(interfaceC9845af2);
        }
        if (i == 1) {
            interfaceC9845af2.k((int) this.f);
            this.h = 2;
            return 0;
        }
        if (i == 2) {
            AbstractC9683aN7.j(this.d);
            return k(interfaceC9845af2, c8292Vi5);
        }
        if (i == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    protected abstract boolean i(EW4 ew4, long j, b bVar);

    protected void l(boolean z) {
        if (z) {
            this.j = new b();
            this.f = 0L;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1L;
        this.g = 0L;
    }

    final void m(long j, long j2) {
        this.a.e();
        if (j == 0) {
            l(!this.l);
        } else if (this.h != 0) {
            this.e = c(j2);
            ((InterfaceC15261jH4) AbstractC9683aN7.j(this.d)).c(this.e);
            this.h = 2;
        }
    }

    private static final class c implements InterfaceC15261jH4 {
        private c() {
        }

        @Override // ir.nasim.InterfaceC15261jH4
        public long a(InterfaceC9845af2 interfaceC9845af2) {
            return -1L;
        }

        @Override // ir.nasim.InterfaceC15261jH4
        public InterfaceC22148uk6 b() {
            return new InterfaceC22148uk6.b(-9223372036854775807L);
        }

        @Override // ir.nasim.InterfaceC15261jH4
        public void c(long j) {
        }
    }
}
