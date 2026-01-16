package ir.nasim;

/* renamed from: ir.nasim.lq2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16772lq2 implements InterfaceC8586Wp2 {
    private final float a;
    private final float b;
    private final float c;
    private final C18236oJ6 d;

    public C16772lq2(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        C18236oJ6 c18236oJ6 = new C18236oJ6(1.0f);
        c18236oJ6.c(f);
        c18236oJ6.e(f2);
        this.d = c18236oJ6;
    }

    @Override // ir.nasim.InterfaceC8586Wp2
    public float b(float f, float f2, float f3) {
        return 0.0f;
    }

    @Override // ir.nasim.InterfaceC8586Wp2
    public float c(long j, float f, float f2, float f3) {
        this.d.d(f2);
        return Float.intBitsToFloat((int) (this.d.f(f, f3, j / 1000000) >> 32));
    }

    @Override // ir.nasim.InterfaceC8586Wp2
    public float d(long j, float f, float f2, float f3) {
        this.d.d(f2);
        return Float.intBitsToFloat((int) (this.d.f(f, f3, j / 1000000) & 4294967295L));
    }

    @Override // ir.nasim.InterfaceC8586Wp2
    public long e(float f, float f2, float f3) {
        float fB = this.d.b();
        float fA = this.d.a();
        float f4 = f - f2;
        float f5 = this.c;
        return AbstractC17054mJ6.b(fB, fA, f3 / f5, f4 / f5, 1.0f) * 1000000;
    }

    public /* synthetic */ C16772lq2(float f, float f2, float f3, int i, ED1 ed1) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1500.0f : f2, (i & 4) != 0 ? 0.01f : f3);
    }
}
