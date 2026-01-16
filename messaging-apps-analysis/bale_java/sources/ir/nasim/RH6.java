package ir.nasim;

/* loaded from: classes.dex */
final class RH6 {
    private final Object a;
    private final int b;

    public RH6(Object obj, int i) {
        this.a = obj;
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RH6)) {
            return false;
        }
        RH6 rh6 = (RH6) obj;
        return AbstractC13042fc3.d(this.a, rh6.a) && this.b == rh6.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "SourceInformationSlotTableGroupIdentity(parentIdentity=" + this.a + ", index=" + this.b + ')';
    }
}
