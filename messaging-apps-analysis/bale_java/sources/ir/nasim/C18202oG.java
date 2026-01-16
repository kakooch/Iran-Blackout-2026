package ir.nasim;

/* renamed from: ir.nasim.oG, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18202oG {
    private final Object a;
    private final Object b;

    public C18202oG(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public final Object a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final Object c() {
        return this.a;
    }

    public final Object d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18202oG)) {
            return false;
        }
        C18202oG c18202oG = (C18202oG) obj;
        return AbstractC13042fc3.d(this.a, c18202oG.a) && AbstractC13042fc3.d(this.b, c18202oG.b);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.a + ", upper=" + this.b + ')';
    }
}
