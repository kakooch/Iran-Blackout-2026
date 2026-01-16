package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class UX4 {
    private final int a;
    private final String b;

    public UX4(int i, String str) {
        AbstractC13042fc3.i(str, "name");
        this.a = i;
        this.b = str;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UX4)) {
            return false;
        }
        UX4 ux4 = (UX4) obj;
        return this.a == ux4.a && AbstractC13042fc3.d(this.b, ux4.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "PassportGroup(id=" + this.a + ", name=" + this.b + Separators.RPAREN;
    }
}
