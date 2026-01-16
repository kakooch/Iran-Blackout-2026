package ir.nasim;

/* renamed from: ir.nasim.nq2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17954nq2 implements InterfaceC8586Wp2 {
    private final int a;
    private final int b;
    private final K22 c;
    private final long d;
    private final long e;

    public C17954nq2(int i, int i2, K22 k22) {
        this.a = i;
        this.b = i2;
        this.c = k22;
        this.d = i * 1000000;
        this.e = i2 * 1000000;
    }

    @Override // ir.nasim.InterfaceC8586Wp2
    public float c(long j, float f, float f2, float f3) {
        long j2 = j - this.e;
        long j3 = this.d;
        if (j2 < 0) {
            j2 = 0;
        }
        if (j2 > j3) {
            j2 = j3;
        }
        float fA = this.c.a(this.a == 0 ? 1.0f : j2 / j3);
        return (f * (1 - fA)) + (f2 * fA);
    }

    @Override // ir.nasim.InterfaceC8586Wp2
    public float d(long j, float f, float f2, float f3) {
        long j2 = j - this.e;
        long j3 = this.d;
        if (j2 < 0) {
            j2 = 0;
        }
        long j4 = j2 > j3 ? j3 : j2;
        if (j4 == 0) {
            return f3;
        }
        return (c(j4, f, f2, f3) - c(j4 - 1000000, f, f2, f3)) * 1000.0f;
    }

    @Override // ir.nasim.InterfaceC8586Wp2
    public long e(float f, float f2, float f3) {
        return this.e + this.d;
    }
}
