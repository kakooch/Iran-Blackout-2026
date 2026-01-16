package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes6.dex */
public final class LN5 implements InterfaceC15283jK {
    private final List a;

    public LN5(List list) {
        AbstractC13042fc3.i(list, "tags");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LN5) && AbstractC13042fc3.d(this.a, ((LN5) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "RemoveUserTag(tags=" + this.a + Separators.RPAREN;
    }
}
