package ir.nasim;

/* loaded from: classes.dex */
final class O93 implements TS4 {
    private final A98 a;
    private final WH1 b;

    public O93(A98 a98, WH1 wh1) {
        this.a = a98;
        this.b = wh1;
    }

    @Override // ir.nasim.TS4
    public float a() {
        WH1 wh1 = this.b;
        return wh1.D(this.a.c(wh1));
    }

    @Override // ir.nasim.TS4
    public float b(EnumC12613eu3 enumC12613eu3) {
        WH1 wh1 = this.b;
        return wh1.D(this.a.d(wh1, enumC12613eu3));
    }

    @Override // ir.nasim.TS4
    public float c() {
        WH1 wh1 = this.b;
        return wh1.D(this.a.a(wh1));
    }

    @Override // ir.nasim.TS4
    public float d(EnumC12613eu3 enumC12613eu3) {
        WH1 wh1 = this.b;
        return wh1.D(this.a.b(wh1, enumC12613eu3));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof O93)) {
            return false;
        }
        O93 o93 = (O93) obj;
        return AbstractC13042fc3.d(this.a, o93.a) && AbstractC13042fc3.d(this.b, o93.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "InsetsPaddingValues(insets=" + this.a + ", density=" + this.b + ')';
    }
}
