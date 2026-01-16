package ir.nasim;

/* loaded from: classes2.dex */
final class ZH1 implements WH1 {
    private final float a;
    private final float b;
    private final InterfaceC21654tu2 c;

    public ZH1(float f, float f2, InterfaceC21654tu2 interfaceC21654tu2) {
        this.a = f;
        this.b = f2;
        this.c = interfaceC21654tu2;
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public long T(float f) {
        return AbstractC13784go7.f(this.c.a(f));
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float Y(long j) {
        if (C14377ho7.g(C13193fo7.g(j), C14377ho7.b.b())) {
            return C17784nZ1.q(this.c.b(C13193fo7.h(j)));
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZH1)) {
            return false;
        }
        ZH1 zh1 = (ZH1) obj;
        return Float.compare(this.a, zh1.a) == 0 && Float.compare(this.b, zh1.b) == 0 && AbstractC13042fc3.d(this.c, zh1.c);
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return this.a;
    }

    public int hashCode() {
        return (((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return this.b;
    }

    public String toString() {
        return "DensityWithConverter(density=" + this.a + ", fontScale=" + this.b + ", converter=" + this.c + ')';
    }
}
