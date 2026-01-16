package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class I3 {
    private final SA2 a;
    private final SA2 b;
    private final SA2 c;
    private final SA2 d;
    private final SA2 e;

    public I3(SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25) {
        AbstractC13042fc3.i(sa2, "navigateToEditName");
        AbstractC13042fc3.i(sa22, "navigateToEditUserId");
        AbstractC13042fc3.i(sa23, "navigateToEditAbout");
        AbstractC13042fc3.i(sa24, "navigateToEditPhoneNumber");
        AbstractC13042fc3.i(sa25, "navigateToPassportPage");
        this.a = sa2;
        this.b = sa22;
        this.c = sa23;
        this.d = sa24;
        this.e = sa25;
    }

    public final SA2 a() {
        return this.c;
    }

    public final SA2 b() {
        return this.a;
    }

    public final SA2 c() {
        return this.d;
    }

    public final SA2 d() {
        return this.b;
    }

    public final SA2 e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I3)) {
            return false;
        }
        I3 i3 = (I3) obj;
        return AbstractC13042fc3.d(this.a, i3.a) && AbstractC13042fc3.d(this.b, i3.b) && AbstractC13042fc3.d(this.c, i3.c) && AbstractC13042fc3.d(this.d, i3.d) && AbstractC13042fc3.d(this.e, i3.e);
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "AccountInfoNavigationCallback(navigateToEditName=" + this.a + ", navigateToEditUserId=" + this.b + ", navigateToEditAbout=" + this.c + ", navigateToEditPhoneNumber=" + this.d + ", navigateToPassportPage=" + this.e + Separators.RPAREN;
    }
}
