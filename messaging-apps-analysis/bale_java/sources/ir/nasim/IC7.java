package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Map;

/* loaded from: classes5.dex */
public final class IC7 extends AbstractC20556sC7 {
    private final long a;
    private final String b;
    private final Map c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IC7(long j, String str, Map map) {
        super(null);
        AbstractC13042fc3.i(str, "triggererIdentity");
        AbstractC13042fc3.i(map, "extraData");
        this.a = j;
        this.b = str;
        this.c = map;
    }

    public final long a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IC7)) {
            return false;
        }
        IC7 ic7 = (IC7) obj;
        return this.a == ic7.a && AbstractC13042fc3.d(this.b, ic7.b) && AbstractC13042fc3.d(this.c, ic7.c);
    }

    public int hashCode() {
        return (((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "UpdateCallEvent(callId=" + this.a + ", triggererIdentity=" + this.b + ", extraData=" + this.c + Separators.RPAREN;
    }
}
