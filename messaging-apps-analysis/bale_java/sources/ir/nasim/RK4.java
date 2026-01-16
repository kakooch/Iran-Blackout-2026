package ir.nasim;

/* loaded from: classes.dex */
public final class RK4 {
    private final String a;

    public RK4(String str) {
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RK4) && AbstractC13042fc3.d(this.a, ((RK4) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "OpaqueKey(key=" + this.a + ')';
    }
}
