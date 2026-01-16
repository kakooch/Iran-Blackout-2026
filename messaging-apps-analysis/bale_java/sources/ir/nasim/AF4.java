package ir.nasim;

/* loaded from: classes8.dex */
public final class AF4 {
    private final String a;
    private final int b;

    public AF4(String str, int i) {
        AbstractC13042fc3.i(str, "number");
        this.a = str;
        this.b = i;
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AF4)) {
            return false;
        }
        AF4 af4 = (AF4) obj;
        return AbstractC13042fc3.d(this.a, af4.a) && this.b == af4.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public String toString() {
        return "NumberWithRadix(number=" + this.a + ", radix=" + this.b + ')';
    }
}
