package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.pfm.entity.PFMTransactionId;

/* loaded from: classes6.dex */
public final class P8 implements InterfaceC15283jK {
    private final PFMTransactionId a;
    private final String b;

    public P8(PFMTransactionId pFMTransactionId, String str) {
        AbstractC13042fc3.i(pFMTransactionId, "id");
        AbstractC13042fc3.i(str, "detail");
        this.a = pFMTransactionId;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final PFMTransactionId b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof P8)) {
            return false;
        }
        P8 p8 = (P8) obj;
        return AbstractC13042fc3.d(this.a, p8.a) && AbstractC13042fc3.d(this.b, p8.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "AddDetailToTransaction(id=" + this.a + ", detail=" + this.b + Separators.RPAREN;
    }
}
