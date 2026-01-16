package ir.nasim;

import ir.nasim.InterfaceC22148uk6;

/* renamed from: ir.nasim.y48, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C24122y48 implements InterfaceC22148uk6 {
    private final C22942w48 a;
    private final int b;
    private final long c;
    private final long d;
    private final long e;

    public C24122y48(C22942w48 c22942w48, int i, long j, long j2) {
        this.a = c22942w48;
        this.b = i;
        this.c = j;
        long j3 = (j2 - j) / c22942w48.e;
        this.d = j3;
        this.e = a(j3);
    }

    private long a(long j) {
        return AbstractC9683aN7.N0(j * this.b, 1000000L, this.a.c);
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public InterfaceC22148uk6.a c(long j) {
        long jQ = AbstractC9683aN7.q((this.a.c * j) / (this.b * 1000000), 0L, this.d - 1);
        long j2 = this.c + (this.a.e * jQ);
        long jA = a(jQ);
        C23334wk6 c23334wk6 = new C23334wk6(jA, j2);
        if (jA >= j || jQ == this.d - 1) {
            return new InterfaceC22148uk6.a(c23334wk6);
        }
        long j3 = jQ + 1;
        return new InterfaceC22148uk6.a(c23334wk6, new C23334wk6(a(j3), this.c + (this.a.e * j3)));
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public boolean g() {
        return true;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public long i() {
        return this.e;
    }
}
