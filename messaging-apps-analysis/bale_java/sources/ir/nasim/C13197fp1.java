package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.fp1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13197fp1 {
    private String a;
    private final String b;
    private final int c;
    private final String d;
    private final String e;

    public C13197fp1(String str, String str2, int i, String str3, String str4) {
        AbstractC13042fc3.i(str, "phoneCode");
        AbstractC13042fc3.i(str2, "shortName");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
        this.e = str4;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13197fp1)) {
            return false;
        }
        C13197fp1 c13197fp1 = (C13197fp1) obj;
        return AbstractC13042fc3.d(this.a, c13197fp1.a) && AbstractC13042fc3.d(this.b, c13197fp1.b) && this.c == c13197fp1.c && AbstractC13042fc3.d(this.d, c13197fp1.d) && AbstractC13042fc3.d(this.e, c13197fp1.e);
    }

    public final String f() {
        return this.e;
    }

    public final String g() {
        return this.a;
    }

    public final String h() {
        return this.b;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31;
        String str = this.d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void i(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.a = str;
    }

    public String toString() {
        return "Country(phoneCode=" + this.a + ", shortName=" + this.b + ", fullNameRes=" + this.c + ", emoji=" + this.d + ", persianName=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C13197fp1(String str, String str2, int i, String str3, String str4, int i2, ED1 ed1) {
        this(str, str2, i, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4);
    }
}
