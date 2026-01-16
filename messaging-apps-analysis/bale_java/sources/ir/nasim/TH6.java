package ir.nasim;

/* loaded from: classes2.dex */
public final class TH6 {
    private final int a;
    private final int b;
    private final int c;
    private final String d;
    private final int e;

    public TH6(int i, int i2, int i3, String str, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = str;
        this.e = i4;
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final String d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TH6)) {
            return false;
        }
        TH6 th6 = (TH6) obj;
        return this.a == th6.a && this.b == th6.b && this.c == th6.c && AbstractC13042fc3.d(this.d, th6.d) && this.e == th6.e;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31;
        String str = this.d;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "SourceLocation(lineNumber=" + this.a + ", offset=" + this.b + ", length=" + this.c + ", sourceFile=" + this.d + ", packageHash=" + this.e + ')';
    }
}
