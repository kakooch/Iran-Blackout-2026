package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class FE7 extends AbstractC20556sC7 {
    private final C11458d25 a;
    private final List b;
    private final List c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FE7(C11458d25 c11458d25, List list, List list2) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "rids");
        AbstractC13042fc3.i(list2, "dates");
        this.a = c11458d25;
        this.b = list;
        this.c = list2;
    }

    public final List a() {
        return this.c;
    }

    public final C11458d25 b() {
        return this.a;
    }

    public final List c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FE7)) {
            return false;
        }
        FE7 fe7 = (FE7) obj;
        return AbstractC13042fc3.d(this.a, fe7.a) && AbstractC13042fc3.d(this.b, fe7.b) && AbstractC13042fc3.d(this.c, fe7.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "UpdateMessageDelete(peer=" + this.a + ", rids=" + this.b + ", dates=" + this.c + Separators.RPAREN;
    }
}
