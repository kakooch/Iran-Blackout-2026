package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Jp7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C5504Jp7 {
    private final int a;
    private final String b;
    private final String c;

    public C5504Jp7(int i, String str, String str2) {
        AbstractC13042fc3.i(str2, "startParam");
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public final int a() {
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
        if (!(obj instanceof C5504Jp7)) {
            return false;
        }
        C5504Jp7 c5504Jp7 = (C5504Jp7) obj;
        return this.a == c5504Jp7.a && AbstractC13042fc3.d(this.b, c5504Jp7.b) && AbstractC13042fc3.d(this.c, c5504Jp7.c);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Timche(botId=" + this.a + ", shortName=" + this.b + ", startParam=" + this.c + Separators.RPAREN;
    }
}
