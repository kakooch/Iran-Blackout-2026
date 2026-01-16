package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.hJ6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14081hJ6 {
    private final String a;
    private final int b;
    private final int c;
    private final String d;
    private final C4626Fy e;
    private final String f;
    private final String g;

    public C14081hJ6(String str, int i, int i2, String str2, C4626Fy c4626Fy, String str3, String str4) {
        AbstractC13042fc3.i(str, "id");
        AbstractC13042fc3.i(str2, "caption");
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = str2;
        this.e = c4626Fy;
        this.f = str3;
        this.g = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14081hJ6)) {
            return false;
        }
        C14081hJ6 c14081hJ6 = (C14081hJ6) obj;
        return AbstractC13042fc3.d(this.a, c14081hJ6.a) && this.b == c14081hJ6.b && this.c == c14081hJ6.c && AbstractC13042fc3.d(this.d, c14081hJ6.d) && AbstractC13042fc3.d(this.e, c14081hJ6.e) && AbstractC13042fc3.d(this.f, c14081hJ6.f) && AbstractC13042fc3.d(this.g, c14081hJ6.g);
    }

    public int hashCode() {
        int iHashCode = ((((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31;
        C4626Fy c4626Fy = this.e;
        int iHashCode2 = (iHashCode + (c4626Fy == null ? 0 : c4626Fy.hashCode())) * 31;
        String str = this.f;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "SponsoredMessageAd(id=" + this.a + ", tag1=" + this.b + ", tag2=" + this.c + ", caption=" + this.d + ", imageLocation=" + this.e + ", link=" + this.f + ", linkTitle=" + this.g + Separators.RPAREN;
    }
}
