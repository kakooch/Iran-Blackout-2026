package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class SD7 extends AbstractC20556sC7 {
    private final C25238zy a;
    private final DA b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SD7(C25238zy c25238zy, DA da) {
        super(null);
        AbstractC13042fc3.i(c25238zy, "group");
        AbstractC13042fc3.i(da, "permissions");
        this.a = c25238zy;
        this.b = da;
    }

    public final C25238zy a() {
        return this.a;
    }

    public final DA b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SD7)) {
            return false;
        }
        SD7 sd7 = (SD7) obj;
        return AbstractC13042fc3.d(this.a, sd7.a) && AbstractC13042fc3.d(this.b, sd7.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateGroupDefaultPermissionsChanged(group=" + this.a + ", permissions=" + this.b + Separators.RPAREN;
    }
}
