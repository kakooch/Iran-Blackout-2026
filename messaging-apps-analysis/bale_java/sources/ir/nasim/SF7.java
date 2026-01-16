package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class SF7 extends AbstractC20556sC7 {
    private final int a;
    private final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SF7(int i, List list) {
        super(null);
        AbstractC13042fc3.i(list, "commands");
        this.a = i;
        this.b = list;
    }

    public final List a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SF7)) {
            return false;
        }
        SF7 sf7 = (SF7) obj;
        return this.a == sf7.a && AbstractC13042fc3.d(this.b, sf7.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateUserBotCommandsChanged(uid=" + this.a + ", commands=" + this.b + Separators.RPAREN;
    }
}
