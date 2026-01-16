package ir.nasim;

/* loaded from: classes.dex */
final class ZS extends AbstractC24676z12 {
    private final MM4 a;
    private final MM4 b;

    ZS(MM4 mm4, MM4 mm42) {
        if (mm4 == null) {
            throw new NullPointerException("Null primaryOutConfig");
        }
        this.a = mm4;
        if (mm42 == null) {
            throw new NullPointerException("Null secondaryOutConfig");
        }
        this.b = mm42;
    }

    @Override // ir.nasim.AbstractC24676z12
    public MM4 a() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC24676z12
    public MM4 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC24676z12)) {
            return false;
        }
        AbstractC24676z12 abstractC24676z12 = (AbstractC24676z12) obj;
        return this.a.equals(abstractC24676z12.a()) && this.b.equals(abstractC24676z12.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "DualOutConfig{primaryOutConfig=" + this.a + ", secondaryOutConfig=" + this.b + "}";
    }
}
