package ir.nasim;

/* loaded from: classes2.dex */
public final class KJ6 implements InterfaceC22009uW3 {
    private final NV0 a;
    private boolean b;
    private long c;
    private long d;
    private com.google.android.exoplayer2.y0 e = com.google.android.exoplayer2.y0.d;

    public KJ6(NV0 nv0) {
        this.a = nv0;
    }

    public void a(long j) {
        this.c = j;
        if (this.b) {
            this.d = this.a.elapsedRealtime();
        }
    }

    public void b() {
        if (this.b) {
            return;
        }
        this.d = this.a.elapsedRealtime();
        this.b = true;
    }

    @Override // ir.nasim.InterfaceC22009uW3
    public com.google.android.exoplayer2.y0 c() {
        return this.e;
    }

    public void d() {
        if (this.b) {
            a(y());
            this.b = false;
        }
    }

    @Override // ir.nasim.InterfaceC22009uW3
    public void e(com.google.android.exoplayer2.y0 y0Var) {
        if (this.b) {
            a(y());
        }
        this.e = y0Var;
    }

    @Override // ir.nasim.InterfaceC22009uW3
    public long y() {
        long j = this.c;
        if (!this.b) {
            return j;
        }
        long jElapsedRealtime = this.a.elapsedRealtime() - this.d;
        com.google.android.exoplayer2.y0 y0Var = this.e;
        return j + (y0Var.a == 1.0f ? AbstractC9683aN7.B0(jElapsedRealtime) : y0Var.c(jElapsedRealtime));
    }
}
