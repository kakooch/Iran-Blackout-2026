package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class OC7 extends AbstractC20556sC7 {
    private final long a;
    private final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OC7(long j, List list) {
        super(null);
        AbstractC13042fc3.i(list, "participants");
        this.a = j;
        this.b = list;
    }

    public final long a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OC7)) {
            return false;
        }
        OC7 oc7 = (OC7) obj;
        return this.a == oc7.a && AbstractC13042fc3.d(this.b, oc7.b);
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateCallReceived(callId=" + this.a + ", participants=" + this.b + Separators.RPAREN;
    }
}
