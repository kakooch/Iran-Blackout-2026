package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class S68 {
    private final String a;
    private final EnumC23552x68 b;
    private final String c;

    public S68(String str, EnumC23552x68 enumC23552x68, String str2) {
        AbstractC13042fc3.i(str, "url");
        AbstractC13042fc3.i(enumC23552x68, "screenMode");
        this.a = str;
        this.b = enumC23552x68;
        this.c = str2;
    }

    public final EnumC23552x68 a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S68)) {
            return false;
        }
        S68 s68 = (S68) obj;
        return AbstractC13042fc3.d(this.a, s68.a) && this.b == s68.b && AbstractC13042fc3.d(this.c, s68.c);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "WebAppUrl(url=" + this.a + ", screenMode=" + this.b + ", webAppQueryId=" + this.c + Separators.RPAREN;
    }
}
