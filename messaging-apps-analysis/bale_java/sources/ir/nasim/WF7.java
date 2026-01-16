package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class WF7 extends AbstractC20556sC7 {
    private final int a;
    private final String b;

    public WF7(int i, String str) {
        super(null);
        this.a = i;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WF7)) {
            return false;
        }
        WF7 wf7 = (WF7) obj;
        return this.a == wf7.a && AbstractC13042fc3.d(this.b, wf7.b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UpdateUserDefaultBankAccountChanged(uid=" + this.a + ", defaultBankAccount=" + this.b + Separators.RPAREN;
    }
}
