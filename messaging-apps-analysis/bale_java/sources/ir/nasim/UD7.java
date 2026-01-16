package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class UD7 extends AbstractC20556sC7 {
    private final int a;
    private final C7714Sx b;

    public UD7(int i, C7714Sx c7714Sx) {
        super(null);
        this.a = i;
        this.b = c7714Sx;
    }

    public final C7714Sx a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UD7)) {
            return false;
        }
        UD7 ud7 = (UD7) obj;
        return this.a == ud7.a && AbstractC13042fc3.d(this.b, ud7.b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        C7714Sx c7714Sx = this.b;
        return iHashCode + (c7714Sx == null ? 0 : c7714Sx.hashCode());
    }

    public String toString() {
        return "UpdateGroupExInfoChanged(groupId=" + this.a + ", exInfo=" + this.b + Separators.RPAREN;
    }
}
