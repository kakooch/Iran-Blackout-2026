package ir.nasim;

/* loaded from: classes8.dex */
final class Y82 {
    private final Object a;
    private final InterfaceC4356Eu b;

    public Y82(Object obj, InterfaceC4356Eu interfaceC4356Eu) {
        this.a = obj;
        this.b = interfaceC4356Eu;
    }

    public final Object a() {
        return this.a;
    }

    public final InterfaceC4356Eu b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Y82)) {
            return false;
        }
        Y82 y82 = (Y82) obj;
        return AbstractC13042fc3.d(this.a, y82.a) && AbstractC13042fc3.d(this.b, y82.b);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        InterfaceC4356Eu interfaceC4356Eu = this.b;
        return iHashCode + (interfaceC4356Eu != null ? interfaceC4356Eu.hashCode() : 0);
    }

    public String toString() {
        return "EnhancementResult(result=" + this.a + ", enhancementAnnotations=" + this.b + ')';
    }
}
