package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class U75 {
    private final String a;
    private final String b;
    private final String c;

    public U75(String str, String str2, String str3) {
        AbstractC13042fc3.i(str, "countryCode");
        AbstractC13042fc3.i(str2, "countryName");
        AbstractC13042fc3.i(str3, "phoneNumber");
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof U75)) {
            return false;
        }
        U75 u75 = (U75) obj;
        return AbstractC13042fc3.d(this.a, u75.a) && AbstractC13042fc3.d(this.b, u75.b) && AbstractC13042fc3.d(this.c, u75.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "PhoneData(countryCode=" + this.a + ", countryName=" + this.b + ", phoneNumber=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ U75(String str, String str2, String str3, int i, ED1 ed1) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
