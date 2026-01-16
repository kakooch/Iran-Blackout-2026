package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.cX1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10977cX1 {
    private final C10361bX1 a;
    private String b;
    private final String c;
    private int d;

    public C10977cX1(C10361bX1 c10361bX1, String str, String str2, int i) {
        AbstractC13042fc3.i(c10361bX1, "fileLocationDomain");
        AbstractC13042fc3.i(str, "fileName");
        this.a = c10361bX1;
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    public final String a() {
        return this.c;
    }

    public final C10361bX1 b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10977cX1)) {
            return false;
        }
        C10977cX1 c10977cX1 = (C10977cX1) obj;
        return AbstractC13042fc3.d(this.a, c10977cX1.a) && AbstractC13042fc3.d(this.b, c10977cX1.b) && AbstractC13042fc3.d(this.c, c10977cX1.c) && this.d == c10977cX1.d;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "DomainFileReference(fileLocationDomain=" + this.a + ", fileName=" + this.b + ", caption=" + this.c + ", fileSize=" + this.d + Separators.RPAREN;
    }
}
