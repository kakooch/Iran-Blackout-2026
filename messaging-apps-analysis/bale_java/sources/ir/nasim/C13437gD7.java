package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.gD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13437gD7 extends AbstractC20556sC7 {
    private final List a;
    private final C19811qz b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13437gD7(List list, C19811qz c19811qz) {
        super(null);
        AbstractC13042fc3.i(list, "uids");
        this.a = list;
        this.b = c19811qz;
    }

    public final C19811qz a() {
        return this.b;
    }

    public final List b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13437gD7)) {
            return false;
        }
        C13437gD7 c13437gD7 = (C13437gD7) obj;
        return AbstractC13042fc3.d(this.a, c13437gD7.a) && AbstractC13042fc3.d(this.b, c13437gD7.b);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        C19811qz c19811qz = this.b;
        return iHashCode + (c19811qz == null ? 0 : c19811qz.hashCode());
    }

    public String toString() {
        return "UpdateContactsAdded(uids=" + this.a + ", phones=" + this.b + Separators.RPAREN;
    }
}
