package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class KI7 {
    private final String a;
    private final AbstractC19428qK7 b;

    public KI7(String str, AbstractC19428qK7 abstractC19428qK7) {
        AbstractC13042fc3.i(str, "userName");
        AbstractC13042fc3.i(abstractC19428qK7, "userType");
        this.a = str;
        this.b = abstractC19428qK7;
    }

    public final String a() {
        return this.a;
    }

    public final AbstractC19428qK7 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KI7)) {
            return false;
        }
        KI7 ki7 = (KI7) obj;
        return AbstractC13042fc3.d(this.a, ki7.a) && AbstractC13042fc3.d(this.b, ki7.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UserNameTextStateFolder(userName=" + this.a + ", userType=" + this.b + Separators.RPAREN;
    }
}
