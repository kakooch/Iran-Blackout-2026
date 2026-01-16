package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class ME7 extends AbstractC20556sC7 {
    private final C11458d25 a;
    private final long b;
    private final long c;
    private final List d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ME7(C11458d25 c11458d25, long j, long j2, List list) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "reactions");
        this.a = c11458d25;
        this.b = j;
        this.c = j2;
        this.d = list;
    }

    public final long a() {
        return this.c;
    }

    public final C11458d25 b() {
        return this.a;
    }

    public final List c() {
        return this.d;
    }

    public final long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ME7)) {
            return false;
        }
        ME7 me7 = (ME7) obj;
        return AbstractC13042fc3.d(this.a, me7.a) && this.b == me7.b && this.c == me7.c && AbstractC13042fc3.d(this.d, me7.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "UpdateMessageReactions(peer=" + this.a + ", rid=" + this.b + ", date=" + this.c + ", reactions=" + this.d + Separators.RPAREN;
    }
}
