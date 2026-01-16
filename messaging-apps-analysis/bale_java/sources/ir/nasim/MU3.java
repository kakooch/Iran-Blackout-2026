package ir.nasim;

/* loaded from: classes8.dex */
public final class MU3 {
    private final String a;
    private final C24411ya3 b;

    public MU3(String str, C24411ya3 c24411ya3) {
        AbstractC13042fc3.i(str, "value");
        AbstractC13042fc3.i(c24411ya3, "range");
        this.a = str;
        this.b = c24411ya3;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MU3)) {
            return false;
        }
        MU3 mu3 = (MU3) obj;
        return AbstractC13042fc3.d(this.a, mu3.a) && AbstractC13042fc3.d(this.b, mu3.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.b + ')';
    }
}
