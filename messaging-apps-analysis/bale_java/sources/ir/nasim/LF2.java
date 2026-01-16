package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class LF2 {
    private final List a;

    public LF2(List list) {
        AbstractC13042fc3.i(list, "seqStates");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LF2) && AbstractC13042fc3.d(this.a, ((LF2) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "GetDiff(seqStates=" + this.a + Separators.RPAREN;
    }
}
