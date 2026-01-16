package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.vX4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22609vX4 {
    private final String a;
    private final FX4 b;
    private final String c;
    private final String d;

    public C22609vX4(String str, FX4 fx4, String str2, String str3) {
        AbstractC13042fc3.i(str, "linkId");
        AbstractC13042fc3.i(fx4, "form");
        this.a = str;
        this.b = fx4;
        this.c = str2;
        this.d = str3;
    }

    public final String a() {
        return this.c;
    }

    public final FX4 b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22609vX4)) {
            return false;
        }
        C22609vX4 c22609vX4 = (C22609vX4) obj;
        return AbstractC13042fc3.d(this.a, c22609vX4.a) && AbstractC13042fc3.d(this.b, c22609vX4.b) && AbstractC13042fc3.d(this.c, c22609vX4.c) && AbstractC13042fc3.d(this.d, c22609vX4.d);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Passport(linkId=" + this.a + ", form=" + this.b + ", cancelCallbackUrl=" + this.c + ", successCallbackUrl=" + this.d + Separators.RPAREN;
    }
}
