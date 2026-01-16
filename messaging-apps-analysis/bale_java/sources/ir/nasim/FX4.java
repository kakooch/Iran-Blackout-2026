package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class FX4 {
    private final List a;
    private final String b;

    public FX4(List list, String str) {
        AbstractC13042fc3.i(list, "groups");
        AbstractC13042fc3.i(str, "description");
        this.a = list;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final List b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FX4)) {
            return false;
        }
        FX4 fx4 = (FX4) obj;
        return AbstractC13042fc3.d(this.a, fx4.a) && AbstractC13042fc3.d(this.b, fx4.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "PassportForm(groups=" + this.a + ", description=" + this.b + Separators.RPAREN;
    }
}
