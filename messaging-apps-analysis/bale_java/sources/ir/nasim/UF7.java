package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class UF7 extends AbstractC20556sC7 {
    private final int a;
    private final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UF7(int i, List list) {
        super(null);
        AbstractC13042fc3.i(list, "contactRecords");
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
        if (!(obj instanceof UF7)) {
            return false;
        }
        UF7 uf7 = (UF7) obj;
        return this.a == uf7.a && AbstractC13042fc3.d(this.b, uf7.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateUserContactsChanged(id=" + this.a + ", contactRecords=" + this.b + Separators.RPAREN;
    }
}
