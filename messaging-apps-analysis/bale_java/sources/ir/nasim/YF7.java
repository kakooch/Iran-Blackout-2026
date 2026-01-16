package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class YF7 extends AbstractC20556sC7 {
    private final int a;
    private final String b;

    public YF7(int i, String str) {
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
        if (!(obj instanceof YF7)) {
            return false;
        }
        YF7 yf7 = (YF7) obj;
        return this.a == yf7.a && AbstractC13042fc3.d(this.b, yf7.b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UpdateUserDefaultCardNumberChanged(uid=" + this.a + ", defaultCardNumber=" + this.b + Separators.RPAREN;
    }
}
