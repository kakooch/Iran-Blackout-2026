package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.features.pfm.entity.PFMTransactionId;
import java.util.List;

/* renamed from: ir.nasim.yu6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24614yu6 implements InterfaceC15283jK {
    private final List a;
    private final PFMTransactionId b;

    public C24614yu6(List list, PFMTransactionId pFMTransactionId) {
        AbstractC13042fc3.i(list, "tags");
        AbstractC13042fc3.i(pFMTransactionId, "transactionId");
        this.a = list;
        this.b = pFMTransactionId;
    }

    public final List a() {
        return this.a;
    }

    public final PFMTransactionId b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24614yu6)) {
            return false;
        }
        C24614yu6 c24614yu6 = (C24614yu6) obj;
        return AbstractC13042fc3.d(this.a, c24614yu6.a) && AbstractC13042fc3.d(this.b, c24614yu6.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SetTransactionTag(tags=" + this.a + ", transactionId=" + this.b + Separators.RPAREN;
    }
}
