package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class M75 {
    private final long a;
    private final String b;
    private final String c;

    public M75(long j, String str, String str2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "phoneNumber");
        this.a = j;
        this.b = str;
        this.c = str2;
    }

    public final long a() {
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
        if (!(obj instanceof M75)) {
            return false;
        }
        M75 m75 = (M75) obj;
        return this.a == m75.a && AbstractC13042fc3.d(this.b, m75.b) && AbstractC13042fc3.d(this.c, m75.c);
    }

    public int hashCode() {
        return (((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "PhoneBookContactItem(id=" + this.a + ", name=" + this.b + ", phoneNumber=" + this.c + Separators.RPAREN;
    }
}
