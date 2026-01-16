package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.zG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24829zG7 extends AbstractC20556sC7 {
    private final String a;
    private final SW b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C24829zG7(String str, SW sw) {
        super(null);
        AbstractC13042fc3.i(str, "walletId");
        AbstractC13042fc3.i(sw, "newBalance");
        this.a = str;
        this.b = sw;
    }

    public final SW a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24829zG7)) {
            return false;
        }
        C24829zG7 c24829zG7 = (C24829zG7) obj;
        return AbstractC13042fc3.d(this.a, c24829zG7.a) && AbstractC13042fc3.d(this.b, c24829zG7.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateWalletBalanceUpdated(walletId=" + this.a + ", newBalance=" + this.b + Separators.RPAREN;
    }
}
