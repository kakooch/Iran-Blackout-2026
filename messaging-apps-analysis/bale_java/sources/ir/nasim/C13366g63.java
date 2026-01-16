package ir.nasim;

import ir.nasim.InterfaceC22148uk6;

/* renamed from: ir.nasim.g63, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C13366g63 implements InterfaceC24514yk6 {
    private final long a;
    private final YI3 b;
    private final YI3 c;
    private long d;

    public C13366g63(long j, long j2, long j3) {
        this.d = j;
        this.a = j3;
        YI3 yi3 = new YI3();
        this.b = yi3;
        YI3 yi32 = new YI3();
        this.c = yi32;
        yi3.a(0L);
        yi32.a(j2);
    }

    public boolean a(long j) {
        YI3 yi3 = this.b;
        return j - yi3.b(yi3.c() - 1) < 100000;
    }

    public void b(long j, long j2) {
        if (a(j)) {
            return;
        }
        this.b.a(j);
        this.c.a(j2);
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public InterfaceC22148uk6.a c(long j) {
        int iF = AbstractC9683aN7.f(this.b, j, true, true);
        C23334wk6 c23334wk6 = new C23334wk6(this.b.b(iF), this.c.b(iF));
        if (c23334wk6.a == j || iF == this.b.c() - 1) {
            return new InterfaceC22148uk6.a(c23334wk6);
        }
        int i = iF + 1;
        return new InterfaceC22148uk6.a(c23334wk6, new C23334wk6(this.b.b(i), this.c.b(i)));
    }

    void d(long j) {
        this.d = j;
    }

    @Override // ir.nasim.InterfaceC24514yk6
    public long f() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public boolean g() {
        return true;
    }

    @Override // ir.nasim.InterfaceC24514yk6
    public long h(long j) {
        return this.b.b(AbstractC9683aN7.f(this.c, j, true, true));
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public long i() {
        return this.d;
    }
}
