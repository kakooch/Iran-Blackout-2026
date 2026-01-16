package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Dj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4026Dj2 {
    private final String a;
    private final String b;

    public C4026Dj2(String str, String str2) {
        AbstractC13042fc3.i(str, "fa");
        AbstractC13042fc3.i(str2, "en");
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4026Dj2)) {
            return false;
        }
        C4026Dj2 c4026Dj2 = (C4026Dj2) obj;
        return AbstractC13042fc3.d(this.a, c4026Dj2.a) && AbstractC13042fc3.d(this.b, c4026Dj2.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FeedTag(fa=" + this.a + ", en=" + this.b + Separators.RPAREN;
    }
}
