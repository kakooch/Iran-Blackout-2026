package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Gf6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4711Gf6 {
    private final String a;
    private final Integer b;

    public C4711Gf6(String str, Integer num) {
        AbstractC13042fc3.i(str, "title");
        this.a = str;
        this.b = num;
    }

    public final Integer a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4711Gf6)) {
            return false;
        }
        C4711Gf6 c4711Gf6 = (C4711Gf6) obj;
        return AbstractC13042fc3.d(this.a, c4711Gf6.a) && AbstractC13042fc3.d(this.b, c4711Gf6.b);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Integer num = this.b;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "SearchCategory(title=" + this.a + ", drawableRes=" + this.b + Separators.RPAREN;
    }
}
