package ir.nasim;

/* loaded from: classes2.dex */
public final class OE2 {
    private final int a;
    private final AbstractC20754sY7 b;

    public OE2(int i, AbstractC20754sY7 abstractC20754sY7) {
        AbstractC13042fc3.i(abstractC20754sY7, "hint");
        this.a = i;
        this.b = abstractC20754sY7;
    }

    public final int a() {
        return this.a;
    }

    public final AbstractC20754sY7 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OE2)) {
            return false;
        }
        OE2 oe2 = (OE2) obj;
        return this.a == oe2.a && AbstractC13042fc3.d(this.b, oe2.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "GenerationalViewportHint(generationId=" + this.a + ", hint=" + this.b + ')';
    }
}
