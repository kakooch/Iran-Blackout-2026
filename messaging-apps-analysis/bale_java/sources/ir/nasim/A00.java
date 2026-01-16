package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class A00 {
    private final Integer a;
    private final Integer b;

    public A00(Integer num, Integer num2) {
        this.a = num;
        this.b = num2;
    }

    public final Integer a() {
        return this.a;
    }

    public final Integer b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof A00)) {
            return false;
        }
        A00 a00 = (A00) obj;
        return AbstractC13042fc3.d(this.a, a00.a) && AbstractC13042fc3.d(this.b, a00.b);
    }

    public int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        return iHashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "BaleListSwitchPreviewParams(descriptionRes=" + this.a + ", iconRes=" + this.b + Separators.RPAREN;
    }
}
