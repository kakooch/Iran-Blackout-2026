package ir.nasim;

import ir.nasim.InterfaceC22148uk6;

/* renamed from: ir.nasim.Od1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C6585Od1 implements InterfaceC22148uk6 {
    private final long a;
    private final long b;
    private final int c;
    private final long d;
    private final int e;
    private final long f;
    private final boolean g;

    public C6585Od1(long j, long j2, int i, int i2, boolean z) {
        this.a = j;
        this.b = j2;
        this.c = i2 == -1 ? 1 : i2;
        this.e = i;
        this.g = z;
        if (j == -1) {
            this.d = -1L;
            this.f = -9223372036854775807L;
        } else {
            this.d = j - j2;
            this.f = d(j, j2, i);
        }
    }

    private long a(long j) {
        int i = this.c;
        long jMin = (((j * this.e) / 8000000) / i) * i;
        long j2 = this.d;
        if (j2 != -1) {
            jMin = Math.min(jMin, j2 - i);
        }
        return this.b + Math.max(jMin, 0L);
    }

    private static long d(long j, long j2, int i) {
        return (Math.max(0L, j - j2) * 8000000) / i;
    }

    public long b(long j) {
        return d(j, this.b, this.e);
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public InterfaceC22148uk6.a c(long j) {
        if (this.d == -1 && !this.g) {
            return new InterfaceC22148uk6.a(new C23334wk6(0L, this.b));
        }
        long jA = a(j);
        long jB = b(jA);
        C23334wk6 c23334wk6 = new C23334wk6(jB, jA);
        if (this.d != -1 && jB < j) {
            int i = this.c;
            if (i + jA < this.a) {
                long j2 = jA + i;
                return new InterfaceC22148uk6.a(c23334wk6, new C23334wk6(b(j2), j2));
            }
        }
        return new InterfaceC22148uk6.a(c23334wk6);
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public boolean g() {
        return this.d != -1 || this.g;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public long i() {
        return this.f;
    }
}
