package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.f25, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12692f25 {
    private final String a;
    private final String b;
    private final int c;
    private final int d;
    private final C14733iO2 e;

    public C12692f25(String str, String str2, int i, int i2, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "nick");
        AbstractC13042fc3.i(c14733iO2, "groupVM");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
        this.e = c14733iO2;
    }

    public final C14733iO2 a() {
        return this.e;
    }

    public final int b() {
        return this.d;
    }

    public final int c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12692f25)) {
            return false;
        }
        C12692f25 c12692f25 = (C12692f25) obj;
        return AbstractC13042fc3.d(this.a, c12692f25.a) && AbstractC13042fc3.d(this.b, c12692f25.b) && this.c == c12692f25.c && this.d == c12692f25.d && AbstractC13042fc3.d(this.e, c12692f25.e);
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "Peer(title=" + this.a + ", nick=" + this.b + ", memberCount=" + this.c + ", id=" + this.d + ", groupVM=" + this.e + Separators.RPAREN;
    }
}
