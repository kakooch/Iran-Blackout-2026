package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.gp1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13788gp1 {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;

    public C13788gp1(String str, String str2, String str3, String str4, String str5) {
        AbstractC13042fc3.i(str, "code");
        AbstractC13042fc3.i(str2, "fullName");
        AbstractC13042fc3.i(str3, "shortName");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.e;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13788gp1)) {
            return false;
        }
        C13788gp1 c13788gp1 = (C13788gp1) obj;
        return AbstractC13042fc3.d(this.a, c13788gp1.a) && AbstractC13042fc3.d(this.b, c13788gp1.b) && AbstractC13042fc3.d(this.c, c13788gp1.c) && AbstractC13042fc3.d(this.d, c13788gp1.d) && AbstractC13042fc3.d(this.e, c13788gp1.e);
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Country(code=" + this.a + ", fullName=" + this.b + ", shortName=" + this.c + ", phoneNumberFormat=" + this.d + ", emoji=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C13788gp1(String str, String str2, String str3, String str4, String str5, int i, ED1 ed1) {
        this(str, str2, str3, str4, (i & 16) != 0 ? null : str5);
    }
}
