package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class YE7 extends AbstractC20556sC7 {
    private final C11458d25 a;
    private final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YE7(C11458d25 c11458d25, List list) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "messageContainers");
        this.a = c11458d25;
        this.b = list;
    }

    public final List a() {
        return this.b;
    }

    public final C11458d25 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YE7)) {
            return false;
        }
        YE7 ye7 = (YE7) obj;
        return AbstractC13042fc3.d(this.a, ye7.a) && AbstractC13042fc3.d(this.b, ye7.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateMessages(peer=" + this.a + ", messageContainers=" + this.b + Separators.RPAREN;
    }
}
