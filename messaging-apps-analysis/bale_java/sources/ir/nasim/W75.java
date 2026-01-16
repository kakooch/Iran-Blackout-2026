package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class W75 {
    private final String a;
    private final String b;
    private final String c;
    private final String d;

    public W75(String str, String str2, String str3, String str4) {
        AbstractC13042fc3.i(str, "countryCode");
        AbstractC13042fc3.i(str2, "countryName");
        AbstractC13042fc3.i(str3, "phoneNumber");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public static /* synthetic */ W75 b(W75 w75, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = w75.a;
        }
        if ((i & 2) != 0) {
            str2 = w75.b;
        }
        if ((i & 4) != 0) {
            str3 = w75.c;
        }
        if ((i & 8) != 0) {
            str4 = w75.d;
        }
        return w75.a(str, str2, str3, str4);
    }

    public final W75 a(String str, String str2, String str3, String str4) {
        AbstractC13042fc3.i(str, "countryCode");
        AbstractC13042fc3.i(str2, "countryName");
        AbstractC13042fc3.i(str3, "phoneNumber");
        return new W75(str, str2, str3, str4);
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof W75)) {
            return false;
        }
        W75 w75 = (W75) obj;
        return AbstractC13042fc3.d(this.a, w75.a) && AbstractC13042fc3.d(this.b, w75.b) && AbstractC13042fc3.d(this.c, w75.c) && AbstractC13042fc3.d(this.d, w75.d);
    }

    public final String f() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PhoneData(countryCode=" + this.a + ", countryName=" + this.b + ", phoneNumber=" + this.c + ", emoji=" + this.d + Separators.RPAREN;
    }

    public /* synthetic */ W75(String str, String str2, String str3, String str4, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC12152e76.b("98") : str, (i & 2) != 0 ? "Iran" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "🇮🇷" : str4);
    }
}
