package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes6.dex */
public final class JN5 implements InterfaceC15283jK {
    private final List a;

    public JN5(List list) {
        AbstractC13042fc3.i(list, "ids");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof JN5) && AbstractC13042fc3.d(this.a, ((JN5) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "RemoveTransactions(ids=" + this.a + Separators.RPAREN;
    }
}
