package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import ir.nasim.InterfaceC22148uk6;
import java.io.EOFException;
import java.io.IOException;

/* renamed from: ir.nasim.vE1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C22435vE1 implements InterfaceC15261jH4 {
    private final C14663iH4 a;
    private final long b;
    private final long c;
    private final YX6 d;
    private int e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;

    /* renamed from: ir.nasim.vE1$b */
    private final class b implements InterfaceC22148uk6 {
        private b() {
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public InterfaceC22148uk6.a c(long j) {
            return new InterfaceC22148uk6.a(new C23334wk6(j, AbstractC9683aN7.q((C22435vE1.this.b + ((C22435vE1.this.d.c(j) * (C22435vE1.this.c - C22435vE1.this.b)) / C22435vE1.this.f)) - 30000, C22435vE1.this.b, C22435vE1.this.c - 1)));
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public boolean g() {
            return true;
        }

        @Override // ir.nasim.InterfaceC22148uk6
        public long i() {
            return C22435vE1.this.d.b(C22435vE1.this.f);
        }
    }

    public C22435vE1(YX6 yx6, long j, long j2, long j3, long j4, boolean z) {
        AbstractC20011rK.a(j >= 0 && j2 > j);
        this.d = yx6;
        this.b = j;
        this.c = j2;
        if (j3 == j2 - j || z) {
            this.f = j4;
            this.e = 4;
        } else {
            this.e = 0;
        }
        this.a = new C14663iH4();
    }

    private long i(InterfaceC9845af2 interfaceC9845af2) throws IOException {
        if (this.i == this.j) {
            return -1L;
        }
        long position = interfaceC9845af2.getPosition();
        if (!this.a.d(interfaceC9845af2, this.j)) {
            long j = this.i;
            if (j != position) {
                return j;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.a.a(interfaceC9845af2, false);
        interfaceC9845af2.e();
        long j2 = this.h;
        C14663iH4 c14663iH4 = this.a;
        long j3 = c14663iH4.c;
        long j4 = j2 - j3;
        int i = c14663iH4.h + c14663iH4.i;
        if (0 <= j4 && j4 < 72000) {
            return -1L;
        }
        if (j4 < 0) {
            this.j = position;
            this.l = j3;
        } else {
            this.i = interfaceC9845af2.getPosition() + i;
            this.k = this.a.c;
        }
        long j5 = this.j;
        long j6 = this.i;
        if (j5 - j6 < 100000) {
            this.j = j6;
            return j6;
        }
        long position2 = interfaceC9845af2.getPosition() - (i * (j4 <= 0 ? 2L : 1L));
        long j7 = this.j;
        long j8 = this.i;
        return AbstractC9683aN7.q(position2 + ((j4 * (j7 - j8)) / (this.l - this.k)), j8, j7 - 1);
    }

    private void k(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        while (true) {
            this.a.c(interfaceC9845af2);
            this.a.a(interfaceC9845af2, false);
            C14663iH4 c14663iH4 = this.a;
            if (c14663iH4.c > this.h) {
                interfaceC9845af2.e();
                return;
            } else {
                interfaceC9845af2.k(c14663iH4.h + c14663iH4.i);
                this.i = interfaceC9845af2.getPosition();
                this.k = this.a.c;
            }
        }
    }

    @Override // ir.nasim.InterfaceC15261jH4
    public long a(InterfaceC9845af2 interfaceC9845af2) throws IOException {
        int i = this.e;
        if (i == 0) {
            long position = interfaceC9845af2.getPosition();
            this.g = position;
            this.e = 1;
            long j = this.c - 65307;
            if (j > position) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long jI = i(interfaceC9845af2);
                if (jI != -1) {
                    return jI;
                }
                this.e = 3;
            } else if (i != 3) {
                if (i == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            k(interfaceC9845af2);
            this.e = 4;
            return -(this.k + 2);
        }
        this.f = j(interfaceC9845af2);
        this.e = 4;
        return this.g;
    }

    @Override // ir.nasim.InterfaceC15261jH4
    public void c(long j) {
        this.h = AbstractC9683aN7.q(j, 0L, this.f - 1);
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }

    @Override // ir.nasim.InterfaceC15261jH4
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public b b() {
        if (this.f != 0) {
            return new b();
        }
        return null;
    }

    long j(InterfaceC9845af2 interfaceC9845af2) throws ParserException, EOFException {
        this.a.b();
        if (!this.a.c(interfaceC9845af2)) {
            throw new EOFException();
        }
        this.a.a(interfaceC9845af2, false);
        C14663iH4 c14663iH4 = this.a;
        interfaceC9845af2.k(c14663iH4.h + c14663iH4.i);
        long j = this.a.c;
        while (true) {
            C14663iH4 c14663iH42 = this.a;
            if ((c14663iH42.b & 4) == 4 || !c14663iH42.c(interfaceC9845af2) || interfaceC9845af2.getPosition() >= this.c || !this.a.a(interfaceC9845af2, true)) {
                break;
            }
            C14663iH4 c14663iH43 = this.a;
            if (!AbstractC11055cf2.e(interfaceC9845af2, c14663iH43.h + c14663iH43.i)) {
                break;
            }
            j = this.a.c;
        }
        return j;
    }
}
