package ir.nasim;

/* renamed from: ir.nasim.Aj7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3324Aj7 {
    private final Object a;
    private final Object b;

    public C3324Aj7(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public final Object a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3324Aj7)) {
            return false;
        }
        C3324Aj7 c3324Aj7 = (C3324Aj7) obj;
        return AbstractC13042fc3.d(this.a, c3324Aj7.a) && AbstractC13042fc3.d(this.b, c3324Aj7.b);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "TargetState(initial=" + this.a + ", target=" + this.b + ')';
    }
}
