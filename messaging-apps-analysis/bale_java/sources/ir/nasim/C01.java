package ir.nasim;

/* loaded from: classes8.dex */
public final class C01 {
    public final Object a;
    public final UA2 b;

    public C01(Object obj, UA2 ua2) {
        this.a = obj;
        this.b = ua2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C01)) {
            return false;
        }
        C01 c01 = (C01) obj;
        return AbstractC13042fc3.d(this.a, c01.a) && AbstractC13042fc3.d(this.b, c01.b);
    }

    public int hashCode() {
        Object obj = this.a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.a + ", onCancellation=" + this.b + ')';
    }
}
