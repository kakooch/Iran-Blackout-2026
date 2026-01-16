package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class GD7 extends AbstractC20556sC7 {
    private final String a;
    private final String b;
    private final AbstractC10026ax1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GD7(String str, String str2, AbstractC10026ax1 abstractC10026ax1) {
        super(null);
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        this.a = str;
        this.b = str2;
        this.c = abstractC10026ax1;
    }

    public final AbstractC10026ax1 a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GD7)) {
            return false;
        }
        GD7 gd7 = (GD7) obj;
        return AbstractC13042fc3.d(this.a, gd7.a) && AbstractC13042fc3.d(this.b, gd7.b) && AbstractC13042fc3.d(this.c, gd7.c);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        AbstractC10026ax1 abstractC10026ax1 = this.c;
        return iHashCode + (abstractC10026ax1 == null ? 0 : abstractC10026ax1.hashCode());
    }

    public String toString() {
        return "UpdateGeneralNotificationMessage(title=" + this.a + ", description=" + this.b + ", action=" + this.c + Separators.RPAREN;
    }
}
