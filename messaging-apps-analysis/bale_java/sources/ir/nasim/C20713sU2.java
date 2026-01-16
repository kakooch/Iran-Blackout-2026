package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.sU2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20713sU2 {
    private final String a;
    private final String b;
    private final List c;

    public C20713sU2(String str, String str2, List list) {
        AbstractC13042fc3.i(str, "host");
        AbstractC13042fc3.i(list, "hashes");
        this.a = str;
        this.b = str2;
        this.c = list;
    }

    public final List a() {
        return this.c;
    }

    public final String b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20713sU2)) {
            return false;
        }
        C20713sU2 c20713sU2 = (C20713sU2) obj;
        return AbstractC13042fc3.d(this.a, c20713sU2.a) && AbstractC13042fc3.d(this.b, c20713sU2.b) && AbstractC13042fc3.d(this.c, c20713sU2.c);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "HashEndpoint(host=" + this.a + ", knownIp=" + this.b + ", hashes=" + this.c + Separators.RPAREN;
    }
}
