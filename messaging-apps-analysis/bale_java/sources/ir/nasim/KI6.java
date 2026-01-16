package ir.nasim;

/* loaded from: classes.dex */
public final class KI6 implements InterfaceC10575bq2 {
    private final C7884Tp2 a;

    public KI6(WH1 wh1) {
        this.a = new C7884Tp2(LI6.a(), wh1);
    }

    private final float f(float f) {
        return this.a.b(f) * Math.signum(f);
    }

    @Override // ir.nasim.InterfaceC10575bq2
    public float a() {
        return 0.0f;
    }

    @Override // ir.nasim.InterfaceC10575bq2
    public float b(long j, float f, float f2) {
        return this.a.d(f2).b(j / 1000000);
    }

    @Override // ir.nasim.InterfaceC10575bq2
    public long c(float f, float f2) {
        return this.a.c(f2) * 1000000;
    }

    @Override // ir.nasim.InterfaceC10575bq2
    public float d(float f, float f2) {
        return f + f(f2);
    }

    @Override // ir.nasim.InterfaceC10575bq2
    public float e(long j, float f, float f2) {
        return f + this.a.d(f2).a(j / 1000000);
    }
}
