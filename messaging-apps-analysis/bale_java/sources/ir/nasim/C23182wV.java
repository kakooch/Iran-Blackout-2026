package ir.nasim;

/* renamed from: ir.nasim.wV, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C23182wV {
    private long a;
    private long b;

    private final long a(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        long j3 = 4;
        return (j / j3) + ((j2 / j3) * 3);
    }

    public final C23182wV b() {
        C23182wV c23182wV = new C23182wV();
        c23182wV.a = this.a;
        c23182wV.b = this.b;
        return c23182wV;
    }

    public final long c() {
        return this.a;
    }

    public final long d() {
        return this.b;
    }

    public final void e(long j) {
        this.a = a(j, this.a);
    }

    public final void f(long j) {
        this.b = a(j, this.b);
    }
}
