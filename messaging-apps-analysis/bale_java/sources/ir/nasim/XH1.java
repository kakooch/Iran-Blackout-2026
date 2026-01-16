package ir.nasim;

/* loaded from: classes2.dex */
final class XH1 implements WH1 {
    private final float a;
    private final float b;

    public XH1(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XH1)) {
            return false;
        }
        XH1 xh1 = (XH1) obj;
        return Float.compare(this.a, xh1.a) == 0 && Float.compare(this.b, xh1.b) == 0;
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return this.a;
    }

    public int hashCode() {
        return (Float.hashCode(this.a) * 31) + Float.hashCode(this.b);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return this.b;
    }

    public String toString() {
        return "DensityImpl(density=" + this.a + ", fontScale=" + this.b + ')';
    }
}
