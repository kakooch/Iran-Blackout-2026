package ir.nasim;

/* renamed from: ir.nasim.iT4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C14780iT4 implements InterfaceC8539Wk0 {
    private final GT4 b;
    private final InterfaceC8539Wk0 c;

    public C14780iT4(GT4 gt4, InterfaceC8539Wk0 interfaceC8539Wk0) {
        this.b = gt4;
        this.c = interfaceC8539Wk0;
    }

    private final float b(float f) {
        float fZ = this.b.z() * (-1);
        while (f > 0.0f && fZ < f) {
            fZ += this.b.J();
        }
        while (f < 0.0f && fZ > f) {
            fZ -= this.b.J();
        }
        return fZ;
    }

    @Override // ir.nasim.InterfaceC8539Wk0
    public float a(float f, float f2, float f3) {
        float fA = this.c.a(f, f2, f3);
        boolean z = false;
        if (f <= 0.0f ? f + f2 <= 0.0f : f + f2 > f3) {
            z = true;
        }
        if (Math.abs(fA) != 0.0f && z) {
            return b(fA);
        }
        if (Math.abs(this.b.z()) < 1.0E-6d) {
            return 0.0f;
        }
        float fZ = this.b.z() * (-1.0f);
        if (this.b.B()) {
            fZ += this.b.J();
        }
        return AbstractC23053wG5.l(fZ, -f3, f3);
    }
}
