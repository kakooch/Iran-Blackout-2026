package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.jJ5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15280jJ5 {
    private final String a;
    private final String b;
    private final int c;

    public C15280jJ5(String str, String str2, int i) {
        AbstractC13042fc3.i(str, "nickName");
        AbstractC13042fc3.i(str2, "memberCount");
        this.a = str;
        this.b = str2;
        this.c = i;
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
        if (!(obj instanceof C15280jJ5)) {
            return false;
        }
        C15280jJ5 c15280jJ5 = (C15280jJ5) obj;
        return AbstractC13042fc3.d(this.a, c15280jJ5.a) && AbstractC13042fc3.d(this.b, c15280jJ5.b) && this.c == c15280jJ5.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "RecommendedData(nickName=" + this.a + ", memberCount=" + this.b + ", index=" + this.c + Separators.RPAREN;
    }
}
