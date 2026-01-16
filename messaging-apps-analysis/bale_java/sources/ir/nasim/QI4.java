package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class QI4 {
    private final List a;
    private final int b;

    public QI4(List list, int i) {
        AbstractC13042fc3.i(list, "list");
        this.a = list;
        this.b = i;
    }

    public final int a() {
        return this.b;
    }

    public final List b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QI4)) {
            return false;
        }
        QI4 qi4 = (QI4) obj;
        return AbstractC13042fc3.d(this.a, qi4.a) && this.b == qi4.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "OnBoardingModelResult(list=" + this.a + ", allContactCount=" + this.b + Separators.RPAREN;
    }
}
