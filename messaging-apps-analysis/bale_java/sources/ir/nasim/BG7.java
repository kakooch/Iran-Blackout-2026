package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class BG7 extends AbstractC20556sC7 {
    private final D18 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BG7(D18 d18) {
        super(null);
        AbstractC13042fc3.i(d18, "newWallet");
        this.a = d18;
    }

    public final D18 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BG7) && AbstractC13042fc3.d(this.a, ((BG7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "UpdateWalletUpdated(newWallet=" + this.a + Separators.RPAREN;
    }
}
