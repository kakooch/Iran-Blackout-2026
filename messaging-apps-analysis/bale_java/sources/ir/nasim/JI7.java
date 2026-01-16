package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class JI7 {
    private final AbstractC19428qK7 a;
    private final boolean b;

    public JI7(AbstractC19428qK7 abstractC19428qK7, boolean z) {
        AbstractC13042fc3.i(abstractC19428qK7, "userType");
        this.a = abstractC19428qK7;
        this.b = z;
    }

    public final boolean a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JI7)) {
            return false;
        }
        JI7 ji7 = (JI7) obj;
        return AbstractC13042fc3.d(this.a, ji7.a) && this.b == ji7.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "UserNameTextState(userType=" + this.a + ", isMuted=" + this.b + Separators.RPAREN;
    }
}
